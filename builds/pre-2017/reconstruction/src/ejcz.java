/*
 * Decompiled with CFR 0.152.
 */
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Icon;

public class ejcz
extends TextureAtlasSprite {
    public static final Icon _a = new ejcz("full")._a(0.0f, 0.0f, 1.0f, 1.0f, false);

    public ejcz(String string) {
        super(string);
    }

    @Override
    public void initSprite(int n, int n2, int n3, int n4, boolean bl) {
        this.originX = n3;
        this.originY = n4;
        this.padded = bl;
        float f = (float)(0.01999999977648258 / (double)n);
        float f2 = (float)(0.01999999977648258 / (double)n2);
        this.minU = (float)n3 / (float)((double)n) + f;
        this.maxU = (float)(n3 + this.width) / (float)((double)n) - f;
        this.minV = (float)n4 / (float)n2 + f2;
        this.maxV = (float)(n4 + this.height) / (float)n2 - f2;
    }

    public ejcz _a(float f, float f2, float f3, float f4, boolean bl) {
        this.minU = f;
        this.minV = f2;
        this.maxU = f3;
        this.maxV = f4;
        this.padded = bl;
        return this;
    }

    @Override
    public void loadSprite(htyg htyg2) throws IOException {
        this.resetSprite();
        InputStream inputStream = htyg2._a();
        htxz htxz2 = (htxz)htyg2._a("animation");
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        this.height = bufferedImage.getHeight();
        this.width = bufferedImage.getWidth();
        int[] nArray = new int[this.height * this.width];
        bufferedImage.getRGB(0, 0, this.width, this.height, nArray, 0, this.width);
        for (int i = 0; i < nArray.length; ++i) {
            int n = nArray[i];
            int n2 = n >> 24 & 0xFF;
            int n3 = (int)((float)(n >> 16 & 0xFF) * ((float)n2 / 255.0f));
            int n4 = (int)((float)(n >> 8 & 0xFF) * ((float)n2 / 255.0f));
            int n5 = (int)((float)(n & 0xFF) * ((float)n2 / 255.0f));
            nArray[i] = (n2 & 0xFF) << 24 | (n3 & 0xFF) << 16 | (n4 & 0xFF) << 8 | n5 & 0xFF;
        }
        if (htxz2 == null) {
            if (this.height != this.width) {
                throw new RuntimeException("broken aspect ratio and not an animation");
            }
            this.textureData = nArray;
        }
    }
}

