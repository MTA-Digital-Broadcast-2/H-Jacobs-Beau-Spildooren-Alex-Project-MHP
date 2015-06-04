package hellotvxlet;

import javax.tv.xlet.*;
import org.davic.resources.*;
import org.dvb.event.*;
import org.havi.ui.*;
import org.havi.ui.event.*;


public class HelloTVXlet  implements Xlet, ResourceClient, 
        HBackgroundImageListener, UserEventListener {
    
    private HScreen screen;
    private HBackgroundDevice bgDevice;
    private HBackgroundConfigTemplate bgTemplate;
    private HStillImageBackgroundConfiguration bgConfiguration;
    private HBackgroundImage agrondimg = new HBackgroundImage("pizza1.m2v");
    
    private HBackgroundImage pizza1 = new HBackgroundImage("pizza1.m2v");
    private HBackgroundImage pizza2 = new HBackgroundImage("pizza2.m2v");
    private HBackgroundImage pizza3 = new HBackgroundImage("pizza3.m2v");
    private HBackgroundImage pizza4 = new HBackgroundImage("pizza4.m2v");
    
    private int currentimg = 1;
    
    public void notifyRelease(ResourceProxy proxy) {}
    public void release(ResourceProxy proxy) {}
    public boolean requestRelease(ResourceProxy proxy, Object requestdata)
    {
        return false;
    }
    
    public void imageLoaded (HBackgroundImageEvent e)
    {
        try {
            bgConfiguration.displayImage(agrondimg);
            System.out.println("Image loaded :D");
        }
        catch (Exception s) {
            System.out.println(s.toString());
        }
    }
    
    public void imageLoadFailed(HBackgroundImageEvent e)
    {
        System.out.println("Image not loaded :c");
    }
    
    public void initXlet(XletContext context) {
    screen= HScreen.getDefaultHScreen();
    
    bgDevice = screen.getDefaultHBackgroundDevice();
    
    if(bgDevice.reserveDevice(this))
    {
        System.out.println("BackgroundImage device has been reserved");
    }
    
    else 
    {
        System.out.println("Background image device cannot be reserved");
    }
    
    
    bgTemplate = new HBackgroundConfigTemplate();
    
    bgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE,HBackgroundConfigTemplate.REQUIRED);
    
    bgConfiguration = (HStillImageBackgroundConfiguration)bgDevice.getBestConfiguration(bgTemplate);
    
    
    try{
        bgDevice.setBackgroundConfiguration(bgConfiguration);
        }
    
    catch(java.lang.Exception e) {
        System.out.println(e.toString());
        }
    
    UserEventRepository uev = new UserEventRepository("mijn verzameling");
    uev.addAllArrowKeys();
    EventManager.getInstance().addUserEventListener(this, uev);
    
    }
    public void startXlet() {
        System.out.println("startXlet");
        agrondimg.load(this);
    }

    public void pauseXlet() {
     System.out.println("pauseXlet");
    }

    public void destroyXlet(boolean unconditional) {
     System.out.println("destroyXLet");
     agrondimg.flush();
    }
    
    public void userEventReceived(UserEvent e) {
        
        if(e.getType() == HRcEvent.KEY_PRESSED){
            switch(e.getCode())
            {
                case HRcEvent.VK_LEFT:
                    System.out.println("LEFT");
                    currentimg--;
                    break;
                case HRcEvent.VK_RIGHT:
                    System.out.println("RIGHT");
                    currentimg++;
                    break;
            }
            
            
            if(currentimg == 0)
            {
                currentimg = 4;
            }
            else if(currentimg == 5)
            {
                currentimg = 1;
            }
            
            
            switch(currentimg)
            {
                case 1:
                    agrondimg = pizza1;
                    System.out.println("pizza 1");
                    break;
                case 2:
                    agrondimg = pizza1;
                    System.out.println("pizza 2");
                    break;
                case 3:
                    agrondimg = pizza3;
                    System.out.println("pizza 3");
                    break;
                case 4:
                    agrondimg = pizza4;
                    System.out.println("pizza 4");
                    break;
                default:
                    System.out.println("image does not exist");
                    break;
            }//end of switch
            agrondimg.load(this);
            
            }//end of event listener
            
        }//end of method
    
}//end of programm
