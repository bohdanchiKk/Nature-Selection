package org.example.service.impl;

import org.example.Cell;
import org.example.map.Map;
import org.example.service.RenderService;

public class ConsoleRenderService implements RenderService {
    private Map map;
    public ConsoleRenderService(){
        this.map = map;
    }
    @Override
    public void render(Map map) {
        //clear console
//        System.out.print("\033\143");

        //draw map
        System.out.print("   ");  // Оставляем место для y координат
        for (int i = 0; i < map.x; i++) {
            System.out.print(" x" + i + " ");
        }
        System.out.println();

        // Печать карты с координатами
        for (int j = 0; j < map.y; j++) {
            // Печать координаты y в начале каждой строки
            System.out.print("y" + j + " ");
            for (int i = 0; i < map.x; i++) {
                var cell = map.entities.get(new Cell(i, j));
                System.out.print(cell == null ? " .. " : " " + cell.getEmoji() + " ");
            }
            System.out.println();
        }
//        for (int i = 0; i < map.x; i++) {
//            for (int j = 0; j < map.y; j++) {
//                var cell = map.entities.get(new Cell(i, j));
//                System.out.print(cell == null ? " .. " : " " + cell.getEmoji() + " ");
//            }
//            System.out.println(System.lineSeparator());
//        }

    }
}
