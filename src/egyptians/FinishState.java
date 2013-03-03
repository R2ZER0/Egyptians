/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package egyptians;

import org.newdawn.slick.Color;
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
public class FinishState extends BasicGameState {
    
    boolean goBack = false;
    private int stateid;
    Image bg;
    
    public FinishState(int sid)
    {
        stateid = sid;
    }
    
    @Override public int getID()
    {
        return stateid;
    }
    
    @Override public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        goBack = false;
        bg = new Image("death.png");
    }
  
    @Override public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
    {
        if(goBack)
        {
            sbg.enterState(Egyptians.STARTSTATE);
            init(gc, sbg);
        }
    }
    
    @Override public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        bg.draw();
        g.setColor(Color.red);
        g.drawString("Final Score: " + GameState.score, 150, 400);
    }
    
    @Override public void keyPressed(int key, char c)
    {
        if (key == 28) {
            GameState.score = 0;
            GameState.DUDE_PROBABILITY_KINDA_THING = 0.7;
            goBack = true;
        }
    }
}