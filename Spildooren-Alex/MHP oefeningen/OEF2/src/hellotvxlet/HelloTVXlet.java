package hellotvxlet;

import javax.tv.xlet.*;
import java.awt.event.*;
import org.dvb.event.UserEvent;
import org.havi.ui.*;
import org.havi.ui.event.*;
import org.dvb.ui.*;
import java.awt.Graphics.*;
import org.dvb.event.*;

public class HelloTVXlet implements Xlet, HActionListener,UserEventListener{
    private XletContext actueleXletContext;
    private HScene scene;
    private MijnComponent component ;
    
    public void actionPerformed(ActionEvent e)
    {
        System.out.println(e.getActionCommand());
        scene.validate();
    }
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context ) {
      this.actueleXletContext = context;
        HSceneTemplate sceneTemplate= new HSceneTemplate();
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION,new HScreenDimension(1.0f, 1.0f),HSceneTemplate.REQUIRED);
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION,new HScreenPoint(0.0f, 0.0f),HSceneTemplate.REQUIRED);
        
        scene= HSceneFactory.getInstance().getBestScene(sceneTemplate);
        UserEventRepository uev=new UserEventRepository("mijn");
        uev.addKey(HRcEvent.VK_LEFT);
        uev.addKey(HRcEvent.VK_RIGHT);
        EventManager.getInstance().addUserEventListener(this,uev);
        
        
        MijnComponent me = new MijnComponent();
        scene.add(me);
        
        

    }

    public void startXlet() {
    scene.validate();
    scene.setVisible(true);
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void userEventReceived(UserEvent e) {
        if(e.getType()==HRcEvent.KEY_PRESSED){
            switch(e.getCode())
            {
                case HRcEvent.VK_LEFT:
                    System.out.println("LINKS!!!!");
                    component.verplaatsSchip(3,0);
                break;
                case HRcEvent.VK_RIGHT:
                    System.out.println("RECHTS!!!!");
                    component.verplaatsSchip(-3,0);
                break;
            }
        }
    }
}
