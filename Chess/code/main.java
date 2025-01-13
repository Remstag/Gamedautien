
package main;
import javax.swing.JFrame;
public class main {
    public static void main(String args[]) {
        JFrame window=new JFrame("Chess");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        //add gamepan to window
        gamepan gp=new gamepan();
        window.add(gp);
        window.pack();
        
        gp.launchGame();
    }
}
