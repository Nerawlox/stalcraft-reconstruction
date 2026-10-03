/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asx
 *  cpw.mods.fml.common.registry.LanguageRegistry
 */
package ru.stalcraft.items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import ru.stalcraft.entity.EntityTurrel;
import ru.stalcraft.entity.EntityTurrel3;
import ru.stalcraft.items.ItemTurrel;

public class ItemTurrel3
extends ItemTurrel {
    public ItemTurrel3(int par1) {
        super(par1);
        this.b("turrel3");
        this.d("stalker:turrel3");
        LanguageRegistry.addName((Object)this, (String)"\u0422\u044f\u0436\u0435\u043b\u0430\u044f \u0442\u0443\u0440\u0435\u043b\u044c");
    }

    @Override
    protected EntityTurrel getTurrel(abw world, String clanName, asx agroZone) {
        return new EntityTurrel3(world, clanName, agroZone);
    }
}

