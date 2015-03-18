import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Document;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JProgressBar;


public class paaikkuna extends JFrame {

	private JPanel contentPane;
	private static JTextField textFieldSyota;
	private static JTextArea textAreaTulostus;
	private static String alkup = "ALKUP ";
	private static String kysymys = "Mikä on oikea vaihtoehto?\n 1. moi\n 2. hei\n 3. terve";
	

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					paaikkuna frame = new paaikkuna();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//Tutkii onko hakuehto sama kuin nettisivun teksti
	public static String haeSysteeminTiedot(String haku) throws IOException {
		
        //Mitä webbisivua luetaan
		URL nettisivu = new URL("http://gunni.arkku.net/Tuskar%20-%20kaikki.txt");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(nettisivu.openStream()));
        
        //tehdään stringbuilder vertaamista varten
        StringBuilder hakuehto = new StringBuilder(haku);
        StringBuilder tiedosto = new StringBuilder(in.readLine());
        
     //     System.out.println(hakuehto.toString());
     //    System.out.println(tiedosto.toString());
          
       //   System.out.println(tiedosto.append(line));
        
        //Verrataan onko syötetty teksti sama kuin nettisivun teksti
          if(hakuehto.toString().equals(tiedosto.toString())) {        	
         	return "Oikein";
           	}
         else return "VäärinFD";
         }       		

	/**
	 * Create the frame.
	 */
	public paaikkuna() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		textFieldSyota = new JTextField();
		textFieldSyota.setBounds(70, 93, 86, 20);
		panel.add(textFieldSyota);
		textFieldSyota.setColumns(10);
		
		JLabel lblSytSysteemi = new JLabel("Arvaa oikein");
		lblSytSysteemi.setBounds(70, 62, 106, 20);
		panel.add(lblSytSysteemi);
		
		
		// Kun klikataan send nappia, tulostaa tekstikentän sisällön
		JButton btnSend = new JButton("Send");
			btnSend.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent arg0) {
							
			//	textAreaTulostus.setText();			
			//	textAreaTulostus.setText(alkup + textFieldSyota.getText()+ " ");
				alkup = textAreaTulostus.getText();
				try {
					textAreaTulostus.setText(kysymys +"\n" +"\n"+ haeSysteeminTiedot(textFieldSyota.getText()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			}
		});
		btnSend.setBounds(166, 92, 89, 23);
		panel.add(btnSend);
		
		textAreaTulostus = new JTextArea();		
		textAreaTulostus.setText(kysymys);
		textAreaTulostus.setEditable(false);
		textAreaTulostus.setBounds(70, 139, 363, 109);
		panel.add(textAreaTulostus);
		
	
	}
}
