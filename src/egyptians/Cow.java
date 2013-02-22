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
    
    public final static Vector2f COW_SIZE = new Vector2f(200, 50);

    @Override public void think(int delta)
    {
        // cows don't think, stupid!
    }
    
    public Cow(float posx) throws SlickException
    {
        // FIXME - don't create a new image every time (same for dude)
        super(new Image("cow.png"), new Vector2f(), COW_SIZE);
    }
    
}
