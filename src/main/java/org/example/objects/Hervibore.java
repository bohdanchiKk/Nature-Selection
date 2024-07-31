package org.example.objects;

import org.example.map.Cell;
import org.example.map.Map;
import org.example.service.impl.BFSPathFinderService;
import org.example.view.Emoji;

import java.util.ArrayDeque;
import java.util.Random;

public class Hervibore extends Creature {

    public Hervibore(int hp, int speed, Map map){
        this.pathFinderService = new BFSPathFinderService(map);
        this.map = map;
        this.emoji = Emoji.HERBIVORE[new Random().nextInt(Emoji.HERBIVORE.length)];
        this.hp = hp;
        this.speed = speed;
        this.currentPath = new ArrayDeque<>();
    }
    @Override
    public void makeMove(Cell currentCell) {
        System.out.println("Making move from cell x: " + currentCell.getX() + ", y: " + currentCell.getY());

        for(int step = 0; step < this.speed; step++){
            //check if there is grass nearby
            var grassOnCell = this.pathFinderService.isGrassNear(currentCell);

            if (grassOnCell != null){
                System.out.println("Herbivore found grass on cell x: "+ grassOnCell.getX()+" and ate it. Yum!");
                map.entities.put(grassOnCell, null);
                //rerender
                this.map.render();
                break;
            }
            //follow the path
            Cell movingTo = this.currentPath.pollFirst();
            //if there isn't current path, add path
            if (movingTo == null){
                currentPath.addAll(pathFinderService.findPathToGrass(currentCell));
                movingTo = this.currentPath.pollFirst();
            }
            this.map.entities.put(movingTo,this);
            this.map.entities.put(currentCell,null);
            currentCell = movingTo;
            System.out.println("Herbivore moved to cell x: " + currentCell.getX() + " y:" + currentCell.getY() + ". Stomp!");
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            this.map.render();
        }
    }
}
