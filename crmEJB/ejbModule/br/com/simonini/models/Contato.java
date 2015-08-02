package br.com.simonini.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="contato")
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;
	
	private String nome;
	private String endereco;
	private String numero;
	private String telefone;
	
	// 1 - pessoa fisica
	// 2 - pessoa juridica
	private int tipo;
	private String documento;
	private String cidade;
	private String estado;
	private String email;
	// 1 - micro
	// 2 - pequeno
	// 3 - medio
	// 4 - grande
	private int porte;
	private double limiteCredito;
	private Date dataCadastro;
	
	
	
    public Contato() {

    }

}
