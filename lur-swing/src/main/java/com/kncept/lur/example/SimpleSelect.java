package com.kncept.lur.example;

import com.kncept.lur.IntegerLurCoord;
import com.kncept.lur.LurExample;
import com.kncept.lur.hex.SimpleHexRenderer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class SimpleSelect implements LurExample {


    @Override
    public String name() {
        return "Simple Select";
    }

    @Override
    public String description() {
        return "Simple example for drawing LUR as a circle or variable radius";
    }

    private IntegerLurCoord selected = null;
    @Override
    public JPanel panel() {
        JPanel panel = new JPanel();

        IntegerLurCoord origin = new IntegerLurCoord(0, 0, 0);
        List<IntegerLurCoord> coords = new ArrayList<>();
        coords.add(origin);
        for(int i = 1; i< 10; i++) { // 5
            coords.addAll(origin.hexMoveRing(i));
        }

        SimpleHexRenderer renderer = new SimpleHexRenderer();
        renderer.setCells(coords);
        renderer.setRadius(30);
        renderer.setRadius(10);
        renderer.setOnHexClicked(new Consumer<IntegerLurCoord>() {
            @Override
            public void accept(IntegerLurCoord coord) {
                if (selected == coord) selected = null;
                else selected = coord;
                renderer.setSelected(selected);
                renderer.repaint();
            }
        });

        panel.setLayout(new BorderLayout());
        panel.add(renderer, BorderLayout.CENTER);
        return panel;
    }
}
