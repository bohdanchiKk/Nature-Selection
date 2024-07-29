package org.example.staticElements;

import org.example.abstraction.Entity;
import org.example.view.Emoji;

import java.util.Random;

public class Tree extends Entity {
    public Tree(){
        this.emoji = Emoji.TREE[new Random().nextInt(Emoji.TREE.length)];
    }
}
