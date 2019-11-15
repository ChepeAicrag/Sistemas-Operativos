/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paginacion;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Ventana extends JFrame {
    public Ventana(){
        this.setSize(800,800);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("PAGINACION DE MEMORIA");
        this.setLocationRelativeTo(null);
        //iniciarComponentes();
        crearPaginas();
        
  }
    private void iniciarComponentes(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        this.getContentPane().add(panel);
        JLabel etiqueta = new JLabel("Tamaño del archivo");
        etiqueta.setLayout(null);
        etiqueta.setBounds(50, 50, 150, 30);
        JLabel etiqueta2 = new JLabel("Numero de paginas");
        etiqueta2.setLayout(null);
        etiqueta2.setBounds(50, 90, 150, 30);
        panel.add(etiqueta);
        panel.add(etiqueta2);
    }   
    
    
    private void crearPaginas(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        this.getContentPane().add(panel);
        float x = 5;
        int cont = 1;
        int posY = 50;
        while (cont <= x) {            
            
            JLabel hojaFisica = new JLabel("Pagina Fisica " + cont,SwingConstants.CENTER);
            hojaFisica.setOpaque(true);
            hojaFisica.setBackground(Color.red);
            hojaFisica.setBounds(300,posY,150,30);
            
            JLabel hojaVirtual = new JLabel("Pagina Virtual " + cont,SwingConstants.CENTER);
            hojaVirtual.setOpaque(true);
            hojaVirtual.setBackground(Color.BLUE);
            hojaVirtual.setBounds(300,posY + 40,150,30);
            
            
            cont++;
            posY += 100;
            panel.add(hojaFisica);
            panel.add(hojaVirtual);
        }
        if(x % 1 != 0){
            JLabel hojaFisica = new JLabel("Pagina Fisica " + cont,SwingConstants.CENTER);
            hojaFisica.setOpaque(true);
            hojaFisica.setBackground(Color.red);
            hojaFisica.setBounds(300,posY,150,30);
            panel.add(hojaFisica);
        }
        
    }
        
}
