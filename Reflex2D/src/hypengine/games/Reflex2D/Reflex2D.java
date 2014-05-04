package hypengine.games.Reflex2D;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class Reflex2D extends StateBasedGame{

	public Reflex2D(String gamename) {
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		this.addState(new Inventory(inventory));
	}

	public static final String gamename = "Reflex 2D";
	public static final int menu = 0;
	public static final int play = 1;
	public static final int inventory = 2;
	public static int height = 800, width = 1200;
	
			
	public static void main(String[] args) {
		
		AppGameContainer appgc;
		
		try {
			
			appgc = new AppGameContainer(new Reflex2D(gamename));
			
			appgc.setIcons(new String[] { "res/reflex_icon16.png", "res/reflex_icon32.png"} );
			
			appgc.setDisplayMode(width, height, false);
								
			appgc.setVSync(true);
						
			appgc.setShowFPS(true);
									
			appgc.start();
			
		}catch(SlickException e) {
			e.printStackTrace();			
		}
					
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this); 
		this.getState(inventory).init(gc, this); 
		
		this.enterState(menu);
		
	}
}

