/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import gloomyfolken.mods.shop.data.ShopEntry;
import java.util.Map;

public abstract class dggk<T extends ShopEntry>
extends GuiComponentsList {
    public dggk(ivwa ivwa2, T t, int n, int n2) {
        super(ivwa2);
        this.setLocation(new Point(n, n2));
        this._a(ivwa2, t, n, n2);
    }

    protected abstract void _a(ivwa var1, T var2, int var3, int var4);

    public abstract T _a();

    public abstract void _a(boolean var1);

    public abstract boolean _b();

    public abstract Map<Integer, cvzo> _c();

    public abstract McToolTip _d();

    @Override
    public abstract void setEnabled(boolean var1);
}

