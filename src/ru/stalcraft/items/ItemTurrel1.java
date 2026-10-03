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
import ru.stalcraft.entity.EntityTurrel1;
import ru.stalcraft.items.ItemTurrel;

public class ItemTurrel1
extends ItemTurrel {
    public ItemTurrel1(int par1) {
        super(par1);
        this.b("turrel1");
        this.d("stalker:turrel1");
        LanguageRegistry.addName((Object)this, (String)"\u041b\u0435\u0433\u043a\u0430\u044f \u0442\u0443\u0440\u0435\u043b\u044c");
    }

    @Override
    protected EntityTurrel getTurrel(abw world, String clanName, asx agroZone) {
        return new EntityTurrel1(world, clanName, agroZone);
    }
}

