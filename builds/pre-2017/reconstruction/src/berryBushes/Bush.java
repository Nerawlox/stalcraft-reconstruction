/*
 * Decompiled with CFR 0.152.
 */
package berryBushes;

import berryBushes.Base;
import berryBushes.te.BushTE;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Bush
extends BlockContainer {
    public int Meta;

    public Bush(int n, int n2) {
        super(n, Material._j);
        this.Meta = n2;
        this.setResistance(0.2f);
        this.setHardness(0.5f);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new BushTE();
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        switch (this.Meta) {
            case 0: {
                this.setBlockBounds(0.2f, 0.0f, 0.2f, 0.8f, 0.6f, 0.8f);
                break;
            }
            case 1: {
                this.setBlockBounds(0.15f, 0.0f, 0.15f, 0.85f, 0.8f, 0.85f);
                break;
            }
            case 2: {
                this.setBlockBounds(0.1f, 0.0f, 0.1f, 0.9f, 0.9f, 0.9f);
                break;
            }
            case 3: {
                this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
        }
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return 0;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int idPicked(World world, int n, int n2, int n3) {
        return 0;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int colorMultiplier(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        switch (this.Meta) {
            case 0: {
                return 1008406;
            }
            case 1: {
                return 1018134;
            }
            case 2: {
                return 2517270;
            }
            case 3: {
                return 4164425;
            }
        }
        return 0;
    }

    @Override
    public ArrayList<ItemStack> getBlockDropped(World world, int n, int n2, int n3, int n4, int n5) {
        ArrayList<ItemStack> arrayList = super.getBlockDropped(world, n, n2, n3, n4, n5);
        Item item = this.Meta == 0 ? Base.berry : (this.Meta == 1 ? Base.berryII : (this.Meta == 2 ? Base.berryIII : Base.berryIV));
        int n6 = new Random().nextInt(2) + 1;
        for (int i = 0; i < n6; ++i) {
            arrayList.add(new ItemStack(item, 1));
        }
        return arrayList;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b("leaves_oak_opaque");
    }

    @Override
    public int getRenderType() {
        return RenderingRegistry.getNextAvailableRenderId();
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
}

