package puzzlegame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PuzzleGame extends JFrame {

    private JButton[][] buttons;
    private final int rows = 4;
    private final int cols = 4;
    private Timer timer;
    private int elapsedTime;
    private boolean gamePaused;
    private JLabel timerLabel;

    public PuzzleGame() {
        initComponents();
        initializeGame();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Puzzle Game");
        setSize(400, 450);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(rows, cols));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttons = new JButton[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                panel.add(buttons[i][j]);
            }
        }

        add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        JButton pauseButton = new JButton("Pausa");
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!gamePaused) {
                    timer.stop();
                    gamePaused = true;
                } else {
                    timer.start();
                    gamePaused = false;
                }
            }
        });
        buttonPanel.add(pauseButton);

        JButton resetButton = new JButton("Reiniciar");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeGame();
            }
        });
        buttonPanel.add(resetButton);

        add(buttonPanel, BorderLayout.SOUTH);

        timerLabel = new JLabel("Tiempo: 0");
        add(timerLabel, BorderLayout.NORTH);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!gamePaused) {
                    elapsedTime++;
                    timerLabel.setText("Tiempo: " + elapsedTime);
                }
            }
        });
    }

    private void initializeGame() {
        elapsedTime = 0;
        timer.stop();
        gamePaused = false;
        timerLabel.setText("Tiempo: 0");

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (index < 15) {
                    buttons[i][j].setText(String.valueOf(numbers.get(index)));
                    index++;
                } else {
                    buttons[i][j].setText("");
                }
            }
        }

        timer.start();
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
            JButton clickedButton = buttons[x][y];
            int[] emptySpace = findEmptySpace();
            if (emptySpace != null && isAdjacent(emptySpace[0], emptySpace[1], x, y)) {
                buttons[emptySpace[0]][emptySpace[1]].setText(clickedButton.getText());
                clickedButton.setText("");
                if (checkWin()) {
                    timer.stop();
                    JOptionPane.showMessageDialog(PuzzleGame.this, "¡Has ganado!");
                }
            }
        }
    }

    private boolean isAdjacent(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2) == 1;
    }

    private int[] findEmptySpace() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (buttons[i][j].getText().isEmpty()) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private boolean checkWin() {
        int expectedValue = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!buttons[i][j].getText().isEmpty()) {
                    int value = Integer.parseInt(buttons[i][j].getText());
                    if (value != expectedValue) {
                        return false;
                    }
                    expectedValue++;
                } else if (i != rows - 1 || j != cols - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new PuzzleGame().setVisible(true);
        });
    }
}
