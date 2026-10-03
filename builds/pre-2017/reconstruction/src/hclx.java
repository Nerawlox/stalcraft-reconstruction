/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.gui.inventory.GuiBeacon;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.potion.Potion;

public class hclx
extends pked {
    public final int _e;
    public final int _f;
    public final /* synthetic */ GuiBeacon _g;

    public hclx(GuiBeacon guiBeacon, int n, int n2, int n3, int n4, int n5) {
        this._g = guiBeacon;
        super(n, n2, n3, GuiContainer.field_110408_a, 0 + Potion._a[n4]._e() % 8 * 18, 198 + Potion._a[n4]._e() / 8 * 18);
        this._e = n4;
        this._f = n5;
    }

    @Override
    public void func_82251_b(int n, int n2) {
        String string = wpcz._a(Potion._a[this._e]._c());
        if (this._f >= 3 && this._e != Potion._l._H) {
            string = string + " II";
        }
        this._g.drawCreativeTabHoveringText(string, n, n2);
    }
}

