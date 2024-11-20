package org.game;

import org.game.Listeners.MouseListener_;
import org.game.Shapes.Circle;
import org.game.Shapes.Square;

import javax.swing.*;
import java.awt.*;
import org.game.Shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class PaintingArea extends JPanel {
    private final int WIDTH = 1280,HEIGHT = 640;

    List<Shape> shapes;
    private Shape drawingShape;
    private Color drawingColor = Color.BLACK;

    private int cursorX, cursorY;
    private boolean isDrawing = false;

    private MouseListener_ mouseListener;

    public PaintingArea(){
        setBorder(BorderFactory.createLineBorder(Color.black,1));
        setPreferredSize(new Dimension(WIDTH,HEIGHT));

        mouseListener = new MouseListener_(this);
        addMouseMotionListener(mouseListener);
        addMouseListener(mouseListener);

        shapes = new ArrayList<>();
        drawingShape = new Circle(cursorX,cursorY,10,10);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Calculating positions to put a shape right into the center
        int posX = cursorX,posY = cursorY;

        if(drawingShape instanceof Square) {
            posX = cursorX - ((Square) drawingShape).getWidth() / 2;
            posY = cursorY - ((Square) drawingShape).getHeight() / 2;
        }else if(drawingShape instanceof Circle){
            posX = cursorX - ((Circle) drawingShape).getWidth()/2;
            posY = cursorY - ((Circle) drawingShape).getHeigth()/2;
        }

        //Drawing all previous shapes
        if(!shapes.isEmpty()) {
            for (Shape shape : shapes) {
                shape.draw(g);
            }
        }

        //Drawing shape
        if(isDrawing) {
            Shape shape = drawingShape.createShape(posX, posY);
            shape.setColor(drawingColor);
            shapes.add(shape);

            shape.draw(g);
        }

        //Creating a pointer
        Shape pointer = drawingShape.createShape(posX,posY);
        pointer.setColor(Color.red);
        pointer.draw(g);

        isDrawing = false;
    }

    public void setCursorX(int cursorX){
        this.cursorX = cursorX;
        repaint();
    }

    public void setCursorY(int cursorY){
        this.cursorY = cursorY;
        repaint();
    }

    public void setDrawing(boolean state){
        this.isDrawing = true;
    }

    public void clearCanvas(){
        shapes.clear();
        System.out.println("<-- Canvas has been cleared -->");

        repaint();
    }

    public Color getColor(){
        return this.drawingColor;
    }

    public void setColor(Color color){
        this.drawingColor = color;
    }

    public Shape getDrawingShape(){
        return this.drawingShape;
    }

    public void setDrawingShape(Shape shape){
        this.drawingShape = shape;
    }
}