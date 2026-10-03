/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.stats.StatBase;

public class htnw
extends GuiSlot {
    public final /* synthetic */ uzta _a;

    public htnw(uzta uzta2) {
        this._a = uzta2;
        super(uzta._a(uzta2), uzta2.width, uzta2.height, 32, uzta2.height - 64, 10);
        this.setShowSelectionBox(false);
    }

    @Override
    public int getSize() {
        return dzif._c.size();
    }

    @Override
    public void elementClicked(int n, boolean bl) {
    }

    @Override
    public boolean isSelected(int n) {
        return false;
    }

    @Override
    public int getContentHeight() {
        return this.getSize() * 10;
    }

    @Override
    public void drawBackground() {
        this._a.drawDefaultBackground();
    }

    @Override
    public void drawSlot(int n, int n2, int n3, int n4, Tessellator tessellator) {
        StatBase statBase = (StatBase)dzif._c.get(n);
        this._a.drawString(uzta._b(this._a), wpcz._a(statBase.getName()), n2 + 2, n3 + 1, n % 2 == 0 ? 0xFFFFFF : 0x909090);
        String string = statBase.func_75968_a(uzta._c(this._a)._a(statBase));
        this._a.drawString(uzta._d(this._a), string, n2 + 2 + 213 - uzta._e(this._a)._b(string), n3 + 1, n % 2 == 0 ? 0xFFFFFF : 0x909090);
    }
}

