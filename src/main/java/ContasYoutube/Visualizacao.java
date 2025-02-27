package ContasYoutube;

import java.util.Scanner;

public class Visualizacao {
	
	Scanner entrada = new Scanner(System.in);
	
	protected int id;
	protected Inscritos espectador;
	protected Video video;
	
	public Visualizacao() {
		
	}
	
	public Visualizacao(Inscritos espectador, Video video) {
		this.espectador = espectador;
		this.video = video;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Inscritos getEspectador() {
		return espectador;
	}
	
	public void setEspectador(Inscritos espectador) {
		this.espectador = espectador;
	}
	
	public Video getVideo() {
		return video;
	}
	
	public void setVideo(Video filme) {
		this.video = filme;
	}
	
	public void avaliar() {
		this.getVideo().setAvaliacao(5);
		
	}
	
	public void avaliar(int nota) {
		if(nota == 1) {
			this.video.setAvaliacao(1);
			System.out.println("Vídeo muito ruim!");
		
		} else if(nota == 2){
			this.video.setAvaliacao(2);
			System.out.println("Vídeo ruim!");
			
		} else if(nota == 3) {
			this.video.setAvaliacao(3);
			System.out.println("Vídeo mediano!");
		
		} else if(nota == 4){
			this.video.setAvaliacao(4);
			System.out.println("Vídeo bom!");
			
		} else if(nota == 5) {
			this.video.setAvaliacao(5);
			System.out.println("Vídeo muito bom!");
		
		} else {
			System.out.println("Opção inválida! Digite de 1 a 5");
			
		}	
	}
	
	public void avaliar(double porcentagem) {
		int total = 0;
		
		if (porcentagem <= 20) {
			total = 1;
			System.out.println("Vídeo ruim!");
			
		} else if (porcentagem <= 50) {
			total = 3;
			System.out.println("Vídeo mediano!");
		
		}else if (porcentagem <= 90) {
			total = 4;
			System.out.println("Vídeo bom!");
		
		} else {
			total = 5;
			System.out.println("Vídeo muito bom!");
		
		}
		this.video.setAvaliacao(total);
	
	}
	
	public void comecarVideo() {
		while (true) {
			System.out.println("Digite o que deseja fazer \n 1- PLAY \n 2- PAUSE \n 3- LIKE \n 4- AVALIAR POR NOTA \n 5- AVALIAR POR PORCENTAGEM \n 6- SAIR");
			int escolha = entrada.nextInt();

			if (escolha == 1) {
				this.video.setViews(this.video.getViews() + 1);
				this.espectador.setTotalAssistindo(this.espectador.getTotalAssistindo() + 1);
				this.video.play();
				System.out.println("Vídeo Reproduzindo!");
				System.out.println("\n");
				
			} else if (escolha == 2) {
				this.video.pause();
				System.out.println("Vídeo Pausasdo!");
				System.out.println("\n");
				
			} else if (escolha == 3) {
				this.video.like();
				System.out.println("Like no vídeo!");
				System.out.println("\n");
				
			} else if (escolha == 4) {
				System.out.println("Avalie o vídeo de 1 a 5");
				int avaliarPorNota = entrada.nextInt();
				this.avaliar(avaliarPorNota);
				System.out.println("Vídeo avaliado com " + avaliarPorNota);
				System.out.println("\n");
				
			} else if (escolha == 5) {
				System.out.println("Avalie o vídeo de 0 a 100");
				double avaliarPorPorcentagem = entrada.nextInt();
				this.avaliar(avaliarPorPorcentagem);
				System.out.println("Vídeo avaliado com " + avaliarPorPorcentagem);
				System.out.println("\n");
				
			} else if (escolha == 6) {
				break;
				
			} else {
				System.out.println("Opção Inválida! Escolha entre 1 a 5");
				
			}
			
		}
	}
	
	@Override
	public String toString() {
		return "Visualizacao [espectador = " + espectador.getId() + ",\n video = " + video.getId() + "]";
	}
	
}
