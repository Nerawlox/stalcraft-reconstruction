/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.config;

import codechicken.core.gui.GuiDraw;
import codechicken.lib.vec.Rectangle4i;
import codechicken.nei.LayoutManager;
import codechicken.nei.config.Option;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public abstract class OptionButton
extends Option {
    protected static ResourceLocation guiTex = new ResourceLocation("textures/gui/widgets.png");
    public final String prefix;
    public final String text;
    public final String tooltip;
    private boolean isEnabled = true;

    public OptionButton(String string, String string2, String string3, String string4) {
        super(string);
        this.prefix = string2;
        this.text = string3;
        this.tooltip = string4;
    }

    public OptionButton(String string, String string2, String string3) {
        this(string2, string, string2, string3);
    }

    public OptionButton(String string) {
        this(null, string, string + ".tip");
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void setEnabled(boolean bl) {
        this.isEnabled = bl;
    }

    @Override
    public void draw(int n, int n2, float f) {
        GuiDraw.changeTexture(guiTex);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.drawPrefix();
        this.drawButton(n, n2);
    }

    public Rectangle4i buttonSize() {
        int n;
        int n2;
        if (this.getPrefix() == null) {
            n2 = this.slot.contentWidth();
            n = (this.slot.contentWidth() - n2) / 2;
        } else {
            n2 = Math.max(60, GuiDraw.getStringWidth(this.getButtonText()));
            n = this.slot.contentWidth() - n2;
        }
        return new Rectangle4i(n, 2, n2, 20);
    }

    public String getPrefix() {
        if (this.prefix == null) {
            return null;
        }
        String string = this.translateN(this.prefix, new Object[0]);
        if (string.equals(this.namespaced(this.prefix))) {
            return null;
        }
        return string;
    }

    public String getButtonText() {
        return this.translateN(this.name, new Object[0]);
    }

    public String getTooltip() {
        if (this.tooltip == null) {
            return null;
        }
        String string = this.translateN(this.tooltip, new Object[0]);
        if (string.equals(this.namespaced(this.tooltip))) {
            return null;
        }
        return string;
    }

    public void drawPrefix() {
        if (this.getPrefix() != null) {
            GuiDraw.drawString(this.getPrefix(), 10, 8, -1);
        }
    }

    public void drawButton(int n, int n2) {
        Rectangle4i rectangle4i = this.buttonSize();
        LayoutManager.drawButtonBackground(rectangle4i.x, rectangle4i.y, rectangle4i.w, rectangle4i.h, true, this.getButtonTex(n, n2));
        GuiDraw.drawStringC(this.getButtonText(), rectangle4i.x, rectangle4i.y, rectangle4i.w, rectangle4i.h, this.getTextColour(n, n2));
    }

    public int getButtonTex(int n, int n2) {
        return !this.isEnabled() ? 0 : (this.pointInside(n, n2) ? 2 : 1);
    }

    public int getTextColour(int n, int n2) {
        return !this.isEnabled() ? -6250336 : (this.pointInside(n, n2) ? -96 : -2039584);
    }

    public boolean pointInside(int n, int n2) {
        return this.buttonSize().contains(n, n2);
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        if (this.pointInside(n, n2) && this.onClick(n3)) {
            Minecraft._E()._N._a("random.click", 1.0f, 1.0f);
        }
    }

    public boolean onClick(int n) {
        return false;
    }

    @Override
    public List<String> handleTooltip(int n, int n2, List<String> list2) {
        if (new Rectangle4i(0, 2, this.slot.contentWidth(), 20).contains(n, n2) && this.getTooltip() != null) {
            list2.add(this.getTooltip());
        }
        return list2;
    }
}

