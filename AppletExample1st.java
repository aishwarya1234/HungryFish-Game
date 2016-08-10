
import java.applet.Applet;
import java.applet.AppletStub;
import java.awt.Graphics;
import java.awt.GridLayout;
 
public class AppletExample1st extends Applet
implements Runnable, AppletStub {
 
	Thread threadABC;
 
	public void init(){}
 
	public void paint(Graphics g) {
	    g.drawString("I'm Applet 1 ~", 10, 10);
	    g.drawString("Loading Applet 2 ...", 10, 30);
 
	} 
 
	public void run() {
 
	  try {
 
	    //sleep for 5 seconds , for demo
	    threadABC.sleep(5000);
 
	    Class applet2 = Class.forName("AppletExample2nd");
	    Applet appletToLoad = (Applet)applet2.newInstance();
	    appletToLoad.setStub(this);
	    setLayout( new GridLayout(1,0));
	    add(appletToLoad);
	    appletToLoad.init();
	    appletToLoad.start();
 
	  }catch (Exception e) {
	    System.out.println(e);
	  }
 
	    validate();
	}
 
	public void start(){
	    threadABC = new Thread(this);
	    threadABC.start();
	}
 
	public void stop() {
	    threadABC.stop();
	    threadABC = null;
	}
 
	public void appletResize( int width, int height ){
	    resize( width, height );
	}
 
}

