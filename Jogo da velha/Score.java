import javax.swing.JLabel;
public class Score {
    private JLabel O_Wins;
    private JLabel X_Wins;
    private JLabel Draws;

    public Score(){
        O_Wins = new JLabel();
        X_Wins = new JLabel();
        Draws = new JLabel();
        clearScore();
    }

    public JLabel getO_Wins(){
        return O_Wins;
    }

    public JLabel getX_Wins(){
        return X_Wins;
    }

    public JLabel getDraws(){
        return Draws;
    }

    public void incrementWins(String currentPlayer) {
        if (currentPlayer.equals("X")) {
            int xWinsValue = Character.getNumericValue(X_Wins.getText().charAt(X_Wins.getText().length() - 1));
            xWinsValue++;
            X_Wins.setText("X_Wins = " + xWinsValue);
        } else {
            int oWinsValue = Character.getNumericValue(O_Wins.getText().charAt(O_Wins.getText().length() - 1));
            oWinsValue++;
            O_Wins.setText("O_Wins = " + oWinsValue);
        }
    }
    

    public void incrementDraws() {
        int drawsValue = Character.getNumericValue(Draws.getText().charAt(Draws.getText().length() - 1));
        drawsValue++;
        Draws.setText("Draws = " + drawsValue);
    }
    
    public void clearScore(){
        O_Wins.setText("O_Wins = 0");
        X_Wins.setText("X_Wins = 0");
        Draws.setText("Draws = 0");
    }
}