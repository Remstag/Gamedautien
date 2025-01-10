
package flappy_bird;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;
public class Flappybird extends JPanel implements ActionListener, KeyListener{
    boolean resound=false;
    boolean start=false;
    boolean souund=true;
    boolean pause=false;
    int width=360;
    int height=640;
    int e=0;
    double score=0;
    Image backgroundimg;
    Image birdimg;
    Image toppipeimg;
    Image bottompipeimg;
    Image itemimg;
    Image undead;
    Image energy;
    int birdX=width/8;
    int birdY=height/2;
    int birdwidth=54;
    int birdheight=54;

    
    @Override
    public void actionPerformed(ActionEvent e) {
        //draw();
     
        //playsoundbg();
        //playsoundpaimon();
        //collision();
        move();
        repaint();
       
        if(gameover){
            
            if(souund==true && start==true){
            try {
                   playsoundpaimon("/ehe.wav");
               } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                   Logger.getLogger(Flappybird.class.getName()).log(Level.SEVERE, null, ex);
               } 
            clip2.start();
            }
            placepipetimer.stop();
         
            gameloop.stop();
     
        }
        if(resound==true && souund==true){
              Random rdds2=new Random();
             int er2=rdds2.nextInt();
             if(er2%2==0) er2=2;
                else er2=1;
             resound=true;
             sbg="/bgs"+String.valueOf(er2)+".wav";
                    try{
                    playsoundbg(sbg);
                            }
                    catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex){
                            ex.printStackTrace();
                            }
                    clip.setFramePosition(0);
                  clip.start();
                  resound=false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {    
    }

    @Override
    public void keyPressed(KeyEvent e) {
    
        if(gameover){
           bird.y=0;
            pipes.clear();
            score=0;
            items.clear();
            items2.clear();
            this.e=0;
          pipespeed=0;
            gameover=false;
            gameloop.start();
            placepipetimer.start();
            delay=0;
            delay2=0;
            no=0;
           
          energy=new ImageIcon(getClass().getResource("/empty.png")).getImage();
        }
              
        
        
       if(e.getKeyCode()==KeyEvent.VK_SPACE){
          
           if(pipespeed<0) {
               gravity=-1;
               velocityY=9;
           }
           else {
               
           gravity=1;
           velocityY=-9;
           }
           if(delay>0) delay--;
           if(delay2>0) delay2--;
       } 
       
      if(e.getKeyCode()==KeyEvent.VK_Z && no==100){
                        no=0;
                        score+=20;
                     pipespeed+=10;
                    delay2=15;
             if(souund==true){
            try {
                   playsoundpaimon("/undeadmode.wav");
               } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                   Logger.getLogger(Flappybird.class.getName()).log(Level.SEVERE, null, ex);
               } 
            clip2.start();
            }
      }
      
