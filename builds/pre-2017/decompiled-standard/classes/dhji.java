/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.IntBuffer;
import javax.imageio.ImageIO;
import mcoptifine.AnimatedTextures;
import mcoptifine.Mipmaps;
import mcoptifine.TextureUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwan;
import org.lwjgl.opengl.GL11;

public class dhji
implements dwan {
    public final String field_110984_i;
    public int[] textureData;
    public boolean padded;
    public int field_110975_c;
    public int field_110974_d;
    public int field_130223_c;
    public int field_130224_d;
    public float field_110979_l;
    public float field_110980_m;
    public float field_110977_n;
    public float field_110978_o;
    public float baseU;
    public float baseV;
    public int field_110983_h;
    public int indexInMap = -1;
    public boolean mipmapActive = false;
    public int animationSlotId = -1;
    public boolean animated;
    public htxz field_110982_k;
    public int resourcePackResolution = 256;
    public float cellSize = 1.5f;
    public int spriteWidth;
    public int spriteHeight;
    public int borderX;
    public int borderY;

    public dhji(String string) {
        this.field_110984_i = string;
    }

    public void func_110971_a(int n, int n2, int n3, int n4, boolean bl) {
        this.field_110975_c = n3;
        this.field_110974_d = n4;
        this.padded = bl;
        float f = (float)((double)0.01f / (double)n);
        float f2 = (float)((double)0.01f / (double)n2);
        this.field_110979_l = (float)n3 / (float)((double)n) + f;
        this.field_110980_m = (float)(n3 + this.field_130223_c) / (float)((double)n) - f;
        this.field_110977_n = (float)n4 / (float)n2 + f2;
        this.field_110978_o = (float)(n4 + this.field_130224_d) / (float)n2 - f2;
        if (bl && (double)this.borderX > 0.0 && (double)this.borderY > 0.0) {
            this.field_110979_l = (float)((double)this.field_110979_l + (double)this.borderX / (double)n);
            this.field_110980_m = (float)((double)this.field_110980_m - (double)this.borderX / (double)n);
            this.field_110977_n = (float)((double)this.field_110977_n + (double)this.borderY / (double)n2);
            this.field_110978_o = (float)((double)this.field_110978_o - (double)this.borderY / (double)n2);
        }
        this.baseU = Math.min(this.field_110979_l, this.field_110980_m);
        this.baseV = Math.min(this.field_110977_n, this.field_110978_o);
    }

    public void func_94217_a(dhji dhji2) {
        this.field_110975_c = dhji2.field_110975_c;
        this.field_110974_d = dhji2.field_110974_d;
        this.field_130223_c = dhji2.field_130223_c;
        this.field_130224_d = dhji2.field_130224_d;
        this.padded = dhji2.padded;
        this.field_110979_l = dhji2.field_110979_l;
        this.field_110980_m = dhji2.field_110980_m;
        this.field_110977_n = dhji2.field_110977_n;
        this.field_110978_o = dhji2.field_110978_o;
        this.baseU = Math.min(this.field_110979_l, this.field_110980_m);
        this.baseV = Math.min(this.field_110977_n, this.field_110978_o);
    }

    public int func_130010_a() {
        return this.field_110975_c;
    }

    public int func_110967_i() {
        return this.field_110974_d;
    }

    @Override
    public int func_94211_a() {
        return this.field_130223_c;
    }

    @Override
    public int func_94216_b() {
        return this.field_130224_d;
    }

    @Override
    public float func_94209_e() {
        return this.field_110979_l;
    }

    @Override
    public float func_94212_f() {
        return this.field_110980_m;
    }

    @Override
    public float func_94214_a(double d) {
        float f;
        if (this.animated) {
            f = this.field_110980_m - this.field_110979_l;
        }
        f = this.field_110980_m - this.field_110979_l;
        return this.field_110979_l + f * (float)d / 16.0f;
    }

    @Override
    public float func_94206_g() {
        return this.field_110977_n;
    }

    @Override
    public float func_94210_h() {
        return this.field_110978_o;
    }

    @Override
    public float func_94207_b(double d) {
        float f;
        if (this.animated) {
            f = this.field_110978_o - this.field_110977_n;
        }
        f = this.field_110978_o - this.field_110977_n;
        return this.field_110977_n + f * ((float)d / 16.0f);
    }

    @Override
    public String func_94215_i() {
        return this.field_110984_i;
    }

    public int[] getTextureData() {
        return this.textureData;
    }

    public void setTextureData(int[] nArray) {
        this.textureData = nArray;
    }

    public void func_110966_b(int n) {
        this.field_130223_c = n;
    }

    public void func_110969_c(int n) {
        this.field_130224_d = n;
    }

    public boolean copyRegion(int[] nArray, int[] nArray2, int n, int n2, int n3, int n4, int n5, int n6) {
        boolean bl = false;
        for (int i = n2; i < n2 + n4; ++i) {
            for (int j = n; j < n + n3; ++j) {
                int n7 = i * this.spriteWidth + j;
                int n8 = j - n;
                int n9 = i - n2;
                int n10 = (n6 + n9) * this.field_130223_c + n5 + n8;
                nArray2[n10] = nArray[n7];
                if (i != n2 && j != n && i != n2 + n4 - 1 && j != n + n3 - 1) continue;
                bl |= (nArray[n7] >> 24 & 0xFF) == 0;
            }
        }
        return bl;
    }

    public void repeatImage(int[] nArray, int[] nArray2, boolean bl) {
        int n = this.spriteWidth;
        int n2 = this.spriteHeight;
        boolean bl2 = this.copyRegion(nArray, nArray2, 0, 0, n, n2, this.borderX, this.borderY);
        if (!bl2 || bl) {
            this.copyRegion(nArray, nArray2, 0, 0, n, this.borderY, this.borderX, this.field_130224_d - this.borderY);
            this.copyRegion(nArray, nArray2, 0, n2 - this.borderY, n, this.borderY, this.borderX, 0);
            this.copyRegion(nArray, nArray2, 0, 0, this.borderX, n2, this.field_130223_c - this.borderX, this.borderY);
            this.copyRegion(nArray, nArray2, n - this.borderX, 0, this.borderX, n2, 0, this.borderY);
            this.copyRegion(nArray, nArray2, 0, 0, this.borderX, this.borderY, this.field_130223_c - this.borderX, this.field_130224_d - this.borderY);
            this.copyRegion(nArray, nArray2, n - this.borderX, 0, this.borderX, this.borderY, 0, this.field_130224_d - this.borderY);
            this.copyRegion(nArray, nArray2, 0, n2 - this.borderY, this.borderX, this.borderY, this.field_130223_c - this.borderX, 0);
            this.copyRegion(nArray, nArray2, n - this.borderX, n2 - this.borderY, this.borderX, this.borderY, 0, 0);
        }
    }

    public int[] reformatSpriteToPaddedAtlas(int[] nArray, boolean bl) {
        if (bl) {
            while (this.field_130223_c > this.resourcePackResolution) {
                this.fixTransparentColor(nArray);
                nArray = Mipmaps.generateMipMapData(nArray, this.field_130223_c, this.field_130224_d, new Dimension[]{new Dimension(this.field_130223_c / 2, this.field_130224_d / 2)})[0];
                this.field_130223_c /= 2;
                this.field_130224_d /= 2;
            }
        }
        this.spriteWidth = this.field_130223_c;
        this.spriteHeight = this.field_130224_d;
        this.field_130223_c = (int)((float)this.field_130223_c * this.cellSize);
        this.field_130224_d = (int)((float)this.field_130224_d * this.cellSize);
        this.borderX = this.borderY = (this.field_130223_c - this.spriteWidth) / 2;
        int[] nArray2 = new int[this.field_130223_c * this.field_130224_d];
        this.repeatImage(nArray, nArray2, false);
        nArray = nArray2;
        this.fixTransparentColor(nArray);
        return nArray;
    }

    public boolean load(xsfs xsfs2, ResourceLocation resourceLocation) throws IOException {
        htyg htyg2 = xsfs2._a(resourceLocation);
        this.func_130100_a(htyg2);
        return true;
    }

    public BufferedImage getSourceImage(htyg htyg2) throws IOException {
        return ImageIO.read(htyg2._a());
    }

    public void func_130100_a(htyg htyg2) throws IOException {
        this.func_130102_n();
        boolean bl = this.animated = htyg2._a("animation") != null;
        if (this.animated) {
            this.field_110982_k = (htxz)htyg2._a("animation");
            this.animationSlotId = AnimatedTextures.getNextAnimationSlot();
        } else {
            BufferedImage bufferedImage = this.getSourceImage(htyg2);
            this.loadSpriteFromImage(bufferedImage);
        }
    }

    public void loadSpriteFromImage(BufferedImage bufferedImage) {
        this.field_130223_c = bufferedImage.getWidth();
        this.field_130224_d = bufferedImage.getHeight();
        int[] nArray = new int[this.field_130224_d * this.field_130223_c];
        bufferedImage.getRGB(0, 0, this.field_130223_c, this.field_130224_d, nArray, 0, this.field_130223_c);
        int[] nArray2 = this.reformatSpriteToPaddedAtlas(nArray, true);
        if (this.field_130224_d != this.field_130223_c) {
            throw new RuntimeException("broken aspect ratio and not an animation");
        }
        this.textureData = nArray2;
    }

    public void loadAnimatedSprite(xsfs xsfs2, ResourceLocation resourceLocation, int n, sctd sctd2) throws IOException {
        htyg htyg2 = xsfs2._a(resourceLocation);
        BufferedImage bufferedImage = this.getSourceImage(htyg2);
        this.field_130223_c = this.field_130224_d = bufferedImage.getWidth();
        this.spriteHeight = this.field_130224_d;
        this.spriteWidth = this.field_130224_d;
        int n2 = (int)((float)this.resourcePackResolution * this.cellSize);
        int n3 = (int)((float)this.resourcePackResolution * this.cellSize);
        this.field_110975_c = 0;
        this.field_110974_d = -sctd2._q + this.animationSlotId * n2;
        this.mipmapActive = true;
        for (int i = 0; i < n; ++i) {
            this.field_130223_c = this.field_130224_d = bufferedImage.getWidth();
            BufferedImage bufferedImage2 = bufferedImage.getSubimage(0, i * this.field_130223_c, this.field_130223_c, this.field_130223_c);
            int[] nArray = new int[this.field_130223_c * this.field_130223_c];
            bufferedImage2.getRGB(0, 0, this.field_130223_c, this.field_130223_c, nArray, 0, this.field_130223_c);
            this.textureData = this.reformatSpriteToPaddedAtlas(nArray, true);
            this.uploadFrameTexture(n3 * i, n2 * this.animationSlotId);
        }
        this.borderX = this.borderY = (this.field_130223_c - this.spriteWidth) / 2;
        this.func_110971_a(sctd2._p, sctd2._q, this.field_110975_c, this.field_110974_d, true);
        this.textureData = null;
    }

    public static int[] getTextureData(int[] nArray, int n, int n2, int n3) {
        int[] nArray2 = new int[n * n2];
        System.arraycopy(nArray, n3 * nArray2.length, nArray2, 0, nArray2.length);
        return nArray2;
    }

    public void func_130103_l() {
        this.textureData = null;
    }

    public boolean func_130098_m() {
        return this.field_110982_k != null;
    }

    public void func_130102_n() {
        this.field_110982_k = null;
        this.func_130103_l();
        this.field_110983_h = 0;
    }

    public String toString() {
        return "TextureAtlasSprite{name='" + this.field_110984_i + '\'' + ", animated=" + this.animated + ", padded=" + this.padded + ", x=" + this.field_110975_c + ", y=" + this.field_110974_d + ", height=" + this.field_130224_d + ", width=" + this.field_130223_c + ", u0=" + this.field_110979_l + ", u1=" + this.field_110980_m + ", v0=" + this.field_110977_n + ", v1=" + this.field_110978_o + '}';
    }

    public int getWidth() {
        return this.field_130223_c;
    }

    public int getHeight() {
        return this.field_130224_d;
    }

    public int getIndexInMap() {
        return this.indexInMap;
    }

    public void setIndexInMap(int n) {
        this.indexInMap = n;
    }

    public void setMipmapActive(boolean bl) {
        this.mipmapActive = bl;
    }

    public void uploadFrameTexture() {
        this.uploadFrameTexture(this.field_110975_c, this.field_110974_d);
    }

    public void uploadFrameTexture(int n, int n2) {
        IntBuffer intBuffer = TextureUtils.getStaticBufferNpot(this.field_130223_c, this.field_130224_d);
        intBuffer.clear();
        intBuffer.put(this.textureData);
        intBuffer.clear();
        GL11.glTexSubImage2D(3553, 0, n, n2, this.field_130223_c, this.field_130224_d, 32993, 33639, intBuffer);
        if (this.mipmapActive) {
            new Mipmaps(this.field_110984_i, this.field_130223_c, this.field_130224_d, this.textureData, false).uploadMipmaps(n, n2);
        }
    }

    public void fixTransparentColor(int[] nArray) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        long l = 0L;
        long l2 = 0L;
        long l3 = 0L;
        long l4 = 0L;
        for (n6 = 0; n6 < nArray.length; ++n6) {
            n5 = nArray[n6];
            n4 = n5 >> 24 & 0xFF;
            if (n4 == 0) continue;
            n3 = n5 >> 16 & 0xFF;
            n2 = n5 >> 8 & 0xFF;
            n = n5 & 0xFF;
            l += (long)n3;
            l2 += (long)n2;
            l3 += (long)n;
            ++l4;
        }
        if (l4 > 0L) {
            n6 = (int)(l / l4);
            n5 = (int)(l2 / l4);
            n4 = (int)(l3 / l4);
            for (n3 = 0; n3 < nArray.length; ++n3) {
                n2 = nArray[n3];
                n = n2 >> 24 & 0xFF;
                if (n != 0) continue;
                nArray[n3] = n6 << 16 | n5 << 8 | n4;
            }
        }
    }
}

