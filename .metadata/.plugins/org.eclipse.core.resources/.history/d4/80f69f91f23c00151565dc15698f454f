package br.com.simonini.utils;

import static javax.faces.context.FacesContext.getCurrentInstance;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;

public class ScreenUtils {
	/**
	 * @param chave do arquivo properties
	 * @return Texto criado no arquivo properties
	 */
	public static String getMessageFromI18N(String key) {
		ResourceBundle bundle = ResourceBundle.getBundle("screen_text", getCurrentInstance().getViewRoot().getLocale());
		return bundle.getString(key);
	}
	
	/**
	 * Adiciona um mensagem no contexto do Faces
	 * @param summary
	 * @param detail
	 */
	public static void addMessage(String summary, String detail) {
		getCurrentInstance().addMessage(null, new FacesMessage(summary, summary.concat("<br/>").concat(detail)));
	}
}
