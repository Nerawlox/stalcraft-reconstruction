/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import java.util.Collection;
import java.util.UUID;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.logging.ILogAgent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class sajz {
    public static final Attribute _a = new RangedAttribute("generic.maxHealth", 20.0, 0.0, Double.MAX_VALUE)._a("Max Health")._a(true);
    public static final Attribute _b = new RangedAttribute("generic.followRange", 32.0, 0.0, 2048.0)._a("Follow Range");
    public static final Attribute _c = new RangedAttribute("generic.knockbackResistance", 0.0, 0.0, 1.0)._a("Knockback Resistance");
    public static final Attribute _d = new RangedAttribute("generic.movementSpeed", 0.7f, 0.0, Double.MAX_VALUE)._a("Movement Speed")._a(true);
    public static final Attribute _e = new RangedAttribute("generic.attackDamage", 2.0, 0.0, Double.MAX_VALUE);

    public static NBTTagList _a(BaseAttributeMap baseAttributeMap) {
        NBTTagList nBTTagList = new NBTTagList();
        for (hubf hubf2 : baseAttributeMap._a()) {
            nBTTagList._a(sajz._a(hubf2));
        }
        return nBTTagList;
    }

    public static NBTTagCompound _a(hubf hubf2) {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        Attribute attribute = hubf2._a();
        nBTTagCompound._a("Name", attribute._a());
        nBTTagCompound._a("Base", hubf2._b());
        Collection collection = hubf2._c();
        if (collection != null && !collection.isEmpty()) {
            NBTTagList nBTTagList = new NBTTagList();
            for (AttributeModifier attributeModifier : collection) {
                if (!attributeModifier._e()) continue;
                nBTTagList._a(sajz._a(attributeModifier));
            }
            nBTTagCompound._a("Modifiers", nBTTagList);
        }
        return nBTTagCompound;
    }

    public static NBTTagCompound _a(AttributeModifier attributeModifier) {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        nBTTagCompound._a("Name", attributeModifier._b());
        nBTTagCompound._a("Amount", attributeModifier._d());
        nBTTagCompound._a("Operation", attributeModifier._c());
        nBTTagCompound._a("UUIDMost", attributeModifier._a().getMostSignificantBits());
        nBTTagCompound._a("UUIDLeast", attributeModifier._a().getLeastSignificantBits());
        return nBTTagCompound;
    }

    public static void _a(BaseAttributeMap baseAttributeMap, NBTTagList nBTTagList, ILogAgent iLogAgent) {
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            hubf hubf2 = baseAttributeMap._a(nBTTagCompound._j("Name"));
            if (hubf2 != null) {
                sajz._a(hubf2, nBTTagCompound);
                continue;
            }
            if (iLogAgent == null) continue;
            iLogAgent._b("Ignoring unknown attribute '" + nBTTagCompound._j("Name") + "'");
        }
    }

    public static void _a(hubf hubf2, NBTTagCompound nBTTagCompound) {
        hubf2._a(nBTTagCompound._i("Base"));
        if (nBTTagCompound._c("Modifiers")) {
            NBTTagList nBTTagList = nBTTagCompound._n("Modifiers");
            for (int i = 0; i < nBTTagList._d(); ++i) {
                AttributeModifier attributeModifier = sajz._a((NBTTagCompound)nBTTagList._b(i));
                AttributeModifier attributeModifier2 = hubf2._a(attributeModifier._a());
                if (attributeModifier2 != null) {
                    hubf2._b(attributeModifier2);
                }
                hubf2._a(attributeModifier);
            }
        }
    }

    public static AttributeModifier _a(NBTTagCompound nBTTagCompound) {
        UUID uUID = new UUID(nBTTagCompound._g("UUIDMost"), nBTTagCompound._g("UUIDLeast"));
        return new AttributeModifier(uUID, nBTTagCompound._j("Name"), nBTTagCompound._i("Amount"), nBTTagCompound._f("Operation"));
    }
}

