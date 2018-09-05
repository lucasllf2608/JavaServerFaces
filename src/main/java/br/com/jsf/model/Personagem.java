package br.com.jsf.model;

public class Personagem {
	
	private Integer id;
	private String nome;
	private String habilidade;
	private String historia;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getHabilidade() {
		return habilidade;
	}
	public void setHabilidade(String habilidades) {
		this.habilidade = habilidade;
	}
	public String getHistoria() {
		return historia;
	}
	public void setHistoria(String historia) {
		this.historia = historia;
	}
	
	
	@Override
	public String toString() {
		return "Personagem [id=" + id + ", nome=" + nome + ", habilidade=" + habilidade + ", historia=" + historia
				+ "]";
	}
	

}
