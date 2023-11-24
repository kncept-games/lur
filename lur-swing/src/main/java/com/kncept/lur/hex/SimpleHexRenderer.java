package com.kncept.lur.hex;

import com.kncept.lur.HexUtils2D;
import com.kncept.lur.IntegerLurCoord;
import com.kncept.lur.point.IntegerPoint2D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.function.Consumer;

public class SimpleHexRenderer extends JPanel {

    private float radius;
    private Collection<IntegerLurCoord> cells;

    private IntegerLurCoord selected;
    private CircularHexRenderer renderer;

    private CircularHexRenderer selectedCellRenderer;

    private Consumer<IntegerLurCoord> onHexClicked = new Consumer<IntegerLurCoord>() {
        @Override
        public void accept(IntegerLurCoord coord) {
        }
    };

    public SimpleHexRenderer() {
        super();
        selectedCellRenderer = new CircularHexRenderer();
        selectedCellRenderer.setColor(Color.red);

        renderer = new CircularHexRenderer();

        radius = 10;
        cells = Collections.emptyList();

        setBackground(Color.lightGray);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Dimension size = getSize();
                Point origin = new Point(size.width / 2, size.height/2);
                IntegerLurCoord coord = HexUtils2D.calculateLurFromXY(new IntegerPoint2D(e.getX() - origin.x, origin.y - e.getY()), radius);
                onHexClicked.accept(coord);
            }
        });
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public void setCells(Collection<IntegerLurCoord> cells) {
        this.cells = cells;
    }

    public void setOnHexClicked(Consumer<IntegerLurCoord> onHexClicked) {
        this.onHexClicked = onHexClicked;
    }

    public void setSelected(IntegerLurCoord selected) {
        this.selected = selected;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Dimension size = getSize();
//        System.out.println("shr size is " + size.width + "," + size.height);
        Point origin = new Point(size.width / 2, size.height/2);

        Iterator<IntegerLurCoord> iterator = cells.iterator();
        while (iterator.hasNext()) {
            IntegerLurCoord cell = iterator.next();
            renderer.paint(g, origin, cell, radius);
        }

        if (selected != null)
            selectedCellRenderer.paint(g, origin, selected, radius);
    }
}
