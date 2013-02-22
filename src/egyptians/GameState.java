/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package egyptians;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rikki
 */
public class GameState extends BasicGameState
{
    
    Image stage = null;
    Image moses = null;

    private List<Cow> cows = new LinkedList<>();
    private List<Dude> dudes = new LinkedList<>();

    Image[] boxes = new Image[4];
    
    private enum STATES 
    {
        NORMAL_STATE, PLACE_COW_STATE, PLACE_THUNDER_STATE;
    }
    
    //private STATES state = STATES.NORMAL_STATE;
    private STATES state = STATES.PLACE_COW_STATE;
    
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
        this.moses = new Image("moses.png");
        this.boxes[0] = new Image("box1.png");
        this.boxes[1] = new Image("box2.png");
        this.boxes[2] = new Image("box3.png");
        this.boxes[3] = new Image("box4.png");
    }
  
    Random randomGenerator = new Random();
    @Override public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
    {
        final double DUDE_PROBABILITY_KINDA_THING = 0.2;
        // shall we create a Dude? lets ask probability!
        if(randomGenerator.nextDouble() * delta < DUDE_PROBABILITY_KINDA_THING)
            createDude();
        
        //let all the entities think
        Iterator<? extends Entity> iter = dudes.iterator();
        while(iter.hasNext())
            iter.next().think(delta);
        
        iter = cows.iterator();
        while(iter.hasNext())
            iter.next().think(delta);
        
        // Check if a cow is landing on a dude
        ListIterator<Cow> cowIter = cows.listIterator();
        while(cowIter.hasNext())
        {
            Cow c = cowIter.next();
            // check if it's gone offscreen
            if(c.pos.y > Egyptians.WINDOW_SIZE.x)
            {
                cowIter.remove();
                continue;
            }
            
            ListIterator<Dude> dudeIter = dudes.listIterator();
            while(dudeIter.hasNext())
            {
                Dude d = dudeIter.next();
                
                //collision test for the cow/dude
                if(c.pos.y + c.size.y < d.pos.y) break;
                if(c.pos.x + c.size.x < d.pos.x) break;
                if(c.pos.x > d.pos.x + d.size.x) break;
                //if we get here, it's a collission
                cowCollide(c, d);
                dudeIter.remove();
            }
            
        }
        
        // TODO place here all the logic which calls the event methods below
  
    }
    
    @Override public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        // TODO render background/moses etc here
        stage.draw(0, 0);
        moses.draw(880, 200);
        for (int i=0;i<4;i++)
        {
            boxes[i].draw(30+i*130, 30);
        }
        //render each entity
        Iterator<? extends Entity> iter = dudes.iterator();
        while(iter.hasNext())
            iter.next().render(g);
        
        iter = cows.iterator();
        while(iter.hasNext())
            iter.next().render(g);
    }
    
    private void createDude() throws SlickException
    {
        final Vector2f DUDE_START_POS = new Vector2f(-100, 300);
        Dude thisguy = new Dude(DUDE_START_POS);
        dudes.add(thisguy);
    }
    
    @Override public void mousePressed(int button, int x, int y)
    {
        try {
            if(state == STATES.PLACE_COW_STATE)
                placeCow(x);
            else if(state == STATES.PLACE_THUNDER_STATE)
                shootThunder(x);
        } catch (SlickException ex) {
            Logger.getLogger(GameState.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    private void placeCow(int xpos) throws SlickException
    {
        Cow moocow = new Cow(xpos); //cows go moo
        cows.add(moocow); //and now it gets to go join the herd
        state = STATES.NORMAL_STATE;
    }
    
    //this is called when they choose where to shoot thunder
    private void shootThunder(float xpos)
    {
        // TODO shoot that lightning!
        state = STATES.NORMAL_STATE;
    }
    
    //when a cow collides with a dude
    private void cowCollide(Cow cow, Dude dude)
    {
        //cowcount or something? this is perhaps useless
    }
}
