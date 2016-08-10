package game;

import java.awt.*;

import java.applet.*;
import java.util.Random;

 

public class Ball extends Applet

{

    int xpos;

    int ypos;

     int radius;

     int vx; //vector x

     int vy; //vector y

    Color color;

     

    public Ball(int x, int y, int r, int vx, int vy, Color color)

    {

        xpos = x;

        ypos = y;

        radius = r;

        this.vx = vx;

        this.vy = vy;

        this.color = color;

    }

 

    public void drawBall(Graphics g)

    {

        g.setColor (color);
        
        g.fillOval (xpos - radius, ypos - radius, 2 * radius, 2 * radius);
        
        g.dispose();
    }

 

    public void moveBall()

    {
    	   		
 
    	
    	xpos=(int)(700*Math.random());
    	ypos=(int)(700*Math.random());
    	
    	

    }



}


