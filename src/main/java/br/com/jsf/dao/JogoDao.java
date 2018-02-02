package br.com.jsf.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.com.jsf.model.Jogo;
import br.com.jsf.util.ConexaoBd;

public class JogoDao {

	// public static Jogo jogo = new Jogo();

	public static java.sql.Connection conexao() {

		Connection connetion;
		return connetion = ConexaoBd.getConexao();
				
	}
		

	public ArrayList<Jogo> listarJogos() {

		ArrayList<Jogo> listaJogos = new ArrayList();

		conexao();

		String sql = "Select * from jogo";
		try {

			java.sql.PreparedStatement stmt = conexao().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				Jogo jogo = new Jogo();
				jogo.setId(rs.getInt("id"));
				jogo.setNome(rs.getString("nome"));
				jogo.setDescricao(rs.getString("descricao"));
				listaJogos.add(jogo);

			}
			
			
			rs.close();
			stmt.close();
			conexao().close();
			
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

		return listaJogos;

	}

	public void salvarJogo(Jogo jogo) {
		
		System.out.println("chegou no dao o jogo: "+jogo.getNome());

		String sql = "insert into jogo (nome, descricao) values (?,?)";
		try {
			java.sql.PreparedStatement stmt = conexao().prepareStatement(sql);
		stmt.setString(1, jogo.getNome());
		stmt.setString(2, jogo.getDescricao());
		stmt.execute();
		stmt.close();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		
		
		ConexaoBd.fecharConexao();
	}
	
	
	public void excluirJogo(int id){
		
		String sql = "DELETE FROM jogo WHERE id = ?";
		
		System.out.println("excluindo:"+ id);
		
		try {
			
			java.sql.PreparedStatement stmt = conexao().prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
			conexao().close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