     if(start==false && e.getKeyCode()==KeyEvent.VK_N){
            if(souund==true){
            try {
                   playsoundpaimon("/button.wav");
               } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                   Logger.getLogger(Flappybird.class.getName()).log(Level.SEVERE, null, ex);
               } 
            clip2.start();
            }
            bird.y=0;
            pipes.clear();
            score=0;
            items.clear();
            items2.clear();
            this.e=0;
          pipespeed=0;
            gameover=false;
            gameloop.start();
            placepipetimer.start();
            delay=0;
            delay2=0;
            no=0;
            clip.start();
          energy=new ImageIcon(getClass().getResource("/empty.png")).getImage();
          souund=true;
          start=true;
          stopimg=new ImageIcon(getClass().getResource("/menu1.png")).getImage();
     }
     
     if(start==false && e.getKeyCode()==KeyEvent.VK_Y){
            if(souund==true){
            try {
                   playsoundpaimon("/button.wav");
               } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                   Logger.getLogger(Flappybird.class.getName()).log(Level.SEVERE, null, ex);
               } 
            clip2.start();
            }
            bird.y=0;
            pipes.clear();
            score=0;
            items.clear();
            items2.clear();
            this.e=0;
          pipespeed=0;
            gameover=false;
            gameloop.start();
            placepipetimer.start();
            delay=0;
            delay2=0;
            no=0;
       
          energy=new ImageIcon(getClass().getResource("/empty.png")).getImage();
          souund=false;
          clip.stop();
          clip2.stop();
          stopimg=new ImageIcon(getClass().getResource("/menu2.png")).getImage();
          start=true;
     }
     
     if(start==true && e.getKeyCode()==KeyEvent.VK_P){
       if(souund==true){
            try {
                   playsoundpaimon("/button.wav");
               } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                   Logger.getLogger(Flappybird.class.getName()).log(Level.SEVERE, null, ex);
               } 
            clip2.start();
            }
         pause=true;
          stopimg=new ImageIcon(getClass().getResource("/Pause.png")).getImage();
        
         placepipetimer.stop();
      
     }
     
     if(pause==true && e.getKeyCode()==KeyEvent.VK_C){
         if(souund==true){
            try {
                   playsoundpaimon("/button.wav");
               } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                   Logger.getLogger(Flappybird.class.getName()).log(Level.SEVERE, null, ex);
               } 
            clip2.start();
            }
         gameloop.start();
         placepipetimer.start();
         
         pause=false;
     }
     
       if(pause==true && e.getKeyCode()==KeyEvent.VK_R){
           if(souund==true){
            try {
                   playsoundpaimon("/button.wav");
               } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                   Logger.getLogger(Flappybird.class.getName()).log(Level.SEVERE, null, ex);
               } 
            clip2.start();
            }
           gravity=1;
           velocityY=-9;
            bird.y=0;
            pipes.clear();
            score=0;
            items.clear();
            items2.clear();
            this.e=0;
          pipespeed=0;
            gameover=false;
            gameloop.start();
            placepipetimer.start();
            delay=0;
            delay2=0;
            no=0;
            if(souund==true){
            clip.start();
            }
          energy=new ImageIcon(getClass().getResource("/empty.png")).getImage();
          pause=false;
       }
       
       if(pause==true && e.getKeyCode()==KeyEvent.VK_S){
           if(souund==true){
            try {
                   playsoundpaimon("/button.wav");
               } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                   Logger.getLogger(Flappybird.class.getName()).log(Level.SEVERE, null, ex);
               } 
            clip2.start();
            }
           souund=true;
           clip.start();
           gameloop.start();
           placepipetimer.start();
           pause=false;
       }
       
       if(pause==true && e.getKeyCode()==KeyEvent.VK_F){
           if(souund==true){
            try {
                   playsoundpaimon("/button.wav");
               } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                   Logger.getLogger(Flappybird.class.getName()).log(Level.SEVERE, null, ex);
               } 
            clip2.start();
            }
           souund=false;
           clip.stop();
           gameloop.start();
           placepipetimer.start();
           pause=false;
       }

    }
        
    @Override
    public void keyReleased(KeyEvent e) {   
    }
    
    class Bird{
        int x=birdX;
        int y=birdY;
        int width=birdwidth;
        int height=birdheight;
        Image img;

        Bird(Image img) {
            this.img=img;
            
        }
        
    }
    
  int pipex=width;
  int pipey=0;
  int pipewith=200;
  int pipeheight=512;
  Random random=new Random();
    class Pipe{
        int x=pipex;
        int y=pipey;
        int width=pipewith;
        int height=pipeheight;
        Image img;
        boolean passed=false;
        Pipe(Image img){
            this.img=img;
        }
    }
    
  Bird bird;
  int velocityY=0;
  int velocityX=-4;
  int gravity=1;
    
  ArrayList<Pipe> pipes;
    
  int itemx=width-50;
  int itemy=height/2;
  int itemwidth=54;
  int itemheight=44;
    class Item{
        int x=itemx;
        int y=itemy;
        int width=itemwidth;
        int height=itemheight;
        Image img;
        boolean got=false;
        Item(Image img){
            this.img=img;
        }
    }
  ArrayList<Item> items=new ArrayList<>();
  
  int delay=10;
  
  ArrayList<Item> items2=new ArrayList<>();
  
  int delay2=0;
  int no=0;
  Timer gameloop;
  Timer placepipetimer;  
  boolean gameover =false ;
  Clip clip;
    public void playsoundbg(String soundd) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        AudioInputStream ado= AudioSystem.getAudioInputStream(getClass().getResource(soundd));
       clip=AudioSystem.getClip();
        clip.open(ado);
    
    }
  
  Clip clip2;
    public void playsoundpaimon(String soundd) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        AudioInputStream ado= AudioSystem.getAudioInputStream(getClass().getResource(soundd));
       clip2=AudioSystem.getClip();
        clip2.open(ado);
    
    }
    
  String sbg;
  Flappybird (){
        setPreferredSize(new Dimension(width,height));
       
        setFocusable(true);
        addKeyListener(this);
        
        backgroundimg =new ImageIcon(getClass().getResource("/flappybg.png")).getImage();
        birdimg=new ImageIcon(getClass().getResource("/bird.png")).getImage();
        toppipeimg=new ImageIcon(getClass().getResource("/toppipe.png")).getImage();
        bottompipeimg=new ImageIcon(getClass().getResource("/bottom.png")).getImage();
         itemimg=new ImageIcon(getClass().getResource("/item.png")).getImage();
         undead=new ImageIcon(getClass().getResource("/undead.png")).getImage();
           energy=new ImageIcon(getClass().getResource("/empty.png")).getImage();
        
       bird=new Bird(birdimg);
       
       pipes=new ArrayList<Pipe>();
    
           placepipetimer =new Timer(1500,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                placePipes();
               clip.addLineListener(event -> {      
            if(souund==true){           
                if (event.getType() == LineEvent.Type.STOP && resound==false) {
                   resound=true;
                }
            }
            });
            }
           
         });
         
             placepipetimer.start();
       
             gameloop=new Timer(1000/40, this);
             gameloop.start();
            items=new ArrayList<Item>();
             Random rdds=new Random();
             int er=rdds.nextInt();
             if(er%2==0) er=2;
             else er=1;
             sbg="/bgs"+String.valueOf(er)+".wav";
             try{
               playsoundbg(sbg);
             }
               catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
                 e.printStackTrace();
             }
       
        
        
         clip.start(); 
        
      
                 
    }
    public boolean collision(Bird a,Pipe b){
        if(delay2>0) return false;
        return  false;


    }

    public void placePipes(){
         
        Item item=new Item(itemimg);
        int randompipe=(int)(pipey - pipeheight/4 -Math.random()*(pipeheight/2));
        //-300
        int openspace=height/4;
        Pipe toppipe=new Pipe(toppipeimg);
        toppipe.y=randompipe;
        pipes.add(toppipe);
        Random rd=new Random();
        int rdd=rd.nextInt(4, 16);
        Pipe bottom=new Pipe(bottompipeimg);
        bottom.y=toppipe.y+openspace+pipeheight;
        item.y=(int)(bottom.y-height/rdd);
       Item item2=new Item(undead);
       item2.y=(int)(bottom.y-height/rdd);
       if(e%6==0 && e!=0) {
           Random rrd=new Random();
           items2.add(item2);
       } 
       if(e%5==0){
        items.add(item);
        }
        pipes.add(bottom);
        e++;
    }
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        draw(g);
    }
  
    Image stopimg;
    
    public void draw(Graphics g){
   
        stopimg=new ImageIcon(getClass().getResource("/bg0.png")).getImage();
        if(start==false){
             g.drawImage(stopimg,0,0,width,height,null);
             gameloop.stop();
             placepipetimer.stop();
        }
      
       
         else {
            if(pause==true){
              g.drawImage(new ImageIcon(getClass().getResource("/Pause.png")).getImage(),0,0,width,height,null);
             gameloop.stop();
             placepipetimer.stop();
            }
            else {
                
        g.drawImage(backgroundimg,0,0,width,height,null);
         g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Pause (P)",210, 630);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        
         if(score>=45 && score<85){
                g.drawImage(new ImageIcon(getClass().getResource("/bg2.png")).getImage(),0,0,width,height,null);
            }
         if(score>=85 && score<135){
                g.drawImage(new ImageIcon(getClass().getResource("/bg3.png")).getImage(),0,0,width,height,null);
            }
          if(score>=135 && score<175){
                g.drawImage(new ImageIcon(getClass().getResource("/bg5.png")).getImage(),0,0,width,height,null);
            }
           if(score>=175){
                g.drawImage(new ImageIcon(getClass().getResource("/bg6.png")).getImage(),0,0,width,height,null);
            }
          
            
         
            if(delay2==0){
         if(velocityY<0) g.drawImage(new ImageIcon(getClass().getResource("/birdup.png")).getImage(), bird.x, bird.y, bird.width,bird.height,null);
        else g.drawImage(new ImageIcon(getClass().getResource("/birddown.png")).getImage(), bird.x, bird.y, bird.width,bird.height,null);
            }
            else {
               if(velocityY<0) g.drawImage(new ImageIcon(getClass().getResource("/birdupyellow.png")).getImage(), bird.x, bird.y, bird.width,bird.height,null);
        else g.drawImage(new ImageIcon(getClass().getResource("/birdyellow.png")).getImage(), bird.x, bird.y, bird.width,bird.height,null);
            }
        for(int i=0;i<pipes.size();i++){
            Pipe pip=pipes.get(i);
            g.drawImage(pip.img, pip.x, pip.y, pip.width,pip.height,null);
           
        }
       
      
        for(int j=0;j<items.size();j++){
            Item item=items.get(j);
           
            g.drawImage(item.img, item.x, item.y, item.width,item.height,null);
            
            
                   
        }
         for(int j=0;j<items2.size();j++){
            Item item=items2.get(j);
           
            g.drawImage(item.img, item.x, item.y, item.width,item.height,null);
         
            
        }
       
        if(gameover){
            g.drawString("GAME OVER !!!!",30, 80);
            g.drawString( "Score: "+String.valueOf((int) score),30, 150);
            g.drawString("Press *Space*",30, 230);
            g.drawString("to restart",30, 300);
        }
        else  {
          
            g.drawString( String.valueOf((int) score),10, 35);
             g.drawImage(energy,255,0,64, 64,null);
             if(no==100){
                  g.setColor(Color.YELLOW);
                 g.drawString( "Press *Z* ",35,540);
             }
             if(delay2>0){
                 g.setColor(Color.YELLOW);
                 g.drawString( "UNDEAD MODE!!!",15,105);
             }
             else {
                 g.setColor(Color.WHITE);
             }
        }
         }
        }
    }
   
    int pipespeed=0;
    int truoc=0;
   
    public void move(){
      
        velocityY+=gravity;
        bird.y+=velocityY;
        bird.y=Math.max(bird.y, 0);
       
  
        if(bird.y>height) gameover=true;
        for(int i=0;i<pipes.size();i++){
           int ssspeed=(int)(score/10);
          
            Pipe pipe=pipes.get(i);
            pipe.x-=ssspeed;
            
            pipe.x -= pipespeed;
            if(pipespeed<0){
               pipe.x+=ssspeed;
            }
           
            
            
            pipe.x+=velocityX;
            if(!pipe.passed && bird.x+90>pipe.x+pipe.width) {
                score+=0.5;
                pipe.passed=true;

            }
            if(collision(bird, pipe)){
                gameover=true;
            }
        }
       
        if(delay==0 && delay2==0) {
            pipespeed=0;
            placepipetimer.start();
    
        }
        if(delay2>=0 && no==0){
            energy=new ImageIcon(getClass().getResource("/empty.png")).getImage();
        }
        for(int i=0;i<items2.size();i++){
            int ssspeed=(int)(score/10);
            Item item=items2.get(i);
            item.x-=ssspeed;
            if(pipespeed<10){
                item.x+=ssspeed;
            }
            item.x-=pipespeed;
            item.x+=velocityX;

             if(!item.got && bird.x+90>=item.x+item.width && bird.x+90<item.x+item.width+90  && bird.y>=item.y-item.height && bird.y<=item.y+item.height ){
                 item.img=new ImageIcon(getClass().getResource("/got.png")).getImage();
                 item.width=84;
                 item.height=84;
                 if(souund==true){
                     try {
                         playsoundpaimon("/got.wav");
                     } catch (UnsupportedAudioFileException |IOException | LineUnavailableException ex) {
                         Logger.getLogger(Flappybird.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     clip2.start();
                     
                 }
                 item.got=true;
                 if(item.got==true && no<=50) no+=50;
                    if(no==50){
                        energy=new ImageIcon(getClass().getResource("/mid.png")).getImage();
                    }
                    if(no==100){
                        
                        energy=new ImageIcon(getClass().getResource("/full.png")).getImage();
                    
                  
                 }
             }
        }
        for(int i=0;i<items.size();i++){
            int pipeSpeed=(int)(score/10);
            Item item=items.get(i);
             int ssspeed=(int)(score/10);
             item.x-=ssspeed;
             if(pipespeed<0){
                 item.x+=ssspeed;
             }
            item.x-=pipespeed;
            item.x+=velocityX;
            
            if(!item.got && bird.x+90>=item.x+item.width && bird.x+90<item.x+item.width+90  && bird.y>=item.y-item.height && bird.y<=item.y+item.height ) {
              
                if(souund==true){
                  try {
                   playsoundpaimon("/button.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                   Logger.getLogger(Flappybird.class.getName()).log(Level.SEVERE, null, ex);
                } 
                       clip2.start();
            }
                Random rd=new Random();
                int rr=rd.nextInt();
                item.width=60;
                item.height=54;
                if(rr%2==1){
                    score-=10;
                    
                    pipespeed-=15;
                    delay=10;
                    placepipetimer.stop();
                    pipes.clear();
                   
                    item.img=new ImageIcon(getClass().getResource("/lech.png")).getImage();
                }
                else {
                    score+=10;
                     pipespeed+=5;
                    delay=15;
                    item.img=new ImageIcon(getClass().getResource("/trung.png")).getImage();
                }
                item.got=true;
               
            }
        }
    }
    
}

