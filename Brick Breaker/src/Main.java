import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
      
        JFrame gameFrame = new GameFrame();

        gameFrame.setTitle("Brick Breaker Game");

        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameFrame.setBounds(10, 10, 700, 600);

        
        gameFrame.setResizable(false);

        gameFrame.add(new GamePanel());

        gameFrame.setVisible(true);
    }
}
