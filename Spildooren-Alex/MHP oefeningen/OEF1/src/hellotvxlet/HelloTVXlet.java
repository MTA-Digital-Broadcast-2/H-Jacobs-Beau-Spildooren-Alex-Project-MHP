package hellotvxlet;

import javax.tv.xlet.*;
import java.awt.event.*;
import org.havi.ui.*;
import org.havi.ui.event.*;
import org.dvb.ui.*;


public class HelloTVXlet implements Xlet, HActionListener {
    private XletContext actueleXletContext;
    private HScene scene;
    private HStaticText vraag,antwoord ;
    private HTextButton Knop1,Knop2,Knop3,Knop4;
    
    public void actionPerformed(ActionEvent e)
    {
        System.out.println(e.getActionCommand());
        antwoord.setVisible(true);
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
        
        vraag = new HStaticText("Who gives a F**** ?");
        vraag.setLocation(0, 0);
        vraag.setSize(200, 50);
        vraag.setBackground(new DVBColor(0,0,50,255));
        vraag.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(vraag);
        
        antwoord=new HStaticText("Werkt dit eigenlijk");
        antwoord.setLocation(0, 200);
        antwoord.setSize(200, 50);
        antwoord.setBackground(new DVBColor(0,0,50,255));
        antwoord.setBackgroundMode(HVisible.BACKGROUND_FILL);
        antwoord.setVisible(false);
        scene.add(antwoord);
        
        Knop1 = new HTextButton("Jules");
        Knop1.setLocation(100, 100);
        Knop1.setSize(100, 50);
        Knop1.setBackground(new DVBColor(150,0,0,255));
        Knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        scene.add(Knop1);
        
        Knop2 = new HTextButton("Firmin");
        Knop2.setLocation(200, 100);
        Knop2.setSize(100, 50);
        Knop2.setBackground(new DVBColor(150,0,0,255));
        Knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        scene.add(Knop2);
        
        Knop3 = new HTextButton("Luk");
        Knop3.setLocation(300, 100);
        Knop3.setSize(100, 50);
        Knop3.setBackground(new DVBColor(150,0,0,255));
        Knop3.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        scene.add(Knop3);
        
        Knop4 = new HTextButton("Philippe");
        Knop4.setLocation(400, 100);
        Knop4.setSize(100, 50);
        Knop4.setBackground(new DVBColor(150,0,0,255));
        Knop4.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        scene.add(Knop4);
        
        Knop1.setFocusTraversal(null, null, null, Knop2);//op,neer,links,rechts
        Knop2.setFocusTraversal(null, null, Knop1, Knop3);//op,neer,links,rechts
        Knop3.setFocusTraversal(null, null, Knop2, Knop4);//op,neer,links,rechts
        Knop4.setFocusTraversal(null, null, Knop3, null);//op,neer,links,rechts
        
        Knop1.setActionCommand("Woohow tis de Jules");
        Knop2.setActionCommand("Woohow tis de Firmin");
        Knop3.setActionCommand("Woohow tis de Luk");
        Knop4.setActionCommand("Woohow tis de Philippe");
        
        Knop1.requestFocus();
        
        Knop1.addHActionListener(this);
        Knop2.addHActionListener(this);
        Knop3.addHActionListener(this);
        Knop4.addHActionListener(this);
        
        
        

    }

    public void startXlet() {
    scene.validate();
    scene.setVisible(true);
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }
}
