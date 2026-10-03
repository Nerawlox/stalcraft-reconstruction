/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.anomaly;

import cpw.mods.fml.common.FMLCommonHandler;
import gloomyfolken.mods.anomaly.AnomalyMod;
import gloomyfolken.mods.anomaly.zwat;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import net.minecraft.entity.player.EntityPlayer;

public class ezey
extends tehy {
    private static final long _f = TimeUnit.SECONDS.toMillis(10L);
    public static final String _a = "anomaly";
    private boolean _g = false;
    private boolean _h = false;
    public boolean _b = false;
    private long _i = -1L;
    private long _j = -1L;
    public boolean _c = false;
    public boolean _d = false;
    public ArrayList<zwat> _e = new ArrayList();

    public ezey(ccxr ccxr2) {
        super(ccxr2);
    }

    @Override
    public void tick() {
        if (FMLCommonHandler.instance().getEffectiveSide().isClient()) {
            return;
        }
        long l = System.currentTimeMillis();
        if (!this._g) {
            this._a(l);
        }
        if (!this._h) {
            this._b(l);
        }
    }

    private void _a(long l) {
        if (this._c && this._i == -1L) {
            this._i = l;
        } else if (this._c && l - this._i > _f) {
            this.playerInfo._a(AnomalyMod._x)._e();
            this._g = true;
        } else if (!this._c) {
            this._i = -1L;
        }
        this._c = false;
    }

    private void _b(long l) {
        if (this._d && this._j == -1L) {
            this._j = l;
        } else if (this._d && l - this._j > _f) {
            this.playerInfo._a(AnomalyMod._y)._e();
            this._h = true;
        } else if (!this._d) {
            this._j = -1L;
        }
        this._d = false;
    }

    @Override
    public void resetHandler() {
        this._e.clear();
    }

    public static ezey _a(EntityPlayer entityPlayer) {
        return (ezey)ncwh._a((EntityPlayer)entityPlayer)._h.get(_a);
    }
}

