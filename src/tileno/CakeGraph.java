package tileno;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CakeGraph extends JFrame {
    private static ArrayList<Slice> DATA = new ArrayList<>();
    private int width, height;
    private String data_name;

    CakeGraph(int width, int height, String title, String data_name) {
        this.setSize(new Dimension(width, height));
        this.setTitle(title);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.width = width;
        this.height = height;
        this.data_name = data_name;
    }

    CakeGraph(int width, int height, String title) {
        this(width, height, title, title);
    }

    /**
     * Adds a person to the graph
     *
     * @param c      color of the data
     * @param points the amount of reached points
     */
    void addPerson(Color c, int points) {
        DATA.add(new Slice(points, c));
    }

    @Override
    public void paint(Graphics g) {
        Slice[] data = new Slice[DATA.size()];
        for (int i = 0; i < DATA.size(); i++) {
            data[i] = DATA.get(i);
        }
        this.drawPie((Graphics2D) g, new Rectangle(width / 2 - 100, height / 2 - 100, 200, 200), data);
        for (int i = 0; i < DATA.size(); i++) {
            this.drawLegend(g, DATA.get(i).color, DATA.get(i).value, i * 32);
        }
    }

    /**
     * An utility method that draws the legend on the screen so we can better see the data values
     *
     * @param g       graphics
     * @param c       color of date
     * @param val     value of data
     * @param yOffset offset on the y axis
     */
    private void drawLegend(Graphics g, Color c, int val, int yOffset) {
        g.setColor(Color.BLACK);
        int start_x = 50;
        int start_y = 100;
        int len_x = 110 + (5 * this.data_name.length());
        int end_y = 128 + yOffset;

        g.drawLine(start_x, start_y, len_x, start_y);
        g.drawLine(start_x + 25, start_y - 20, start_x + 25, end_y);
        g.setColor(c);
        g.fillRect(start_x + 6, end_y - 20, 12, 12);
        g.setColor(Color.BLACK);
        g.drawString("" + val, start_x + 30, end_y - 10);
        g.drawString(this.data_name, start_x + 30, start_y - 5);
    }

    /**
     * @param g      graphics used to draw
     * @param area   area specified for drawing the pie chart
     * @param slices an array that contains all the slices with their data
     */
    private void drawPie(Graphics2D g, Rectangle area, Slice[] slices) {
        double total = 0.0D;
        for (Slice slice1 : slices) {
            total += slice1.value;
        }
        double curValue = 0.0D;
        int startAngle;
        for (Slice slice : slices) {
            startAngle = (int) (curValue * 360 / total);
            int arcAngle = (int) (slice.value * 360 / total);
            g.setColor(slice.color);
            g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
            curValue += slice.value;
        }
    }
}
