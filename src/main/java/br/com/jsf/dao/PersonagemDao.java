package br.com.jsf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.jsf.model.Personagem;
import br.com.jsf.util.ConexaoBd;

public class PersonagemDao {
	
	public static java.sql.Connection conexao() {

		Connection connetion;
		return connetion = ConexaoBd.getConexao();

	}
	
	
	public ArrayList<Personagem> listarPersonagens(){
		ArrayList<Personagem> personagens = new ArrayList<Personagem>();
		conexao();
		
		String sql = "select * from tb_personagem";
		
		try {
			
			java.sql.PreparedStatement stmt = conexao().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Personagem p = new Personagem();
				p.setId(rs.getInt("ci_personagem"));
				p.setNome(rs.getString("nome"));
				p.setHistoria(rs.getString("historia"));
				p.setHabilidade(rs.getString("habilidades"));
				personagens.add(p);
			}
			
			rs.close();
			stmt.close();
			conexao().close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return personagens;
	}
	
	public void salvarPersonagem(Personagem personagem) {
		if(personagem.getId() == null) {
				String sql = "insert into tb_personagem (nome, habilidades, historia) values (?,?,?)";
				try {
					
					PreparedStatement stmt = conexao().prepareStatement(sql);
					stmt.setString(1, personagem.getNome());
					stmt.setString(2, personagem.getHabilidade());
					stmt.setString(3, personagem.getHistoria());
					stmt.execute();
					stmt.close();
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				
		}else {
			
		}
	}
	

}
