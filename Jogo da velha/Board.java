import javax.swing.JButton;

public class Board{
    private JButton[] boardGame;
    
    public Board(){
        boardGame = new JButton[9];
        for (int i = 0; i < 9; i++)
            boardGame[i] = new JButton("");
    }

    public Boolean boardIsFull(){
        for(JButton jb : boardGame) if (jb.getText().equals("")) return false;
        return true;
    }

    public JButton[] getBoard(){
        return boardGame;
    }

    public void clearBoard(){
        for (int i = 0; i < 9; i++) boardGame[i].setText("");
    }
    public JButton getCell(int index){
        return boardGame[index];
    }
}