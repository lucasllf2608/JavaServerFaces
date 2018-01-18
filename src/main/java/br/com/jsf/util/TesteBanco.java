package br.com.jsf.util;

import br.com.jsf.dao.JogoDao;

public class TesteBanco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConexaoBd conn = new ConexaoBd();
		
		System.out.println(conn.getStatusConexao());
		conn.getConexao();
		System.out.println(conn.getStatusConexao());
		
		
		JogoDao jd = new JogoDao();
		
		System.out.println(jd.listarJogos().size());
		
		
	}

}
