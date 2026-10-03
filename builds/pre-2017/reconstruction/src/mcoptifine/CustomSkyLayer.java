/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.util.Properties;
import mcoptifine.Config;
import mcoptifine.TextureUtils;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;

public class CustomSkyLayer {
    public String source = null;
    private int startFadeIn = -1;
    private int endFadeIn = -1;
    private int startFadeOut = -1;
    private int endFadeOut = -1;
    private int blend = 0;
    private boolean rotate = false;
    private float speed = 1.0f;
    private float[] axis = DEFAULT_AXIS;
    public int textureId = -1;
    public static final int BLEND_ADD = 0;
    public static final int BLEND_SUBSTRACT = 1;
    public static final int BLEND_MULTIPLY = 2;
    public static final int BLEND_DODGE = 3;
    public static final int BLEND_BURN = 4;
    public static final int BLEND_SCREEN = 5;
    public static final int BLEND_REPLACE = 6;
    public static final float[] DEFAULT_AXIS = new float[]{1.0f, 0.0f, 0.0f};

    public CustomSkyLayer(Properties properties, String string) {
        this.source = properties.getProperty("source", string);
        this.startFadeIn = this.parseTime(properties.getProperty("startFadeIn"));
        this.endFadeIn = this.parseTime(properties.getProperty("endFadeIn"));
        this.startFadeOut = this.parseTime(properties.getProperty("startFadeOut"));
        this.endFadeOut = this.parseTime(properties.getProperty("endFadeOut"));
        this.blend = this.parseBlend(properties.getProperty("blend"));
        this.rotate = this.parseBoolean(properties.getProperty("rotate"), true);
        this.speed = this.parseFloat(properties.getProperty("speed"), 1.0f);
        this.axis = this.parseAxis(properties.getProperty("axis"), DEFAULT_AXIS);
    }

    private int parseTime(String string) {
        if (string == null) {
            return -1;
        }
        String[] stringArray = Config.tokenize(string, ":");
        if (stringArray.length != 2) {
            Config.warn("Invalid time: " + string);
            return -1;
        }
        String string2 = stringArray[0];
        String string3 = stringArray[1];
        int n = Config.parseInt(string2, -1);
        int n2 = Config.parseInt(string3, -1);
        if (n >= 0 && n <= 23 && n2 >= 0 && n2 <= 59) {
            if ((n -= 6) < 0) {
                n += 24;
            }
            int n3 = n * 1000 + (int)((double)n2 / 60.0 * 1000.0);
            return n3;
        }
        Config.warn("Invalid time: " + string);
        return -1;
    }

    private int parseBlend(String string) {
        if (string == null) {
            return 0;
        }
        if (string.equals("add")) {
            return 0;
        }
        if (string.equals("subtract")) {
            return 1;
        }
        if (string.equals("multiply")) {
            return 2;
        }
        if (string.equals("dodge")) {
            return 3;
        }
        if (string.equals("burn")) {
            return 4;
        }
        if (string.equals("screen")) {
            return 5;
        }
        if (string.equals("replace")) {
            return 6;
        }
        Config.warn("Unknown blend: " + string);
        return 0;
    }

    private boolean parseBoolean(String string, boolean bl) {
        if (string == null) {
            return bl;
        }
        if (string.toLowerCase().equals("true")) {
            return true;
        }
        if (string.toLowerCase().equals("false")) {
            return false;
        }
        Config.warn("Unknown boolean: " + string);
        return bl;
    }

    private float parseFloat(String string, float f) {
        if (string == null) {
            return f;
        }
        float f2 = Config.parseFloat(string, Float.MIN_VALUE);
        if (f2 == Float.MIN_VALUE) {
            Config.warn("Invalid value: " + string);
            return f;
        }
        return f2;
    }

    private float[] parseAxis(String string, float[] fArray) {
        if (string == null) {
            return fArray;
        }
        String[] stringArray = Config.tokenize(string, " ");
        if (stringArray.length != 3) {
            Config.warn("Invalid axis: " + string);
            return fArray;
        }
        float[] fArray2 = new float[3];
        for (int i = 0; i < stringArray.length; ++i) {
            fArray2[i] = Config.parseFloat(stringArray[i], Float.MIN_VALUE);
            if (fArray2[i] == Float.MIN_VALUE) {
                Config.warn("Invalid axis: " + string);
                return fArray;
            }
            if (!(fArray2[i] < -1.0f) && !(fArray2[i] > 1.0f)) continue;
            Config.warn("Invalid axis values: " + string);
            return fArray;
        }
        float f = fArray2[0];
        float f2 = fArray2[1];
        float f3 = fArray2[2];
        if (f * f + f2 * f2 + f3 * f3 < 1.0E-5f) {
            Config.warn("Invalid axis values: " + string);
            return fArray;
        }
        float[] fArray3 = new float[]{f3, f2, -f};
        return fArray3;
    }

