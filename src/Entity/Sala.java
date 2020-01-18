
package Entity;

import java.awt.List;
import java.util.Date;

public class Sala extends Agenda{
    private int id;
    private String descricao;
    private Date data;
    private Date horarioInicio;
    private Date horarioTermino;
    private int numero;
    private int idCliente;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    

    @Override
    public String toString() {
        return numero + " - "+data+" - ("+horarioInicio+")";
       
    }
    
    public int getSala() {
        return sala;
    }

    public void setSala(int descricao) {
        this.sala = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Date horario) {
        this.horarioInicio = horario;
    }

    public Date getHorarioTermino() {
        return horarioTermino;
    }

    public void setHorarioTermino(Date horarioTermino) {
        this.horarioTermino = horarioTermino;
    }
    
}
