/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DB.Conecao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.campos_Pedido;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Vinicius Nunes
 */
public class FuncaoPedido {
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    public void CadastraPedido(campos_Pedido cp){
        con = Conecao.Conecao();
        
     String sql = "insert into listarpedido (Mesa,pedido,quantidade,preco,CodPedido,total)values(?,?,?,?,?,?)";
     
     try{
     pst = con.prepareStatement(sql);  
     pst.setInt(1, cp.getMesa());
     pst.setString(2, cp.getPedido());
     pst.setInt(3, cp.getQuantidade());
     pst.setDouble(4, cp.getValor());
     pst.setInt(5, cp.getTfcodigopedido());
     pst.setDouble(6, cp.getValorTotal());
     
     
     pst.execute();
     
     JOptionPane.showMessageDialog(null,"Cadastrado com sucesso!");
         
     
     }catch(SQLException error){
     JOptionPane.showMessageDialog(null,error);
     }
    }
    
    public void alterar(campos_Pedido cp){
        con = Conecao.Conecao();
       String sql = "update listarpedido set Mesa = ?, CodPedido = ?, pedido = ?, quantidade = ?, preco = ?, total = ? where Id = ?";
       try{
       pst = con.prepareStatement(sql);
       pst.setInt(1, cp.getMesa());
       pst.setInt(2, cp.getTfcodigopedido());
       pst.setString(3, cp.getPedido());
       pst.setInt(4, cp.getQuantidade());
       pst.setDouble(5, cp.getValor());
       pst.setDouble(6, cp.getValorTotal());
       pst.setInt(7, cp.getCodigo());
       
       pst.executeUpdate(); 
       
       JOptionPane.showMessageDialog(null,"Alterado com Sucesso!");
       
       }
       catch(SQLException error){
       JOptionPane.showMessageDialog(null,error);
       }
      }
     public void deletar(campos_Pedido cp){
      int sim = JOptionPane.showConfirmDialog(null, "Tem certeza que quer excluir?");
         if(sim!=0){
          JOptionPane.showMessageDialog(null, "ok");
      }else{
         con = Conecao.Conecao();
         
      String sql = "delete from listarpedido where id = ?";
      try{
      pst = con.prepareStatement(sql);
      pst.setInt(1, cp.getCodigo());
      pst.execute();
      
      JOptionPane.showMessageDialog(null,"Deletado com Sucesso!");
      
      }
      catch(SQLException error){
      JOptionPane.showMessageDialog(null, error);
      }
      
      }
     }
     
     public List<campos_Pedido> ListarPedidos(String parametro){
         List<campos_Pedido> lista = new ArrayList<>();
         String sql;
         if(parametro.equals("listar")){
            sql = "select * from alimentos order by id";
         }else{
             sql = "select * from alimentos where id = '"+parametro+"'";
         }
         con = Conecao.Conecao();
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            campos_Pedido cp;
            while(rs.next()){
                cp = new campos_Pedido();
                cp.setCodigo(rs.getInt("id"));
                cp.setPedido(rs.getString("nome"));
                cp.setValor(rs.getDouble("preco"));
                lista.add(cp);
            }
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel realizar a pesquisa "+ex.getMessage());
        }
        return null;
     }
}