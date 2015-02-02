package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.event.*;
import org.dvb.ui.*;
import org.havi.ui.*;
import org.havi.ui.event.*;
import java.awt.*;


public class HelloTVXlet  implements Xlet, UserEventListener
{
    private HScene scene;

    private HStaticText lblBlocks[] = new HStaticText[16];
    private HStaticText lblPoints = new HStaticText("Points:\n0");
    
    private Block block[] = new Block[16];
    
    int x,y;
    int size = 130;
    int margin = 11;
    
    int points = 0;
    
    Font myfont = new Font("Serif", Font.BOLD, 24);
    
    
    DVBColor backgroundcolor = new DVBColor(new DVBColor(125,195,232,255));
    
    
    public void initXlet(XletContext context) {
        
        x = margin;
        y = margin;

        HSceneTemplate sceneTemplate = new HSceneTemplate();
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, 
                new HScreenDimension(1.0f,1.0f), HSceneTemplate.REQUIRED);
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION,
                new HScreenPoint(0.0f,0.0f), HSceneTemplate.REQUIRED);
        
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        scene.setBackground(backgroundcolor);
        scene.setBackgroundMode(1);
        
        //init lblPoints
        lblPoints.setSize(125,80);
        lblPoints.setLocation(580,margin);
        lblPoints.setBackground(new DVBColor(255,0,0,0));
        lblPoints.setBackgroundMode(HVisible.BACKGROUND_FILL);
        lblPoints.setFont(myfont);        
        scene.add(lblPoints);
        
        

        //init block labels
        for(int i = 0; i < lblBlocks.length; i++)
        {
            
            if(i%4 == 0 && i != 0)
            {
                x = margin;
                y += margin+size;
                
            }
            
            lblBlocks[i] = new HStaticText("TEST");
            lblBlocks[i].setSize(size, size);
            lblBlocks[i].setBackground(new DVBColor(0,0,0,150));
            lblBlocks[i].setBackgroundMode(HVisible.BACKGROUND_FILL);
            
            lblBlocks[i].setLocation(x,y);
            x+=margin+size;
            scene.add(lblBlocks[i]);
           
            
        
    }
        //init block[]
        for(int i = 0; i < block.length; i++)
        {
             block[i] = new Block(8); 
             
        }
        System.out.println(block[15].GetValue());
    }
    public void startXlet() {
        scene.validate();
        scene.setVisible(true);
    }
    
    public void RefreshBlock()
    {
        
    }
        

    public void pauseXlet() {
     System.out.println("pauseXlet");
    }

    public void destroyXlet(boolean unconditional) {
     System.out.println("destroyXLet");
    }
    
    public void userEventReceived(UserEvent e) {
        
        if(e.getType() == HRcEvent.KEY_PRESSED){
            switch(e.getCode())
            {
                case HRcEvent.VK_LEFT:
                    System.out.println("LEFT");
                    
                    break;
                case HRcEvent.VK_RIGHT:
                    System.out.println("RIGHT");
                    
                    break;
            }
            
            }//end of event listener
            
        }//end of method
    

    
}//end of programm
