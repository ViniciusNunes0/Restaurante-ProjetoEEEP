/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Vinicius Nunes
 */
public class campos_Pedido {

    private int codigo;
    private int mesa;
    private String pedido;
    private int quantidade;
    private double valor;
    private double valorTotal;
    private int tfcodigopedido;
    private String status;

    public int getTfcodigopedido() {
        return tfcodigopedido;
    }

    public void setTfcodigopedido(int tfcodigopedido) {
        this.tfcodigopedido = tfcodigopedido;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getMesa() {
        return mesa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
