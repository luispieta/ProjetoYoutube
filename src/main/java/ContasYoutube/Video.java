package ContasYoutube;

import Interface.AcoesVideo;

public class Video implements AcoesVideo{

	private int id;
	private String titulo;
	private int avaliacao;
	private int views;
	private int curtidas;
	private boolean reproduzindo;
	
	public Video() {
		
	}
	
	public Video(String titulo) {
		this.titulo = titulo;
		this.avaliacao = 0;
		this.views = 0;
		this.curtidas = 0;
		this.reproduzindo = false;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int isAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getCurtidas() {
		return curtidas;
	}

	public void setCurtidas(int curtidas) {
		this.curtidas = curtidas;
	}

	public boolean isReproduzindo() {
		return reproduzindo;
	}

	public void setReproduzindo(boolean reproduzindo) {
		this.reproduzindo = reproduzindo;
	}

	@Override
	public void play() {
		setViews(views++);
		setReproduzindo(true);
		
	}

	@Override
	public void pause() {
		setReproduzindo(false);
		
	}

	@Override
	public void like() {
		setCurtidas(curtidas++);
		
	}

	@Override
	public String toString() {
		return "/n Video:\n titulo = " + this.getTitulo() + ",\n avaliacao = " + this.isAvaliacao() + ",\n views = " + this.getViews() + ",\n curtidas = " + this.getCurtidas()
				+ ",\n reproduzindo = " + this.getCurtidas() + "\n";
	}

}
