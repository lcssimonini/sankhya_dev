package br.com.simonini.utils;

import static javax.faces.context.FacesContext.getCurrentInstance;

import javax.faces.application.FacesMessage;

public class SimoUtils {

	public static void addMessage(String summary, String detail) {
		getCurrentInstance().addMessage(null, new FacesMessage(summary, summary.concat("<br/>").concat(detail)));
	}
}
