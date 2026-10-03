/*
 * Decompiled with CFR 0.152.
 */
package me.nallar.jdds.internal.ddsutil;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class BIUtil {
    private BIUtil() {
    }

    public static BufferedImage convertImageToBufferedImage(Image image, int type2) {
        BufferedImage result2 = new BufferedImage(image.getWidth(null), image.getHeight(null), type2);
        Graphics2D g = result2.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return result2;
    }
}

