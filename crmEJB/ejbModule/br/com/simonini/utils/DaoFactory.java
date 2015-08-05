package br.com.simonini.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.simonini.daos.ClienteDao;
import br.com.simonini.daos.ContatoDao;
import br.com.simonini.entities.Cliente;
import br.com.simonini.entities.Contato;

public final class DaoFactory {
	
	private static ClienteDao clienteDaoInstance;
	private static ContatoDao contatoDaoInstance;
	
	private DaoFactory() { }

	private static final String PERSISTENCE_UNIT_NAME = "crmPersistenceUnit";

	private static EntityManagerFactory entityManagerFactoryInstance;

	public static EntityManagerFactory entityManagerFactorInstance() {
		if (entityManagerFactoryInstance == null) {
			entityManagerFactoryInstance = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}

		return entityManagerFactoryInstance;
	}
	
	public static ClienteDao clienteInstance() {
		if (clienteDaoInstance == null) {
			clienteDaoInstance = new ClienteDao(Cliente.class);
		}
		
		return clienteDaoInstance;
	}
	
	public static ContatoDao contatoInstance() {
		if (contatoDaoInstance == null) {
			contatoDaoInstance = new ContatoDao(Contato.class);
		}
		
		return contatoDaoInstance;
	}
}
