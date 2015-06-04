/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.*;
import org.havi.ui.HComponent;
import org.dvb.ui.*;

/**
 *
 * @author student
 */



public class MijnComponent extends HComponent{
    
    private Image stars;
    private Image ship;
    int starsx = 0;
    int starsy = 0;
    int shipx = 340;
    int shipy = 500;
    MediaTracker mt;
    
    public MijnComponent () {
        
        
        stars = this.getToolkit().getImage("sterren.png");
        ship = this.getToolkit().getImage("spaceship.png");
        mt = new MediaTracker(this);
        mt.addImage(stars,0);
        mt.addImage(ship,0);
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.setBounds(0,0,720,576);
    }
    
    public void paint(Graphics g) {
        g.setColor(new DVBColor(255,0,0,255));
        //g.drawLine(0,0,200,200);
        g.drawImage(stars,starsx,starsy,this);
        g.drawImage(stars,starsx,starsy-570,this);
        g.drawImage(ship, shipx, shipy,this);
    }
    
    public void Move (int x, int y)
    {
        starsx += x;
        starsy += y;
        if(starsy > 570) { starsy -= 570;}
        this.repaint();
    }
    
    public void MoveShip (int x, int y)
    {
        shipx += x;
        shipy += y;
        this.repaint();
    }
}
