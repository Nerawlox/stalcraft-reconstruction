/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import gloomyfolken.mods.stalker.misc.tupg;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class zxky
implements ofux {
    private int _a;

    public zxky(int n) {
        this._a = n;
    }

    @Override
    public void onKeyDown() {
        Minecraft minecraft = Minecraft._E();
        EntityClientPlayerMP entityClientPlayerMP = minecraft._t;
        ItemStack[] itemStackArray = tupg._a((EntityPlayer)entityClientPlayerMP)._c._a;
        if (itemStackArray[this._a + 8] != null) {
            boolean bl = StalkerMiscMod.instance.__at.enabled;
            new numa((byte)(this._a + 8), bl).sendToServer();
        }
    }
}

