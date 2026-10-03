/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class gprx
extends Block
implements stgn {
    public gprx(int n) {
        super(n, Material._d);
        this.setUnlocalizedName("camp_fire");
        LanguageRegistry.addName(this, "\u041a\u043e\u0441\u0442\u0435\u0440");
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new maao();
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b("stalker:transparent");
    }

    @Override
    public void onEntityWalking(World world, int n, int n2, int n3, Entity entity) {
        entity.setFire(10);
    }

    @Override
    public int getLightValue(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return 15;
    }
}

