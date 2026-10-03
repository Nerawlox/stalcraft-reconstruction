/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.EventHandler;
import carpentersblocks.util.handler.FeatureHandler;
import carpentersblocks.util.handler.ItemHandler;
import carpentersblocks.util.handler.PatternHandler;
import carpentersblocks.util.handler.PlantHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import java.util.Random;
import net.minecraft.client.particle.kjui;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class BlockBase
extends iwgt {
    public BlockBase(int n, tflj tflj2) {
        super(n, tflj2);
    }

    protected boolean willCoverRecurse(sdrg sdrg2, int n, int n2, int n3) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)sdrg2.func_72796_p(n, n2, n3);
        return BlockProperties.getCoverBlock((TECarpentersBlock)tECarpentersBlock, (int)6).field_71990_ca == this.field_71990_ca;
    }

    protected boolean extendsBlockBase(sdrg sdrg2, int n, int n2, int n3) {
        int n4 = sdrg2.func_72798_a(n, n2, n3);
        return n4 > 0 && twgu.field_71973_m[n4] instanceof BlockBase;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_71895_b(sdrg sdrg2, int n, int n2, int n3, int n4) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)sdrg2.func_72796_p(n, n2, n3);
        return BlockProperties.getCoverBlock(tECarpentersBlock, 6).func_71858_a(n4, BlockProperties.getCoverMetadata(tECarpentersBlock, 6));
    }

    @Override
    public void func_71921_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3);
        cvzo cvzo2 = entityPlayer.func_71045_bC();
        if (cvzo2 != null) {
            int n4 = EventHandler.eventFace;
            int n5 = BlockProperties.hasCover(tECarpentersBlock, n4) ? n4 : 6;
            tgdv tgdv2 = cvzo2._a();
            if (tgdv2.equals(ItemHandler.itemCarpentersHammer)) {
                boolean bl = false;
                if (entityPlayer.func_70093_af()) {
                    if (!ozlu2.field_72995_K) {
                        if (BlockProperties.hasOverlay(tECarpentersBlock, n5)) {
                            bl = BlockProperties.setOverlay(tECarpentersBlock, n5, null);
                        } else if (BlockProperties.hasDyeColor(tECarpentersBlock, n5)) {
                            bl = BlockProperties.setDyeColor(tECarpentersBlock, n5, 0);
                        } else if (BlockProperties.hasCover(tECarpentersBlock, n5)) {
                            BlockProperties.setCover(tECarpentersBlock, n5, 0, null);
                            bl = BlockProperties.setPattern(tECarpentersBlock, n5, 0);
                        }
                    }
                } else {
                    bl = this.onHammerLeftClick(tECarpentersBlock, entityPlayer);
                }
                if (bl) {
                    if (!entityPlayer.field_71075_bZ._d) {
                        ozlu2.func_72908_a((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, "dig.wood", 4.0f, 1.0f);
                    }
                    this.func_71863_a(ozlu2, n, n2, n3, this.field_71990_ca);
                    ozlu2.func_72898_h(n, n2, n3, this.field_71990_ca);
                }
            } else if (!ozlu2.field_72995_K && tgdv2.equals(ItemHandler.itemCarpentersChisel)) {
                if (entityPlayer.func_70093_af()) {
                    if (BlockProperties.hasPattern(tECarpentersBlock, n5)) {
                        BlockProperties.setPattern(tECarpentersBlock, n5, 0);
                    }
                } else if (BlockProperties.hasCover(tECarpentersBlock, n5) && BlockProperties.getCoverBlock(tECarpentersBlock, n5).func_71926_d()) {
                    this.onChiselClick(tECarpentersBlock, n5, true);
                }
            }
        }
        this.auxiliaryOnBlockClicked(tECarpentersBlock, ozlu2, n, n2, n3, entityPlayer);
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3);
        cvzo cvzo2 = entityPlayer.func_71045_bC();
        boolean bl = false;
        boolean bl2 = false;
        if (cvzo2 != null) {
            int n5;
            int n6 = n5 = BlockProperties.hasCover(tECarpentersBlock, n4) ? n4 : 6;
            if (cvzo2._a() == ItemHandler.itemCarpentersHammer) {
                bl = this.onHammerRightClick(tECarpentersBlock, entityPlayer, n4);
            } else if (ItemHandler.enableChisel && cvzo2._a() == ItemHandler.itemCarpentersChisel) {
                if (ozlu2.field_72995_K) {
                    return true;
                }
                if (BlockProperties.hasCover(tECarpentersBlock, n5) && BlockProperties.getCoverBlock(tECarpentersBlock, n5).func_71926_d()) {
                    bl = this.onChiselClick(tECarpentersBlock, n5, false);
                }
            } else if (FeatureHandler.enableCovers && BlockProperties.isCover(cvzo2._a(), cvzo2._j())) {
                int n7;
                twgu twgu2 = twgu.field_71973_m[cvzo2._d];
                int n8 = n7 = twgu2 instanceof gqau ? sajh._c((double)(EventHandler.eventEntity.field_70177_z * 4.0f / 360.0f) + 2.5) & 3 : cvzo2._j();
                if (!BlockProperties.hasCover(tECarpentersBlock, 6)) {
                    if (BlockProperties.blockRotates(ozlu2, twgu2, n, n2, n3)) {
                        n7 = twgu2.func_85104_a(ozlu2, n, n2, n3, n4, f, f2, f3, n7);
                    }
                    bl = bl2 = BlockProperties.setCover(tECarpentersBlock, 6, n7, cvzo2);
                } else if (FeatureHandler.enableSideCovers && !BlockProperties.hasCover(tECarpentersBlock, n4) && this.canCoverSide(tECarpentersBlock, ozlu2, n, n2, n3, n4)) {
                    if (BlockProperties.blockRotates(ozlu2, twgu2, n, n2, n3)) {
                        int n9 = sajh._c((double)(EventHandler.eventEntity.field_70177_z * 4.0f / 360.0f) + 2.5) & 3;
                        int n10 = entityPlayer.field_70125_A < -45.0f ? 0 : (entityPlayer.field_70125_A > 45.0f ? 1 : (n9 == 0 ? 3 : (n9 == 1 ? 4 : (n9 == 2 ? 2 : 5))));
                        n7 = twgu2.func_85104_a(ozlu2, n, n2, n3, n10, f, f2, f3, n7);
                    }
                    bl = bl2 = BlockProperties.setCover(tECarpentersBlock, n4, n7, cvzo2);
                }
            } else if (FeatureHandler.enableOverlays && BlockProperties.isOverlay(cvzo2._d)) {
                if (ozlu2.field_72995_K) {
                    return true;
                }
                if (!BlockProperties.hasOverlay(tECarpentersBlock, n5) && (n5 < 6 && BlockProperties.hasCover(tECarpentersBlock, n5) || n5 == 6)) {
                    bl = bl2 = BlockProperties.setOverlay(tECarpentersBlock, n5, cvzo2);
                }
            } else if (FeatureHandler.enableDyeColors && cvzo2._a() == tgdv.field_77756_aW && cvzo2._j() != 15) {
                if (ozlu2.field_72995_K) {
                    return true;
                }
                if (!BlockProperties.hasDyeColor(tECarpentersBlock, n5)) {
                    bl = bl2 = BlockProperties.setDyeColor(tECarpentersBlock, n5, 15 - cvzo2._j());
                }
            }
        }
        if (!bl) {
            bl = this.auxiliaryOnBlockActivated(tECarpentersBlock, ozlu2, n, n2, n3, entityPlayer, n4, f, f2, f3);
        } else {
            cvzo2._a(1, (EntityLivingBase)entityPlayer);
            if (!entityPlayer.field_71075_bZ._d) {
                ozlu2.func_72908_a((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, "dig.wood", 4.0f, 1.0f);
            }
            this.func_71863_a(ozlu2, n, n2, n3, this.field_71990_ca);
            ozlu2.func_72898_h(n, n2, n3, this.field_71990_ca);
        }
        if (!ozlu2.field_72995_K && bl2 && !entityPlayer.field_71075_bZ._d && --cvzo2._b <= 0) {
            entityPlayer.field_71071_by.func_70299_a(entityPlayer.field_71071_by._c, null);
        }
        return bl;
    }

    public boolean onChiselClick(TECarpentersBlock tECarpentersBlock, int n, boolean bl) {
        int n2 = BlockProperties.getPattern(tECarpentersBlock, n);
        int n3 = 0;
        if (n2 == 0) {
            TECarpentersBlock tECarpentersBlock2;
            TECarpentersBlock tECarpentersBlock3 = this.extendsBlockBase(tECarpentersBlock.field_70331_k, tECarpentersBlock.field_70329_l - 1, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n) ? (TECarpentersBlock)tECarpentersBlock.field_70331_k.func_72796_p(tECarpentersBlock.field_70329_l - 1, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n) : null;
            TECarpentersBlock tECarpentersBlock4 = this.extendsBlockBase(tECarpentersBlock.field_70331_k, tECarpentersBlock.field_70329_l + 1, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n) ? (TECarpentersBlock)tECarpentersBlock.field_70331_k.func_72796_p(tECarpentersBlock.field_70329_l + 1, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n) : null;
            TECarpentersBlock tECarpentersBlock5 = this.extendsBlockBase(tECarpentersBlock.field_70331_k, tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m - 1, tECarpentersBlock.field_70327_n) ? (TECarpentersBlock)tECarpentersBlock.field_70331_k.func_72796_p(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m - 1, tECarpentersBlock.field_70327_n) : null;
            TECarpentersBlock tECarpentersBlock6 = this.extendsBlockBase(tECarpentersBlock.field_70331_k, tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m + 1, tECarpentersBlock.field_70327_n) ? (TECarpentersBlock)tECarpentersBlock.field_70331_k.func_72796_p(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m + 1, tECarpentersBlock.field_70327_n) : null;
            TECarpentersBlock tECarpentersBlock7 = this.extendsBlockBase(tECarpentersBlock.field_70331_k, tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n - 1) ? (TECarpentersBlock)tECarpentersBlock.field_70331_k.func_72796_p(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n - 1) : null;
            TECarpentersBlock tECarpentersBlock8 = tECarpentersBlock2 = this.extendsBlockBase(tECarpentersBlock.field_70331_k, tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n + 1) ? (TECarpentersBlock)tECarpentersBlock.field_70331_k.func_72796_p(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n + 1) : null;
            if (tECarpentersBlock3 != null && BlockProperties.hasPattern(tECarpentersBlock3, n)) {
                n3 = n2 = BlockProperties.getPattern(tECarpentersBlock3, n);
            } else if (tECarpentersBlock4 != null && BlockProperties.hasPattern(tECarpentersBlock4, n)) {
                n3 = n2 = BlockProperties.getPattern(tECarpentersBlock4, n);
            } else if (tECarpentersBlock5 != null && BlockProperties.hasPattern(tECarpentersBlock5, n)) {
                n3 = n2 = BlockProperties.getPattern(tECarpentersBlock5, n);
            } else if (tECarpentersBlock6 != null && BlockProperties.hasPattern(tECarpentersBlock6, n)) {
                n3 = n2 = BlockProperties.getPattern(tECarpentersBlock6, n);
            } else if (tECarpentersBlock7 != null && BlockProperties.hasPattern(tECarpentersBlock7, n)) {
                n3 = n2 = BlockProperties.getPattern(tECarpentersBlock7, n);
            } else if (tECarpentersBlock2 != null && BlockProperties.hasPattern(tECarpentersBlock2, n)) {
                n3 = n2 = BlockProperties.getPattern(tECarpentersBlock2, n);
            }
        }
        if (n3 == 0) {
            n2 = bl ? PatternHandler.getPrev(n2) : PatternHandler.getNext(n2);
        }
        BlockProperties.setPattern(tECarpentersBlock, n, n2);
        return true;
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        TECarpentersBlock tECarpentersBlock = null;
        if (!ozlu2.field_72995_K && BlockProperties.hasSideCovers(tECarpentersBlock = (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3))) {
            for (int i = 0; i < 6; ++i) {
                twgu twgu2;
                if (!BlockProperties.hasCover(tECarpentersBlock, i)) continue;
                if (!this.canCoverSide(tECarpentersBlock, ozlu2, n, n2, n3, i)) {
                    return;
                }
                ForgeDirection forgeDirection = ForgeDirection.getOrientation(i);
                int n5 = n + forgeDirection.offsetX;
                int n6 = n2 + forgeDirection.offsetY;
                int n7 = n3 + forgeDirection.offsetZ;
                if (ozlu2.func_72798_a(n5, n6, n7) > 0 && !(twgu2 = twgu.field_71973_m[ozlu2.func_72798_a(n5, n6, n7)]).isBlockSolidOnSide(ozlu2, n5, n6, n7, ForgeDirection.getOrientation(ForgeDirection.OPPOSITES[i]))) continue;
            }
        }
        if (tECarpentersBlock != null) {
            this.auxiliaryOnNeighborBlockChange(tECarpentersBlock, ozlu2, n, n2, n3, n4);
        }
    }

    @Override
    public int func_71865_a(sdrg sdrg2, int n, int n2, int n3, int n4) {
        if (!this.willCoverRecurse(sdrg2, n, n2, n3)) {
            TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)sdrg2.func_72796_p(n, n2, n3);
            int n5 = ForgeDirection.OPPOSITES[n4];
            int n6 = BlockProperties.getCoverBlock(sdrg2, 6, n, n2, n3).func_71865_a(sdrg2, n, n2, n3, n4);
            int n7 = BlockProperties.hasCover(tECarpentersBlock, n5) ? BlockProperties.getCoverBlock(tECarpentersBlock, n5).func_71865_a(sdrg2, n, n2, n3, n4) : 0;
            return n7 > n6 ? n7 : n6;
        }
        return 0;
    }

    @Override
    public int func_71855_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        if (!this.willCoverRecurse(sdrg2, n, n2, n3)) {
            TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)sdrg2.func_72796_p(n, n2, n3);
            int n5 = ForgeDirection.OPPOSITES[n4];
            int n6 = BlockProperties.getCoverBlock(sdrg2, 6, n, n2, n3).func_71855_c(sdrg2, n, n2, n3, n4);
            int n7 = BlockProperties.hasCover(tECarpentersBlock, n5) ? BlockProperties.getCoverBlock(tECarpentersBlock, n5).func_71855_c(sdrg2, n, n2, n3, n4) : 0;
            return n7 > n6 ? n7 : n6;
        }
        return 0;
    }

    private boolean suppressDestroyBlock(EntityPlayer entityPlayer, cvzo cvzo2) {
        return entityPlayer.field_71075_bZ._d && cvzo2 != null && (cvzo2._a() == ItemHandler.itemCarpentersHammer || cvzo2._a() == ItemHandler.itemCarpentersChisel);
    }

    @Override
    public boolean removeBlockByPlayer(ozlu ozlu2, EntityPlayer entityPlayer, int n, int n2, int n3) {
        if (!this.suppressDestroyBlock(entityPlayer, entityPlayer.func_70694_bm())) {
            return ozlu2.func_94571_i(n, n2, n3);
        }
        this.func_71921_a(ozlu2, n, n2, n3, entityPlayer);
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean addBlockDestroyEffects(ozlu ozlu2, int n, int n2, int n3, int n4, kjui kjui2) {
        EntityPlayer entityPlayer;
        if (ozlu2.func_72798_a(n, n2, n3) == this.field_71990_ca && (entityPlayer = ozlu2.func_72977_a(n, n2, n3, 6.5)) != null) {
            return this.suppressDestroyBlock(entityPlayer, entityPlayer.func_70694_bm());
        }
        return false;
    }

    @Override
    public int getLightValue(sdrg sdrg2, int n, int n2, int n3) {
        twgu twgu2 = twgu.field_71973_m[sdrg2.func_72798_a(n, n2, n3)];
        if (twgu2 != null && twgu2.field_71990_ca == this.field_71990_ca) {
            TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)sdrg2.func_72796_p(n, n2, n3);
            int n4 = 0;
            for (int i = 0; i < 7; ++i) {
                int n5;
                if (!BlockProperties.hasCover(tECarpentersBlock, i) || (n5 = twgu.field_71984_q[BlockProperties.getCoverID(tECarpentersBlock, i)]) <= n4) continue;
                n4 = n5;
            }
            return n4;
        }
        return twgu.field_71984_q[this.field_71990_ca];
    }

    @Override
    public float func_71934_m(ozlu ozlu2, int n, int n2, int n3) {
        return ozlu2.func_72798_a(n, n2, n3) == this.field_71990_ca && !this.willCoverRecurse(ozlu2, n, n2, n3) ? BlockProperties.getCoverBlock(ozlu2, 6, n, n2, n3).func_71934_m(ozlu2, n, n2, n3) : this.field_71989_cb;
    }

    @Override
    public int getFlammability(sdrg sdrg2, int n, int n2, int n3, int n4, ForgeDirection forgeDirection) {
        return twgu.blockFlammability[BlockProperties.getCoverBlock((sdrg)sdrg2, (int)6, (int)n, (int)n2, (int)n3).field_71990_ca];
    }

    @Override
    public int getFireSpreadSpeed(ozlu ozlu2, int n, int n2, int n3, int n4, ForgeDirection forgeDirection) {
        return twgu.blockFlammability[BlockProperties.getCoverBlock((sdrg)ozlu2, (int)6, (int)n, (int)n2, (int)n3).field_71990_ca];
    }

    @Override
    public boolean isFireSource(ozlu ozlu2, int n, int n2, int n3, int n4, ForgeDirection forgeDirection) {
        twgu twgu2;
        return !this.willCoverRecurse(ozlu2, n, n2, n3) && (twgu2 = BlockProperties.getCoverBlock(ozlu2, 6, n, n2, n3)).isBlockSolidOnSide(ozlu2, n, n2, n3, ForgeDirection.UP) && forgeDirection == ForgeDirection.UP && twgu2.isFireSource(ozlu2, n, n2, n3, n4, forgeDirection);
    }

    @Override
    public float getExplosionResistance(Entity entity, ozlu ozlu2, int n, int n2, int n3, double d, double d2, double d3) {
        return !this.willCoverRecurse(ozlu2, n, n2, n3) ? BlockProperties.getCoverBlock(ozlu2, 6, n, n2, n3).func_71904_a(entity) : this.func_71904_a(entity);
    }

    @Override
    public boolean isWood(ozlu ozlu2, int n, int n2, int n3) {
        return !this.willCoverRecurse(ozlu2, n, n2, n3) ? BlockProperties.getCoverBlock(ozlu2, 6, n, n2, n3).isWood(ozlu2, n, n2, n3) : false;
    }

    @Override
    public boolean canEntityDestroy(ozlu ozlu2, int n, int n2, int n3, Entity entity) {
        if (!this.willCoverRecurse(ozlu2, n, n2, n3)) {
            int n4 = BlockProperties.getCoverBlock((sdrg)ozlu2, (int)6, (int)n, (int)n2, (int)n3).field_71990_ca;
            if (entity instanceof EntityWither) {
                return n4 != twgu.field_71986_z.field_71990_ca && n4 != twgu.field_72102_bH.field_71990_ca && n4 != twgu.field_72104_bI.field_71990_ca;
            }
            if (entity instanceof EntityDragon) {
                return this.canDragonDestroy(ozlu2, n, n2, n3);
            }
        }
        return true;
    }

    @Override
    public boolean canDragonDestroy(ozlu ozlu2, int n, int n2, int n3) {
        return !this.willCoverRecurse(ozlu2, n, n2, n3) ? BlockProperties.getCoverBlock(ozlu2, 6, n, n2, n3).canDragonDestroy(ozlu2, n, n2, n3) : super.canDragonDestroy(ozlu2, n, n2, n3);
    }

    @Override
    public void func_71852_a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3);
        if (tECarpentersBlock != null) {
            for (int i = 0; i < 7; ++i) {
                BlockProperties.clearAttributes(tECarpentersBlock, i);
            }
            this.auxiliaryBreakBlock(tECarpentersBlock, ozlu2, n, n2, n3, n4, n5);
        }
        super.func_71852_a(ozlu2, n, n2, n3, n4, n5);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_71862_a(ozlu ozlu2, int n, int n2, int n3, Random random) {
        TECarpentersBlock tECarpentersBlock;
        if (!this.willCoverRecurse(ozlu2, n, n2, n3)) {
            BlockProperties.getCoverBlock(ozlu2, 6, n, n2, n3).func_71862_a(ozlu2, n, n2, n3, random);
        }
        if (ozlu2.func_72798_a(n, n2, n3) == this.field_71990_ca && BlockProperties.getOverlay(tECarpentersBlock = (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3), 6) == 6) {
            twgu.field_71994_by.func_71862_a(ozlu2, n, n2, n3, random);
        }
    }

    @Override
    public boolean canSustainPlant(ozlu ozlu2, int n, int n2, int n3, ForgeDirection forgeDirection, IPlantable iPlantable) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3);
        twgu twgu2 = BlockProperties.getCoverBlock(tECarpentersBlock, 6);
        twgu twgu3 = BlockProperties.getCoverBlock(tECarpentersBlock, 1);
        int n4 = BlockProperties.getOverlay(tECarpentersBlock, 6);
        int n5 = BlockProperties.getOverlay(tECarpentersBlock, 1);
        boolean bl = false;
        int n6 = this.field_71990_ca;
        for (int i = 0; i < 4; ++i) {
            switch (i) {
                case 0: {
                    n6 = twgu2.field_71990_ca;
                    break;
                }
                case 1: {
                    n6 = twgu3.field_71990_ca;
                    break;
                }
                case 2: {
                    n6 = n4 != 1 && n5 != 1 ? this.field_71990_ca : twgu.field_71980_u.field_71990_ca;
                    break;
                }
                case 3: {
                    int n7 = n6 = n4 != 6 && n5 != 6 ? this.field_71990_ca : twgu.field_71994_by.field_71990_ca;
                }
            }
            if (!this.canSustainPlantWithBlockIdOverride(tECarpentersBlock, ozlu2, n, n2, n3, n6, forgeDirection, iPlantable)) continue;
            bl = true;
        }
        return bl && this.isBlockSolidOnSide(ozlu2, n, n2, n3, ForgeDirection.UP);
    }

    protected boolean canSustainPlantWithBlockIdOverride(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, int n4, ForgeDirection forgeDirection, IPlantable iPlantable) {
        if (FeatureHandler.enablePlantSupport) {
            int n5 = iPlantable.getPlantID(ozlu2, n, n2 + 1, n3);
            EnumPlantType enumPlantType = iPlantable.getPlantType(ozlu2, n, n2 + 1, n3);
            if (n5 == twgu.field_72038_aV.field_71990_ca && n4 == twgu.field_72038_aV.field_71990_ca || n5 == twgu.field_72040_aX.field_71990_ca && n4 == twgu.field_72040_aX.field_71990_ca || iPlantable instanceof aorr && PlantHandler.canThisPlantGrowOnThisBlockID(n4)) {
                return true;
            }
            switch (NamelessClass520750742.$SwitchMap$net$minecraftforge$common$EnumPlantType[enumPlantType.ordinal()]) {
                case 1: {
                    return n4 == twgu.field_71939_E.field_71990_ca;
                }
                case 2: {
                    return n4 == twgu.field_72013_bc.field_71990_ca;
                }
                case 3: {
                    return n4 == twgu.field_72050_aA.field_71990_ca;
                }
                case 4: {
                    return true;
                }
                case 5: {
                    return n4 == twgu.field_71980_u.field_71990_ca || n4 == twgu.field_71979_v.field_71990_ca;
                }
                case 6: {
                    return BlockProperties.getCoverBlock((TECarpentersBlock)tECarpentersBlock, (int)6).field_72018_cp == tflj._h && ozlu2.func_72805_g(n, n2, n3) == 0;
                }
                case 7: {
                    boolean bl = n4 == twgu.field_71980_u.field_71990_ca || n4 == twgu.field_71979_v.field_71990_ca || n4 == twgu.field_71939_E.field_71990_ca;
                    boolean bl2 = ozlu2.func_72803_f(n - 1, n2, n3) == tflj._h || ozlu2.func_72803_f(n + 1, n2, n3) == tflj._h || ozlu2.func_72803_f(n, n2, n3 - 1) == tflj._h || ozlu2.func_72803_f(n, n2, n3 + 1) == tflj._h;
                    return bl && bl2;
                }
            }
        }
        return super.canSustainPlant(ozlu2, n, n2, n3, forgeDirection, iPlantable);
    }

    protected boolean isBlockSolid(ozlu ozlu2, int n, int n2, int n3) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3);
        return !BlockProperties.hasCover(tECarpentersBlock, 6) || BlockProperties.getCoverBlock(tECarpentersBlock, 6).func_71926_d();
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3);
        this.auxiliaryOnBlockPlacedBy(tECarpentersBlock, ozlu2, n, n2, n3, entityLivingBase, cvzo2);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean func_71877_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        ozlu ozlu2 = sdrg2 instanceof zzie ? ((zzie)sdrg2)._e : (ozlu)sdrg2;
        if (this.extendsBlockBase(ozlu2, n, n2, n3)) {
            ForgeDirection forgeDirection = ForgeDirection.getOrientation(n4);
            ForgeDirection forgeDirection2 = ForgeDirection.getOrientation(ForgeDirection.OPPOSITES[n4]);
            TECarpentersBlock tECarpentersBlock = TECarpentersBlock.get(ozlu2, n, n2, n3);
            TECarpentersBlock tECarpentersBlock2 = TECarpentersBlock.get(ozlu2, n + forgeDirection2.offsetX, n2 + forgeDirection2.offsetY, n3 + forgeDirection2.offsetZ);
            if (tECarpentersBlock != null && tECarpentersBlock2 != null && tECarpentersBlock.func_70311_o().isBlockSolidOnSide(ozlu2, n, n2, n3, forgeDirection2) == tECarpentersBlock2.func_70311_o().isBlockSolidOnSide(ozlu2, n + forgeDirection2.offsetX, n2 + forgeDirection2.offsetY, n3 + forgeDirection2.offsetZ, ForgeDirection.getOrientation(n4)) && this.shareFaces(tECarpentersBlock, tECarpentersBlock2, forgeDirection2, forgeDirection)) {
                return BlockProperties.shouldRenderSharedFaceBasedOnCovers(tECarpentersBlock, tECarpentersBlock2);
            }
        }
        return super.func_71877_c(sdrg2, n, n2, n3, n4);
    }

    protected boolean shareFaces(TECarpentersBlock tECarpentersBlock, TECarpentersBlock tECarpentersBlock2, ForgeDirection forgeDirection, ForgeDirection forgeDirection2) {
        return tECarpentersBlock.func_70311_o().isBlockSolidOnSide(tECarpentersBlock.field_70331_k, tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n, forgeDirection) && tECarpentersBlock2.func_70311_o().isBlockSolidOnSide(tECarpentersBlock2.field_70331_k, tECarpentersBlock2.field_70329_l, tECarpentersBlock2.field_70330_m, tECarpentersBlock2.field_70327_n, forgeDirection2);
    }

    @Override
    public boolean canRenderInPass(int n) {
        ForgeHooksClient.setRenderPass(n);
        return true;
    }

    @Override
    public hank func_71878_a(ozlu ozlu2, int n, int n2, int n3, ofbx ofbx2, ofbx ofbx3) {
        hank hank2 = super.func_71878_a(ozlu2, n, n2, n3, ofbx2, ofbx3);
        if (hank2 == null) {
            return null;
        }
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3);
        twgu twgu2 = BlockProperties.getCoverBlock(tECarpentersBlock, 6);
        if (twgu2 == StalkerMiscMod.__ac && !StalkerMiscMod.__ac._a(ozlu2)) {
            int n4 = BlockProperties.getCoverID(tECarpentersBlock, hank2._g);
            if (n4 > 0 && twgu.field_71973_m[n4] != null && !yufe._a.contains(n4)) {
                return hank2;
            }
            return null;
        }
        return hank2;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71856_s_() {
        return 1;
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
    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
        ozlu2.func_72837_a(n, n2, n3, this.func_72274_a(ozlu2));
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new TECarpentersBlock();
    }

    @Override
    public boolean hasTileEntity(int n) {
        return true;
    }

    protected void auxiliaryOnBlockClicked(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer) {
    }

    protected void auxiliaryOnBlockPlacedBy(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
    }

    protected boolean auxiliaryOnBlockActivated(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        return false;
    }

    protected void auxiliaryBreakBlock(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
    }

    protected boolean onHammerLeftClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer) {
        return false;
    }

    protected boolean onHammerRightClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer, int n) {
        return false;
    }

    protected boolean canCoverSide(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, int n4) {
        return false;
    }

    protected void auxiliaryOnNeighborBlockChange(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, int n4) {
    }

    static class NamelessClass520750742 {
        static final int[] $SwitchMap$net$minecraftforge$common$EnumPlantType = new int[EnumPlantType.values().length];

        NamelessClass520750742() {
        }

        static {
            try {
                NamelessClass520750742.$SwitchMap$net$minecraftforge$common$EnumPlantType[EnumPlantType.Desert.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass520750742.$SwitchMap$net$minecraftforge$common$EnumPlantType[EnumPlantType.Nether.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass520750742.$SwitchMap$net$minecraftforge$common$EnumPlantType[EnumPlantType.Crop.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass520750742.$SwitchMap$net$minecraftforge$common$EnumPlantType[EnumPlantType.Cave.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass520750742.$SwitchMap$net$minecraftforge$common$EnumPlantType[EnumPlantType.Plains.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass520750742.$SwitchMap$net$minecraftforge$common$EnumPlantType[EnumPlantType.Water.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass520750742.$SwitchMap$net$minecraftforge$common$EnumPlantType[EnumPlantType.Beach.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
        }
    }
}

