**Project Name:** Word Search Puzzle App

**Project Description:**
The Word Search Puzzle App is an interactive Android application developed using Java, designed to create and solve custom word search grids. This project demonstrates dynamic UI creation, word search algorithms, and user interaction in a visually appealing and functional way.

**Features:**

**1.Splash Screen:**
- A visually engaging splash screen that appears upon launching the app, creating a smooth transition to the main interface.

**2.Dynamic Grid Creation:**
- Users can define the grid size by entering the number of rows (m) and columns (n).
- The grid dynamically adjusts to the specified dimensions.

**3.Alphabet Input:**
- Each cell in the grid allows the user to input one alphabet.
- The app validates that the grid is fully populated before proceeding.

**4.Grid Display and Word Search:**
- The user can view the created grid.
- A text input field allows the user to search for words within the grid.

**5.Word Highlighting:**
- If the searched word exists in the grid, it is highlighted:
  - Horizontally (Left to Right - East)
  - Vertically (Top to Bottom - South)
  - Diagonally (Top-Left to Bottom-Right - South-East)

**6.Search Modification:**
Users can change the search term and recheck the grid for new words without recreating the grid.

**7.Reset Functionality:**
Users can reset the app at any time to start from scratch.
Resets the grid, inputs, and search queries to their initial state.

**Technical Details:**
**Programming Language:** Java
**Development Environment:** Android Studio
**UI Framework:** AndroidX

**Key Components:**
GridLayout for dynamic grid creation.
TextWatcher for real-time alphabet input.
Custom word search algorithm for multiple directions.

**How It Works:**
1. The app starts with a Splash Screen and transitions to the main activity.
2. The user specifies grid dimensions and fills the grid with alphabets.
3. Words are searched within the grid based on user input, highlighting matches.
4. Users can modify the search query or reset the entire setup to create a new grid.

**Use Case:**
The app is ideal for practicing vocabulary, solving custom word puzzles, and demonstrating dynamic UI and algorithmic implementation in Android applications.
