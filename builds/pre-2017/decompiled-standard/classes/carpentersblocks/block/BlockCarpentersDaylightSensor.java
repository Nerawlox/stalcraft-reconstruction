/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.CarpentersBlocks;
import carpentersblocks.block.BlockBase;
import carpentersblocks.data.DaylightSensor;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.tileentity.TECarpentersBlockExt;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;
import net.minecraft.util.sajh;

public class BlockCarpentersDaylightSensor
extends BlockBase {
    public BlockCarpentersDaylightSensor(int n) {
        super(n, tflj._d);
        this.func_71848_c(0.2f);
        this.func_71864_b("blockCarpentersDaylightSensor");
        this.func_71849_a(CarpentersBlocks.tabCarpentersBlocks);
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.375f, 1.0f);
        this.func_111022_d("carpentersblocks:general/generic");
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_71895_b(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return n4 == 1 ? twgu.field_94344_cp.func_71851_a(1) : super.func_71895_b(sdrg2, n, n2, n3, n4);
    }

    @Override
    protected boolean onHammerLeftClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer) {
        int n;
        int n2 = BlockProperties.getData(tECarpentersBlock);
        int n3 = n = DaylightSensor.getPolarity(n2) == 0 ? 1 : 0;
        if (!tECarpentersBlock.field_70331_k.field_72995_K) {
            DaylightSensor.setPolarity(tECarpentersBlock, n);
        } else {
            switch (n) {
                case 0: {
                    entityPlayer.func_71035_c(LanguageRegistry.instance().getStringLocalization("message.activation_day.name"));
                    break;
                }
                case 1: {
                    entityPlayer.func_71035_c(LanguageRegistry.instance().getStringLocalization("message.activation_night.name"));
                }
            }
        }
        return true;
    }

    @Override
    public int func_71865_a(sdrg sdrg2, int n, int n2, int n3, int n4) {
        boolean bl;
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)sdrg2.func_72796_p(n, n2, n3);
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = DaylightSensor.getType(n5);
        boolean bl2 = n6 > 2;
        boolean bl3 = bl = DaylightSensor.getPolarity(n5) == 0;
        return bl2 ? (bl ? n6 : 0) : (!bl ? 15 : 0);
    }

    public void updateLightLevel(ozlu ozlu2, int n, int n2, int n3) {
        if (!ozlu2.field_73011_w._g) {
            TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3);
            int n4 = BlockProperties.getData(tECarpentersBlock);
            int n5 = DaylightSensor.getType(n4);
            int n6 = ozlu2.func_72972_b(rrqi._a, n, n2, n3) - ozlu2.field_73008_k;
            float f = ozlu2.func_72929_e(1.0f);
            f = f < (float)Math.PI ? (f += (0.0f - f) * 0.2f) : (f += ((float)Math.PI * 2 - f) * 0.2f);
            n6 = Math.round((float)n6 * sajh._b(f));
            if (n6 < 0) {
                n6 = 0;
            } else if (n6 > 15) {
                n6 = 15;
            }
            if (n5 != n6) {
                DaylightSensor.setType(tECarpentersBlock, n6);
                ozlu2.func_72898_h(n, n2, n3, this.field_71990_ca);
            }
        }
    }

    @Override
    public boolean func_71853_i() {
        return true;
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new TECarpentersBlockExt();
    }

    @Override
    public int func_71857_b() {
        return BlockHandler.carpentersDaylightSensorRenderID;
    }
}

