package org.game.Shapes;

import java.awt.*;

public class Circle extends Shape{
    private int width,heigth;

    public Circle(int x, int y,int width,int height) {
        super(x, y);
        this.width = width;
        this.heigth = height;
    }

    @Override
    public Shape createShape(int x, int y) {
        return new Circle(x,y,width,heigth);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX(),getY(),width,heigth);
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public int getWidth() {
        return width;
    }

    public int getHeigth() {
        return heigth;
    }
}
