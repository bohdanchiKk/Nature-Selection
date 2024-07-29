package org.example.abstraction;

import org.example.Cell;

public abstract class Creature extends Entity {
    protected int speed;
    protected int hp;


    abstract public void makeMove(Cell currentCell);
    public boolean isAlive(){ return hp > 0; }
}
