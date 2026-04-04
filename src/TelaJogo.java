import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class TelaJogo {

	private JFrame frame;
	private JButton iniciarButton;
	private JLabel acertosLabel;
	private JogoDaForca jogo;
	private JLabel penalidadeLabel;
	private JLabel dicaLabel;
	private JLabel letraLabel;
	private JTextField tentativaField;
	private JButton adivinharButton;
	private JTextArea textArea;
	private JLabel palavraLabel;
	private JLabel imagemLabel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaJogo window = new TelaJogo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaJogo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		jogo = new JogoDaForca();
		frame = new JFrame();
		frame.setTitle("Jogo da Forca");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		iniciarButton = new JButton("Iniciar");
		iniciarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Precisa iniciar botão adivinhar
				jogo.iniciar();
				jogo.setAcertos(0);
				jogo.setCodigoPenalidades(0);
				
				String acertosTexto = "Acertos: 0";
				acertosLabel.setText(acertosTexto);
				
				String penalidadeTexto = "Penalidade: 0";
				penalidadeLabel.setText(penalidadeTexto);
				
				adivinharButton.setEnabled(true);
				
				String dicaSorteada = "Dica: " + jogo.getDica();
				dicaLabel.setText(dicaSorteada);
				
				String palavraEscondida = new String(jogo.getPalavraSecreta());
				String palavraSorteada = "palavra=" + palavraEscondida;
				palavraLabel.setText(palavraSorteada);
			}
		});
		iniciarButton.setBounds(31, 30, 84, 20);
		frame.getContentPane().add(iniciarButton);
		
		acertosLabel = new JLabel("");
		acertosLabel.setForeground(new Color(0, 255, 0));
		acertosLabel.setBounds(125, 30, 61, 20);
		frame.getContentPane().add(acertosLabel);
		
		penalidadeLabel = new JLabel("");
		penalidadeLabel.setForeground(new Color(255, 0, 0));
		penalidadeLabel.setBounds(196, 34, 216, 12);
		frame.getContentPane().add(penalidadeLabel);
		
		dicaLabel = new JLabel("Dica:");
		dicaLabel.setBounds(31, 60, 231, 20);
		frame.getContentPane().add(dicaLabel);
		
		letraLabel = new JLabel("Letra:");
		letraLabel.setBounds(31, 93, 42, 12);
		frame.getContentPane().add(letraLabel);
		
		tentativaField = new JTextField();
		tentativaField.setBounds(83, 90, 27, 18);
		frame.getContentPane().add(tentativaField);
		tentativaField.setColumns(10);
		
		adivinharButton = new JButton("Adivinhar");
		adivinharButton.setEnabled(false);
		adivinharButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tentativa = tentativaField.getText();
				if(!(tentativa.isEmpty())){
									//jogo.setTentativa(tentativaChar)
					try {
						//Revelar as letras corretas
						jogo.setTentativa(tentativa);
						ArrayList<Integer> posicoesCorretas = jogo.getOcorrencias(tentativa);
						int tamanho = posicoesCorretas.size();
						for(int i = 0;i < tamanho;i++) {
							int posicao = posicoesCorretas.get(i);
							jogo.setPalavraSecreta(tentativa,posicao);
						}
						String palavraEscondida = new String(jogo.getPalavraSecreta());
						
						String palavraSorteada = "palavra=" + palavraEscondida;
						palavraLabel.setText(palavraSorteada);

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					textArea.setText("campo vazio");
				}
				
				String acertosTexto = "Acertos: " + Integer.toString(jogo.getAcertos());
				acertosLabel.setText(acertosTexto);
				
				String penalidadeTexto = "Penalidade: " + Integer.toString(jogo.getCodigoPenalidade());
				penalidadeLabel.setText(penalidadeTexto);
				
			}
				
		});
		adivinharButton.setBounds(125, 89, 107, 20);
		frame.getContentPane().add(adivinharButton);
		
		textArea = new JTextArea();
		textArea.setBounds(25, 232, 198, 21);
		frame.getContentPane().add(textArea);
		
		palavraLabel = new JLabel("palavra=");
		palavraLabel.setBounds(31, 123, 152, 20);
		frame.getContentPane().add(palavraLabel);
		
		imagemLabel = new JLabel("");
		imagemLabel.setBounds(256, 52, 170, 172);
		frame.getContentPane().add(imagemLabel);
		
	}
}
