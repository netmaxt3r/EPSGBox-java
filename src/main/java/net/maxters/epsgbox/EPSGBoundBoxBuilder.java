package net.maxters.epsgbox;

public interface EPSGBoundBoxBuilder {
    double[] getBoundBoxFor(int x, int y, int zoom);
}
