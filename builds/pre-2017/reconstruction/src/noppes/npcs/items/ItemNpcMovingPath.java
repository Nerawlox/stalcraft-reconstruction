/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import noppes.npcs.CustomItems;
import noppes.npcs.CustomNpcs;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.constants.EnumGuiType;

public class ItemNpcMovingPath
extends Item {
    public ItemNpcMovingPath(int n) {
        super(n - 26700 + CustomNpcs.ItemStartId);
        this.maxStackSize = 1;
        this.setCreativeTab(CustomItems.tab);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        EntityNPCInterface entityNPCInterface = this.getNpc(itemStack, world);
        if (entityNPCInterface != null) {
            NoppesUtilServer.sendOpenGui(entityPlayer, EnumGuiType.MovingPath, entityNPCInterface);
        }
        return itemStack;
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        EntityNPCInterface entityNPCInterface = this.getNpc(itemStack, world);
        if (entityNPCInterface == null) {
            return true;
        }
        List list2 = entityNPCInterface.aiData.getMovingPath();
        list2.add(new int[]{n, n2, n3});
        entityPlayer.addChatMessage("Added point x:" + n + " y:" + n2 + " z:" + n3 + " to npc " + entityNPCInterface.getEntityName());
        return true;
    }

    private EntityNPCInterface getNpc(ItemStack itemStack, World world) {
        if (!world.isRemote && itemStack._e != null) {
            Entity entity = world.getEntityByID(itemStack._e._f("NPCID"));
            return entity != null && entity instanceof EntityNPCInterface ? (EntityNPCInterface)entity : null;
        }
        return null;
    }

    @Override
    public int getColorFromItemStack(ItemStack itemStack, int n) {
        return 9127187;
    }

    @Override
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.itemIcon = Item.swordIron.getIconFromDamage(0);
    }

    @Override
    public Item setUnlocalizedName(String string) {
        GameRegistry.registerItem(this, string);
        return super.setUnlocalizedName(string);
    }
}

