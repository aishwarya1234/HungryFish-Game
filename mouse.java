package game;

import java.applet.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;



public class mouse extends Applet
   implements MouseListener, MouseMotionListener,Runnable{

	int counter=10;
	
	Thread th,Abc;

	AudioClip audioClip;
		
	Ball b=new Ball(155,155,15,85,85,Color.red);	
	    	
	Ball b2;
		  
    public int width, height;
   
   
    int mx, my;  // the mouse coordinates
    int count=0;
   
  public void init() {
	  
      Color customColor = new Color(110,244,224);
      
      this.setBackground( customColor);

      mx = width/2;
      my = height/2;

      addMouseListener( this );
      addMouseMotionListener( this );


	   audioClip = getAudioClip(getCodeBase(), "mario_08(1).wav");
	      audioClip.play();
      
	   /*extra   JLabel picLabel = new JLabel(new ImageIcon("hint.gif"));
		   
		   picLabel.setPreferredSize(new Dimension(1300,600));
		   JOptionPane.showMessageDialog(null, picLabel, "Loading.....zzz", JOptionPane.PLAIN_MESSAGE, null);
		   setSize(new Dimension(1350,600));
		   */
      
	   JLabel picLabel = new JLabel(new ImageIcon("hint.gif"));
	   
	   picLabel.setPreferredSize(new Dimension(1300,600));
	   JOptionPane.showMessageDialog(null, picLabel, "Starting....", JOptionPane.PLAIN_MESSAGE, null);
	   setSize(new Dimension(1350,600));
	   
	   
	   //Start of game
	   JLabel picLabel2 = new JLabel(new ImageIcon("hung.jpeg"));
	   
	   picLabel2.setPreferredSize(new Dimension(700,400));
	   JOptionPane.showMessageDialog(null, picLabel2, "Hungry Fish....<><", JOptionPane.PLAIN_MESSAGE, null);
	  
      //Music Code
     
       AudioClip audioClip2;
	   audioClip2 = getAudioClip(getCodeBase(), "hungry.wav");
	   audioClip2.play();
     
   }

  

   public void mouseEntered( MouseEvent e ) {
      // called when the pointer enters the applet's rectangular area
   }
   public void mouseExited( MouseEvent e ) {
      // called when the pointer leaves the applet's rectangular area
   }
   public void mouseClicked( MouseEvent e ) {
      
   }
   public void mousePressed( MouseEvent e )
   {
	  
   }
   public void mouseReleased( MouseEvent e ) 
   {  

   }
   public void mouseMoved( MouseEvent e ) 
   { 

	   
	  mx = e.getX();
   
      my = e.getY();
      
      int dist;
      
      dist=((b.xpos-b.radius)-(mx-155))*((b.xpos-b.radius)-(mx-155))+((b.ypos-b.radius)-(my+195))*((b.ypos-b.radius)-(my+195));
    
    
      if(dist<=(b.radius+130))
      {
    	  
    	  b.moveBall();
    	
    	  count=1;
    	 
			try {
				paint1(getGraphics());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
      }
    	 
      repaint();
    
      e.consume();
    
   }
   



 public void mouseDragged( MouseEvent e ) 
  {

  }
 
 
   public void paint( Graphics g ) {
	  
	   Font font = new Font("Arial",Font.BOLD,30);
	   g.setFont(font);
	   
	//  g.drawString(String.valueOf(counter),75,25);
	   
      //Draws the body
      g.setColor (Color.blue);
      
      g.fillOval (mx-120, my+120, 150, 150);
      
      
      Color customColor1 = new Color(110,244,224);
      g.setColor(customColor1);
      g.fillOval(mx-60, my+125, 150, 150);
      
      g.setColor (Color.blue);
      g.fillOval (mx-80, my+145, 100, 100);
      
      Color customColor3 = new Color(110,244,224);
      g.setColor(customColor3);

      g.fillOval (mx-50, my+155, 80, 80);

      g.setColor (Color.blue);
      g.fillOval (mx-50, my+170, 50, 50);
      
      Color customColor4 = new Color(110,244,224);
      g.setColor(customColor4);
      g.fillOval (mx-20, my+180, 30, 30);

      //main fish body ends
      
 
      //Draws the eye 
      g.setColor (Color.white);
      g.fillOval (mx-110, my+170, 10, 10);
      
      g.setColor (Color.black);
      g.fillOval (mx-110, my+170, 8, 8);
      
      //Draws tail
      
      Color customColor2 = new Color(110,244,224);
      g.setColor(customColor2);
      g.fillArc (mx-125, my+155, 85,75, 180, 30);
     
      
      
      b.drawBall(g);
      
      
     if(count==1)
     {
    
    	
    	 b=new Ball(45,45,10,45,45,customColor2);
    	 b.drawBall(g);
    	 b.moveBall();
    	
     }
    
   }

   public void start()
   {
	   th = new Thread (this);

       th.start ();
   
   }

   public void paint1(Graphics g1) throws Exception
   {
	   AudioClip audioClip1;
	   audioClip1 = getAudioClip(getCodeBase(), "ohyeh.wav");
	   audioClip1.play();
	 //  Thread.sleep(800);
	   AudioClip audioClip7;
	  // audioClip7 = getAudioClip(getCodeBase(), "wow.wav");
	 //  audioClip7.play();
	   
       JLabel picLabel1 = new JLabel(new ImageIcon("cong.gif"));
	   
	   picLabel1.setPreferredSize(new Dimension(1300,600));
	   JOptionPane.showMessageDialog(null, picLabel1, "Congratulations.....!!!", JOptionPane.PLAIN_MESSAGE, null);
	   setSize(new Dimension(1350,600));

	  
	   
	   
   }
	  
	 
   
   

@Override
public void run() {
	// TODO Auto-generated method stub
	

    Thread.currentThread().setPriority(Thread.MIN_PRIORITY);       

    while(true)

    {

      b.moveBall();
     
       repaint();
       
       try
       {  	  
          Thread.sleep (1300);
       }
       catch (InterruptedException ex)     
       {
    	   
       }

       Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
       try {
		Thread.sleep(100);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       --counter;
       
       if(counter<=0)
       {
JLabel picLabel = new JLabel(new ImageIcon("timeout.png"));
		   
		   picLabel.setPreferredSize(new Dimension(1300,600));
		   JOptionPane.showMessageDialog(null, picLabel, "Loading.....zzz", JOptionPane.PLAIN_MESSAGE, null);
		   setSize(new Dimension(1350,600));
       	th.stop();
       	
       	
       }

    }
	}

public void stop()
{
	th.stop();
}






}