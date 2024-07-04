import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.EmptyBorder;
import java.awt.BasicStroke;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Gui extends JFrame {

    public Gui(JButton[] boardGame, JButton resetGame, JButton resetScore, JLabel O_wins, JLabel X_wins, JLabel draws) {
        this.setBoard(boardGame);
        this.setScore(O_wins, X_wins, draws);
        this.setButtons(resetGame, resetScore);
        this.setBorder();
        this.activateFrame();
    }

    private void activateFrame(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setTitle("Jogo da Velha");
        setSize(600, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon("R.png").getImage());
        getContentPane().setBackground(Color.YELLOW);
        setVisible(true);
    }

    private void setBoard(JButton[] boardGame){
        int k = 0;
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                add(boardGame[k]);
                boardGame[k].setFont(new Font("MV Boli", Font.CENTER_BASELINE, 50));
                boardGame[k].setBounds((i * 100) + 135, (j * 100) + 100, 100, 100);
                boardGame[k].setBorder(new EmptyBorder(0, 0, 0, 0)); // Remove a borda padrão
                boardGame[k].setFocusPainted(false);
                boardGame[k].setContentAreaFilled(false);
                boardGame[k].setOpaque(true);
                boardGame[k].setBackground(Color.YELLOW);
                boardGame[k].setBorder(new RoundedBorder(50, 5));
                k++;
            }
        }
    }

    private void setScore(JLabel O_wins, JLabel X_wins, JLabel draws){
        O_wins.setBounds(80, 420, 200, 50);
        X_wins.setBounds(230, 420, 200, 50);
        draws.setBounds(380, 420, 200, 50);
        O_wins.setFont(new Font("MV Boli", Font.CENTER_BASELINE, 20));
        X_wins.setFont(new Font("MV Boli", Font.CENTER_BASELINE, 20));
        draws.setFont(new Font("MV Boli", Font.CENTER_BASELINE, 20));
        add(O_wins);
        add(X_wins);
        add(draws);
    }

    private void setButtons(JButton resetGame, JButton resetScore){
        resetGame.setBackground(Color.WHITE);
        resetGame.setBorder(new RoundedBorder(40, 5));
        resetGame.setForeground(Color.WHITE);
        resetGame.setFont(new Font("MV Boli", Font.CENTER_BASELINE, 12));
        resetGame.setContentAreaFilled(false);
        resetGame.setBounds(50, 500, 100, 50);
        resetGame.setFocusPainted(false);
        add(resetGame);
        resetScore.setBounds(450, 500, 100, 50);
        resetScore.setBackground(Color.BLUE);
        resetScore.setBorder(new RoundedBorder(40, 5));
        resetScore.setContentAreaFilled(false);
        resetScore.setForeground(Color.WHITE);
        resetScore.setFont(new Font("MV Boli", Font.CENTER_BASELINE, 12));;
        add(resetScore);
    }

    private void setBorder(){
        JPanel jp = new JPanel();
        jp.setLayout(null);
        jp.setBounds(0, 0, 600, 80);
        jp.setBackground(Color.BLACK);
        JLabel title = new JLabel("JOGO DA VELHA");
        title.setBounds(150, 0, 600, 80);
        title.setFont(new Font("MV Boli", Font.CENTER_BASELINE, 30));
        title.setForeground(Color.WHITE);
        jp.add(title);
        add(jp);

        JPanel jp2 = new JPanel();
        jp2.setBounds(0, 490, 600, 100);
        jp2.setBackground(Color.black);
        add(jp2);
    }

    private class RoundedBorder extends javax.swing.border.AbstractBorder {
        private int radius;
        private int borderWidth;

        public RoundedBorder(int radius, int borderWidth) {
            this.radius = radius;
            this.borderWidth = borderWidth;
        }

        @Override
        public void paintBorder(java.awt.Component c, java.awt.Graphics g, int x, int y, int width, int height) {
            super.paintBorder(c, g, x, y, width, height);
            java.awt.Graphics2D g2d = (java.awt.Graphics2D) g;
            g2d.setStroke(new BasicStroke(borderWidth));
            g2d.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, radius, radius));
        }
    }
    
}
