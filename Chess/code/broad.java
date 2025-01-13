
package main;
import java.awt.*;
public class broad {
    public static int col=8;
    public static int row=8;
    public static final int sizeO=100;
    public static final int halfSize=sizeO/2;
    
    public static void draw(Graphics2D g2){
        int cl=0;
        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                //fillRect() ve hcn day
                if(cl==0){
                    //set mau cua o
                    g2.setColor(new Color(210,165,125));
                    cl=1;
                }
                else {
                    g2.setColor(new Color(175,115,70));
                    cl=0;
                }
                g2.fillRect(c*sizeO, r*sizeO, sizeO, sizeO);
            }
            if(cl==0) {
                    cl=1;
                }
                else cl=0;
        }
    }
}
