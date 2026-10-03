/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class zhxn
extends Item {
    public txfz _a;

    public zhxn(int n, txfz txfz2) {
        super(n);
        this._a = txfz2;
        this.maxStackSize = 1;
        this.setMaxDamage(txfz2._a());
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (!entityPlayer.canPlayerEdit(n, n2, n3, n4, itemStack)) {
            return false;
        }
        UseHoeEvent useHoeEvent = new UseHoeEvent(entityPlayer, itemStack, world, n, n2, n3);
        if (MinecraftForge.EVENT_BUS.post(useHoeEvent)) {
            return false;
        }
        if (useHoeEvent.getResult() == Event.Result.ALLOW) {
            itemStack._a(1, (EntityLivingBase)entityPlayer);
            return true;
        }
        int n5 = world.getBlockId(n, n2, n3);
        boolean bl = world.isAirBlock(n, n2 + 1, n3);
        if (n4 != 0 && bl && (n5 == Block.grass.blockID || n5 == Block.dirt.blockID)) {
            Block block = Block.tilledField;
            world.playSoundEffect((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, block.stepSound._d(), (block.stepSound._a() + 1.0f) / 2.0f, block.stepSound._b() * 0.8f);
            if (world.isRemote) {
                return true;
            }
            world.setBlock(n, n2, n3, block.blockID);
            itemStack._a(1, (EntityLivingBase)entityPlayer);
            return true;
        }
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

    public String _a() {
        return this._a.toString();
    }
}

