package hypengine.games.Reflex2D;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.*;

public class Menu extends BasicGameState{

	public Menu(int state) {
			
			
			
		}
	
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		
		
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
		Image logo = new Image("res/Full.png");
		Image Play = new Image("res/Play.png");
		Image Exit = new Image("res/Exit.png");
		
		g.drawImage(logo, 200, 50);
		g.drawImage(Play, 400, 350);
		g.drawImage(Exit, 390, 475);
		
				
	}

	
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
	Input input = gc.getInput();
	int Xpos = Mouse.getX();
	int Ypos = 800 - Mouse.getY();	
	
	if((Xpos>400 && Xpos<800) && (Ypos>450 && Ypos<350)) {
		
		if(input.isMouseButtonDown(0)) {
			
			sbg.enterState(1);
			
		}
		
		if((Xpos>400 && Xpos<800) && (Ypos>475 && Ypos<675)) {
			
			if(input.isMouseButtonDown(0)) {
				
				System.exit(0);
				
				}
			}
		
		}
	
	}

	
	public int getID() {
		
		return 0;
	}

}
