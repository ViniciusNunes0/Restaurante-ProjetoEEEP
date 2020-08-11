/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DB.Conecao;
import Model.camposCaixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinícius Nunes
 */
public class FuncaoCaixa {
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
     public void excluir(camposCaixa cc){
         conn = Conecao.Conecao();
      String sql = "delete from listarpedido where Mesa = ?";
     try{
     pst = conn.prepareStatement(sql);
     pst.setString(1, cc.getPesquisar());
     pst.execute();
          
     JOptionPane.showMessageDialog(null, "Pagamento Feito com Sucesso!");
     }catch(SQLException erro){
         JOptionPane.showMessageDialog(null, erro);
     }
 } 
     public void Cadastrar(camposCaixa cc){
    conn =Conecao.Conecao();
     String sql = "Insert Into totalDia(valor,data)Values(?,?)";
     
     try{
     pst = conn.prepareStatement(sql);  
     pst.setString(1, cc.getTotal());
     pst.setString(2, cc.getData());
     pst.execute();
       
     }catch(SQLException erro){
         JOptionPane.showMessageDialog(null, erro);
     }

         }

}
