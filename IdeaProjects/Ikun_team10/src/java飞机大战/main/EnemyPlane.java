package java飞机大战.main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;


public class EnemyPlane {
	static final int ENEMY_SIZE = 80;
	private Image enemyPic[];
	private int enemy_x, enemy_y;
	private int enemy_y0;
	private final int Speed = 2;
	boolean stayed = true;
	private Break b;
	private int id=0;
	
	public EnemyPlane(int y)
	{
		
		enemy_x = (int) (Math.random()*2000);
		enemy_y0 = enemy_y = y;
		enemyPic = new Image[5];
		for(int i = 1; i <= enemyPic.length; i++) {
			enemyPic[i-1] = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/bullet0" + i + ".png"));
		}
	}
	
	
	public void drawEnemy(Graphics g,Canvas c, int i)
	{
		if(stayed)
			g.drawImage(enemyPic[i], enemy_x, enemy_y, ENEMY_SIZE, ENEMY_SIZE, c);
		
		else if(id == 0&&!stayed) {
			b = new Break(enemy_x, enemy_y);
			b.enemy_break(g, c, id);
			id++;
		}
		
		if(b != null && id != 0)
			if(id == 5){
				b.enemy_break(g, c, id);
				id = 0;
			} else {
				b.enemy_break(g, c, id);
				id++;
			}
		
	}
	
	
	public void enemyMove() {
		if(enemy_y > GamePanel.MAP_HEIGHT || stayed == false)
		{
			if(GamePanel.time >= 10000) {
				enemy_x = 0;
				enemy_y = GamePanel.MAP_HEIGHT+MyPlane.PLANE_SIZE;
			}	
			else {
				enemy_x = (int) (Math.random()*2000);
				enemy_y = enemy_y0;
				stayed = true;
			}
		}else
			enemy_y += Speed;			
	}
	
	
    Point getX_Y() {
		return new Point(enemy_x, enemy_y);		
	}
	
}
