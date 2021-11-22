package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameFrame extends JFrame implements ActionListener {

    int height = 480;
    int width = height * 12/9;

    JButton button1 = new JButton();
    JButton button2 = new JButton();
    JButton button3 = new JButton();
    JButton button4 = new JButton();
    JButton button5 = new JButton();
    JButton button6 = new JButton();
    JButton button7 = new JButton();
    JButton button8 = new JButton();
    JButton button9 = new JButton();

    boolean[] ischecked = {false,false,false,false,false,false,false,false,false};  //keeps track whether the cell is occupied
    int[] XorO = {0,0,0,0,0,0,0,0,0};                                               //keeps track which player used which cell
    JButton[] button = {button1, button2, button3, button4, button5,                //cells
            button6, button7, button8, button9};

    Random rand = new Random();
    int counter = 0;                //keeps track how many turns have passed


    GameFrame(){

        for(int i = 0; i < 9; i++)
            button[i].addActionListener(this);

        this.setTitle("Tic Tac Toe");
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3,3, 10, 10));
        this.setVisible(true);

        for(int i = 0; i < 9; i++)
            this.add(button[i]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {                //placing X (player move) on the board

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == button[i]) {
                if (!ischecked[i]){
                    button[i].setText("X");
                    button[i].setFont(new Font("MV Boli", Font.PLAIN, 30));
                    button[i].setEnabled(false);
                    ischecked[i] = true;
                    XorO[i] = 1;
                    counter++;
                    WinCheck();
                    if (counter < 8)
                        EnemyTurn();
                }
            }
        }
    }

    private void EnemyTurn() {                      //Executes computer move (O)

        int i = 0;

        while (i == 0)
        {
            int r = rand.nextInt(9);
            if (!ischecked[r])
            {
                button[r].setText("O");
                button[r].setFont(new Font("MV Boli", Font.PLAIN, 30));
                button[r].setEnabled(false);
                ischecked[r] = true;
                XorO[r] = 2;
                i = 1;
                counter++;
                WinCheck();
            }
        }

    }

    public void WinCheck() {            //Method that checks after every move
        //whether winning condition has been satisfied
        String Massage = "";

        for (int i = 0; i < 9; i += 3) {
            if ((XorO[i] == XorO[1 + i] && XorO[1 + i] == XorO[2 + i]) && (XorO[i] != 0)) {
                winMassage(i, "You Win!", "You Lose :(");
            }
        }

        for (int i = 0; i < 3; i++){
            if ((XorO[i] == XorO[3 + i] && XorO[3 + i] == XorO[6 + i]) && (XorO[i] != 0)) {
                winMassage(i, "You Win!", "You Lose :(");
            }
        }

        if (XorO[0] == XorO[4] && XorO[4] == XorO[8] && (XorO[4] != 0)) {
            winMassage(0, "You Win!", "You Lose :(");
        }

        else if (XorO[2] == XorO[4] && XorO[4] == XorO[6] && (XorO[4] != 0)) {
            winMassage(2, "You Win!", "You Lose :(");
        }

        else if (counter > 8) {
            this.dispose();
            Result result = new Result("Draw :()");
        }
    }

    public void winMassage(int x, String Massage1, String Massage2){            //Method that displays appropriate massage upon ending the game
        counter = 8;                                                            //Setting counter to 8 fixes a problem where two winning screens
        this.dispose();                                                         //would appear instead of one. No idea why, though.
        if (XorO[x] == 1) {
            Result result = new Result(Massage1);
        } else if (XorO[x] == 2) {
            Result result = new Result(Massage2);
        }
    }
}
