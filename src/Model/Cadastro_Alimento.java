/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author vinicius
 */
public class Cadastro_Alimento {
    private int codigo;
    private String nome;
    private double preco;
    
   public int getcodigo() {
        return codigo;
    }

    public void setcodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
     public double getpreco() {
        return preco;
    }

    public void setpreco(double preco) {
        this.preco = preco;
    }
    
}
