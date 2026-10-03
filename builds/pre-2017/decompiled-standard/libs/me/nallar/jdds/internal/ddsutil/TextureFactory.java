/*
 * Decompiled with CFR 0.152.
 */
package me.nallar.jdds.internal.ddsutil;

import java.awt.image.BufferedImage;
import me.nallar.jdds.internal.model.AbstractTextureMap;
import me.nallar.jdds.internal.model.MipMaps;
import me.nallar.jdds.internal.model.SingleTextureMap;
import me.nallar.jdds.internal.model.TextureMap;

public class TextureFactory {
    public static TextureMap createTextureMap(boolean generateMipMaps, BufferedImage sourceImage) {
        AbstractTextureMap maps;
        if (generateMipMaps) {
            maps = new MipMaps();
            maps.generateMipMaps(sourceImage);
        } else {
            maps = new SingleTextureMap(sourceImage);
        }
        return maps;
    }
}

