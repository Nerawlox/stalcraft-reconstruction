/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.mcsa.kjui;
import java.util.HashMap;
import net.minecraft.entity.player.EntityPlayer;

public class tewl
extends iefv {
    private static HashMap<dgmz, tewl> _a = new HashMap();
    private static final String _b = "/assets/stalker/models/armor/";
    private iefv _c;
    private dgmz _i;

    public static tewl _a(dgmz dgmz2) {
        return _a.get(dgmz2);
    }

    public static tewl _a(EntityPlayer entityPlayer) {
        return tewl._a(entityPlayer, 2);
    }

    public static tewl _a(EntityPlayer entityPlayer, int n) {
        if (entityPlayer.func_82169_q(n) != null && entityPlayer.func_82169_q(n)._a() instanceof dgmz) {
            dgmz dgmz2 = (dgmz)entityPlayer.func_82169_q(n)._a();
            return tewl._a(dgmz2);
        }
        return null;
    }

    public tewl(dgmz dgmz2) {
        super(_b, dgmz2._d, dgmz2._e);
        this._i = dgmz2;
        if (dgmz2._f != null) {
            boolean bl = false;
            String string = dgmz2._g;
            if (string == null) {
                string = dgmz2._e == null ? dgmz2._d.replace(".mcsa", ".mcmtl") : dgmz2._e;
            } else {
                bl = true;
            }
            this._c = new iefv(_b, dgmz2._f, string, bl ? "_hands" : "");
        }
    }

    public void _a() {
        _a.put(this._i, this);
    }

    public void _a(cvzo cvzo2, cucv cucv2) {
        dgmz dgmz2 = (dgmz)cvzo2._a();
        kjui kjui2 = this._a(dgmz2._i_(cvzo2));
        kjui2._c.renderAll(cucv2);
    }

    public void _a(cvzo cvzo2, zxbe zxbe2) {
        if (this._c != null) {
            dgmz dgmz2 = (dgmz)cvzo2._a();
            kjui kjui2 = this._c._a(dgmz2._i_(cvzo2));
            kjui2._c.renderAll(zxbe2);
        }
    }
}

