import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class JogoDaForca{
	private String palavra;
	private String dica;
	private Integer acertos = 0;
	private Integer codigoPenalidades = 0;
	private ArrayList<String> resultados = new ArrayList<String>();

	public void setResultados(String novoResultado) {
		resultados.add(novoResultado);
	}
	
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
	
	public 

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
		return resultados;
	}
	
	public ArrayList<Integer> getOcorrencias(String letra) throws Exception {
		//checar se letra ja foi chutada
			if(letra.length() != 1){ //lembrar de verificar também se o caracter é uma letra mesmo
				if(letra.length() == 0) {
					setResultados("campo vazio");
				}else if(letra.length() > 1) {
					setResultados("a letra possui mais de um caractere");
				}
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
				setResultados("errou a letra " + letra);
			} else {
				int corretos = posicoes.size();
				setAcertos(corretos + getAcertos());
				setResultados("acertou a letra " + letra);
			}
		//System.out.println(acertos);
		return posicoes;
	}
	
	public boolean terminou() {
		if(getCodigoPenalidade() >= 6) {
			return true;
			//caso o jogador perca
		}else if(true /*incompleto*/) {
			//caso o jogador ganhe
		}
		//caso nenhum aconteça
		return false;
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
		int tam = getResultados().size();
		return getResultados().get(tam-1);
	}
}

