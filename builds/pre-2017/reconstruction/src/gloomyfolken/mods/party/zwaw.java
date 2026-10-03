/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.party;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import java.lang.invoke.LambdaMetafactory;
import net.minecraft.entity.player.EntityPlayer;

public class zwaw
extends tehy {
    public static final String _a = "party";
    public ofgy _b;

    public zwaw(ccxr ccxr2) {
        super(ccxr2);
    }

    @Override
    public void resetHandler() {
        if (!this.player.worldObj.isRemote) {
            InvokeSideOnly.frontend((InvokeSideOnly.InvokeFrontendOnly)LambdaMetafactory.metafactory(null, null, null, ()V, initServer(), ()V)((zwaw)this));
        }
    }

    @Override
    public void tick() {
    }

    public static zwaw _a(EntityPlayer entityPlayer) {
        return (zwaw)ncwh._a((EntityPlayer)entityPlayer)._h.get(_a);
    }

    public boolean _a() {
        return this._b != null && this._b._a().equals(this.player.username);
    }
}

