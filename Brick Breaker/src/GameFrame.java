import javax.swing.JFrame;

public class GameFrame extends JFrame {

    public GameFrame() {
      
        setTitle("Brick Breaker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(10, 10, 700, 600);

       
        GamePanel gamePanel = new GamePanel();
        add(gamePanel); 
        setVisible(true);
    }

    public static void main(String[] args) {
       
        new GameFrame();
    }
}
