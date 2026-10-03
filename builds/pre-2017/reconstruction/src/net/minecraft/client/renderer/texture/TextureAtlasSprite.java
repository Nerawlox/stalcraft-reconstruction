/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.texture;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.IntBuffer;
import javax.imageio.ImageIO;
import mcoptifine.AnimatedTextures;
import mcoptifine.Mipmaps;
import mcoptifine.TextureUtils;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TextureAtlasSprite
implements Icon {
    public final String iconName;
    public int[] textureData;
    public boolean padded;
    public int originX;
    public int originY;
    public int width;
    public int height;
    public float minU;
    public float maxU;
    public float minV;
    public float maxV;
    public float baseU;
    public float baseV;
    public int tickCounter;
    public int indexInMap = -1;
    public boolean mipmapActive = false;
    public int animationSlotId = -1;
    public boolean animated;
    public htxz animationMetadata;
    public int resourcePackResolution = 256;
    public float cellSize = 1.5f;
    public int spriteWidth;
    public int spriteHeight;
    public int borderX;
    public int borderY;

    public TextureAtlasSprite(String string) {
        this.iconName = string;
    }

    public void initSprite(int n, int n2, int n3, int n4, boolean bl) {
        this.originX = n3;
        this.originY = n4;
        this.padded = bl;
        float f = (float)((double)0.01f / (double)n);
        float f2 = (float)((double)0.01f / (double)n2);
        this.minU = (float)n3 / (float)((double)n) + f;
        this.maxU = (float)(n3 + this.width) / (float)((double)n) - f;
        this.minV = (float)n4 / (float)n2 + f2;
        this.maxV = (float)(n4 + this.height) / (float)n2 - f2;
        if (bl && (double)this.borderX > 0.0 && (double)this.borderY > 0.0) {
            this.minU = (float)((double)this.minU + (double)this.borderX / (double)n);
            this.maxU = (float)((double)this.maxU - (double)this.borderX / (double)n);
            this.minV = (float)((double)this.minV + (double)this.borderY / (double)n2);
            this.maxV = (float)((double)this.maxV - (double)this.borderY / (double)n2);
        }
        this.baseU = Math.min(this.minU, this.maxU);
        this.baseV = Math.min(this.minV, this.maxV);
    }

    public void copyFrom(TextureAtlasSprite textureAtlasSprite) {
        this.originX = textureAtlasSprite.originX;
        this.originY = textureAtlasSprite.originY;
        this.width = textureAtlasSprite.width;
        this.height = textureAtlasSprite.height;
        this.padded = textureAtlasSprite.padded;
        this.minU = textureAtlasSprite.minU;
        this.maxU = textureAtlasSprite.maxU;
        this.minV = textureAtlasSprite.minV;
        this.maxV = textureAtlasSprite.maxV;
        this.baseU = Math.min(this.minU, this.maxU);
        this.baseV = Math.min(this.minV, this.maxV);
    }

    public int getOriginX() {
        return this.originX;
    }

    public int getOriginY() {
        return this.originY;
    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    @Override
    public int getIconHeight() {
        return this.height;
    }

    @Override
    public float getMinU() {
        return this.minU;
    }

    @Override
    public float getMaxU() {
        return this.maxU;
    }

    @Override
    public float getInterpolatedU(double d) {
        float f;
        if (this.animated) {
            f = this.maxU - this.minU;
        }
        f = this.maxU - this.minU;
        return this.minU + f * (float)d / 16.0f;
    }

    @Override
    public float getMinV() {
        return this.minV;
    }

    @Override
    public float getMaxV() {
        return this.maxV;
    }

    @Override
    public float getInterpolatedV(double d) {
        float f;
        if (this.animated) {
            f = this.maxV - this.minV;
        }
        f = this.maxV - this.minV;
        return this.minV + f * ((float)d / 16.0f);
    }

    @Override
    public String getIconName() {
        return this.iconName;
    }

    public int[] getTextureData() {
        return this.textureData;
    }

    public void setTextureData(int[] nArray) {
        this.textureData = nArray;
    }

    public void setIconWidth(int n) {
        this.width = n;
    }

    public void setIconHeight(int n) {
        this.height = n;
    }

    public boolean copyRegion(int[] nArray, int[] nArray2, int n, int n2, int n3, int n4, int n5, int n6) {
        boolean bl = false;
        for (int i = n2; i < n2 + n4; ++i) {
            for (int j = n; j < n + n3; ++j) {
                int n7 = i * this.spriteWidth + j;
                int n8 = j - n;
                int n9 = i - n2;
                int n10 = (n6 + n9) * this.width + n5 + n8;
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
            this.copyRegion(nArray, nArray2, 0, 0, n, this.borderY, this.borderX, this.height - this.borderY);
            this.copyRegion(nArray, nArray2, 0, n2 - this.borderY, n, this.borderY, this.borderX, 0);
            this.copyRegion(nArray, nArray2, 0, 0, this.borderX, n2, this.width - this.borderX, this.borderY);
            this.copyRegion(nArray, nArray2, n - this.borderX, 0, this.borderX, n2, 0, this.borderY);
            this.copyRegion(nArray, nArray2, 0, 0, this.borderX, this.borderY, this.width - this.borderX, this.height - this.borderY);
            this.copyRegion(nArray, nArray2, n - this.borderX, 0, this.borderX, this.borderY, 0, this.height - this.borderY);
            this.copyRegion(nArray, nArray2, 0, n2 - this.borderY, this.borderX, this.borderY, this.width - this.borderX, 0);
            this.copyRegion(nArray, nArray2, n - this.borderX, n2 - this.borderY, this.borderX, this.borderY, 0, 0);
        }
    }

    public int[] reformatSpriteToPaddedAtlas(int[] nArray, boolean bl) {
        if (bl) {
            while (this.width > this.resourcePackResolution) {
                this.fixTransparentColor(nArray);
                nArray = Mipmaps.generateMipMapData(nArray, this.width, this.height, new Dimension[]{new Dimension(this.width / 2, this.height / 2)})[0];
                this.width /= 2;
                this.height /= 2;
            }
        }
        this.spriteWidth = this.width;
        this.spriteHeight = this.height;
        this.width = (int)((float)this.width * this.cellSize);
        this.height = (int)((float)this.height * this.cellSize);
        this.borderX = this.borderY = (this.width - this.spriteWidth) / 2;
        int[] nArray2 = new int[this.width * this.height];
        this.repeatImage(nArray, nArray2, false);
        nArray = nArray2;
        this.fixTransparentColor(nArray);
        return nArray;
    }

    public boolean load(ResourceManager resourceManager, ResourceLocation resourceLocation) throws IOException {
        htyg htyg2 = resourceManager._a(resourceLocation);
        this.loadSprite(htyg2);
        return true;
    }

    public BufferedImage getSourceImage(htyg htyg2) throws IOException {
        return ImageIO.read(htyg2._a());
    }

    public void loadSprite(htyg htyg2) throws IOException {
        this.resetSprite();
        boolean bl = this.animated = htyg2._a("animation") != null;
        if (this.animated) {
            this.animationMetadata = (htxz)htyg2._a("animation");
            this.animationSlotId = AnimatedTextures.getNextAnimationSlot();
        } else {
            BufferedImage bufferedImage = this.getSourceImage(htyg2);
            this.loadSpriteFromImage(bufferedImage);
        }
    }

    public void loadSpriteFromImage(BufferedImage bufferedImage) {
        this.width = bufferedImage.getWidth();
        this.height = bufferedImage.getHeight();
        int[] nArray = new int[this.height * this.width];
        bufferedImage.getRGB(0, 0, this.width, this.height, nArray, 0, this.width);
        int[] nArray2 = this.reformatSpriteToPaddedAtlas(nArray, true);
        if (this.height != this.width) {
            throw new RuntimeException("broken aspect ratio and not an animation");
        }
        this.textureData = nArray2;
    }

    public void loadAnimatedSprite(ResourceManager resourceManager, ResourceLocation resourceLocation, int n, sctd sctd2) throws IOException {
        htyg htyg2 = resourceManager._a(resourceLocation);
        BufferedImage bufferedImage = this.getSourceImage(htyg2);
        this.width = this.height = bufferedImage.getWidth();
        this.spriteHeight = this.height;
        this.spriteWidth = this.height;
        int n2 = (int)((float)this.resourcePackResolution * this.cellSize);
        int n3 = (int)((float)this.resourcePackResolution * this.cellSize);
        this.originX = 0;
        this.originY = -sctd2._q + this.animationSlotId * n2;
        this.mipmapActive = true;
        for (int i = 0; i < n; ++i) {
            this.width = this.height = bufferedImage.getWidth();
            BufferedImage bufferedImage2 = bufferedImage.getSubimage(0, i * this.width, this.width, this.width);
            int[] nArray = new int[this.width * this.width];
            bufferedImage2.getRGB(0, 0, this.width, this.width, nArray, 0, this.width);
            this.textureData = this.reformatSpriteToPaddedAtlas(nArray, true);
            this.uploadFrameTexture(n3 * i, n2 * this.animationSlotId);
        }
        this.borderX = this.borderY = (this.width - this.spriteWidth) / 2;
        this.initSprite(sctd2._p, sctd2._q, this.originX, this.originY, true);
        this.textureData = null;
    }

    public static int[] getTextureData(int[] nArray, int n, int n2, int n3) {
        int[] nArray2 = new int[n * n2];
        System.arraycopy(nArray, n3 * nArray2.length, nArray2, 0, nArray2.length);
        return nArray2;
    }

    public void clearFramesTextureData() {
        this.textureData = null;
    }

    public boolean hasAnimationMetadata() {
        return this.animationMetadata != null;
    }

    public void resetSprite() {
        this.animationMetadata = null;
        this.clearFramesTextureData();
        this.tickCounter = 0;
    }

    public String toString() {
        return "TextureAtlasSprite{name='" + this.iconName + '\'' + ", animated=" + this.animated + ", padded=" + this.padded + ", x=" + this.originX + ", y=" + this.originY + ", height=" + this.height + ", width=" + this.width + ", u0=" + this.minU + ", u1=" + this.maxU + ", v0=" + this.minV + ", v1=" + this.maxV + '}';
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
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
        this.uploadFrameTexture(this.originX, this.originY);
    }

    public void uploadFrameTexture(int n, int n2) {
        IntBuffer intBuffer = TextureUtils.getStaticBufferNpot(this.width, this.height);
        intBuffer.clear();
        intBuffer.put(this.textureData);
        intBuffer.clear();
        GL11.glTexSubImage2D(3553, 0, n, n2, this.width, this.height, 32993, 33639, intBuffer);
        if (this.mipmapActive) {
            new Mipmaps(this.iconName, this.width, this.height, this.textureData, false).uploadMipmaps(n, n2);
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

