package hypengine.games;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL11.*;
import org.lwjgl.util.glu.GLU;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import de.matthiasmann.twl.utils.PNGDecoder;

public class Reflex implements Runnable {
	
	public int Width = 800;
	public int Height  = 600;
	
	private boolean running;
	
	public static void main(String args[]) {
		Reflex reflex = new Reflex();
		reflex.start();
	}
	
	public void start() {
		
		this.running = true;
		new Thread(this).start();
		
	}
	
	public void stop() {
		
		Display.destroy();
		System.exit(0);
		this.running = false;
		
	}
	
	public void initProg() {
		
		
		
	}
	
	public void run() {
		this.create();
		this.initOpenGL();
		
		while (running) {
			this.tick();
			this.render();
			
			if (Display.isCloseRequested()) stop();
				Display.update();
				Display.sync(60);
			
		}
		
	}
			
	private void create() {
		try {
			ByteBuffer[] icon = new ByteBuffer[2];
			icon[0] = imgBuffer("res/reflex_icon16.png");
			icon[1] = imgBuffer("res/reflex_icon32.png");
			
			
			Display.setDisplayMode(new DisplayMode (800,600));
			Display.setResizable(true);
			Display.setVSyncEnabled(true);
			Display.setTitle("Reflex v1");
			Display.setIcon(icon);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
				
		
	public void initOpenGL() {
		
	
		
	}
	
	public void render() {
		
		
		
	}
	
	public void tick() {
		
		
				
	}
	
	public Texture imgTexture(String filename, String format)
			throws IOException {

		InputStream in = new FileInputStream(filename); // load image
		Texture image = TextureLoader.getTexture(format, in);
		in.close();

		return image;
	}
	
	public ByteBuffer imgBuffer(String filename) throws IOException {
		FileInputStream in = new FileInputStream(filename); // load image
		PNGDecoder decoder = new PNGDecoder(in);

		ByteBuffer buffer = ByteBuffer.allocateDirect(4 * decoder.getWidth() * decoder.getHeight());
		decoder.decode(buffer, decoder.getWidth() * 4, PNGDecoder.Format.RGBA);
		buffer.flip();
		in.close();
		
		return buffer;
	}
	
}
