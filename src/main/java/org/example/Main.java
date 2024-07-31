package org.example;

import org.example.map.Map;
import org.example.service.impl.ConsoleRenderService;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting simulation");
        Simulation simulation = new Simulation(new Map(10,10, new ConsoleRenderService()));
        simulation.map.render();

        simulation.startSimulation();
        Scanner scanner = new Scanner(System.in);
        var ch = scanner.nextLine();

        if (ch != null){
            simulation.pauseSimulation();
        }
        scanner.close();



    }
}