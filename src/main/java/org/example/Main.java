package org.example;

import org.example.map.Map;
import org.example.service.RenderService;
import org.example.service.impl.ConsoleRenderService;
import org.example.staticElements.Grass;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Map map = new Map(5,10,new ConsoleRenderService());

        map.render();
    }
}