/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.eidj;
import net.minecraftforge.common.ForgeDirection;

public class cuwq
extends twgu {
    public cuwq(int n) {
        super(n, tflj._q);
        this.func_71849_a(tgbl.field_78031_c);
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        this.func_71902_a(ozlu2, n, n2, n3);
        return super.func_71872_e(ozlu2, n, n2, n3);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public eidj func_71911_a_(ozlu ozlu2, int n, int n2, int n3) {
        this.func_71902_a(ozlu2, n, n2, n3);
        return super.func_71911_a_(ozlu2, n, n2, n3);
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        this._a(sdrg2.func_72805_g(n, n2, n3));
    }

    public void _a(int n) {
        float f = 0.125f;
        if (n == 2) {
            this.func_71905_a(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
        }
        if (n == 3) {
            this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
        }
        if (n == 4) {
            this.func_71905_a(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
        if (n == 5) {
            this.func_71905_a(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
        }
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    public int func_71857_b() {
        return 8;
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        return ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST) || ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) || ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) || ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH);
    }

    @Override
    public int func_85104_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        int n6 = n5;
        if ((n6 == 0 || n4 == 2) && ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH)) {
            n6 = 2;
        }
        if ((n6 == 0 || n4 == 3) && ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH)) {
            n6 = 3;
        }
        if ((n6 == 0 || n4 == 4) && ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST)) {
            n6 = 4;
        }
        if ((n6 == 0 || n4 == 5) && ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST)) {
            n6 = 5;
        }
        return n6;
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        int n5 = ozlu2.func_72805_g(n, n2, n3);
        boolean bl = false;
        if (n5 == 2 && ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH)) {
            bl = true;
        }
        if (n5 == 3 && ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH)) {
            bl = true;
        }
        if (n5 == 4 && ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST)) {
            bl = true;
        }
        if (n5 == 5 && ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST)) {
            bl = true;
        }
        if (!bl) {
            this.func_71897_c(ozlu2, n, n2, n3, n5, 0);
            ozlu2.func_94571_i(n, n2, n3);
        }
        super.func_71863_a(ozlu2, n, n2, n3, n4);
    }

    @Override
    public int func_71925_a(Random random) {
        return 1;
    }

    @Override
    public boolean isLadder(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase) {
        return true;
    }
}

