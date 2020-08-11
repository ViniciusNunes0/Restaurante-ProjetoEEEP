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
import Model.Cadastro_Funcionario;

/**
 *
 *
 * @author vinicius nunes
 */
public class CadastrarFuncionario {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public void CadastrarFuncionario(Cadastro_Funcionario cp) {
        con = Conecao.Conecao(); 
        String sql = "Insert Into listarfuncionario "
                + "(sexo,nome,rg,cpf,telefone,data_nasc,rua,bairro,cep,email)Values(?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cp.getSexo());
            pst.setString(2, cp.getNome());
            pst.setString(3, cp.getRG());
            pst.setString(4, cp.getCPF());
            pst.setString(5, cp.getTelefone());
            pst.setString(6, cp.getData_nascimento());
            pst.setString(7, cp.getRua());
            pst.setString(8, cp.getBairro());
            pst.setString(9, cp.getCEP());
            pst.setString(10, cp.getEmail());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void editar(Cadastro_Funcionario cp) {
        con = Conecao.Conecao();

        String sql = "update listarfuncionario set sexo = ?, nome = ?, rg = ?, cpf = ?, telefone = ?, data_nasc = ?, rua = ?,"
                + " bairro = ?, cep = ?, email = ? where id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cp.getSexo());
            pst.setString(2, cp.getNome());
            pst.setString(3, cp.getRG());
            pst.setString(4, cp.getCPF());
            pst.setString(5, cp.getTelefone());
            pst.setString(6, cp.getData_nascimento());
            pst.setString(7, cp.getRua());
            pst.setString(8, cp.getBairro());
            pst.setString(9, cp.getCEP());
            pst.setString(10, cp.getEmail());
            pst.setInt(11, cp.getCodigo());
            //esta preparando os codigos
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
            //executar os codigos q forem alterados
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }
    // ira mostrar se der erro nos codigos que foram alterados

    public void deletar(Cadastro_Funcionario cp) {
        con = Conecao.Conecao();
        
        String sql = "delete from listarfuncionario where id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, cp.getCodigo());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }

    }

}