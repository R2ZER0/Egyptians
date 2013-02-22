/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package egyptians;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author rikki
 */
public class Cow extends Entity {
    
    public static Image cowImage = null;    
    public final static Vector2f COW_SIZE = new Vector2f(180, 99);
    public final static double COW_GRAVITY = 0.6;

    @Override public void think(int delta)
    {
        // cows don't think, stupid!
        // but they do fall down
        pos.y += COW_GRAVITY * delta;
    }
    
    static
    {
        if(cowImage == null)
        {
            try {
                cowImage = new Image("cow.png");
            } catch (SlickException ex) {
                Logger.getLogger(Cow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Cow(float posx) throws SlickException
    {
        // FIXME - don't create a new image every time (same for dude)
        super(cowImage, new Vector2f(posx-(COW_SIZE.x/2), -100), COW_SIZE);
    }
    
}
