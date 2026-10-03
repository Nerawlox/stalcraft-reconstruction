/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Iterators;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gloomyfolken.mods.asm.Logger;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class ncwh {
    public static kjui _a;
    public static Gson _b;
    private static final qoac _c;

    public static String _a(cvzo cvzo2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cvzo2._d).append(':').append(cvzo2._f).append('x').append(cvzo2._b);
        if (cvzo2._e != null) {
            stringBuilder.append(_b.toJson(cvzo2._e));
        }
        return stringBuilder.toString();
    }

    public static ccxr _a(EntityPlayer entityPlayer) {
        ccxr ccxr2 = (ccxr)entityPlayer.getExtendedProperties("st_attrib");
        if (ccxr2 == null) {
            throw new RuntimeException("Player info for " + entityPlayer + " not found!");
        }
        return ccxr2;
    }

    public static int _a(mssh mssh2, cvzo cvzo2) {
        if (cvzo2 != null) {
            for (int i = 0; i < mssh2.func_70302_i_(); ++i) {
                if (mssh2.func_70301_a(i) != cvzo2) continue;
                return i;
            }
        }
        return -1;
    }

    public static boolean _a(EntityPlayer entityPlayer, int n) {
        zwyn zwyn2 = (zwyn)entityPlayer.field_71069_bz;
        for (yeso yeso2 : zwyn2.getOwnedSlots()) {
            if (!yeso2.func_75216_d() || yeso2.func_75211_c()._d != n) continue;
            return true;
        }
        return false;
    }

    public static int _a(EntityPlayer entityPlayer, int[] nArray) {
        zwyn zwyn2 = (zwyn)entityPlayer.field_71069_bz;
        for (yeso yeso2 : zwyn2.getOwnedSlots()) {
            cvzo cvzo2 = yeso2.func_75211_c();
            if (cvzo2 == null) continue;
            for (int i = 0; i < nArray.length; ++i) {
                if (cvzo2._d != nArray[i]) continue;
                return cvzo2._d;
            }
        }
        return 0;
    }

    public static boolean _b(EntityPlayer entityPlayer, int[] nArray) {
        for (int i = 0; i < nArray.length; ++i) {
            if (!ncwh._a(entityPlayer, nArray[i])) continue;
            return true;
        }
        return false;
    }

    public static int _b(EntityPlayer entityPlayer, int n) {
        int n2 = 0;
        zwyn zwyn2 = (zwyn)entityPlayer.field_71069_bz;
        for (yeso yeso2 : zwyn2.getOwnedSlots()) {
            cvzo cvzo2 = yeso2.func_75211_c();
            if (cvzo2 == null || cvzo2._d != n) continue;
            n2 += cvzo2._b;
        }
        return n2;
    }

    public static int _a(EntityPlayer entityPlayer, int n, int n2) {
        int n3 = 0;
        zwyn zwyn2 = (zwyn)entityPlayer.field_71069_bz;
        for (yeso yeso2 : zwyn2.getOwnedSlots()) {
            cvzo cvzo2 = yeso2.func_75211_c();
            if (cvzo2 == null || cvzo2._d != n || cvzo2._f != n2) continue;
            n3 += cvzo2._b;
        }
        return n3;
    }

    public static int _a(EntityPlayer entityPlayer, int n, qoac qoac2) {
        int n2 = 0;
        zwyn zwyn2 = (zwyn)entityPlayer.field_71069_bz;
        for (yeso yeso2 : zwyn2.getOwnedSlots()) {
            cvzo cvzo2 = yeso2.func_75211_c();
            if (cvzo2 == null || cvzo2._d != n || !Objects.equals(qoac2, cvzo2._e)) continue;
            n2 += cvzo2._b;
        }
        return n2;
    }

    public static cvzo _c(EntityPlayer entityPlayer, int n) {
        zwyn zwyn2 = (zwyn)entityPlayer.field_71069_bz;
        for (yeso yeso2 : zwyn2.getOwnedSlots()) {
            cvzo cvzo2 = yeso2.func_75211_c();
            if (cvzo2 == null || cvzo2._d != n) continue;
            return cvzo2;
        }
        return null;
    }

    public static Iterator<cvzo> _b(EntityPlayer entityPlayer) {
        zwyn zwyn2 = (zwyn)entityPlayer.field_71069_bz;
        pidb[] pidbArray = new pidb[zwyn2.inventories.length];
        for (int i = 0; i < zwyn2.inventories.length; ++i) {
            pidbArray[i] = new pidb(zwyn2.inventories[i]);
        }
        return Iterators.concat(pidbArray);
    }

    public static boolean _a(cvzo cvzo2, cvzo cvzo3, boolean bl) {
        return ncwh._a(cvzo2, cvzo3, bl, false);
    }

    public static boolean _a(cvzo cvzo2, cvzo cvzo3, boolean bl, boolean bl2) {
        if (cvzo2 == null || cvzo3 == null) {
            return false;
        }
        if (cvzo2._d != cvzo3._d) {
            return false;
        }
        if (!bl && cvzo2._j() != -1 && cvzo3._j() != -1 && cvzo2._j() != cvzo3._j()) {
            return false;
        }
        if (cvzo2._e != null || cvzo3._e != null) {
            qoac qoac2 = cvzo2._e != null ? (qoac)cvzo2._e._c() : _c;
            qoac qoac3 = cvzo3._e != null ? (qoac)cvzo3._e._c() : _c;
            boolean bl3 = qoac2._c("owner") || qoac2._o("personal_on_get");
            boolean bl4 = qoac3._c("owner") || qoac3._o("personal_on_get");
            ncwh._a(qoac2);
            ncwh._a(qoac3);
            qoac2._a("tag");
            qoac3._a("tag");
            if (!qoac2.equals(qoac3) || !bl2 && bl3 != bl4) {
                return false;
            }
        }
        return true;
    }

    private static void _a(qoac qoac2) {
        qoac2._p("buyer");
        qoac2._p("owner");
        qoac2._p("personal_on_get");
        qoac2._p("personal_until");
        qoac2._p("u1");
        qoac2._p("u2");
        qoac2._p("src");
        qoac2._p("sm");
    }

    public static void _a(EntityPlayer entityPlayer, cvzo cvzo2) {
        if (_a == null) {
            entityPlayer.func_71035_c("\u0412\u0430\u043c \u0434\u043e\u043b\u0436\u0435\u043d \u0431\u044b\u043b \u0431\u044b\u0442\u044c \u0434\u043e\u0431\u0430\u0432\u043b\u0435\u043d \u043f\u0435\u0440\u0441\u043e\u043d\u0430\u043b\u044c\u043d\u044b\u0439 \u043f\u0440\u0435\u0434\u043c\u0435\u0442 " + cvzo2._s() + ", \u043d\u043e \u0432 \u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u0435 \u043d\u0435\u0442 \u043c\u0435\u0441\u0442\u0430. \u041e\u0431\u0440\u0430\u0442\u0438\u0442\u0435\u0441\u044c \u043a \u0430\u0434\u043c\u0438\u043d\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u0438.");
            Logger.warning("Destroyed personal item " + cvzo2 + " with owner " + entityPlayer.field_71092_bJ, new Object[0]);
        } else {
            _a._a(entityPlayer, cvzo2);
        }
    }

    public static void _b(EntityPlayer entityPlayer, cvzo cvzo2) {
        if (!entityPlayer.field_71075_bZ._d) {
            ncwh._a(entityPlayer.field_71092_bJ, cvzo2);
        }
    }

    public static void _a(String string, cvzo cvzo2) {
        if (cvzo2._e != null && cvzo2._e._o("personal_on_get")) {
            gloomyfolken.mods.core.misc.pidb._a(cvzo2, string);
        }
    }

    public static qoac _b(cvzo cvzo2) {
        if (!cvzo2._p()) {
            cvzo2._d(new qoac());
        }
        return cvzo2._q();
    }

    public static qoac _c(cvzo cvzo2) {
        if (!cvzo2._p()) {
            return new qoac();
        }
        return cvzo2._q();
    }

    public static qoac _c(EntityPlayer entityPlayer) {
        qoac qoac2 = entityPlayer.getEntityData();
        if (!qoac2._c("PlayerPersisted")) {
            qoac2._a("PlayerPersisted", (huhy)new qoac());
        }
        return qoac2._m("PlayerPersisted");
    }

    public static boolean _a(cvzo cvzo2, EntityPlayer entityPlayer) {
        int n;
        cvzo cvzo3 = entityPlayer.field_71071_by._g();
        if (cvzo3 == null) {
            return true;
        }
        return ncwh._a(cvzo3, cvzo2, false) && (n = cvzo2._b) > 0 && n + cvzo3._b <= cvzo3._d();
    }

    public static boolean _b(cvzo cvzo2, EntityPlayer entityPlayer) {
        int n;
        if (!ncwh._a(cvzo2, entityPlayer)) {
            return false;
        }
        ncwh._b(entityPlayer, cvzo2);
        cvzo cvzo3 = entityPlayer.field_71071_by._g();
        if (cvzo3 == null) {
            entityPlayer.field_71071_by._d(cvzo2);
        } else if (ncwh._a(cvzo3, cvzo2, false) && (n = cvzo2._b) > 0 && n + cvzo3._b <= cvzo3._d()) {
            cvzo3._b += n;
        }
        return true;
    }

    public static boolean _a(String string) {
        return dzfd._I().__ag()._g(string);
    }

    public static Entity _a(ozlu ozlu2, UUID uUID) {
        for (Object e : ozlu2.field_72996_f) {
            if (!(e instanceof Entity) || !((Entity)e).getPersistentID().equals(uUID)) continue;
            return (Entity)e;
        }
        return null;
    }

    static {
        _b = new GsonBuilder().registerTypeAdapter((Type)((Object)qoac.class), new anbv()).create();
        _c = new qoac("tag");
    }

    public static interface kjui {
        public void _a(EntityPlayer var1, cvzo var2);
    }

    public static class pidb
    implements Iterator<cvzo> {
        private final mssh _a;
        private int _b = 0;

        public pidb(mssh mssh2) {
            this._a = mssh2;
        }

        @Override
        public boolean hasNext() {
            return this._b < this._a.func_70302_i_();
        }

        public cvzo _a() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            return this._a.func_70301_a(this._b++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Can not remove slot from inventory!");
        }

        @Override
        public /* synthetic */ Object next() {
            return this._a();
        }
    }
}

