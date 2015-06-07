package hellotvxlet;

import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.dvb.ui.*;
import java.awt.*;
import org.havi.ui.*;
import org.havi.ui.event.*;
import org.davic.resources.*;
import org.havi.ui.HScreenDevice;

public class HelloTVXlet implements Xlet, ResourceClient, HBackgroundImageListener {

  private HScreen screen;
  private HbackgroundDevice bgDevice;
  private HbackgroundConfigTemlate bgtemplate;
  private HStillImageBackgroundConfiguration bgConfiguration;
  private HBackgroundImage agrondimg=new HBackgroundImage("pizza1.m2v");
  
  public void notifyRelease(ResourceProxy proxy){}
  public void release(ResourceProxy proxy){}
  public boolean requestRelease(ResourceProxy proxy,Object requestData){return false;}
  
  public void imageLoaded(HBackgroundImageEvent e) {
        try{
            bgConfiguration.displayImage(agrondimg);}
            catch(Exception s){ System.out.println(s.toString());
        }
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        System.out.println("Image kan niet geladen worden");
    }
  
    public HelloTVXlet() {
        
    }
    
    public void initXlet(XletContext context) throws XletStateChangeException{
        screen=HScreen.getDefaultHScreen();
        bgDevice=screen.getDefaultHBackgroundDevice();
        
        //HBackgroundDevice proberen
        if(bgDevice.reserveDevice(this)){
        }
    }

    public void startXlet() throws XletStateChangeException{
        
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void actionPerformed(ActionEvent e) {
               
            
            
            
            
        }

    public boolean requestRelease(ResourceProxy proxy, Object requestData) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void release(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void notifyRelease(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
        
        }
