/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package egyptians;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import java.util.Random;
import org.newdawn.slick.Graphics;

/**
 *
 * @author rikki
 */
public class Dude extends Entity {
    
    public static Image dudeImage = null;
    public final static Vector2f DUDE_SIZE = new Vector2f(66, 96);
    public final static float DUDE_SPEED_NORMAL = 0.2f;
    public final static float DUDE_SPEED_SLOW = 0.05f;
    public static float dudeSpeed = 0.2f;
    public float speedmod;
    public Color col = Color.white;
    
    
    static
    {
        if(dudeImage == null)
        {
            try {
                dudeImage = new Image("dude.png");
            } catch (SlickException ex) {
                Logger.getLogger(Dude.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override public void render(Graphics g)
    {
        if (GameState.hailTimeLeft > 0)
            col = Color.cyan;
        else
            col = Color.white;
        
        if(entityImage != null)
            entityImage.draw(pos.x, pos.y, col);
    }
        
    public Dude(Vector2f pos) throws SlickException
    {
        super(dudeImage, pos, DUDE_SIZE);
        speedmod = (float) (StrictMath.random()*0.5 + 0.5);
    }
    
    @Override public void think(int delta)
    {
        //move them forwards a bit
        this.pos.x += delta * dudeSpeed * speedmod;
    }
    
}
