package demo3;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;
public class Guess extends JFrame{
	
	 private static JButton b1,b2;
	 private static JLabel l1;
	  Guess(){
		
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(300,200,400,250);
		f.setLocationRelativeTo(null);		
		Container c=f.getContentPane();
		c.setLayout(null);
		
		l1=new JLabel("Welcome ! Let's Play Guess The Number Game");
		l1.setBounds(10,30,380,20);
		l1.setFont(new Font("",Font.BOLD,16));
		c.add(l1);
		
		b1=new JButton("Play Game");
		b1.setBounds(140,85,100,30);
		c.add(b1);
		b1.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new Game();
				f.dispose();
			}
		});
		
		b2=new JButton("Exit");
		b2.setBounds(140,150,100,30);
		c.add(b2);
		b2.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
		
		f.setVisible(true);
	}
	
	

	public static void main(String[] args) {
		
		new Guess();
	}


}

	
	


