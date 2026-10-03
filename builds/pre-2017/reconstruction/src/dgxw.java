/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class dgxw
extends BlockFlower {
    @SideOnly(value=Side.CLIENT)
    public Icon[] _a;

    public dgxw(int n) {
        super(n);
        this.setTickRandomly(true);
        float f = 0.5f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.25f, 0.5f + f);
        this.setCreativeTab(null);
    }

    @Override
    public boolean _a(int n) {
        return n == Block.slowSand.blockID;
    }

    @Override
    public boolean canBlockStay(World world, int n, int n2, int n3) {
        Block block = Block.blocksList[world.getBlockId(n, n2 - 1, n3)];
        return block != null && block.canSustainPlant(world, n, n2 - 1, n3, ForgeDirection.UP, this);
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        int n4 = world.getBlockMetadata(n, n2, n3);
        if (n4 < 3 && random.nextInt(10) == 0) {
            world.func_72921_c(n, n2, n3, ++n4, 2);
        }
        super.updateTick(world, n, n2, n3, random);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getIcon(int n, int n2) {
        return n2 >= 3 ? this._a[2] : (n2 > 0 ? this._a[1] : this._a[0]);
    }

    @Override
    public int getRenderType() {
        return 6;
    }

    @Override
    public void dropBlockAsItemWithChance(World world, int n, int n2, int n3, int n4, float f, int n5) {
        super.dropBlockAsItemWithChance(world, n, n2, n3, n4, f, n5);
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return 0;
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int idPicked(World world, int n, int n2, int n3) {
        return Item.netherStalkSeeds.itemID;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this._a = new Icon[3];
        for (int i = 0; i < this._a.length; ++i) {
            this._a[i] = iconRegister._b(this.getTextureName() + "_stage_" + i);
        }
    }

    @Override
    public ArrayList<ItemStack> getBlockDropped(World world, int n, int n2, int n3, int n4, int n5) {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        int n6 = 1;
        if (n4 >= 3) {
            n6 = 2 + world.rand.nextInt(3) + (n5 > 0 ? world.rand.nextInt(n5 + 1) : 0);
        }
        for (int i = 0; i < n6; ++i) {
            arrayList.add(new ItemStack(Item.netherStalkSeeds));
        }
        return arrayList;
    }
}

