/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.mcsa;

import gloomyfolken.mods.effects.client.mcsa.jgro;
import gloomyfolken.mods.effects.client.mcsa.tupg;
import java.util.Collections;
import net.minecraft.util.ResourceLocation;

public class pidb
extends hsnd<tupg> {
    public final ResourceLocation _a;

    public pidb(ResourceLocation resourceLocation) {
        this._a = resourceLocation;
    }

    @Override
    protected void _d() {
        jgro jgro2 = new jgro("default");
        jgro2._a("diffuse map " + this._a);
        jgro2._b(false);
        tupg tupg2 = new tupg(Collections.singletonList(jgro2));
        tupg2._b = jgro2;
        this._a(tupg2, oxca.kjui._c);
    }

    @Override
    protected void _a(tupg tupg2) {
        tupg2.release();
    }
}

