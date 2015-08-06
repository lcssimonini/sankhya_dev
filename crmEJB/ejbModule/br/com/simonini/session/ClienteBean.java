package br.com.simonini.session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.simonini.daos.ClienteDao;
import br.com.simonini.entities.Cliente;

@Stateless(mappedName = "clienteBean")
@LocalBean
public class ClienteBean extends ClienteDao {

	public ClienteBean() {
		super(Cliente.class);
	}
	
    public String getGreeting(){
    	return Cliente.getGreeting();
    }
    
    public List<Cliente> createClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Cliente cliente1 = new Cliente();
		cliente1.setId(new Long(1));
	    cliente1.setNome("alfredo");
	    cliente1.setDocumento("321321");
	    
	    Cliente cliente2 = new Cliente();
	    cliente2.setId(new Long(2));
	    cliente2.setNome("ronaldo");
	    cliente2.setDocumento("321321");
	    
	    Cliente cliente3 = new Cliente();
	    cliente3.setId(new Long(3));
	    cliente3.setNome("silas");
	    cliente3.setDocumento("321321");
	    
	    clientes.add(cliente1);
	    clientes.add(cliente2);
	    clientes.add(cliente3);
	    
	    return clientes;
    }
}
