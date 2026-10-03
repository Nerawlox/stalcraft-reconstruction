/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import gloomyfolken.mods.stalker.misc.tupg;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;

public class zxky
implements ofux {
    private int _a;

    public zxky(int n) {
        this._a = n;
    }

    @Override
    public void onKeyDown() {
        xpzm xpzm2 = xpzm._E();
        EntityClientPlayerMP entityClientPlayerMP = xpzm2._t;
        cvzo[] cvzoArray = tupg._a((EntityPlayer)entityClientPlayerMP)._c._a;
        if (cvzoArray[this._a + 8] != null) {
            boolean bl = StalkerMiscMod.instance.__at.enabled;
            new numa((byte)(this._a + 8), bl).sendToServer();
        }
    }
}

