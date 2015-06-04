package hellotvxlet;

import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.dvb.ui.*;
import java.awt.*;
import org.havi.ui.*;
import org.havi.ui.event.HActionListener;

public class HelloTVXlet implements Xlet, HActionListener {

  private XletContext actueleXletContext;
  private HScene scene;
  private boolean debug = true;
  
  private HStaticText tekstLabel;
  private HTextButton btn1, btn2, btn3, btn4, btnHint;
  
  
    public HelloTVXlet() {
        
    }
    
    public void initXlet(XletContext context) throws XletStateChangeException{
        if(debug) System.out.println("Xlet initialiseren");
        this.actueleXletContext = context;
        
        HSceneTemplate sceneTemplate = new HSceneTemplate();
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, 
                new HScreenDimension(1.0f,1.0f), HSceneTemplate.REQUIRED);
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION,
                new HScreenPoint(0.0f,0.0f), HSceneTemplate.REQUIRED);
        
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        
        tekstLabel = new HStaticText("Wat is de 4e letter van het alfabet?");
        tekstLabel.setLocation(100,150);
        tekstLabel.setSize(500,50);
        tekstLabel.setBackground(new DVBColor(0,0,0,200));
        tekstLabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(tekstLabel);
        
        btn1 = new HTextButton("a: c");
        btn1.setLocation(30,250);
        btn1.setSize(300,50);
        btn1.setBackground(new DVBColor(0,0,0,180));
        btn1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(btn1);
        
        btn2 = new HTextButton("b: d");
        btn2.setLocation(380,250);
        btn2.setSize(300,50);
        btn2.setBackground(new DVBColor(0,0,0,180));
        btn2.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(btn2);
        
        btn3 = new HTextButton("c: b");
        btn3.setLocation(30,330);
        btn3.setSize(300,50);
        btn3.setBackground(new DVBColor(0,0,0,180));
        btn3.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(btn3);
        
        btn4 = new HTextButton("d: a");
        btn4.setLocation(380,330);
        btn4.setSize(300,50);
        btn4.setBackground(new DVBColor(0,0,0,180));
        btn4.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(btn4);
        
        btnHint = new HTextButton("HINT");
        btnHint.setLocation(30,400);
        btnHint.setSize(120,40);
        btnHint.setBackground(new DVBColor(0,0,0,100));
        btnHint.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(btnHint);
        
                                //op, neer, links, rechts
        btn1.setFocusTraversal(btnHint,btn3,btn2,btn2);
        btn2.setFocusTraversal(btn4, btn4, btn1, btn1);
        btn3.setFocusTraversal(btn1,btnHint,btn4,btn4);
        btn4.setFocusTraversal(btn2, btnHint, btn3,btn3);
        btnHint.setFocusTraversal(btn3, btn1, null, btn4);
        
        btn1.requestFocus();
        
        btn1.setActionCommand("btn1");
        btn2.setActionCommand("btn2");
        btn3.setActionCommand("btn3");
        btn4.setActionCommand("btn4");
        btnHint.setActionCommand("btnHint");
        
        btn1.addHActionListener(this);
        btn2.addHActionListener(this);
        btn3.addHActionListener(this);
        btn4.addHActionListener(this);
        btnHint.addHActionListener(this);
    }

    public void startXlet() throws XletStateChangeException{
        if(debug) System.out.println("Xlet starten");
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void actionPerformed(ActionEvent e) {
        //System.out.println(e.getActionCommand());
        
        if(e.getActionCommand() == "btn1")
        {
            System.out.println("FOUT");
            btn1.setBackground(new DVBColor(255,0,0,180));            
        }
        else if(e.getActionCommand() == "btn2")
        {
            System.out.println("GOED");
            btn2.setBackground(new DVBColor(0,255,0,180));
        }
        else if(e.getActionCommand() == "btn3")
        {
            System.out.println("FOUT");
            btn3.setBackground(new DVBColor(255,0,0,180));
        }
        else if(e.getActionCommand() == "btn4")
        {
            System.out.println("FOUT");
            btn4.setBackground(new DVBColor(255,0,0,180));
        }
        else if(e.getActionCommand() == "btnHint")
        {
            System.out.println("HINT");
            btn1.requestFocus();
            
            btn1.setFocusTraversal(null,null,btn2,btn2);
            btn2.setFocusTraversal(null, null, btn1,btn1);
            
            btn3.setBackground(new DVBColor(255,0,0,180));
            btn3.setEnabled(false);
            btn4.setBackground(new DVBColor(255,0,0,180));
            btn4.setEnabled(false);
            btnHint.setEnabled(false);
            
            
            
            
            
        }
        
        }
    }
