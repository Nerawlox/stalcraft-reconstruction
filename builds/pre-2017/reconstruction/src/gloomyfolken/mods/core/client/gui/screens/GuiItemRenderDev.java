/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.screens;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class GuiItemRenderDev
extends GuiScreen {
    private static final ResourceLocation background = new ResourceLocation("weapons", "textures/gui/weapondev.png");
    public anpy cfg;
    private static float STEP = 0.02f;
    private static final int ACCURACY_MINUS = 100;
    private static final int ACCURACY_PLUS = 101;
    private static final int ACCURACY_RESET = 102;
    private static final int SAVE = 200;

    public GuiItemRenderDev(anpy anpy2) {
        this.cfg = anpy2;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.clear();
        Vector3f[] vector3fArray = new Vector3f[]{this.cfg._a, this.cfg._b, this.cfg._c, this.cfg._d, this.cfg._e, this.cfg._f};
        int n = 20;
        for (int i = 0; i < vector3fArray.length * 3; ++i) {
            this.buttonList.add(new GuiButton(i * 3 + 0, 100, n + 10 * i, 10, 8, "-"));
            this.buttonList.add(new GuiButton(i * 3 + 1, 110, n + 10 * i, 10, 8, "+"));
            this.buttonList.add(new GuiButton(i * 3 + 2, 120, n + 10 * i, 10, 8, "x"));
        }
        this.buttonList.add(new GuiButton(100, 148, 135, 20, 20, "-"));
        this.buttonList.add(new GuiButton(101, 148, 157, 20, 20, "+"));
        this.buttonList.add(new GuiButton(102, 148, 179, 20, 20, "x"));
        this.buttonList.add(new GuiButton(200, 8, 274, 78, 20, "\u0417\u0430\u043f\u0438\u0441\u0430\u0442\u044c \u0432 \u0444\u0430\u0439\u043b"));
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        int n = guiButton.id;
        if (n == 200) {
            this.cfg._b();
        } else if (n == 100) {
            STEP *= 0.75f;
        } else if (n == 101) {
            STEP *= 1.3333334f;
        } else if (n == 102) {
            STEP = 0.02f;
        } else {
            Vector3f[] vector3fArray = new Vector3f[]{this.cfg._a, this.cfg._b, this.cfg._c, this.cfg._d, this.cfg._e, this.cfg._f};
            int n2 = n / 3;
            int n3 = n2 % 3;
            int n4 = n2 / 3;
            int n5 = n % 3;
            Vector3f vector3f = vector3fArray[n4];
            float f = STEP;
            if (n4 % 2 == 1) {
                f *= 25.0f;
            }
            if (n5 == 0) {
                this.setValue(vector3f, n3, this.getValue(vector3f, n3) - f);
            } else if (n5 == 1) {
                this.setValue(vector3f, n3, this.getValue(vector3f, n3) + f);
            } else {
                this.setValue(vector3f, n3, 0.0f);
            }
        }
    }

    private void setValue(Vector3f vector3f, int n, float f) {
        if (n == 0) {
            vector3f.x = f;
        } else if (n == 1) {
            vector3f.y = f;
        } else if (n == 2) {
            vector3f.z = f;
        }
    }

    private float getValue(Vector3f vector3f, int n) {
        if (n == 0) {
            return vector3f.x;
        }
        if (n == 1) {
            return vector3f.y;
        }
        if (n == 2) {
            return vector3f.z;
        }
        throw new IllegalArgumentException("Illegal value id " + n);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._h._a(background);
        this.drawTexturedModalRect(0, 0, 0, 0, 176, 240);
        this.drawTexturedModalRect(0, 240, 0, 197, 176, 59);
        this.drawStrings();
        super.drawScreen(n, n2, f);
    }

    private void drawStrings() {
        int n = 20;
        int n2 = 0;
        this.drawString(this.fontRenderer, "\u041f\u0435\u0440\u0432\u043e\u0435 \u043b\u0438\u0446\u043e, X: " + String.format("%.3f", Float.valueOf(this.cfg._a.x)), 5, n + 10 * n2++, 0xFFFFFF);
        this.drawString(this.fontRenderer, "\u041f\u0435\u0440\u0432\u043e\u0435 \u043b\u0438\u0446\u043e, Y: " + String.format("%.3f", Float.valueOf(this.cfg._a.y)), 5, n + 10 * n2++, 0xFFFFFF);
        this.drawString(this.fontRenderer, "\u041f\u0435\u0440\u0432\u043e\u0435 \u043b\u0438\u0446\u043e, Z: " + String.format("%.3f", Float.valueOf(this.cfg._a.z)), 5, n + 10 * n2++, 0xFFFFFF);
        this.drawString(this.fontRenderer, "\u041f\u0435\u0440\u0432\u043e\u0435 \u043b\u0438\u0446\u043e, RX: " + String.format("%.3f", Float.valueOf(this.cfg._b.x)), 5, n + 10 * n2++, 0xFFFFFF);
        this.drawString(this.fontRenderer, "\u041f\u0435\u0440\u0432\u043e\u0435 \u043b\u0438\u0446\u043e, RY: " + String.format("%.3f", Float.valueOf(this.cfg._b.y)), 5, n + 10 * n2++, 0xFFFFFF);
        this.drawString(this.fontRenderer, "\u041f\u0435\u0440\u0432\u043e\u0435 \u043b\u0438\u0446\u043e, RZ: " + String.format("%.3f", Float.valueOf(this.cfg._b.z)), 5, n + 10 * n2++, 0xFFFFFF);
        this.drawString(this.fontRenderer, "\u0422\u0440\u0435\u0442\u044c\u0435 \u043b\u0438\u0446\u043e, X: " + String.format("%.3f", Float.valueOf(this.cfg._c.x)), 5, n + 10 * n2++, 0xFFFFFF);
        this.drawString(this.fontRenderer, "\u0422\u0440\u0435\u0442\u044c\u0435 \u043b\u0438\u0446\u043e, Y: " + String.format("%.3f", Float.valueOf(this.cfg._c.y)), 5, n + 10 * n2++, 0xFFFFFF);
        this.drawString(this.fontRenderer, "\u0422\u0440\u0435\u0442\u044c\u0435 \u043b\u0438\u0446\u043e, Z: " + String.format("%.3f", Float.valueOf(this.cfg._c.z)), 5, n + 10 * n2++, 0xFFFFFF);
        this.drawString(this.fontRenderer, "\u0422\u0440\u0435\u0442\u044c\u0435 \u043b\u0438\u0446\u043e, RX: " + String.format("%.3f", Float.valueOf(this.cfg._d.x)), 5, n + 10 * n2++, 0xFFFFFF);
        this.drawString(this.fontRenderer, "\u0422\u0440\u0435\u0442\u044c\u0435 \u043b\u0438\u0446\u043e, RY: " + String.format("%.3f", Float.valueOf(this.cfg._d.y)), 5, n + 10 * n2++, 0xFFFFFF);
        this.drawString(this.fontRenderer, "\u0422\u0440\u0435\u0442\u044c\u0435 \u043b\u0438\u0446\u043e, RZ: " + String.format("%.3f", Float.valueOf(this.cfg._d.z)), 5, n + 10 * n2++, 0xFFFFFF);
        this.drawString(this.fontRenderer, "\u0417\u0435\u043c\u043b\u044f, X: " + String.format("%.3f", Float.valueOf(this.cfg._e.x)), 5, n + 10 * n2++, 0xFFFFFF);
        this.drawString(this.fontRenderer, "\u0417\u0435\u043c\u043b\u044f, Y: " + String.format("%.3f", Float.valueOf(this.cfg._e.y)), 5, n + 10 * n2++, 0xFFFFFF);
        this.drawString(this.fontRenderer, "\u0417\u0435\u043c\u043b\u044f, Z: " + String.format("%.3f", Float.valueOf(this.cfg._e.z)), 5, n + 10 * n2++, 0xFFFFFF);
        this.drawString(this.fontRenderer, "\u0417\u0435\u043c\u043b\u044f, RX: " + String.format("%.3f", Float.valueOf(this.cfg._f.x)), 5, n + 10 * n2++, 0xFFFFFF);
        this.drawString(this.fontRenderer, "\u0417\u0435\u043c\u043b\u044f, RY: " + String.format("%.3f", Float.valueOf(this.cfg._f.y)), 5, n + 10 * n2++, 0xFFFFFF);
        this.drawString(this.fontRenderer, "\u0417\u0435\u043c\u043b\u044f, RZ: " + String.format("%.3f", Float.valueOf(this.cfg._f.z)), 5, n + 10 * n2++, 0xFFFFFF);
        this.drawString(this.fontRenderer, "\u0428\u0430\u0433:", 148, 115, 0xFFFFFF);
        this.drawString(this.fontRenderer, String.format("%.3f", Float.valueOf(STEP)), 148, 125, 0xFFFFFF);
    }
}

