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
    
    public Dude(Vector2f pos) throws SlickException
    {
        super(new Image("dude.png"), pos, DUDE_SIZE);
    }
    
    public void think(int delta)
    {
        //dudes can't think yet
    }
    
}
