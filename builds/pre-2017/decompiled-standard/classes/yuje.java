/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyCore;
import net.minecraft.entity.Entity;

public class yuje
extends tgdv {
    public yuje(int n) {
        super(n - 256);
        this.func_77637_a(GloomyCore.tab);
        this.func_77655_b("empty_bottle");
        LanguageRegistry.addName(this, "\u0411\u0443\u0442\u044b\u043b\u043a\u0430");
    }

    public int _a(Entity entity) {
        return 2;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void func_94581_a(nege nege2) {
        this.field_77791_bV = nege2._b("stalker:empty_bottle");
    }
}

