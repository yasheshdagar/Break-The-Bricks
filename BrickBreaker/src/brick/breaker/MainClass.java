package brick.breaker;

import java.awt.Color;
import javax.swing.JFrame;

public class MainClass {

	public static void  main(String[] args) {

		JFrame jf=new JFrame();
		GameCode gc=new GameCode();
			
		jf.setVisible(true);
		jf.setBounds(10, 10, 700,600);
		jf.setTitle("Yaaaxi's Game");
	//	jf.setBackground(Color.YELLOW);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(gc);
			
			
			

		}

	}

	


