/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.customcraft;

import cpw.mods.fml.common.registry.GameRegistry;

public class pidb
extends mqrl {
    @Override
    public String _a() {
        return "shapeless_craft";
    }

    @Override
    public void _b(rpaa rpaa2) {
        cvzo cvzo2 = rpaa2._o("result");
        Object[] objectArray = rpaa2._p("recipe");
        GameRegistry.addShapelessRecipe(cvzo2, objectArray);
    }

    @Override
    public boolean _b() {
        return false;
    }
}

