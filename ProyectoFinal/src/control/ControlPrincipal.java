/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;
import control.*;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import modelo.Producto;


/**
 *
 * @author picar
 */
public class ControlPrincipal implements ActionListener{
     private MenuPrincipal principal;
     private ControlCrearCategoria ccc;
     private ControlCrearProducto ccp;
     private ArrayList<Producto> lista;
     private ArrayList<JSpinner> contadores; 
     private ControlBuscarProducto cbp;
     private ContainerListener flechas;
     Dimension pantalla= Toolkit.getDefaultToolkit().getScreenSize();
    public ControlPrincipal(MenuPrincipal menuPrincipal, ControlCrearCategoria ccc, ControlCrearProducto ccp,ControlBuscarProducto cbp,ArrayList<Producto> lista){
        this.contadores = new ArrayList();
        //DeclararPartes
        principal= menuPrincipal;
        this.ccc= ccc;
        this.ccp= ccp;
        this.lista= lista;
        this.cbp= cbp;
        principal.getAgregar().addActionListener(this);
        principal.getCrearCategoria().addActionListener(this);
        principal.getCrearProducto().addActionListener(this);
     
        //Estilo
        principal.setLocation(pantalla.width/2-principal.getWidth()/2, pantalla.height/2-principal.getHeight()/2);
        principal.setResizable(false);
        
        flechas = new ContainerListener(){
            
            @Override
            public void componentAdded(ContainerEvent e) {
               int a =Integer.parseInt((String)contadores.get(contadores.size()-1).getValue());
               contadores.get(contadores.size()-1).setValue(a+1);
            }

            @Override
            public void componentRemoved(ContainerEvent e) {
                int a =Integer.parseInt((String)contadores.get(contadores.size()-1).getValue());
               contadores.get(contadores.size()-1).setValue(a-1);
            }
        };
        
        
        
        
    }
    
    public MenuPrincipal getVentana(){
        return principal;
    }
    public ArrayList<Producto> getLista(){
       return lista; 
    }
    
    public void actualizarTabla(){
        
        
        Object matriz[][] =new Object[this.lista.size()][3];
        JSpinner bTemporal= new JSpinner();
        bTemporal.addContainerListener(flechas);
        bTemporal.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getSource());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                 System.out.println(e.getSource());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        contadores.add(bTemporal);
        for(int i=0; i<lista.size();i++){
            matriz[i][0]= lista.get(i).getNombre();
            matriz[i][1]= lista.get(i).getPrecio();
            matriz[i][2]= contadores.get(i);

        }
        principal.getTablaPrincipal().setDefaultRenderer(Object.class, new Render());
        principal.getTablaPrincipal().setModel(new javax.swing.table.DefaultTableModel(
            matriz,
            new String [] {
                "Producto", "Precio", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(principal.getAgregar()== e.getSource()){
            cbp.getBuscarProducto().setLocation(principal.getX()+principal.getWidth(), principal.getY());
            cbp.getBuscarProducto().setVisible(true);
        }
        if(principal.getCrearCategoria()==e.getSource()){
          ccc.getVentana().setLocation(principal.getX()-ccc.getVentana().getWidth(),principal.getY());
          ccc.getVentana().setVisible(true);
        }
        if(principal.getCrearProducto()==e.getSource()){
          ccp.getVentana().setLocation(principal.getX()-ccp.getVentana().getWidth(),principal.getY()+ccc.getVentana().getHeight());
          ccp.getVentana().setVisible(true);
        }
        
        
    }
  
    
    
 
}
