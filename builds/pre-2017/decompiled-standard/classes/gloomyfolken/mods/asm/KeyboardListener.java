/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.asm;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.ClientProxy;
import gloomyfolken.mods.core.main.GloomyCore;
import mods.regions.RegionsMod;
import mods.regions.client.RegionsGameHandler;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;

@ezey(_a={eidj.CLIENT})
public class KeyboardListener {
    public static boolean _a;

    public static void listen() {
        xpzm xpzm2 = xpzm._E();
        if (xpzm2._B != null && !xpzm2._B.field_73885_j) {
            return;
        }
        if (xpzm2._B != null) {
            xpzm2._B.func_73862_m();
        }
        while (Keyboard.next()) {
            int n;
            net.minecraft.client.settings.eidj._a(Keyboard.getEventKey(), Keyboard.getEventKeyState());
            if (Keyboard.getEventKeyState()) {
                net.minecraft.client.settings.eidj._a(Keyboard.getEventKey());
            }
            if (!Keyboard.getEventKeyState()) continue;
            if (Keyboard.getEventKey() == 87) {
                xpzm2._r();
                continue;
            }
            if (xpzm2._B != null) {
                xpzm2._B.func_73860_n();
                continue;
            }
            if (Keyboard.getEventKey() == 1) {
                xpzm2._q();
            }
            if (Keyboard.getEventKey() == 31 && Keyboard.isKeyDown(61)) {
                xpzm2._c();
            }
            if (Keyboard.getEventKey() == 20 && Keyboard.isKeyDown(61)) {
                xpzm2._c();
            }
            if (Keyboard.getEventKey() == 45 && Keyboard.isKeyDown(61)) {
                GloomyCore.instance.itemsLoader._e();
            }
            if (Keyboard.getEventKey() == 35 && Keyboard.isKeyDown(61)) {
                xpzm2._M.field_82882_x = !xpzm2._M.field_82882_x;
                xpzm2._M.func_74303_b();
            }
            if (Keyboard.getEventKey() == 48 && Keyboard.isKeyDown(61) && xpzm2._t.field_71075_bZ._d) {
                boolean bl = gqqu._r = !gqqu._r;
            }
            if (Keyboard.getEventKey() == 25 && Keyboard.isKeyDown(61)) {
                xpzm2._M.field_82881_y = !xpzm2._M.field_82881_y;
                xpzm2._M.func_74303_b();
            }
            if (Keyboard.getEventKey() == 59) {
                xpzm2._M.field_74319_N = !xpzm2._M.field_74319_N;
                boolean bl = _a = !Keyboard.isKeyDown(29);
            }
            if (Keyboard.getEventKey() == 61) {
                xpzm2._M.field_74330_P = !xpzm2._M.field_74330_P;
                xpzm2._M.field_74329_Q = gqjz.func_73877_p();
            }
            if (Keyboard.getEventKey() == 63) {
                ++xpzm2._M.field_74320_O;
                if (xpzm2._M.field_74320_O > 2) {
                    xpzm2._M.field_74320_O = 0;
                }
            }
            if (Keyboard.getEventKey() == 66) {
                xpzm2._M.field_74326_T = !xpzm2._M.field_74326_T;
            }
            for (n = 0; n < GloomyCore.instance.containerFactory._b(); ++n) {
                if (Keyboard.getEventKey() != 2 + n || MinecraftForge.EVENT_BUS.post(new anrg(xpzm2._t.field_71071_by._c, n, true))) continue;
                xpzm2._t.field_71071_by._c = n;
            }
            if (xpzm2._M.field_74330_P && xpzm2._M.field_74329_Q) {
                if (Keyboard.getEventKey() == 11) {
                    xpzm2._a(0);
                }
                for (n = 0; n < 9; ++n) {
                    if (Keyboard.getEventKey() != 2 + n) continue;
                    xpzm2._a(n + 1);
                }
            }
            EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
            boolean bl = Keyboard.isKeyDown(42);
            boolean bl2 = Keyboard.isKeyDown(29);
            if (!entityClientPlayerMP.field_71075_bZ._d || !bl2 || Keyboard.getEventKey() != 46) continue;
            String string = null;
            if (bl) {
                RegionsGameHandler regionsGameHandler = RegionsMod.regionsClient;
                if (regionsGameHandler.min != null && regionsGameHandler.max != null) {
                    einh einh2 = regionsGameHandler.min;
                    einh einh3 = regionsGameHandler.max;
                    string = einh2._c() + ", " + einh2._d() + ", " + einh2._e() + ", " + einh3._c() + ", " + einh3._d() + ", " + einh3._e();
                }
            } else {
                int n2 = (int)entityClientPlayerMP.field_70165_t;
                int n3 = (int)entityClientPlayerMP.field_70121_D._c;
                int n4 = (int)entityClientPlayerMP.field_70161_v;
                string = n2 + ".5, " + n3 + ", " + n4 + ".5";
            }
            if (string == null) continue;
            ClientProxy.publishScreenCenterMessage(new ntsy("\u0421\u043a\u043e\u043f\u0438\u0440\u043e\u0432\u0430\u043d\u043e: " + string, -1, 30));
            gqjz.func_73865_d(string);
        }
    }
}

