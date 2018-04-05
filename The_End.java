import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class The_End {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					The_End window = new The_End();
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
	public The_End() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel The_End = new JLabel("");
		The_End.setHorizontalAlignment(SwingConstants.CENTER);
		The_End.setBounds(159, 91, 122, 33);
		panel.add(The_End);
		
		if(Main3.player1.score >= 100)
		{
			The_End.setText(Main3.player1.name + " win!");
		}
		else
		{
			The_End.setText(Main3.player2.name + " win!");
		}
		
		JButton Exit = new JButton("Exit");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		Exit.setBounds(115, 169, 100, 33);
		panel.add(Exit);
		
		JButton Play_Again = new JButton("Play Again");
		Play_Again.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Main3.main(null);
			}
		});
		Play_Again.setBounds(225, 169, 100, 33);
		panel.add(Play_Again);
	}
}
