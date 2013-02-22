/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package egyptians;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author rikki
 */
public class StartState extends BasicGameState {
    
    Image start = null;
    Image button = null;
    
    private int stateid = -1;
    private boolean moveOn = false;
    public StartState(int sid)
    {
        stateid = sid;
    }
    
    @Override public int getID()
    {
        return stateid;
    }
    
    @Override public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        this.start = new Image("start.png");
        this.button = new Image("button.png");
        moveOn = false;
    }
  
    @Override public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
    {
        if (moveOn)
        {
            sbg.enterState(Egyptians.GAMESTATE);
            init(gc, sbg);
        }
    }
    
    @Override public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        start.draw(0, 0);
        button.draw(62, 350);
    }
    
    @Override public void mousePressed(int button, int x, int y)
    {
        if (y < 550 && y > 350 && x < 462 && x > 62)
            moveOn = true;
    }
}
