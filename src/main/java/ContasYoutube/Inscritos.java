package ContasYoutube;

public class Inscritos extends Pessoa {
		
	protected int id;
	protected String login;
	protected int totalAssistido;
	
	public Inscritos(String nome, int idade, String sexo, String login) {
		super(nome, idade, sexo);
		this.login = login;
		this.totalAssistido = 0;
	}

	public Inscritos() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public int getTotalAssistindo() {
		return totalAssistido;
	}
	public void setTotalAssistindo(int totalAssistido) {
		this.totalAssistido = totalAssistido;
	}
	
	public void viuMaisUm() {
		this.setTotalAssistindo(this.getTotalAssistindo() + 1);
		
	}

	@Override
	public String toString() {
		return "Inscritos:\n nome = " + this.getNome() + ",\n idade = " + this.getIdade() + ",\n sexo = " + this.getSexo() + 
				", \n login = " + login + ",\n totAssistindo = " + totalAssistido + "\n";
	}
	
	
	
}
