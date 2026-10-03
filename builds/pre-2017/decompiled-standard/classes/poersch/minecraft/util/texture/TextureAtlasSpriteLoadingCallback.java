/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.texture;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import net.minecraft.util.ResourceLocation;
import poersch.minecraft.util.texture.ITextureLoadingCallback;

@SideOnly(value=Side.CLIENT)
public class TextureAtlasSpriteLoadingCallback
extends dhji {
    protected final String sourceName;
    protected final ITextureLoadingCallback callback;

    public TextureAtlasSpriteLoadingCallback(String string, String string2, ITextureLoadingCallback iTextureLoadingCallback) {
        super(string);
        this.sourceName = string2;
        this.callback = iTextureLoadingCallback;
    }

    @Override
    public boolean load(xsfs xsfs2, ResourceLocation resourceLocation) throws IOException {
        this.func_130100_a(xsfs2._a(new ResourceLocation(this.sourceName)));
        return true;
    }

    @Override
    protected BufferedImage getSourceImage(htyg htyg2) throws IOException {
        InputStream inputStream = htyg2._a();
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        if (this.callback != null) {
            bufferedImage = this.callback.onTextureLoading(this, bufferedImage);
        }
        return bufferedImage;
    }
}

