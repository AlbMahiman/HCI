import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rectangle {
    private JTextField widthField;
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
    private JPanel rectanglePanel;
    private Color rectangleColor;

    public Rectangle() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(600, 600);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Create input fields
        JLabel widthLabel = new JLabel("Width:");
        widthField = new JTextField(10);

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
                if (widthField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please Insert Width of Rectangle");
                } else if (heightField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please Insert Height of Rectangle");
                } else if (shapeNameField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please Insert Shape Name");
                } else {
                    rectanglePanel = new JPanel() {
                        @Override
                        protected void paintComponent(Graphics g) {
                            super.paintComponent(g);
                            Graphics2D g2d = (Graphics2D) g;
                            double width = Double.parseDouble(widthField.getText());
                            double height = Double.parseDouble(heightField.getText());
                            int rectWidth = (int) width;
                            int rectHeight = (int) height;
                            int x = (getWidth() - rectWidth) / 2;
                            int y = (getHeight() - rectHeight) / 2;
                            g2d.setColor(rectangleColor);
                            g2d.fillRect(x, y, rectWidth, rectHeight);
                        }
                    };
                    rectanglePanel.setPreferredSize(new Dimension(300, 300));
                    frame.add(rectanglePanel);
                    frame.revalidate();
                    frame.repaint();

                    visualize2DButton.setVisible(false);
                }
            }
        });

        changeColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rectanglePanel != null) {
                    Color newColor = JColorChooser.showDialog(frame, "Choose a Color", rectangleColor);
                    if (newColor != null) {
                        rectangleColor = newColor;
                        if (rectanglePanel != null) {
                            rectanglePanel.repaint();
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
                if (rectanglePanel != null) {
                    String scaleInput = JOptionPane.showInputDialog(frame, "Enter the scale factor:");
                    if (scaleInput != null && !scaleInput.isEmpty()) {
                        try {
                            double scaleFactor = Double.parseDouble(scaleInput);
                            double width = Double.parseDouble(widthField.getText());
                            double height = Double.parseDouble(heightField.getText());
                            double scaledWidth = width * scaleFactor;
                            double scaledHeight = height * scaleFactor;
                            widthField.setText(String.valueOf(scaledWidth));
                            heightField.setText(String.valueOf(scaledHeight));
                            rectanglePanel.repaint();
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
                if (rectanglePanel != null) {
                    String newWidthInput = JOptionPane.showInputDialog(frame, "Enter the new width:");
                    if (newWidthInput != null && !newWidthInput.isEmpty()) {
                        try {
                            double newWidth = Double.parseDouble(newWidthInput);
                            widthField.setText(String.valueOf(newWidth));
                            rectanglePanel.repaint();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Invalid input for width.");
                        }
                    }

                    String newHeightInput = JOptionPane.showInputDialog(frame, "Enter the new height:");
                    if (newHeightInput != null && !newHeightInput.isEmpty()) {
                        try {
                            double newHeight = Double.parseDouble(newHeightInput);
                            heightField.setText(String.valueOf(newHeight));
                            rectanglePanel.repaint();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Invalid input for height.");
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
                if (rectanglePanel != null) {
                    frame.remove(rectanglePanel);
                    rectanglePanel = null;
                    frame.revalidate();
                    frame.repaint();
                    visualize2DButton.setVisible(true);
                }
            }
        });

        visualize3DButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        frame.add(widthLabel);
        frame.add(widthField);
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
