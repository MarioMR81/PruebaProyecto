package com.proyecto;

import controller.HojaCalculoController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.HojaCalculoModel;
import vista.HojaCalculoView;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        HojaCalculoModel model = new HojaCalculoModel(10, 10);
        HojaCalculoView view = new HojaCalculoView(primaryStage);
        HojaCalculoController controller = new HojaCalculoController(model, view);

        // Obtener los datos de la hoja de cálculo desde el modelo
        String[][] data = obtenerDatosHojaCalculo(model);

        // Mostrar los datos en la vista
        view.mostrarTabla(data);

        primaryStage.setTitle("Hoja de Cálculo");
        primaryStage.show();
    }

    private String[][] obtenerDatosHojaCalculo(HojaCalculoModel model) {
        int rows = model.getNumeroFilas();
        int cols = model.getNumeroColumnas();
        String[][] data = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                data[row][col] = model.getValue(row, col);
            }
        }

        return data;
    }
}