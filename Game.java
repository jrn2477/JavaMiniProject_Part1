import javax.swing.*;
import javax.swing.BorderFactory;
import java.util.*;
import javax.sound.midi.*;
import java.awt.*;
import javax.net.ssl.*;
import java.awt.event.*;
import javax.xml.soap.*;
import java.awt.color.*;



public class Game extends JFrame {

	// ------------------------------------ All the buttons
	private JButton jb_a1;
	private JButton jb_a2;
	private JButton jb_a3;
	private JButton jb_a4;
	private JButton jb_a5;
	private JButton jb_a6;
	private JButton jb_a7;
	private JButton jb_a8;

	private JButton jb_b1;
	private JButton jb_b2;
	private JButton jb_b3;
	private JButton jb_b4;
	private JButton jb_b5;
	private JButton jb_b6;
	private JButton jb_b7;
	private JButton jb_b8;

	private JButton jb_c1;
	private JButton jb_c2;
	private JButton jb_c3;
	private JButton jb_c4;
	private JButton jb_c5;
	private JButton jb_c6;
	private JButton jb_c7;
	private JButton jb_c8;

	private JButton jb_d1;
	private JButton jb_d2;
	private JButton jb_d3;
	private JButton jb_d4;
	private JButton jb_d5;
	private JButton jb_d6;
	private JButton jb_d7;
	private JButton jb_d8;

	private JButton jb_e1;
	private JButton jb_e2;
	private JButton jb_e3;
	private JButton jb_e4;
	private JButton jb_e5;
	private JButton jb_e6;
	private JButton jb_e7;
	private JButton jb_e8;

	private JButton jb_f1;
	private JButton jb_f2;
	private JButton jb_f3;
	private JButton jb_f4;
	private JButton jb_f5;
	private JButton jb_f6;
	private JButton jb_f7;
	private JButton jb_f8;

	private JButton jb_g1;
	private JButton jb_g2;
	private JButton jb_g3;
	private JButton jb_g4;
	private JButton jb_g5;
	private JButton jb_g6;
	private JButton jb_g7;
	private JButton jb_g8;

	private JButton jb_h1;
	private JButton jb_h2;
	private JButton jb_h3;
	private JButton jb_h4;
	private JButton jb_h5;
	private JButton jb_h6;
	private JButton jb_h7;
	private JButton jb_h8;

	// ------------------------------------ CONSTANTS
	private static int Y_AXIS = 8;
	private static int X_AXIS = 8;

	// ------------------------------------ GlOBAL VARIABLES
	private static String p1Name;
	private static String p2Name;

	private static JPanel mainPanel;

	private static JMenu fileMenu;
	private static JMenu helpMenu;

	private static ArrayList<JButton> ary_btnField = new ArrayList<JButton>();

	public static void main(String[] args) {
		Game g1 = new Game();
		g1.init();

	}

	public Game() {

	}

