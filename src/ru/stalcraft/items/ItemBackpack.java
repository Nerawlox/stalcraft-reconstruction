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

public class ItemBackpack
extends yc {
    public final int weightModifier;
    private String textureName;

    public ItemBackpack(int par1, String textureName, String localizedName, int weightModifier) {
        super(par1);
        this.weightModifier = weightModifier;
        this.textureName = textureName;
        this.a(StalkerMain.tab);
        this.b(textureName);
        LanguageRegistry.addName((Object)this, (String)localizedName);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
        this.cz = par1IconRegister.a("stalker:" + this.textureName);
    }
}

