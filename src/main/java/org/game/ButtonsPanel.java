 package org.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsPanel extends JPanel implements ActionListener {
    private PaintingArea paintingArea;

    private JButton clearButton,chooseColorButton,customiseButton;

    public ButtonsPanel(PaintingArea paintingArea){
        this.paintingArea = paintingArea;

        FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
        setLayout(layout);

        createButtons();
    }

    private JButton createButton(String name){
        JButton btn = new JButton(name);
        btn.addActionListener(this);
        btn.setBackground(Color.WHITE);
        return btn;
    }

    private void createButtons(){
        clearButton = createButton("Clear canvas!");
        add(clearButton);

        chooseColorButton = createButton("Choose color!");
        add(chooseColorButton);

        customiseButton = createButton("Customise!");
        add(customiseButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();

        switch(event){
            case "Clear canvas!" ->{
                paintingArea.clearCanvas();
            }
            case "Choose color!" ->{
                Color choosedColor =JColorChooser.showDialog(this,"Choose color!",paintingArea.getColor());
                if(choosedColor != null){
                    System.out.println("Choosed color: " + choosedColor);
                    paintingArea.setColor(choosedColor);
                }
            }
            case "Customise!" ->{
                new CustomistingWindow(paintingArea);
            }
        }
    }
}
