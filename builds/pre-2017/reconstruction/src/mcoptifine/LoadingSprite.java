/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.util.Arrays;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class LoadingSprite {
    public final TextureAtlasSprite sprite;
    public final int hashCode;
    public final int[] pixeldata;

    public LoadingSprite(TextureAtlasSprite textureAtlasSprite) {
        this.sprite = textureAtlasSprite;
        this.pixeldata = textureAtlasSprite.getTextureData();
        this.hashCode = Arrays.hashCode(this.pixeldata);
    }
}

