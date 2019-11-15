/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paginacion;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Ventana extends JFrame {
    private JPanel panel;
    private int tamArchivo;
    private int tamPagina;
    
    public Ventana(int tamArchivo, int tamPagina){
        JScrollPane deslizador = new JScrollPane();
        deslizador.setBounds(15, 30, 2000,2000);
        this.tamArchivo = tamArchivo;
        this.tamPagina = tamPagina;
        this.setSize(800,800);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("PAGINACION DE MEMORIA");
        this.setLocationRelativeTo(null);
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.black);
        panel.setPreferredSize(new Dimension(1080,1080));
        deslizador.setViewportView(panel);
        //panel.setPreferredSize(new Dimension(5000,5000));
        this.getContentPane().add(deslizador);
        crearPaginas();
        
  }
 private void Datos(){
    /*
    JLabel dato1 = new JLabel("Tamaño del archivo");
    dato1.setLayout(null);
    dato1.setBounds(100, 10, 200, 100);
    
    JLabel dato2 = new JLabel("Tamaño de la pagina");
    dato2.setLayout(null);
    dato2.setBounds(500, 10, 200, 100);
    panel.add(dato1);
    panel.add(dato2);
    
    */
    JTextField numDato1 = new JTextField("Tamaño del archivo");
    numDato1.setBounds(100, 500, 100, 30);
    JTextField numDato2 = new JTextField("Tamaño de la pagina");
    numDato2.setBounds(500, 500, 100, 30);
    panel.add(numDato1);
    panel.add(numDato2);
    //tamArchivo = Integer.parseInt(numDato1.getText());
    //tamPagina = Integer.parseInt(numDato2.getText());
    JButton boton1 = new JButton("Inciar");
    boton1.setBounds(250, 50, 50, 50);
    panel.add(boton1);
    
    
}
    
    
private void crearPaginas(){
        
        float x = (float) tamArchivo/tamPagina;
        int cont = 1;
        int posX = 100;
        int posY = 80;
        while (cont <= x) {            
            
            // Creación de la hoja fisica
            JLabel hojaFisica = new JLabel("Pagina Fisica " + cont + " " + x/1 + " mb",SwingConstants.CENTER);
            hojaFisica.setOpaque(true);
            hojaFisica.setBackground(new Color((int) (Math.random()*255),(int) (Math.random()*255),(int) (Math.random()*255)));
            hojaFisica.setBounds(posX,posY,150,30);
            
            // Creación de la hoja virtual
            JLabel hojaVirtual = new JLabel("Pagina Virtual " + cont + " " + x/1 + " mb",SwingConstants.CENTER);
            hojaVirtual.setOpaque(true);
            hojaVirtual.setBackground(new Color((int) (Math.random()*255),(int) (Math.random()*255),(int) (Math.random()*255)));
            hojaVirtual.setBounds(posX,posY + 40,150,30);
            
            cont++;
            posY += 100;
            panel.add(hojaFisica);
            panel.add(hojaVirtual);
            
            if(cont % 10 == 0){
                posX = 300;
                posY = 80;
            }
        }
        if(x % 1 != 0){
            JLabel hojaFisica = new JLabel("Pagina Fisica " + cont + " " + x/1 + " mb" ,SwingConstants.CENTER);
            hojaFisica.setOpaque(true);
            hojaFisica.setBackground(new Color((int) (Math.random()*255),(int) (Math.random()*255),(int) (Math.random()*255)));
            hojaFisica.setBounds(posX,posY,150,30);
            panel.add(hojaFisica);
        }
    }
}
