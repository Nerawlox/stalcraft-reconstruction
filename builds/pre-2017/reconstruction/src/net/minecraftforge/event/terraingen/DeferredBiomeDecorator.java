/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.terraingen;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.BiomeEvent;

public class DeferredBiomeDecorator
extends BiomeDecorator {
    private BiomeDecorator wrapped;

    public DeferredBiomeDecorator(BiomeGenBase biomeGenBase, BiomeDecorator biomeDecorator) {
        super(biomeGenBase);
        this.wrapped = biomeDecorator;
    }

    @Override
    public void decorate(World world, Random random, int n, int n2) {
        this.fireCreateEventAndReplace();
        this.biome._I.decorate(world, random, n, n2);
    }

    public void fireCreateEventAndReplace() {
        this.wrapped.bigMushroomsPerChunk = this.bigMushroomsPerChunk;
        this.wrapped.cactiPerChunk = this.cactiPerChunk;
        this.wrapped.clayPerChunk = this.clayPerChunk;
        this.wrapped.deadBushPerChunk = this.deadBushPerChunk;
        this.wrapped.flowersPerChunk = this.flowersPerChunk;
        this.wrapped.generateLakes = this.generateLakes;
        this.wrapped.grassPerChunk = this.grassPerChunk;
        this.wrapped.mushroomsPerChunk = this.mushroomsPerChunk;
        this.wrapped.reedsPerChunk = this.reedsPerChunk;
        this.wrapped.sandPerChunk = this.sandPerChunk;
        this.wrapped.sandPerChunk2 = this.sandPerChunk2;
        this.wrapped.treesPerChunk = this.treesPerChunk;
        this.wrapped.waterlilyPerChunk = this.waterlilyPerChunk;
        BiomeEvent.CreateDecorator createDecorator = new BiomeEvent.CreateDecorator(this.biome, this.wrapped);
        MinecraftForge.TERRAIN_GEN_BUS.post(createDecorator);
        this.biome._I = createDecorator.newBiomeDecorator;
    }
}

