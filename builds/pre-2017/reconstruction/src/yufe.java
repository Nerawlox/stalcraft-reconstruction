/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Sets;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.bundle.common.core.InvokeWithResult;
import gloomyfolken.mods.core.entity.EntityAdvancedThrowable;
import gloomyfolken.mods.core.main.GloomyCore;
import java.util.List;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class yufe
extends Block {
    public static final Set<Integer> _a = Sets.newHashSet(20, 101, 102, 79, 3520, 3523, 3522, 3518, 153);
    private Icon _b;

    public yufe(int n, Material material) {
        super(n, material);
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b("stalker:impblock_inv");
        this._b = iconRegister._b("stalker:impblock_vis");
    }

    @Override
    public MovingObjectPosition collisionRayTrace(World world, int n, int n2, int n3, Vec3 vec3, Vec3 vec32) {
        if (this._a(world)) {
            return super.collisionRayTrace(world, n, n2, n3, vec3, vec32);
        }
        return null;
    }

    public boolean _a(World world) {
        return world.isRemote && InvokeWithResult.client(() -> Minecraft._E()._t.capabilities._d) != false;
    }

    @Override
    public void addCollisionBoxesToList(World world, int n, int n2, int n3, AxisAlignedBB axisAlignedBB, List list2, Entity entity) {
        if (!(entity instanceof EntityAdvancedThrowable)) {
            super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getIcon(int n, int n2) {
        EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
        if (entityClientPlayerMP == null || !entityClientPlayerMP.capabilities._d) {
            return this.blockIcon;
        }
        return this._b;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }

    @Override
    public boolean canRenderInPass(int n) {
        return super.canRenderInPass(n) && this.getRenderType() != -1;
    }

    @Override
    public int getRenderType() {
        return GloomyCore.transparentsRenderType;
    }
}

