package br.com.simonini.session;

import javax.ejb.Stateless;

import br.com.simonini.entities.Cliente;

@Stateless(mappedName = "clienteBean")
public class ClienteBean implements ClienteBeanLocal {

    public ClienteBean() {
    }
    
    public String getGreeting(){
    	return Cliente.getGreeting();
    }

}
