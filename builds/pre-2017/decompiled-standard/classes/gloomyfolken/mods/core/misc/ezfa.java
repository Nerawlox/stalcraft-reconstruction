/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.misc.amww;
import gloomyfolken.mods.core.misc.jxsn;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;

public interface ezfa
extends amww {
    default public void _c(cvzo cvzo2, EntityPlayer entityPlayer, List<String> list2) {
        if (this instanceof jxsn) {
            ((jxsn)((Object)this))._a(cvzo2, entityPlayer, list2);
        }
    }

    default public boolean _a_(cvzo cvzo2) {
        return this._l_(cvzo2);
    }

    default public boolean _l_(cvzo cvzo2) {
        return true;
    }

    default public String _d_(cvzo cvzo2) {
        return "\u041d\u0430\u0436\u043c\u0438\u0442\u0435 <\u041f\u041a\u041c> \u0447\u0442\u043e\u0431\u044b \u043e\u0442\u043a\u0440\u044b\u0442\u044c \u043c\u0435\u043d\u044e \u043e\u0431\u0432\u0435\u0441\u043e\u0432";
    }

    @ezey(_a={eidj.CLIENT})
    public gqjz _a(gqjz var1, EntityPlayer var2, cvzo var3, int var4);
}

