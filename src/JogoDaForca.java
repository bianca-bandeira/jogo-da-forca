import java.io.*;
import java.util.*;

public class JogoDaForca{

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
			//processar linha
		}
		arquivo.close();
		System.out.println(arquivo);
	}
	
	public void iniciar() {
		new JogoDaForca();
	}
	
}

