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
public class Cow extends Entity {
    
    public final static Vector2f COW_SIZE = new Vector2f(100, 60);
    public final static double COW_GRAVITY = 0.4;

    @Override public void think(int delta)
    {
        // cows don't think, stupid!
        // but they do fall down
        pos.y -= COW_GRAVITY * delta;
    }
    
    public Cow(float posx) throws SlickException
    {
        // FIXME - don't create a new image every time (same for dude)
        super(new Image("cow.png"), new Vector2f(), COW_SIZE);
    }
    
}
