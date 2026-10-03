/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.respawn;

import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.stalker.respawn.jxtc;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class kjui
extends Block
implements stgn {
    private Icon _a;

    public kjui(int n) {
        super(n, GloomyCore.fakeAir);
        this.setUnlocalizedName("block_savepoint");
        this.setCreativeTab(GloomyCore.tab);
        this.setBlockUnbreakable();
        LanguageRegistry.addName(this, "\u0422\u043e\u0447\u043a\u0430 \u0441\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u044f");
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        this.setLightOpacity(0);
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        if (!world.isRemote) {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return null;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b("stalker:transparent");
        this._a = iconRegister._b("anomalies:anomaly");
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public Icon getIcon(int n, int n2) {
        EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
        if (entityClientPlayerMP == null || !entityClientPlayerMP.capabilities._d) {
            return this.blockIcon;
        }
        return this._a;
    }

    @Override
    public boolean addBlockDestroyEffects(World world, int n, int n2, int n3, int n4, EffectRenderer effectRenderer) {
        return true;
    }

    @Override
    public boolean addBlockHitEffects(World world, MovingObjectPosition movingObjectPosition, EffectRenderer effectRenderer) {
        return true;
    }

    @Override
    public boolean isAirBlock(World world, int n, int n2, int n3) {
        return true;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public int getRenderBlockPass() {
        return 1;
    }

    @Override
    public int getRenderType() {
        return GloomyCore.transparentsRenderType;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new jxtc();
    }
}

