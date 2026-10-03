/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.terraingen;

import java.util.Random;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.event.terraingen.InitNoiseGensEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;

public abstract class TerrainGen {
    public static mcfq[] getModdedNoiseGenerators(ozlu ozlu2, Random random, mcfq[] mcfqArray) {
        InitNoiseGensEvent initNoiseGensEvent = new InitNoiseGensEvent(ozlu2, random, mcfqArray);
        MinecraftForge.TERRAIN_GEN_BUS.post(initNoiseGensEvent);
        return initNoiseGensEvent.newNoiseGens;
    }

    public static yfis getModdedMapGen(yfis yfis2, InitMapGenEvent.EventType eventType) {
        InitMapGenEvent initMapGenEvent = new InitMapGenEvent(eventType, yfis2);
        MinecraftForge.TERRAIN_GEN_BUS.post(initMapGenEvent);
        return initMapGenEvent.newGen;
    }

    public static boolean populate(mccn mccn2, ozlu ozlu2, Random random, int n, int n2, boolean bl, PopulateChunkEvent.Populate.EventType eventType) {
        PopulateChunkEvent.Populate populate = new PopulateChunkEvent.Populate(mccn2, ozlu2, random, n, n2, bl, eventType);
        MinecraftForge.TERRAIN_GEN_BUS.post(populate);
        return populate.getResult() != Event.Result.DENY;
    }

    public static boolean decorate(ozlu ozlu2, Random random, int n, int n2, DecorateBiomeEvent.Decorate.EventType eventType) {
        DecorateBiomeEvent.Decorate decorate = new DecorateBiomeEvent.Decorate(ozlu2, random, n, n2, eventType);
        MinecraftForge.TERRAIN_GEN_BUS.post(decorate);
        return decorate.getResult() != Event.Result.DENY;
    }

    public static boolean generateOre(ozlu ozlu2, Random random, zzpm zzpm2, int n, int n2, OreGenEvent.GenerateMinable.EventType eventType) {
        OreGenEvent.GenerateMinable generateMinable = new OreGenEvent.GenerateMinable(ozlu2, random, zzpm2, n, n2, eventType);
        MinecraftForge.ORE_GEN_BUS.post(generateMinable);
        return generateMinable.getResult() != Event.Result.DENY;
    }

    public static boolean saplingGrowTree(ozlu ozlu2, Random random, int n, int n2, int n3) {
        SaplingGrowTreeEvent saplingGrowTreeEvent = new SaplingGrowTreeEvent(ozlu2, random, n, n2, n3);
        MinecraftForge.TERRAIN_GEN_BUS.post(saplingGrowTreeEvent);
        return saplingGrowTreeEvent.getResult() != Event.Result.DENY;
    }
}

