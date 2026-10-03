/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.SlopeBlock;
import carpentersblocks.data.Slope;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.bundle.common.core.InvokeWithResult;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.stalker.misc.qlgf;
import java.util.Arrays;
import java.util.List;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import net.minecraftforge.client.ForgeHooksClient;

public class BlockStalkerSlope
extends twgu
implements SlopeBlock {
    public static final int DEFAULT_SLOPE_ID = 2415;
    public static final int DOUBLE_SLOPE_ID = 2445;
    public static List<twgu> TERRAIN_BLOCKS = Arrays.asList(twgu.field_71980_u, twgu.field_71979_v, twgu.field_71940_F, twgu.field_71939_E, twgu.field_72013_bc, twgu.field_71994_by, twgu.field_72012_bb, twgu.field_72089_ap, twgu.field_72041_aW);
    public static int renderType = 0;
    private static Slope[][] slopes = new Slope[][]{{Slope.OBL_INT_POS_SE, Slope.OBL_INT_POS_SW, Slope.OBL_INT_POS_NW, Slope.OBL_INT_POS_NE}, {Slope.OBL_EXT_POS_SE, Slope.OBL_EXT_POS_SW, Slope.OBL_EXT_POS_NW, Slope.OBL_EXT_POS_NE}, {Slope.WEDGE_SE, Slope.WEDGE_SW, Slope.WEDGE_NW, Slope.WEDGE_NE}, {Slope.WEDGE_POS_S, Slope.WEDGE_POS_W, Slope.WEDGE_POS_N, Slope.WEDGE_POS_E}};
    private twgu coverBlock;

    public BlockStalkerSlope(int n, twgu twgu2) {
        super(n, tflj._d);
        this.func_71864_b("BlockSlope_" + twgu2.field_71968_b);
        this.coverBlock = twgu2;
    }

    public static boolean isSlopeBlock(int n) {
        return n >= 2415 && n < 2415 + TERRAIN_BLOCKS.size() || n >= 2445 && n < 2445 + TERRAIN_BLOCKS.size();
    }

    public static Slope getSlopeFromMeta(int n) {
        return slopes[n & 3][n >> 2 & 3];
    }

    @Override
    public void func_71871_a(ozlu ozlu2, int n, int n2, int n3, eidj eidj2, List list, Entity entity) {
        if (entity instanceof EntityItem) {
            super.func_71871_a(ozlu2, n, n2, n3, eidj2, list, entity);
        } else {
            int n4 = ozlu2.func_72805_g(n, n2, n3);
            Slope slope = BlockStalkerSlope.getSlopeFromMeta(n4);
            this.addSlopeCollision(slope, n, n2, n3, list);
        }
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        super.func_71860_a(ozlu2, n, n2, n3, entityLivingBase, cvzo2);
        int n4 = entityLivingBase instanceof EntityPlayer ? ((EntityPlayer)entityLivingBase).field_71071_by._c % 4 : 3;
        int n5 = sajh._c((double)entityLivingBase.field_70177_z / 90.0 + 2.5) & 3;
        ozlu2.func_72921_c(n, n2, n3, n4 & 3 | n5 << 2, 2);
    }

    @Override
    public hank func_71878_a(ozlu ozlu2, int n, int n2, int n3, ofbx ofbx2, ofbx ofbx3) {
        if (GloomyCore.side.isClient() && InvokeWithResult.client(() -> qlgf._a && !xpzm._E()._t.field_71075_bZ._d).booleanValue()) {
            return null;
        }
        Slope slope = BlockStalkerSlope.getSlopeFromMeta(ozlu2.func_72805_g(n, n2, n3));
        hank hank2 = null;
        int n4 = this.getNumBoxesPerPass(slope);
        int n5 = this.getNumPasses(slope);
        double d = 0.0;
        double d2 = 0.0;
        for (int i = 0; i < n5 && hank2 == null; ++i) {
            for (int j = 0; j < n4 && hank2 == null; ++j) {
                float[] fArray = this.genBounds(slope, j, n4, i);
                this.func_71905_a(fArray[0], fArray[1], fArray[2], fArray[3], fArray[4], fArray[5]);
                hank hank3 = super.func_71878_a(ozlu2, n, n2, n3, ofbx2, ofbx3);
                if (hank3 == null || !((d = hank3._h._e(ofbx3)) > d2)) continue;
                hank2 = hank3;
                d2 = d;
            }
            if (!slope.slopeType.equals((Object)Slope.SlopeType.OBLIQUE_EXT)) continue;
            --n4;
        }
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        if (hank2 != null) {
            hank2 = super.func_71878_a(ozlu2, n, n2, n3, ofbx2, ofbx3);
        }
        return hank2;
    }

    public twgu getCoverBlock() {
        return this.coverBlock;
    }

    @Override
    public int func_71857_b() {
        return renderType;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71856_s_() {
        return 0;
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
    public boolean canRenderInPass(int n) {
        ForgeHooksClient.setRenderPass(n);
        return n == 0;
    }

    public boolean shouldRenderBase() {
        return false;
    }
}

