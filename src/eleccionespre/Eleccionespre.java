/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleccionespre;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Eleccionespre extends JFrame implements ActionListener{
  private JPanel pnlTitulo;
    private JPanel pnlOperacion;
    private JPanel pnlBotones;
    private JLabel lblTitulo;
    private JTextArea resultado;
    private JButton btnLimpiar;
    private JButton btnvotar;
    private JButton btnSalir;
    private JButton btnresultado;
     private JButton subir;
    private JRadioButton gustavopetro;
    private JRadioButton ivanduque;
    private JRadioButton humbertocalle;
    private JRadioButton sergiofajardo;
    private int votospetro=0;
    private int votosivan=0;
    private int votoshumber=0;

  private int votossergio=0;
    
    private ButtonGroup bg;
    private Container contenedor;
      conexion con = new conexion();

public Eleccionespre(){
    
    
     this.pnlTitulo = new JPanel();
     this.lblTitulo = new JLabel("Elecciones presidenciales 2018 Escoja su voto");
     pnlTitulo.add(lblTitulo);
     this.pnlOperacion = new JPanel();
     this.pnlOperacion.setLayout(new GridLayout(5,2));
     this.gustavopetro =new JRadioButton("Gustavo Petro");
       this.ivanduque=new JRadioButton("Ivan Duque");
       this.humbertocalle =new JRadioButton("Humberto De La Calle");
       this.sergiofajardo =new JRadioButton("Sergio Fajardo");
    
   
     this.resultado= new JTextArea();
    this.btnresultado= new JButton("Resultados");
       this.pnlBotones = new JPanel();

        pnlBotones.setLayout(new GridLayout(1,5));
        this.subir=new JButton("actualizar base de datos ");
        this.btnvotar= new JButton("Votar");
        this.btnLimpiar = new JButton("Limpiar");
        this.btnSalir = new JButton("Salir");
       
      
       this.bg=new ButtonGroup();
       
       bg.add(gustavopetro);
       bg.add(ivanduque);
       bg.add(humbertocalle);
       bg.add(sergiofajardo);
       pnlOperacion.add(gustavopetro);
       pnlOperacion.add(ivanduque);
       pnlOperacion.add(humbertocalle);
       pnlOperacion.add(sergiofajardo);
       pnlOperacion.add(resultado);
       resultado.setEditable(false);
        pnlBotones.add(subir);
       pnlBotones.add(btnresultado);
       pnlBotones.add(btnvotar);
       pnlBotones.add(btnLimpiar);
       pnlBotones.add(btnSalir);
       subir.addActionListener(this);
       btnresultado.addActionListener(this);
       btnvotar.addActionListener(this);
       btnSalir.addActionListener(this);
       btnLimpiar.addActionListener(this);

       
        this.contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        contenedor.add(pnlTitulo, BorderLayout.NORTH);
        contenedor.add(pnlOperacion,BorderLayout.CENTER);
        contenedor.add(pnlBotones,BorderLayout.SOUTH);
     
        setTitle("Elecciones 2018");
        setSize(600,700);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(true);
     
     
}
 @Override
    public void actionPerformed(ActionEvent evento) {
        
         if (evento.getSource()==btnvotar) {
              if (gustavopetro.isSelected()) {
                votopetro();
            }
            if (ivanduque.isSelected()) {
                votoivan();
            }
               if (humbertocalle.isSelected()) {
                votohumber();
            }
         
            
                if (sergiofajardo.isSelected()) {
                    votosergio();
            }
         
              
         }  else{
             
             
                  
            if(evento.getSource()==subir){
                actualizar();
            }else
             
            
            if(evento.getSource()==btnresultado){
                mostrar();
            }
            else{
            
            if(evento.getSource()==btnLimpiar){
                limpiar();
            } else { if(evento.getSource()==btnSalir){
                    System.exit(0);
                }
            }
        }
    }
    }         
               
          
      private void votopetro() {
        int x=1;
        
        
        this.votospetro+=x;
        JOptionPane.showMessageDialog(null,"Voto exitoso gracias");
    
      
    }  
   
      private void votoivan() {
        int x=1;
        
       
        this.votosivan+=x;
       JOptionPane.showMessageDialog(null,"Voto exitoso gracias");
       

      
    }  
        private void votohumber() {
        int x=1;
        
    
        this.votoshumber+=x;
        JOptionPane.showMessageDialog(null,"Voto exitoso gracias");
    
      
    }    
      
        private void votosergio() {
        int x=1;
        
      
        this.votossergio+=x;
        JOptionPane.showMessageDialog(null,"Voto exitoso gracias");
    
      
    }    
    
    private void mostrar(){
        resultado.setText("Resultados Elecciones: \nGustavo Petro: "+this.votospetro+" votos\n Ivan Duque: "+this.votosivan+" votos\n Humberto De La Calle: "+this.votoshumber+" votos\n Sergio fajardo: "+this.votossergio+" votos\n" );
    }
      
    
    
     private void actualizar() {

        try{

            Statement comando=con.getConnection().createStatement();
            int cantidad = comando.executeUpdate("insert into votos(votospetro,votosivanduque,votoshumbertocalle,votossergiofajardo) values ('"+this.votospetro+"','"+this.votosivan+"','"+this.votoshumber+"','"+this.votossergio+"')");
            
            if (cantidad==1) {
                setTitle("se actualizo base de datos ");
            } else {
                setTitle("No actualizo");
            }
        } catch(SQLException ex){
            setTitle(ex.toString());
        }
    }
     private void limpiar() {
        resultado.setText("");
        resultado.requestFocus();
        bg.clearSelection(); 
}
}
