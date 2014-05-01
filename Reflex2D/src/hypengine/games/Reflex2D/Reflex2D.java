package hypengine.games.Reflex2D;

import java.util.Properties;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Reflex2D extends StateBasedGame{

	public Reflex2D(String gamename) {
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		this.addState(new Pause(pause));
		this.addState(new Inventory(inventory));
	}

	public static final String gamename = "Reflex 2D";
	public static final int menu = 0;
	public static final int play = 1;
	public static final int pause = 2;
	public static final int inventory = 3;
	public static int height = 800, width = 1000;
	
			
	public static void main(String[] args) {
		
		AppGameContainer app;
		
		try {
			
			app = new AppGameContainer(new Reflex2D(gamename + " | " + "FPS:"));
			
			app.setIcons(new String[] { "res/reflex_icon16.png", "res/reflex_icon32.png"} );
			
			app.setDisplayMode(width, height, false);
			
			app.setVSync(true);
						
			app.setShowFPS(false);
									
			app.start();
			
		}catch(SlickException e) {
			e.printStackTrace();			
		}
					
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this); 
		this.getState(pause).init(gc, this); 
		this.getState(inventory).init(gc, this); 
		
		this.enterState(menu);
		
	}
}

