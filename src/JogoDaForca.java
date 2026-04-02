import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class JogoDaForca{
	private String palavra;
	private String dica;
	private Integer acertos = 0;
	private Integer codigoPenalidades = 0;

	public void setAcertos(Integer acertos) {
		this.acertos = acertos;
	}

	public void setCodigoPenalidades(Integer codigoPenalidades) {
		this.codigoPenalidades = codigoPenalidades;
	}

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

		String palavraSorteada = palavras.get(numero);
		setPalavra(palavraSorteada);

		String dicaSorteada = dicas.get(numero);
		setDica(dicaSorteada);
	}

	
	public ArrayList<String> getResultados() {
		return null;
		//incompleto
	}
	
	public ArrayList<Integer> getOcorrencias(String letra) throws Exception {
			if(letra.length() != 1){ //lembrar de verificar também se o caracter é uma letra mesmo
				throw new Exception("Caractere inválido");
			}
			ArrayList<Integer> posicoes = new ArrayList<>();
			letra = letra.toUpperCase(); // Deixa a letra maiúscula
			int posicao = 0; // vai ser o contador

			for(char c : palavra.toCharArray()){
				String letraAtual = String.valueOf(c); //transforma o c(char) em string
				if (letraAtual.equals(letra)){
					posicoes.add(posicao);
				}
				posicao++;
			}

			if(posicoes.isEmpty()){
				int erros = getCodigoPenalidade();
				setCodigoPenalidades(erros+1);
			} else {
				int corretos = posicoes.size();
				setAcertos(corretos);
			}
		return posicoes;
	}
	
	public boolean terminou() {
		return false;
		//incompleto
	}
	
	public int getAcertos() {
		return acertos;
	}
	
	public int getCodigoPenalidade() {
		return codigoPenalidades;
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

