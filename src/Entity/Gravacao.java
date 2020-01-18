
package Entity;

import java.awt.List;
import java.util.ArrayList;

public abstract class Gravacao{
    protected double custo;
    private java.util.List<Disco>  listaDiscos;

    //private List listaDiscos = new List();

    public Gravacao(){
        listaDiscos = new ArrayList<Disco>();
    }
  
    public void adicionarDisco(Disco disco) {
        listaDiscos.add(disco);
    }
    
     public java.util.List<Disco> getListarDiscos() {
        return listaDiscos;
    }
    
    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    
}
