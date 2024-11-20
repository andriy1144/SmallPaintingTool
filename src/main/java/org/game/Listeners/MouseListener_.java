package org.game.Listeners;

import org.game.PaintingArea;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseListener_ implements MouseMotionListener, MouseListener {
    private PaintingArea paintingArea;

    public MouseListener_(PaintingArea paintingArea){
        this.paintingArea = paintingArea;
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        paintingArea.setDrawing(true);

        paintingArea.setCursorX(e.getX());
        paintingArea.setCursorY(e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        paintingArea.setCursorX(e.getX());
        paintingArea.setCursorY(e.getY());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        paintingArea.setDrawing(true);
        paintingArea.setCursorX(e.getX());
        paintingArea.setCursorY(e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
