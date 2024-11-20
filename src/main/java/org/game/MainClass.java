package org.game;

public class MainClass {
    public static void main(String[] args) {
        PaintingArea area = new PaintingArea();
        ButtonsPanel buttonsPanel = new ButtonsPanel(area);

        new Window(area,buttonsPanel);
    }
}
