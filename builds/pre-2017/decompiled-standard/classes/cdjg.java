/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyCore;
import net.minecraft.util.dwan;

public class cdjg
extends mbpd {
    public cdjg(int n) {
        super(n);
        this.func_77656_e(0);
        this.func_77637_a(GloomyCore.tab);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void func_94581_a(nege nege2) {
        this.field_77791_bV = nege2._b("stalker:machinegun");
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public dwan func_77617_a(int n) {
        return this.field_77791_bV;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public int func_94901_k() {
        return 1;
    }
}

