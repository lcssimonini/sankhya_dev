package br.com.simonini.daos;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.simonini.entities.Cliente;
import br.com.simonini.utils.GenericDao;

public class ClienteDao extends GenericDao<Cliente, Long> {

	public ClienteDao(Class<?> clazz) {
		super(clazz);
	}
	
	public List<Cliente> findByNome(String nome) {
		Query q = this.getEntityManager().createQuery("select object(c) from Cliente as c where c.nome like :nome");
		q.setParameter("nome", nome);
		
		List<Cliente> result = (List<Cliente>) q.getResultList();
		
		return result;
	}
	
	@Override
	public void save(Cliente cliente) throws Exception {
		
		cliente.setDataCadastro(new Date(Calendar.getInstance().getTimeInMillis()));
		
		if (!validaCredito(cliente)) {
			throw new Exception("N�o � poss�vel salvar o cliente pois o limite de cr�dito est� acima do permitido");
		}
		
		try {
			this.beginTransaction();
			this.getEntityManager().persist(cliente);
			this.commit();
		} catch (Exception e) {
			this.rollBack();
			throw e;
		}
	}
	
	@Override
	public void update(Cliente cliente) throws Exception {
		if (!validaCredito(cliente)) {
			throw new Exception("N�o � poss�vel salvar o cliente pois o limite de cr�dito est� acima do permitido");
		}
		try {
			this.beginTransaction();
			this.getEntityManager().merge(cliente);
			this.commit();
		} catch (Exception e) {
			this.rollBack();
			throw e;
		}
	}
	
	@Override
	public void delete(Cliente cliente) {
		EntityManager em = this.getEntityManager();
		
		try {
			this.beginTransaction();
			em.remove(em.getReference(Cliente.class, cliente.getId()));
			this.commit();
		} catch (Exception e) {
			this.rollBack();
			throw e;
		}
	}
	// 1 - micro
	// 2 - pequeno
	// 3 - medio
	// 4 - grande
	public boolean validaCredito(Cliente cliente){
		boolean isValid = true;
		Double credito = cliente.getLimiteCredito();
		
		Integer porte = cliente.getPorte();
		
		if (porte != null && credito != null) {
				switch (porte) {
				case 1:
					if (credito.compareTo(new Double(0)) > 0) {
						isValid = false;
					}
					break;
				case 2:
					if (credito.compareTo(new Double(1000)) > 0) {
						isValid = false;
					}
					break;
				case 3:
					if (credito.compareTo(new Double(50000)) > 0) {
						isValid = false;
					}
					break;
				case 4:
					if (credito.compareTo(new Double(500000)) > 0) {
						isValid = false;
					}
					break;
		
				default:
					break;
			}
		}
		return isValid;
	}
}
