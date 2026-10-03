/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class mavq
extends GuiSlot {
    public int _a;
    public final /* synthetic */ tfkf _b;

    public mavq(tfkf tfkf2) {
        this._b = tfkf2;
        super(tfkf2.mc, tfkf2.width, tfkf2.height, 80, tfkf2.height - 37, 24);
        this._a = -1;
    }

    public void _a(int n, int n2, int n3) {
        this._a(n + 1, n2 + 1);
        GL11.glEnable(32826);
        qnon._c();
        tfkf._c().renderItemIntoGUI(this._b.fontRenderer, this._b.mc._R(), new ItemStack(n3, 1, 0), n + 2, n2 + 2);
        qnon._a();
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
        return tfkf._d().size();
    }

    @Override
    public void elementClicked(int n, boolean bl) {
        this._a = n;
        this._b._a();
        tfkf._b(this._b).setText(((htjk)tfkf._d().get((int)tfkf._a((tfkf)this._b)._a))._c);
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
        htjk htjk2 = (htjk)tfkf._d().get(n);
        this._a(n2, n3, htjk2._a);
        this._b.fontRenderer._b(htjk2._b, n2 + 18 + 5, n3 + 6, 0xFFFFFF);
    }
}

