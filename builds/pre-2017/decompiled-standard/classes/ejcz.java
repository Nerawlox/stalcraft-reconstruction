/*
 * Decompiled with CFR 0.152.
 */
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import net.minecraft.util.dwan;

public class ejcz
extends dhji {
    public static final dwan _a = new ejcz("full")._a(0.0f, 0.0f, 1.0f, 1.0f, false);

    public ejcz(String string) {
        super(string);
    }

    @Override
    public void func_110971_a(int n, int n2, int n3, int n4, boolean bl) {
        this.field_110975_c = n3;
        this.field_110974_d = n4;
        this.padded = bl;
        float f = (float)(0.01999999977648258 / (double)n);
        float f2 = (float)(0.01999999977648258 / (double)n2);
        this.field_110979_l = (float)n3 / (float)((double)n) + f;
        this.field_110980_m = (float)(n3 + this.field_130223_c) / (float)((double)n) - f;
        this.field_110977_n = (float)n4 / (float)n2 + f2;
        this.field_110978_o = (float)(n4 + this.field_130224_d) / (float)n2 - f2;
    }

    public ejcz _a(float f, float f2, float f3, float f4, boolean bl) {
        this.field_110979_l = f;
        this.field_110977_n = f2;
        this.field_110980_m = f3;
        this.field_110978_o = f4;
        this.padded = bl;
        return this;
    }

    @Override
    public void func_130100_a(htyg htyg2) throws IOException {
        this.func_130102_n();
        InputStream inputStream = htyg2._a();
        htxz htxz2 = (htxz)htyg2._a("animation");
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        this.field_130224_d = bufferedImage.getHeight();
        this.field_130223_c = bufferedImage.getWidth();
        int[] nArray = new int[this.field_130224_d * this.field_130223_c];
        bufferedImage.getRGB(0, 0, this.field_130223_c, this.field_130224_d, nArray, 0, this.field_130223_c);
        for (int i = 0; i < nArray.length; ++i) {
            int n = nArray[i];
            int n2 = n >> 24 & 0xFF;
            int n3 = (int)((float)(n >> 16 & 0xFF) * ((float)n2 / 255.0f));
            int n4 = (int)((float)(n >> 8 & 0xFF) * ((float)n2 / 255.0f));
            int n5 = (int)((float)(n & 0xFF) * ((float)n2 / 255.0f));
            nArray[i] = (n2 & 0xFF) << 24 | (n3 & 0xFF) << 16 | (n4 & 0xFF) << 8 | n5 & 0xFF;
        }
        if (htxz2 == null) {
            if (this.field_130224_d != this.field_130223_c) {
                throw new RuntimeException("broken aspect ratio and not an animation");
            }
            this.textureData = nArray;
        }
    }
}

