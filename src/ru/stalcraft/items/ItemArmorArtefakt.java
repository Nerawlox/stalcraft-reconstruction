/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  cpw.mods.fml.common.FMLCommonHandler
 *  cpw.mods.fml.common.registry.LanguageRegistry
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  mt
 *  wh
 */
package ru.stalcraft.items;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.items.IArtefakt;
import ru.stalcraft.items.IStalkerArmor;

public class ItemArmorArtefakt
extends wh
implements IArtefakt,
IStalkerArmor {
    private static String EMPTY_TEXTURE = "empty";
    public int[] protection = new int[]{0, 0, 0, 0};
    public boolean[] immunity = new boolean[]{false, false, false, false};
    private String itemTexture;
    public final String setID;
    private String modelTexture;
    public bjo specialModelTexture;
    public final String specialModelName;
    private float speedFactor;
    private float bulletDamageFactor;
    private float jumpIncrease;
    private boolean fireResistance;
    private boolean waterWalking;
    private int fallProtection;
    private List description;
    public String extension;
    private static int nextId = 0;

    public ItemArmorArtefakt(int id, int armorSlot, wj material, String itemTexture, String modelTexture, String specialModel, String extension, String localizedName, List description, String setID, int[] protection, boolean[] immunity, float speedFactor, float bulletDamageFactor, float jumpIncrease, boolean fireResistance, boolean waterWalking, int fallProtection) {
        super(id - 256, material, ItemArmorArtefakt.addArmor(material.name().toLowerCase() + ItemArmorArtefakt.getSuffix(armorSlot)), armorSlot);
        this.protection = protection;
        this.immunity = immunity;
        this.a(StalkerMain.tabArmor);
        this.b(material.name().toLowerCase() + ItemArmorArtefakt.getSuffix(this.b));
        this.itemTexture = itemTexture;
        if (specialModel != null && !specialModel.isEmpty() && !modelTexture.isEmpty()) {
            this.specialModelTexture = new bjo("stalker", "models/armor/" + modelTexture + ".png");
            modelTexture = EMPTY_TEXTURE;
        }
        this.modelTexture = "stalker:textures/armor/" + modelTexture + ".png";
        this.specialModelName = specialModel;
        this.speedFactor = speedFactor;
        this.bulletDamageFactor = bulletDamageFactor;
        this.jumpIncrease = jumpIncrease;
        this.fireResistance = fireResistance;
        this.waterWalking = waterWalking;
        this.description = description;
        this.fallProtection = fallProtection;
        this.setID = setID != null && setID.isEmpty() ? null : setID;
        this.extension = extension;
        LanguageRegistry.addName((Object)this, (String)localizedName);
    }

    @Override
    public int getFallProtection() {
        return this.fallProtection;
    }

    @Override
    public float getSpeedFactor() {
        return 1.0f;
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

    @SideOnly(value=Side.CLIENT)
    public void a(ye par1ItemStack, uf par2EntityPlayer, List par3, boolean par4) {
        par3.addAll(this.description);
        par3.add("\u00a7" + (this.protection[0] > 0 ? "2" : "4") + "\u0420\u0430\u0434\u0438\u0430\u0446\u0438\u044f: " + this.protection[0] + "%");
        par3.add("\u00a7" + (this.protection[1] > 0 ? "2" : "4") + "\u0425\u0438\u043c. \u043e\u0436\u043e\u0433: " + this.protection[1] + "%");
        par3.add("\u00a7" + (this.protection[2] > 0 ? "2" : "4") + "\u0411\u0438\u043e. \u0437\u0430\u0440\u0430\u0436\u0435\u043d\u0438\u0435: " + this.protection[2] + "%");
        par3.add("\u00a7" + (this.protection[3] > 0 ? "2" : "4") + "\u0422\u0435\u043b\u0435\u043f\u0430\u0442: " + this.protection[3] + "%");
        par3.add("\u00a7" + (this.bulletDamageFactor > 0.0f ? "2" : "4") + "\u041f\u0443\u043b\u0435\u0441\u0442\u043e\u0439\u043a\u043e\u0441\u0442\u044c: " + this.bulletDamageFactor + "%");
    }

    @Override
    public boolean getImmunity(int effectID) {
        return this.immunity[effectID];
    }

    @Override
    public int getProtection(int effectID) {
        return this.protection[effectID];
    }

    @SideOnly(value=Side.CLIENT)
    public boolean b() {
        return false;
    }

    public boolean a(ye par1ItemStack) {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public String getArmorTexture(ye stack, nn entity, int slot, int layer) {
        return "stalker:textures/armor/empty.png";
    }

    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
        this.cz = par1IconRegister.a("stalker:" + this.itemTexture);
    }

    public static String getSuffix(int armorType) {
        return armorType == 0 ? "_helm" : (armorType == 1 ? "_chest" : (armorType == 2 ? "_legs" : (armorType == 3 ? "_boots" : "")));
    }

    public static int addArmor(String set) {
        Side side = FMLCommonHandler.instance().getEffectiveSide();
        return side == Side.CLIENT ? ModLoader.addArmor(set) : 1;
    }

    public int getEntityLifespan(ye itemStack, abw world) {
        return 288000;
    }

    @Override
    public String getSetID() {
        return this.setID;
    }

    @Override
    public int getArmorType() {
        return this.b;
    }
}

