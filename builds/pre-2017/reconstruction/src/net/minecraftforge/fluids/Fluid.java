/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.fluids;

import com.google.common.collect.Maps;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.LoaderException;
import java.util.Locale;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.util.Icon;
import net.minecraft.util.tdpx;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDummyContainer;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class Fluid {
    protected final String fluidName;
    protected String unlocalizedName;
    protected Icon stillIcon;
    protected Icon flowingIcon;
    protected int luminosity = 0;
    protected int density = 1000;
    protected int temperature = 295;
    protected int viscosity = 1000;
    protected boolean isGaseous;
    protected EnumRarity rarity = EnumRarity._a;
    protected int blockID = -1;
    private static Map<String, String> legacyNames = Maps.newHashMap();

    public Fluid(String string) {
        this.fluidName = string.toLowerCase(Locale.ENGLISH);
        this.unlocalizedName = string;
    }

    public Fluid setUnlocalizedName(String string) {
        this.unlocalizedName = string;
        return this;
    }

    public Fluid setBlockID(int n) {
        if (this.blockID == -1 || this.blockID == n) {
            this.blockID = n;
        } else if (!ForgeDummyContainer.forceDuplicateFluidBlockCrash) {
            FMLLog.warning("A mod has attempted to assign BlockID " + n + " to the Fluid '" + this.fluidName + "' but this Fluid has already been linked to BlockID " + this.blockID + ". Configure your mods to prevent this from happening.", new Object[0]);
        } else {
            FMLLog.severe("A mod has attempted to assign BlockID " + n + " to the Fluid '" + this.fluidName + "' but this Fluid has already been linked to BlockID " + this.blockID + ". Configure your mods to prevent this from happening.", new Object[0]);
            throw new LoaderException(new RuntimeException("A mod has attempted to assign BlockID " + n + " to the Fluid '" + this.fluidName + "' but this Fluid has already been linked to BlockID " + this.blockID + ". Configure your mods to prevent this from happening."));
        }
        return this;
    }

    public Fluid setBlockID(Block block) {
        return this.setBlockID(block.blockID);
    }

    public Fluid setLuminosity(int n) {
        this.luminosity = n;
        return this;
    }

    public Fluid setDensity(int n) {
        this.density = n;
        return this;
    }

    public Fluid setTemperature(int n) {
        this.temperature = n;
        return this;
    }

    public Fluid setViscosity(int n) {
        this.viscosity = n;
        return this;
    }

    public Fluid setGaseous(boolean bl) {
        this.isGaseous = bl;
        return this;
    }

    public Fluid setRarity(EnumRarity enumRarity) {
        this.rarity = enumRarity;
        return this;
    }

    public final String getName() {
        return this.fluidName;
    }

    public final int getID() {
        return FluidRegistry.getFluidID(this.fluidName);
    }

    public final int getBlockID() {
        return this.blockID;
    }

    public final boolean canBePlacedInWorld() {
        return this.blockID != -1;
    }

    public String getLocalizedName() {
        String string = this.getUnlocalizedName();
        return string == null ? "" : tdpx._a(string);
    }

    public String getUnlocalizedName() {
        return "fluid." + this.unlocalizedName;
    }

    public final int getSpriteNumber() {
        return 0;
    }

    public final int getLuminosity() {
        return this.luminosity;
    }

    public final int getDensity() {
        return this.density;
    }

    public final int getTemperature() {
        return this.temperature;
    }

    public final int getViscosity() {
        return this.viscosity;
    }

    public final boolean isGaseous() {
        return this.isGaseous;
    }

    public EnumRarity getRarity() {
        return this.rarity;
    }

    public int getColor() {
        return 0xFFFFFF;
    }

    public final Fluid setStillIcon(Icon icon) {
        this.stillIcon = icon;
        return this;
    }

    public final Fluid setFlowingIcon(Icon icon) {
        this.flowingIcon = icon;
        return this;
    }

    public final Fluid setIcons(Icon icon, Icon icon2) {
        return this.setStillIcon(icon).setFlowingIcon(icon2);
    }

    public final Fluid setIcons(Icon icon) {
        return this.setStillIcon(icon).setFlowingIcon(icon);
    }

    public Icon getIcon() {
        return this.getStillIcon();
    }

    public Icon getStillIcon() {
        return this.stillIcon;
    }

    public Icon getFlowingIcon() {
        return this.flowingIcon;
    }

    public int getLuminosity(FluidStack fluidStack) {
        return this.getLuminosity();
    }

    public int getDensity(FluidStack fluidStack) {
        return this.getDensity();
    }

    public int getTemperature(FluidStack fluidStack) {
        return this.getTemperature();
    }

    public int getViscosity(FluidStack fluidStack) {
        return this.getViscosity();
    }

    public boolean isGaseous(FluidStack fluidStack) {
        return this.isGaseous();
    }

    public EnumRarity getRarity(FluidStack fluidStack) {
        return this.getRarity();
    }

    public int getColor(FluidStack fluidStack) {
        return this.getColor();
    }

    public Icon getIcon(FluidStack fluidStack) {
        return this.getIcon();
    }

    public int getLuminosity(World world, int n, int n2, int n3) {
        return this.getLuminosity();
    }

    public int getDensity(World world, int n, int n2, int n3) {
        return this.getDensity();
    }

    public int getTemperature(World world, int n, int n2, int n3) {
        return this.getTemperature();
    }

    public int getViscosity(World world, int n, int n2, int n3) {
        return this.getViscosity();
    }

    public boolean isGaseous(World world, int n, int n2, int n3) {
        return this.isGaseous();
    }

    public EnumRarity getRarity(World world, int n, int n2, int n3) {
        return this.getRarity();
    }

    public int getColor(World world, int n, int n2, int n3) {
        return this.getColor();
    }

    public Icon getIcon(World world, int n, int n2, int n3) {
        return this.getIcon();
    }

    static String convertLegacyName(String string) {
        return string != null && legacyNames.containsKey(string) ? legacyNames.get(string) : string;
    }

    public static void registerLegacyName(String string, String string2) {
        legacyNames.put(string.toLowerCase(Locale.ENGLISH), string2);
    }
}

