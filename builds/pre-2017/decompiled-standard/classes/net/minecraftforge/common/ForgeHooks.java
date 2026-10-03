/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.amww;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;
import net.minecraft.util.iurq;
import net.minecraft.util.jxtc;
import net.minecraft.util.piet;
import net.minecraft.util.sajh;
import net.minecraft.util.zwat;
import net.minecraftforge.common.ForgeDummyContainer;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.event.entity.player.PlayerOpenContainerEvent;
import net.minecraftforge.event.world.BlockEvent;

public class ForgeHooks {
    static final List<GrassEntry> grassList = new ArrayList<GrassEntry>();
    static final List<SeedEntry> seedList = new ArrayList<SeedEntry>();
    private static boolean toolInit = false;
    static HashMap<tgdv, List> toolClasses = new HashMap();
    static HashMap<List, Integer> toolHarvestLevels = new HashMap();
    static HashSet<List> toolEffectiveness = new HashSet();

    public static void plantGrass(ozlu ozlu2, int n, int n2, int n3) {
        GrassEntry grassEntry = (GrassEntry)iurq._a(ozlu2.field_73012_v, grassList);
        if (grassEntry == null || grassEntry.block == null || !grassEntry.block.func_71854_d(ozlu2, n, n2, n3)) {
            return;
        }
        ozlu2.func_72832_d(n, n2, n3, grassEntry.block.field_71990_ca, grassEntry.metadata, 3);
    }

    public static cvzo getGrassSeed(ozlu ozlu2) {
        SeedEntry seedEntry = (SeedEntry)iurq._a(ozlu2.field_73012_v, seedList);
        if (seedEntry == null || seedEntry.seed == null) {
            return null;
        }
        return seedEntry.seed._l();
    }

    public static boolean canHarvestBlock(twgu twgu2, EntityPlayer entityPlayer, int n) {
        if (twgu2.field_72018_cp._l()) {
            return true;
        }
        cvzo cvzo2 = entityPlayer.field_71071_by._a();
        if (cvzo2 == null) {
            return entityPlayer.func_71062_b(twgu2);
        }
        List list2 = toolClasses.get(cvzo2._a());
        if (list2 == null) {
            return entityPlayer.func_71062_b(twgu2);
        }
        Object[] objectArray = list2.toArray();
        String string = (String)objectArray[0];
        int n2 = (Integer)objectArray[1];
        Integer n3 = toolHarvestLevels.get(Arrays.asList(twgu2, n, string));
        if (n3 == null) {
            return entityPlayer.func_71062_b(twgu2);
        }
        return n3 <= n2;
    }

    public static boolean canToolHarvestBlock(twgu twgu2, int n, cvzo cvzo2) {
        if (cvzo2 == null) {
            return false;
        }
        List list2 = toolClasses.get(cvzo2._a());
        if (list2 == null) {
            return false;
        }
        Object[] objectArray = list2.toArray();
        String string = (String)objectArray[0];
        int n2 = (Integer)objectArray[1];
        Integer n3 = toolHarvestLevels.get(Arrays.asList(twgu2, n, string));
        return n3 != null && n3 <= n2;
    }

    public static float blockStrength(twgu twgu2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3) {
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        float f = twgu2.func_71934_m(ozlu2, n, n2, n3);
        if (f < 0.0f) {
            return 0.0f;
        }
        if (!ForgeHooks.canHarvestBlock(twgu2, entityPlayer, n4)) {
            float f2 = ForgeEventFactory.getBreakSpeed(entityPlayer, twgu2, n4, 1.0f);
            return (f2 < 0.0f ? 0.0f : f2) / f / 100.0f;
        }
        return entityPlayer.getCurrentPlayerStrVsBlock(twgu2, false, n4) / f / 30.0f;
    }

    public static boolean isToolEffective(cvzo cvzo2, twgu twgu2, int n) {
        List list2 = toolClasses.get(cvzo2._a());
        return list2 != null && toolEffectiveness.contains(Arrays.asList(twgu2, n, list2.get(0)));
    }

