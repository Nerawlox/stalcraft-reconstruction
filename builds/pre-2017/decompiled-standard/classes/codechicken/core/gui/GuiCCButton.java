/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.gui;

import codechicken.core.gui.GuiWidget;
import net.minecraft.client.xpzm;
import org.lwjgl.opengl.GL11;

public class GuiCCButton
extends GuiWidget {
    public String text;
    public String actionCommand;
    private boolean isEnabled = true;
    public boolean drawButton = true;

    public GuiCCButton(int n, int n2, int n3, int n4, String string) {
        super(n, n2, n3, n4);
        this.text = string;
    }

    public void setText(String string) {
        this.text = string;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void setEnabled(boolean bl) {
        this.isEnabled = bl;
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        if (this.isEnabled && this.pointInside(n, n2) && this.actionCommand != null) {
            this.sendAction(this.actionCommand, n3);
            xpzm._E()._N._a("random.click", 1.0f, 1.0f);
        }
    }

    @Override
    public void draw(int n, int n2, float f) {
        if (!this.drawButton) {
            return;
        }
        this.renderEngine._a(GuiWidget.guiTex);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        boolean bl = this.pointInside(n, n2);
        int n3 = !this.isEnabled ? 0 : (bl ? 2 : 1);
        this.func_73729_b(this.x, this.y, 0, 46 + n3 * 20, this.width / 2, this.height / 2);
        this.func_73729_b(this.x + this.width / 2, this.y, 200 - this.width / 2, 46 + n3 * 20, this.width / 2, this.height / 2);
        this.func_73729_b(this.x, this.y + this.height / 2, 0, 46 + n3 * 20 + 20 - this.height / 2, this.width / 2, this.height / 2);
        this.func_73729_b(this.x + this.width / 2, this.y + this.height / 2, 200 - this.width / 2, 46 + n3 * 20 + 20 - this.height / 2, this.width / 2, this.height / 2);
        this.func_73732_a(this.fontRenderer, this.text, this.x + this.width / 2, this.y + (this.height - 8) / 2, this.getTextColour(n, n2));
    }

    public int getTextColour(int n, int n2) {
        return !this.isEnabled ? -6250336 : (this.pointInside(n, n2) ? -96 : -2039584);
    }

    public GuiCCButton setActionCommand(String string) {
        this.actionCommand = string;
        return this;
    }
}

