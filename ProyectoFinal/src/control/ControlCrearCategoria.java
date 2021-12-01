/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CrearCategoria;

/**
 *
 * @author picar
 */
public class ControlCrearCategoria implements ActionListener {
    private CrearCategoria crearCategoria;

    public ControlCrearCategoria(CrearCategoria cc) {
        crearCategoria= cc;
        
        crearCategoria.getNombre().addActionListener(this);
        crearCategoria.getCrear().addActionListener(this);
        crearCategoria.getCancelar().addActionListener(this);
        
    }
    
    public CrearCategoria getVentana(){
        return crearCategoria;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(crearCategoria.getCancelar()== e.getSource()){
            crearCategoria.dispose();
        }
    }
    
}
