package br.com.simonini.session;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.simonini.daos.ClienteDao;
import br.com.simonini.entities.Cliente;

@Stateless(mappedName = "clienteBean")
@LocalBean
public class ClienteBean extends ClienteDao {

    public ClienteBean() {
    	super();
    }
    
    public String getGreeting(){
    	return Cliente.getGreeting();
    }
}
