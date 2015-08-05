package br.com.simonini.managedbeans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.simonini.entities.Cliente;
import br.com.simonini.session.ClienteBean;
import br.com.simonini.utils.ScreenUtils;

@ManagedBean(name = "clienteMB")
@ViewScoped
public class ClienteMB implements Serializable {

	private static final long serialVersionUID = -8498185949884249551L;
	
	@EJB
	private ClienteBean clienteBean;
	
	private Long idSelecionado;
	
	private List<Cliente> clientes;
	
	private Cliente cliente;
	
	public String greeting;
	
	public ClienteMB(){
	}
	
	 private Map<Integer,String> tipo;
	 private Map<Integer,String> porte;
	     
	 @PostConstruct
	 public void init() {
	        tipo  = new HashMap<Integer, String>();
	        tipo.put(new Integer(1), "F�sica");
	        tipo.put(new Integer(2), "Jur�dica");
	        
	        porte  = new HashMap<Integer, String>();
	        porte.put(new Integer(1), "Micro");
	        porte.put(new Integer(2), "Pequeno");
	        porte.put(new Integer(3), "Medio");
	        porte.put(new Integer(4), "Grande");
	 }
	
	public void setIdSelecionado(Long idSelecionado) {
		this.idSelecionado = idSelecionado;
	}
	
	public Long getIdSelecionado() {
		return idSelecionado;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void incluir(){
		cliente = new Cliente();
	}
	
	public void editar() {
		if (idSelecionado == null) {
			return;
		}
		cliente = clienteBean.findById(idSelecionado);
	}
	
	public List<Cliente> getClientes() {
		if (clientes == null) {
			clientes = clienteBean.findAll();
		}
		return clientes;
	}

	
	public String salvar() {
		try {
			clienteBean.save(cliente);
		} catch(Exception ex) {
			ScreenUtils.addMessage("N�o foi poss�vel salvar o cliente", ex.getMessage());
			return "";
		}
		return "listaClientes";
	}
	
	public String remover() {
		try {
			clienteBean.delete(cliente);
		} catch(Exception ex) {
			ScreenUtils.addMessage("N�o foi poss�vel remover o contato", ex.getMessage());
			return "";
		}
		return "listaClientes";
	}
	
	public String getGreeting(){
		this.greeting = clienteBean.getGreeting();
		return greeting;
	}
}
