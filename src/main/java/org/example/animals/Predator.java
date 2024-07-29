package org.example.animals;

import org.example.abstraction.Entity;
import org.example.view.Emoji;

import java.util.Random;

public class Predator extends Entity {
    public Predator(){
        this.emoji = Emoji.CARNIVORE[new Random().nextInt(Emoji.CARNIVORE.length)];
    }
}
