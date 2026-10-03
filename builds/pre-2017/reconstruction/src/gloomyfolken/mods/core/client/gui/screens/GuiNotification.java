/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.screens;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public abstract class GuiNotification
extends GuiScreen {
    public static final ResourceLocation texture = new ResourceLocation("gloomycore", "textures/gui/yesno.png");
    protected boolean answered;
    protected String line1;
    protected String line2;

    public GuiNotification(String string, String string2) {
        this.line1 = string;
        this.line2 = string2;
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 76, this.height / 2 + 40, 74, 20, "\u041e\u041a"));
        this.buttonList.add(new GuiButton(1, this.width / 2 + 2, this.height / 2 + 40, 74, 20, "\u041e\u0442\u043c\u0435\u043d\u0430"));
    }

    @Override
    protected void keyTyped(char c, int n) {
        super.keyTyped(c, n);
        if (n == 28) {
            this.success();
            this.answered = true;
            this.mc._a((GuiScreen)null);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawWorldBackground(0);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(2896);
        Minecraft._E()._h._a(texture);
        this.drawTexturedModalRect(this.width / 2 - 95, this.height / 2 - 25, 0, 0, 190, 110);
        this.drawCenteredString(this.fontRenderer, this.line1, this.width / 2, this.height / 2 - 2, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, this.line2, this.width / 2, this.height / 2 + 10, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 0) {
            this.success();
        } else if (guiButton.id == 1) {
            this.fail();
        }
        this.answered = true;
        Minecraft._E()._a((GuiScreen)null);
    }

    @Override
    public void onGuiClosed() {
        if (!this.answered) {
            this.fail();
        }
    }

    public abstract void fail();

    public abstract void success();
}

