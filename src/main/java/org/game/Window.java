package org.game;

import javax.swing.*;
import java.awt.*;

public class Window {
    private JFrame frame;
    public Window(JPanel panel,ButtonsPanel buttonsPanel){
        frame = new JFrame();

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }catch (Exception e){
            e.printStackTrace();
        }

        frame.setSize(1280,720);
        frame.setTitle("Sketch Book");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        frame.setLayout(new BorderLayout());

        frame.add(buttonsPanel,BorderLayout.SOUTH);

        frame.add(panel,BorderLayout.NORTH);

        panel.requestFocus();

        frame.setVisible(true);
    }
}
