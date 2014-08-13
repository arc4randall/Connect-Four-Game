/* Connect4.java
 * Brenna Belletti, Eric Dunton, Randall Spence
 * Purpose: A GUI that allows a human to the play the board game "Connect Four". Calls
 * a Player class for evaluation functions.
 * Uses: JCanvas, JBox, and JEventQueue.
 */

import java.awt.*;
import javax.swing.*;
import java.util.*;


public class Connect4 {
    public static void main(String args[]) {
        //construct a player
        Player P = new Player();
        
        //keeps track of which player's turn it is (1 for red 10 for blue)
        int player = 1;
        
        //the board
        int[][] gameBoard = { { 0,0,0,0,0,0,0,0},
            { 0,0,0,0,0,0,0,0},
            { 0,0,0,0,0,0,0,0},
            { 0,0,0,0,0,0,0,0},
            { 0,0,0,0,0,0,0,0},
            { 0,0,0,0,0,0,0,0},
            { 0,0,0,0,0,0,0,0},
            { 0,0,0,0,0,0,0,0} };
        
        //constructor for the frame
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setTitle("Connect Four");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //create a new color and make the frame that color
        Color lightYellow = new Color(255, 240, 180);
        frame.setBackground(lightYellow);
        
        //set the title in the window
        JLabel title = new JLabel("Connect Four", JLabel.CENTER);
        Font myfont = new Font ("Serif", Font.PLAIN, 16);
        title.setFont(myfont);
        
        //creates a panel which will act as a container for the buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 8));
        
        //creates an array of buttons in which each button will be added to the panel
        JButton[][] board = new JButton[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new JButton();
                board[i][j].setOpaque(true);
                board[i][j].setBorder(BorderFactory.createEtchedBorder());
                board[i][j].setBackground(lightYellow);
                panel.add(board[i][j]);
            }
        }
        
        //assemble the buttons for quit and reset in the window
        JButton quit = new JButton("Quit");
        JButton reset = new JButton("Reset");
        
        //create the label for the status section
        JLabel info = new JLabel("Playing...", JLabel.CENTER);
        
        //set up the body for the window
        JBox body = JBox.vbox(JBox.CENTER,
                              JBox.vspace(20),
                              JBox.hbox(title),
                              JBox.vspace(20),
                              JBox.hbox(
                                        JBox.hspace(150),
                                        panel,
                                        JBox.hspace(150)),
                              JBox.hbox(
                                        quit,
                                        JBox.hspace(125),
                                        reset,
                                        JBox.hspace(125),
                                        info),
                              JBox.vspace(50));
        
        //add the body to the frame and set it visible
        frame.add(body);
        frame.setVisible(true);
        
        //create an event that will listen to all of the buttons
        JEventQueue events = new JEventQueue();
        events.listenTo(board[0][0], "00");
        events.listenTo(board[0][1], "01");
        events.listenTo(board[0][2], "02");
        events.listenTo(board[0][3], "03");
        events.listenTo(board[0][4], "04");
        events.listenTo(board[0][5], "05");
        events.listenTo(board[0][6], "06");
        events.listenTo(board[0][7], "07");
        events.listenTo(board[1][0], "10");
        events.listenTo(board[1][1], "11");
        events.listenTo(board[1][2], "12");
        events.listenTo(board[1][3], "13");
        events.listenTo(board[1][4], "14");
        events.listenTo(board[1][5], "15");
        events.listenTo(board[1][6], "16");
        events.listenTo(board[1][7], "17");
        events.listenTo(board[2][0], "20");
        events.listenTo(board[2][1], "21");
        events.listenTo(board[2][2], "22");
        events.listenTo(board[2][3], "23");
        events.listenTo(board[2][4], "24");
        events.listenTo(board[2][5], "25");
        events.listenTo(board[2][6], "26");
        events.listenTo(board[2][7], "27");
        events.listenTo(board[3][0], "30");
        events.listenTo(board[3][1], "31");
        events.listenTo(board[3][2], "32");
        events.listenTo(board[3][3], "33");
        events.listenTo(board[3][4], "34");
        events.listenTo(board[3][5], "35");
        events.listenTo(board[3][6], "36");
        events.listenTo(board[3][7], "37");
        events.listenTo(board[4][0], "40");
        events.listenTo(board[4][1], "41");
        events.listenTo(board[4][2], "42");
        events.listenTo(board[4][3], "43");
        events.listenTo(board[4][4], "44");
        events.listenTo(board[4][5], "45");
        events.listenTo(board[4][6], "46");
        events.listenTo(board[4][7], "47");
        events.listenTo(board[5][0], "50");
        events.listenTo(board[5][1], "51");
        events.listenTo(board[5][2], "52");
        events.listenTo(board[5][3], "53");
        events.listenTo(board[5][4], "54");
        events.listenTo(board[5][5], "55");
        events.listenTo(board[5][6], "56");
        events.listenTo(board[5][7], "57");
        events.listenTo(board[6][0], "60");
        events.listenTo(board[6][1], "61");
        events.listenTo(board[6][2], "62");
        events.listenTo(board[6][3], "63");
        events.listenTo(board[6][4], "64");
        events.listenTo(board[6][5], "65");
        events.listenTo(board[6][6], "66");
        events.listenTo(board[6][7], "67");
        events.listenTo(board[7][0], "70");
        events.listenTo(board[7][1], "71");
        events.listenTo(board[7][2], "72");
        events.listenTo(board[7][3], "73");
        events.listenTo(board[7][4], "74");
        events.listenTo(board[7][5], "75");
        events.listenTo(board[7][6], "76");
        events.listenTo(board[7][7], "77");
        events.listenTo(quit, "quit");
        events.listenTo(reset, "reset");
        
        //waits for the user's input and reacts accordingly, i.e. calling the Player class
        //or updating the GUI
        while(true) {
            EventObject event = events.waitEvent();
            String name = events.getName(event);
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (name.equals("" + i + j)) {
                        for (int k = 7; k >= 0; k--) {
                            if (board[k][j].getBackground() == lightYellow) {
                                board[k][j].setBackground(Color.red);
                                gameBoard[k][j] = 1;
                                player = 10;
                                break;
                            }
                        }
                        int nextPosition = P.move(gameBoard, player);
                        for (int k = 7; k >= 0; k--) {
                            if (board[k][nextPosition].getBackground() == lightYellow) {
                                board[k][nextPosition].setBackground(Color.blue);
                                gameBoard[k][nextPosition] = 10;
                                player = 1;
                                break;
                            }
                        }
                        int status = P.eval(gameBoard);
                        if (status == Integer.MIN_VALUE) {
                            info.setText("Red Player Wins!");
                            for (int m = 0; m < 8; m++) {
                                for (int l = 0; l < 8; l++) {
                                    board[m][l].setBackground(lightYellow);
                                    gameBoard[m][l] = 0;
                                }
                            }
                            player = 1;
                        } else if (status == Integer.MAX_VALUE) {
                            info.setText("Blue Player Wins!");
                            for (int m = 0; m < 8; m++) {
                                for (int l = 0; l < 8; l++) {
                                    board[m][l].setBackground(lightYellow);
                                    gameBoard[m][l] = 0;
                                }
                            }
                            player = 1;
                        }
                    } else if (name.equals("quit")) {
                        frame.dispose();
                    } else if (name.equals("reset")) {
                        for (int m = 0; m < 8; m++) {
                            for (int l = 0; l < 8; l++) {
                                board[m][l].setBackground(lightYellow);
                                gameBoard[m][l] = 0;
                            }
                        }
                        player = 1;
                    }
                }
            }
        }    
        
    }  
}




