/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public interface IGuiHandler {
    public Object getServerGuiElement(int var1, EntityPlayer var2, World var3, int var4, int var5, int var6);

    public Object getClientGuiElement(int var1, EntityPlayer var2, World var3, int var4, int var5, int var6);
}

