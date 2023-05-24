import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pentagon {
    private JTextField sideField;
    private JTextField shapeNameField;
    private JButton visualize2DButton;
    private JButton visualize3DButton;
    private JButton scaleButton;
    private JButton addShadeButton;
    private JButton changeColorButton;
    private JButton saveButton;
    private JButton editButton;
    private JButton deleteButton;
    private JPanel pentagonPanel;
    private Color pentagonColor;

    Pentagon() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Create input fields
        JLabel sideLabel = new JLabel("Side:");
        sideField = new JTextField(10);

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
                if (sideField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please Insert Side of Pentagon");
                } else if (shapeNameField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please Insert Shape Name");
                } else {
                    pentagonPanel = new JPanel() {
                        @Override
                        protected void paintComponent(Graphics g) {
                            super.paintComponent(g);
                            Graphics2D g2d = (Graphics2D) g;
                            int side = Integer.parseInt(sideField.getText());
                            int[] xPoints = calculateXPoints(getWidth() / 2, side);
                            int[] yPoints = calculateYPoints(getHeight() / 2, side);
                            g2d.setColor(pentagonColor);
                            g2d.fillPolygon(xPoints, yPoints, 5);
                        }

                        private int[] calculateXPoints(int centerX, int side) {
                            int[] xPoints = new int[5];
                            for (int i = 0; i < 5; i++) {
                                xPoints[i] = (int) (centerX + side * Math.cos(Math.toRadians(90 + i * 72)));
                            }
                            return xPoints;
                        }

                        private int[] calculateYPoints(int centerY, int side) {
                            int[] yPoints = new int[5];
                            for (int i = 0; i < 5; i++) {
                                yPoints[i] = (int) (centerY - side * Math.sin(Math.toRadians(90 + i * 72)));
                            }
                            return yPoints;
                        }
                    };
                    pentagonPanel.setPreferredSize(new Dimension(300, 300));
                    frame.add(pentagonPanel);
                    frame.revalidate();
                    frame.repaint();

                    visualize2DButton.setVisible(false);
                }
            }
        });

        changeColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pentagonPanel != null) {
                    Color newColor= JColorChooser.showDialog(frame, "Choose a Color", pentagonColor);
                    if (newColor != null) {
                        pentagonColor = newColor;
                        if (pentagonPanel != null) {
                            pentagonPanel.repaint();
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
                if (pentagonPanel != null) {
                    String scaleInput = JOptionPane.showInputDialog(frame, "Enter the scale factor:");
                    if (scaleInput != null && !scaleInput.isEmpty()) {
                        try {
                            double scaleFactor = Double.parseDouble(scaleInput);
                            int side = Integer.parseInt(sideField.getText());
                            int scaledSide = (int) (side * scaleFactor);
                            sideField.setText(String.valueOf(scaledSide));
                            pentagonPanel.repaint();
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
                if (pentagonPanel != null) {
                    String newSideInput = JOptionPane.showInputDialog(frame, "Enter the new side:");
                    if (newSideInput != null && !newSideInput.isEmpty()) {
                        try {
                            int newSide = Integer.parseInt(newSideInput);
                            sideField.setText(String.valueOf(newSide));
                            pentagonPanel.repaint();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Invalid input for side.");
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
                if (pentagonPanel != null) {
                    frame.remove(pentagonPanel);
                    pentagonPanel = null;
                    frame.revalidate();
                    frame.repaint();
                    visualize2DButton.setVisible(true);
                }
            }
        });

        visualize3DButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add functionality to visualize the Pentagon in 3D
            }
        });

        frame.add(sideLabel);
        frame.add(sideField);
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
