package hypengine.games.Reflex2D;

import org.lwjgl.input.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Play extends BasicGameState{
	
	boolean quit = false;
	Image Resume;
	Image Quit;
	boolean MapInt = false;
	Image Map;
	Image Grasslands;
	Image GrasslandsThumb;
	Image Grass;
	Image City;
	Image Prompt;
	int maxHealth = 100;
	double Health = 23;
	int currentHealth;
	float CharacterX = -1000;
	float CharacterY = -1334;
	float shiftX = CharacterX + 1502;
	float shiftY = CharacterY + 1754;
	Animation Character, CharacterWalkingLeft, CharacterWalkingRight, BulletRight, BulletLeft;
	int[] duration = {200, 200};
	
	
	public Play(int state) {
			
			
			
		}

	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		
		Resume = new Image("res/Resume.png");
		Quit = new Image("res/ExitToMenu.png");
		GrasslandsThumb = new Image("res/Grassland Map Thumbnail.png");
		Grass = new Image("res/Grasslands.png");
		Prompt = new Image("res/Map.png");
		Image[] walkingLeft = {};
		Image[] walkingRight = {new Image("res/Character Right/Start Right.png"), new Image("res/Character Right/Right 1.png"), new Image("res/Character Right/End Right.png")};
		
		CharacterWalkingLeft = new Animation(walkingLeft, duration, false);
		CharacterWalkingRight = new Animation(walkingRight, duration, false);
		Character = CharacterWalkingRight;
				
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
		if(MapInt==false) {
		
			g.drawImage(Prompt, 400, 150);
			g.drawImage(GrasslandsThumb, 200, 300);
			g.drawImage(Grass, 230, 570);			
			
		}
			
			if(MapInt==true) {
				
				g.drawImage(Map, CharacterX, CharacterY);
					
				g.drawAnimation(Character, shiftX, shiftY);
				
				g.setColor(Color.black);
				g.drawRect(10, 725, maxHealth,30);
				g.setColor(Color.black);
				g.fillRect(10, 725, maxHealth,30);
				g.setColor(Color.red);
				g.fillRect(10, 725, currentHealth, 30);
				g.setColor(Color.black);
				g.drawString("Health: " + currentHealth + "/" + maxHealth, 10, 760);
				
		}
		
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
				
		if(quit==false){
			
			
			if(input.isKeyDown(Input.KEY_D)) {
				
				Character = CharacterWalkingRight;
				
				CharacterX -= delta * .1f;
				
			}
			
			
			if(currentHealth==100) {
				
				Health += 0;
				
				}
				
				if(currentHealth<100) {
					
					Health += .008;
					currentHealth = (int)(Health);
					
				}
			
		}
			
		if(MapInt==false) {
		
		  if((Xpos>200 && Xpos<450) && (Ypos>234 && Ypos<400)) { //Resume Button
				
				if(Mouse.isButtonDown(0)) {
					
				MapInt = true;
				Map = new Image("res/Grassland Map.png");
					
					}
				}
		  
			}
		
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
						
					sbg.enterState(0, new FadeOutTransition(), new FadeInTransition());
										
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