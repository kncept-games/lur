package com.kncept.lur;

import com.kncept.lur.example.HexRingPaint;
import com.kncept.lur.example.SimplePaint;
import com.kncept.lur.example.SimpleSelect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collections;

public class LurSwingExplorer {
    public static void main(String[] args) {
        new LurSwingExplorer();
    }

    JFrame frame;
    List<LurExample> examples;
    JList<LurExample> leftLift;
    JPanel currentPanel;
    LurExample currentExample = null;

    public LurSwingExplorer() {
        // set currentExample to an instance to just straight in
//       currentExample = new HexRingPaint();

        frame = new JFrame("Lur Explorer");//creating instance of JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if(currentExample == null) {
            currentPanel = new JPanel();
            currentPanel.add(new JLabel("" +
                    "Please choose a topic to explore from the left panel" +
                    ""), BorderLayout.CENTER);
        } else {
            currentPanel = currentExample.panel();
        }
        frame.getContentPane().add(currentPanel, BorderLayout.CENTER);        

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        frame.setSize(
                Math.min(screenSize.width, 800),
                Math.min(screenSize.height, 600)
        );

        int x = (int) ((screenSize.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);


        // add left scroll and right viewpane
        examples = examples();
        examples.add(0, null);
        examples.add(null);
        leftLift = new JList<>(examples.toArray(new LurExample[]{}));
        leftLift.setCellRenderer(new ListCellRenderer<LurExample>() {
            @Override
            public Component getListCellRendererComponent(JList<? extends LurExample> jList, LurExample value, int index, boolean selected, boolean focused) {
                if (value == null) return new JLabel(" ");
                JLabel label = new JLabel(value.name());
//                JLabel label = new JLabel(value == null ? "xxxx" : value.name());
                if (selected) label.setBackground(Color.lightGray);
                else label.setForeground(Color.white);
                if (focused) label.setForeground(Color.black);
                else label.setForeground(Color.gray);
                return label;
            }
        });
        leftLift.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        leftLift.addListSelectionListener(listSelectionEvent -> {
            if (listSelectionEvent.getValueIsAdjusting()) return;
            int index = leftLift.getSelectedIndex();
            if (index >= 0 && index < examples.size()) {
                LurExample example = examples.get(index);
//                System.out.println("index " + index + " " + (example == null? "null" : example.description()));
                if (example != null && example != currentExample) {
                    currentExample = example;
                    JPanel oldPanel = currentPanel;
                    currentPanel = example.panel();
                    if (oldPanel != null) {
                        frame.getContentPane().remove(oldPanel);
                    }
                    frame.getContentPane().add(currentPanel, BorderLayout.CENTER);
                    frame.revalidate();
//                    currentPanel.revalidate();
                }


            }
        });

        frame.getContentPane().add(leftLift, BorderLayout.WEST);

        frame.revalidate();
        frame.setVisible(true);
    }

    private static List<LurExample> examples() {
        return new ArrayList<>(Arrays.asList(
                new SimplePaint(),
                new HexRingPaint(),
                new SimpleSelect()
        ));
    }
}
