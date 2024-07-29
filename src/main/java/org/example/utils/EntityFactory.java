package org.example.utils;

import org.example.abstraction.Entity;
import org.example.animals.Herbivore;
import org.example.animals.Predator;
import org.example.map.Map;
import org.example.staticElements.Grass;
import org.example.staticElements.Rock;
import org.example.staticElements.Tree;

import java.util.Random;

public class EntityFactory {
    private Map map;
    public EntityFactory(Map map){
        this.map = map;
    }

    public Entity getRandomEntity(){
        int a = new Random().nextInt(20);

        switch (a){
            case 0 -> {
                return new Grass();
            }
            case 1 -> {
                return new Rock();
            }
            case 2 -> {
                return new Tree();
            }
            case 3 -> {
                return new Herbivore();
//                return new Herbivore(new Random().nextInt(5), new Random().nextInt(5),map);
            }
            case 4 -> {
                return new Predator();
//                return new Predator(new Random().nextInt(5), new Random().nextInt(5),map);
            }
            default -> {
                return null;
            }
        }
    }
}