	// intitial method run
	public void init() {


		JFrame f1 = new JFrame();

		JPanel p1 = new JPanel(new BorderLayout());
		JPanel westPanel = new JPanel(new GridLayout(2,1)); // two rows, 1 column
		JPanel eastPanel = new JPanel(new GridLayout(2,1)); // two rows, 1 column


		JButton btn_submit = new JButton("Start Game");
		JTextField txt_p1 = new JTextField(10);
		JTextField txt_p2 = new JTextField(10);
		JLabel lbl_p1 = new JLabel(" Player 1 Name:");
		JLabel lbl_p2 = new JLabel(" Player 2 Name:");

		btn_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == btn_submit) {

					String temp1 = txt_p1.getText();
					String temp2 = txt_p2.getText();


					if (temp1.equals("")) {
						createErrorMessageBox("Please enter a name into the player 1 text field");
					} else if (temp2.equals("")) {
						createErrorMessageBox("Please enter a name into the player 2 text field");
					}
					else {
						// trim inputs
						temp1.trim();
						temp2.trim();
						set_p1(temp1);
						set_p2(temp2);

						new JOptionPane().showConfirmDialog(null,
						"Welcome to the Minfield!", null, JOptionPane.PLAIN_MESSAGE);

						f1.hide();

						initializeField();
						addButtonsToArray();
						intialMinefieldSetup(50);
						createMinefield();
					}


				} // endif (ae.getSource() == btn_submit)
			} // end actionPerformed(ActionEvent ae)
		});

		westPanel.add(lbl_p1);
		westPanel.add(lbl_p2);
		eastPanel.add(txt_p1);
		eastPanel.add(txt_p2);

		p1.add(westPanel, BorderLayout.WEST);
		p1.add(eastPanel, BorderLayout.EAST);
		p1.add(btn_submit, BorderLayout.SOUTH);

		f1.add(p1);
		f1.setTitle("Game Settings");
		f1.pack();
		f1.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f1.setVisible(true);
		f1.setLocationRelativeTo(null);

	}

	public void initializeField() {
		this.jb_a1 = new JButton();
		this.jb_a2 = new JButton();
		this.jb_a3 = new JButton();
		this.jb_a4 = new JButton();
		this.jb_a5 = new JButton();
		this.jb_a6 = new JButton();
		this.jb_a7 = new JButton();
		this.jb_a8 = new JButton();

		this.jb_b1 = new JButton();
		this.jb_b2 = new JButton();
		this.jb_b3 = new JButton();
		this.jb_b4 = new JButton();
		this.jb_b5 = new JButton();
		this.jb_b6 = new JButton();
		this.jb_b7 = new JButton();
		this.jb_b8 = new JButton();

		this.jb_c1 = new JButton();
		this.jb_c2 = new JButton();
		this.jb_c3 = new JButton();
		this.jb_c4 = new JButton();
		this.jb_c5 = new JButton();
		this.jb_c6 = new JButton();
		this.jb_c7 = new JButton();
		this.jb_c8 = new JButton();

		this.jb_d1 = new JButton();
		this.jb_d2 = new JButton();
		this.jb_d3 = new JButton();
		this.jb_d4 = new JButton();
		this.jb_d5 = new JButton();
		this.jb_d6 = new JButton();
		this.jb_d7 = new JButton();
		this.jb_d8 = new JButton();

		this.jb_e1 = new JButton();
		this.jb_e2 = new JButton();
		this.jb_e3 = new JButton();
		this.jb_e4 = new JButton();
		this.jb_e5 = new JButton();
		this.jb_e6 = new JButton();
		this.jb_e7 = new JButton();
		this.jb_e8 = new JButton();

		this.jb_f1 = new JButton();
		this.jb_f2 = new JButton();
		this.jb_f3 = new JButton();
		this.jb_f4 = new JButton();
		this.jb_f5 = new JButton();
		this.jb_f6 = new JButton();
		this.jb_f7 = new JButton();
		this.jb_f8 = new JButton();

		this.jb_g1 = new JButton();
		this.jb_g2 = new JButton();
		this.jb_g3 = new JButton();
		this.jb_g4 = new JButton();
		this.jb_g5 = new JButton();
		this.jb_g6 = new JButton();
		this.jb_g7 = new JButton();
		this.jb_g8 = new JButton();

		this.jb_h1 = new JButton();
		this.jb_h2 = new JButton();
		this.jb_h3 = new JButton();
		this.jb_h4 = new JButton();
		this.jb_h5 = new JButton();
		this.jb_h6 = new JButton();
		this.jb_h6 = new JButton();
		this.jb_h7 = new JButton();
		this.jb_h8 = new JButton();
	}


	public void addButtonsToArray() {

		try {
			ary_btnField.add(this.jb_a1);
			ary_btnField.add(this.jb_a2);
			ary_btnField.add(this.jb_a3);
			ary_btnField.add(this.jb_a4);
			ary_btnField.add(this.jb_a5);
			ary_btnField.add(this.jb_a6);
			ary_btnField.add(this.jb_a7);
			ary_btnField.add(this.jb_a8);

			ary_btnField.add(this.jb_b1);
			ary_btnField.add(this.jb_b2);
			ary_btnField.add(this.jb_b3);
			ary_btnField.add(this.jb_b4);
			ary_btnField.add(this.jb_b5);
			ary_btnField.add(this.jb_b6);
			ary_btnField.add(this.jb_b7);
			ary_btnField.add(this.jb_b8);


			ary_btnField.add(this.jb_c1);
			ary_btnField.add(this.jb_c2);
			ary_btnField.add(this.jb_c3);
			ary_btnField.add(this.jb_c4);
			ary_btnField.add(this.jb_c5);
			ary_btnField.add(this.jb_c6);
			ary_btnField.add(this.jb_c7);
			ary_btnField.add(this.jb_c8);

			ary_btnField.add(this.jb_d1);
			ary_btnField.add(this.jb_d2);
			ary_btnField.add(this.jb_d3);
			ary_btnField.add(this.jb_d4);
			ary_btnField.add(this.jb_d5);
			ary_btnField.add(this.jb_d6);
			ary_btnField.add(this.jb_d7);
			ary_btnField.add(this.jb_d8);

			ary_btnField.add(this.jb_e1);
			ary_btnField.add(this.jb_e2);
			ary_btnField.add(this.jb_e3);
			ary_btnField.add(this.jb_e4);
			ary_btnField.add(this.jb_e5);
			ary_btnField.add(this.jb_e6);
			ary_btnField.add(this.jb_e7);
			ary_btnField.add(this.jb_e8);

			ary_btnField.add(this.jb_f1);
			ary_btnField.add(this.jb_f2);
			ary_btnField.add(this.jb_f3);
			ary_btnField.add(this.jb_f4);
			ary_btnField.add(this.jb_f5);
			ary_btnField.add(this.jb_f6);
			ary_btnField.add(this.jb_f7);
			ary_btnField.add(this.jb_f8);

			ary_btnField.add(this.jb_g1);
			ary_btnField.add(this.jb_g2);
			ary_btnField.add(this.jb_g3);
			ary_btnField.add(this.jb_g4);
			ary_btnField.add(this.jb_g5);
			ary_btnField.add(this.jb_g6);
			ary_btnField.add(this.jb_g7);
			ary_btnField.add(this.jb_g8);

			ary_btnField.add(this.jb_h1);
			ary_btnField.add(this.jb_h2);
			ary_btnField.add(this.jb_h3);
			ary_btnField.add(this.jb_h4);
			ary_btnField.add(this.jb_h5);
			ary_btnField.add(this.jb_h6);
			ary_btnField.add(this.jb_h7);
			ary_btnField.add(this.jb_h8);
		} catch (Exception e) {
			System.out.println("Error adding to the array");
		}

	}


	public void intialMinefieldSetup(int s) {
		int end = ary_btnField.size();

		for (int i = 0; i < end; i++) {

//			BorderFactory bFactory = new BorderFactory();
//			Border greenBorder = bFactory.createLineBorder(Color.GREEN);

			ary_btnField.get(i).setText(" ");
			ary_btnField.get(i).setSize(s,s);
			ary_btnField.get(i).setBackground(Color.BLACK);
			ary_btnField.get(i).setBorder(BorderFactory.createLineBorder(Color.GREEN));
			ary_btnField.get(i).setVisible(true);
			System.out.println("Button " + i + " has been created");
		}

		super.repaint();
		super.revalidate();
	}

	public void createMinefield() {
		JFrame f2 = new JFrame();

		JPanel mainPanel = new JPanel(new BorderLayout());

		JPanel minePanel = new JPanel(new GridLayout(8,8));

		minePanel.add(this.jb_a1);
		minePanel.add(this.jb_a2);
		minePanel.add(this.jb_a3);
		minePanel.add(this.jb_a5);
		minePanel.add(this.jb_a6);
		minePanel.add(this.jb_a7);
		minePanel.add(this.jb_a8);

		minePanel.add(this.jb_b1);
		minePanel.add(this.jb_b2);
		minePanel.add(this.jb_b3);
		minePanel.add(this.jb_b4);
		minePanel.add(this.jb_b5);
		minePanel.add(this.jb_b6);
		minePanel.add(this.jb_b7);
		minePanel.add(this.jb_b8);

		minePanel.add(this.jb_c1);
		minePanel.add(this.jb_c2);
		minePanel.add(this.jb_c3);
		minePanel.add(this.jb_c4);
		minePanel.add(this.jb_c5);
		minePanel.add(this.jb_c6);
		minePanel.add(this.jb_c7);
		minePanel.add(this.jb_c8);

		minePanel.add(this.jb_d1);
		minePanel.add(this.jb_d2);
		minePanel.add(this.jb_d3);
		minePanel.add(this.jb_d4);
		minePanel.add(this.jb_d5);
		minePanel.add(this.jb_d6);
		minePanel.add(this.jb_d7);
		minePanel.add(this.jb_d8);

		minePanel.add(this.jb_e1);
		minePanel.add(this.jb_e2);
		minePanel.add(this.jb_e3);
		minePanel.add(this.jb_e4);
		minePanel.add(this.jb_e5);
		minePanel.add(this.jb_e6);
		minePanel.add(this.jb_e7);
		minePanel.add(this.jb_e8);

		minePanel.add(this.jb_f1);
		minePanel.add(this.jb_f2);
		minePanel.add(this.jb_f2);
		minePanel.add(this.jb_f3);
		minePanel.add(this.jb_f4);
		minePanel.add(this.jb_f5);
		minePanel.add(this.jb_f6);
		minePanel.add(this.jb_f7);
		minePanel.add(this.jb_f8);

		minePanel.add(this.jb_g1);
		minePanel.add(this.jb_g2);
		minePanel.add(this.jb_g3);
		minePanel.add(this.jb_g4);
		minePanel.add(this.jb_g5);
		minePanel.add(this.jb_g6);
		minePanel.add(this.jb_g7);
		minePanel.add(this.jb_g8);

		minePanel.add(this.jb_h1);
		minePanel.add(this.jb_h2);
		minePanel.add(this.jb_h3);
		minePanel.add(this.jb_h4);
		minePanel.add(this.jb_h5);
		minePanel.add(this.jb_h6);
		minePanel.add(this.jb_h7);
		minePanel.add(this.jb_h8);

		mainPanel.add(minePanel, BorderLayout.CENTER);
		f2.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		f2.setLocationRelativeTo(null);
		f2.pack();
		f2.repaint();
		f2.revalidate();
		f2.setVisible(true);
	}



	//
	// Method to create a temporary window/frame that will display messages as needed
	//
	public void createErrorMessageBox(String _msg) {
		String msg = _msg;
		JOptionPane jop = new JOptionPane();
		jop.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public void set_p1(String _p1) {
		p1Name = _p1;
	}
	public void set_p2(String _p2) {
		p2Name = _p2;
	}


}
