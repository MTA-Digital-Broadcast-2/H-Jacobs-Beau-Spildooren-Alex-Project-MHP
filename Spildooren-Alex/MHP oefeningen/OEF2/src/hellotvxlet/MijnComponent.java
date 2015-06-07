/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;
import org.havi.ui.*;
import java.awt.*;
import org.dvb.ui.*;
import java.awt.Graphics.*;
/**
 *
 * @author student
 */
public class MijnComponent extends HComponent{
    private Image bmap;
    private MediaTracker mtrack;
    int schipx=20,schipy=20;
    
    public MijnComponent(){
        
        bmap=this.getToolkit().getImage("spaceship.png");
        mtrack=new MediaTracker(this);
        mtrack.addImage(bmap, 20);
        try{
            mtrack.waitForAll();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        this.setBounds(0,0,200,200);
        
        
    }
    public void verplaatsSchip(int X, int Y)
    {
        schipx= schipx+X;
        schipy=schipy+Y;
        this.repaint();
    }
    public void paint(Graphics g){
        g.setColor(new DVBColor(255,113,255,255));
        g.fillRect(schipx, schipy, 100, 100);
        g.setColor(Color.white);
        g.drawString("HEY", 15, 50);
        g.drawImage(bmap, schipx, schipy, this);
    }
}
