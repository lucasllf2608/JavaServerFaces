package br.com.jsf.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.sun.faces.spi.SerializationProvider;

import br.com.jsf.dao.JogoDao;
import br.com.jsf.model.Jogo;
import br.com.jsf.util.ConexaoBd;

@ManagedBean
@SessionScoped
public class JogoBean implements Serializable {

	private Jogo jogo = new Jogo();
	public static JogoDao jd = new JogoDao();
	private ArrayList<Jogo> listJogos;
	

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

		this.listJogos = jd.listarJogos();
		return listJogos;
	}
	
	
	
	public void salva(Jogo jogo){
	
		System.out.println(jogo.toString());
		jd.salvarJogo(jogo);
		
	}
	
	
	public void excluir(int id){
		System.out.println("chegou:"+ id);
		jd.excluirJogo(id);
	}
		
	

}
