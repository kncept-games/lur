package com.kncept.lur.hex;

import com.kncept.lur.IntegerLurCoord;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.Iterator;

public class SimpleHexRenderer extends JPanel {

    public SimpleHexRenderer() {
        super();
        setBackground(Color.lightGray);
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        setPreferredSize(screenSize);
    }

    private float radius = 10;
    private Collection<IntegerLurCoord> cells;
    private CircularHexRenderer renderer = new CircularHexRenderer();
    public void setRadius(float radius) {
        this.radius = radius;
    }

    public void setCells(Collection<IntegerLurCoord> cells) {
        this.cells = cells;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Dimension size = getSize();
        System.out.println("shr size is " + size.width + "," + size.height);
        Point origin = new Point(size.width / 2, size.height/2);

        Iterator<IntegerLurCoord> iterator = cells.iterator();
        while (iterator.hasNext()) {
            IntegerLurCoord cell = iterator.next();
            renderer.paint(g, origin, cell, radius);
        }

    }
}
