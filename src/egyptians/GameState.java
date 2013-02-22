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
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author rikki
 */
public class GameState extends BasicGameState {
    
    //list of all cows, dudes and whatnot
    Image stage = null;
    private List<Entity> entities = new LinkedList<Entity>();
    
    private enum STATES 
    {
        NORMAL_STATE, PLACE_COW_STATE, PLACE_THUNDER_STATE;
    }
    
    private STATES state = STATES.NORMAL_STATE;
    
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
        this.stage = new Image("stage.png");
    }
  
    @Override public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
    {
        
        //let all the entities think
        Iterator<Entity> iter = entities.iterator();
        while(iter.hasNext())
            iter.next().think(delta);
        
        // TODO place here all the logic which calls the event methods below
  
    }
    
    @Override public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        // TODO render background/moses etc here
        stage.draw(0, 0);
        
        //render each entity
        Iterator<Entity> iter = entities.iterator();
        while(iter.hasNext())
            iter.next().render(g);
    }
    
    private void createDude() throws SlickException
    {
        final Vector2f DUDE_START_POS = new Vector2f(-100, 300-Dude.DUDE_SIZE.y);
        Dude thisguy = new Dude(DUDE_START_POS);
        entities.add(thisguy);
    }
    
    ////// event methods //////
    // functions called when the user presses one of the power buttons
    private void doCow()
    {
        state = STATES.PLACE_COW_STATE;
    }
    
    private void doThunder()
    {
        state = STATES.PLACE_THUNDER_STATE;
    }
    
    private void doHailstorm()
    {
        
    }
    
    private void doAngelOfDeath()
    {
        
    }
    
    //this is called when the user chooses where to place the cow (i.e mouse click)
    private void placeCow(float xpos) throws SlickException
    {
        Cow moocow = new Cow(xpos); //cows go moo
        entities.add(moocow);
        // TODO spawn the cow!
        state = STATES.NORMAL_STATE;
    }
    
    //this is called when they choose where to shoot thunder
    private void shootThunder(float xpos)
    {
        // TODO shoot that lightning!
        state = STATES.NORMAL_STATE;
    }
}
