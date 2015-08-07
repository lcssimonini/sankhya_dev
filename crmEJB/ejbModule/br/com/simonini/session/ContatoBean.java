package br.com.simonini.session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.simonini.daos.ContatoDao;
import br.com.simonini.entities.Cliente;
import br.com.simonini.entities.Contato;
import br.com.simonini.keys.ContatoClientePK;

@Stateless(mappedName = "contatoBean")
@LocalBean
public class ContatoBean extends ContatoDao {

    public ContatoBean() {
    	super(Contato.class);
    }
    
    public String getGreeting(){
    	return Contato.getGreeting();
    }
    
    public List<Contato> createContatos(Cliente cliente) {
		
    	List<Contato> contatos= new ArrayList<Contato>();
		
    	Contato contato1 = new Contato();
		contato1.setId(new ContatoClientePK(cliente.getId()));
	    contato1.setNome("alfredo");
	    
	    Contato contato2 = new Contato();
	    contato2.setId(new ContatoClientePK(cliente.getId()));
	    contato2.setNome("ronaldo");
	    
	    Contato contato3 = new Contato();
	    contato3.setId(new ContatoClientePK(cliente.getId()));
	    contato3.setNome("silas");
	    
	    contatos.add(contato1);
	    contatos.add(contato2);
	    contatos.add(contato3);
	    
	    return contatos;
    }
}
