package br.com.jsf.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.jsf.model.Usuario;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable {
	
	private Usuario usuario = new Usuario();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String acessar() {
		
		System.out.println(usuario.getLogin());
		
		if(usuario.getLogin().equals("lucas") && usuario.getSenha().equals("123456")) {
			return "menu";	
		} else {
			
			FacesContext mensagem = FacesContext.getCurrentInstance();
			mensagem.addMessage(null, new FacesMessage("usuário invalido!"));
			
			return "index";
		}
		
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
