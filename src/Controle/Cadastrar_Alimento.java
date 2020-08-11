/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;
import DB.Conecao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.Cadastro_Alimento;
/**
 *
 * @author Werlesson
 */
public class Cadastrar_Alimento {
    
Connection con;
   PreparedStatement pst;
   ResultSet rs;
   
        
    public void CadastrarAlimento(Cadastro_Alimento cp){
   con = Conecao.Conecao();
   
        String sql = "insert into alimentos (nome,preco) values(?,?)";
     
     try{
     pst = con.prepareStatement(sql);  
     
     pst.setString(1, cp.getNome());
     pst.setDouble(2, cp.getpreco());
    
     pst.execute();
     
     JOptionPane.showMessageDialog(null,"Cadastrado com sucesso!");
     
     }
     
     catch(SQLException error){
     JOptionPane.showMessageDialog(null,error);
     }
    }
     public void editar(Cadastro_Alimento cp){
       con = Conecao.Conecao();
      
       String sql = "Update alimentos set nome = ?, preco = ? where id = ?";
       try{
       pst = con.prepareStatement(sql);
       pst.setString(1, cp.getNome());
       pst.setDouble(2, cp.getpreco());
       pst.setInt(3, cp.getcodigo());
  
       pst.executeUpdate(); 
       JOptionPane.showMessageDialog(null,"Alterado com Sucesso!");
      
       }
       catch(SQLException error){
       JOptionPane.showMessageDialog(null,error);
       }
     }
      
     public void deletar(Cadastro_Alimento cp){
     con =Conecao.Conecao();      
      String sql = "delete from alimentos where id = ?";
      try{
      pst = con.prepareStatement(sql);
      pst.setInt(1,cp.getcodigo());
      pst.execute();
      
      JOptionPane.showMessageDialog(null,"Excluido com sucesso!");
      
      }
      catch(SQLException error){
      JOptionPane.showMessageDialog(null, error);
      }
      
      }
      

}