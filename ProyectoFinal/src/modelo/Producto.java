/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author picar
 */
public class Producto {
    private static int codigo;
    private int codigoProducto;
    private String nombre;
    private double precio;
    private String departamento;
    
    public Producto(String n, double p, String departamento ){
        Producto.codigo= Producto.codigo+1; 
        codigoProducto = Producto.codigo;
        this.nombre =n;
        this.precio = p;
        this.departamento= departamento;
    }

   
    public int getCodigo() {
        return codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDepartamento() {
        return departamento;
    }
}
