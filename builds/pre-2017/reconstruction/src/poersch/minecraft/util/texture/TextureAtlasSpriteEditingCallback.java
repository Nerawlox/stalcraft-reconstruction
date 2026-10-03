/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.texture;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import poersch.minecraft.util.texture.ITextureEditingCallback;

@SideOnly(value=Side.CLIENT)
public class TextureAtlasSpriteEditingCallback
extends TextureAtlasSprite {
    protected final ITextureEditingCallback callback;

    public TextureAtlasSpriteEditingCallback(String string, ITextureEditingCallback iTextureEditingCallback) {
        super(string);
        this.callback = iTextureEditingCallback;
    }

    @Override
    public void loadSprite(htyg htyg2) throws IOException {
        super.loadSprite(htyg2);
        if (this.callback != null) {
            this.textureData = this.callback.onTextureEditing(this, this.textureData, this.width, this.height);
        }
    }
}

