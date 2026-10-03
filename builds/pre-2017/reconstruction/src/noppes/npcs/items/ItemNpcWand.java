/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.jgro;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import noppes.npcs.CustomItems;
import noppes.npcs.CustomNpcs;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.constants.EnumGuiType;
import noppes.npcs.entity.EntityNPCHumanMale;
import noppes.npcs.permissions.CustomNpcsPermissions;

public class ItemNpcWand
extends Item {
    public ItemNpcWand(int n) {
        super(n - 26700 + CustomNpcs.ItemStartId);
        this.maxStackSize = 1;
        this.setCreativeTab(CustomItems.tab);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (!world.isRemote) {
            return itemStack;
        }
        CustomNpcs.proxy.openGui((EntityNPCInterface)null, EnumGuiType.NpcRemote);
        return itemStack;
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (world.isRemote) {
            return true;
        }
        if (CustomNpcs.OpsOnly && !MinecraftServer._I().__ag()._p().contains(entityPlayer.username.toLowerCase())) {
            MinecraftServer._I()._c(entityPlayer.username + ": tried to use custom npcs without being an op");
        } else if (CustomNpcsPermissions.Instance.hasPermission(entityPlayer.username, "customnpcs.npc.create")) {
            EntityNPCHumanMale entityNPCHumanMale = (EntityNPCHumanMale)jgro._a("npchumanmale", world);
            entityNPCHumanMale.startPos = new int[]{n, n2, n3};
            entityNPCHumanMale.setLocationAndAngles((float)n + 0.5f, entityNPCHumanMale.getStartYPos(), (float)n3 + 0.5f, entityPlayer.rotationYaw, entityPlayer.rotationPitch);
            entityNPCHumanMale.status.onCreation(entityPlayer);
            entityNPCHumanMale.shuffleEquipment();
            world.spawnEntityInWorld(entityNPCHumanMale);
            entityNPCHumanMale.setHealth(entityNPCHumanMale.getMaxHealth());
            CustomNpcs.npcsLog.info(entityPlayer.username + " created npc with name " + entityNPCHumanMale.display.name + " at (" + entityNPCHumanMale.posX + ", " + entityNPCHumanMale.posY + ", " + entityNPCHumanMale.posZ + ")");
            NoppesUtilServer.sendOpenGui(entityPlayer, EnumGuiType.MainMenuDisplay, entityNPCHumanMale);
        }
        return true;
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
        this.itemIcon = Item.hoeIron.getIconFromDamage(0);
    }

    @Override
    public Item setUnlocalizedName(String string) {
        GameRegistry.registerItem(this, string);
        return super.setUnlocalizedName(string);
    }
}

