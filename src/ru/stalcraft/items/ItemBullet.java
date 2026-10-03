/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.registry.LanguageRegistry
 *  mt
 */
package ru.stalcraft.items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import java.util.List;
import ru.stalcraft.StalkerMain;

public class ItemBullet
extends yc {
    private final List description;
    private final String textureName;
    private static int nextId = 0;

    public ItemBullet(int id, String name, String textureName, List description, int stackSize) {
        super(id - 256);
        this.b("bullet" + ++nextId);
        this.a(StalkerMain.tab);
        this.textureName = textureName;
        LanguageRegistry.addName((Object)this, (String)name);
        this.description = description;
        this.cw = Math.max(1, Math.min(64, stackSize));
    }

    @Override
    public void a(mt par1IconRegister) {
        this.cz = par1IconRegister.a("stalker:" + this.textureName);
    }

    @Override
    public void a(ye par1ItemStack, uf par2EntityPlayer, List par3List, boolean par4) {
        par3List.addAll(this.description);
    }
}

