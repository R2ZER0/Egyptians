/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package egyptians;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author rikki
 */
public class GameState extends BasicGameState {
    
    //list of all cows, dudes and whatnot
    private List<Entity> entities = new LinkedList<Entity>();
    
    private enum STATES 
    {
        NORMAL_STATE, PLACE_COW_STATE, PLACE_THUNDER_STATE;
    }
    
    private int stateid = -1;
    public GameState(int sid)
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
        
        //let all the entities think
        Iterator<Entity> iter = entities.iterator();
        while(iter.hasNext())
            iter.next().think(delta);
        
  
    }
    
    @Override public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        // TODO render background/moses etc
        
        //render each entity
        Iterator<Entity> iter = entities.iterator();
        while(iter.hasNext())
            iter.next().render(g);
    }
}
