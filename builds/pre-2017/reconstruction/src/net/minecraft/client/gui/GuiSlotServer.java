/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.opengl.GL11;

public class GuiSlotServer
extends GuiSlot {
    public final /* synthetic */ gqju _a;

    public GuiSlotServer(gqju gqju2) {
        this._a = gqju2;
        super(gqju2.mc, gqju2.width, gqju2.height, 32, gqju2.height - 64, 36);
    }

    @Override
    public int getSize() {
        return gqju._a(this._a)._c() + gqju._b(this._a).size() + 1;
    }

    @Override
    public void elementClicked(int n, boolean bl) {
        if (n >= gqju._a(this._a)._c() + gqju._b(this._a).size()) {
            return;
        }
        int n2 = gqju._c(this._a);
        gqju._a(this._a, n);
        ServerData serverData = gqju._a(this._a)._c() > n ? gqju._a(this._a)._a(n) : null;
        boolean bl2 = gqju._c(this._a) >= 0 && gqju._c(this._a) < this.getSize() && (serverData == null || serverData._f == 78);
        boolean bl3 = gqju._c(this._a) < gqju._a(this._a)._c();
        gqju._d((gqju)this._a).enabled = bl2;
        gqju._e((gqju)this._a).enabled = bl3;
        gqju._f((gqju)this._a).enabled = bl3;
        if (bl && bl2) {
            gqju._b(this._a, n);
        } else if (bl3 && GuiScreen.isShiftKeyDown() && n2 >= 0 && n2 < gqju._a(this._a)._c()) {
            gqju._a(this._a)._a(n2, gqju._c(this._a));
        }
    }

    @Override
    public boolean isSelected(int n) {
        return n == gqju._c(this._a);
    }

    @Override
    public int getContentHeight() {
        return this.getSize() * 36;
    }

    @Override
    public void drawBackground() {
        this._a.drawDefaultBackground();
    }

    @Override
    public void drawSlot(int n, int n2, int n3, int n4, Tessellator tessellator) {
        if (n < gqju._a(this._a)._c()) {
            this._c(n, n2, n3, n4, tessellator);
        } else if (n < gqju._a(this._a)._c() + gqju._b(this._a).size()) {
            this._a(n, n2, n3, n4, tessellator);
        } else {
            this._b(n, n2, n3, n4, tessellator);
        }
    }

    public void _a(int n, int n2, int n3, int n4, Tessellator tessellator) {
        ohgi ohgi2 = (ohgi)gqju._b(this._a).get(n - gqju._a(this._a)._c());
        this._a.drawString(this._a.fontRenderer, wpcz._a("lanServer.title"), n2 + 2, n3 + 1, 0xFFFFFF);
        this._a.drawString(this._a.fontRenderer, ohgi2._a(), n2 + 2, n3 + 12, 0x808080);
        if (this._a.mc._M.hideServerAddress) {
            this._a.drawString(this._a.fontRenderer, wpcz._a("selectServer.hiddenAddress"), n2 + 2, n3 + 12 + 11, 0x303030);
        } else {
            this._a.drawString(this._a.fontRenderer, ohgi2._b(), n2 + 2, n3 + 12 + 11, 0x303030);
        }
    }

    public void _b(int n, int n2, int n3, int n4, Tessellator tessellator) {
        String string;
        this._a.drawCenteredString(this._a.fontRenderer, wpcz._a("lanServer.scanning"), this._a.width / 2, n3 + 1, 0xFFFFFF);
        switch (gqju._g(this._a) / 3 % 4) {
            default: {
                string = "O o o";
                break;
            }
            case 1: 
            case 3: {
                string = "o O o";
                break;
            }
            case 2: {
                string = "o o O";
            }
        }
        this._a.drawCenteredString(this._a.fontRenderer, string, this._a.width / 2, n3 + 12, 0x808080);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void _c(int n, int n2, int n3, int n4, Tessellator tessellator) {
        ServerData serverData = gqju._a(this._a)._a(n);
        Object object = gqju._b();
        synchronized (object) {
            if (gqju._c() < 5 && !serverData._h) {
                serverData._h = true;
                serverData._e = -2L;
                serverData._d = "";
                serverData._c = "";
                gqju._d();
                new woyo(this, serverData).start();
            }
        }
        boolean bl = serverData._f > 78;
        boolean bl2 = serverData._f < 78;
        boolean bl3 = bl || bl2;
        this._a.drawString(this._a.fontRenderer, serverData._a, n2 + 2, n3 + 1, 0xFFFFFF);
        this._a.drawString(this._a.fontRenderer, serverData._d, n2 + 2, n3 + 12, 0x808080);
        this._a.drawString(this._a.fontRenderer, serverData._c, n2 + 215 - this._a.fontRenderer._b(serverData._c), n3 + 12, 0x808080);
        if (bl3) {
            String string = (Object)((Object)EnumChatFormatting._e) + serverData._g;
            this._a.drawString(this._a.fontRenderer, string, n2 + 200 - this._a.fontRenderer._b(string), n3 + 1, 0x808080);
        }
        if (this._a.mc._M.hideServerAddress || serverData._b()) {
            this._a.drawString(this._a.fontRenderer, wpcz._a("selectServer.hiddenAddress"), n2 + 2, n3 + 12 + 11, 0x303030);
        } else {
            this._a.drawString(this._a.fontRenderer, serverData._b, n2 + 2, n3 + 12 + 11, 0x303030);
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this._a.mc._R()._a(Gui.icons);
        int n5 = 0;
        int n6 = 0;
        String string = "";
        if (bl3) {
            string = bl ? "Client out of date!" : "Server out of date!";
            n6 = 5;
        } else if (serverData._h && serverData._e != -2L) {
            n6 = serverData._e < 0L ? 5 : (serverData._e < 150L ? 0 : (serverData._e < 300L ? 1 : (serverData._e < 600L ? 2 : (serverData._e < 1000L ? 3 : 4))));
            string = serverData._e < 0L ? "(no connection)" : serverData._e + "ms";
        } else {
            n5 = 1;
            n6 = (int)(Minecraft._M() / 100L + (long)(n * 2) & 7L);
            if (n6 > 4) {
                n6 = 8 - n6;
            }
            string = "Polling..";
        }
        this._a.drawTexturedModalRect(n2 + 205, n3, 0 + n5 * 10, 176 + n6 * 8, 10, 8);
        int n7 = 4;
        if (this.mouseX >= n2 + 205 - n7 && this.mouseY >= n3 - n7 && this.mouseX <= n2 + 205 + 10 + n7 && this.mouseY <= n3 + 8 + n7) {
            gqju._a(this._a, string);
        }
    }
}

