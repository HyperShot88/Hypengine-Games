package hypengine.games.Reflex2D;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.*;

public class Menu extends BasicGameState{

	Image Logo;
	Image Play;
	Image Exit;
	
	
	public Menu(int state) {
			
		
			
		}
	
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		
		Logo = new Image("res/Full.png");
		Play = new Image("res/Play2.png");
		Exit = new Image("res/Exit2.png");
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
						
		g.drawImage(Logo, 200, 50);
		g.drawImage(Play, 470, 375);
		g.drawImage(Exit, 470, 575);
						
	}

	
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
		int Xpos = Mouse.getX();
		int Ypos = Mouse.getY();	
		
	if((Xpos>470 && Xpos<725) && (Ypos>275 && Ypos<425)) { //Play button
		
		if(Mouse.isButtonDown(0)) {
			
			sbg.enterState(1);
			
		}
		
	}
		
		if((Xpos>470 && Xpos<730) && (Ypos>75 && Ypos<225)) { //Exit Button
			
			if(Mouse.isButtonDown(0)) {
				
			System.exit(0);
				
				}
			}
		
		}
			
	public int getID() {
		
		return 0;
	}

}
