package br.com.simonini.managedbeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.simonini.session.ClienteBean;

@ManagedBean(name = "clienteMB")
@ViewScoped
public class ClienteMB implements Serializable{

	private static final long serialVersionUID = -8498185949884249551L;
	
	@EJB
	private ClienteBean clienteBean;
	
	public String greeting;
	
	public String getGreeting(){
		this.greeting = clienteBean.getGreeting();
		return greeting;
	}
}
