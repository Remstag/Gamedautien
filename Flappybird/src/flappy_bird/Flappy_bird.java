
package flappy_bird;
import javax.swing.*;    
import javax.swing.JFrame;
public class Flappy_bird {
    public static void main(String args[]) {
        int width=360;
        int height=640;  
        JFrame frame=new JFrame("Flappy Bird");
        frame.setSize(width, height);  
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Flappybird flappybird=new Flappybird();
        frame.add(flappybird);
        frame.pack();        
        
        flappybird.requestFocus();
        frame.setVisible(true);
    }
}
