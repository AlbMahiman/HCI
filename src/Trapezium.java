import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Trapezium {
    private JTextField topWidthField;
    private JTextField bottomWidthField;
    private JTextField heightField;
    private JTextField shapeNameField;
    private JButton visualize2DButton;
    private JButton visualize3DButton;
    private JButton scaleButton;
    private JButton addShadeButton;
    private JButton changeColorButton;
    private JButton saveButton;
    private JButton editButton;
    private JButton deleteButton;
    private JPanel trapeziumPanel;
    private Color trapeziumColor;

    Trapezium() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Create input fields
        JLabel topWidthLabel = new JLabel("Top Width:");
        topWidthField = new JTextField(10);

        JLabel bottomWidthLabel = new JLabel("Bottom Width:");
        bottomWidthField = new JTextField(10);

        JLabel heightLabel = new JLabel("Height:");
        heightField = new JTextField(10);

        JLabel shapeNameLabel = new JLabel("Shape Name:");
        shapeNameField = new JTextField(10);

        // Create buttons
        visualize2DButton = new JButton("Visualize 2D");
        visualize3DButton = new JButton("Visualize 3D");
        scaleButton = new JButton("Scale Shape");
        addShadeButton = new JButton("Add Shade");
        changeColorButton = new JButton("Change Color");
        saveButton = new JButton("Save Shape");
        editButton = new JButton("Edit Shape");
        deleteButton = new JButton("Delete Shape");

        // Add components to the frame
        visualize2DButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (topWidthField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please Insert Top Width of Trapezium");
                } else if (bottomWidthField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please Insert Bottom Width of Trapezium");
                } else if (heightField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please Insert Height of Trapezium");
                } else if (shapeNameField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please Insert Shape Name");
                } else {
                    trapeziumPanel = new JPanel() {
                        @Override
                        protected void paintComponent(Graphics g) {
                            super.paintComponent(g);
                            Graphics2D g2d = (Graphics2D) g;
                            int topWidth = Integer.parseInt(topWidthField.getText());
                            int bottomWidth = Integer.parseInt(bottomWidthField.getText());
                            int height = Integer.parseInt(heightField.getText());
                            int centerX = getWidth() / 2;
                            int centerY = getHeight() / 2;

                            int[] xPoints = {centerX - topWidth / 2, centerX + topWidth / 2, centerX + bottomWidth / 2, centerX - bottomWidth / 2};
                            int[] yPoints = {centerY - height / 2, centerY - height / 2, centerY + height / 2, centerY + height / 2};

                            g2d.setColor(trapeziumColor);
                            g2d.fillPolygon(xPoints, yPoints, 4);
                        }
                    };
                    trapeziumPanel.setPreferredSize(new Dimension(300, 300));
                    frame.add(trapeziumPanel);
                    frame.revalidate();
                    frame.repaint();

                    visualize2DButton.setVisible(false);
                }
            }
        });

        changeColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (trapeziumPanel != null) {
                    Color newColor = JColorChooser.showDialog(frame, "Choose a Color", trapeziumColor);
                    if (newColor != null) {
                        trapeziumColor = newColor;
                        if (trapeziumPanel != null) {
                            trapeziumPanel.repaint();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please Create the Shape First");
                }
            }
        });

        scaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (trapeziumPanel != null) {
                    String scaleInput = JOptionPane.showInputDialog(frame, "Enter the scale factor:");
                    if (scaleInput != null && !scaleInput.isEmpty()) {
                        try {
                            double scaleFactor = Double.parseDouble(scaleInput);
                            int topWidth = Integer.parseInt(topWidthField.getText());
                            int bottomWidth = Integer.parseInt(bottomWidthField.getText());
                            int height = Integer.parseInt(heightField.getText());

                            int scaledTopWidth = (int) (topWidth * scaleFactor);
                            int scaledBottomWidth = (int) (bottomWidth * scaleFactor);
                            int scaledHeight = (int) (height * scaleFactor);

                            topWidthField.setText(String.valueOf(scaledTopWidth));
                            bottomWidthField.setText(String.valueOf(scaledBottomWidth));
                            heightField.setText(String.valueOf(scaledHeight));

                            trapeziumPanel.repaint();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Invalid input for scale factor.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please Create the Shape First");
                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (trapeziumPanel != null) {
                    String newTopWidthInput = JOptionPane.showInputDialog(frame, "Enter the new top width:");
                    String newBottomWidthInput = JOptionPane.showInputDialog(frame, "Enter the new bottom width:");
                    String newHeightInput = JOptionPane.showInputDialog(frame, "Enter the new height:");

                    if (newTopWidthInput != null && !newTopWidthInput.isEmpty() &&
                            newBottomWidthInput != null && !newBottomWidthInput.isEmpty() &&
                            newHeightInput != null && !newHeightInput.isEmpty()) {
                        try {
                            int newTopWidth = Integer.parseInt(newTopWidthInput);
                            int newBottomWidth = Integer.parseInt(newBottomWidthInput);
                            int newHeight = Integer.parseInt(newHeightInput);

                            topWidthField.setText(String.valueOf(newTopWidth));
                            bottomWidthField.setText(String.valueOf(newBottomWidth));
                            heightField.setText(String.valueOf(newHeight));

                            trapeziumPanel.repaint();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Invalid input for dimensions.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please Create the Shape First");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (trapeziumPanel != null) {
                    frame.remove(trapeziumPanel);
                    trapeziumPanel = null;
                    frame.revalidate();
                    frame.repaint();
                    visualize2DButton.setVisible(true);
                }
            }
        });

        visualize3DButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the visualization of Trapezium in 3D here
            }
        });

        frame.add(topWidthLabel);
        frame.add(topWidthField);
        frame.add(bottomWidthLabel);
        frame.add(bottomWidthField);
        frame.add(heightLabel);
        frame.add(heightField);
        frame.add(shapeNameLabel);
        frame.add(shapeNameField);
        frame.add(visualize2DButton);
        frame.add(visualize3DButton);
        frame.add(scaleButton);
        frame.add(addShadeButton);
        frame.add(changeColorButton);
        frame.add(saveButton);
        frame.add(editButton);
        frame.add(deleteButton);
    }

}