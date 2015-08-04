package br.com.simonini.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.simonini.entities.Contato;
import br.com.simonini.keys.ContatoClientePK;
import br.com.simonini.session.ContatoBean;
import br.com.simonini.utils.ScreenUtils;

@ManagedBean(name = "contatoMB")
@ViewScoped
public class ContatoMB implements Serializable {

	private static final long serialVersionUID = 4575274497323620647L;

	@EJB
	private ContatoBean contatoBean;
	
	private ContatoClientePK idSelecionado;
	
	private List<Contato> contatos;
	
	private Contato contato;
	
	public String greeting;
	
	public ContatoMB(){
	}
	
	public void setIdSelecionado(ContatoClientePK idSelecionado) {
		this.idSelecionado = idSelecionado;
	}
	
	public ContatoClientePK getIdSelecionado() {
		return idSelecionado;
	}
	
	public Contato getContato() {
		return contato;
	}
	
	public void incluir(){
		contato = new Contato();
	}
	
	public void editar() {
		if (idSelecionado == null) {
			return;
		}
		contato = contatoBean.findById(idSelecionado);
	}
	
	public List<Contato> getContatos() {
		if (contatos == null) {
			contatos = contatoBean.findAll();
		}
		return contatos;
	}

	
	public String salvar() {
		try {
			contatoBean.save(contato);
		} catch(Exception ex) {
			ScreenUtils.addMessage(ScreenUtils.getMessageFromI18N("msg.erro.salvar.mercadoria"), ex.getMessage());
			return "";
		}
		return "listaMercadorias";
	}
	
	public String remover() {
		try {
			contatoBean.delete(contato);
		} catch(Exception ex) {
			ScreenUtils.addMessage(ScreenUtils.getMessageFromI18N("msg.erro.remover.mercadoria"), ex.getMessage());
			return "";
		}
		return "listaContatos";
	}
	
	public String getGreeting(){
		this.greeting = contatoBean.getGreeting();
		return greeting;
	}

}
