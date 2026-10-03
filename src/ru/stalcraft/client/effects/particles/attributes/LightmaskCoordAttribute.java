/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.ReflectionHelper
 */
package ru.stalcraft.client.effects.particles.attributes;

import cpw.mods.fml.relauncher.ReflectionHelper;
import ru.stalcraft.client.effects.particles.Particle;
import ru.stalcraft.client.effects.particles.attributes.Attribute;

public class LightmaskCoordAttribute
extends Attribute {
    public LightmaskCoordAttribute() {
        super("brightness", 3);
    }

    @Override
    public void writeToBuffer(Particle particle, float frame) {
        int l2 = particle.getTessellatorBrightness();
        int[] lightmapColors = (int[])ReflectionHelper.getPrivateValue(bfe.class, (Object)atv.w().p, (String[])new String[]{"lightmapColors", "field_78504_Q", "Q"});
        int b2 = lightmapColors[l2 / 65536 + l2 % 65536 / 16];
        this.buffer.put((float)(b2 >> 16 & 0xFF) / 255.0f);
        this.buffer.put((float)(b2 >> 8 & 0xFF) / 255.0f);
        this.buffer.put((float)(b2 & 0xFF) / 255.0f);
    }
}

