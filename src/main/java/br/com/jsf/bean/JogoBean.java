package br.com.jsf.bean;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;

import com.sun.faces.spi.SerializationProvider;

import br.com.jsf.dao.JogoDao;
import br.com.jsf.model.Jogo;
import br.com.jsf.util.ConexaoBd;

@ManagedBean(name="jogoBean")
@RequestScoped
public class JogoBean implements Serializable {

	private Jogo jogo = new Jogo();
	private JogoDao jogoDao = new JogoDao();
	private ArrayList<Jogo> listJogos;
	
// opa
	public ArrayList<Jogo> getListJogos() {
		return listJogos;
	}

	public void setListJogos(ArrayList<Jogo> listJogos) {
		this.listJogos = listJogos;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public List<Jogo> getListarJogos() throws SQLException {

		this.listJogos = jogoDao.listarJogos();
		return listJogos;
	}
	

	public String salva(Jogo jogo){	
		System.out.println(jogo.toString());
		jogoDao.salvarJogo(jogo);
		return "jogo.jsf";		
	}

	
	public void excluir(int id){
		System.out.println("chegou, excluir:"+ id);
		jogoDao.excluirJogo(id);
	}
		
	
	public String editar(Jogo jogo){
		System.out.println("chegou,  "+jogo.toString());
		this.setJogo(jogo);
		return "cadastro.jsf";
		
	}
	
	   public void addMessage(String summary, String detail) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	

}
