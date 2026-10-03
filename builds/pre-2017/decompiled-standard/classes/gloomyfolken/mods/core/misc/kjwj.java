/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.eifc;
import gloomyfolken.mods.core.misc.jxsn;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;

public class kjwj
extends tgdv
implements jxsn {
    protected final List<String> _b_;

    public kjwj(int n, String string, String string2, List<String> list, int n2) {
        super(n - 256);
        this.func_77655_b(eifc._a(string) + "_" + n);
        LanguageRegistry.addName(this, string);
        this.func_111206_d(string2);
        this._b_ = list;
        this.field_77777_bU = n2;
        this.func_77637_a(GloomyCore.tab);
    }

    @Override
    public final void func_77624_a(cvzo cvzo2, EntityPlayer entityPlayer, List list, boolean bl) {
    }

    @Override
    public void _b(cvzo cvzo2, EntityPlayer entityPlayer, List<String> list) {
        list.addAll(this._b_);
    }
}

