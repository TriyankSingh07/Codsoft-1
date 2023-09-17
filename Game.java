package demo3;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Game {
    private int randomNumber; // Store the random number
    private JTextField t1;
    private static JLabel l2,l3;
    private static JButton b2,b5,b1,b3,b4;
     private static int attempts;
    Game() {
    	 attempts=10;
    	randomNumber = generateRandomNumber();
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(300, 200, 400, 250);
        f.setLocationRelativeTo(null);
        Container c = f.getContentPane();
        c.setLayout(null);

        JLabel l1 = new JLabel("Enter a number between 1 to 100 : ");
        l1.setBounds(30, 20, 250, 25);
        c.add(l1);
         l2=new JLabel();
         l2.setBounds(50, 60, 150, 25);
         l2.setFont(new Font("",Font.BOLD,14));
         c.add(l2);
         
         l3=new JLabel(" Your Attempts: "+attempts);
         l3.setFont(new Font("",Font.BOLD,14));
         l3.setBounds(220, 60, 200, 25);
         c.add(l3);
         
        t1 = new JTextField();
        t1.setBounds(250, 20, 100, 25);
        c.add(t1);

        b1 = new JButton("Giveup!");
        b1.setBounds(50, 110, 100, 30);
        c.add(b1);

        b2 = new JButton("Guess");
        b2.setBounds(240, 110, 100, 30);
        c.add(b2);

        b3 = new JButton("Reset");
        b3.setBounds(50, 165, 100, 30);
        c.add(b3);
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t1.setText(null);
            }
        });

        b4 = new JButton("Exit");
        b4.setBounds(240, 165, 100, 30);
        c.add(b4);
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
        
        b5=new JButton("Play Again");
        b5.setBounds(240, 110, 100, 30);
        c.add(b5);
        b5.setVisible(false);


        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	f.dispose();
                 new Guess();
            }
        });
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	f.dispose();
                 new Game();
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String userGuess=t1.getText();
                if ( userGuess.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a number first.");
                    return;
                }
                else if(Integer.parseInt(userGuess)>100) {
                	JOptionPane.showMessageDialog(null, "Please enter a number between 1 to 100.");
                	return;
                }

                int g = Integer.parseInt(t1.getText());
                checkGuess(g);
            }
        });

        f.setVisible(true);
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * 100) + 1; 
    }

    private void checkGuess(int userGuess) {
    	attempts--;
    	
    	l3.setText("Attempts Remaining: "+ attempts);
    	
    	
    	if(attempts==0) {
    		 JOptionPane.showMessageDialog(null, "Sorry, you've run out of attempts. The number was " + randomNumber + ".");
    		 b5.setBounds(140, 110, 100, 30);
    		 b4.setBounds(140, 165, 100, 30);
             b5.setVisible(true);
             b2.setVisible(false);
             b1.setVisible(false);
             b3.setVisible(false);
             
    	}
    	
    	else if (userGuess == randomNumber) {
        	b2.setVisible(false);
      
            JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number.");
            b4.setBounds(140, 165, 100, 30);
            b5.setBounds(140, 110, 100, 30);
            b5.setVisible(true);
            b1.setVisible(false);
            b3.setVisible(false);
        } else if (userGuess < randomNumber) {
            l2.setText("Too low. Try again.");
        } else if((userGuess > randomNumber) ) {
        	 l2.setText("Too high. Try again.");
        }
        else if(attempts<=3) {
    		l3.setForeground(Color.RED);
    	}
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Game();
            }
        });
    }
}
