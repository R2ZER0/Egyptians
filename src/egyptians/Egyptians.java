/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package egyptians;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author rikki & lewis
 */
public class Egyptians extends StateBasedGame {
    
    public static final int STARTSTATE = 0;
    public static final int GAMESTATE = 1;
    
    private Egyptians()
    {
        super("Egyptians");
    }
    
    @Override public void initStatesList(GameContainer gameContainer) throws SlickException
    {
        this.addState(new StartState(STARTSTATE));
        this.addState(new GameState(GAMESTATE));
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
