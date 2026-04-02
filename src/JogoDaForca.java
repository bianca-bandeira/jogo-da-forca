import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class JogoDaForca{
	private String palavra;
	private String dica;

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public void setDica(String dica) {
		this.dica = dica;
	}

	public String getDica() {
		return dica;
	}

	public String getPalavra() {
		return palavra;
	}

	ArrayList<String> palavras = new ArrayList<>();
	ArrayList<String> dicas = new ArrayList<>();

	public JogoDaForca() {
		
		InputStream stream = this.getClass().getResourceAsStream("/dados/palavras.txt");
		if (stream == null) {
		JOptionPane.showMessageDialog(null, "Arquivo de palavras inexistente!");
			System.exit(0);
		}
		Scanner arquivo = new Scanner(stream);
		String linha;
		while (arquivo.hasNext()) {
			linha = arquivo.nextLine();
			String[] divisao = linha.split(";");
			palavras.add(divisao[0]);
			dicas.add(divisao[1]);
		}
		arquivo.close();
		System.out.println(palavras);
		System.out.println(dicas);
	}
	
	public static void main(String[] args) {
		new JogoDaForca();
	}
	
	public void iniciar() {
		Random sorteio = new Random();
		int numero = sorteio.nextInt(0,palavras.size());

		String palavra_sorteada = palavras.get(numero);
		setPalavra(palavra_sorteada);

		String dica_sorteada = dicas.get(numero);
		setDica(dica_sorteada);
	}

	
	public ArrayList<String> getResultados() {
		return null;
		//incompleto
	}
	
	public ArrayList<Integer> getOcorrencias(String letra) throws Exception {
		return null;
		//incompleto
	}
	
	public boolean terminou() {
		return false;
		//incompleto
	}
	
	public int getAcertos() {
		return 0;
		//incompleto
	}
	
	public int getCodigoPenalidade() {
		return 0;
		//incompleto
	}
	
	public String getNomePenalidade() {
		return null;
		//incompleto
	}
	
	public String getResultado() {
		return null;
		//incompleto
	}
}

