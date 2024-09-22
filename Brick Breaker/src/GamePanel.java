import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;  
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private boolean play = false;
    private int score = 0;

    private int totalBricks = 21;

    private Timer timer;
    private int delay = 8;

    private int paddleX = 310; 

    private int ballPosX = 120; 
    private int ballPosY = 350; 
    private int ballXDir = -1;  
    private int ballYDir = -2;  

    private BrickGenerator brickMap;

    public GamePanel() {
        brickMap = new BrickGenerator(3, 7); 
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        timer = new Timer(delay, this);
        timer.start();
    }

  
    @Override
    public void paint(Graphics g) {
      
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.black);
        g2d.fillRect(1, 1, 692, 592);

        brickMap.draw(g2d); 

      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
       
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (paddleX >= 600) {
                paddleX = 600;
            } else {
                moveRight();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (paddleX < 10) {
                paddleX = 10;
            } else {
                moveLeft();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!play) {
                play = true;
                ballPosX = 120;
                ballPosY = 350;
                ballXDir = -1;
                ballYDir = -2;
                paddleX = 310;
                score = 0;
                totalBricks = 21;
                brickMap = new BrickGenerator(3, 7);

                repaint();
            }
        }
    }

    public void moveRight() {
        play = true;
        paddleX += 20;
    }

    public void moveLeft() {
        play = true;
        paddleX -= 20;
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
