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
				jogo.setNome(rs.getString("nome"));
				listaJogos.add(jogo);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaJogos;

	}

	public void salvarJogo(Jogo jogo) {
		
		System.out.println("chegou no dao o jogo: "+jogo.getNome());

		String sql = "insert into jogo (nome) values (?)";
		try {
			java.sql.PreparedStatement stmt = conexao().prepareStatement(sql);
		stmt.setString(1, jogo.getNome());
		stmt.execute();
		stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
