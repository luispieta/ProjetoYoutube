package Repositorios;

import ContasYoutube.Video;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import BancoDeDados.DatabaseConnection;

public class RepositorioVideo {

	public void salvarVideo(Video video){
		String sql = "INSERT INTO video (titulo, avaliacao, views, curtidas) VALUES (?, ?, ?, ?)";
		
		try (Connection conexao = DatabaseConnection.conectar();
		PreparedStatement execucao = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
			
			execucao.setString(1, video.getTitulo());
			execucao.setInt(2, video.isAvaliacao());
			execucao.setInt(3, video.getViews());
			execucao.setInt(4, video.getCurtidas());
			execucao.executeUpdate();	
			
			ResultSet gerandoId = execucao.getGeneratedKeys();
			if(gerandoId.next()) {
				video.setId(gerandoId.getInt(1));
				
			}
			
			System.out.println("Video " + video.getTitulo() + " foi salvo com ID " + video.getId());
		
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	public List<Video> buscarTodosVideos() {
		List<Video> video = new ArrayList<>();
		String sql = "SELECT * FROM video";
		
		try(Connection conexao = DatabaseConnection.conectar();
			PreparedStatement execucao = conexao.prepareStatement(sql);
			ResultSet execucaoQuery = execucao.executeQuery()) {
		
			while(execucaoQuery.next()) {
				Video videos = new Video();
				videos.setId(execucaoQuery.getInt("id"));
				videos.setTitulo(execucaoQuery.getString("titulo"));
				videos.setAvaliacao(execucaoQuery.getInt("avaliacao"));
				videos.setViews(execucaoQuery.getInt("views"));
				videos.setCurtidas(execucaoQuery.getInt("curtidas"));
				
				video.add(videos);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		
		return video;
	}
	
	public Video buscarVideosporId(int id) {
		String sql = "SELECT * FROM video WHERE id = ?";
		Video video = null;
		
		try(Connection conexao = DatabaseConnection.conectar();
			PreparedStatement execucao = conexao.prepareStatement(sql)){
			
			execucao.setInt(1, id);
			try(ResultSet execucaoQuery = execucao.executeQuery()) {
				if (execucaoQuery.next()) {
					video = new Video();
					video.setId(execucaoQuery.getInt("id"));
					video.setTitulo(execucaoQuery.getString("titulo"));
					video.setAvaliacao(execucaoQuery.getInt("avaliacao"));
					video.setViews(execucaoQuery.getInt("views"));
					video.setCurtidas(execucaoQuery.getInt("curtidas"));
					
				}
			}
			
		} catch (SQLException e){
			e.printStackTrace();
			
		}
		
		return video;
		
	}
}
