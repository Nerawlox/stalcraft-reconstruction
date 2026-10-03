/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.util.handler;

import java.util.HashMap;
import java.util.Map;

public class DyeColorHandler {
    public static final byte NO_COLOR = 0;
    public static Map colorMap;

    public static void init() {
        colorMap = new HashMap();
        colorMap.put(0, new float[]{1.0f, 1.0f, 1.0f});
        colorMap.put(1, new float[]{1.0f, 0.59765625f, 0.328125f});
        colorMap.put(2, new float[]{0.785f, 0.39828125f, 0.8201563f});
        colorMap.put(3, new float[]{0.47859374f, 0.623125f, 0.91609377f});
        colorMap.put(4, new float[]{0.80859375f, 0.7578125f, 0.19140625f});
        colorMap.put(5, new float[]{0.37421876f, 0.81171876f, 0.32734376f});
        colorMap.put(6, new float[]{1.0f, 0.6171875f, 0.7265625f});
        colorMap.put(7, new float[]{0.2890625f, 0.2890625f, 0.2890625f});
        colorMap.put(8, new float[]{0.703125f, 0.71875f, 0.71875f});
        colorMap.put(9, new float[]{0.2109375f, 0.5f, 0.6171875f});
        colorMap.put(10, new float[]{0.56640625f, 0.3203125f, 0.7734375f});
        colorMap.put(11, new float[]{0.2109375f, 0.25f, 0.640625f});
        colorMap.put(12, new float[]{0.359375f, 0.2265625f, 0.140625f});
        colorMap.put(13, new float[]{0.23828125f, 0.3203125f, 0.125f});
        colorMap.put(14, new float[]{0.6796875f, 0.2421875f, 0.21875f});
        colorMap.put(15, new float[]{0.140625f, 0.125f, 0.125f});
    }

    public static float[] getDyeColorRGB(int n) {
        return (float[])colorMap.get(n);
    }
}

