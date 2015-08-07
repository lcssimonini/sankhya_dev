package br.com.simonini.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.simonini.keys.ContatoClientePK;

@Entity
@Table(name="contato")
public class Contato implements Serializable{

	private static final long serialVersionUID = -4035563719397519490L;

	@EmbeddedId
	private ContatoClientePK id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;
	
	private String nome;
	private String email;
	private String telefone;
	
	// 1 - comprador
	// 2 - vendedor
	// 3 - auxiliar administrativo
	// 4 - gerente
	// 5 - diretor
	private int cargo;

	// 1 - comercial
	// 2 - financeiro
	// 3 - servi�os
	// 4 - ind�stria
	// 1 - almoxarifado
	// 2 - recursos humanos
	// 3 - fiscal
	// 4 - cont�bil
	private int departamento;
		
    public Contato() {
    }
    
    public Contato(ContatoClientePK pk, Cliente cliente, String nome,
			String email, String telefone, int cargo, int departamento) {
		super();
		this.id = pk;
		this.cliente = cliente;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cargo = cargo;
		this.departamento = departamento;
	}
    
    public long getSequencia() {
    	return this.id.getSequencia();
    }
    
    public static String getGreeting(){
    	return "Bom dia Contato";
    }
    
	public ContatoClientePK getId() {
    	return this.id;
    }
    
    public void setId(ContatoClientePK id){
    	this.id = id;
    }

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getCargo() {
		return cargo;
	}

	public void setCargo(int cargo) {
		this.cargo = cargo;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	

}
