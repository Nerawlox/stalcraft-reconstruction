/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class GuiCreateFlatWorldListSlot
extends GuiSlot {
    public int _a;
    public final /* synthetic */ stik _b;

    public GuiCreateFlatWorldListSlot(stik stik2) {
        this._b = stik2;
        super(stik2.mc, stik2.width, stik2.height, 43, stik2.height - 60, 24);
        this._a = -1;
    }

    public void _a(int n, int n2, ItemStack itemStack) {
        this._a(n + 1, n2 + 1);
        GL11.glEnable(32826);
        if (itemStack != null) {
            qnon._c();
            stik._d().renderItemIntoGUI(this._b.fontRenderer, this._b.mc._R(), itemStack, n + 2, n2 + 2);
            qnon._a();
        }
        GL11.glDisable(32826);
    }

    public void _a(int n, int n2) {
        this._a(n, n2, 0, 0);
    }

    public void _a(int n, int n2, int n3, int n4) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this._b.mc._R()._a(Gui.statIcons);
        float f = 0.0078125f;
        float f2 = 0.0078125f;
        int n5 = 18;
        int n6 = 18;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(n + 0, n2 + 18, this._b.zLevel, (float)(n3 + 0) * 0.0078125f, (float)(n4 + 18) * 0.0078125f);
        tessellator.addVertexWithUV(n + 18, n2 + 18, this._b.zLevel, (float)(n3 + 18) * 0.0078125f, (float)(n4 + 18) * 0.0078125f);
        tessellator.addVertexWithUV(n + 18, n2 + 0, this._b.zLevel, (float)(n3 + 18) * 0.0078125f, (float)(n4 + 0) * 0.0078125f);
        tessellator.addVertexWithUV(n + 0, n2 + 0, this._b.zLevel, (float)(n3 + 0) * 0.0078125f, (float)(n4 + 0) * 0.0078125f);
        tessellator.draw();
    }

    @Override
    public int getSize() {
        return stik._a(this._b)._c().size();
    }

    @Override
    public void elementClicked(int n, boolean bl) {
        this._a = n;
        this._b._b();
    }

    @Override
    public boolean isSelected(int n) {
        return n == this._a;
    }

    @Override
    public void drawBackground() {
    }

    @Override
    public void drawSlot(int n, int n2, int n3, int n4, Tessellator tessellator) {
        suyo suyo2 = (suyo)stik._a(this._b)._c().get(stik._a(this._b)._c().size() - n - 1);
        ItemStack itemStack = suyo2._b() == 0 ? null : new ItemStack(suyo2._b(), 1, suyo2._c());
        String string = itemStack == null ? "Air" : Item.itemsList[suyo2._b()].getItemStackDisplayName(itemStack);
        this._a(n2, n3, itemStack);
        this._b.fontRenderer._b(string, n2 + 18 + 5, n3 + 3, 0xFFFFFF);
        String string2 = n == 0 ? wpcz._a("createWorld.customize.flat.layer.top", suyo2._a()) : (n == stik._a(this._b)._c().size() - 1 ? wpcz._a("createWorld.customize.flat.layer.bottom", suyo2._a()) : wpcz._a("createWorld.customize.flat.layer", suyo2._a()));
        this._b.fontRenderer._b(string2, n2 + 2 + 213 - this._b.fontRenderer._b(string2), n3 + 3, 0xFFFFFF);
    }

    @Override
    public int getScrollBarX() {
        return this._b.width - 70;
    }
}

