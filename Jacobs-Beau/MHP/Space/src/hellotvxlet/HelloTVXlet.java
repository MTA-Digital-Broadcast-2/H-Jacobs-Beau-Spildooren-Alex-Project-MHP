package hellotvxlet;

import java.util.Timer;
import javax.tv.xlet.*;
import org.dvb.event.*;
import org.havi.ui.*;
import org.havi.ui.event.HRcEvent;

public class HelloTVXlet implements Xlet, UserEventListener {
  MijnComponent mc;
  Timer t;
    public HelloTVXlet() {
        
    }
    
    public void initXlet(XletContext context) {
        HScene scene = HSceneFactory.getInstance().getDefaultHScene();
        mc = new MijnComponent();
        System.out.println("hallo");
        scene.add(mc);
        scene.validate();
        scene.setVisible(true);
        
        UserEventRepository uev = new UserEventRepository("mijn verzameling");
        uev.addAllArrowKeys();
        EventManager.getInstance().addUserEventListener(this, uev);
        
        t = new Timer();
        
        
        MijnTimerTask mtt = new MijnTimerTask();
        mtt.setCallback(this);
        t.scheduleAtFixedRate(mtt,0,100);
    }

    public void startXlet() {
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void userEventReceived(UserEvent e) {
        if(e.getType() == HRcEvent.KEY_PRESSED){
            switch(e.getCode())
            {
                case HRcEvent.VK_LEFT:
                    System.out.println("LEFT");
                    mc.MoveShip(-10,0);
                    break;
                case HRcEvent.VK_RIGHT:
                    System.out.println("RIGHT");
                    mc.MoveShip(10,0);
                    break;
            }
        }
    }
    
    public void callback(){
     //ystem.out.println("callback"); 
     mc.Move(0, 10);
    }
}
