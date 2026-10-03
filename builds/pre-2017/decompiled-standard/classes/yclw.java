/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anomaly.kjui;
import gloomyfolken.mods.anomaly.pidb;
import gloomyfolken.mods.core.misc.ezey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;

public class yclw
extends royz {
    private HashMap<EntityPlayer, Integer> _c = new HashMap(1);
    private String _d = "anomalies:coach_active";
    private String _e;

    public void _a(EntityPlayer entityPlayer) {
        if (!this._c.containsKey(entityPlayer)) {
            this._c.put(entityPlayer, 0);
        }
    }

    public void _b(EntityPlayer entityPlayer) {
        this._c.remove(entityPlayer);
    }

    @Override
    public void func_70316_g() {
        block5: {
            block3: {
                jzqf jzqf2;
                block4: {
                    super.func_70316_g();
                    if (!this.field_70331_k.field_72995_K) break block3;
                    boolean bl = this._c.size() > 0;
                    jzqf2 = xpzm._E()._N;
                    if (!bl || this._e != null && jzqf2._c.playing(this._e)) break block4;
                    this._e = "sound_" + (jzqf2._h + 1) % 256;
                    this.field_70331_k.func_72980_b((float)this.field_70329_l + 0.5f, (float)this.field_70330_m + 0.5f, (float)this.field_70327_n + 0.5f, this._d, 1.0f, 1.0f, false);
                    break block5;
                }
                if (this._e == null || !jzqf2._c.playing(this._e)) break block5;
                jzqf2._c.stop(this._e);
                break block5;
            }
            Iterator<Map.Entry<EntityPlayer, Integer>> iterator2 = this._c.entrySet().iterator();
            while (iterator2.hasNext()) {
                Map.Entry<EntityPlayer, Integer> entry = iterator2.next();
                entry.setValue(Math.max(0, entry.getValue() - 1));
                if (entry.getKey().field_70128_L || entry.getKey().field_70170_p != this.field_70331_k) {
                    iterator2.remove();
                    continue;
                }
                double d = Math.sqrt(this.func_70318_a(entry.getKey().field_70165_t, entry.getKey().field_70163_u, entry.getKey().field_70161_v));
                if (d > 50.0) {
                    iterator2.remove();
                    continue;
                }
                if (!(d > 5.0) || entry.getValue() >= 1) continue;
                ezey._a(entry.getKey(), pidb._c, kjui._q._d, true);
                int n = 10 - (int)(d / 5.0);
                entry.setValue(5 + n);
            }
        }
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

    @Override
    protected Class<? extends iekw> _d() {
        return null;
    }
}

