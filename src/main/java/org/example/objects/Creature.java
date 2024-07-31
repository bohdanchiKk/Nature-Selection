package org.example.objects;

import org.example.map.Cell;
import org.example.map.Map;
import org.example.service.PathFinderService;

import java.util.Deque;

public abstract class Creature extends Entity {
    protected int speed;
    protected int hp;
    protected PathFinderService pathFinderService;
    protected Map map;
    protected Deque<Cell> currentPath;

    abstract public void makeMove(Cell currentCell);

    public boolean isAlive(){ return hp > 0; }
}
