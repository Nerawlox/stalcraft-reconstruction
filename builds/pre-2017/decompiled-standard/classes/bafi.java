/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyCore;

public class bafi
extends tgdv {
    public final klcb _a;
    private String _b;

    public bafi(int n, String string, String string2, klcb klcb2) {
        super(n - 256);
        this._a = klcb2;
        this._b = string;
        this.func_77637_a(GloomyCore.tab);
        this.func_77655_b(string);
        LanguageRegistry.addName(this, string2);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void func_94581_a(nege nege2) {
        this.field_77791_bV = nege2._b("stalker:" + this._b);
    }
}

