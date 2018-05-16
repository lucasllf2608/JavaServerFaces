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
				jogo.setTipoJogo(rs.getString("tp_jogo"));
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

		if (jogo.getId() == null) {
			System.out.println("novo");

			System.out.println("chegou no dao o jogo: " + jogo.getTipoJogo());

			String sql = "insert into jogo (nome, descricao, tp_jogo) values (?,?,?)";
			try {
				java.sql.PreparedStatement stmt = conexao().prepareStatement(sql);
				stmt.setString(1, jogo.getNome());
				stmt.setString(2, jogo.getDescricao());
				stmt.setString(3, jogo.getTipoJogo());
				stmt.execute();
				stmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

			}

		} else {

			System.out.println("chegou no dao o jogo: " + jogo.getNome());

			String sql = "UPDATE jogo SET nome = ?, descricao = ?, tp_jogo = ? WHERE id = ? ";
			try {
				java.sql.PreparedStatement stmt = conexao().prepareStatement(sql);
				stmt.setString(1, jogo.getNome());
				stmt.setString(2, jogo.getDescricao());
				stmt.setString(3, jogo.getTipoJogo());
				stmt.setInt(4, jogo.getId());
				stmt.execute();
				stmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

			}

		}

		ConexaoBd.fecharConexao();
	}

	public boolean findGame(Jogo jogo) {

		boolean status = false;
		String sql = "Select * from jogo";

		try {
			java.sql.PreparedStatement stmt = conexao().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt("id") == jogo.getId()) {
					System.out.println("jogo encontrado");
					status = true;
				} else {
					System.out.println("não encontrado");
					status = false;
				}
			}

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;

	}

	public void excluirJogo(int id) {

		String sql = "DELETE FROM jogo WHERE id = ?";

		System.out.println("excluindo:" + id);

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
