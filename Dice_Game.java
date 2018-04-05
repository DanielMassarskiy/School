import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;

public class Dice_Game {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dice_Game window = new Dice_Game();
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
	public Dice_Game() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	Random rand = new Random();
	boolean player1 = true;
	int turn_score = 0;
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 584, 361);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		final JLabel First_Dice = new JLabel("");
		First_Dice.setIcon(new ImageIcon("1.png"));
		First_Dice.setBounds(52, 80, 200, 200);
		panel.add(First_Dice);
		
		final JLabel Second_Dice = new JLabel("");
		Second_Dice.setIcon(new ImageIcon("2.png"));
		Second_Dice.setBounds(322, 80, 200, 200);
		panel.add(Second_Dice);
		
		final JLabel Player_1_score = new JLabel("<html>" + Main3.player1.name + ": " + Main3.player1.score + "</html>");
		Player_1_score.setBackground(Color.WHITE);
		Player_1_score.setVerticalAlignment(SwingConstants.TOP);
		Player_1_score.setBounds(52, 10, 200, 60);
		panel.add(Player_1_score);
		
		final JLabel Player_2_score = new JLabel("<html>" + Main3.player2.name + ": " + Main3.player2.score + "</html>");
		Player_2_score.setBackground(Color.WHITE);
		Player_2_score.setVerticalAlignment(SwingConstants.TOP);
		Player_2_score.setBounds(322, 10, 200, 60);
		panel.add(Player_2_score);
		
		final JLabel Turn = new JLabel("");
		Turn.setBounds(242, 29, 90, 60);
		panel.add(Turn);
		
		JButton Play_Button = new JButton("Throw");
		Play_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int first_dice, second_dice;
				first_dice = rand.nextInt(5) + 1;
				second_dice = rand.nextInt(5) + 1;
				switch (first_dice) {
				case 1:
					First_Dice.setIcon(new ImageIcon("1.png"));
					break;
				case 2:
					First_Dice.setIcon(new ImageIcon("2.png"));
					break;
				case 3:
					First_Dice.setIcon(new ImageIcon("3.png"));
					break;
				case 4:
					First_Dice.setIcon(new ImageIcon("4.png"));
					break;
				case 5:
					First_Dice.setIcon(new ImageIcon("5.png"));
					break;
				case 6:
					First_Dice.setIcon(new ImageIcon("6.png"));
					break;
				}
				switch (second_dice) {
				case 1:
					Second_Dice.setIcon(new ImageIcon("1.png"));
					break;
				case 2:
					Second_Dice.setIcon(new ImageIcon("2.png"));
					break;
				case 3:
					Second_Dice.setIcon(new ImageIcon("3.png"));
					break;
				case 4:
					Second_Dice.setIcon(new ImageIcon("4.png"));
					break;
				case 5:
					Second_Dice.setIcon(new ImageIcon("5.png"));
					break;
				case 6:
					Second_Dice.setIcon(new ImageIcon("6.png"));
					break;
				}
				if(first_dice + second_dice == 7)
				{
					turn_score += (first_dice + second_dice) * 2;
				}
				else
				{
					turn_score += first_dice + second_dice;
				}
				if(player1)
				{	
					
					if(first_dice == 1 && second_dice == 1)
					{	
						Main3.player1.score = 0;
						turn_score = 0;
					}
					else if(first_dice + second_dice == 7)
						Main3.player1.score += 14;
					else
						Main3.player1.score += first_dice + second_dice;
					if(turn_score > 21)
					{
						Main3.player1.score -= turn_score;
						turn_score = 0;
						player1 = false;
					}
					if(Main3.player1.score >= 100)
					{
						frame.dispose();
						The_End.main(null);
					}
					Player_1_score.setText("<html>" + Main3.player1.name + ": " + Main3.player1.score + "</html>");
					Turn.setText("<html>" + Main3.player1.name + "'s turn.<br>" + turn_score + "</html>");
				}
				else
				{	
					if(first_dice == 1 && second_dice == 1)
					{	
						Main3.player2.score = 0;
						turn_score = 0;
					}
					else if(first_dice + second_dice == 7)
						Main3.player2.score += 14;
					else
						Main3.player2.score += first_dice + second_dice;
					if(turn_score > 21)
					{
						Main3.player2.score -= turn_score;
						turn_score = 0;
						player1 = true;
					}
					if(Main3.player2.score >= 100)
					{
						frame.dispose();
						The_End.main(null);
					}
					Player_2_score.setText("<html>" + Main3.player2.name + ": " + Main3.player2.score + "</html>");
					Turn.setText("<html>" + Main3.player2.name + "'s turn.<br>" + turn_score + "</html>");	
				}
			}
		});
		Play_Button.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		Play_Button.setForeground(Color.BLACK);
		Play_Button.setBackground(Color.WHITE);
		Play_Button.setBounds(152, 290, 100, 40);
		panel.add(Play_Button);
		
		JButton Skip_Button = new JButton("Skip");
		Skip_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(player1)
				{
					player1 = false;
					turn_score = 0;
					Turn.setText("<html>" + Main3.player2.name + "'s turn.</html>");
				}
				else
				{
					player1 = true;
					turn_score = 0;
					Turn.setText("<html>" + Main3.player1.name + "'s turn.</html>");
				}
			}
		});
		Skip_Button.setForeground(Color.BLACK);
		Skip_Button.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		Skip_Button.setBackground(Color.WHITE);
		Skip_Button.setBounds(322, 290, 100, 40);
		panel.add(Skip_Button);
	}
}
