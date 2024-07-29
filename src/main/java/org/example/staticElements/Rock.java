package org.example.staticElements;

import org.example.abstraction.Entity;
import org.example.view.Emoji;

import java.util.Random;

public class Rock extends Entity {
    public Rock(){
        this.emoji = Emoji.ROCK[new Random().nextInt(Emoji.ROCK.length)];
    }
}
