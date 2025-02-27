package Repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import BancoDeDados.DatabaseConnection;
import ContasYoutube.Visualizacao;
import ContasYoutube.Inscritos;
import ContasYoutube.Video;

public class RepositorioVisualizacao {
	
	public void salvarVizualizacao (Visualizacao visualizacao) {
		
		String sql = "INSERT INTO visualizacao (espectador, video_rodando) VALUES (?, ?)";
		
		try (Connection conexao = DatabaseConnection.conectar();
			PreparedStatement execucao = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
			
			execucao.setInt(1, visualizacao.getEspectador().getId());
			execucao.setInt(2, visualizacao.getVideo().getId());
			System.out.println(execucao.toString());
			execucao.executeUpdate();
			
			
			ResultSet gerandoId = execucao.getGeneratedKeys();
			if (gerandoId.next()) {
				visualizacao.setId(gerandoId.getInt(1));
				
			}
			
			Inscritos inscritos = new Inscritos();
			Video video = new Video();
			
			System.out.println("Visualizacao do Vídeo " + video.getTitulo() + ", com o usuario "+ inscritos.getLogin() + " salvo com o Id " + visualizacao.getId());
			
		} catch(SQLException e) {
			e.printStackTrace();
		
		}
	}
	
	public List<Visualizacao> buscarTodasVisualizacoes(){
		List<Visualizacao> visualizacao = new ArrayList<>();
	
		String sql = "SELECT * FROM visualizacao";
		
		try (Connection conexao = DatabaseConnection.conectar();
			PreparedStatement execucao = conexao.prepareStatement(sql);
			ResultSet execucaoQuery = execucao.executeQuery()){
			
			while(execucaoQuery.next()) {
				
				Visualizacao visualizacoes = new Visualizacao();
				visualizacoes.setId(execucaoQuery.getInt("id"));
				
				Inscritos inscritos = new Inscritos();
				inscritos.setId(execucaoQuery.getInt("espectador"));
				visualizacoes.setEspectador(inscritos);
				
				Video video = new Video();
				video.setId(execucaoQuery.getInt("video_rodando"));		
				visualizacoes.setVideo(video);
				
				visualizacao.add(visualizacoes);

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return visualizacao;
	}
	
	public Visualizacao buscarVisualizacaoPorId(int id) {
		
		String sql = "SELECT * FROM visualizacao WHERE id = ?";
		Visualizacao visualizacao = null;
		
		try (Connection conexao = DatabaseConnection.conectar();
			PreparedStatement execucao = conexao.prepareStatement(sql)) {
			
			execucao.setInt(1, id);
			
			try(ResultSet execucaoQuery = execucao.executeQuery()){
				if (execucaoQuery.next()) {
					int espectadorId = execucaoQuery.getInt("espectador");
					int videoId = execucaoQuery.getInt("video_rodando");
					
					visualizacao = new Visualizacao();
					visualizacao.setId(execucaoQuery.getInt("id"));
					
					RepositorioInscritos repositorioInscritos = new RepositorioInscritos();
					Inscritos inscritos = repositorioInscritos.buscarInscritosPorId(espectadorId);
					visualizacao.setEspectador(inscritos);
					
					RepositorioVideo repositorioVideo = new RepositorioVideo(); 
					Video video = repositorioVideo.buscarVideosporId(videoId);
					visualizacao.setVideo(video);
					
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		
		return visualizacao;
		
	}
	
	
}
