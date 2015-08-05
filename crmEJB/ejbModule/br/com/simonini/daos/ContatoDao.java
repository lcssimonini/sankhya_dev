package br.com.simonini.daos;

import br.com.simonini.entities.Contato;
import br.com.simonini.keys.ContatoClientePK;
import br.com.simonini.utils.GenericDao;


public class ContatoDao extends GenericDao<Contato, ContatoClientePK> {

	public ContatoDao(Class<?> clazz) {
		super(clazz);
	}
}
