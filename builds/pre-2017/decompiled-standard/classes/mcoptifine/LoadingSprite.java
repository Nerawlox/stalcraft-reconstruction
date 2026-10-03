/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.util.Arrays;

public class LoadingSprite {
    public final dhji sprite;
    public final int hashCode;
    public final int[] pixeldata;

    public LoadingSprite(dhji dhji2) {
        this.sprite = dhji2;
        this.pixeldata = dhji2.getTextureData();
        this.hashCode = Arrays.hashCode(this.pixeldata);
    }
}

