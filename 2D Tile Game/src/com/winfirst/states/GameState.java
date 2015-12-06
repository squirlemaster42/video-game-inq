package com.winfirst.states;

import java.awt.Graphics;

import com.winfirst.entity.Player;
import com.winfirst.game.Game;

public class GameState extends State{
	
	private Player player;

	
	public GameState(Game game){
		super(game);
		player = new Player(game, 100, 100);
	}
	
	@Override
	public void tick() {
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		player.render(g);
	}
	
	
}
