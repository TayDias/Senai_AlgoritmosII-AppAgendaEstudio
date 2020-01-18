
package Entity;

import Exception.ValorSuperiorException;


public class Pagamento {
    private int idPagamento;
    private double valor;
    private String descricao;
    private int idCliente;
    private double custoPorHora;

     public Pagamento(){
       
         custoPorHora = 25;
    }
    
    public double getCustoPorHora() {
        return custoPorHora;
    }

    public void setCustoPorHora(double custoPorHora) {
        this.custoPorHora = custoPorHora;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public double CalcularCustoAgendamento (int h){
        double total = h * custoPorHora;   
        return total;
    }
     public double PagarParcialmente (double v,double v2) throws ValorSuperiorException{
        double total;
         if( v > v2){
              total = v - v2;       
        } else{
            throw new ValorSuperiorException();
        }
         
        return total;
    }
    
    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
