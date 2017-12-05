package tileno;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static tileno.util.MathHelper.map;

public class Graph extends JFrame {
    public static HashMap<String, Integer> DATA = new HashMap<>();

    private int width, height,max_points;

    public Graph(int width, int height, String title,int max_points) {
        this.setSize(new Dimension(width, height));
        this.setTitle(title);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.width = width;
        this.height = height;
        this.max_points = max_points;
    }

    /**
     * Adds a person to the graph
     * @param name of the person or data
     * @param points the amount of reached points
     */
    void addPerson(String name, int points) {
        if (points > 20) points = 20;
        DATA.put(name, points);
    }

    @Override
    public void paint(Graphics g) {
        int j = 0;
        for (Map.Entry<String, Integer> d : DATA.entrySet()) {
            this.drawData(g, d.getValue(), 64 * j);

            g.setColor(Color.BLACK);
            g.drawString(d.getKey(), 50 + 64 * j, 250);

            j++;
        }

        g.setColor(Color.BLACK);
        g.drawLine(0, 228, this.width, 228);
        g.drawLine(32, 0, 32, this.height);
        g.drawString("" + this.max_points, 16, 128 - 20);
        g.drawString("0", 23, 240);
    }


    /**
     * An utility method to draw all data on the screen
     * @param g graphics
     * @param points points to draw
     * @param xOffset the x offset on the graph
     */
    private void drawData(Graphics g, int points, int xOffset) {
        g.setColor(Color.BLACK);
        g.drawRect(50 + xOffset, 100, 32, 128);
        g.setColor(Color.BLUE);
        int h = (int) map(points, 0, this.max_points, 0, 128);
        g.fillRect(50 + xOffset, 100 + (128 - h), 32, h);
    }
}
