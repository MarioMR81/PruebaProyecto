package controller;

import model.HojaCalculoModel;
import vista.HojaCalculoView;

import java.util.Hashtable;

public class HojaCalculoController {
    private HojaCalculoModel model;
    private HojaCalculoView view;

    public HojaCalculoController(HojaCalculoModel model, HojaCalculoView view) {
        this.model = model;
        this.view = view;
        // Asignar eventos a los botones y otros componentes de la interfaz gráfica
    }

    public void setValue(int row, int col, String value) {
        model.setValue(row, col, value);
    }
    public String getValue(int row, int col) {
        return model.getValue(row, col);
    }

    public void calcularSuma() {
        model.calcularSuma();
    }

    public void calcularMultiplicacion() {
        model.calcularMultiplicacion();
    }

    public void generarTablaHash() {
        model.generarTablaHash();
    }

    public void mostrarTabla() {
        String[][] data = obtenerDatosTabla();
        view.mostrarTabla(data);
    }


    public void mostrarMensaje(String mensaje) {
        view.mostrarMensaje(mensaje);
    }

    public void mostrarTablaHash() {
        Hashtable<Integer, String> hashTable = model.getHashTable();
        view.mostrarTablaHash(hashTable);
    }

    // Métodos privados del controlador para obtener los datos de la tabla
    private String[][] obtenerDatosTabla() {
        // Lógica para obtener los datos de la hoja de cálculo en formato de matriz
        return null;
    }

    // Métodos para manejar eventos de la interfaz gráfica
    private void onCalcularSumaButtonClicked() {
        calcularSuma();
        mostrarTabla();
    }

    private void onCalcularMultiplicacionButtonClicked() {
        calcularMultiplicacion();
        mostrarTabla();
    }

    private void onGenerarTablaHashButtonClicked() {
        generarTablaHash();
        mostrarTablaHash();
    }
}