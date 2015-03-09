package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.event.*;
import org.dvb.ui.*;
import org.havi.ui.*;
import org.havi.ui.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class HelloTVXlet  implements Xlet, UserEventListener, HActionListener
{
    private HScene scene;

    private HStaticText lblBlocks[] = new HStaticText[16];
    private HStaticText lblPoints = new HStaticText("Points:\n0");
    
    private HTextButton resetbutton = new HTextButton("Reset");
    
    private Block block[] = new Block[16];
    
    int x,y;
    int size = 130;
    int margin = 11;
    
    int points = 0;
    
    int moves = 0;
    
    Font myfont = new Font("Serif", Font.BOLD, 24);
    
    
    DVBColor backgroundcolor = new DVBColor(new DVBColor(125,195,232,255));
    
    boolean moved = false;
    
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
        
        //init resetbutton
        resetbutton.setSize(130,50);
        resetbutton.setLocation(580,90);
        scene.add(resetbutton);
        resetbutton.requestFocus();
        resetbutton.setActionCommand("resetbutton");
        resetbutton.addHActionListener(this);
        

        //init block labels
        for(int i = 0; i < lblBlocks.length; i++)
        {
            
            if(i%4 == 0 && i != 0)
            {
                x = margin;
                y += margin+size;
                
            }
            
            lblBlocks[i] = new HStaticText("");
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
             block[i] = new Block(i);
             
        }
        System.out.println(block[15].GetValue());
        
        UserEventRepository uev = new UserEventRepository("mijn verzameling");
        uev.addAllArrowKeys();
        EventManager.getInstance().addUserEventListener(this, uev);
        
    }
    public void startXlet() {
        scene.validate();
        scene.setVisible(true);
        Reset();
        RefreshBlock();
    }
    
    public void RefreshBlock()
    {
        //update labels
        for(int i = 0; i < block.length; i++)
        {
            if(block[i].value == 0)
            {
                lblBlocks[i].setTextContent("", HState.NORMAL_STATE);
            }
            else
            {
                lblBlocks[i].setTextContent(Integer.toString(block[i].value), HState.NORMAL_STATE);
            }
            lblBlocks[i].setBackground(block[i].UpdateColor());
            lblPoints.setTextContent(Integer.toString(points), HState.NORMAL_STATE);
        }
        
    }
    
    public void Reset()
    {
        for(int i = 0; i < block.length; i++)
        {
            block[i].SetValue(0);
        }
        
       int randomblock1 = (int)(Math.random()* 16); 
       int randomblock2 = (int) (Math.random() * 16);
       
       
       boolean isRandom1 = true;
       
       while(isRandom1)
       {
           if(randomblock1 == randomblock2)
           {
               randomblock2 = (int) (Math.random() * 15);
           }
           else
           {
               isRandom1 = false;
           }
       }       
       
       System.out.println(randomblock1);
       System.out.println(randomblock2);
       
       int randomvalue1 = (int)(Math.random() * 4);
       
        if(randomvalue1 == 0)
        {
            block[randomblock1].SetValue(4);
        }
        else
        {
           block[randomblock1].SetValue(2);
        }
       
       int randomvalue2 = (int)(Math.random() * 4);

       if(randomvalue2 == 0)
        {
            block[randomblock2].SetValue(4);
        }
        else
        {
           block[randomblock2].SetValue(2);
        }
       RefreshBlock();
    }//end of reset
    
        

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
                 case HRcEvent.VK_UP:
                    System.out.println("UP");
                    Move(0);
                    break;
                    
                case HRcEvent.VK_DOWN:
                    System.out.println("DOWN");
                    Move(1);           
                    break;
                
                case HRcEvent.VK_LEFT:
                    System.out.println("LEFT");
                    Move(2);
                    break;
                case HRcEvent.VK_RIGHT:
                    System.out.println("RIGHT");
                    Move(3);
                    break;
                    
               
            }
            
            }//end of event listener
            
        }//end of method
    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand() == "resetbutton")
        {
            Reset();
            System.out.println("RESET");
        }
    
    }
    
    public void Move(int direction) //0 1 2 3 = up, down, left, right
    {
        switch(direction)
        {
            case 0: //up
                for (int j = 0; j < 3; j++)
                {
                    for (int i = 4; i <= 15; i++)
                    {
                        if (block[i].value != 0)
                        {
                            if (block[i-4].value == 0)
                            {
                                block[i-4].value= block[i].value;
                                block[i].value = 0;
                                moved = true;
                            }
                         else if (block[i].value == block[i-4].value)
                            {
                                block[i-4].value += block[i].value;
                                block[i].value = 0;
                                moved = true;

                                points += block[i-4].value;
                             }
                        }
                    }

               }
               if (moved)
               {
                   RefreshBlock();
                   Spawnblock();

               }
            break;
            case 1: //down
                for (int j = 0; j < 3; j++)
                {
                    for (int i = 11; i >= 0; i--)
                    {
                        if (block[i].value != 0)
                        {
                            if (block[i+4].value == 0)
                            {
                                block[i+4].value = block[i].value;
                                block[i].value = 0;
                                moved = true;
                            }
                            else if (block[i].value == block[i+4].value)
                            {
                                block[i+4].value += block[i].value;
                                block[i].value = 0;
                                moved = true;

                               points += block[i+4].value;
                             }
                          }
                     }
                }
                if (moved)
               {
                    RefreshBlock();    
                    Spawnblock();
               }
            break;
                            
            case 2: //left
                for (int j = 0; j < 3; j++)
                            {
                                for (int i = 0; i <= 15; i++)
                                {
                                    if (block[i].value != 0
                                        && i != 0
                                        && i != 4
                                        && i != 8
                                        && i != 12)
                                    {
                                        if (block[i-1].value == 0)
                                        {
                                            block[i-1].value = block[i].value;
                                            block[i].value = 0;
                                            moved = true;
                                        }
                                        else if (block[i].value == block[i-1].value)
                                        {
                                            block[i-1].value += block[i].value;
                                            block[i].value = 0;
                                            moved = true;
                                            //addedLeft = true;

                                            points += block[i-1].value;
                                        }
                                    }
                                }

                            }
                            if (moved)
                            {
                                RefreshBlock();
                                Spawnblock();
                            }
                            break;
                            
            case 3: //right
                     for (int j = 0; j < 3; j++)
                            {
                                for (int i = 15; i >= 0; i--)
                                {
                                    if (block[i].value != 0
                                        && i != 3
                                        && i != 7
                                        && i != 11
                                        && i != 15)
                                    {
                                        if (block[i+1].value == 0)
                                        {
                                            block[i+1].value = block[i].value;
                                            block[i].value = 0;
                                            moved = true;
                                        }
                                        else if (block[i].value == block[i+1].value)
                                        {
                                            block[i+1].value += block[i].value;
                                            block[i].value = 0;
                                            moved = true;
                                            //addedRight = true;

                                            points += block[i+1].value;
                                        }
                                    }
                                }

                            }

                            if(moved)
                            {
                                RefreshBlock();
                                Spawnblock();
                            }
                            break;
        }
    }
    
    public void Spawnblock()
    {
        if (moved)
            {                
                boolean unavailable = true;
                while (unavailable)
                {
                    int rndblock = (int)(Math.random() * 100);
                    
                    if (rndblock < 75) 
                    { rndblock = 2; }
                    else 
                    { rndblock = 4; }

                    int position = (int)(Math.random() * 16);
                    if (block[position].value == 0)
                    {
                        block[position].value = rndblock;
                        unavailable = false;
                        System.out.println("SPAWN");
                    }
                }

                moves++;
                
                RefreshBlock();
                moved = false;                
            
            }
    }
    
}//end of programm
