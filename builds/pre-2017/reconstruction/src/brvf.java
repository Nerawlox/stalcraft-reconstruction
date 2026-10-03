/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IShearable;

public class brvf
extends BlockFlower
implements IShearable {
    public static final String[] _a = new String[]{"deadbush", "tallgrass", "fern"};
    @SideOnly(value=Side.CLIENT)
    public Icon[] _b;

    public brvf(int n) {
        super(n, Material._l);
        float f = 0.4f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.8f, 0.5f + f);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getIcon(int n, int n2) {
        if (n2 >= this._b.length) {
            n2 = 0;
        }
        return this._b[n2];
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return -1;
    }

    @Override
    public int quantityDroppedWithBonus(int n, Random random) {
        return 1 + random.nextInt(n * 2 + 1);
    }

    @Override
    public void harvestBlock(World world, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        super.harvestBlock(world, entityPlayer, n, n2, n3, n4);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int getBlockColor() {
        double d = 0.5;
        double d2 = 1.0;
        return gapq._a(d, d2);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int getRenderColor(int n) {
        return n == 0 ? 0xFFFFFF : igvq._c();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int colorMultiplier(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4 = iBlockAccess.getBlockMetadata(n, n2, n3);
        return n4 == 0 ? 0xFFFFFF : iBlockAccess.getBiomeGenForCoords(n, n3)._l();
    }

    @Override
    public int getDamageValue(World world, int n, int n2, int n3) {
        return world.getBlockMetadata(n, n2, n3);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void getSubBlocks(int n, CreativeTabs creativeTabs, List list2) {
        for (int i = 1; i < 3; ++i) {
            list2.add(new ItemStack(n, 1, i));
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this._b = new Icon[_a.length];
        for (int i = 0; i < this._b.length; ++i) {
            this._b[i] = iconRegister._b(_a[i]);
        }
    }

    @Override
    public ArrayList<ItemStack> getBlockDropped(World world, int n, int n2, int n3, int n4, int n5) {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        if (world.rand.nextInt(8) != 0) {
            return arrayList;
        }
        ItemStack itemStack = ForgeHooks.getGrassSeed(world);
        if (itemStack != null) {
            arrayList.add(itemStack);
        }
        return arrayList;
    }

    @Override
    public boolean isShearable(ItemStack itemStack, World world, int n, int n2, int n3) {
        return true;
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack itemStack, World world, int n, int n2, int n3, int n4) {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        arrayList.add(new ItemStack(this, 1, world.getBlockMetadata(n, n2, n3)));
        return arrayList;
    }
}

