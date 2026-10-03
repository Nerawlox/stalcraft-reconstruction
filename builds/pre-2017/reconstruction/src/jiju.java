/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.block.BlockBasePressurePlate;
import net.minecraft.block.EnumMobType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class jiju
extends BlockBasePressurePlate {
    public EnumMobType _b;

    public jiju(int n, String string, Material material, EnumMobType enumMobType) {
        super(n, string, material);
        this._b = enumMobType;
    }

    @Override
    public int _c(int n) {
        return n > 0 ? 1 : 0;
    }

    @Override
    public int _b(int n) {
        return n == 1 ? 15 : 0;
    }

    @Override
    public int _b(World world, int n, int n2, int n3) {
        List list2 = null;
        if (this._b == EnumMobType._a) {
            list2 = world.getEntitiesWithinAABBExcludingEntity(null, this._a(n, n2, n3));
        }
        if (this._b == EnumMobType._b) {
            list2 = world.getEntitiesWithinAABB(EntityLivingBase.class, this._a(n, n2, n3));
        }
        if (this._b == EnumMobType._c) {
            list2 = world.getEntitiesWithinAABB(EntityPlayer.class, this._a(n, n2, n3));
        }
        if (list2 != null && !list2.isEmpty()) {
            for (Entity entity : list2) {
                if (entity.doesEntityNotTriggerPressurePlate()) continue;
                return 15;
            }
        }
        return 0;
    }
}

