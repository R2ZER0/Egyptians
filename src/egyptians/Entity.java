/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package egyptians;

import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Image;

/**
 *
 * @author rikki
 */
abstract public class Entity {
    
    public Image entityImage = null;
    
    public Vector2f pos, size;
    
    public Entity(Image img, Vector2f pos, Vector2f size)
    {
        this.entityImage = img;
        this.pos = pos;
        this.size = size;
    }    
}