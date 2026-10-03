/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.nio.ByteBuffer;
import java.util.Properties;
import mcoptifine.Config;
import mcoptifine.CustomAnimationFrame;
import org.lwjgl.opengl.GL11;

public class TextureAnimation {
    private String srcTex = null;
    private String dstTex = null;
    private int dstTextId = -1;
    private int dstX = 0;
    private int dstY = 0;
    private int frameWidth = 0;
    private int frameHeight = 0;
    private CustomAnimationFrame[] frames = null;
    private int activeFrame = 0;
    private ByteBuffer imageData = null;

    public TextureAnimation(String string, byte[] byArray, String string2, int n, int n2, int n3, int n4, int n5, Properties properties, int n6) {
        this.srcTex = string;
        this.dstTex = string2;
        this.dstTextId = n;
        this.dstX = n2;
        this.dstY = n3;
        this.frameWidth = n4;
        this.frameHeight = n5;
        int n7 = n4 * n5 * 4;
        if (byArray.length % n7 != 0) {
            Config.warn("Invalid animated texture length: " + byArray.length + ", frameWidth: " + n5 + ", frameHeight: " + n5);
        }
        this.imageData = pklh._c(byArray.length);
        this.imageData.put(byArray);
        int n8 = byArray.length / n7;
        if (properties.get("tile.0") != null) {
            int n9 = 0;
            while (properties.get("tile." + n9) != null) {
                n8 = n9 + 1;
                ++n9;
            }
        }
        String string3 = (String)properties.get("duration");
        int n10 = Config.parseInt(string3, n6);
        this.frames = new CustomAnimationFrame[n8];
        for (int i = 0; i < this.frames.length; ++i) {
            CustomAnimationFrame customAnimationFrame;
            String string4 = (String)properties.get("tile." + i);
            int n11 = Config.parseInt(string4, i);
            String string5 = (String)properties.get("duration." + i);
            int n12 = Config.parseInt(string5, n10);
            this.frames[i] = customAnimationFrame = new CustomAnimationFrame(n11, n12);
        }
    }

    public boolean nextFrame() {
        if (this.frames.length <= 0) {
            return false;
        }
        if (this.activeFrame >= this.frames.length) {
            this.activeFrame = 0;
        }
        CustomAnimationFrame customAnimationFrame = this.frames[this.activeFrame];
        ++customAnimationFrame.counter;
        if (customAnimationFrame.counter < customAnimationFrame.duration) {
            return false;
        }
        customAnimationFrame.counter = 0;
        ++this.activeFrame;
        if (this.activeFrame >= this.frames.length) {
            this.activeFrame = 0;
        }
        return true;
    }

    public int getActiveFrameIndex() {
        if (this.frames.length <= 0) {
            return 0;
        }
        if (this.activeFrame >= this.frames.length) {
            this.activeFrame = 0;
        }
        CustomAnimationFrame customAnimationFrame = this.frames[this.activeFrame];
        return customAnimationFrame.index;
    }

    public int getFrameCount() {
        return this.frames.length;
    }

    public boolean updateTexture() {
        if (!this.nextFrame()) {
            return false;
        }
        int n = this.frameWidth * this.frameHeight * 4;
        int n2 = this.getActiveFrameIndex();
        int n3 = n * n2;
        if (n3 + n > this.imageData.capacity()) {
            return false;
        }
        this.imageData.position(n3);
        bsfn._a(this.dstTextId);
        GL11.glTexSubImage2D(3553, 0, this.dstX, this.dstY, this.frameWidth, this.frameHeight, 6408, 5121, this.imageData);
        return true;
    }
}

