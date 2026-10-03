/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.stalker.clans.pidb;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import mods.pda.client.map.MapInitEvent;
import mods.pda.client.screens.GuiPda;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraftforge.event.ForgeSubscribe;
import org.apache.commons.lang3.tuple.Pair;
import org.lwjgl.opengl.GL11;

public class yuch
implements nttf {
    public static kkzc _a;
    public static qmkx _b;
    public static pidb _c;
    public static int _d;
    public jhwa _e = new jhwa();
    public static long _f;
    public static boolean _g;
    public static Queue<Pair<Integer, Boolean>> _h;
    private Map<Integer, Boolean> _i = new HashMap<Integer, Boolean>();

    @Override
    public void onGameJoined() {
        _a = new kkzc();
        _b = new qmkx();
        _c = null;
    }

    @Override
    public void onTickInGame() {
        _b._b();
        EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
        if (_c != null && entityClientPlayerMP != null) {
            List<pidb.tupg> list2 = _c._g();
            if (_d >= 0 && _d < list2.size() && !list2.get(_d)._a(entityClientPlayerMP)) {
                _d = -1;
            }
            if (_d < 0) {
                _d = this._a(list2);
            }
            this._b();
        }
    }

    private int _a(List<pidb.tupg> list2) {
        for (int i = 0; i < list2.size(); ++i) {
            pidb.pidb pidb2;
            pidb.tupg tupg2 = list2.get(i);
            if (!(tupg2 instanceof pidb.ezey) || (pidb2 = ((pidb.ezey)tupg2)._b()) == null || !pidb2._b().equals(yuch._a._a)) continue;
            return i;
        }
        return -1;
    }

    private void _b() {
        String string = yuch._a._a;
        for (int i = 0; i < _c._f().size(); ++i) {
            boolean bl;
            boolean bl2 = this._i.getOrDefault(i, false);
            pidb.eidj eidj2 = _c._f().get(i);
            boolean bl3 = bl = eidj2._b() && eidj2._a() != null && string.equals(eidj2._a()._b());
            if (bl2 && !bl) {
                _h.add(Pair.of(i, false));
            } else if (!bl2 && bl) {
                _h.add(Pair.of(i, true));
            }
            this._i.put(i, bl);
        }
    }

    public static void _a() {
        if (xpzm._E()._B instanceof jzpo) {
            return;
        }
        if (xpzm._E()._B instanceof GuiPda) {
            GuiPda guiPda = (GuiPda)xpzm._E()._B;
            if (guiPda.currentTab instanceof pjlq && yuch._a._a != null) {
                if (yuch._a._a.equals("")) {
                    guiPda.openTab(new dxjw(guiPda));
                } else {
                    guiPda.openTab(new mack(guiPda));
                }
            }
        }
    }

    @ForgeSubscribe
    public void _a(MapInitEvent mapInitEvent) {
        mapInitEvent.canvas.addObjectRenderer(this._e);
    }

    public static void _a(float f, float f2, float f3, int n, int n2, int n3, int n4, int n5, int n6, int n7, float f4) {
        float f5 = 0.5f;
        GL11.glEnable(3042);
        xpzm._E()._R()._a(hbqf._a);
        GL11.glColor4f((float)(n2 >> 16 & 0xFF) / 255.0f, (float)(n2 >> 8 & 0xFF) / 255.0f, (float)(n2 & 0xFF) / 255.0f, (float)(n2 >> 24 & 0xFF) / 255.0f);
        if (f3 > 0.0f && f3 < 1.0f) {
            htvf htvf2 = htvf.field_78398_a;
            htvf2.func_78371_b(6);
            float f6 = 0.001953125f;
            htvf2.func_78374_a(f * f5, f2 * f5, 0.0, (float)(n3 + n7 / 2) * f6, (float)(n4 + n7 / 2) * f6);
            double d = 4.71238898038469;
            double d2 = Math.PI * 2 * (double)f3;
            float f7 = 20.0f;
            double d3 = d2 / (double)(f7 - 1.0f);
            double d4 = d;
            int n8 = 0;
            while ((float)n8 < f7) {
                double d5 = Math.cos(d4);
                double d6 = Math.sin(d4);
                htvf2.func_78374_a(((double)f + d5 * (double)(f4 / 2.0f)) * (double)f5, ((double)f2 + d6 * (double)(f4 / 2.0f)) * (double)f5, 0.0, ((double)(n3 + n7 / 2) + d5 * (double)(n7 / 2)) * (double)f6, ((double)(n4 + n7 / 2) + d6 * (double)(n7 / 2)) * (double)f6);
                d4 -= d3;
                ++n8;
            }
            htvf2.func_78381_a();
        } else if (f3 == 1.0f) {
            qozx._a((f - f4 / 2.0f) * f5, (f2 - f4 / 2.0f) * f5, f4 * f5, f4 * f5, n3, n4, n3 + n7, n4 + n7, 512.0, 512.0);
        }
        GL11.glColor4f((float)(n >> 16 & 0xFF) / 255.0f, (float)(n >> 8 & 0xFF) / 255.0f, (float)(n & 0xFF) / 255.0f, (float)(n >> 24 & 0xFF) / 255.0f);
        qozx._a((f - f4 / 2.0f) * f5, (f2 - f4 / 2.0f) * f5, f4 * f5, f4 * f5, n5, n6, n5 + n7, n6 + n7, 512.0, 512.0);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

    static {
        _d = -1;
        _f = 0L;
        _g = false;
        _h = new LinkedList<Pair<Integer, Boolean>>();
    }
}

