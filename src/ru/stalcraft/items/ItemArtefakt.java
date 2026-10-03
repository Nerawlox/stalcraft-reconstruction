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
import java.util.List;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.items.IArtefakt;

public class ItemArtefakt
extends yc
implements IArtefakt {
    private int[] protection = new int[]{0, 0, 0, 0};
    private boolean[] immunity = new boolean[]{false, false, false, false};
    private String textureName;
    private float speedFactor;
    private float bulletDamageFactor;
    private float jumpIncrease;
    private boolean fireResistance;
    private boolean waterWalking;
    private int fallProtection;
    private List description;
    private static int nextId = 0;

    public ItemArtefakt(int id, String localizedName, String textureName, List description, int[] protection, boolean[] immunity, float speedFactor, float bulletDamageFactor, float jumpIncrease, boolean fireResistance, boolean waterWalking, int fallProtection) {
        super(id - 256);
        this.protection = protection;
        this.immunity = immunity;
        this.a(StalkerMain.tab);
        this.b("itemartefact" + ++nextId);
        this.textureName = textureName;
        this.speedFactor = speedFactor;
        this.bulletDamageFactor = bulletDamageFactor;
        this.jumpIncrease = jumpIncrease;
        this.fireResistance = fireResistance;
        this.waterWalking = waterWalking;
        this.description = description;
        this.fallProtection = fallProtection;
        LanguageRegistry.addName((Object)this, (String)localizedName);
    }

    @Override
    public float getSpeedFactor() {
        return this.speedFactor;
    }

    @Override
    public float getBulletDamageFactor() {
        return this.bulletDamageFactor;
    }

    @Override
    public float getJumpIncrease() {
        return this.jumpIncrease;
    }

    @Override
    public boolean getFireResistance() {
        return this.fireResistance;
    }

    @Override
    public boolean getWaterWalking() {
        return this.waterWalking;
    }

    @Override
    public int getFallProtection() {
        return this.fallProtection;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(ye par1ItemStack, uf par2EntityPlayer, List par3List, boolean par4) {
        par3List.addAll(this.description);
    }

    @Override
    public boolean getImmunity(int effectID) {
        return this.immunity[effectID];
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
        this.cz = par1IconRegister.a("stalker:" + this.textureName);
    }

    @Override
    public int getProtection(int effectID) {
        return this.protection[effectID];
    }

    @Override
    public int getEntityLifespan(ye itemStack, abw world) {
        return 288000;
    }
}

