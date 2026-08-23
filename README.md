# 🧩 Sudoku Solver

An automated Sudoku puzzle solver built using the **Backtracking Algorithm**. The program takes a 9x9 grid representing an unsolved Sudoku puzzle and fills in the missing numbers according to standard Sudoku rules.

Available in two versions:
- **Java** — Console-based solver with formatted grid output
- **Web (HTML/CSS/JS)** — Interactive browser-based solver with a modern UI and live visualization

---

## 📖 Overview

Sudoku is a classic constraint satisfaction problem. This project solves it using **backtracking**, a depth-first search technique that:

1. Finds the next empty cell in the grid
2. Tries placing digits 1–9 in that cell
3. Checks whether the digit is valid (not repeated in the same row, column, or 3×3 sub-grid)
4. If valid, places the digit and recursively attempts to solve the rest of the puzzle
5. If a later placement fails, it **backtracks** — undoes the last move and tries the next digit
6. Repeats until the entire grid is filled or all possibilities are exhausted

---

## ✨ Features

- Solves any valid 9x9 Sudoku puzzle automatically
- Efficient backtracking algorithm with constraint checking (row, column, and 3×3 box validation)
- Clean, formatted console output (Java version) with box separators
- Displays solve time in milliseconds
- Web version includes an attractive, responsive UI with puzzle selection and live grid rendering
- Easily extendable to support custom puzzle input

---

## 🛠️ Tech Stack

| Version | Technologies |
|---------|-------------|
| Console | Java (JDK 8+) |
| Web     | HTML5, CSS3, JavaScript (Vanilla) |

---

## 📂 Project Structure

```
sudoku-solver/
│
├── SudokuSolver.java     # Java console-based solver
├── index.html            # Web-based solver (UI + logic)
├── README.md             # Project documentation
└── screenshots/          # (optional) UI screenshots
```

---

## 🚀 Getting Started

### Java Version

**Prerequisites:** JDK 8 or higher installed

```bash
# Clone the repository
git clone https://github.com/<your-username>/sudoku-solver.git
cd sudoku-solver

# Compile
javac SudokuSolver.java

# Run
java SudokuSolver
```

### Web Version

Simply open `index.html` in any modern browser — no build step or server required.

```bash
# Clone the repository
git clone https://github.com/<your-username>/sudoku-solver.git
cd sudoku-solver

# Open in browser
open index.html   # macOS
start index.html  # Windows
```

---

## 🧠 Algorithm Explanation

The core logic revolves around three functions:

- **`findEmptyCell()`** — Scans the grid to locate the next unfilled cell (value `0`)
- **`isValidPlacement()`** — Verifies a candidate digit doesn't already exist in the same row, column, or 3×3 box
- **`solveSudoku()`** — Recursive backtracking function that attempts digits 1–9 in each empty cell, recursing forward on success and backtracking on failure

**Time Complexity:** O(9^(n×n)) in the worst case, though constraint checking prunes the search space significantly in practice, making it fast for typical puzzles.

---

## 📸 Sample Output (Java Console)

```
Unsolved Sudoku Puzzle:
5 3 . | . 7 . | . . .
6 . . | 1 9 5 | . . .
. 9 8 | . . . | . 6 .
------+-------+------
8 . . | . 6 . | . . 3
4 . . | 8 . 3 | . . 1
7 . . | . 2 . | . . 6
------+-------+------
. 6 . | . . . | 2 8 .
. . . | 4 1 9 | . . 5
. . . | . 8 . | . 7 9

Solved Sudoku Puzzle:
5 3 4 | 6 7 8 | 9 1 2
6 7 2 | 1 9 5 | 3 4 8
1 9 8 | 3 4 2 | 5 6 7
------+-------+------
8 5 9 | 7 6 1 | 4 2 3
4 2 6 | 8 5 3 | 7 9 1
7 1 3 | 9 2 4 | 8 5 6
------+-------+------
9 6 1 | 5 3 7 | 2 8 4
2 8 7 | 4 1 9 | 6 3 5
3 4 5 | 2 8 6 | 1 7 9

## 🔮 Future Enhancements

- [ ] Accept custom puzzle input via file or user prompt
- [ ] Add GUI (Java Swing/JavaFX) with step-by-step visualization
- [ ] Puzzle generator (create solvable puzzles of varying difficulty)
- [ ] Sudoku validity checker for user-submitted grids
- [ ] Support for larger grid variants (16x16)

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

## 🙋 Author
Soundarya Umesh Barigidad,
Information Science Engineering Student

Internship Project -SkillCraft Technology 
