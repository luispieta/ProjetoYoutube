package MainVideos;


import Repositorios.RepositorioVideo;
import Repositorios.RepositorioVisualizacao;
import Repositorios.RepositorioInscritos;
import ContasYoutube.Inscritos;
import ContasYoutube.Video;
import ContasYoutube.Visualizacao;

public class MainPrincipal {

	public static void main(String[] args) {

		RepositorioVideo repositorioVideo = new RepositorioVideo();
		RepositorioInscritos repositorioInscrito = new RepositorioInscritos();
		RepositorioVisualizacao repositorioVisu = new RepositorioVisualizacao();
		
		Video cursoHtml5 = new Video("Curso de HTML 5");
		repositorioVideo.salvarVideo(cursoHtml5);
		
		Video cursoPython = new Video("Curso de Python");
		repositorioVideo.salvarVideo(cursoPython);
		
		Video cursoC = new Video("Curso de C#");
		repositorioVideo.salvarVideo(cursoC);
		
		Inscritos inscrito1 = new Inscritos("Luis", 18, "mascul", "Pieta");
		repositorioInscrito.salvarInscritos(inscrito1);	
		
		Inscritos inscrito2 = new Inscritos("Rafaela", 18, "femini", "Vascon");
		repositorioInscrito.salvarInscritos(inscrito2);	
		
		Visualizacao visu1 = new Visualizacao(inscrito2, cursoPython);
		repositorioVisu.salvarVizualizacao(visu1);
		
		Visualizacao visu2 = new Visualizacao(inscrito1, cursoC);
		repositorioVisu.salvarVizualizacao(visu2);
		
		
		//Inscritos inscrito1 = new Inscritos("Erico", 18, "mascul", "Pieta");
		//repositorioInscrito.editarValores(inscrito1);

		System.out.println(repositorioInscrito.buscarTodosInscritos());
		System.out.println(repositorioVideo.buscarTodosVideos());
		System.out.println(repositorioVisu.buscarTodasVisualizacoes());
		}
	}


