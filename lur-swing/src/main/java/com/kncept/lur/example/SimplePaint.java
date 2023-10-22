package com.kncept.lur.example;

import com.kncept.lur.IntegerLurCoord;
import com.kncept.lur.LurExample;
import com.kncept.lur.hex.SimpleHexRenderer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SimplePaint implements LurExample {


    @Override
    public String name() {
        return "Simple Paint";
    }

    @Override
    public String description() {
        return "Simple example for drawing LUR as a circle or variable radius";
    }

    @Override
    public JPanel panel() {
        JPanel panel = new JPanel();

        List<IntegerLurCoord> coords = new ArrayList<>();
        coords.add(new IntegerLurCoord(0, 0, 0));
        coords.add(new IntegerLurCoord(1, 0, 0));
        coords.add(new IntegerLurCoord(2, 0, 0));
        coords.add(new IntegerLurCoord(0, 1, 0));
        coords.add(new IntegerLurCoord(0, 0, 1));

        SimpleHexRenderer renderer = new SimpleHexRenderer();
        renderer.setCells(coords);
        renderer.setRadius(30);

        panel.setLayout(new BorderLayout());
        panel.add(renderer, BorderLayout.CENTER);
        return panel;
    }
}
