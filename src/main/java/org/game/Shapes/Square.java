package org.game.Shapes;

import java.awt.*;

public class Square extends Shape{
    private int width,height;
    public Square(int x, int y,int width,int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }
    @Override
    public Shape createShape(int x, int y) {
        return new Square(x,y,width,height);
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(),getY(),width,height);
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
}
