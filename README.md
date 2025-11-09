# TicTacToe
This project builds a Tic Tac Toe game in Java using Swing. It applies OOP concepts, GUI design, and event handling. Players alternate turns on a 3x3 grid, with logic to detect wins, losses, or draws. A reset option restarts the game. It’s a beginner-friendly demo of interactive desktop app development.

Project Overview
Title: Tic Tac Toe Game Using Java (GUI Version)

Author: GAJINI PRASANTH G

Purpose: Demonstrates how to build an interactive Tic Tac Toe game using Java Swing, focusing on GUI design, event handling, and logical reasoning.

 Objectives
Create a user-friendly GUI for Tic Tac Toe.

Apply object-oriented programming (OOP) principles.

Implement logic checks for win, loss, and draw conditions.

Provide a reset functionality to restart the game without closing the app.

🛠 System Design
Class: TicTacToeGUI

Components:

JFrame → main window

JPanel → 3x3 grid layout

JButton → each cell of the board

ActionListener → handles clicks and updates game state

Logic checks → determine winner, draw, or continue

 Implementation Highlights
Game Flow:

Players alternate turns (X and O).

Each button click updates the board.

Checks rows, columns, and diagonals for a win.

Declares a draw if all cells are filled with no winner.

Restart Feature:

After win/draw, prompts user to restart or exit.

Reset clears the board and sets turn back to Player X.

Java Code Features
Uses Swing components (JFrame, JPanel, JButton, JLabel).

Event-driven programming with ActionListener.

Game state tracking with currentPlayer, gameOver, and statusLabel.

Methods:

checkWin() → verifies winning conditions.

checkDraw() → checks if board is full.

resetBoard() → clears board for new game.

askRestart() → prompts restart confirmation.

 Output Screens
Game Board: 3x3 grid with clickable buttons.

Status Label: Displays whose turn it is.

Pop-up Messages:

“Player X wins!” or “It’s a draw!”

Restart confirmation dialog.

Conclusion
The project successfully shows how Java Swing can be used to build interactive desktop applications. It’s a solid beginner-friendly example of combining GUI design, event handling, and logical reasoning in Java.
