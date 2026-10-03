/*
 * Decompiled with CFR 0.152.
 */
package me.nallar.jdds.internal.ddsutil;

import java.awt.Image;
import java.awt.image.BufferedImage;
import me.nallar.jdds.internal.ddsutil.BIUtil;
import me.nallar.jdds.internal.ddsutil.Rescaler;

public class ImageRescaler
extends Rescaler {
    private final int scaleAlgorithm;

    public ImageRescaler() {
        this.scaleAlgorithm = 4;
    }

    @Override
    public BufferedImage rescaleBI(BufferedImage originalImage, int newWidth, int newHeight) {
        Image rescaledImage = originalImage.getScaledInstance(newWidth, newHeight, this.scaleAlgorithm);
        BufferedImage bi = rescaledImage instanceof BufferedImage ? (BufferedImage)rescaledImage : BIUtil.convertImageToBufferedImage(rescaledImage, 6);
        return bi;
    }
}

