package U3_4;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class n implements Initializable {

    private ArrayList<AAAACliente> clientes;

    private ArrayList<AAAAVentaProductoCosto> ventaProductoCostos;

    private ObservableList<AAAAVentaElementos> ventaElementos;

    private double calcularTotal() {
        double total = 0;

        for(AAAAVentaElementos v : ventaElementos) {
            total = total + v.getCostoTotal();
        }
        return total;
    }


    @FXML
    private AnchorPane contenedor;

    @FXML
    private JFXTextField producto;

    @FXML
    private JFXListView<String> listaProductos;

    @FXML
    private JFXTextField cantidad;

    @FXML
    private TableView<AAAAVentaElementos> tabla;

    @FXML
    private Label granTotal;

    @FXML
    private JFXComboBox<String> cliente;

    @FXML
    void AgregarProducto(ActionEvent event) {
        int indiceLista = listaProductos.
                getSelectionModel().getSelectedIndex();
        if( indiceLista < 0)
            return;

        int cantidadProductoExistente = ventaProductoCostos.
                get(indiceLista).getCantidad();

        int cantidadProducto = Integer.valueOf(
                cantidad.getText().isEmpty()?"1":cantidad.getText()
        );

        if(cantidadProducto>cantidadProductoExistente)
            return;

        int idProducto = ventaProductoCostos.
                get(indiceLista).getIdProducto();
        int idExistencia = ventaProductoCostos.
                get(indiceLista).getIdExistencias();
        String nombreProducto = ventaProductoCostos.
                get(indiceLista).getNombre();
        double costoUnitario = ventaProductoCostos.
                get(indiceLista).getCosto();

        ventaElementos.add(new AAAAVentaElementos(
                        idProducto,
                        idExistencia,
                        cantidadProducto,
                costoUnitario,
                nombreProducto));

        granTotal.setText(String.valueOf(calcularTotal()));
    }

    @FXML
    void Cancelar(ActionEvent event) {
        Pane p = (Pane)contenedor.getParent();
        p.getChildren().remove(0);


    }

    @FXML
    void Guardar(ActionEvent event) throws SQLException {
        if( ventaElementos.size()==0)
            return;
        int idClienteCombo = cliente.getSelectionModel().getSelectedIndex();
        int idCliente = clientes.get(idClienteCombo).getIdCliente();
        double total = calcularTotal();

        Connection connection = DriverManager.
                getConnection("jdbc:sqlite:pventa.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "INSERT INTO ventas(idCliente, fecha, total) " +
                "VALUES ("+idCliente+", date('now'), "+total+")";

        statement.execute(sql);

        sql = "SELECT  last_insert_rowid()";

        ResultSet resultSet = statement.executeQuery(sql);
        int idVenta=-1;
        if(resultSet.next()) {
            idVenta = resultSet.getInt(1);
        }

        for(AAAAVentaElementos v: ventaElementos) {
            sql = "INSERT INTO VentasDetalle (idVenta, idProducto, costo) " +
                    "VALUES ("+
                    idVenta+", "+
                    v.getIdProductos()+", "+
                    v.getCostoTotal()+")";
            statement.execute(sql);
        }
        ventaElementos.clear();
        granTotal.setText(String.valueOf(calcularTotal()));

    }

    @FXML
    void Quitar(ActionEvent event) {
        int indice = tabla.getSelectionModel().getSelectedIndex();
        if( indice<0 )
            return;

        ventaElementos.remove(indice);

        granTotal.setText(String.valueOf(calcularTotal()));


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:pventa.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(60);

            String sql = "SELECT * FROM clientes";
            ResultSet resultSet = statement.executeQuery(sql);

            clientes = new ArrayList<AAAACliente>();
            cliente.getItems().clear();

            while(resultSet.next()) {
                cliente.getItems().add(resultSet.getString("nombre"));
                clientes.add(new AAAACliente(
                        resultSet.getInt("idCliente"),
                        resultSet.getString("nombre"),
                        resultSet.getString("rfc"),
                        resultSet.getString("calle"),
                        resultSet.getString("colonia"),
                        resultSet.getString("ciudad"),
                        resultSet.getString("pais"),
                        resultSet.getString("telefono"),
                        resultSet.getString("celular"),
                        resultSet.getString("email")
                ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        producto.setOnKeyTyped(e-> {
            String patron = producto.getText();
            if( patron.length()<3 )
                return;


            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:pventa.db");
                Statement statement = connection.createStatement();

                String sql = "SELECT * FROM productos, existencias " +
                        "WHERE productos.idProducto=existencias.idProducto " +
                        "AND nombre LIKE '%" + patron + "%' " +
                        "AND cantidad > 0";

                ResultSet resultSet = statement.executeQuery(sql);
                ventaProductoCostos = new ArrayList<AAAAVentaProductoCosto>();
                listaProductos.getItems().clear();
                while(resultSet.next()) {
                    listaProductos.getItems().add(
                            resultSet.getString("nombre"));

                    ventaProductoCostos.add(new AAAAVentaProductoCosto(
                            resultSet.getInt("idProducto"),
                            resultSet.getInt("idExistencias"),
                            resultSet.getInt("cantidad"),
                            resultSet.getDouble("costo"),
                            resultSet.getString("nombre"),
                            resultSet.getString("descripcion")
                    ));

                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }


        });

        TableColumn<AAAAVentaElementos, String> columnaCantidad = new TableColumn<>("Cantidad.");
        columnaCantidad.setMinWidth(10);
        columnaCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        TableColumn<AAAAVentaElementos, String> columnaNombre = new TableColumn<>("Nombre Producto");
        columnaNombre.setMinWidth(250);
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<AAAAVentaElementos, String> columnaCostoU = new TableColumn<>("Costo Unitario");
        columnaCostoU.setMinWidth(10);
        columnaCostoU.setCellValueFactory(new PropertyValueFactory<>("costoU"));

        TableColumn<AAAAVentaElementos, String> columnaCostoT = new TableColumn<>("Costo Total");
        columnaCostoT.setMinWidth(10);
        columnaCostoT.setCellValueFactory(new PropertyValueFactory<>("costoT"));

        tabla.getColumns().clear();
        tabla.getColumns().addAll(columnaCantidad, columnaNombre, columnaCostoU, columnaCostoT);


        ventaElementos = FXCollections.observableArrayList();
        tabla.setItems(ventaElementos);



    }
}