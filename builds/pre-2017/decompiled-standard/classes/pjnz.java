/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.misc.kjui;
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import gloomyfolken.mods.stalker.misc.tupg;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ezfc;

public class pjnz
extends brhe {
    public pjnz(int n, String string, String string2, List<String> list2, int n2, int n3, int n4, float f, xafi xafi2, pjov pjov2, String string3, String string4) {
        super(n, string, string2, list2, n2, n3, n4, f, xafi2, pjov2, string3, string4);
    }

    @Override
    public kjui.kjui _c(cvzo cvzo2) {
        return kjui.kjui._a;
    }

    @Override
    public void _a(cvzo cvzo2, EntityPlayer entityPlayer, List<String> list2) {
        qoac qoac2;
        qoac qoac3 = qoac2 = cvzo2._p() ? cvzo2._q()._m("TradeData") : null;
        if (qoac2 != null) {
            String string = qoac2._j("OriginalOwner");
            boolean bl = qoac2._o("Bought");
            String string2 = qoac2._j("Location");
            String string3 = StalkerMiscMod._W.getOrDefault(string2, string2);
            list2.add((Object)((Object)ezfc._c) + (bl ? "\u041a\u0443\u043f\u0438\u043b: " : "\u0418\u0437\u0433\u043e\u0442\u043e\u0432\u0438\u043b: ") + string);
            list2.add((Object)((Object)ezfc._c) + "\u041d\u0430\u0447\u0430\u043b\u044c\u043d\u0430\u044f \u0441\u0442\u043e\u0438\u043c\u043e\u0441\u0442\u044c: " + qoac2._f("BaseCost"));
            list2.add((Object)((Object)ezfc._c) + (bl ? "\u041a\u0443\u043f\u043b\u0435\u043d\u043e " : "\u0421\u043e\u0437\u0434\u0430\u043d\u043e ") + "\u043d\u0430 \u043b\u043e\u043a\u0430\u0446\u0438\u0438: " + string3);
            list2.add("");
        }
        super._a(cvzo2, entityPlayer, list2);
    }

    public static void _a(cvzo cvzo2, EntityPlayer entityPlayer, String string, int n, boolean bl) {
        long l = System.currentTimeMillis();
        if (!cvzo2._p()) {
            cvzo2._d(new qoac());
        }
        qoac qoac2 = cvzo2._q();
        qoac qoac3 = new qoac();
        qoac3._a("OriginalOwner", entityPlayer.field_71092_bJ);
        qoac3._a("Time", l);
        qoac3._a("Location", string);
        qoac3._a("BaseCost", n);
        qoac3._a("Bought", bl);
        qoac3._a("X", (float)entityPlayer.field_70165_t);
        qoac3._a("Y", (float)entityPlayer.field_70163_u);
        qoac3._a("Z", (float)entityPlayer.field_70161_v);
        qoac2._a("TradeData", qoac3);
    }

    public static void _a(EntityPlayer entityPlayer, cvzo cvzo2) {
        if (entityPlayer.field_70170_p.field_72995_K) {
            return;
        }
        InvokeSideOnly.frontend(() -> {});
    }

    public static void _a(EntityPlayer entityPlayer, boolean bl) {
        if (entityPlayer.field_70170_p.field_72995_K) {
            return;
        }
        ydir ydir2 = tupg._a((EntityPlayer)entityPlayer)._c;
        cvzo cvzo2 = ydir2._e();
        if (cvzo2 != null && cvzo2._a() instanceof pjnz) {
            qoac qoac2;
            if (bl && (qoac2 = cvzo2._q()) != null && qoac2._c("TradeData")) {
                qoac2._m("TradeData")._a("LostOnDeath", true);
            }
            ydir2._c(null);
            entityPlayer.func_71019_a(cvzo2, true);
        }
    }
}

