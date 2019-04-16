package net.maxters.epsgbox;

public class EPSG900913 implements EPSGBoundBoxBuilder {
    private static final double[] mapBound = {-20037508.34789244, 20037508.34789244};
    private static final double FULL = 20037508.34789244 * 2;

    @Override
    public double[] getBoundBoxFor(int x, int y, int zoom) {
        double tile = FULL / Math.pow(2, zoom);
        return new double[]{
                mapBound[0] + x * tile,
                mapBound[1] - (y + 1) * tile,
                mapBound[0] + (x + 1) * tile,
                mapBound[1] - y * tile
        };
    }
}
