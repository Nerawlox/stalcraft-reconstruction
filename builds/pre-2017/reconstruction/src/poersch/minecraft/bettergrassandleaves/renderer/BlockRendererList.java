/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
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
    private static Minecraft minecraft;
    private OptionChoice optionIndex = standardIndex;
    private final String name;
    private final int events;

    public BlockRendererList(String string, int n) {
        this.name = string;
        this.events = n;
        rendererList.add(this);
    }

    @Hook(targetMethod="registerIcons")
    public static void onRegisterIconsHook(BlockGrass blockGrass, IconRegister iconRegister) {
        BlockRenderer.initiateIconRegistration(iconRegister);
        BetterGrassAndLeavesMod.updatePlugins(iconRegister);
        for (BlockRendererList blockRendererList : rendererList) {
            for (int i = 0; i < blockRendererList.size(); ++i) {
                ((BlockRenderer)blockRendererList.get(i)).onRegisterIcons(iconRegister);
            }
        }
    }

    @Hook(createMethod=true, returnType="boolean")
    public static void hitByEntity(EntityLivingBase entityLivingBase, Entity entity) {
        BlockRendererList.onSpawnParticleHook("blood", entityLivingBase.worldObj, entityLivingBase.posX, entityLivingBase.posY, entityLivingBase.posZ, 0.0, 0.0, 0.0, entityLivingBase);
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean spawnParticle(World world, String string, double d, double d2, double d3, double d4, double d5, double d6) {
        return BlockRendererList.onSpawnParticleHook(string, world, d, d2, d3, d4, d5, d6, null);
    }

    public static boolean onSpawnParticleHook(String string, World world, double d, double d2, double d3, double d4, double d5, double d6, Entity entity) {
        BlockRendererList blockRendererList;
        boolean bl = CustomHooks.onSpawnParticle(string, entity);
        if (bl) {
            return false;
        }
        if (BetterGrassAndLeavesMod.modActive && (blockRendererList = particleSpawnerList.get(string)) != null) {
            boolean bl2 = true;
            return bl2 &= blockRendererList.getCurrentRenderer().onSpawnParticle(string, world, d, d2, d3, d4, d5, d6, entity);
        }
        return false;
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE, targetMethod="renderBlockByRenderType")
    public static boolean onRenderBlockHook(RenderBlocks renderBlocks, Block block, int n, int n2, int n3) {
        ArrayList<BlockRendererList> arrayList;
        if (BetterGrassAndLeavesMod.modActive && (arrayList = renderBlockEventMap.get(block.blockID)) != null) {
            BlockRenderer.tessellator.set(renderBlocks.__aF);
            boolean bl = true;
            for (int i = 0; i < arrayList.size(); ++i) {
                BlockRendererList blockRendererList = arrayList.get(i);
                bl &= blockRendererList.getCurrentRenderer().onRenderBlock(block, renderBlocks._a, n, n2, n3, renderBlocks);
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
            Block block;
            int n5;
            int n6;
            int n7 = n + pkix2.rand.nextInt(n4) - pkix2.rand.nextInt(n4);
            int n8 = pkix2.getBlockId(n7, n6 = n2 + pkix2.rand.nextInt(n4) - pkix2.rand.nextInt(n4), n5 = n3 + pkix2.rand.nextInt(n4) - pkix2.rand.nextInt(n4));
            if (n8 == 0 && pkix2.rand.nextInt(8) > n6 && pkix2.provider._j()) {
                pkix2.spawnParticle("depthsuspend", (float)n7 + pkix2.rand.nextFloat(), (float)n6 + pkix2.rand.nextFloat(), (float)n5 + pkix2.rand.nextFloat(), 0.0, 0.0, 0.0);
                continue;
            }
            if (n8 <= 0 || BlockRendererList.onRandomDisplayTickHook(block = Block.blocksList[n8], pkix2, n7, n6, n5, random)) continue;
            Block.blocksList[n8].randomDisplayTick(pkix2, n7, n6, n5, random);
        }
    }

    public static boolean onRandomDisplayTickHook(Block block, World world, int n, int n2, int n3, Random random) {
        ArrayList<BlockRendererList> arrayList;
        if (BetterGrassAndLeavesMod.modActive && (arrayList = randomDisplayEventMap.get(block.blockID)) != null) {
            boolean bl = true;
            for (int i = 0; i < arrayList.size(); ++i) {
                BlockRendererList blockRendererList = arrayList.get(i);
                bl &= blockRendererList.getCurrentRenderer().onRandomDisplayTick(block, world, n, n2, n3, random);
            }
            return bl;
        }
        return false;
    }

    @Hook(targetMethod="onEntityWalking", returnCondition=ReturnCondition.ON_TRUE)
    public static boolean onEntityWalkingHook(Block block, World world, int n, int n2, int n3, Entity entity) {
        ArrayList<BlockRendererList> arrayList;
        if (!(!BetterGrassAndLeavesMod.modActive || minecraft._I() && entity instanceof EntityPlayerMP || BlockRendererList.minecraft._u != null && !entity.isInRangeToRenderDist(entity.getDistanceSqToEntity(BlockRendererList.minecraft._u)) || (arrayList = entityWalkingEventMap.get(block.blockID)) == null)) {
            boolean bl = true;
            for (int i = 0; i < arrayList.size(); ++i) {
                BlockRendererList blockRendererList = arrayList.get(i);
                bl &= blockRendererList.getCurrentRenderer().onEntityWalking(block, world, n, n2, n3, entity);
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
        minecraft = Minecraft._E();
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

