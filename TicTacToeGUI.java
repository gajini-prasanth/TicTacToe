import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeGUI extends JFrame implements ActionListener {

    private final JButton[][] buttons = new JButton[3][3];
    private char currentPlayer = 'X';
    private final JLabel statusLabel;
    private boolean gameOver = false;

    public TicTacToeGUI() {
        setTitle("Tic Tac Toe");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        JLabel title = new JLabel("Tic Tac Toe Game", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(title, BorderLayout.NORTH);

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3));
        Font buttonFont = new Font("Arial", Font.BOLD, 60);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(buttonFont);
                buttons[i][j].setFocusPainted(false);
                boardPanel.add(buttons[i][j]);
            }
        }

        add(boardPanel, BorderLayout.CENTER);

        statusLabel = new JLabel("Player X's turn", JLabel.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        statusLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(statusLabel, BorderLayout.SOUTH);

    
    }

    
    public void init() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].addActionListener(this);
            }
        }
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) return;

        JButton clickedButton = (JButton) e.getSource();

        if (!clickedButton.getText().equals("")) return;

        clickedButton.setText(String.valueOf(currentPlayer));

        if (checkWin()) {
            statusLabel.setText("Player " + currentPlayer + " wins!");
            JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!");
            gameOver = true;
            askRestart();
            return;
        }

        if (checkDraw()) {
            statusLabel.setText("It's a draw!");
            JOptionPane.showMessageDialog(this, "It's a draw!");
            gameOver = true;
            askRestart();
            return;
        }

        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        statusLabel.setText("Player " + currentPlayer + "'s turn");
    }

    private boolean checkWin() {
        String s = String.valueOf(currentPlayer);
        for (int i = 0; i < 3; i++) {
            if (s.equals(buttons[i][0].getText()) && s.equals(buttons[i][1].getText()) && s.equals(buttons[i][2].getText())) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (s.equals(buttons[0][i].getText()) && s.equals(buttons[1][i].getText()) && s.equals(buttons[2][i].getText())) {
                return true;
            }
        }

        boolean diag1 = s.equals(buttons[0][0].getText()) && s.equals(buttons[1][1].getText()) && s.equals(buttons[2][2].getText());
        boolean diag2 = s.equals(buttons[0][2].getText()) && s.equals(buttons[1][1].getText()) && s.equals(buttons[2][0].getText());
        return diag1 || diag2;
    }

    private boolean checkDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (buttons[i][j].getText().equals("")) return false;
        return true;
    }

    private void askRestart() {
        int option = JOptionPane.showConfirmDialog(this, "Do you want to play again?", "Restart Game",
                JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            resetBoard();
        } else {
            System.exit(0);
        }
    }

    private void resetBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                buttons[i][j].setText("");

        currentPlayer = 'X';
        statusLabel.setText("Player X's turn");
        gameOver = false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TicTacToeGUI gui = new TicTacToeGUI();
            gui.init();
        });
    }
}

