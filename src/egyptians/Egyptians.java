/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/* Highscores
 * 1.   Lewis Barker    67750
 */

package egyptians;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author rikki & lewis
 */
public class Egyptians extends StateBasedGame {
    
    public static final int STARTSTATE = 0;
    public static final int GAMESTATE = 1;
    public static final int FINISHSTATE = 2;
    public static final Vector2f WINDOW_SIZE = new Vector2f(1024, 600);
    
    private Egyptians()
    {
        super("Egyptians");
    }
    
    @Override public void initStatesList(GameContainer gameContainer) throws SlickException
    {
        this.addState(new StartState(STARTSTATE));
        this.addState(new GameState(GAMESTATE));
        this.addState(new FinishState(FINISHSTATE));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SlickException
    {
        System.setProperty("org.lwjgl.librarypath",System.getProperty("user.home") + "/natives");
        System.setProperty("net.java.games.input.librarypath", System.getProperty("org.lwjgl.librarypath"));
        
        AppGameContainer app = new AppGameContainer(new Egyptians());
        app.setDisplayMode(1024, 600, false);
        app.start();
    }
}
