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
import view.Tela_inicial;
import Model.Login;
import view.login;

/**
 *
 * @author Vinicius Nunes
 */
public class Logar {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public boolean Login(Login cl) {

        con = Conecao.Conecao();

        String sql = "Select * from login where usuario = ? and senha = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cl.getUsuario());
            pst.setString(2, cl.getSenha());

            rs = pst.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuário e senha incorretos!", "Restaurante", JOptionPane.WARNING_MESSAGE);

            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);

        }
        return false;
    }
}
