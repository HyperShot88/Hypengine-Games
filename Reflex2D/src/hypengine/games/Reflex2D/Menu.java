package hypengine.games.Reflex2D;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.*;

public class Menu extends BasicGameState{

	Image Logo;
	Image Play;
	Image Exit;
	Image Graphic;
	Image CompLogo;
	boolean Graphic1 = false;
	boolean Graphic2 = false;
	boolean LogoFlash = true;
	int Timer;
	double time = 0;
	
	public Menu(int state) {
			
		
			
		}
	
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		
		Logo = new Image("res/Full.png");
		Play = new Image("res/Play2.png");
		Exit = new Image("res/Exit2.png");
		Graphic = new Image("res/diamond.png");
		CompLogo = new Image("res/Logo.png");
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
					
		if(LogoFlash==true) {
			
			g.drawImage(CompLogo, 225, 25);
			
		}
		
		if(LogoFlash==false) {
		
		g.drawImage(Logo, 200, 50);
		g.drawImage(Play, 470, 375);
		g.drawImage(Exit, 470, 575);
			
				
		 if(Graphic1==true){
	         
			 g.drawImage(Graphic, 290, 375);
			 g.drawImage(Graphic, 760, 375);
			 
	         if(Graphic1==false){
	            g.clear();
	         }
	    }
		 
		 if(Graphic2==true){
	         
			 g.drawImage(Graphic, 290, 575);
			 g.drawImage(Graphic, 760, 575);
			 
	         if(Graphic2==false){
	            g.clear();
	        }
	         
	    }
			
	}
		
	}

	
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
		int Xpos = Mouse.getX();
		int Ypos = Mouse.getY();	
		
	if(LogoFlash==true) {
		
		time += .003;
		Timer = (int) time;
		
		if(Timer==1) {
			
			LogoFlash = false;
			
		}
		
	}
	
	if(LogoFlash==false) {
	
	if((Xpos>470 && Xpos<725) && (Ypos>275 && Ypos<425)) { //Play button
		
		Graphic1 = true;
						
		if(Mouse.isButtonDown(0)) {
			
			sbg.enterState(1);
			
		}
		
	}
	
	if(!(Xpos>470 && Xpos<725) && !(Ypos>275 && Ypos<425)) { //Play button
		
		Graphic1 = false;
	
		}
	
			
		if((Xpos>470 && Xpos<725) && (Ypos>75 && Ypos<225)) { //Exit Button
			
			Graphic2 = true;
			
			if(Mouse.isButtonDown(0)) {
				
			System.exit(0);
				
				}
			}
		
		if(!(Xpos>470 && Xpos<725) && !(Ypos>75 && Ypos<225)) { //Play button
			
			Graphic2 = false;
		
			}
		
		if((Xpos>470 && Xpos<725) && (Ypos>226 && Ypos<274)) { //Play button
			
		Graphic1 = false;	
		Graphic2 = false;
		
		}			
	}
	
	}
			
	public int getID() {
		
		return 0;
	}

}
