package com.kncept.lur.hex;

import com.kncept.lur.HexUtils2D;
import com.kncept.lur.IntegerLurCoord;
import com.kncept.lur.util.FloatPoint2D;

import java.awt.*;

public class CircularHexRenderer {

    public void paint(
            Graphics g,
            Point origin,
            IntegerLurCoord lur,
            float radius
    ) {

        FloatPoint2D cellOrigin = HexUtils2D.calculateCentralOffset(lur);
        g.setColor(Color.gray);
        g.fillOval(
                (int)(cellOrigin.x - radius + origin.x),
                (int)(cellOrigin.y - radius + origin.y),
                (int)(2 * radius),
                (int)(2 * radius)
        );

        System.out.println(lur + "->" + cellOrigin.x + "," + cellOrigin.y);
        System.out.println("off " + origin.x + "," + origin.y + " rad" + radius);
    }
}
