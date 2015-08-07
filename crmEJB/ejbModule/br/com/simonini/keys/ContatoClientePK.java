package br.com.simonini.keys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class ContatoClientePK implements Serializable {

	private static final long serialVersionUID = -2997064521885342444L;

	@Column(name="ID_CLIENTE", updatable=false)
	private long idCliente2;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sequencia;

	public ContatoClientePK() {
		super();
	}

	public ContatoClientePK(long idCliente2) {
		super();
		this.idCliente2 = idCliente2;
	}

	public long getIdCliente2() {
		return this.idCliente2;
	}

	public void setIdCliente2(long idCliente2) {
		this.idCliente2 = idCliente2;
	}

	public long getSequencia() {
		return this.sequencia;
	}

	public void setSequencia(long sequencia) {
		this.sequencia = sequencia;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if ( ! (o instanceof ContatoClientePK)) {
			return false;
		}
		ContatoClientePK other = (ContatoClientePK) o;
		return (this.idCliente2 == other.idCliente2)
			&& (this.sequencia == other.sequencia);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idCliente2 ^ (this.idCliente2 >>> 32)));
		hash = hash * prime + ((int) (this.sequencia ^ (this.sequencia >>> 32)));
		return hash;
	}
}
