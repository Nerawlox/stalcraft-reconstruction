/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.CarpentersBlocks;
import carpentersblocks.block.BlockBase;
import carpentersblocks.data.PressurePlate;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.jxsn;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;

public class BlockCarpentersPressurePlate
extends BlockBase {
    public BlockCarpentersPressurePlate(int n) {
        super(n, tflj._d);
        this.func_71848_c(0.2f);
        this.func_71864_b("blockCarpentersPressurePlate");
        this.func_71849_a(CarpentersBlocks.tabCarpentersBlocks);
        this.func_71907_b(true);
        this.func_111022_d("carpentersblocks:slope/slope");
    }

    @Override
    protected boolean onHammerLeftClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer) {
        int n;
        int n2 = BlockProperties.getData(tECarpentersBlock);
        int n3 = n = PressurePlate.getPolarity(n2) == 0 ? 1 : 0;
        if (!tECarpentersBlock.field_70331_k.field_72995_K) {
            PressurePlate.setPolarity(tECarpentersBlock, n);
            tECarpentersBlock.field_70331_k.func_72898_h(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m - 1, tECarpentersBlock.field_70327_n, this.field_71990_ca);
        } else {
            switch (n) {
                case 0: {
                    entityPlayer.func_71035_c(LanguageRegistry.instance().getStringLocalization("message.polarity_pos.name"));
                    break;
                }
                case 1: {
                    entityPlayer.func_71035_c(LanguageRegistry.instance().getStringLocalization("message.polarity_neg.name"));
                }
            }
        }
        return true;
    }

    @Override
    protected boolean onHammerRightClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer, int n) {
        int n2;
        int n3 = BlockProperties.getData(tECarpentersBlock);
        switch (PressurePlate.getTriggerEntity(n3)) {
            case 0: {
                n2 = 1;
                break;
            }
            case 1: {
                n2 = 2;
                break;
            }
            case 2: {
                n2 = 3;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        if (!tECarpentersBlock.field_70331_k.field_72995_K) {
            PressurePlate.setTriggerEntity(tECarpentersBlock, n2);
        } else {
            switch (n2) {
                case 0: {
                    entityPlayer.func_71035_c(LanguageRegistry.instance().getStringLocalization("message.trigger_player.name"));
                    break;
                }
                case 1: {
                    entityPlayer.func_71035_c(LanguageRegistry.instance().getStringLocalization("message.trigger_monster.name"));
                    break;
                }
                case 2: {
                    entityPlayer.func_71035_c(LanguageRegistry.instance().getStringLocalization("message.trigger_animal.name"));
                    break;
                }
                case 3: {
                    entityPlayer.func_71035_c(LanguageRegistry.instance().getStringLocalization("message.trigger_all.name"));
                }
            }
        }
        return true;
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)sdrg2.func_72796_p(n, n2, n3);
        this.func_71905_a(0.0625f, 0.0f, 0.0625f, 0.9375f, this.isDepressed(tECarpentersBlock) ? 0.03125f : 0.0625f, 0.9375f);
    }

    @Override
    public void auxiliaryOnBlockPlacedBy(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        PressurePlate.setType(tECarpentersBlock, ozlu2.func_72805_g(n, n2, n3));
    }

    @Override
    public int func_71859_p_(ozlu ozlu2) {
        return 20;
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return null;
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        return ozlu2.func_72797_t(n, n2 - 1, n3) || ozlu2.func_72798_a(n, n2 - 1, n3) == BlockHandler.blockCarpentersBarrierID;
    }

    @Override
    protected void auxiliaryOnNeighborBlockChange(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, int n4) {
        boolean bl = false;
        if (!ozlu2.func_72797_t(n, n2 - 1, n3) && ozlu2.func_72798_a(n, n2 - 1, n3) != BlockHandler.blockCarpentersBarrierID) {
            bl = true;
        }
        if (bl) {
            int n5 = BlockProperties.getData(tECarpentersBlock);
            int n6 = PressurePlate.getType(n5);
            ozlu2.func_94571_i(n, n2, n3);
        }
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (!ozlu2.field_72995_K) {
            TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3);
            List list = ozlu2.func_72872_a(Entity.class, this.getSensitiveAABB(n, n2, n3));
            if (!list.isEmpty()) {
                for (int i = 0; i < list.size(); ++i) {
                    this.setStateIfMobCollidesWithPlate(tECarpentersBlock, (Entity)list.get(i), ozlu2, n, n2, n3);
                }
            } else {
                this.setStateIfMobCollidesWithPlate(tECarpentersBlock, null, ozlu2, n, n2, n3);
            }
        }
    }

    @Override
    public void func_71869_a(ozlu ozlu2, int n, int n2, int n3, Entity entity) {
        TECarpentersBlock tECarpentersBlock;
        List list;
        if (!(ozlu2.field_72995_K || (list = ozlu2.func_72872_a(Entity.class, this.getSensitiveAABB(n, n2, n3))).isEmpty() || this.isDepressed(tECarpentersBlock = (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3)))) {
            for (int i = 0; i < list.size(); ++i) {
                this.setStateIfMobCollidesWithPlate(tECarpentersBlock, (Entity)list.get(i), ozlu2, n, n2, n3);
            }
        }
    }

    private void setStateIfMobCollidesWithPlate(TECarpentersBlock tECarpentersBlock, Entity entity, ozlu ozlu2, int n, int n2, int n3) {
        BlockProperties.getData(tECarpentersBlock);
        boolean bl = this.isDepressed(tECarpentersBlock);
        if (this.shouldTrigger(tECarpentersBlock, entity, ozlu2, n, n2, n3)) {
            PressurePlate.setState(tECarpentersBlock, 1, true);
            this.notifyNeighborsOfUpdate(ozlu2, n, n2, n3);
            ozlu2.func_72836_a(n, n2, n3, this.field_71990_ca, this.func_71859_p_(ozlu2));
        } else if (bl) {
            PressurePlate.setState(tECarpentersBlock, 0, true);
            this.notifyNeighborsOfUpdate(ozlu2, n, n2, n3);
        }
    }

    private eidj getSensitiveAABB(int n, int n2, int n3) {
        return eidj._a()._a((float)n + 0.125f, n2, (float)n3 + 0.125f, (float)n + 1.0f - 0.125f, (double)n2 + 0.25, (float)n3 + 1.0f - 0.125f);
    }

    private void notifyNeighborsOfUpdate(ozlu ozlu2, int n, int n2, int n3) {
        ozlu2.func_72898_h(n, n2, n3, this.field_71990_ca);
        ozlu2.func_72898_h(n, n2 - 1, n3, this.field_71990_ca);
    }

    private boolean isDepressed(TECarpentersBlock tECarpentersBlock) {
        int n = BlockProperties.getData(tECarpentersBlock);
        return PressurePlate.getState(n) == 1;
    }

    @Override
    public int func_71865_a(sdrg sdrg2, int n, int n2, int n3, int n4) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)sdrg2.func_72796_p(n, n2, n3);
        int n5 = BlockProperties.getData(tECarpentersBlock);
        return this.getPowerSupply(tECarpentersBlock, n5);
    }

    @Override
    public int func_71855_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)sdrg2.func_72796_p(n, n2, n3);
        int n5 = BlockProperties.getData(tECarpentersBlock);
        return n4 == 1 ? this.getPowerSupply(tECarpentersBlock, n5) : 0;
    }

    @Override
    public boolean func_71853_i() {
        return true;
    }

    private int getPowerSupply(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = PressurePlate.getPolarity(n);
        return this.isDepressed(tECarpentersBlock) ? (n2 == 0 ? 15 : 0) : (n2 == 1 ? 15 : 0);
    }

    private boolean shouldTrigger(TECarpentersBlock tECarpentersBlock, Entity entity, ozlu ozlu2, int n, int n2, int n3) {
        if (entity == null) {
            return false;
        }
        int n4 = PressurePlate.getTriggerEntity(BlockProperties.getData(tECarpentersBlock));
        switch (n4) {
            case 0: {
                return entity instanceof EntityPlayer;
            }
            case 1: {
                return entity.isCreatureType(jxsn._a, false);
            }
            case 2: {
                return entity.isCreatureType(jxsn._b, false);
            }
        }
        return true;
    }

    @Override
    public void auxiliaryBreakBlock(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        if (this.isDepressed(tECarpentersBlock)) {
            this.notifyNeighborsOfUpdate(ozlu2, n, n2, n3);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean func_71877_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return n4 != 0;
    }

    @Override
    public int func_71857_b() {
        return BlockHandler.carpentersPressurePlateRenderID;
    }
}

