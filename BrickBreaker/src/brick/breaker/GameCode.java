package brick.breaker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameCode extends JPanel implements KeyListener,ActionListener {
	
	Random ran=new Random();
	
	private int rgx=ran.nextInt(50);
	private int randomX=120+rgx;

	private int rgy=ran.nextInt(60);
	private int randomY=350;
	private boolean play=false;
	private int score=0;
	private int totalBricks=21;
	private int sliderX=310;
	private int ballposX=randomX;
	private int ballposY=randomY;
	private int balldirX=-1;
	private int balldirY=-1;
	
	private Timer t;
	private BrickDesign bd;
	
	public GameCode(){
		bd=new BrickDesign(3,7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		t=new Timer(1,this);
		t.start();
	}
	
	public void moveToRight(){
		play=true;
		sliderX+=50;
	}
	
	public void moveToLeft(){
		play=true;
		sliderX-=50;
	}
	
	public void paint(Graphics g){
		
		
		
		
		//bg
		
		g.setColor(Color.BLACK);
		g.fillRect(1, 1, 692, 590);
		
		//borders
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 2);
		g.fillRect(691, 0, 3, 592);
		
		//scores
		
		g.setColor(Color.GREEN);
		g.setFont(new Font("serif",Font.BOLD,35));
		g.drawString("Your score:"+score, 400, 40);
		
		//paddle
		
		g.setColor(Color.RED);
		g.fillRect(sliderX, 550, 110, 8);
		
		//ball
		
		g.setColor(Color.YELLOW);
		g.fillOval(ballposX, ballposY, 20, 20);
		
		//bricks
		
		bd.draw((Graphics2D) g);
		
		if(totalBricks<=0){
			play=false;
			balldirX=0;
			balldirY=0;
			
			g.setColor(Color.PINK);
			g.setFont(new Font("serif",Font.BOLD,35));
			g.drawString("You won,score:"+score, 190, 300);
			g.drawString("Press Enter To Restart:", 200, 350);
		}
		
		if(ballposY>570){
			play=false;
			balldirX=0;
			balldirY=0;
			
			g.setColor(Color.PINK);
			g.setFont(new Font("serif",Font.BOLD,35));
			g.drawString("Game over,score:"+score, 190, 300);
			g.drawString("Press Enter To Restart:", 200, 350);
			
		}
		
	}
	
						
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		t.start();
		
	if(play){
			
		ballposX+=balldirX;
		ballposY+=balldirY;
			
	if(ballposX<0){
		balldirX=-balldirX;
	}
			
	if(ballposY<0){
		balldirY=-balldirY;
	}
			
			
	if(ballposX>670){
		balldirX=-balldirX;
	}
			
	if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(sliderX,550,100,8))){
		balldirY=-balldirY;
	}
	
A:	for(int i=0;i<bd.bricks.length;i++){
		for(int j=0;j<bd.bricks[0].length;j++){
			
			if(bd.bricks[i][j]>0){
				int brickX=j*bd.brickWidth+80;
				int brickY=i*bd.brickHeight+50;
				int brickWidth=bd.brickWidth;
				int brickHeight=bd.brickHeight;
				
				Rectangle r1=new Rectangle(brickX,brickY,brickWidth,brickHeight);
				Rectangle r2=new Rectangle(ballposX,ballposY,20,20);
				Rectangle r3=r1;
				
				if(r2.intersects(r3)){
					bd.setBValue(0, i, j);
					totalBricks-=1;
					score+=5;
					
					if(ballposX+19<=r3.x || ballposX+1>=r3.x+r3.width){
						balldirX=-balldirX;
					}
					
					else{
						balldirY=-balldirY;
					}
					
					break A;
					
				}
				
				
			}
			
			
		}
	}
			
			
		}
		
		
		
		repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			
			if(sliderX>=600)sliderX=600;
			
			else moveToRight();
			
		}
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			

			if(sliderX<=10)sliderX=10;
			
			else moveToLeft();
			
			
		}
		
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			
			if(!play){
				play=true;
				ballposX=randomX;
				ballposY=randomY;
				balldirX=-1;
				balldirY=-1;
				sliderX=310;
				score=0;
				totalBricks=21;
				
				bd=new BrickDesign(3,7);
				
				repaint();
			}
			
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {	
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

											
	
	
	
	
}
