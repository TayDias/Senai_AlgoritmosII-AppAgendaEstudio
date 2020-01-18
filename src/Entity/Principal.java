
package Entity;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    
    private List<Cliente> listaClientes;
     
      public Principal(){
       
        listaClientes = new ArrayList<Cliente>();        
    }

    public void adicionarCliente(Cliente objCliente) {
        listaClientes.add(objCliente);   
    }
    
     public void excluirCliente(Cliente cliente) {
        listaClientes.remove(cliente);
    }
      
    public List<Cliente> getListaclientes() {
        return listaClientes;
    }
}
