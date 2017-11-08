package org.academiadecodigo.pacman.grid;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.ScreenWriter;
import com.googlecode.lanterna.terminal.Terminal;
import org.academiadecodigo.pacman.FileHelper;
import org.academiadecodigo.pacman.objects.GameObject;
import org.academiadecodigo.pacman.objects.fruit.Edible;

import java.io.*;
import java.util.LinkedList;

/**
 * Created by codecadet on 05/11/17.
 */
public class Grid {

    private Screen screen;
    private ScreenWriter screenWriter;
    private int cols;
    private int rows;
    private LinkedList<Position> walkablePositions = new LinkedList<>();

    public Grid() {

        cols = 55;
        rows = 30;
    }

    public void init() {

        screen = TerminalFacade.createScreen();

        screen.getTerminal().getTerminalSize().setColumns(cols);
        screen.getTerminal().getTerminalSize().setRows(rows);

        //screen.getTerminal().setCursorVisible(false);
        screen.setCursorPosition(null);

        screenWriter = new ScreenWriter(screen);

        screen.startScreen();
    }

    public void drawGrid() {

        screen.clear();

        String[] rows = FileHelper.readFromFile().split("\\n");

        for (int i = 0; i < rows.length; i++) {

            char[] row = rows[i].toCharArray();

            for (int j = 0; j < row.length; j++) {

                System.out.println(i + " " + j);
                if (row[j] == '0') {

                    walkablePositions.add(new Position(j, i));
                    screenWriter.drawString(j, i, " ");
                    screenWriter.setBackgroundColor(Terminal.Color.WHITE);
                }
            }
        }
        screen.refresh();
    }

    public void draw(Position position, Terminal.Color color) {


        screenWriter.setBackgroundColor(color);

        screenWriter.drawString(position.getCol(), position.getRow(), " ");
        screen.refresh();
    }

    public LinkedList<Position> getWalkablePositions() {

        for (Position pos : walkablePositions) {
            System.out.println(pos.getCol() + " , " + pos.getRow());
        }

        return walkablePositions;
    }

    /*
    void clear() {
    }


    public void drawObjects(GameObject[] objects) {

        for (GameObject object : objects) {

            if (object instanceof Edible) {

                // screenWriter.drawString(object.getCol(), object.getPos().getRow(), object.toString());

            } else {

                // screenWriter.drawString(object.getPos().getCol(), object.getPos().getRow(), object.toString());
            }

        }
    }
*/
}
