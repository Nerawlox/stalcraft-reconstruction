/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import com.google.common.collect.Iterators;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.core.misc.amww;
import gloomyfolken.mods.core.misc.pidb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface xpzm<I extends tgdv, K>
extends amww {
    public static final String _a = "attach";

    @Nullable
    default public qoac _a(cvzo cvzo2) {
        if (cvzo2 == null || cvzo2._e == null || !cvzo2._e._c(_a)) {
            return null;
        }
        return cvzo2._e._m(_a);
    }

    @NotNull
    default public qoac _b(cvzo cvzo2) {
        qoac qoac2 = ncwh._b(cvzo2);
        qoac qoac3 = flra._a(qoac2, _a);
        if (qoac3 == null) {
            xpzm._a(0);
        }
        return qoac3;
    }

    @Nullable
    default public qoac _a(cvzo cvzo2, K k) {
        if (cvzo2 == null || cvzo2._e == null || !cvzo2._e._c(_a) || !cvzo2._e._m(_a)._c(k.toString())) {
            return null;
        }
        return cvzo2._e._m(_a)._m(k.toString());
    }

    @Nullable
    default public cvzo _b(cvzo cvzo2, K k) {
        qoac qoac2 = this._a(cvzo2, k);
        if (qoac2 == null) {
            return null;
        }
        return cvzo._a(qoac2);
    }

    @Nullable
    default public cvzo _c(cvzo cvzo2, K k) {
        cvzo cvzo3 = this._b(cvzo2, k);
        if (cvzo3 == null || !this._a(cvzo2, cvzo3._a(), k)) {
            this._a(cvzo2, (cvzo)null, k);
            return null;
        }
        return cvzo3;
    }

    @Nullable
    default public I _d(cvzo cvzo2, K k) {
        qoac qoac2 = this._a(cvzo2, k);
        if (qoac2 == null) {
            return null;
        }
        short s = qoac2._e("id");
        if (s <= 0 || s >= 32000 || !this._a(cvzo2, tgdv.field_77698_e[s], k)) {
            this._a(cvzo2, (cvzo)null, k);
            return null;
        }
        return this._b(tgdv.field_77698_e[s]);
    }

    default public void _a(cvzo cvzo2, cvzo cvzo3, K k) {
        qoac qoac2 = this._b(cvzo2);
        if (cvzo3 == null) {
            qoac2._p(k.toString());
        } else if (!this._a(cvzo2, cvzo3._a(), k)) {
            Logger.info("Can't attach item " + cvzo3 + " to slot " + k + "!", new Object[0]);
            Thread.dumpStack();
        } else {
            qoac2._a(k.toString(), (huhy)cvzo3._b(new qoac()));
        }
    }

    default public int _j_(cvzo cvzo2) {
        qoac qoac2 = this._a(cvzo2);
        if (qoac2 == null) {
            return 0;
        }
        return qoac2._c.size();
    }

    default public Iterator<qoac> _d(cvzo cvzo2) {
        qoac qoac2 = this._a(cvzo2);
        if (qoac2 == null) {
            return Iterators.emptyIterator();
        }
        return qoac2._c.values().iterator();
    }

    default public List<cvzo> _k_(cvzo cvzo2) {
        ArrayList<cvzo> arrayList = new ArrayList<cvzo>(this._j_(cvzo2));
        Iterator<qoac> iterator2 = this._d(cvzo2);
        while (iterator2.hasNext()) {
            qoac qoac2 = iterator2.next();
            cvzo cvzo3 = cvzo._a(qoac2);
            if (cvzo3 == null || !this._a(cvzo3._a())) continue;
            arrayList.add(cvzo3);
        }
        return arrayList;
    }

    default public void _a_(cvzo cvzo2, EntityPlayer entityPlayer) {
        pidb._c(cvzo2, entityPlayer);
        if (pidb._b(cvzo2)) {
            Iterator<qoac> iterator2 = this._d(cvzo2);
            while (iterator2.hasNext()) {
                qoac qoac2 = iterator2.next();
                qoac qoac3 = flra._a(qoac2, "tag");
                qoac3._a("owner", entityPlayer.field_71092_bJ);
            }
        }
    }

    default public String _f(cvzo cvzo2) {
        Iterator<qoac> iterator2 = this._d(cvzo2);
        while (iterator2.hasNext()) {
            qoac qoac2 = iterator2.next();
            qoac qoac3 = qoac2._m("tag");
            if (!qoac3._c("owner")) continue;
            return qoac3._j("owner");
        }
        return null;
    }

    default public boolean _b(cvzo cvzo2, cvzo cvzo3, K k) {
        return this._a(cvzo2, cvzo3._a(), k);
    }

    default public boolean _a(cvzo cvzo2, tgdv tgdv2, K k) {
        I i;
        try {
            i = this._b(tgdv2);
        }
        catch (ClassCastException classCastException) {
            return false;
        }
        return this._b(cvzo2, i, k);
    }

    default public boolean _b(cvzo cvzo2, I i, K k) {
        return true;
    }

    default public boolean _a(tgdv tgdv2) {
        try {
            this._b(tgdv2);
            return true;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    public I _b(tgdv var1);

    private static /* synthetic */ void _a(int n) {
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "gloomyfolken/mods/core/misc/IContainerItem", "getContainerTagOrCreate"));
    }
}

