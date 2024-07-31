package org.example.objects;

import org.example.map.Cell;
import org.example.map.Map;
import org.example.service.impl.BFSPathFinderService;
import org.example.view.Emoji;

import java.util.ArrayDeque;
import java.util.Random;


public class Predator extends Creature {

    private int attack;
    public Predator(int hp, int speed, int attack, Map map){
        this.pathFinderService = new BFSPathFinderService(map);
        this.map = map;
        this.currentPath = new ArrayDeque<>();
        this.emoji = Emoji.CARNIVORE[new Random().nextInt(Emoji.CARNIVORE.length)];
        this.hp = hp;
        this.speed = speed;
        this.attack = attack;
    }
    @Override
    public void makeMove(Cell currentCell) {

        System.out.println("Making move from cell x: " + currentCell.getX() + ", y: " + currentCell.getY());

        for(int step = 0; step < this.speed; step++){

            //check if there is prey nearby
            var preyOnCell = this.pathFinderService.isPreyNear(currentCell);

            if (preyOnCell != null){
                System.out.println("Carnivore caught prey on cell x: " + preyOnCell.getX() + " y:" + preyOnCell.getY() + " and attacked it. Arrrgh!");
                Hervibore prey = (Hervibore) map.entities.get(preyOnCell);
                prey.hp -= this.attack;
                if (!prey.isAlive()){
                    System.out.println("Carnivore killed prey on cell x: " + preyOnCell.getX() + " y:" + preyOnCell.getY() + " and ate it. Yum!");
                    map.entities.put(preyOnCell, null);
                }
                //rerender
                this.map.render();
                break;
            }

            //follow the path
            Cell movingTo = this.currentPath.pollFirst();
            //if there isn't current path, add path
            if (movingTo == null){
                currentPath.addAll(pathFinderService.findPathToPrey(currentCell));
                movingTo = this.currentPath.pollFirst();
            }

            this.map.entities.put(movingTo,this);
            this.map.entities.put(currentCell,null);
            currentCell = movingTo;

            System.out.println("Carnivore moved to cell x: " + currentCell.getX() + " y:" + currentCell.getY() + ". Stomp!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.map.render();
        }

    }
}
