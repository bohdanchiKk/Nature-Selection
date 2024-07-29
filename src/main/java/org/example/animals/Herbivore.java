package org.example.animals;

import org.example.abstraction.Entity;
import org.example.view.Emoji;

import java.util.Random;

public class Herbivore extends Entity {
    public Herbivore(){
        this.emoji = Emoji.HERBIVORE[new Random().nextInt(Emoji.HERBIVORE.length)];
    }
}
