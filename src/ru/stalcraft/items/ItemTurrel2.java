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
import ru.stalcraft.entity.EntityTurrel2;
import ru.stalcraft.items.ItemTurrel;

public class ItemTurrel2
extends ItemTurrel {
    public ItemTurrel2(int par1) {
        super(par1);
        this.b("turrel2");
        this.d("stalker:turrel2");
        LanguageRegistry.addName((Object)this, (String)"\u0421\u0440\u0435\u0434\u043d\u044f\u044f \u0442\u0443\u0440\u0435\u043b\u044c");
    }

    @Override
    protected EntityTurrel getTurrel(abw world, String clanName, asx agroZone) {
        return new EntityTurrel2(world, clanName, agroZone);
    }
}

