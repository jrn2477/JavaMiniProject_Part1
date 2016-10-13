import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Project 1
 * Course Java 2
 * @author Jeremy Bolella and Jason Nordheim
 *
 * This projects goal is to make a video game using JFrame and other default tools included in Java
 * This project is a spinoff of battleship
 * Two players can play and each take turns till one player wins
 **/

public class GUI extends JFrame {

    //Global Variables
    public String player1_name = "";
    public String player2_name = "";

    public boolean initializing = true;

    public GUI() {
        //This does nothing yet
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
                        f1.setVisible(true);
                        new JOptionPane().showConfirmDialog(null, "Welcome to the Minfield!", null, JOptionPane.PLAIN_MESSAGE);
                    }
                } // endif (ae.getSource() == btn_submit)
            } // end actionPerformed(ActionEvent ae)
        });
        //adds the labels and text fields to the west and east panel
        westPanel.add(lbl_p1);
        westPanel.add(lbl_p2);
        eastPanel.add(txt_p1);
        eastPanel.add(txt_p2);

        //adds the west/east panel to the p1 panel and then adds the submit button(btn_submit)
        p1.add(westPanel, BorderLayout.WEST);
        p1.add(eastPanel, BorderLayout.EAST);
        p1.add(btn_submit, BorderLayout.SOUTH);

        f1.add(p1);
        f1.setTitle("BattleShip start of the game.");
        f1.pack();
        f1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f1.setVisible(true);
        f1.setLocationRelativeTo(null);
    }




    public void setBoard(String player) {


        ActionListener listener  = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String ButtonClick = e.getActionCommand();
               System.out.println(ButtonClick +","+player);
            }
        };
        JPanel grid = new JPanel(new GridLayout(5, 5, 10, 10));
        for(int i= 0; i < 25; i++) {
            String buttonName = Integer.toString(i);
            JButton tempButton = new JButton(buttonName);
            tempButton.addActionListener(listener);
            tempButton.setActionCommand(buttonName);
            grid.add(tempButton);

        }
        int clicks = 0;

        JFrame playerBoard = new JFrame();
        playerBoard.setTitle(player1_name + "Game Board");
        playerBoard.add(grid);

        playerBoard.setSize(500, 500);
        playerBoard.setVisible(true);


    }
    public void createErrorMessageBox(String _msg) {
        String msg = _msg;
        JOptionPane jop = new JOptionPane();
        jop.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

//    public void checkChosenHotspots(Player thisPlayer) {
//        String[] tempString = thisPlayer.getChosenHotspots();
//    }

}