import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main3 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main3 window = new Main3();
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
	public Main3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static Players player1 = new Players();
	public static Players player2 = new Players();
	private JTextField Name_input;
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JPanel panel = new JPanel();
		panel.setVisible(false);
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		final JLabel P1_and_P2_names = new JLabel("");
		P1_and_P2_names.setBounds(140, 70, 150, 44);
		panel.add(P1_and_P2_names);
		
		P1_and_P2_names.setText("<html>Player #1, enter your name:</html>");
		
		Name_input = new JTextField();
		Name_input.setBounds(140, 125, 150, 20);
		panel.add(Name_input);
		Name_input.setColumns(10);
		
		final JLabel Names = new JLabel("");
		Names.setBounds(310, 70, 114, 113);
		panel.add(Names);
		
		final JButton Change_Name_1 = new JButton("<html>Change name of<br>Player #1</html>");
		Change_Name_1.setVisible(false);
		Change_Name_1.setBounds(130, 70, 170, 40);
		panel.add(Change_Name_1);
		
		final JButton Change_Name_2 = new JButton("<html>Change name of<br>Player #2</html>");
		Change_Name_2.setVisible(false);
		Change_Name_2.setBounds(130, 115, 170, 40);
		panel.add(Change_Name_2);
		
		final JButton Name_confirm = new JButton("Confirm the name");
		Name_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(player1.name.compareTo("") == 0)
				{
					player1.name = Name_input.getText();
					if(player1.name.compareTo("") != 0)
					{	
						P1_and_P2_names.setText("<html>Player #2, enter your name:</html>");
						Names.setText("<html>Player #1: " + player1.name + "</html>");
						Name_input.setText("");
					}
					if(player2.name.compareTo("") != 0)
					{
						Name_confirm.setText("Continue");
						Name_input.setVisible(false);
						P1_and_P2_names.setVisible(false);
						Change_Name_1.setVisible(true);
						Change_Name_2.setVisible(true);
						Names.setText("<html>Player #1: " + player1.name + "<br>Player #2: " + player2.name + "</html>");
					}
				}
				else if(player2.name.compareTo("") == 0)
				{
					player2.name = Name_input.getText();
					if(player2.name.compareTo("") != 0)
					{
						Names.setText("<html>Player #1: " + player1.name + "<br>Player #2: " + player2.name + "</html>");
						Name_confirm.setText("Continue");
						Name_input.setText("");
						Name_input.setVisible(false);
						P1_and_P2_names.setVisible(false);
						Change_Name_1.setVisible(true);
						Change_Name_2.setVisible(true);
					}
				}
				else
				{
					frame.dispose();
					Dice_Game.main(null);
				}
			}
		});
		Name_confirm.setBounds(140, 160, 150, 23);
		panel.add(Name_confirm);
		
		Change_Name_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Change_Name_1.setVisible(false);
				Change_Name_2.setVisible(false);
				Name_confirm.setText("Confirm name");
				Name_input.setVisible(true);
				P1_and_P2_names.setVisible(true);
				player1.name = "";
				
			}
		});
		
		Change_Name_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Change_Name_1.setVisible(false);
				Change_Name_2.setVisible(false);
				Name_confirm.setText("Confirm name");
				Name_input.setVisible(true);
				P1_and_P2_names.setVisible(true);
				player2.name = "";
			}
		});
		
		final JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton Start = new JButton("Start");
		Start.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_1.setVisible(false);
				panel.setVisible(true);
			}
		});
		Start.setBounds(170, 100, 100, 30);
		panel_1.add(Start);
	}
}
