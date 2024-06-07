package java飞机大战.main;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;




public class GameFrame extends JFrame{
	private JLabel back,lblNewLabel, lblNewLabel_1, lblNewLabel_2;
	private GameFrame m;

	public GameFrame() {
		m=this;
		this.setTitle("Ikun' Space Ship");
		getContentPane().setLayout(null);
		this.setSize(1800, 1000);
		this.setLocationRelativeTo(null);			
		this.setVisible(true);		
		showlabel();
		
	  
	}

	
	public void showlabel(){
		JLabel lblNewLabel = new JLabel("Start Game");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().removeAll();
	        	GamePanel game=new GamePanel(m);
	        	getContentPane().add(game);
				game.setSize(1800, 1000);
				revalidate();
				repaint();
	   
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setForeground(Color.GREEN);
			}
		});
		lblNewLabel.setFont(new Font("Bodoni MT Black", Font.BOLD, 24));
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBounds(800, 568, 182, 70);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Load Game");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setForeground(Color.GREEN);
			}
		});
		lblNewLabel_1.setFont(new Font("Bodoni MT Black", Font.BOLD, 24));
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setBounds(800, 689, 182, 70);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Rank List");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setForeground(Color.GREEN);
			}
		});
		lblNewLabel_2.setFont(new Font("Bodoni MT Black", Font.BOLD, 24));
		lblNewLabel_2.setForeground(Color.GREEN);
		lblNewLabel_2.setBounds(800, 811, 182, 70);
		getContentPane().add(lblNewLabel_2);
		
		JLabel back = new JLabel(new ImageIcon(this.getClass().getResource("/images/alien-3233076.png")));
		back.setBounds(0, 0, 1800, 1000);
		
		JLabel lblNewLabel_3 = new JLabel("Click link to study:");
		lblNewLabel_3.setFont(new Font("Bodoni MT Black", Font.PLAIN, 20));
		lblNewLabel_3.setForeground(Color.GREEN);
		lblNewLabel_3.setBounds(67, 39, 220, 70);
		
		
		
		
		JButton btnNewButton = new JButton("http://www.baidu.com");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.print("click");
				new Thread() {
					public void run() {
						String cmd = "cmd.exe /c start ";
						//web
						String file = "http://www.baidu.com";
						
						try {
							//run
							Runtime.getRuntime().exec(cmd + file);
						} catch (IOException ignore) {
							//print if wrong
							ignore.printStackTrace();
						}

						
					}
				}.start();//start
			}
		});
		btnNewButton.setBounds(297, 66, 387, 23);
		
		
		getContentPane().add(lblNewLabel);
		getContentPane().add(lblNewLabel_1);
		getContentPane().add(lblNewLabel_2);
		getContentPane().add(lblNewLabel_3);
		getContentPane().add(btnNewButton);
		getContentPane().add(back);
		
		
		
		}
	



	 public static void main(String[] args) {
	        new GameFrame();
	    }
}

