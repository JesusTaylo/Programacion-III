package tictactoeframe;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToeFrame extends javax.swing.JFrame {

    private final JButton[][] buttons;
    private char currentPlayer = 'X'; // Inicia el jugador X
    private boolean gameEnded = false;
    private int winsX = 0;
    private int winsO = 0;

    private final JLabel labelTurno;
    private final JLabel labelGanadorX;
    private final JLabel labelGanadorO;

    public TicTacToeFrame() {
        buttons = new JButton[3][3];
        initComponents();
        initializeButtons();
        labelTurno = new JLabel("Turno de: X");
        labelTurno.setBounds(20, 240, 150, 20);
        labelGanadorX = new JLabel("X: " + winsX + " victorias");
        labelGanadorX.setBounds(200, 240, 150, 20);
        labelGanadorO = new JLabel("O: " + winsO + " victorias");
        labelGanadorO.setBounds(350, 240, 150, 20);
        add(labelTurno);
        add(labelGanadorX);
        add(labelGanadorO);
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        setSize(500, 300);
        setLayout(null);
        JPanel panelTablero = new JPanel();
        panelTablero.setLayout(new GridLayout(3, 3));
        panelTablero.setBounds(20, 20, 300, 200);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 40));
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                panelTablero.add(buttons[i][j]);
            }
        }
        add(panelTablero);
        JButton buttonReiniciar = new JButton("Reiniciar");
        buttonReiniciar.setBounds(350, 20, 100, 30);
        buttonReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarJuego();
            }
        });
        add(buttonReiniciar);
    }

    private void initializeButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        gameEnded = false;
        currentPlayer = 'X';
        labelTurno.setText("Turno de: X");
    }

    private void checkWinner() {
    
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                    buttons[i][0].getText().equals(buttons[i][2].getText()) &&
                    !buttons[i][0].getText().isEmpty()) {
                endGame(buttons[i][0].getText() + " gana!");
                return;
            }
        }

      
        for (int j = 0; j < 3; j++) {
            if (buttons[0][j].getText().equals(buttons[1][j].getText()) &&
                    buttons[0][j].getText().equals(buttons[2][j].getText()) &&
                    !buttons[0][j].getText().isEmpty()) {
                endGame(buttons[0][j].getText() + " gana!");
                return;
            }
        }

       
        if (buttons[0][0].getText().equals(buttons[1][1].getText()) &&
                buttons[0][0].getText().equals(buttons[2][2].getText()) &&
                !buttons[0][0].getText().isEmpty()) {
            endGame(buttons[0][0].getText() + " gana!");
            return;
        }
        if (buttons[0][2].getText().equals(buttons[1][1].getText()) &&
                buttons[0][2].getText().equals(buttons[2][0].getText()) &&
                !buttons[0][2].getText().isEmpty()) {
            endGame(buttons[0][2].getText() + " gana!");
            return;
        }

      
        boolean fullBoard = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().isEmpty()) {
                    fullBoard = false;
                    break;
                }
            }
        }
        if (fullBoard) {
            endGame("¡Empate!");
        }
    }

    private void endGame(String message) {
        gameEnded = true;
        javax.swing.JOptionPane.showMessageDialog(this, message);
        if (!message.equals("¡Empate!")) {
            if (currentPlayer == 'X') {
                winsX++;
                labelGanadorX.setText("X: " + winsX + " victorias");
            } else {
                winsO++;
                labelGanadorO.setText("O: " + winsO + " victorias");
            }
        }
    }

    private void reiniciarJuego() {
        initializeButtons();
    }

    private class ButtonClickListener implements ActionListener {

        private final int x;
        private final int y;

        public ButtonClickListener(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!gameEnded && buttons[x][y].getText().isEmpty()) {
                buttons[x][y].setText(String.valueOf(currentPlayer));
                checkWinner();
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                labelTurno.setText("Turno de: " + currentPlayer);
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new TicTacToeFrame().setVisible(true);
        });
    }
}
