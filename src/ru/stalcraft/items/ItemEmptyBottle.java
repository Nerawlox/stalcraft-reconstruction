/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.registry.LanguageRegistry
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  mt
 */
package ru.stalcraft.items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ru.stalcraft.StalkerMain;

public class ItemEmptyBottle
extends yc {
    public ItemEmptyBottle(int par1) {
        super(par1);
        this.a(StalkerMain.tab);
        this.b("empty_bottle");
        LanguageRegistry.addName((Object)this, (String)"\u0411\u0443\u0442\u044b\u043b\u043a\u0430");
    }

    public int getDamageVsEntity(nn par1Entity) {
        return 2;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
        this.cz = par1IconRegister.a("stalker:empty_bottle");
    }
}

