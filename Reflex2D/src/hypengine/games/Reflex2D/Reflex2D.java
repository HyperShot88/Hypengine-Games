package hypengine.games.Reflex2D;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Reflex2D extends BasicGame{

		public Reflex2D(String title) {
		super(title);
	}
	
	
	public void init(GameContainer container) throws SlickException {
		
		
		
	}
	
	public void update(GameContainer container, int delta) throws SlickException {
		
		
		
	}
	
	public void render(GameContainer container, Graphics r) throws SlickException {
		
		
					
	}

	public static void main(String[] args) throws SlickException {
		
		AppGameContainer app =  new AppGameContainer(new Reflex2D("Reflex 2D" + " | "));
		
		app.setDisplayMode(800, 600, false);
		
		app.setShowFPS(false);
					
		app.start();
		
	}
}

