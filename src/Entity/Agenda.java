
package Entity;

import java.awt.List;
import java.util.ArrayList;
import javafx.scene.chart.PieChart;

public abstract class Agenda {
    protected int id;
    protected int sala;
    private double custoPorHora;

    
    
    public double getCustoPorHora() {
        return custoPorHora;
    }

    public void setCustoPorHora(double custoPorHora) {
        this.custoPorHora = custoPorHora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }
 
    
    private java.util.List<Sala> listaSalas;
   
      public Agenda(){
       
        listaSalas = new ArrayList<Sala>();   
      
         custoPorHora = 25;
    }

    public void adicionarSala(Sala objSala) {
         listaSalas.add(objSala); 
        
    }
      
    public java.util.List<Sala> getListaSala() {
        return listaSalas;
    }
  
}
