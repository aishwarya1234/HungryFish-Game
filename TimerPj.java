import java.awt.*; //windows toolkit

import java.applet.*; //applet support

public class TimerPj extends Applet implements Runnable{

int counter; Thread cd;

public void start() { // create thread

counter = 60; 
cd = new Thread(this); 
cd.start();

}

public void stop() { cd = null;}

public void run() {	// executed by Thread

while (counter>0 && cd!=null) {

try{Thread.sleep(1000);} catch (InterruptedException e){}

--counter; repaint(); //update screen

if(counter<=30)
{
	cd.stop();
	
	
}


}

}

public void paint(Graphics g) {

g.drawString(String.valueOf(counter),25,75);

}

}