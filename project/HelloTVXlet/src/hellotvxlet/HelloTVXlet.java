package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.event.*;
import org.dvb.ui.*;
import org.havi.ui.*;
import org.havi.ui.event.*;


public class HelloTVXlet  implements Xlet, UserEventListener
{
    private HScene scene;
    
    
    //private HStaticText lbl1;
    //private HStaticText lbl2;
    //private HStaticText lbl3;
    //private HStaticText lbl4;
    //private HStaticText lbl5;
    //private HStaticText lbl6;
    //private HStaticText lbl7;
    //private HStaticText lbl8;
    //private HStaticText lbl9;
    //private HStaticText lbl10;
    //private HStaticText lbl11;
    //private HStaticText lbl12;
    //private HStaticText lbl13;
    //private HStaticText lbl14;
    //private HStaticText lbl15;
    //private HStaticText lbl16;
    
    private HStaticText labels[] = new HStaticText[16];
    
    
    public void initXlet(XletContext context) {

        HSceneTemplate sceneTemplate = new HSceneTemplate();
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, 
                new HScreenDimension(1.0f,1.0f), HSceneTemplate.REQUIRED);
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION,
                new HScreenPoint(0.0f,0.0f), HSceneTemplate.REQUIRED);
        
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        
        
        boolean initPos = true;
        int initPosCounter = 0;
        for(int i = 0; i <= 16; i++)
        {
            labels[i] = new HStaticText("TEST");
            
            labels[i].setSize(100, 100);
            labels[i].setBackground(new DVBColor(0,0,0,200));
            labels[i].setBackgroundMode(HVisible.BACKGROUND_FILL);
            
            if(initPos)
            {
                for(int y = 0; y < 4; y++)
                {
                    for(int x = 0; x <4; x++)
                    {
                        labels[initPosCounter].setLocation(x*110, y*110);
                        
                        System.out.println(initPosCounter);
                        
                        initPosCounter++;
                        
                    }
                }
                initPos = false;
            }
            scene.add(labels[i]);
             
        }
        
        System.out.println("Labels done");
        
        
        
        
    
    }
    public void startXlet() {
        scene.validate();
        scene.setVisible(true);
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
