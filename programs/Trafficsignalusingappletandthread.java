import java.applet.*;
import java.awt.*;
public class signal extends Applet implements Runnable
{
    int r,g1,y,i;
    Thread t;
    public void init()
    {
        r=0;g1=0;y=0;
        t=new Thread(this);
        t.start();
    }
    public void run()
    {
        try   
        {
         for (i=24;i>=1;i--)
         {
            t.sleep(100);
            if (i>=16 && i<24)
            {
                g1=1;
                repaint();
            }
            if (i>=8 && i<16)
            {
                y=1;
                repaint();
            }
            if (i>=1 && i<8)
            {
                r=1;
                repaint();
            }
        }
            if (i==0)
            {
                run();
            }
        }
        catch(Exception e)
        {
        }
    }
    public void paint(Graphics g)
   {
        g.drawOval(100,100,100,100);//red
        g.drawOval(100,225,100,100);//green
        g.drawOval(100,350,100,100);//yellow
        g.drawString("start",200,200);
        
	if (r==1)
        { 
	    g.setColor(Color.red);
            g.fillOval(100,100,100,100);
            g.drawString("stop",200,200);
            r=0;
        }
        if (g1==1)
        { 
	    g.setColor(Color.green);
            g.fillOval(100,225,100,100);
            g.drawString("go",200,200);
	    g1=0;
        }
        if (y==1)
        { 
	    g.setColor(Color.yellow);
            g.fillOval(100,350,100,100);
            g.drawString("slow",200,200);
	    y=0;
        }
    }
}
