package java飞机大战.main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

public class Bullet {
	static final int BULLET_WIDTH = 15;//�ӵ���
	static final int BULLET_HEIGHT = 30;//�ӵ���
	private int bullet_x, bullet_y;//�ӵ�����
	private final int STEP = 5;//��ҷɻ��ӵ��ٶ�
	private final int eSTEP =5;//�л��ӵ��ٶ�
	private Image bullet01, bullet02;//�ӵ�ͼƬ
	private final int TIME = 200;//��ҷɻ��ӵ�������ʱ��
	private final int eTIME = 5000;//�л��ӵ�������ʱ��
	boolean stayed = true;//�ӵ����ڱ�ʶ
	static long before_time;//��ȥ������ҷɻ��ӵ�ʱ��
	static long[] ebefore_time = new long[10];//��ȥ���Ƶл��ӵ�ʱ��
	
    public Bullet(int x, int y) {
		
		//��ʼ������
		bullet_x = x;
		bullet_y = y;
		
		bullet01 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/bullet_01.png"));//�����ӵ�ͼƬ
		bullet02 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/bullet_02.png"));//���õл��ӵ�ͼƬ
		
		}
    
    public void drawBullet(Graphics g, Canvas c,int i) {
    	if(i == 1)
    		g.drawImage(bullet01, bullet_x, bullet_y, BULLET_WIDTH,BULLET_HEIGHT, c);//�����ӵ�
    	else
    		g.drawImage(bullet02, bullet_x, bullet_y, BULLET_WIDTH, BULLET_WIDTH, c);//�����ӵ�

	}
    
   // ��ҷɻ��ӵ����Ʒ���������ʱ�������ж�   
    public void drawBullet_1(ArrayList<Bullet> array, Graphics g, Canvas c) {
    	long now_time = System.currentTimeMillis();
    	if(now_time-before_time >= TIME)//�ж��Ƿ����ӵ�
    	{    		
    		array.add(this);//�ӵ�����ӽ�����
			before_time = now_time;//������ʱ����Ϊ��ȥʱ	
    	}
	}
    
   // �л��ӵ����Ʒ���������ʱ�������ж�   
    void drawBullet_2(ArrayList<Bullet> array, Graphics g, Canvas c, int i) {
    	long now_time = System.currentTimeMillis();
    	if(now_time-ebefore_time[i] >= eTIME)//�ж��Ƿ����ӵ�
    	{  		
    		array.add(this);//�ӵ�����ӽ�����
			ebefore_time[i] = now_time;//������ʱ����Ϊ��ȥʱ			
    	}
	}
    
    // boss�ӵ����Ʒ���
    public void drawBullet_3(Graphics g, Canvas c) {
    	drawBullet(g, c, 2);    	
    }
    
    //������ҷɻ��ӵ��ƶ�����
   public void bulletMove(ArrayList<Bullet> array, int i) {
		
		if(bullet_y < -BULLET_HEIGHT || stayed == false)
			array.remove(i);//���������Ƴ��ӵ�����
		else
			bullet_y -= STEP;
	}
   
   //���Ƶл��ɻ��ӵ��ƶ�����
   void bulletMove1(ArrayList<Bullet> array, int i) {
		
		if(bullet_y > GamePanel.MAP_HEIGHT || stayed == false)
			array.remove(i);//���������Ƴ��ӵ�����
		else
			bullet_y += eSTEP;
	}
   
   //����boss�ӵ��ƶ�����
   public void bulletMove2(ArrayList<Bullet[]> arr, int i, int j) {
		if(stayed)
			switch (j) {
			case 0:
				bullet_x -= 2;
				bullet_y += 2;
				break;
			case 1:
				bullet_x -= 1;
				bullet_y += 2;
				break;
			case 2:
				bullet_y += 2;
				break;
			case 3:
				bullet_x += 1;
				bullet_y += 2;
				break;
			case 4:
				bullet_x += 2;
				bullet_y += 2;
				break;
			default:
				break;
			}
		else
			arr.get(i)[j] = null;
	}
   
   
    public Point getX_Y() {
		
		return new Point(bullet_x, bullet_y);
		
	}
   
   
   
    
}
