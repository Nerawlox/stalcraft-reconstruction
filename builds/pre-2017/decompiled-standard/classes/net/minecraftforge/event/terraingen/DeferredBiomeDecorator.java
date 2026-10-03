/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.terraingen;

import java.util.Random;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.BiomeEvent;

public class DeferredBiomeDecorator
extends qoqn {
    private qoqn wrapped;

    public DeferredBiomeDecorator(foqh foqh2, qoqn qoqn2) {
        super(foqh2);
        this.wrapped = qoqn2;
    }

    @Override
    public void func_76796_a(ozlu ozlu2, Random random, int n, int n2) {
        this.fireCreateEventAndReplace();
        this.field_76812_e._I.func_76796_a(ozlu2, random, n, n2);
    }

    public void fireCreateEventAndReplace() {
        this.wrapped.field_76807_J = this.field_76807_J;
        this.wrapped.field_76800_F = this.field_76800_F;
        this.wrapped.field_76806_I = this.field_76806_I;
        this.wrapped.field_76804_C = this.field_76804_C;
        this.wrapped.field_76802_A = this.field_76802_A;
        this.wrapped.field_76808_K = this.field_76808_K;
        this.wrapped.field_76803_B = this.field_76803_B;
        this.wrapped.field_76798_D = this.field_76798_D;
        this.wrapped.field_76799_E = this.field_76799_E;
        this.wrapped.field_76801_G = this.field_76801_G;
        this.wrapped.field_76805_H = this.field_76805_H;
        this.wrapped.field_76832_z = this.field_76832_z;
        this.wrapped.field_76833_y = this.field_76833_y;
        BiomeEvent.CreateDecorator createDecorator = new BiomeEvent.CreateDecorator(this.field_76812_e, this.wrapped);
        MinecraftForge.TERRAIN_GEN_BUS.post(createDecorator);
        this.field_76812_e._I = createDecorator.newBiomeDecorator;
    }
}

