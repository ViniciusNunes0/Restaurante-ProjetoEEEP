/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinicius Nunes
 */
public class Conecao {
    public static Connection Conecao(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/restaurante","root","");
        return con;
        }catch(ClassNotFoundException erro){
        JOptionPane.showMessageDialog(null,"O drive de coneção não foi encontrado "+erro.getMessage());
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados "+ex.getMessage());
        }
        return null; 
    }


}
