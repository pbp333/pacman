package org.academiadecodigo.gameplay.game_objects.movables;

import org.academiadecodigo.gameplay.grid.Position;

public interface Movable {

    void move();

    boolean isAlive();

    void die();

    Position getPosition();

    void setPosition(int col, int row);
}