/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package egyptians;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author rikki
 */
public class StartState extends BasicGameState {
    
    private int stateid = -1;
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
  
    }
  
    @Override public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
    {
  
    }
    
    @Override public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
  
    }
}
