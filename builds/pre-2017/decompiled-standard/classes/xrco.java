/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import net.minecraft.util.dwan;

public class xrco
extends mbpd {
    public xrco(int n) {
        super(n);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void func_94581_a(nege nege2) {
        this.field_77791_bV = nege2._b("stalkerclans:flag");
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