    static void initTools() {
        if (toolInit) {
            return;
        }
        toolInit = true;
        MinecraftForge.setToolClass(tgdv.field_77713_t, "pickaxe", 0);
        MinecraftForge.setToolClass(tgdv.field_77720_x, "pickaxe", 1);
        MinecraftForge.setToolClass(tgdv.field_77696_g, "pickaxe", 2);
        MinecraftForge.setToolClass(tgdv.field_77681_I, "pickaxe", 0);
        MinecraftForge.setToolClass(tgdv.field_77674_B, "pickaxe", 3);
        MinecraftForge.setToolClass(tgdv.field_77712_u, "axe", 0);
        MinecraftForge.setToolClass(tgdv.field_77719_y, "axe", 1);
        MinecraftForge.setToolClass(tgdv.field_77708_h, "axe", 2);
        MinecraftForge.setToolClass(tgdv.field_77682_J, "axe", 0);
        MinecraftForge.setToolClass(tgdv.field_77675_C, "axe", 3);
        MinecraftForge.setToolClass(tgdv.field_77714_s, "shovel", 0);
        MinecraftForge.setToolClass(tgdv.field_77710_w, "shovel", 1);
        MinecraftForge.setToolClass(tgdv.field_77695_f, "shovel", 2);
        MinecraftForge.setToolClass(tgdv.field_77680_H, "shovel", 0);
        MinecraftForge.setToolClass(tgdv.field_77673_A, "shovel", 3);
        for (twgu twgu2 : hufu._a) {
            MinecraftForge.setBlockHarvestLevel(twgu2, "pickaxe", 0);
        }
        for (twgu twgu2 : bsws._a) {
            MinecraftForge.setBlockHarvestLevel(twgu2, "shovel", 0);
        }
        for (twgu twgu2 : bsrw._a) {
            MinecraftForge.setBlockHarvestLevel(twgu2, "axe", 0);
        }
        MinecraftForge.setBlockHarvestLevel(twgu.field_72089_ap, "pickaxe", 3);
        MinecraftForge.setBlockHarvestLevel(twgu.field_72068_bR, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(twgu.field_72073_aw, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(twgu.field_72071_ax, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(twgu.field_71941_G, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(twgu.field_72105_ah, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(twgu.field_71949_H, "pickaxe", 1);
        MinecraftForge.setBlockHarvestLevel(twgu.field_72083_ai, "pickaxe", 1);
        MinecraftForge.setBlockHarvestLevel(twgu.field_71947_N, "pickaxe", 1);
        MinecraftForge.setBlockHarvestLevel(twgu.field_71948_O, "pickaxe", 1);
        MinecraftForge.setBlockHarvestLevel(twgu.field_72047_aN, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(twgu.field_72048_aO, "pickaxe", 2);
        MinecraftForge.removeBlockEffectiveness(twgu.field_72047_aN, "pickaxe");
        MinecraftForge.removeBlockEffectiveness(twgu.field_72089_ap, "pickaxe");
        MinecraftForge.removeBlockEffectiveness(twgu.field_72048_aO, "pickaxe");
    }

    public static int getTotalArmorValue(EntityPlayer entityPlayer) {
        int n = 0;
        for (int i = 0; i < entityPlayer.field_71071_by._b.length; ++i) {
            cvzo cvzo2 = entityPlayer.field_71071_by._b[i];
            if (cvzo2 != null && cvzo2._a() instanceof ISpecialArmor) {
                n += ((ISpecialArmor)((Object)cvzo2._a())).getArmorDisplay(entityPlayer, cvzo2, i);
                continue;
            }
            if (cvzo2 == null || !(cvzo2._a() instanceof lpno)) continue;
            n += ((lpno)cvzo2._a()).field_77879_b;
        }
        return n;
    }

    public static boolean onPickBlock(hank hank2, EntityPlayer entityPlayer, ozlu ozlu2) {
        int n;
        cvzo cvzo2 = null;
        boolean bl = entityPlayer.field_71075_bZ._d;
        if (hank2._c == amww._a) {
            n = hank2._d;
            int n2 = hank2._e;
            int n3 = hank2._f;
            twgu twgu2 = twgu.field_71973_m[ozlu2.func_72798_a(n, n2, n3)];
            if (twgu2 == null) {
                return false;
            }
            cvzo2 = twgu2.getPickBlock(hank2, ozlu2, n, n2, n3);
        } else {
            if (hank2._c != amww._b || hank2._i == null || !bl) {
                return false;
            }
            cvzo2 = hank2._i.getPickedResult(hank2);
        }
        if (cvzo2 == null) {
            return false;
        }
        for (n = 0; n < 9; ++n) {
            cvzo cvzo3 = entityPlayer.field_71071_by.func_70301_a(n);
            if (cvzo3 == null || !cvzo3._b(cvzo2) || !cvzo._a(cvzo3, cvzo2)) continue;
            entityPlayer.field_71071_by._c = n;
            return true;
        }
        if (!bl) {
            return false;
        }
        n = entityPlayer.field_71071_by._c();
        if (n < 0 || n >= 9) {
            n = entityPlayer.field_71071_by._c;
        }
        entityPlayer.field_71071_by.func_70299_a(n, cvzo2);
        entityPlayer.field_71071_by._c = n;
        return true;
    }

    public static void onLivingSetAttackTarget(EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        MinecraftForge.EVENT_BUS.post(new LivingSetAttackTargetEvent(entityLivingBase, entityLivingBase2));
    }

    public static boolean onLivingUpdate(EntityLivingBase entityLivingBase) {
        return MinecraftForge.EVENT_BUS.post(new LivingEvent.LivingUpdateEvent(entityLivingBase));
    }

    public static boolean onLivingAttack(EntityLivingBase entityLivingBase, jxtc jxtc2, float f) {
        return MinecraftForge.EVENT_BUS.post(new LivingAttackEvent(entityLivingBase, jxtc2, f));
    }

    public static float onLivingHurt(EntityLivingBase entityLivingBase, jxtc jxtc2, float f) {
        LivingHurtEvent livingHurtEvent = new LivingHurtEvent(entityLivingBase, jxtc2, f);
        return MinecraftForge.EVENT_BUS.post(livingHurtEvent) ? 0.0f : livingHurtEvent.ammount;
    }

    public static boolean onLivingDeath(EntityLivingBase entityLivingBase, jxtc jxtc2) {
        return MinecraftForge.EVENT_BUS.post(new LivingDeathEvent(entityLivingBase, jxtc2));
    }

    public static boolean onLivingDrops(EntityLivingBase entityLivingBase, jxtc jxtc2, ArrayList<EntityItem> arrayList, int n, boolean bl, int n2) {
        return MinecraftForge.EVENT_BUS.post(new LivingDropsEvent(entityLivingBase, jxtc2, arrayList, n, bl, n2));
    }

    public static float onLivingFall(EntityLivingBase entityLivingBase, float f) {
        LivingFallEvent livingFallEvent = new LivingFallEvent(entityLivingBase, f);
        return MinecraftForge.EVENT_BUS.post(livingFallEvent) ? 0.0f : livingFallEvent.distance;
    }

    public static boolean isLivingOnLadder(twgu twgu2, ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase) {
        if (!ForgeDummyContainer.fullBoundingBoxLadders) {
            return twgu2 != null && twgu2.isLadder(ozlu2, n, n2, n3, entityLivingBase);
        }
        eidj eidj2 = entityLivingBase.field_70121_D;
        int n4 = sajh._c(eidj2._b);
        int n5 = sajh._c(eidj2._c);
        int n6 = sajh._c(eidj2._d);
        int n7 = n5;
        while ((double)n7 < eidj2._f) {
            int n8 = n4;
            while ((double)n8 < eidj2._e) {
                int n9 = n6;
                while ((double)n9 < eidj2._g) {
                    twgu2 = twgu.field_71973_m[ozlu2.func_72798_a(n8, n7, n9)];
                    if (twgu2 != null && twgu2.isLadder(ozlu2, n8, n7, n9, entityLivingBase)) {
                        return true;
                    }
                    ++n9;
                }
                ++n8;
            }
            ++n7;
        }
        return false;
    }

    public static void onLivingJump(EntityLivingBase entityLivingBase) {
        MinecraftForge.EVENT_BUS.post(new LivingEvent.LivingJumpEvent(entityLivingBase));
    }

    public static EntityItem onPlayerTossEvent(EntityPlayer entityPlayer, cvzo cvzo2) {
        entityPlayer.captureDrops = true;
        EntityItem entityItem = entityPlayer.func_71019_a(cvzo2, false);
        entityPlayer.capturedDrops.clear();
        entityPlayer.captureDrops = false;
        if (entityItem == null) {
            return null;
        }
        ItemTossEvent itemTossEvent = new ItemTossEvent(entityItem, entityPlayer);
        if (MinecraftForge.EVENT_BUS.post(itemTossEvent)) {
            return null;
        }
        entityPlayer.func_71012_a(itemTossEvent.entityItem);
        return itemTossEvent.entityItem;
    }

    public static float getEnchantPower(ozlu ozlu2, int n, int n2, int n3) {
        if (ozlu2.func_72799_c(n, n2, n3)) {
            return 0.0f;
        }
        twgu twgu2 = twgu.field_71973_m[ozlu2.func_72798_a(n, n2, n3)];
        return twgu2 == null ? 0.0f : twgu2.getEnchantPowerBonus(ozlu2, n, n2, n3);
    }

    public static zwat onServerChatEvent(xbvu xbvu2, String string, zwat zwat2) {
        ServerChatEvent serverChatEvent = new ServerChatEvent(xbvu2.field_72574_e, string, zwat2);
        if (MinecraftForge.EVENT_BUS.post(serverChatEvent)) {
            return null;
        }
        return serverChatEvent.component;
    }

    public static boolean canInteractWith(EntityPlayer entityPlayer, jjgc jjgc2) {
        PlayerOpenContainerEvent playerOpenContainerEvent = new PlayerOpenContainerEvent(entityPlayer, jjgc2);
        MinecraftForge.EVENT_BUS.post(playerOpenContainerEvent);
        return playerOpenContainerEvent.getResult() == Event.Result.DEFAULT ? playerOpenContainerEvent.canInteractWith : playerOpenContainerEvent.getResult() == Event.Result.ALLOW;
    }

    public static BlockEvent.BreakEvent onBlockBreakEvent(ozlu ozlu2, xtby xtby2, EntityPlayerMP entityPlayerMP, int n, int n2, int n3) {
        Object object;
        boolean bl = false;
        if (xtby2._c() && !entityPlayerMP.func_82246_f(n, n2, n3)) {
            bl = true;
        } else if (xtby2._d() && entityPlayerMP.func_70694_bm() != null && entityPlayerMP.func_70694_bm()._a() instanceof vmpw) {
            bl = true;
        }
        if (ozlu2.func_72796_p(n, n2, n3) == null) {
            object = new cwan(n, n2, n3, ozlu2);
            ((cwan)object)._d = 0;
            ((cwan)object)._e = 0;
            entityPlayerMP.field_71135_a.func_72567_b((cezg)object);
        }
        object = twgu.field_71973_m[ozlu2.func_72798_a(n, n2, n3)];
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        BlockEvent.BreakEvent breakEvent = new BlockEvent.BreakEvent(n, n2, n3, ozlu2, (twgu)object, n4, entityPlayerMP);
        breakEvent.setCanceled(bl);
        MinecraftForge.EVENT_BUS.post(breakEvent);
        if (breakEvent.isCanceled()) {
            cezg cezg2;
            entityPlayerMP.field_71135_a.func_72567_b(new cwan(n, n2, n3, ozlu2));
            hurg hurg2 = ozlu2.func_72796_p(n, n2, n3);
            if (hurg2 != null && (cezg2 = hurg2.func_70319_e()) != null) {
                entityPlayerMP.field_71135_a.func_72567_b(cezg2);
            }
        }
        return breakEvent;
    }

    static {
        grassList.add(new GrassEntry(twgu.field_72097_ad, 0, 20));
        grassList.add(new GrassEntry(twgu.field_72107_ae, 0, 10));
        seedList.add(new SeedEntry(new cvzo(tgdv.field_77690_S), 10));
        ForgeHooks.initTools();
    }

    static class SeedEntry
    extends piet {
        public final cvzo seed;

        public SeedEntry(cvzo cvzo2, int n) {
            super(n);
            this.seed = cvzo2;
        }
    }

    static class GrassEntry
    extends piet {
        public final twgu block;
        public final int metadata;

        public GrassEntry(twgu twgu2, int n, int n2) {
            super(n2);
            this.block = twgu2;
            this.metadata = n;
        }
    }
}

