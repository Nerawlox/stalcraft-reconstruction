/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class hdbs
extends Item {
    public hdbs(int n) {
        super(n);
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabTransport);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        Object object;
        int n;
        float f;
        float f2;
        float f3;
        double d;
        float f4;
        float f5 = 1.0f;
        float f6 = entityPlayer.prevRotationPitch + (entityPlayer.rotationPitch - entityPlayer.prevRotationPitch) * f5;
        float f7 = entityPlayer.prevRotationYaw + (entityPlayer.rotationYaw - entityPlayer.prevRotationYaw) * f5;
        double d2 = entityPlayer.prevPosX + (entityPlayer.posX - entityPlayer.prevPosX) * (double)f5;
        double d3 = entityPlayer.prevPosY + (entityPlayer.posY - entityPlayer.prevPosY) * (double)f5 + 1.62 - (double)entityPlayer.yOffset;
        double d4 = entityPlayer.prevPosZ + (entityPlayer.posZ - entityPlayer.prevPosZ) * (double)f5;
        Vec3 vec3 = world.getWorldVec3Pool()._a(d2, d3, d4);
        float f8 = sajh._b(-f7 * ((float)Math.PI / 180) - (float)Math.PI);
        float f9 = sajh._a(-f7 * ((float)Math.PI / 180) - (float)Math.PI);
        float f10 = f9 * (f4 = -sajh._b(-f6 * ((float)Math.PI / 180)));
        Vec3 vec32 = vec3._c((double)f10 * (d = 5.0), (double)(f3 = (f2 = sajh._a(-f6 * ((float)Math.PI / 180)))) * d, (double)(f = f8 * f4) * d);
        MovingObjectPosition movingObjectPosition = world.func_72901_a(vec3, vec32, true);
        if (movingObjectPosition == null) {
            return itemStack;
        }
        Vec3 vec33 = entityPlayer.getLook(f5);
        boolean bl = false;
        float f11 = 1.0f;
        List list = world.getEntitiesWithinAABBExcludingEntity(entityPlayer, entityPlayer.boundingBox._a(vec33._c * d, vec33._d * d, vec33._e * d)._b(f11, f11, f11));
        for (n = 0; n < list.size(); ++n) {
            float f12;
            Entity entity = (Entity)list.get(n);
            if (!entity.canBeCollidedWith() || !((AxisAlignedBB)(object = entity.boundingBox._b(f12 = entity.getCollisionBorderSize(), f12, f12)))._a(vec3)) continue;
            bl = true;
        }
        if (bl) {
            return itemStack;
        }
        if (movingObjectPosition._c == EnumMovingObjectType._a) {
            n = movingObjectPosition._d;
            int n2 = movingObjectPosition._e;
            int n3 = movingObjectPosition._f;
            if (world.getBlockId(n, n2, n3) == Block.snow.blockID) {
                --n2;
            }
            object = new EntityBoat(world, (float)n + 0.5f, (float)n2 + 1.0f, (float)n3 + 0.5f);
            ((EntityBoat)object).rotationYaw = ((sajh._c((double)(entityPlayer.rotationYaw * 4.0f / 360.0f) + 0.5) & 3) - 1) * 90;
            if (!world.getCollidingBoundingBoxes((Entity)object, ((EntityBoat)object).boundingBox._b(-0.1, -0.1, -0.1)).isEmpty()) {
                return itemStack;
            }
            if (!world.isRemote) {
                world.spawnEntityInWorld((Entity)object);
            }
            if (!entityPlayer.capabilities._d) {
                --itemStack._b;
            }
        }
        return itemStack;
    }
}

