package net.maxters.epsgbox;


public class EPSG4326 implements EPSGBoundBoxBuilder {
    private static double toY(double scale, int y) {
        double n = Math.PI - (2.0 * Math.PI * y) / scale;
        return Math.atan(Math.sinh(n)) * 180 / Math.PI;
    }

    @Override
    public double[] getBoundBoxFor(int x, int y, int zoom) {
        double scale = Math.pow(2, zoom);
        double x1 = x / scale * 360 - 180;
        double x2 = (x + 1) / scale * 360 - 180;
        double y1 = toY(scale, y);
        double y2 = toY(scale, y + 1);
        return new double[]{x1, y1, x2, y2};
    }
}
