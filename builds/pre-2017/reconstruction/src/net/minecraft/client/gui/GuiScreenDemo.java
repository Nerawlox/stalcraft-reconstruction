/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import java.net.URI;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiScreenDemo
extends GuiScreen {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/demo_background.png");

    @Override
    public void initGui() {
        this.buttonList.clear();
        int n = -16;
        this.buttonList.add(new GuiButton(1, this.width / 2 - 116, this.height / 2 + 62 + n, 114, 20, wpcz._a("demo.help.buy")));
        this.buttonList.add(new GuiButton(2, this.width / 2 + 2, this.height / 2 + 62 + n, 114, 20, wpcz._a("demo.help.later")));
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        switch (guiButton.id) {
            case 2: {
                this.mc._a((GuiScreen)null);
                this.mc._o();
                break;
            }
            case 1: {
                guiButton.enabled = false;
                try {
                    Class<?> clazz = Class.forName("java.awt.Desktop");
                    Object object = clazz.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
                    clazz.getMethod("browse", URI.class).invoke(object, new URI("http://www.minecraft.net/store?source=demo"));
                    break;
                }
                catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
    }

    @Override
    public void drawDefaultBackground() {
        super.drawDefaultBackground();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._R()._a(_a);
        int n = (this.width - 248) / 2;
        int n2 = (this.height - 166) / 2;
        this.drawTexturedModalRect(n, n2, 0, 0, 248, 166);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        int n3 = (this.width - 248) / 2 + 10;
        int n4 = (this.height - 166) / 2 + 8;
        this.fontRenderer._b(wpcz._a("demo.help.title"), n3, n4, 0x1F1F1F);
        GameSettings gameSettings = this.mc._M;
        this.fontRenderer._b(wpcz._a("demo.help.movementShort", GameSettings.getKeyDisplayString(gameSettings.keyBindForward._d), GameSettings.getKeyDisplayString(gameSettings.keyBindLeft._d), GameSettings.getKeyDisplayString(gameSettings.keyBindBack._d), GameSettings.getKeyDisplayString(gameSettings.keyBindRight._d)), n3, n4 += 12, 0x4F4F4F);
        this.fontRenderer._b(wpcz._a("demo.help.movementMouse"), n3, n4 + 12, 0x4F4F4F);
        this.fontRenderer._b(wpcz._a("demo.help.jump", GameSettings.getKeyDisplayString(gameSettings.keyBindJump._d)), n3, n4 + 24, 0x4F4F4F);
        this.fontRenderer._b(wpcz._a("demo.help.inventory", GameSettings.getKeyDisplayString(gameSettings.keyBindInventory._d)), n3, n4 + 36, 0x4F4F4F);
        this.fontRenderer._a(wpcz._a("demo.help.fullWrapped"), n3, n4 + 68, 218, 0x1F1F1F);
        super.drawScreen(n, n2, f);
    }
}

