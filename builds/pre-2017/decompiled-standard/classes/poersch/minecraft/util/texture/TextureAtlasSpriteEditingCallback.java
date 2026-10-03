/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.texture;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import poersch.minecraft.util.texture.ITextureEditingCallback;

@SideOnly(value=Side.CLIENT)
public class TextureAtlasSpriteEditingCallback
extends dhji {
    protected final ITextureEditingCallback callback;

    public TextureAtlasSpriteEditingCallback(String string, ITextureEditingCallback iTextureEditingCallback) {
        super(string);
        this.callback = iTextureEditingCallback;
    }

    @Override
    public void func_130100_a(htyg htyg2) throws IOException {
        super.func_130100_a(htyg2);
        if (this.callback != null) {
            this.textureData = this.callback.onTextureEditing(this, this.textureData, this.field_130223_c, this.field_130224_d);
        }
    }
}

