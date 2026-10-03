/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.screens.GuiPlayerInteract;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;

public class ntsz {
    @ForgeSubscribe
    public void _a(piyh piyh2) {
        if (piyh2._a._i instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)piyh2._a._i;
            xpzm._E()._a(new GuiPlayerInteract(entityPlayer));
        }
    }
}

