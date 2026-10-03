/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;

public class aoxf
extends GuiSlot {
    public final /* synthetic */ ifno _a;

    public aoxf(ifno ifno2) {
        this._a = ifno2;
        super(ifno2.mc, ifno2.width, ifno2.height, 80, ifno2.height - 40, ifno2.fontRenderer._c + 1);
    }

    @Override
    public int getSize() {
        return ifno._a(this._a).size();
    }

    @Override
    public void elementClicked(int n, boolean bl) {
    }

    @Override
    public boolean isSelected(int n) {
        return false;
    }

    @Override
    public void drawBackground() {
    }

    @Override
    public void drawSlot(int n, int n2, int n3, int n4, Tessellator tessellator) {
        this._a.fontRenderer._b((String)ifno._a(this._a).get(n), 10, n3, 0xFFFFFF);
        this._a.fontRenderer._b((String)ifno._b(this._a).get(n), 230, n3, 0xFFFFFF);
    }

    @Override
    public int getScrollBarX() {
        return this._a.width - 10;
    }
}

