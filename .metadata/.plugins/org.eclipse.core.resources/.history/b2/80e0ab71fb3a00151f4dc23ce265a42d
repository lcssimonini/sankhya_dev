package br.com.simonini.session;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.simonini.entities.Cliente;

@Stateless(mappedName = "clienteBean")
@LocalBean
public class ClienteBean {

    public ClienteBean() {
    }
    
    public String getGreeting(){
    	return Cliente.getGreeting();
    }

}
