package org.game.Shapes;

import java.awt.*;

// TODO: THIS CLASS IS NOT FINISHED
public class Triangle extends Shape{
    public Triangle(int x, int y) {
        super(x, y);
    }

    @Override
    public Shape createShape(int x, int y) {
        return new Triangle(x,y);
    }

    @Override
    public void draw(Graphics g) {
        int cordsX[] = {getX() - 30,getX(),getX() + 30};
        int cordsY[] = {getY() - 30, getY(),getY() + 30};
        int n = 3;

        Polygon polygon = new Polygon(cordsX,cordsY,n);

        g.drawPolygon(polygon);
    }
}
