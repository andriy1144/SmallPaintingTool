package org.game;

import org.game.Shapes.Circle;
import org.game.Shapes.Shape;
import org.game.Shapes.Square;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomistingWindow {
    private JFrame frame;
    private PaintingArea paintingArea;

    public CustomistingWindow(PaintingArea paintingArea){
        this.paintingArea = paintingArea;

        frame = new JFrame("Customise!");
        frame.setLayout(new BorderLayout());

        frame.setSize(new Dimension(600,400));
        frame.setResizable(false);

        Shape shape = paintingArea.getDrawingShape();

        ViewPanel viewPanel = new ViewPanel(shape);
        SettingsPanel settingsPanel = new SettingsPanel(viewPanel);

        frame.add(viewPanel,BorderLayout.WEST);
        frame.add(settingsPanel,BorderLayout.EAST);

        frame.setAlwaysOnTop(true);

        frame.setVisible(true);
    }

    private class ViewPanel extends JPanel{
        private final int WIDTH = 300;
        private final int HEIGHT = 400;
        private Shape shape;
        public ViewPanel(Shape shape){
            setPreferredSize(new Dimension(WIDTH,HEIGHT));

            if(shape instanceof Square){
                int posX = (WIDTH - ((Square) shape).getWidth())/2;
                int posY = (HEIGHT - ((Square) shape).getHeight())/2;
                this.shape = shape.createShape(posX,posY);
            }else if(shape instanceof Circle){
                int posX = (WIDTH - ((Circle) shape).getWidth())/2;
                int posY = (HEIGHT - ((Circle) shape).getHeigth())/2;
                this.shape = shape.createShape(posX,posY);
            }

            setBorder(BorderFactory.createLineBorder(Color.blue));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(shape.getColor());
            shape.draw(g);
        }
        public void setShape(Shape shape){
            this.shape = shape;
            if(shape instanceof Square){
                //Centering a square in of the panel
                int posX = (WIDTH - ((Square) shape).getWidth())/2;
                int posY = (HEIGHT - ((Square) shape).getHeight())/2;
                shape.setY(posY);
                shape.setX(posX);
            }else if(shape instanceof Circle){
                int posX = (WIDTH - ((Circle) shape).getWidth())/2;
                int posY = (HEIGHT - ((Circle) shape).getHeigth())/2;
                shape.setX(posX);
                shape.setY(posY);
            }

            repaint();
        }
        public Shape getShape(){
            return this.shape;
        }
    }
    private class SettingsPanel extends JPanel implements ActionListener {
        private final int WIDTH = 300, HEIGHT = 400;

        private Shape shape;

        private ViewPanel viewPanel;

        public SettingsPanel(ViewPanel viewPanel){
            setPreferredSize(new Dimension(WIDTH,HEIGHT));

            setLayout(new FlowLayout(FlowLayout.CENTER));

            this.viewPanel = viewPanel;
            this.shape = viewPanel.getShape();

            if (shape instanceof Square) {
                createSquareSettings();
            }else if(shape instanceof  Circle){
                createCircleSettings();
            }

            JButton save = new JButton("Save!");
            JButton canel = new JButton("Cancel!");

            save.addActionListener(this);
            canel.addActionListener(this);

            add(save);
            add(canel);
        }

        private void addSlider(ChangeListener listener,int startValue){
            JSlider slider = new JSlider(2,200,startValue);
            slider.setValueIsAdjusting(true);
            slider.addChangeListener(listener);

            add(slider);
        }

        public void createSquareSettings(){
            Square squareShape = (Square) shape;

            JLabel widthLabel = new JLabel("WIDTH: ");

            ChangeListener widthListner = (e) -> {
                        JSlider slider = (JSlider) e.getSource();
                        squareShape.setWidth(slider.getValue());

                        viewPanel.setShape(squareShape);
                    };

            add(widthLabel);
            addSlider(widthListner,squareShape.getWidth());

            //Slider
            JLabel heightLabel = new JLabel("HEIGHT: ");
            ChangeListener heightListner = (e) -> {
                JSlider slider = (JSlider) e.getSource();
                squareShape.setHeight(slider.getValue());

                viewPanel.setShape(squareShape);
            };

            add(heightLabel);
            addSlider(heightListner,squareShape.getHeight());

            this.shape = squareShape;
        }

        public void createCircleSettings(){
            Circle circle = (Circle) shape;

            JLabel widthLabel = new JLabel("WIDTH: ");
            ChangeListener widthListner = (e) -> {
                JSlider slider = (JSlider) e.getSource();
                circle.setWidth(slider.getValue());

                viewPanel.setShape(circle);
            };

            JLabel heightLabel = new JLabel("HEIGHT: ");

            ChangeListener heightListener = (e) -> {
                JSlider slider = (JSlider) e.getSource();
                circle.setHeigth(slider.getValue());

                viewPanel.setShape(circle);
            };

            add(widthLabel);
            addSlider(widthListner,circle.getWidth());

            add(heightLabel);
            addSlider(heightListener,circle.getHeigth());
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String event = e.getActionCommand();

            if(event.equals("Save!")){
                paintingArea.setDrawingShape(this.shape);
            }
            frame.dispose();
        }
    }
}
