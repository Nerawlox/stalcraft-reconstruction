/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.sajh;

public class hupu
extends gamb {
    public hupu(String string) {
        super(string);
    }

    @Override
    public int _a(List list) {
        float f = 0.0f;
        for (EntityPlayer entityPlayer : list) {
            f += entityPlayer.func_110143_aJ() + entityPlayer.func_110139_bj();
        }
        if (list.size() > 0) {
            f /= (float)list.size();
        }
        return sajh._f(f);
    }

    @Override
    public boolean _b() {
        return true;
    }
}

