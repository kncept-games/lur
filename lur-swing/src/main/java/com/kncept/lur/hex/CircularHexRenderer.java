package com.kncept.lur.hex;

import com.kncept.lur.HexUtils2D;
import com.kncept.lur.IntegerLurCoord;
import com.kncept.lur.util.FloatPoint2D;

import java.awt.*;

public class CircularHexRenderer {

    private Color color = Color.gray;

    public void setColor(Color color) {
        this.color = color;
    }

    public void paint(
            Graphics g,
            Point origin,
            IntegerLurCoord lur,
            float radius
    ) {

        FloatPoint2D cellOrigin = HexUtils2D.calculateCentralOffset(lur, radius).negateY();
        g.setColor(color);
        g.fillOval(
                (int)(cellOrigin.x - radius + origin.x),
                (int)(cellOrigin.y - radius + origin.y),
                (int)(2 * radius),
                (int)(2 * radius)
        );
    }
}
