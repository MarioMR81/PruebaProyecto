package model;

import java.util.Hashtable;

public class HojaCalculoModel {
    private int rows;
    private int cols;
    private String[][] data;
    private Hashtable<Integer, String> hashTable;

    public HojaCalculoModel(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new String[rows][cols];
        this.hashTable = new Hashtable<>();
    }

    public void setValue(int row, int col, String value) {
        data[row][col] = value;
    }

    public String getValue(int row, int col) {
        return data[row][col];
    }

    public void calcularSuma() {
        // Lógica para calcular la suma de las celdas
    }

    public void calcularMultiplicacion() {
        // Lógica para calcular la multiplicación de las celdas
    }

    public void generarTablaHash() {
        // Lógica para generar la tabla hash a partir de los datos de la columna A
    }

    public Hashtable<Integer, String> getHashTable() {
        return hashTable;
    }

    public int getNumeroFilas() {
        return rows;
    }

    public int getNumeroColumnas() {
        return cols;
    }
}
