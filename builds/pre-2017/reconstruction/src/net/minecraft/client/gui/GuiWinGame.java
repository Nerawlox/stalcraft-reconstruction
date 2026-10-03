/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.network.packet.Packet205ClientCommand;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.Charsets;
import org.lwjgl.opengl.GL11;

public class GuiWinGame
extends GuiScreen {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/title/minecraft.png");
    public static final ResourceLocation _b = new ResourceLocation("textures/misc/vignette.png");
    public int _c;
    public List _d;
    public int _e;
    public float _f = 0.5f;

    @Override
    public void updateScreen() {
        ++this._c;
        float f = (float)(this._e + this.height + this.height + 24) / this._f;
        if ((float)this._c > f) {
            this._a();
        }
    }

    @Override
    public void keyTyped(char c, int n) {
        if (n == 1) {
            this._a();
        }
    }

    public void _a() {
        this.mc._t.sendQueue._b(new Packet205ClientCommand(1));
        this.mc._a((GuiScreen)null);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return true;
    }

    @Override
    public void initGui() {
        if (this._d != null) {
            return;
        }
        this._d = new ArrayList();
        try {
            int n;
            String string = "";
            String string2 = "" + (Object)((Object)EnumChatFormatting._p) + (Object)((Object)EnumChatFormatting._q) + (Object)((Object)EnumChatFormatting._k) + (Object)((Object)EnumChatFormatting._l);
            int n2 = 274;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.mc._S()._a(new ResourceLocation("texts/end.txt"))._a(), Charsets.UTF_8));
            Random random = new Random(8124371L);
            while ((string = bufferedReader.readLine()) != null) {
                string = string.replaceAll("PLAYERNAME", this.mc._P()._a());
                while (string.contains(string2)) {
                    n = string.indexOf(string2);
                    String string3 = string.substring(0, n);
                    String string4 = string.substring(n + string2.length());
                    string = string3 + (Object)((Object)EnumChatFormatting._p) + (Object)((Object)EnumChatFormatting._q) + "XXXXXXXX".substring(0, random.nextInt(4) + 3) + string4;
                }
                this._d.addAll(this.mc._z._c(string, n2));
                this._d.add("");
            }
            for (n = 0; n < 8; ++n) {
                this._d.add("");
            }
            bufferedReader = new BufferedReader(new InputStreamReader(this.mc._S()._a(new ResourceLocation("texts/credits.txt"))._a(), Charsets.UTF_8));
            while ((string = bufferedReader.readLine()) != null) {
                string = string.replaceAll("PLAYERNAME", this.mc._P()._a());
                string = string.replaceAll("\t", "    ");
                this._d.addAll(this.mc._z._c(string, n2));
                this._d.add("");
            }
            this._e = this._d.size() * 12;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void _a(int n, int n2, float f) {
        Tessellator tessellator = Tessellator.instance;
        this.mc._R()._a(Gui.optionsBackground);
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(1.0f, 1.0f, 1.0f, 1.0f);
        int n3 = this.width;
        float f2 = 0.0f - ((float)this._c + f) * 0.5f * this._f;
        float f3 = (float)this.height - ((float)this._c + f) * 0.5f * this._f;
        float f4 = 0.015625f;
        float f5 = ((float)this._c + f - 0.0f) * 0.02f;
        float f6 = (float)(this._e + this.height + this.height + 24) / this._f;
        float f7 = (f6 - 20.0f - ((float)this._c + f)) * 0.005f;
        if (f7 < f5) {
            f5 = f7;
        }
        if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        f5 *= f5;
        f5 = f5 * 96.0f / 255.0f;
        tessellator.setColorOpaque_F(f5, f5, f5);
        tessellator.addVertexWithUV(0.0, this.height, this.zLevel, 0.0, f2 * f4);
        tessellator.addVertexWithUV(n3, this.height, this.zLevel, (float)n3 * f4, f2 * f4);
        tessellator.addVertexWithUV(n3, 0.0, this.zLevel, (float)n3 * f4, f3 * f4);
        tessellator.addVertexWithUV(0.0, 0.0, this.zLevel, 0.0, f3 * f4);
        tessellator.draw();
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        int n3;
        this._a(n, n2, f);
        Tessellator tessellator = Tessellator.instance;
        int n4 = 274;
        int n5 = this.width / 2 - n4 / 2;
        int n6 = this.height + 50;
        float f2 = -((float)this._c + f) * this._f;
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0f, f2, 0.0f);
        this.mc._R()._a(_a);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.drawTexturedModalRect(n5, n6, 0, 0, 155, 44);
        this.drawTexturedModalRect(n5 + 155, n6, 0, 45, 155, 44);
        tessellator.setColorOpaque_I(0xFFFFFF);
        int n7 = n6 + 200;
        for (n3 = 0; n3 < this._d.size(); ++n3) {
            float f3;
            if (n3 == this._d.size() - 1 && (f3 = (float)n7 + f2 - (float)(this.height / 2 - 6)) < 0.0f) {
                GL11.glTranslatef(0.0f, -f3, 0.0f);
            }
            if ((float)n7 + f2 + 12.0f + 8.0f > 0.0f && (float)n7 + f2 < (float)this.height) {
                String string = (String)this._d.get(n3);
                if (string.startsWith("[C]")) {
                    this.fontRenderer._a(string.substring(3), n5 + (n4 - this.fontRenderer._b(string.substring(3))) / 2, n7, 0xFFFFFF);
                } else {
                    this.fontRenderer._d.setSeed((long)n3 * 4238972211L + (long)(this._c / 4));
                    this.fontRenderer._a(string, n5, n7, 0xFFFFFF);
                }
            }
            n7 += 12;
        }
        GL11.glPopMatrix();
        this.mc._R()._a(_b);
        GL11.glEnable(3042);
        GL11.glBlendFunc(0, 769);
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(1.0f, 1.0f, 1.0f, 1.0f);
        n3 = this.width;
        int n8 = this.height;
        tessellator.addVertexWithUV(0.0, n8, this.zLevel, 0.0, 1.0);
        tessellator.addVertexWithUV(n3, n8, this.zLevel, 1.0, 1.0);
        tessellator.addVertexWithUV(n3, 0.0, this.zLevel, 1.0, 0.0);
        tessellator.addVertexWithUV(0.0, 0.0, this.zLevel, 0.0, 0.0);
        tessellator.draw();
        GL11.glDisable(3042);
        super.drawScreen(n, n2, f);
    }
}

