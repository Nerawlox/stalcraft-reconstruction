/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.client.IItemRenderer
 */
package ru.stalcraft.client.effects.particles;

import net.minecraftforge.client.IItemRenderer;
import ru.stalcraft.client.effects.particles.ParticleEmitter;
import ru.stalcraft.tile.IParticleEmmiter;

public abstract class ParticleItemEmitter
extends ParticleEmitter {
    public ParticleItemEmitter(IParticleEmmiter emmiter, IItemRenderer renderSpawn) {
        super(emmiter);
    }
}

