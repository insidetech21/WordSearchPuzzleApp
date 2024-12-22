/*
Implement an application which works as follows

1. Splash Screen
2. enter numbers m & n which indirectly indicates m rows and n column of a 2D grid.
3. the user should enter alphabets such that one alphabet occupies one position in the grid. Here we will need m*n number of alphabets.
4. grid creation done
5. Display the grid. Now The user can provide a text which needs to be searched in the grid.
6. If the text is available in the grid, then those alphabets should be highlighted if the text in the grid is readable in left to right direction (east), or top to bottom direction (south) or diagonal (south-east).
7. User can change the text provided in step 5 and check for the occurance of the word in the grid.

Note -
1. At anytime, the user should be able to reset the setup and the application starts again from step 2.
2. APK and the Source code should be shared via dropbox, google drive etc... to hr@mobigic.com
*/

package com.example.wordsearchpuzzleapp;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

public class MainActivity extends AppCompatActivity {
    private EditText rowsInput, colsInput, searchTextInput;
    private Button createGridButton, searchButton, resetButton;
    private GridLayout gridLayout;
    private char[][] grid;
    private int rows, cols;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rowsInput = findViewById(R.id.rowsInput);
        colsInput = findViewById(R.id.colsInput);
        searchTextInput = findViewById(R.id.searchTextInput);
        createGridButton = findViewById(R.id.createGridButton);
        searchButton = findViewById(R.id.searchButton);
        resetButton = findViewById(R.id.resetButton);
        gridLayout = findViewById(R.id.gridLayout);

        createGridButton.setOnClickListener(v -> createGrid());
        searchButton.setOnClickListener(v -> searchWord());
        resetButton.setOnClickListener(v -> resetApp());
    }

    private void createGrid() {
        if (rowsInput.getText().toString().isEmpty() || colsInput.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter valid dimensions!", Toast.LENGTH_SHORT).show();
            return;
        }

        rows = Integer.parseInt(rowsInput.getText().toString());
        cols = Integer.parseInt(colsInput.getText().toString());
        grid = new char[rows][cols];

        gridLayout.removeAllViews();
        gridLayout.setRowCount(rows);
        gridLayout.setColumnCount(cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                EditText cell = new EditText(this);
                cell.setEms(1);
                cell.setTextColor(Color.BLACK);
                cell.setBackgroundColor(Color.LTGRAY);
                gridLayout.addView(cell);

                final int row = i, col = j;
                cell.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {}

                    @Override
                    public void afterTextChanged(Editable s) {
                        if (s.length() > 0) {
                            grid[row][col] = s.charAt(0);
                        }
                    }
                });
            }
        }
    }

    private void searchWord() {
        String word = searchTextInput.getText().toString();
        if (word.isEmpty()) {
            Toast.makeText(this, "Enter a word to search.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (searchInGrid(word)) {
            Toast.makeText(this, "Word Found!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Word Not Found", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean searchInGrid(String word) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (checkWord(word, i, j)) {
                    highlightWord(word, i, j);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkWord(String word, int x, int y) {
        if (y + word.length() <= cols) {
            for (int k = 0; k < word.length(); k++) {
                if (grid[x][y + k] != word.charAt(k)) return false;
            }
            return true;
        }

        if (x + word.length() <= rows) {
            for (int k = 0; k < word.length(); k++) {
                if (grid[x + k][y] != word.charAt(k)) return false;
            }
            return true;
        }

        if (x + word.length() <= rows && y + word.length() <= cols) {
            for (int k = 0; k < word.length(); k++) {
                if (grid[x + k][y + k] != word.charAt(k)) return false;
            }
            return true;
        }
        return false;
    }

    private void highlightWord(String word, int startX, int startY) {
        int length = word.length();

        if (startY + length <= cols) {
            for (int i = 0; i < length; i++) {
                View cell = gridLayout.getChildAt(startX * cols + startY + i);
                cell.setBackgroundColor(Color.YELLOW);
            }
        }

        if (startX + length <= rows) {
            for (int i = 0; i < length; i++) {
                View cell = gridLayout.getChildAt((startX + i) * cols + startY);
                cell.setBackgroundColor(Color.YELLOW);
            }
        }

        if (startX + length <= rows && startY + length <= cols) {
            for (int i = 0; i < length; i++) {
                View cell = gridLayout.getChildAt((startX + i) * cols + startY + i);
                cell.setBackgroundColor(Color.YELLOW);
            }
        }
    }

    private void resetApp() {
        rowsInput.setText("");
        colsInput.setText("");
        searchTextInput.setText("");
        gridLayout.removeAllViews();
        grid = null;
        Toast.makeText(this, "Setup reset. Start again.", Toast.LENGTH_SHORT).show();
    }
}