    public boolean isValid(String string) {
        if (this.source == null) {
            Config.warn("No source texture: " + string);
            return false;
        }
        this.source = TextureUtils.fixResourcePath(this.source, TextureUtils.getBasePath(string));
        if (this.startFadeIn >= 0 && this.endFadeIn >= 0 && this.endFadeOut >= 0) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5 = this.normalizeTime(this.endFadeIn - this.startFadeIn);
            if (this.startFadeOut < 0) {
                this.startFadeOut = this.normalizeTime(this.endFadeOut - n5);
            }
            if ((n4 = n5 + (n3 = this.normalizeTime(this.startFadeOut - this.endFadeIn)) + (n2 = this.normalizeTime(this.endFadeOut - this.startFadeOut)) + (n = this.normalizeTime(this.startFadeIn - this.endFadeOut))) != 24000) {
                Config.warn("Invalid fadeIn/fadeOut times, sum is more than 24h: " + n4);
                return false;
            }
            if (this.speed < 0.0f) {
                Config.warn("Invalid speed: " + this.speed);
                return false;
            }
            return true;
        }
        Config.warn("Invalid times, required are: startFadeIn, endFadeIn and endFadeOut.");
        return false;
    }

    private int normalizeTime(int n) {
        while (n >= 24000) {
            n -= 24000;
        }
        while (n < 0) {
            n += 24000;
        }
        return n;
    }

    public void render(int n, float f, float f2) {
        float f3 = f2 * this.getFadeBrightness(n);
        if ((f3 = Config.limit(f3, 0.0f, 1.0f)) >= 1.0E-4f) {
            bsfn._a(this.textureId);
            this.setupBlend(f3);
            GL11.glPushMatrix();
            if (this.rotate) {
                GL11.glRotatef(f * 360.0f * this.speed, this.axis[0], this.axis[1], this.axis[2]);
            }
            Tessellator tessellator = Tessellator.instance;
            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
            this.renderSide(tessellator, 4);
            GL11.glPushMatrix();
            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
            this.renderSide(tessellator, 1);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
            this.renderSide(tessellator, 0);
            GL11.glPopMatrix();
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            this.renderSide(tessellator, 5);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            this.renderSide(tessellator, 2);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            this.renderSide(tessellator, 3);
            GL11.glPopMatrix();
        }
    }

    private float getFadeBrightness(int n) {
        if (this.timeBetween(n, this.startFadeIn, this.endFadeIn)) {
            int n2 = this.normalizeTime(this.endFadeIn - this.startFadeIn);
            int n3 = this.normalizeTime(n - this.startFadeIn);
            return (float)n3 / (float)n2;
        }
        if (this.timeBetween(n, this.endFadeIn, this.startFadeOut)) {
            return 1.0f;
        }
        if (this.timeBetween(n, this.startFadeOut, this.endFadeOut)) {
            int n4 = this.normalizeTime(this.endFadeOut - this.startFadeOut);
            int n5 = this.normalizeTime(n - this.startFadeOut);
            return 1.0f - (float)n5 / (float)n4;
        }
        return 0.0f;
    }

    private void renderSide(Tessellator tessellator, int n) {
        double d = (double)(n % 3) / 3.0;
        double d2 = (double)(n / 3) / 2.0;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(-100.0, -100.0, -100.0, d, d2);
        tessellator.addVertexWithUV(-100.0, -100.0, 100.0, d, d2 + 0.5);
        tessellator.addVertexWithUV(100.0, -100.0, 100.0, d + 0.3333333333333333, d2 + 0.5);
        tessellator.addVertexWithUV(100.0, -100.0, -100.0, d + 0.3333333333333333, d2);
        tessellator.draw();
    }

    void setupBlend(float f) {
        switch (this.blend) {
            case 0: {
                GL11.glDisable(3008);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 1);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, f);
                break;
            }
            case 1: {
                GL11.glDisable(3008);
                GL11.glEnable(3042);
                GL11.glBlendFunc(775, 0);
                GL11.glColor4f(f, f, f, 1.0f);
                break;
            }
            case 2: {
                GL11.glDisable(3008);
                GL11.glEnable(3042);
                GL11.glBlendFunc(774, 771);
                GL11.glColor4f(f, f, f, f);
                break;
            }
            case 3: {
                GL11.glDisable(3008);
                GL11.glEnable(3042);
                GL11.glBlendFunc(1, 1);
                GL11.glColor4f(f, f, f, 1.0f);
                break;
            }
            case 4: {
                GL11.glDisable(3008);
                GL11.glEnable(3042);
                GL11.glBlendFunc(0, 769);
                GL11.glColor4f(f, f, f, 1.0f);
                break;
            }
            case 5: {
                GL11.glDisable(3008);
                GL11.glEnable(3042);
                GL11.glBlendFunc(1, 769);
                GL11.glColor4f(f, f, f, 1.0f);
                break;
            }
            case 6: {
                GL11.glEnable(3008);
                GL11.glDisable(3042);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, f);
            }
        }
        GL11.glEnable(3553);
    }

    public boolean isActive(int n) {
        return !this.timeBetween(n, this.endFadeOut, this.startFadeIn);
    }

    private boolean timeBetween(int n, int n2, int n3) {
        return n2 <= n3 ? n >= n2 && n <= n3 : n >= n2 || n <= n3;
    }
}

