package java飞机大战.main;



public class Collision {
	private Sound p;
	
	
	
	void bullet_enemy(Bullet b, EnemyPlane e) {
		if(b.getX_Y().getX() >= e.getX_Y().getX()-Bullet.BULLET_WIDTH
				&& b.getX_Y().getX() <= e.getX_Y().getX()+EnemyPlane.ENEMY_SIZE
				&& b.getX_Y().getY() >= e.getX_Y().getY()-Bullet.BULLET_HEIGHT
				&& b.getX_Y().getY() <= e.getX_Y().getY()+EnemyPlane.ENEMY_SIZE) {
			b.stayed = false;
			e.stayed = false;
			if(Sound.b[2]) {
				
				p = new Sound("/sounds/Break.wav");
				p.start();
			}			
			GamePanel.sum += 100;
		}
	}
	
	
	void plane_enemy(MyPlane m, EnemyPlane e) {
		if(m.getX_Y().getX() >= e.getX_Y().getX()-MyPlane.PLANE_SIZE
				&& m.getX_Y().getX() <= e.getX_Y().getX()+EnemyPlane.ENEMY_SIZE
				&& m.getX_Y().getY() >= e.getX_Y().getY()-MyPlane.PLANE_SIZE
				&& m.getX_Y().getY() <= e.getX_Y().getY()+EnemyPlane.ENEMY_SIZE) {
			e.stayed = false;
			if(GamePanel.live <= 50) {
				m.stayed = false;
				if(Sound.b[3]) {
					
					p = new Sound("/sounds/HeroBrustSound.wav");
					p.start();
				
				}
				GamePanel.live = 0;
			} else
				GamePanel.live -= 50;
		}
	}
	
	
	void bullet_plane(Bullet b, MyPlane m) {
		if(b.getX_Y().getX() >= m.getX_Y().getX()-Bullet.BULLET_WIDTH
				&& b.getX_Y().getX() <= m.getX_Y().getX()+MyPlane.PLANE_SIZE-Bullet.BULLET_WIDTH
				&& b.getX_Y().getY() >= m.getX_Y().getY()-Bullet.BULLET_HEIGHT
				&& b.getX_Y().getY() <= m.getX_Y().getY()+MyPlane.PLANE_SIZE) {
			b.stayed = false;
			if(GamePanel.live <= 5) {
				m.stayed = false;
				if(Sound.b[3]) {
					//��ҷɻ���ը����
					p = new Sound("/sounds/HeroBrustSound.wav");					
						p.start();			
			    }
				GamePanel.live = 0;
			
			} else
				GamePanel.live -= 5;
		}
	}
	
	
	void boss_plane(BossPlane b, MyPlane m) {
		if(b.getX_Y().getX() >= m.getX_Y().getX()-BossPlane.BOSS_WIDTH
				&& b.getX_Y().getX() <= m.getX_Y().getX()+MyPlane.PLANE_SIZE
				&& b.getX_Y().getY() >= m.getX_Y().getY()-BossPlane.BOSS_HEIGHT
				&& b.getX_Y().getY() <= m.getX_Y().getY()+MyPlane.PLANE_SIZE) {
			m.stayed = false;
			if(Sound.b[3]) {
				
				p = new Sound("/sounds/HeroBrustSound.wav");
				p.start();		
		    }
			GamePanel.live = 0;
		}
	}
	
	
	
	
	
}
