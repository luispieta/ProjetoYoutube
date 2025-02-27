package Repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import BancoDeDados.DatabaseConnection;
import ContasYoutube.Inscritos;

public class RepositorioInscritos {
	
	public void salvarInscritos(Inscritos inscrito) {
	
		String sql = "INSERT INTO inscritos (usuario, nome, idade, sexo, totalAssistido) VALUES (?, ?, ?, ?, ?)";
		
		try (Connection conexao = DatabaseConnection.conectar();
			PreparedStatement execucao = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
		
			execucao.setString(1, inscrito.getLogin());
			execucao.setString(2, inscrito.getNome());
			execucao.setInt(3, inscrito.getIdade());
			execucao.setString(4, inscrito.getSexo());
			execucao.setInt(5, inscrito.getTotalAssistindo());
			execucao.executeUpdate();
			
			ResultSet gerandoId = execucao.getGeneratedKeys();
			if (gerandoId.next()) {
				inscrito.setId(gerandoId.getInt(1));
			}
			
			System.out.println("Inscrito " + inscrito.getNome() + " salvo pelo ID " + inscrito.getId());
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
		
	public List<Inscritos> buscarTodosInscritos() {
		List<Inscritos> inscrito = new ArrayList<>();
		String sql = "SELECT * FROM inscritos";
		
		try (Connection conexao = DatabaseConnection.conectar();
			PreparedStatement execucao = conexao.prepareStatement(sql);
			ResultSet execucaoQuery = execucao.executeQuery()) {
			
			while(execucaoQuery.next()) {
				Inscritos inscritos = new Inscritos();
				inscritos.setId(execucaoQuery.getInt("id"));
				inscritos.setLogin(execucaoQuery.getString("usuario"));
				inscritos.setNome(execucaoQuery.getString("nome"));
				inscritos.setIdade(execucaoQuery.getInt("idade"));
				inscritos.setSexo(execucaoQuery.getString("sexo"));
				inscritos.setTotalAssistindo(execucaoQuery.getInt("totalAssistido"));
				inscrito.add(inscritos);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		
		return inscrito;
	}
	
	public Inscritos buscarInscritosPorId(int id) {
		String sql = "SELECT * FROM inscritos WHERE id = ?";
		Inscritos inscrito = null;
		
		try (Connection conexao = DatabaseConnection.conectar();
			PreparedStatement execucao = conexao.prepareStatement(sql)) {
			
			execucao.setInt(1, id);
			try (ResultSet execucaoQuery = execucao.executeQuery()) {
				if (execucaoQuery.next()) {
					inscrito = new Inscritos();
					inscrito.setId(execucaoQuery.getInt("id"));
					inscrito.setLogin(execucaoQuery.getString("usuario"));
					inscrito.setNome(execucaoQuery.getString("nome"));
					inscrito.setIdade(execucaoQuery.getInt("idade"));
					inscrito.setSexo(execucaoQuery.getString("sexo"));
					inscrito.setTotalAssistindo(execucaoQuery.getInt("totalAssistido"));
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return inscrito;
	}
	
	public void editarValores(Inscritos inscritos) {
		
		String sql = "UPDATE inscritos SET usuario = ?, nome = ?, idade = ?, sexo = ?, totalAssistido = ? WHERE id = ?";
		
		try (Connection conexao = DatabaseConnection.conectar();
			PreparedStatement execucao = conexao.prepareStatement(sql)) {
			
			execucao.setString(1, inscritos.getLogin());
			execucao.setString(2, inscritos.getNome());
			execucao.setInt(3, inscritos.getIdade());
			execucao.setString(4, inscritos.getSexo());
			execucao.setInt(5, inscritos.getTotalAssistindo());
			execucao.setInt(6, inscritos.getId());
			execucao.execute();			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}
	
}
