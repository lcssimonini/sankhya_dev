package br.com.simonini.managedbeans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.simonini.daos.ClienteDao;
import br.com.simonini.entities.Cliente;
import br.com.simonini.entities.Contato;
import br.com.simonini.keys.ContatoClientePK;
import br.com.simonini.session.ContatoBean;
import br.com.simonini.utils.SimoUtils;

@ManagedBean(name = "contatoMB")
@ViewScoped
public class ContatoMB implements Serializable {

	private static final long serialVersionUID = 4575274497323620647L;

	@EJB
	private ContatoBean contatoBean;
	
	private ContatoClientePK idSelecionado;
	
	private String clienteId;
	private String sequencia;
	
	private List<Contato> contatos;
	
	private Contato contato;
	
	public String greeting;
	
	private Map<String, Integer> cargo;
	private Map<String, Integer> departamento;
	
	@PostConstruct
	public void init() {
		cargo  = Contato.cargoMap;   
		departamento = Contato.departamentoMap;
	}
	
	public ContatoMB(){
	}
	
	public Map<String, Integer> getCargo() {
		return cargo;
	}

	public void setCargo(Map<String, Integer> cargo) {
		this.cargo = cargo;
	}

	public Map<String, Integer> getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Map<String, Integer> departamento) {
		this.departamento = departamento;
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
		if (clienteId == null || sequencia == null) {
			return;
		}
		
		ContatoClientePK pk = new ContatoClientePK();
		pk.setIdCliente2(new Long(clienteId));
		pk.setSequencia(new Long(sequencia));
		
		contato = contatoBean.findById(pk);
	}
	
	public List<Contato> getContatos() {
		if (contatos == null) {
			contatos = contatoBean.findAll();
		}
		return contatos;
	}

	
	public String salvar() {
		if (contato.getId() == null) {
			ClienteDao cliDao = new ClienteDao(Cliente.class);
			
			Cliente cliente = cliDao.findById(new Long(clienteId));
			
			ContatoClientePK pk = new ContatoClientePK(new Long(clienteId));
			contato.setId(pk);
			contato.setCliente(cliente);

			try {
				contatoBean.save(contato);
			} catch(Exception ex) {
				SimoUtils.addMessage("Não foi possível salvar o contato", ex.getMessage());
				return "";
			}	
		} else {
			try {
				contatoBean.update(contato);
			} catch(Exception ex) {
				SimoUtils.addMessage("Não foi possível editar o contato", ex.getMessage());
				return "";
			}	
		}
		return "listaClientes";
	}
	
	public String remover() {
		try {
			contatoBean.delete(contato);
		} catch(Exception ex) {
			SimoUtils.addMessage("Não foi possível remover o contato", ex.getMessage());
			return "";
		}
		return "listaClientes";
	}

	public String getClienteId() {
		return clienteId;
	}

	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	public String getSequencia() {
		return sequencia;
	}

	public void setSequencia(String sequencia) {
		this.sequencia = sequencia;
	}

}
