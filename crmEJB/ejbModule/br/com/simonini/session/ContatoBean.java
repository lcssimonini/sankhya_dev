package br.com.simonini.session;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.simonini.daos.ContatoDao;
import br.com.simonini.entities.Contato;

@Stateless(mappedName = "contatoBean")
@LocalBean
public class ContatoBean extends ContatoDao {

    public ContatoBean() {
    	super();
    }
    
    public String getGreeting(){
    	return Contato.getGreeting();
    }
}
