/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.biome;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BiomeDecorator {
    public World currentWorld;
    public Random randomGenerator;
    public int chunk_X;
    public int chunk_Z;
    public BiomeGenBase biome;
    public WorldGenerator clayGen = new xcez(4);
    public WorldGenerator sandGen;
    public WorldGenerator gravelAsSandGen;
    public WorldGenerator dirtGen;
    public WorldGenerator gravelGen;
    public WorldGenerator coalGen;
    public WorldGenerator ironGen;
    public WorldGenerator goldGen;
    public WorldGenerator redstoneGen;
    public WorldGenerator diamondGen;
    public WorldGenerator lapisGen;
    public WorldGenerator plantYellowGen;
    public WorldGenerator plantRedGen;
    public WorldGenerator mushroomBrownGen;
    public WorldGenerator mushroomRedGen;
    public WorldGenerator bigMushroomGen;
    public WorldGenerator reedGen;
    public WorldGenerator cactusGen;
    public WorldGenerator waterlilyGen;
    public int waterlilyPerChunk;
    public int treesPerChunk;
    public int flowersPerChunk;
    public int grassPerChunk;
    public int deadBushPerChunk;
    public int mushroomsPerChunk;
    public int reedsPerChunk;
    public int cactiPerChunk;
    public int sandPerChunk;
    public int sandPerChunk2;
    public int clayPerChunk;
    public int bigMushroomsPerChunk;
    public boolean generateLakes;

    public BiomeDecorator(BiomeGenBase biomeGenBase) {
        this.sandGen = new gatb(7, Block.sand.blockID);
        this.gravelAsSandGen = new gatb(6, Block.gravel.blockID);
        this.dirtGen = new qoqx(Block.dirt.blockID, 32);
        this.gravelGen = new qoqx(Block.gravel.blockID, 32);
        this.coalGen = new qoqx(Block.oreCoal.blockID, 16);
        this.ironGen = new qoqx(Block.oreIron.blockID, 8);
        this.goldGen = new qoqx(Block.oreGold.blockID, 8);
        this.redstoneGen = new qoqx(Block.oreRedstone.blockID, 7);
        this.diamondGen = new qoqx(Block.oreDiamond.blockID, 7);
        this.lapisGen = new qoqx(Block.oreLapis.blockID, 6);
        this.plantYellowGen = new xces(Block.plantYellow.blockID);
        this.plantRedGen = new xces(Block.plantRed.blockID);
        this.mushroomBrownGen = new xces(Block.mushroomBrown.blockID);
        this.mushroomRedGen = new xces(Block.mushroomRed.blockID);
        this.bigMushroomGen = new foso();
        this.reedGen = new wqci();
        this.cactusGen = new cfka();
        this.waterlilyGen = new cwnd();
        this.flowersPerChunk = 2;
        this.grassPerChunk = 1;
        this.sandPerChunk = 1;
        this.sandPerChunk2 = 3;
        this.clayPerChunk = 1;
        this.generateLakes = true;
        this.biome = biomeGenBase;
    }

    public void decorate(World world, Random random, int n, int n2) {
        if (this.currentWorld != null) {
            throw new RuntimeException("Already decorating!!");
        }
        this.currentWorld = world;
        this.randomGenerator = random;
        this.chunk_X = n;
        this.chunk_Z = n2;
        this.decorate();
        this.currentWorld = null;
        this.randomGenerator = null;
    }

    public void decorate() {
        int n;
        int n2;
        int n3;
        int n4;
        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z));
        this.generateOres();
        boolean bl = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.SAND);
        for (n4 = 0; bl && n4 < this.sandPerChunk2; ++n4) {
            n3 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            n2 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            this.sandGen._a(this.currentWorld, this.randomGenerator, n3, this.currentWorld.getTopSolidOrLiquidBlock(n3, n2), n2);
        }
        bl = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.CLAY);
        for (n4 = 0; bl && n4 < this.clayPerChunk; ++n4) {
            n3 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            n2 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            this.clayGen._a(this.currentWorld, this.randomGenerator, n3, this.currentWorld.getTopSolidOrLiquidBlock(n3, n2), n2);
        }
        bl = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.SAND_PASS2);
        for (n4 = 0; bl && n4 < this.sandPerChunk; ++n4) {
            n3 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            n2 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            this.sandGen._a(this.currentWorld, this.randomGenerator, n3, this.currentWorld.getTopSolidOrLiquidBlock(n3, n2), n2);
        }
        n4 = this.treesPerChunk;
        if (this.randomGenerator.nextInt(10) == 0) {
            ++n4;
        }
        bl = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.TREE);
        for (n3 = 0; bl && n3 < n4; ++n3) {
            n2 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            n = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            WorldGenerator worldGenerator = this.biome._a(this.randomGenerator);
            worldGenerator._a(1.0, 1.0, 1.0);
            worldGenerator._a(this.currentWorld, this.randomGenerator, n2, this.currentWorld.getHeightValue(n2, n), n);
        }
        bl = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.BIG_SHROOM);
        for (n3 = 0; bl && n3 < this.bigMushroomsPerChunk; ++n3) {
            n2 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            n = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            this.bigMushroomGen._a(this.currentWorld, this.randomGenerator, n2, this.currentWorld.getHeightValue(n2, n), n);
        }
        bl = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.FLOWERS);
        for (n3 = 0; bl && n3 < this.flowersPerChunk; ++n3) {
            n2 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            n = this.randomGenerator.nextInt(128);
            int n5 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            this.plantYellowGen._a(this.currentWorld, this.randomGenerator, n2, n, n5);
            if (this.randomGenerator.nextInt(4) != 0) continue;
            n2 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            n = this.randomGenerator.nextInt(128);
            n5 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            this.plantRedGen._a(this.currentWorld, this.randomGenerator, n2, n, n5);
        }
        bl = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.GRASS);
        for (n3 = 0; bl && n3 < this.grassPerChunk; ++n3) {
            n2 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            n = this.randomGenerator.nextInt(128);
            int n6 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            WorldGenerator worldGenerator = this.biome._b(this.randomGenerator);
            worldGenerator._a(this.currentWorld, this.randomGenerator, n2, n, n6);
        }
        bl = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.DEAD_BUSH);
        for (n3 = 0; bl && n3 < this.deadBushPerChunk; ++n3) {
            n2 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            n = this.randomGenerator.nextInt(128);
            int n7 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            new grvt(Block.deadBush.blockID)._a(this.currentWorld, this.randomGenerator, n2, n, n7);
        }
        bl = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.LILYPAD);
        for (n3 = 0; bl && n3 < this.waterlilyPerChunk; ++n3) {
            int n8;
            n2 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            n = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            for (n8 = this.randomGenerator.nextInt(128); n8 > 0 && this.currentWorld.getBlockId(n2, n8 - 1, n) == 0; --n8) {
            }
            this.waterlilyGen._a(this.currentWorld, this.randomGenerator, n2, n8, n);
        }
        bl = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.SHROOM);
        for (n3 = 0; bl && n3 < this.mushroomsPerChunk; ++n3) {
            int n9;
            if (this.randomGenerator.nextInt(4) == 0) {
                n2 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                n = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                n9 = this.currentWorld.getHeightValue(n2, n);
                this.mushroomBrownGen._a(this.currentWorld, this.randomGenerator, n2, n9, n);
            }
            if (this.randomGenerator.nextInt(8) != 0) continue;
            n2 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            n = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            n9 = this.randomGenerator.nextInt(128);
            this.mushroomRedGen._a(this.currentWorld, this.randomGenerator, n2, n9, n);
        }
        if (bl && this.randomGenerator.nextInt(4) == 0) {
            n3 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            n2 = this.randomGenerator.nextInt(128);
            n = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            this.mushroomBrownGen._a(this.currentWorld, this.randomGenerator, n3, n2, n);
        }
        if (bl && this.randomGenerator.nextInt(8) == 0) {
            n3 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            n2 = this.randomGenerator.nextInt(128);
            n = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            this.mushroomRedGen._a(this.currentWorld, this.randomGenerator, n3, n2, n);
        }
        bl = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.REED);
        for (n3 = 0; bl && n3 < this.reedsPerChunk; ++n3) {
            n2 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            n = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            int n10 = this.randomGenerator.nextInt(128);
            this.reedGen._a(this.currentWorld, this.randomGenerator, n2, n10, n);
        }
        for (n3 = 0; bl && n3 < 10; ++n3) {
            n2 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            n = this.randomGenerator.nextInt(128);
            int n11 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            this.reedGen._a(this.currentWorld, this.randomGenerator, n2, n, n11);
        }
        bl = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.PUMPKIN);
        if (bl && this.randomGenerator.nextInt(32) == 0) {
            n3 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            n2 = this.randomGenerator.nextInt(128);
            n = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            new knaa()._a(this.currentWorld, this.randomGenerator, n3, n2, n);
        }
        bl = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.CACTUS);
        for (n3 = 0; bl && n3 < this.cactiPerChunk; ++n3) {
            n2 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            n = this.randomGenerator.nextInt(128);
            int n12 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            this.cactusGen._a(this.currentWorld, this.randomGenerator, n2, n, n12);
        }
        bl = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.LAKE);
        if (bl && this.generateLakes) {
            for (n3 = 0; n3 < 50; ++n3) {
                n2 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                n = this.randomGenerator.nextInt(this.randomGenerator.nextInt(120) + 8);
                int n13 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                new xtgb(Block.waterMoving.blockID)._a(this.currentWorld, this.randomGenerator, n2, n, n13);
            }
            for (n3 = 0; n3 < 20; ++n3) {
                n2 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                n = this.randomGenerator.nextInt(this.randomGenerator.nextInt(this.randomGenerator.nextInt(112) + 8) + 8);
                int n14 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                new xtgb(Block.lavaMoving.blockID)._a(this.currentWorld, this.randomGenerator, n2, n, n14);
            }
        }
        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z));
    }

    public void genStandardOre1(int n, WorldGenerator worldGenerator, int n2, int n3) {
        for (int i = 0; i < n; ++i) {
            int n4 = this.chunk_X + this.randomGenerator.nextInt(16);
            int n5 = this.randomGenerator.nextInt(n3 - n2) + n2;
            int n6 = this.chunk_Z + this.randomGenerator.nextInt(16);
            worldGenerator._a(this.currentWorld, this.randomGenerator, n4, n5, n6);
        }
    }

    public void genStandardOre2(int n, WorldGenerator worldGenerator, int n2, int n3) {
        for (int i = 0; i < n; ++i) {
            int n4 = this.chunk_X + this.randomGenerator.nextInt(16);
            int n5 = this.randomGenerator.nextInt(n3) + this.randomGenerator.nextInt(n3) + (n2 - n3);
            int n6 = this.chunk_Z + this.randomGenerator.nextInt(16);
            worldGenerator._a(this.currentWorld, this.randomGenerator, n4, n5, n6);
        }
    }

    public void generateOres() {
        MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Pre(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z));
        if (TerrainGen.generateOre(this.currentWorld, this.randomGenerator, this.dirtGen, this.chunk_X, this.chunk_Z, OreGenEvent.GenerateMinable.EventType.DIRT)) {
            this.genStandardOre1(20, this.dirtGen, 0, 128);
        }
        if (TerrainGen.generateOre(this.currentWorld, this.randomGenerator, this.gravelGen, this.chunk_X, this.chunk_Z, OreGenEvent.GenerateMinable.EventType.GRAVEL)) {
            this.genStandardOre1(10, this.gravelGen, 0, 128);
        }
        if (TerrainGen.generateOre(this.currentWorld, this.randomGenerator, this.coalGen, this.chunk_X, this.chunk_Z, OreGenEvent.GenerateMinable.EventType.COAL)) {
            this.genStandardOre1(20, this.coalGen, 0, 128);
        }
        if (TerrainGen.generateOre(this.currentWorld, this.randomGenerator, this.ironGen, this.chunk_X, this.chunk_Z, OreGenEvent.GenerateMinable.EventType.IRON)) {
            this.genStandardOre1(20, this.ironGen, 0, 64);
        }
        if (TerrainGen.generateOre(this.currentWorld, this.randomGenerator, this.goldGen, this.chunk_X, this.chunk_Z, OreGenEvent.GenerateMinable.EventType.GOLD)) {
            this.genStandardOre1(2, this.goldGen, 0, 32);
        }
        if (TerrainGen.generateOre(this.currentWorld, this.randomGenerator, this.redstoneGen, this.chunk_X, this.chunk_Z, OreGenEvent.GenerateMinable.EventType.REDSTONE)) {
            this.genStandardOre1(8, this.redstoneGen, 0, 16);
        }
        if (TerrainGen.generateOre(this.currentWorld, this.randomGenerator, this.diamondGen, this.chunk_X, this.chunk_Z, OreGenEvent.GenerateMinable.EventType.DIAMOND)) {
            this.genStandardOre1(1, this.diamondGen, 0, 16);
        }
        if (TerrainGen.generateOre(this.currentWorld, this.randomGenerator, this.lapisGen, this.chunk_X, this.chunk_Z, OreGenEvent.GenerateMinable.EventType.LAPIS)) {
            this.genStandardOre2(1, this.lapisGen, 16, 16);
        }
        MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Post(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z));
    }
}

