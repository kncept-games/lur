package com.kncept.lur;

import com.kncept.lur.point.FloatPoint2D;
import com.kncept.lur.point.IntegerPoint2D;

/**
 * This assumes that the LUR(0,0,0) Hex lies at (0,0) on the 2D Plain.
 *
 *    /---\
 *   /     \
 *   \     /
 *    \---/
 */
public class HexUtils2D {

    private static final float rootThree = (float)(Math.sqrt(3d));

    public static FloatPoint2D calculateCentralOffset(
        IntegerLurCoord lur,
        float radius
    ) {
        float x = (lur.getR() - lur.getL()) * rootThree * radius;
        float y = (lur.getU() * 2 * radius) - ((lur.getL() + lur.getR()) * radius);
        return new FloatPoint2D(x, y);
    }

    public static IntegerLurCoord calculateLurFromXY(IntegerPoint2D point, float radius) {
        float xWithRadius = point.x >= 0 ? point.x + radius : point.x - radius;
        float yWithRadius = point.y >= 0 ? point.y + radius : point.y - radius;
        int radiiRight = (int) (xWithRadius / (rootThree * radius));
        int radiiUp = (int)(yWithRadius / radius);
        radiiUp /= 2;
        radiiUp += (radiiRight/2);

        IntegerLurCoord from = new IntegerLurCoord(0, radiiUp, radiiRight).minimise();
        return meanderTo(from, point, radius);
    }

    /*
    Inefficient, but will always walk to correct coordinates.
    Best used when the eventual solution is 0 or 1 steps from the input point
     */
    public static IntegerLurCoord meanderTo(IntegerLurCoord from, IntegerPoint2D to, float radius) {
        int distanceSq = to.distanceSq(calculateCentralOffset(from, radius).toClosestDiscretePoint());

        // seed initial walk directions with all possible directions
        IntegerLurCoordDirection[] walkDirections = IntegerLurCoordDirection.values();
        while (walkDirections != null) {
            IntegerLurCoordDirection[] consideredWalkDirections = walkDirections;
            walkDirections = null;
            IntegerLurCoord[] possibleFrom = new IntegerLurCoord[consideredWalkDirections.length];
            for(int i = 0; i < consideredWalkDirections.length; i++) {
                possibleFrom[i] = from.add(consideredWalkDirections[i].getDirection());
            }
            for(int i = 0; i < consideredWalkDirections.length; i++) {
                int directionDistSq = to.distanceSq(calculateCentralOffset(possibleFrom[i], radius).toClosestDiscretePoint());
                if (directionDistSq < distanceSq) {
                    walkDirections = directionOrOneRotation(consideredWalkDirections[i]);
                    distanceSq = directionDistSq;
                    from = possibleFrom[i];
                }
            }
        }
        return from.minimise();
    }

    private static IntegerLurCoordDirection[] directionOrOneRotation(IntegerLurCoordDirection direction) {
        return new IntegerLurCoordDirection[]{
                direction.anticlockwise(),
                direction,
                direction.clockwise()
        };
    }
}
