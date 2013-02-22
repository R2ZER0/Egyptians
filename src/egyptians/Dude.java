/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package egyptians;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author rikki
 */
public class Dude extends Entity {
    
    public final static Vector2f DUDE_SIZE = new Vector2f(50, 250);
    public final static float DUDE_SPEED = 0.5f;
    
    public Dude(Vector2f pos) throws SlickException
    {
        super(new Image("dude.png"), pos, DUDE_SIZE);
    }
    
    @Override public void think(int delta)
    {
        //move them forwards a bit
        this.pos.x += delta * DUDE_SPEED;
    }
    
}
