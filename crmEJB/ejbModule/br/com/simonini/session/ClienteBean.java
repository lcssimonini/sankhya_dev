package br.com.simonini.session;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.simonini.daos.ClienteDao;
import br.com.simonini.entities.Cliente;

@Stateless(mappedName = "clienteBean")
@LocalBean
public class ClienteBean extends ClienteDao {
    
//	@PersistenceContext
//	private EntityManager em;
//	
//	@Override
//	public EntityManager getEntityManager() {
//		return em;
//	}
//	
	public ClienteBean() {
		super(Cliente.class);
	}
	
    public String getGreeting(){
    	return Cliente.getGreeting();
    }
}
