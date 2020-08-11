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
import Model.ResevarModel;
import Model.campos_Pedido;
import java.util.ArrayList;
import java.util.List;
import Model.ResevarModel;
/**
 *
 * @author Vinícius Nunes
 */
public class ResevarControle {
Connection con;
PreparedStatement pst;
ResultSet rs;   
String sql;

    public void salvar(ResevarModel rm){
        con=Conecao.Conecao();
        String sql ="Insert into listarpedido (mesa,status,nome) values(?,?,?)";
        try{
            pst=con.prepareStatement(sql);
            pst.setInt(1, rm.getMesa());
            pst.setString(2, rm.getStatus());
            pst.setString(3, rm.getNome());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Resevado com Sucesso "+rm.getNome());
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, erro);
        }
    }
    public List<ResevarModel>verificarResevarmesa(String mesa,String status,String nome){
                  sql="select *from listarpedido where mesa='"+mesa+"'|| status='"+status+"'and nome='"+nome+"'";
                  
               
               List<ResevarModel> lista = new ArrayList<>();
               
    return RetornarConsulta();
}
    public List<ResevarModel>BuscarResevar(String parametro){
        if(parametro.equals("listar")){
            sql="select * from listarpedido order by mesa"; 
         }else{
            sql="select * from listarpedido where nome like'%"+parametro+"%' order by mesa";
        }
            return RetornarConsulta();
}
    public List<ResevarModel> RetornarConsulta(){
        try {
            List<ResevarModel> lista=new ArrayList <>();
            con =Conecao.Conecao();
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            ResevarModel rm; 
           
            while(rs.next()){        
            rm = new ResevarModel();
            rm.setMesa(rs.getInt("mesa"));
            rm.setNome(rs.getString("mesa"));
            rm.setStatus(rs.getString("status"));
            lista.add(rm);
            }
            
            return lista;
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    return null;    
    }


}
        

