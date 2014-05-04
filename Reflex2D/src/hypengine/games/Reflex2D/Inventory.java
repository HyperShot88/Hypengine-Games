package hypengine.games.Reflex2D;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Inventory extends BasicGameState{

	Image GameOver;
	Image PlayAgain;
	
	public Inventory(int state) {
			
			
			
		}
	
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		
		GameOver = new Image("res/Game Over.png");
		PlayAgain = new Image("res/Replay.png");
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
		g.drawImage(GameOver, 200, 100);
		g.drawImage(PlayAgain, 400, 500);
		
	}

	
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
		int Xpos = Mouse.getX();
		int Ypos = Mouse.getY();	
		
		  if((Xpos>200 && Xpos<450) && (Ypos>234 && Ypos<400)) { //Resume Button
				
				if(Mouse.isButtonDown(0)) {
					
				System.exit(0);
					
					}
				}
		
	}

	
	public int getID() {
		
		return 2;
	}

}