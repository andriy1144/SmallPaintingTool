package org.game.Shapes;

import java.awt.*;

public abstract class Shape {
    private int x,y;
    private Color color;
    public Shape(int x,int y){
        color = Color.BLACK;
        this.x = x;
        this.y = y;
    }
    public Shape(int x,int y,Color color){
        this.color = color;
        this.x = x;
        this.y = y;
    }
    public abstract Shape createShape(int x, int y);
    public abstract void draw(Graphics g);
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public Color getColor(){
        return this.color;
    }
}
