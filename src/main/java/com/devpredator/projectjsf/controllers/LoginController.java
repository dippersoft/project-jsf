package com.devpredator.projectjsf.controllers;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

//clase que permite controllar el comportamiento de la pantalla de login.xhtml

@ManagedBean
public class LoginController {

	private String usuario;

	private String password;

	public void ingresar() {
		if (this.getUsuario().equals("devpredator") && this.getPassword().equals("12345")) {
//			FacesContext.getCurrentInstance().addMessage("formlogin:txtUsuario", new FacesMessage(FacesMessage.SEVERITY_INFO,"usuario correcto",""));

			try {
				this.redireccionar("principal.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				FacesContext.getCurrentInstance().addMessage("formlogin:txtUsuario",
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "La pagina no existe", ""));
				e.printStackTrace();
			}
		} else {
			FacesContext.getCurrentInstance().addMessage("formlogin:txtUsuario",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "usuario INCORRECTOF", ""));
		}

		System.out.println("Usuario: " + this.getUsuario());
	}
	
	private void redireccionar(String pagina) throws IOException {
		ExternalContext ec=FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(pagina);
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
