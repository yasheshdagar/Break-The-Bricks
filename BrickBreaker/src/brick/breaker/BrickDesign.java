package brick.breaker;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class BrickDesign {

	public int bricks[][];
	public int brickWidth;
	public int brickHeight;
	
	
	public BrickDesign(int row, int column){
		
		bricks=new int[row][column];
		
		for(int i=0;i<bricks.length;i++){
			for(int j=0;j<bricks[0].length;j++){
				bricks[i][j]=1;
			}
		}
		
		brickWidth=560/column;
		brickHeight=150/row;
		
	}
	
	public void draw(Graphics2D g){
		
		
		for(int i=0;i<bricks.length;i++){
			for(int j=0;j<bricks[0].length;j++){
				
				if(bricks[i][j]>0){
					g.setColor(Color.WHITE);
					g.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
					
					g.setStroke(new BasicStroke(6));
					g.setColor(Color.BLACK);
					g.drawRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
					
					
				}
				
			}
			
		}
		
		
	}
	
	public void setBValue(int value,int row,int column){
		bricks[row][column]=0;
	}
	
}
