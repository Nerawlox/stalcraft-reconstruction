/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class rrbo
extends tgha
implements IPlantable {
    public int _a;
    public int _b;

    public rrbo(int n, int n2, float f, int n3, int n4) {
        super(n, n2, f, false);
        this._a = n3;
        this._b = n4;
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (n4 != 1) {
            return false;
        }
        if (entityPlayer.func_82247_a(n, n2, n3, n4, cvzo2) && entityPlayer.func_82247_a(n, n2 + 1, n3, n4, cvzo2)) {
            int n5 = ozlu2.func_72798_a(n, n2, n3);
            twgu twgu2 = twgu.field_71973_m[n5];
            if (twgu2 != null && twgu2.canSustainPlant(ozlu2, n, n2, n3, ForgeDirection.UP, this) && ozlu2.func_72799_c(n, n2 + 1, n3)) {
                ozlu2.func_94575_c(n, n2 + 1, n3, this._a);
                --cvzo2._b;
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public EnumPlantType getPlantType(ozlu ozlu2, int n, int n2, int n3) {
        return EnumPlantType.Crop;
    }

    @Override
    public int getPlantID(ozlu ozlu2, int n, int n2, int n3) {
        return this._a;
    }

    @Override
    public int getPlantMetadata(ozlu ozlu2, int n, int n2, int n3) {
        return 0;
    }
}

