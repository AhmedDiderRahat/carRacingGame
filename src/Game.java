import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aziz Ahmed Chowdhury & Ahmed Dider Rahat
 */

public final class Game extends JPanel 
{
        public static int  TreadTime = 10;
	int crx,cry;				//location of cross_road
	int car_x,car_y;			//location of car
	int speedX,speedY;	
	int nOpponent;
	String imageLoc[];
	int lx[],ly[];
	int score;
	int highScore;
	int speedOpponent[];
	boolean isUp, isDown, isRight, isLeft;
	
	public Game() throws FileNotFoundException, IOException
        {
		crx = cry = -999;
		addKeyListener(new KeyListener()
                {
                    public void keyTyped(KeyEvent e) {
                    }
                    public void keyReleased(KeyEvent e) {
                            stopCar(e);
                    }
                    public void keyPressed(KeyEvent e) {
                            moveCar(e);
                    }
		});
		setFocusable(true);
		car_x = 10;
                car_y = 200;
		isUp = isDown = isLeft = isRight = false;
		speedX = speedY = 0;
		nOpponent = 0;
		lx = new int[20];
		ly = new int[20];
		imageLoc = new String[20];
		speedOpponent = new int[20];		
		score = 0;
                highScore = 0; 
                String line;
                BufferedReader br = new BufferedReader(new FileReader("highScore.txt"));
                try 
                {
                    StringBuilder sb = new StringBuilder();
                    line = br.readLine();
                    System.out.println(line +" ");
                } finally {
                    br.close();
                }
                highScore = Integer.parseInt(line);   
            
                
                JFrame frame = new JFrame("Car Racing Game");
                frame.add(this);
                frame.setSize(500,500);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
                runer();            
	}
	
	public void paint(Graphics g)
        {
            super.paint(g);
            Graphics2D obj = (Graphics2D) g;
            obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            try
            {		
                obj.drawImage(getToolkit().getImage("images/st_road.png"), 0, 0 ,this);

                obj.drawImage(getToolkit().getImage("images/car_self.png"),car_x,car_y,this);

                if(this.nOpponent > 0)
                {
                    for(int i=0;i<this.nOpponent;i++){
                            obj.drawImage(getToolkit().getImage(this.imageLoc[i]),this.lx[i],this.ly[i],this);
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
	}

	void moveRoad(int count) throws IOException
        {
            
            if(crx == -999 && cry == -999)
            {
                if(count%10 == 0)
                {
                        crx = 499;
                        cry = 0;
                }
            }
            else
                crx--;
		
            if(crx == -499 && cry == 0)
		crx = cry = -999;

            car_x += speedX;
            car_y += speedY;
		
            //Restricted to go beyond the screen
            if(car_x < 0)
                car_x = 0;
		
            //Restricted to go outside the right side
            if(car_x+93 >= 500)
		car_x = 500-93;
			
            //Restriction of road also
            if(car_y <= 124)
                car_y = 124;
            if(car_y >= 364-50)
                car_y = 364-50;
		
            //also run opponents
            for(int i=0;i<this.nOpponent;i++)
            {
                this.lx[i] -= speedOpponent[i];
            }
		
            int index[] = new int[nOpponent];
            for(int i=0;i<nOpponent;i++)
            {
                if(lx[i] >= -127)
                {
                    index[i] = 1;
                }
            }
            int c = 0;
            for(int i=0;i<nOpponent;i++)
            {
                if(index[i] == 1)
                {
                    imageLoc[c] = imageLoc[i];
                    lx[c] = lx[i];
                    ly[c] = ly[i];
                    speedOpponent[c] = speedOpponent[i];
                    c++;
                }
            }
            score += nOpponent - c;
           
            if(score > highScore)
                highScore = score;

            nOpponent = c;
            //Check for collision
            int diff = 0;
            for(int i=0;i<nOpponent;i++)
            {
                diff = car_y - ly[i];
		if((ly[i] >= car_y && ly[i] <= car_y+46) || (ly[i]+46 >= car_y && ly[i]+46 <= car_y+46))
                {
                    if(car_x+87 >= lx[i] && !(car_x >= lx[i]+87))
                    {
                        this.finish(); //collicion
                    }
		}
            }
	}	
        
        public void runer()
        {
            int count = 1, c = 1;
    	
            while(true)
            {
                try {
                    this.moveRoad(count);
                } catch (IOException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
                while(c <= 1)
                {
                    this.repaint();
                    try
                    {
                        Thread.sleep(Game.TreadTime);
                    }
                    catch(Exception e)
                    { System.out.println(e); }
                    c++;
                }
                c = 1;
                count++;
                if(this.nOpponent < 4 && count % 200 == 0)
                {
                    this.imageLoc[this.nOpponent] = "images/car_left_"+((int)((Math.random()*100)%5)+1)+".png";
                    this.lx[this.nOpponent] = 499;
                    int p = (int)(Math.random()*100)%4;
                    if(p == 0)
                        p = 250;

                    else if(p == 1)
                        p = 300;

                    else if(p == 2)
                        p = 185;

                    else
                        p = 130;
                    
                    this.ly[this.nOpponent] = p;
                    this.speedOpponent[this.nOpponent] = (int)(Math.random()*100)%2 + 2;
                    this.nOpponent++;
                }
            }
        }
	
	void finish() throws IOException
        {
            if(score >= highScore)
            {
                JOptionPane.showMessageDialog(this,"Game Over!!!\nYour Score : "
                        +score+"\nIts a High Score" , "Game Over", JOptionPane.YES_NO_OPTION);
                
                BufferedWriter bw = null;
                FileWriter fw = null;
                String content = highScore + "";

                fw = new FileWriter("highScore.txt");
                bw = new BufferedWriter(fw);
                bw.write(content);
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Game Over!!!\nYour Score : "
                        +score+"\nAnd the High Score is: " + highScore  , "Game "
                                + "Over", JOptionPane.YES_NO_OPTION);
            }
            
           // LandingPage landingPage = new LandingPage();     
            
            System.exit(ABORT);
            
	}
	
	public void moveCar(KeyEvent e)
        {
            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                isRight = true;
                speedY = 1;
            }
            if(e.getKeyCode() == KeyEvent.VK_LEFT){
                isLeft = true;
                speedY = -1;
            }
	}
	
	public void stopCar(KeyEvent e)
        {	 
            if(e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                isLeft = false;
                speedY = 0;
            }
            else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            { 
                isRight = false;
                speedY = 0;
            }
	}
}
