package hypengine.games.Reflex2D;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.ScalableGame;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class Reflex2D extends StateBasedGame{
	
	public static final String gamename = "Reflex 2D";
	public static final int menu = 0;
	public static final int play = 1;
	public static final int inventory = 2;
	public static int height = 800;
	public static int width = 1200;
	public static int customheight = 800;
	public static int customwidth = 1200;

	public Reflex2D(String gamename) {
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		this.addState(new Inventory(inventory));
	}
	
	public Reflex2D(String gamename, int height, int width) {
		super(gamename);
		this.customheight = height;
		this.customwidth = width;
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		this.addState(new Inventory(inventory));
	}

	public static void main(String[] args) {
		
		AppGameContainer appgc;
		
		try {
			
			appgc = new AppGameContainer(new ScalableGame(new Reflex2D(gamename), width, height));
			
			appgc.setIcons(new String[] { "res/reflex_icon16.png", "res/reflex_icon32.png"} );
			
			appgc.setDisplayMode(customwidth, customheight, false);
								
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

