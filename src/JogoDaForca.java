import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class JogoDaForca{

	public JogoDaForca() {
		ArrayList<String> palavras = new ArrayList<>();
		ArrayList<String> dicas = new ArrayList<>();
		
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
		//incompleto
	}
	
	public String getDica() {
		return null;
		//incompleto
	}
	
	public String getPalavra() {
		return null;
		//incompleto
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

