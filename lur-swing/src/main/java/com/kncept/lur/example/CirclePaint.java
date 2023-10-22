package com.kncept.lur.example;

import com.kncept.lur.IntegerLurCoord;
import com.kncept.lur.LurExample;
import com.kncept.lur.hex.SimpleHexRenderer;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CirclePaint implements LurExample {


    @Override
    public String name() {
        return "Hex Circle Paint";
    }

    @Override
    public String description() {
        return "Paint a circular field of hexes ring";
    }

    @Override
    public JPanel panel() {
        JPanel panel = new JPanel();


        SimpleHexRenderer renderer = new SimpleHexRenderer();
        renderer.setCells(new IntegerLurCoord(0, 0, 0).hexesWithinRadius(3f));
        renderer.setRadius(determineHexRadiusFromHexRingRadius(renderer, 2));

        panel.setLayout(new BorderLayout());
        panel.add(renderer, BorderLayout.CENTER);

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 10);
        slider.setMajorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                if (slider.getValueIsAdjusting()) return;

                int radius = slider.getValue();
                renderer.setCells(new IntegerLurCoord(0, 0, 0).hexesWithinRadius(radius));
                renderer.setRadius(determineHexRadiusFromHexRingRadius(renderer, radius));
                renderer.repaint();
            }
        });
        panel.add(slider, BorderLayout.SOUTH);

        return panel;
    }
    private int determineHexRadiusFromHexRingRadius(SimpleHexRenderer renderer, int hexRingRadius) {
//        int size = Math.min(renderer.getHeight(), renderer.getWidth());
//        System.out.println("int " + size + " = Math.min(" + renderer.getHeight() + ", " + renderer.getWidth() + ");");
//        int resulting = (size - 50) / ((hexRingRadius + 1) * 2);
//        return resulting;
        return 250 / ((hexRingRadius + 1) * 2);
    }

}
