/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Producto;
import view.*;

/**
 *
 * @author picar
 */
public class ControlBuscarProducto implements ActionListener{
    private BuscarProducto buscarProducto;
    private ControlPrincipal principal;
    public ControlBuscarProducto(BuscarProducto buscar){
        this.buscarProducto= buscar;
        this.buscarProducto.getBuscar().addActionListener(this);
        this.buscarProducto.getCancelar().addActionListener(this);
    }

    public void setPrincipal(ControlPrincipal principal) {
        this.principal = principal;
    }

    public BuscarProducto getBuscarProducto() {
        return buscarProducto;
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(buscarProducto.getBuscar()==e.getSource()){
          String nombre = this.buscarProducto.getNombre().getText();
          float precio = 0;
          try{
             precio = Float.parseFloat(this.buscarProducto.getCodigo().getText());
             String categoria = this.buscarProducto.getProducto().getToolTipText();
             principal.getLista().add(new Producto(nombre, precio, categoria));
             principal.actualizarTabla();
             buscarProducto.dispose();
          }catch(NumberFormatException ex){
              this.buscarProducto.getCodigo().setText("Invalido");
              this.buscarProducto.getCodigo().select(0, 8);
              this.buscarProducto.getCodigo().requestFocus();
          }
         
          
          
        }
        if(buscarProducto.getCancelar()==e.getSource()){
            buscarProducto.dispose();
        } 
    }
    
}
