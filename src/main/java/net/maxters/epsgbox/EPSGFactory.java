package net.maxters.epsgbox;

import java.util.HashMap;
import java.util.Map;

public class EPSGFactory {
    private final static Map<String, EPSGBoundBoxBuilder> builders = new HashMap<>();

    static {
        builders.put("EPSG:900913", new EPSG900913());
        builders.put("EPSG:4326", new EPSG4326());
    }

    public static EPSGBoundBoxBuilder get(String spec) {
        if (builders.containsKey(spec)) return builders.get(spec);
        return null;
    }

    public static void addBuilder(String spec, EPSGBoundBoxBuilder builder) {
        builders.put(spec, builder);
    }

    public static void removeBuilder(String spec) {
        builders.remove(spec);
    }
}
