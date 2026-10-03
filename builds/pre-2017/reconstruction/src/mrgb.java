/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import gloomyfolken.mods.stalker.misc.tupg;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class mrgb
extends ItemFood {
    public mrgb(int n) {
        super(n - 256, 0, false);
        this.setCreativeTab(GloomyCore.tab);
        this.setUnlocalizedName("vodka");
        LanguageRegistry.addName(this, "\u0412\u043e\u0434\u043a\u0430");
    }

    @Override
    public int getMaxItemUseDuration(ItemStack itemStack) {
        return 32;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack itemStack) {
        return EnumAction._c;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        entityPlayer.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        return itemStack;
    }

    @Override
    public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (!entityPlayer.capabilities._d) {
            --itemStack._b;
        }
        if (!world.isRemote) {
            tupg._a((EntityPlayer)entityPlayer)._b._b()._b(-20.0f);
            entityPlayer.addPotionEffect(new PotionEffect(9, 400));
        }
        ncwh._a(entityPlayer)._a(StalkerMiscMod._C)._e();
        return itemStack._b <= 0 ? new ItemStack(StalkerMiscMod.__ao) : itemStack;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void registerIcons(IconRegister iconRegister) {
        this.itemIcon = iconRegister._b("stalker:vodka");
    }
}

