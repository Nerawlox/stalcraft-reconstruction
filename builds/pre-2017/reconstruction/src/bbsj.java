/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class bbsj
extends Item {
    public bbsj(int n) {
        super(n);
        this.setMaxStackSize(1);
        this.setMaxDamage(238);
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, int n, int n2, int n3, int n4, EntityLivingBase entityLivingBase) {
        if (n != Block.leaves.blockID && n != Block.web.blockID && n != Block.tallGrass.blockID && n != Block.vine.blockID && n != Block.tripWire.blockID && !(Block.blocksList[n] instanceof IShearable)) {
            return super.onBlockDestroyed(itemStack, world, n, n2, n3, n4, entityLivingBase);
        }
        return true;
    }

    @Override
    public boolean canHarvestBlock(Block block) {
        return block.blockID == Block.web.blockID || block.blockID == Block.redstoneWire.blockID || block.blockID == Block.tripWire.blockID;
    }

    @Override
    public float getStrVsBlock(ItemStack itemStack, Block block) {
        return block.blockID != Block.web.blockID && block.blockID != Block.leaves.blockID ? (block.blockID == Block.cloth.blockID ? 5.0f : super.getStrVsBlock(itemStack, block)) : 15.0f;
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer entityPlayer, EntityLivingBase entityLivingBase) {
        if (entityLivingBase.worldObj.isRemote) {
            return false;
        }
        if (entityLivingBase instanceof IShearable) {
            IShearable iShearable = (IShearable)((Object)entityLivingBase);
            if (iShearable.isShearable(itemStack, entityLivingBase.worldObj, (int)entityLivingBase.posX, (int)entityLivingBase.posY, (int)entityLivingBase.posZ)) {
                ArrayList<ItemStack> arrayList = iShearable.onSheared(itemStack, entityLivingBase.worldObj, (int)entityLivingBase.posX, (int)entityLivingBase.posY, (int)entityLivingBase.posZ, zhty._a(Enchantment._t._y, itemStack));
                Random random = new Random();
                for (ItemStack itemStack2 : arrayList) {
                    EntityItem entityItem = entityLivingBase.entityDropItem(itemStack2, 1.0f);
                    entityItem.motionY += (double)(random.nextFloat() * 0.05f);
                    entityItem.motionX += (double)((random.nextFloat() - random.nextFloat()) * 0.1f);
                    entityItem.motionZ += (double)((random.nextFloat() - random.nextFloat()) * 0.1f);
                }
                itemStack._a(1, entityLivingBase);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemStack, int n, int n2, int n3, EntityPlayer entityPlayer) {
        IShearable iShearable;
        if (entityPlayer.worldObj.isRemote) {
            return false;
        }
        int n4 = entityPlayer.worldObj.getBlockId(n, n2, n3);
        if (Block.blocksList[n4] instanceof IShearable && (iShearable = (IShearable)((Object)Block.blocksList[n4])).isShearable(itemStack, entityPlayer.worldObj, n, n2, n3)) {
            ArrayList<ItemStack> arrayList = iShearable.onSheared(itemStack, entityPlayer.worldObj, n, n2, n3, zhty._a(Enchantment._t._y, itemStack));
            Random random = new Random();
            for (ItemStack itemStack2 : arrayList) {
                float f = 0.7f;
                double d = (double)(random.nextFloat() * f) + (double)(1.0f - f) * 0.5;
                double d2 = (double)(random.nextFloat() * f) + (double)(1.0f - f) * 0.5;
                double d3 = (double)(random.nextFloat() * f) + (double)(1.0f - f) * 0.5;
                EntityItem entityItem = new EntityItem(entityPlayer.worldObj, (double)n + d, (double)n2 + d2, (double)n3 + d3, itemStack2);
                entityItem.delayBeforeCanPickup = 10;
                entityPlayer.worldObj.spawnEntityInWorld(entityItem);
            }
            itemStack._a(1, (EntityLivingBase)entityPlayer);
            entityPlayer.addStat(dzif._C[n4], 1);
        }
        return false;
    }
}

