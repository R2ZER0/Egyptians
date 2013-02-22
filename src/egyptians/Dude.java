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
public class Dude extends Entity {
    
    public static Image dudeImage = null;
    public final static Vector2f DUDE_SIZE = new Vector2f(66, 96);
    public final static float DUDE_SPEED = 0.2f;
    
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
    
    public Dude(Vector2f pos) throws SlickException
    {
        super(dudeImage, pos, DUDE_SIZE);
    }
    
    @Override public void think(int delta)
    {
        //move them forwards a bit
        this.pos.x += delta * DUDE_SPEED;
    }
    
}
