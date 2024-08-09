package modelo;

import java.sql.*;
import java.util.UUID;

public class Menu {
    
    //1- Parametros
    String UUID_Menu;
    String nombre;
    double precio;
    String ingredientes;
    
    //2- Getters y Setters

    public String getUUID_Menu() {
        return UUID_Menu;
    }

    public void setUUID_Menu(String UUID_Menu) {
        this.UUID_Menu = UUID_Menu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    //3- Métodos (select, insert, update, delete)
    
    //Ingresar menu
    
    public void Guardar() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addMenu = conexion.prepareStatement("INSERT INTO tbMenu(UUID_Menu, nombre, precio, ingredientes) VALUES (?, ?, ?, ?)");
            //Establecer valores de la consulta SQL
            addMenu.setString(1, UUID.randomUUID().toString());
            addMenu.setString(2, getNombre());
            addMenu.setDouble(3, getPrecio());
            addMenu.setString(4, getIngredientes());
 
            //Ejecutar la consulta
            addMenu.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }
    
}
