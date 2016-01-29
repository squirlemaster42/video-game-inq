package com.winfirst.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.winfirst.graphics.Animation;
import com.winfirst.tile.Assets;
import com.winfirst.tile.Tile;
import com.winfirst.utils.Handler;

public class Player extends Creature{
	
	//Animations
	private Animation animDown, animLeft, animRight, animUp, animStop;
	private int gravity = 20;
	private boolean isJumping = false;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 7;
		bounds.y = 65;
		bounds.width = 18;
		bounds.height = 35;
		
		//Animations
		animDown = new Animation(500, Assets.playerDown);
		animLeft = new Animation(500, Assets.playerLeft);
		animRight = new Animation(500, Assets.playerRight);
		animUp = new Animation(500, Assets.playerUp);
		animStop = new Animation(500, Assets.playerStop);
	}

	@Override
	public void tick() {
		//Animations
		animDown.tick();
		animLeft.tick();
		animRight.tick();
		animUp.tick();
		animStop.tick();
		
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().space){
			if(gravity > 0 && !isJumping){
				yMove -= gravity;
				gravity --;
				
				if(gravity == 0){
					isJumping = true;
				}
			}else{
				if(isJumping){
					gravity++;
					yMove += gravity;
					if(gravity == 30){
						isJumping = false;
					}
				}
			}
			
		}else{
			yMove += speed;
		}
		
	    if(handler.getKeyManager().right)
			xMove += speed;
			
		if(handler.getKeyManager().left)
			xMove -= speed;
		
		yMove += 2;
		
		if(handler.getKeyManager().r){
			this.setX(100);
			this.setY(100);
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
//		g.setColor(Color.red);
//		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
//				(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
//				bounds.width, bounds.height);
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		if(xMove < 0){
			return animLeft.getCurrentFrame();
		}else if(xMove > 0){
			return animRight.getCurrentFrame();
		}else if(yMove < 0){
			return animUp.getCurrentFrame();
		}else{
			return animStop.getCurrentFrame();
		}
	}
	
}
