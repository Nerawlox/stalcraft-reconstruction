/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.tdpx;

public class GuiNpcLabel {
    public String label;
    public boolean enabled = true;
    public int id;
    private int x;
    private int y;
    private int color = 0x404040;

    public GuiNpcLabel(int n, String string, int n2, int n3, int n4) {
        this.id = n;
        this.label = tdpx._a(string);
        this.x = n2;
        this.y = n3;
        this.color = n4;
    }

    public void drawLabel(GuiScreen guiScreen, FontRenderer fontRenderer) {
        if (this.enabled) {
            fontRenderer._b(this.label, this.x, this.y, this.color);
        }
    }

    public void center(int n) {
        int n2 = Minecraft._E()._z._b(this.label);
        this.x += (n - n2) / 2;
    }
}

