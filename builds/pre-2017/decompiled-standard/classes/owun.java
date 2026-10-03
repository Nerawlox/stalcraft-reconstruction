/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.misc.jxsn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class owun
extends anmx {
    protected List<anmx> _a;

    public owun(String string) {
        super(string);
        this._a = new ArrayList<anmx>();
    }

    public owun(String string, List<anmx> list) {
        super(string);
        this._a = list;
    }

    @Override
    public boolean _a() {
        return true;
    }

    @Override
    public int getColor() {
        return 0x939393;
    }

    public Collection<? extends anmx> elements() {
        return this._a;
    }

    public void _a(anmx anmx2) {
        this._a.add(anmx2);
    }

    public <T extends tgdv> kkiq _a(T t) {
        kkiq kkiq2 = new kkiq((jxsn)((Object)t));
        this._a(kkiq2);
        return kkiq2;
    }
}

