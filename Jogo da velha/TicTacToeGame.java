import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class TicTacToeGame {
    private Gui graphics;
    private Board boardGame;
    private Score score;
    private String currentPlayer;
    private Boolean GameEnd;

    //inicializar jogo
    public TicTacToeGame(){
        GameEnd = false;
        boardGame = new Board();
        score = new Score();
        initializeGUI();
        currentPlayer = "X";
    }

    //adicionando a capacidade de responder a eventos nos botões e inicializando a GUI do game
    private void initializeGUI(){
        // eventos nas células do jogo da velha
        ActionListener cc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent action){
                JButton jb = (JButton) action.getSource();
                clickCell(jb);
            }
        };
        for (JButton cell : boardGame.getBoard()) cell.addActionListener(cc);

        //eventos nos botões de controle do jogo
        JButton reset = new JButton("Reiniciar Game");
        reset.addActionListener(event -> resetGame());
        JButton resetScore = new JButton("Reiniciar Score");
        resetScore.addActionListener(event -> score.clearScore());

        //crindo a janela do jogo
        graphics = new Gui(boardGame.getBoard(), reset, resetScore, score.getO_Wins(), score.getX_Wins(), score.getDraws());
    }

    //reseta o game
    private void resetGame(){
        boardGame.clearBoard();
        currentPlayer = "X";
        GameEnd = false;
    }

    //eventos ao apertar uma célula da matriz do jogo
    private void clickCell(JButton button){
        if (!GameEnd){
            if (button.getText() == "") button.setText(currentPlayer); else return;
            if (checkWin()){
                GameEnd = true;
                score.incrementWins(currentPlayer);
            }
            else if (boardGame.boardIsFull()){
                score.incrementDraws();
                return;
            }
            currentPlayer = currentPlayer == "X" ? "O" : "X";
        }
    }

    //checa as linhas da matriz pra ver se algumas delas está preenchida com a jogada vencedora
    private Boolean checkLines(){
        for (int i = 1; i <= 7; i+=3){
            if (boardGame.getCell(i).getText().equals(currentPlayer) 
            && boardGame.getCell(i-1).getText().equals(currentPlayer)
            && boardGame.getCell(i+1).getText().equals(currentPlayer)) return true;
        }
        return false;
    }

     //checa as colunas da matriz pra ver se algumas delas está preenchida com a jogada vencedora
    private Boolean checkColumns(){
        for (int i = 0; i < 3; i++){
            if (boardGame.getCell(i).getText().equals(currentPlayer)
            && boardGame.getCell(i + 3).getText().equals(currentPlayer)
            && boardGame.getCell(i + 6).getText().equals(currentPlayer)) return true;
        }
        return false;
    }

    //checa se a diagonal principal possui a jogada vencedora
    private Boolean checkDiagonal(){
        return boardGame.getCell(0).getText().equals(currentPlayer)
            && boardGame.getCell(4).getText().equals(currentPlayer)
            && boardGame.getCell(8).getText().equals(currentPlayer);
    }

    //checa se a diagonal secundária possui a jogada vencedora
    private Boolean checkSecundaryDiagonal(){
        return boardGame.getCell(2).getText().equals(currentPlayer)
            && boardGame.getCell(4).getText().equals(currentPlayer)
            && boardGame.getCell(6).getText().equals(currentPlayer);
    }

    //checa se existe uma jogada vencedora no jogo
    private Boolean checkWin(){
        return checkLines() || checkColumns() || checkDiagonal() || checkSecundaryDiagonal();
    }

    public static void main(String[] args) {
        new TicTacToeGame();
    }
}