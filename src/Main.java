import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(500,500);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton circleButton = new JButton("Circle");
        JButton squareButton = new JButton("Square");
        JButton rectangleButton = new JButton("Rectangle");
        JButton starButton = new JButton("Star");
        JButton hexagonButton = new JButton("Hexagon");
        JButton pentagonButton = new JButton("Pentagon");
        JButton triangleButton = new JButton("Triangle");
        JButton rhombusButton = new JButton("Rhombus");

        // Add action listeners to buttons

        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Circle circle = new Circle();
            }
        });

        squareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Square square = new Square();
            }
        });

        rectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rectangle = new Rectangle();
            }
        });

        starButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Star star = new Star();
            }
        });

        hexagonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hexagon hexagon = new Hexagon();
            }
        });

        pentagonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pentagon pentagon = new Pentagon();
            }
        });

        triangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Triangle triangle = new Triangle();
            }
        });

        rhombusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rhombus rhombus = new Rhombus();
            }
        });

        frame.add(circleButton);
        frame.add(squareButton);
        frame.add(rectangleButton);
        frame.add(starButton);
        frame.add(hexagonButton);
        frame.add(pentagonButton);
        frame.add(triangleButton);
        frame.add(rhombusButton);
    }
}