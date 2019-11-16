
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
        this.setSize(2000,800);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("PAGINACION DE MEMORIA");
        this.setLocationRelativeTo(null);
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.black);
        panel.setPreferredSize(new Dimension(2000,1080));
        deslizador.setViewportView(panel);
        this.getContentPane().add(deslizador);
        crearPaginas();
    }  
    
    private void crearPaginas(){
        
        float x = (float) tamArchivo/tamPagina;
        int cont = 1;
        int posX = 100;
        int posY = 80;
        while (cont <= x) {            
            
            // Creación de la hoja fisica
            JLabel hojaFisica = new JLabel("Pagina Fisica " + cont + " " + tamPagina + " mb",SwingConstants.CENTER);
            hojaFisica.setOpaque(true);
            hojaFisica.setBackground(new Color((int) (Math.random()*255),(int) (Math.random()*255),(int) (Math.random()*255)));
            hojaFisica.setBounds(posX,posY,150,30);
            
            // Creación de la hoja virtual
            JLabel hojaVirtual = new JLabel("Pagina Virtual " + cont + " " + tamPagina + " mb",SwingConstants.CENTER);
            hojaVirtual.setOpaque(true);
            hojaVirtual.setBackground(new Color((int) (Math.random()*255),(int) (Math.random()*255),(int) (Math.random()*255)));
            hojaVirtual.setBounds(posX,posY + 40,150,30);
            
            posY += 100;
            
            if(cont % 10 == 0){
                posX += 200;
                posY = 80;
            }
            panel.add(hojaFisica);
            panel.add(hojaVirtual);
            cont++;
            
        }
        if(x % 1 != 0){
            JLabel hojaFisica = new JLabel("Pagina Fisica " + cont + " " + tamPagina + " mb" ,SwingConstants.CENTER);
            hojaFisica.setOpaque(true);
            hojaFisica.setBackground(new Color((int) (Math.random()*255),(int) (Math.random()*255),(int) (Math.random()*255)));
            hojaFisica.setBounds(posX,posY,150,30);
            panel.add(hojaFisica);
        }
    }
}
