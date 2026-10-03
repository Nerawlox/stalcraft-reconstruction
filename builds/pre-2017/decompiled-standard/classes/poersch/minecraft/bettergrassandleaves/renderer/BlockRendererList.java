/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import noppes.npcs.CustomHooks;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;
import poersch.minecraft.util.options.OptionChoice;

public class BlockRendererList
extends ArrayList<BlockRenderer> {
    public static final int RENDER_BLOCK_EVENT = 1;
    public static final int RANDOM_DISPLAY_TICK_EVENT = 2;
    public static final int ENTITY_WALKING_EVENT = 4;
    public static ArrayList<BlockRendererList> rendererList;
    public static HashMap<String, BlockRendererList> particleSpawnerList;
    private static ArrayList<ArrayList<BlockRendererList>> renderBlockEventMap;
    private static ArrayList<ArrayList<BlockRendererList>> entityWalkingEventMap;
    private static ArrayList<ArrayList<BlockRendererList>> randomDisplayEventMap;
    private static boolean[] blackList;
    private static final OptionChoice standardIndex;
    private static xpzm minecraft;
    private OptionChoice optionIndex = standardIndex;
    private final String name;
    private final int events;

    public BlockRendererList(String string, int n) {
        this.name = string;
        this.events = n;
        rendererList.add(this);
    }

    @Hook(targetMethod="registerIcons")
    public static void onRegisterIconsHook(jzmk jzmk2, nege nege2) {
        BlockRenderer.initiateIconRegistration(nege2);
        BetterGrassAndLeavesMod.updatePlugins(nege2);
        for (BlockRendererList blockRendererList : rendererList) {
            for (int i = 0; i < blockRendererList.size(); ++i) {
                ((BlockRenderer)blockRendererList.get(i)).onRegisterIcons(nege2);
            }
        }
    }

    @Hook(createMethod=true, returnType="boolean")
    public static void hitByEntity(EntityLivingBase entityLivingBase, Entity entity) {
        BlockRendererList.onSpawnParticleHook("blood", entityLivingBase.field_70170_p, entityLivingBase.field_70165_t, entityLivingBase.field_70163_u, entityLivingBase.field_70161_v, 0.0, 0.0, 0.0, entityLivingBase);
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean spawnParticle(ozlu ozlu2, String string, double d, double d2, double d3, double d4, double d5, double d6) {
        return BlockRendererList.onSpawnParticleHook(string, ozlu2, d, d2, d3, d4, d5, d6, null);
    }

    public static boolean onSpawnParticleHook(String string, ozlu ozlu2, double d, double d2, double d3, double d4, double d5, double d6, Entity entity) {
        BlockRendererList blockRendererList;
        boolean bl = CustomHooks.onSpawnParticle(string, entity);
        if (bl) {
            return false;
        }
        if (BetterGrassAndLeavesMod.modActive && (blockRendererList = particleSpawnerList.get(string)) != null) {
            boolean bl2 = true;
            return bl2 &= blockRendererList.getCurrentRenderer().onSpawnParticle(string, ozlu2, d, d2, d3, d4, d5, d6, entity);
        }
        return false;
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE, targetMethod="renderBlockByRenderType")
    public static boolean onRenderBlockHook(htvc htvc2, twgu twgu2, int n, int n2, int n3) {
        ArrayList<BlockRendererList> arrayList;
        if (BetterGrassAndLeavesMod.modActive && (arrayList = renderBlockEventMap.get(twgu2.field_71990_ca)) != null) {
            BlockRenderer.tessellator.set(htvc2.__aF);
            boolean bl = true;
            for (int i = 0; i < arrayList.size(); ++i) {
                BlockRendererList blockRendererList = arrayList.get(i);
                bl &= blockRendererList.getCurrentRenderer().onRenderBlock(twgu2, htvc2._a, n, n2, n3, htvc2);
            }
            return bl;
        }
        return false;
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void doVoidFogParticles(pkix pkix2, int n, int n2, int n3) {
        int n4 = 16;
        Random random = new Random();
        for (int i = 0; i < 1000; ++i) {
            twgu twgu2;
            int n5;
            int n6;
            int n7 = n + pkix2.field_73012_v.nextInt(n4) - pkix2.field_73012_v.nextInt(n4);
            int n8 = pkix2.func_72798_a(n7, n6 = n2 + pkix2.field_73012_v.nextInt(n4) - pkix2.field_73012_v.nextInt(n4), n5 = n3 + pkix2.field_73012_v.nextInt(n4) - pkix2.field_73012_v.nextInt(n4));
            if (n8 == 0 && pkix2.field_73012_v.nextInt(8) > n6 && pkix2.field_73011_w._j()) {
                pkix2.func_72869_a("depthsuspend", (float)n7 + pkix2.field_73012_v.nextFloat(), (float)n6 + pkix2.field_73012_v.nextFloat(), (float)n5 + pkix2.field_73012_v.nextFloat(), 0.0, 0.0, 0.0);
                continue;
            }
            if (n8 <= 0 || BlockRendererList.onRandomDisplayTickHook(twgu2 = twgu.field_71973_m[n8], pkix2, n7, n6, n5, random)) continue;
            twgu.field_71973_m[n8].func_71862_a(pkix2, n7, n6, n5, random);
        }
    }

    public static boolean onRandomDisplayTickHook(twgu twgu2, ozlu ozlu2, int n, int n2, int n3, Random random) {
        ArrayList<BlockRendererList> arrayList;
        if (BetterGrassAndLeavesMod.modActive && (arrayList = randomDisplayEventMap.get(twgu2.field_71990_ca)) != null) {
            boolean bl = true;
            for (int i = 0; i < arrayList.size(); ++i) {
                BlockRendererList blockRendererList = arrayList.get(i);
                bl &= blockRendererList.getCurrentRenderer().onRandomDisplayTick(twgu2, ozlu2, n, n2, n3, random);
            }
            return bl;
        }
        return false;
    }

    @Hook(targetMethod="onEntityWalking", returnCondition=ReturnCondition.ON_TRUE)
    public static boolean onEntityWalkingHook(twgu twgu2, ozlu ozlu2, int n, int n2, int n3, Entity entity) {
        ArrayList<BlockRendererList> arrayList;
        if (!(!BetterGrassAndLeavesMod.modActive || minecraft._I() && entity instanceof EntityPlayerMP || BlockRendererList.minecraft._u != null && !entity.func_70112_a(entity.func_70068_e(BlockRendererList.minecraft._u)) || (arrayList = entityWalkingEventMap.get(twgu2.field_71990_ca)) == null)) {
            boolean bl = true;
            for (int i = 0; i < arrayList.size(); ++i) {
                BlockRendererList blockRendererList = arrayList.get(i);
                bl &= blockRendererList.getCurrentRenderer().onEntityWalking(twgu2, ozlu2, n, n2, n3, entity);
            }
            return bl;
        }
        return false;
    }

    public BlockRenderer getCurrentRenderer() {
        return (BlockRenderer)this.get((Integer)this.optionIndex.value);
    }

    public BlockRendererList setRendererChoice(OptionChoice optionChoice) {
        this.optionIndex = optionChoice;
        return this;
    }

    public String getRendererName() {
        return this.name;
    }

    public BlockRendererList addRenderer(BlockRenderer ... blockRendererArray) {
        for (int i = 0; i < blockRendererArray.length; ++i) {
            this.add(blockRendererArray[i]);
        }
        return this;
    }

    public BlockRendererList assignToParticleSpawner(String ... stringArray) {
        for (int i = 0; i < stringArray.length; ++i) {
            particleSpawnerList.put(stringArray[i], this);
        }
        return this;
    }

    public static void resetBlackList() {
        for (int i = 0; i < 4096; ++i) {
            BlockRendererList.blackList[i] = false;
        }
    }

    public static void addToBlackList(int n) {
        if (BlockRendererList.isBlockIDValid(n)) {
            BlockRendererList.blackList[n] = true;
        }
    }

    public static void removeFromBlackList(int n) {
        if (BlockRendererList.isBlockIDValid(n)) {
            BlockRendererList.blackList[n] = false;
        }
    }

    public static void resetRendererAssignments() {
        int n;
        for (n = 0; n < 4096; ++n) {
            renderBlockEventMap.set(n, null);
        }
        for (n = 0; n < 4096; ++n) {
            entityWalkingEventMap.set(n, null);
        }
        for (n = 0; n < 4096; ++n) {
            randomDisplayEventMap.set(n, null);
        }
    }

    public void assignToBlockID(int n) {
        if (BlockRendererList.isBlockIDValid(n) && !blackList[n]) {
            if ((this.events & 1) == 1) {
                this.addEventFor(renderBlockEventMap, n);
            }
            if ((this.events & 2) == 2) {
                this.addEventFor(randomDisplayEventMap, n);
            }
            if ((this.events & 4) == 4) {
                this.addEventFor(entityWalkingEventMap, n);
            }
        }
    }

    public void removeFromBlockID(int n) {
        if (BlockRendererList.isBlockIDValid(n)) {
            if ((this.events & 1) == 1) {
                this.removeEventFrom(renderBlockEventMap, n);
            }
            if ((this.events & 2) == 2) {
                this.removeEventFrom(randomDisplayEventMap, n);
            }
            if ((this.events & 4) == 4) {
                this.removeEventFrom(entityWalkingEventMap, n);
            }
        }
    }

    private void addEventFor(ArrayList<ArrayList<BlockRendererList>> arrayList, int n) {
        ArrayList<BlockRendererList> arrayList2 = arrayList.get(n);
        if (arrayList2 == null) {
            arrayList2 = new ArrayList();
            arrayList.set(n, arrayList2);
            arrayList2.add(this);
        } else if (!arrayList2.contains(this)) {
            arrayList2.add(this);
        }
    }

    private void removeEventFrom(ArrayList<ArrayList<BlockRendererList>> arrayList, int n) {
        ArrayList<BlockRendererList> arrayList2 = arrayList.get(n);
        arrayList2 = arrayList.get(n);
        if (arrayList2 != null) {
            arrayList2.remove(this);
            if (arrayList2.size() == 0) {
                arrayList.set(n, null);
            }
        }
    }

    private static boolean isBlockIDValid(int n) {
        return n >= 0 && n < 4096;
    }

    static {
        int n;
        rendererList = new ArrayList();
        particleSpawnerList = new HashMap();
        renderBlockEventMap = new ArrayList(4096);
        entityWalkingEventMap = new ArrayList(4096);
        randomDisplayEventMap = new ArrayList(4096);
        blackList = new boolean[4096];
        standardIndex = new OptionChoice("", "", "", "s", new String[][]{{"s"}});
        minecraft = xpzm._E();
        for (n = 0; n < 4096; ++n) {
            renderBlockEventMap.add(null);
        }
        for (n = 0; n < 4096; ++n) {
            entityWalkingEventMap.add(null);
        }
        for (n = 0; n < 4096; ++n) {
            randomDisplayEventMap.add(null);
        }
    }
}

