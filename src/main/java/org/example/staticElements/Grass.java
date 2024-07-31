package org.example.staticElements;

import org.example.objects.Entity;
import org.example.view.Emoji;

import java.util.Random;

public class Grass extends Entity {
    public Grass(){
        this.emoji = Emoji.GRASS[new Random().nextInt(Emoji.GRASS.length)];
    }
}
