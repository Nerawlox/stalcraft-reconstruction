/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.skinarmor;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyCore;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.src.ModLoader;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ISpecialArmor;

public class kjui
extends ItemArmor
implements ISpecialArmor {
    public static EnumArmorMaterial _a = EnumArmorMaterial._e;

    public kjui(int n, int n2) {
        super(n - 256, _a, kjui._a(_a.name().toLowerCase() + kjui._a(n2)), n2);
        this.setCreativeTab(GloomyCore.tab);
        this.setUnlocalizedName("armor" + this.itemID);
        this.setTextureName("skinarmor:skin");
        LanguageRegistry.addName(this, "\u041a\u043e\u043c\u043f\u043b\u0435\u043a\u0442 \u043e\u0434\u0435\u0436\u0434\u044b");
    }

    public static int _a(String string) {
        if (GloomyCore.side == Side.CLIENT) {
            return ModLoader.addArmor(string);
        }
        return 1;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public boolean requiresMultipleRenderPasses() {
        return false;
    }

    @Override
    public boolean hasColor(ItemStack itemStack) {
        return false;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public String getArmorTexture(ItemStack itemStack, Entity entity, int n, int n2) {
        return "skinarmor:textures/armor/empty.png";
    }

    public static String _a(int n) {
        if (n == 0) {
            return "_helm";
        }
        if (n == 1) {
            return "_chest";
        }
        if (n == 2) {
            return "_legs";
        }
        if (n == 3) {
            return "_boots";
        }
        return "";
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list2, boolean bl) {
        NBTTagCompound nBTTagCompound = ncwh._c(itemStack);
        String string = nBTTagCompound._j("desc");
        if (string.isEmpty()) {
            list2.add("\u041d\u0435\u0442 \u043e\u043f\u0438\u0441\u0430\u043d\u0438\u044f");
        } else {
            list2.add(nBTTagCompound._j("desc"));
        }
        if (entityPlayer.capabilities._d) {
            String string2 = nBTTagCompound._j("skin");
            if (string2.isEmpty()) {
                list2.add("\u0421\u043a\u0438\u043d \u043d\u0435 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d");
            } else {
                list2.add("\u0420\u0430\u0441\u043f\u043e\u043b\u043e\u0436\u0435\u043d\u0438\u0435 \u0441\u043a\u0438\u043d\u0430: " + nBTTagCompound._j("skin"));
            }
        }
    }

    @Override
    public ISpecialArmor.ArmorProperties getProperties(EntityLivingBase entityLivingBase, ItemStack itemStack, DamageSource damageSource, double d, int n) {
        return new ISpecialArmor.ArmorProperties(0, 0.0, 0);
    }

    @Override
    public int getArmorDisplay(EntityPlayer entityPlayer, ItemStack itemStack, int n) {
        return 0;
    }

    @Override
    public void damageArmor(EntityLivingBase entityLivingBase, ItemStack itemStack, DamageSource damageSource, int n, int n2) {
    }
}

