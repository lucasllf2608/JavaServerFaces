package br.com.jsf.util;

public class TesteBanco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConexaoBd conn = new ConexaoBd();
		
		System.out.println(conn.getStatusConexao());
		conn.getConexao();
		System.out.println(conn.getStatusConexao());
		
		
	}

}
