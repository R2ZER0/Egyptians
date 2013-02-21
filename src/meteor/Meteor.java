/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package meteor;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author rikki & lewis
 */
public class Meteor extends BasicGame {
    
    private Meteor()
    {
        super("Meteor");
    }
    
    @Override public void init(GameContainer gc) throws SlickException
    {
        //init
    }
    
    @Override public void update(GameContainer gc, int delta) throws SlickException
    {
        //update
    }
    
    @Override public void render(GameContainer gc, Graphics g) throws SlickException
    {
        //render
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SlickException
    {
        AppGameContainer app = new AppGameContainer(new Meteor());
        app.setDisplayMode(1024, 600, false);
        app.start();
    }
}
