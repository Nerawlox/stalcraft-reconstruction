/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.texture;

import java.awt.image.BufferedImage;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public interface ITextureLoadingCallback {
    public BufferedImage onTextureLoading(TextureAtlasSprite var1, BufferedImage var2);
}

