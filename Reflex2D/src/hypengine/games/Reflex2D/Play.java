package hypengine.games.Reflex2D;

import org.lwjgl.input.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState{
	
	boolean quit = false;
	Image Resume;
	Image Quit;
	
	public Play(int state) {
			
			
			
		}
	
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		
		Resume = new Image("res/Resume.png");
		Quit = new Image("res/ExitToMenu.png");
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
		 if(quit==true){
	         g.drawImage(Resume, 225, 100);
	         g.drawImage(Quit, 225, 500);
	         if(quit==false){
	            g.clear();
	         }
	    }
		
	}

	
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput();
		int Xpos = Mouse.getX();
		int Ypos = Mouse.getY();	
		
		  if(input.isKeyDown(Input.KEY_ESCAPE)){
		         
			  quit = true;
			  			  		  
	   }
		  
		  if(quit==true){
			  
			  if((Xpos>225 && Xpos<975) && (Ypos>500 && Ypos<700)) { //Resume Button
					
					if(Mouse.isButtonDown(0)) {
						
					quit = false;
						
						}
					}
			  
			  if((Xpos>225 && Xpos<975) && (Ypos>100 && Ypos<300)) { //Exit Menu Button
					
					if(Mouse.isButtonDown(0)) {
						
					sbg.enterState(0);
						
				    try{
			               Thread.sleep(250);
			            }catch(InterruptedException e){
			               e.printStackTrace();
			         }
			      }
			  }
			  
		  }
		         
	}

	
	public int getID() {
		
		return 1;
	}

}