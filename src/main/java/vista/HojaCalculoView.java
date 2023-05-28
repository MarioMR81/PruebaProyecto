package vista;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HojaCalculoView {
    private Stage stage;
    private TableView<String[]> tableView;
    private Button calcularSumaButton;
    private Button calcularMultiplicacionButton;
    private Button generarTablaHashButton;

    public HojaCalculoView(Stage stage) {
        this.stage = stage;
        // Inicializar la interfaz gráfica con los componentes necesarios
        tableView = new TableView<>();
        calcularSumaButton = new Button("Calcular Suma");
        calcularMultiplicacionButton = new Button("Calcular Multiplicación");
        generarTablaHashButton = new Button("Generar Tabla Hash");

        VBox root = new VBox(tableView, calcularSumaButton, calcularMultiplicacionButton, generarTablaHashButton);
        stage.setScene(new Scene(root, 800, 600));
    }

    public void mostrarTabla(String[][] data) {
        tableView.getColumns().clear();
        tableView.getItems().clear();

        // Crear columnas en función del número de columnas en los datos
        for (int col = 0; col < data[0].length; col++) {
            TableColumn<String[], String> column = new TableColumn<>("Columna " + (col + 1));
            final int columnIndex = col;
            column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[columnIndex]));
            tableView.getColumns().add(column);
        }

        // Agregar filas a la tabla
        tableView.getItems().addAll(Arrays.asList(data));
    }

    public String obtenerValorSeleccionado() {
        String[] selectedItem = tableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            return selectedItem[0]; // Suponiendo que solo queremos el valor de la primera columna
        }
        return null;
    }

    public void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mensaje");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void mostrarTablaHash(Hashtable<Integer, String> hashTable) {
        tableView.getColumns().clear();
        tableView.getItems().clear();

        TableColumn<String[], String> indexColumn = new TableColumn<>("Índice");
        indexColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[0]));
        TableColumn<String[], String> valueColumn = new TableColumn<>("Valor");
        valueColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[1]));

        tableView.getColumns().addAll(indexColumn, valueColumn);

        // Agregar filas a la tabla a partir de la tabla hash
        for (Map.Entry<Integer, String> entry : hashTable.entrySet()) {
            String[] row = new String[2];
            row[0] = entry.getKey().toString();
            row[1] = entry.getValue();
            tableView.getItems().add(row);
        }
    }
}
