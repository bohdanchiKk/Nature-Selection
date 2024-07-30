package org.example.service;

import org.example.Cell;

import java.util.Deque;
import java.util.List;

public interface PathFinderService {
    Cell isGrassNear(Cell cell);
    Cell isPreyNear(Cell cell);
    List<Cell> emptyCellsNear(Cell cell);

    Deque<Cell> findPathToGrass(Cell cell);

    Deque<Cell> findPathToPrey(Cell cell);
}
