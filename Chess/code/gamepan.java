
package main;
import java.awt.*;
import javax.swing.*;
public class gamepan extends JPanel implements Runnable{
    public static int width=1100;
    public static int height=800;
    public static int fps=60;
    Thread gameThread;
    public gamepan() {
        setPreferredSize(new Dimension(width,height));
        setBackground(Color.black);
    }
    
    private void update(){
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
        broad.draw(g2);
    }

    @Override
    public void run() {
        double interval=1000000000/fps;
        double delta=0;
        long lastTime=System.nanoTime();
        long currentTime;
        while(gameThread!=null){
            currentTime=System.nanoTime();
            delta += (currentTime - lastTime)/interval;
            lastTime=currentTime;
            
            if(delta>=1){
                update();
                repaint();
                delta--;
            }
        }
    }
    public void launchGame(){
        gameThread=new Thread(this);
        gameThread.start();
    }
    
}
