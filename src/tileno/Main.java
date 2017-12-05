package tileno;

import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Graph graph = new Graph(600,400,"Competition points",20);
        CakeGraph cgraph = new CakeGraph(800,600,"Competition points");

        Scanner sc = new Scanner(System.in);

        System.out.println("Program to start(0 - graph, 1 - cake graph): ");
        int i = sc.nextInt();

        switch (i){
            case 0:
                graph.addPerson("Matej",3);
                graph.addPerson("Uroš",16);
                graph.addPerson("Dominik",1);
                graph.addPerson("Erik",20);
                graph.setVisible(true);
                break;

            case 1:
                cgraph.addPerson(Color.BLUE,3);
                cgraph.addPerson(Color.ORANGE,16);
                cgraph.addPerson(Color.GREEN,1);
                cgraph.addPerson(Color.PINK,20);
                cgraph.setVisible(true);
                break;
        }
    }
}
