/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import noppes.npcs.CustomNpcs;
import noppes.npcs.controllers.PlayerData;

public class ItemSquadController
extends Item {
    public ItemSquadController(int n) {
        super(n - 26700 + CustomNpcs.ItemStartId);
        this.maxStackSize = 1;
    }

    @Override
    public int getColorFromItemStack(ItemStack itemStack, int n) {
        return -256;
    }

    @Override
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    @Override
    public boolean onItemUseFirst(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (!world.isRemote) {
            PlayerData playerData = PlayerData.getData(entityPlayer);
            if (playerData.targetNpcUUID != null) {
                playerData.targetNpcUUID = null;
                entityPlayer.addChatMessage((Object)((Object)EnumChatFormatting._l) + "\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u043d\u044b\u0439 \u043d\u043f\u0441 \u0443\u0434\u0430\u043b\u0435\u043d");
            }
            return true;
        }
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.itemIcon = Item.axeGold.getIconFromDamage(0);
    }
}

