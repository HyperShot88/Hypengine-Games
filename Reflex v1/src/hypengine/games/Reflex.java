package hypengine.games;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import de.matthiasmann.twl.utils.PNGDecoder;

public class Reflex {
	
	public static void main(String args[]) {
		Reflex reflex = new Reflex();
	}
	
	public Reflex() {
		create();
		update();
		destroy();
	}
	
	private void create() {
		try {
			ByteBuffer[] icon = new ByteBuffer[2];
			icon[0] = imgBuffer("res/reflex_icon16.png");
			icon[1] = imgBuffer("res/reflex_icon32.png");
			
			
			Display.setDisplayMode(new DisplayMode(800, 600));
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
	
	private void pollInput() {
		while (Keyboard.next()) {
			try {
				if (Keyboard.isKeyDown(Keyboard.KEY_F11)) {
					Display.setFullscreen(true);
				}
			} catch (LWJGLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private void update() {
		while (!Display.isCloseRequested()) {
			Display.update();
			Display.sync(60);
		}
	}
	
	private void destroy() {
		Display.destroy();
		System.exit(0);
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
