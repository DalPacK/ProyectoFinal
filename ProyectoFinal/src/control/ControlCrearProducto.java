/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import view.CrearProducto;


/**
 *
 * @author picar
 */
public class ControlCrearProducto implements ActionListener{
    private CrearProducto crearProducto;
    
    public ControlCrearProducto(CrearProducto cp){
        crearProducto = cp;
        
        crearProducto.setResizable(false);
        crearProducto.getCancelar().addActionListener(this);
        crearProducto.getCrear().addActionListener(this);
        
        crearProducto.getNombre().addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER== e.getKeyCode()){
                    crearProducto.getPrecio().requestFocus();
                }
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                
            }
       
            
    });
        crearProducto.getPrecio().addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER== e.getKeyCode()){
                    crearProducto.getCategoria().requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
            
        });
    }

    public CrearProducto getVentana() {
        return crearProducto;
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {
        if(crearProducto.getCancelar()== e.getSource()){
            crearProducto.dispose();
        }
    }
    
}
