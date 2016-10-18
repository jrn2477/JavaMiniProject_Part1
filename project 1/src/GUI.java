import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Mini Project - Part 1
 * Course Java 2
 * @author Jeremy Bolella and Jason Nordheim
 *
 * This projects goal is to make a video game using JFrame and other default tools included in Java
 * This project is a spinoff of battleship
 * Two players can play and each take turns till one player wins
 **/

public class GUI extends JFrame {
    // ---- Global Variables
    public String player1_name = "";
    public String player2_name = "";
    public boolean initializing = true;
    private int clicks = 0;

    ArrayList<JButton> buttons = new ArrayList<>();
    private JFrame f1 = new JFrame();
    private JFrame playerBoard = new JFrame();
    private JButton finish = new JButton("Finish");

    public GUI() {
        //This does nothing yet
    }
    // intitial method run
    public void init() {
        JPanel p1 = new JPanel(new BorderLayout());
        JPanel westPanel = new JPanel(new GridLayout(2,1)); // two rows, 1 column
        JPanel eastPanel = new JPanel(new GridLayout(2,1)); // two rows, 1 column

        JButton btn_submit = new JButton("Start Game");
        JTextField txt_p1 = new JTextField(10);
        JTextField txt_p2 = new JTextField(10);
        JLabel lbl_p1 = new JLabel(" Player 1 Name:");
        JLabel lbl_p2 = new JLabel(" Player 2 Name:");

        /**
         * ActionListener for submit button
         * @returns void
         * @params ActionListener
         */
        btn_submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == btn_submit) {
                    String temp1 = txt_p1.getText();
                    String temp2 = txt_p2.getText();
                    f1.setVisible(false);
                    if (temp1.equals("")) {
                        createErrorMessageBox("Please enter a name into the player 1 text field");
                    } else if (temp2.equals("")) {
                        createErrorMessageBox("Please enter a name into the player 2 text field");
                    }
                    else {
                        new JOptionPane().showConfirmDialog(null, "Welcome to the BattleShip Field! Player 1 Please select your playing board", null, JOptionPane.PLAIN_MESSAGE);
                        playerBoard.setVisible(true);
                        playerBoard.repaint();

                    }
                }
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
        // add components to the frame
        f1.add(p1);
        f1.setTitle("Game Setup");
        f1.pack();
        f1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f1.setVisible(true);
        f1.setLocationRelativeTo(null);
    }


    /**
     * Method to set up the game board hotspots for each player
     * @param player - Takes in the player1 object
     * @param player2 - Takes in the player2 object
     */
    public void setBoard(Player player, Player player2) {
        ActionListener listener  = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonClick = e.getActionCommand();
                System.out.println(buttonClick);

                // if the player has
                if (clicks < 4) {
                    player.addHotSpot(buttonClick);
                    clicks++;
                    int buttonToInt = Integer.parseInt(buttonClick);
                    JButton disableButton = buttons.get(buttonToInt);
                    disableButton.setEnabled(false);

                } else if (clicks == 4) {
                    finish.setEnabled(true);
                    disableButtons(buttons); 

                    if (buttonClick.contentEquals("Finish") && clicks == 4) {
                        playerBoard.setVisible(false);
                        finish.setEnabled(false);
                        clicks = 5;
                        new JOptionPane().showConfirmDialog(null, "Player 2 Please select your playing board", null, JOptionPane.PLAIN_MESSAGE);
                        playerBoard.repaint();
                        resetButtons(buttons);
                        playerBoard.setVisible(true);
                    }
                } else if(clicks >=5) {
                    if (!(buttonClick.contentEquals("Finish"))) {
                        player2.addHotSpot(buttonClick);
                        clicks++;
                        int buttonToInt = Integer.parseInt(buttonClick);
                        JButton disableButton = buttons.get(buttonToInt);
                        disableButton.setEnabled(false);
                    }
                }
                if (clicks > 9) {
                    playerBoard.setVisible(false);
                    new JOptionPane().showConfirmDialog(null, "The ships are placed. Player 1 will go first", null, JOptionPane.PLAIN_MESSAGE);
                    runGame(player, player2);

                }
            }
        };
        JPanel grid = new JPanel(new GridLayout(5, 5, 10, 10));
        finish.setEnabled(false);
        finish.addActionListener(listener);
        finish.setSize(500, 30);
        playerBoard.setTitle(player.getName() + "Game Board");
        playerBoard.add(grid, BorderLayout.CENTER);
        playerBoard.add(finish, BorderLayout.SOUTH);
        playerBoard.setSize(500, 500);
        playerBoard.setVisible(false);
        for(int i=0; i < 25; i++) {
            String buttonName = Integer.toString(i);
            JButton tempButton = new JButton(buttonName);
            //tempButton.setText("*");
            tempButton.addActionListener(listener);
            tempButton.setActionCommand(buttonName);
            buttons.add(tempButton);
            grid.add(tempButton);
        }
    }
    public void runGame(Player player1, Player player2) {

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isPlayer1 = true; //This keeps the players seperate
                String buttonClick = e.getActionCommand();
                System.out.println(buttonClick);
                //ALL PLAYER 1 EVENTS SHOULD HAPPEN HERE!
                if (isPlayer1) {

                }


                //ALL PLAYER 2 EVENTS SHOULD HAPPEN HERE!
                else {

                }
            }
        };


        JPanel grid = new JPanel(new GridLayout(5, 5, 10, 10));
        finish.setEnabled(false);
        finish.addActionListener(listener);
        finish.setSize(500, 30);
        playerBoard.setTitle("Game Board");
        JLabel northTitle = new JLabel("");
        playerBoard.add(grid, BorderLayout.CENTER);
        playerBoard.add(finish, BorderLayout.SOUTH);
        playerBoard.setSize(500, 500);
        playerBoard.setVisible(true);
        for (int i = 0; i < 25; i++) {
            String buttonName = Integer.toString(i);
            JButton tempButton = new JButton(buttonName);
            tempButton.addActionListener(listener);
            tempButton.setActionCommand(buttonName);
            buttons.add(tempButton);
            grid.add(tempButton);
        }
    }

    public void resetButtons(ArrayList<JButton> btns) {
        for(int i=0; i < 25; i++) {
            JButton tempBtn = btns.get(i);
            tempBtn.setEnabled(true);
        }
    }

    public void testHostpot(int btnClicked, Player opposingPlayer) {
        Player oppPlayer = opposingPlayer;
        ArrayList<String> hotSpotArray = oppPlayer.getChosenHotspots();
    }
    
    public void disableButtons(ArrayList<JButton> btns) {
        for (int i = 0; i < btns.size(); i++) {
            JButton tempBtn = btns.get(i); 
            tempBtn.setEnabled(false);
        }
    }
    

    public void createErrorMessageBox(String _msg) {
        String msg = _msg;
        JOptionPane jop = new JOptionPane();
        jop.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
}