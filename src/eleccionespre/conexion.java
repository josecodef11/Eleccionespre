/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleccionespre;

import java.sql.*; 
public class conexion {
    static String bd = "votos";
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/"+bd;
    Connection conn = null;
    public String cadena1="Conectado a base de datos "; 
    public String result;
    /** Constructor de DbConnection */
    public  conexion() {
        try{
            //obtenemos el driver de para mysql
            Class.forName("com.mysql.jdbc.Driver");
            //obtenemos la conexion
            conn = DriverManager.getConnection(url,login,password);
            if (conn!=null){

                result= cadena1.concat(bd);

            }
        }catch(SQLException e){
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
    }

    public Connection getConnection(){
        return conn;
    }

}
