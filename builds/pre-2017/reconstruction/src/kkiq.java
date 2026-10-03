/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.misc.jxsn;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

public class kkiq
extends eixm {
    protected jxsn _a;
    protected transient ItemStack _c;

    public kkiq(jxsn jxsn2) {
        super("");
        this._a = jxsn2;
    }

    @Override
    public String getString() {
        return this._d()._s();
    }

    @Override
    public String _b() {
        ArrayList<String> arrayList = new ArrayList<String>();
        this._a._a(this._d(), Minecraft._E()._t, arrayList);
        return String.join((CharSequence)"\n", arrayList);
    }

    @Override
    public String _c() {
        return String.join((CharSequence)"\n", this._a._a(this._d(), Minecraft._E()._t));
    }

    public ItemStack _d() {
        if (this._c == null) {
            this._c = this._a._g();
        }
        return this._c;
    }
}

