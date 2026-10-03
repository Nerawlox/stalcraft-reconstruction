/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import gloomyfolken.mods.stalker.misc.tupg;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class brdq
implements ofux {
    public static final long _a = 151L;
    private long _b = 0L;

    private boolean _a() {
        return StalkerMiscMod.instance.__au.value == 0;
    }

    @Override
    public void onKeyDownRepeat() {
        if (System.currentTimeMillis() - this._b > 151L && this._a()) {
            Minecraft minecraft = Minecraft._E();
            minecraft._a(new oxlc(minecraft._t));
        }
    }

    @Override
    public void onKeyDown() {
        if (!this._a()) {
            Minecraft minecraft = Minecraft._E();
            minecraft._a(new xadg(minecraft._t));
        } else {
            this._b = System.currentTimeMillis();
        }
    }

    @Override
    public void onKeyUp() {
        if (System.currentTimeMillis() - this._b <= 151L && this._a()) {
            this._b();
        }
    }

    private void _b() {
        ydir ydir2 = tupg._a((EntityPlayer)Minecraft._E()._t)._c;
        for (int i = 0; i < 4; ++i) {
            int n = 8 + i;
            if (ydir2._a[n] == null) continue;
            boolean bl = StalkerMiscMod.instance.__at.enabled;
            new numa((byte)n, bl).sendToServer();
            break;
        }
    }
}

