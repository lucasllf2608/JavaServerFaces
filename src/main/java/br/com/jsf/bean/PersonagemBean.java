package br.com.jsf.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.jsf.dao.PersonagemDao;
import br.com.jsf.model.Personagem;

@ManagedBean(name="personagembean")
@RequestScoped
public class PersonagemBean implements Serializable {

	private Personagem personagem;
	private PersonagemDao pDao = new PersonagemDao();
	private ArrayList<Personagem> personagens = new ArrayList<Personagem>();

	public Personagem getPersonagem() {
		return personagem;
	}

	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
		
	}
	
	
	public Date getAgora() {
		return new Date();
	}

	public ArrayList<Personagem> getPersonagens() {
		return personagens;
	}

	public void setPersonagens(ArrayList<Personagem> personagens) {
		this.personagens = personagens;
	}
	
	public List<Personagem> getListaPersonagem(){

	this.personagens = pDao.listarPersonagens();
	return personagens;
	}
	
	
	public void salva(PersonagemBean personagem) {
		
		
	}
	
	public void teste() {
		
	}

}
