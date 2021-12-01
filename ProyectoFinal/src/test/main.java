/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import view.*;
import control.*;
import java.util.ArrayList;
import modelo.*;
/**
 *
 * @author picar
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      ControlLook l = new ControlLook();
      ArrayList<Producto> lista;
      lista = new ArrayList();
      
      
      MenuPrincipal p = new MenuPrincipal();
      CrearCategoria crearCategoria = new CrearCategoria();
      CrearProducto crearProducto = new CrearProducto();
      BuscarProducto buscarProducto = new BuscarProducto();
      
      
      ControlCrearCategoria ccc = new ControlCrearCategoria(crearCategoria);
      ControlCrearProducto ccp = new ControlCrearProducto(crearProducto);
      ControlBuscarProducto cbp = new ControlBuscarProducto(buscarProducto);
      ControlPrincipal menuPrincipal = new ControlPrincipal(p, ccc, ccp, cbp ,lista);
      cbp.setPrincipal(menuPrincipal);
      
      
      p.setVisible(true);
       

        
    }
    
}
