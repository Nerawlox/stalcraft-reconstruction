/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lp
 *  or
 *  os
 *  ot
 *  ov
 *  oy
 */
import java.util.Collection;
import java.util.UUID;

public class tp {
    public static final or a = new oy("generic.maxHealth", 20.0, 0.0, Double.MAX_VALUE).a("Max Health").a(true);
    public static final or b = new oy("generic.followRange", 32.0, 0.0, 2048.0).a("Follow Range");
    public static final or c = new oy("generic.knockbackResistance", 0.0, 0.0, 1.0).a("Knockback Resistance");
    public static final or d = new oy("generic.movementSpeed", (double)0.7f, 0.0, Double.MAX_VALUE).a("Movement Speed").a(true);
    public static final or e = new oy("generic.attackDamage", 2.0, 0.0, Double.MAX_VALUE);

    public static cg a(ov par0BaseAttributeMap) {
        cg nbttaglist = new cg();
        for (os attributeinstance : par0BaseAttributeMap.a()) {
            nbttaglist.a(tp.a(attributeinstance));
        }
        return nbttaglist;
    }

    private static by a(os par0AttributeInstance) {
        by nbttagcompound = new by();
        or attribute = par0AttributeInstance.a();
        nbttagcompound.a("Name", attribute.a());
        nbttagcompound.a("Base", par0AttributeInstance.b());
        Collection collection = par0AttributeInstance.c();
        if (collection != null && !collection.isEmpty()) {
            cg nbttaglist = new cg();
            for (ot attributemodifier : collection) {
                if (!attributemodifier.e()) continue;
                nbttaglist.a(tp.a(attributemodifier));
            }
            nbttagcompound.a("Modifiers", nbttaglist);
        }
        return nbttagcompound;
    }

    private static by a(ot par0AttributeModifier) {
        by nbttagcompound = new by();
        nbttagcompound.a("Name", par0AttributeModifier.b());
        nbttagcompound.a("Amount", par0AttributeModifier.d());
        nbttagcompound.a("Operation", par0AttributeModifier.c());
        nbttagcompound.a("UUIDMost", par0AttributeModifier.a().getMostSignificantBits());
        nbttagcompound.a("UUIDLeast", par0AttributeModifier.a().getLeastSignificantBits());
        return nbttagcompound;
    }

    public static void a(ov par0BaseAttributeMap, cg par1NBTTagList, lp par2ILogAgent) {
        for (int i2 = 0; i2 < par1NBTTagList.c(); ++i2) {
            by nbttagcompound = (by)par1NBTTagList.b(i2);
            os attributeinstance = par0BaseAttributeMap.a(nbttagcompound.i("Name"));
            if (attributeinstance != null) {
                tp.a(attributeinstance, nbttagcompound);
                continue;
            }
            if (par2ILogAgent == null) continue;
            par2ILogAgent.b("Ignoring unknown attribute '" + nbttagcompound.i("Name") + "'");
        }
    }

    private static void a(os par0AttributeInstance, by par1NBTTagCompound) {
        par0AttributeInstance.a(par1NBTTagCompound.h("Base"));
        if (par1NBTTagCompound.b("Modifiers")) {
            cg nbttaglist = par1NBTTagCompound.m("Modifiers");
            for (int i2 = 0; i2 < nbttaglist.c(); ++i2) {
                ot attributemodifier = tp.a((by)nbttaglist.b(i2));
                ot attributemodifier1 = par0AttributeInstance.a(attributemodifier.a());
                if (attributemodifier1 != null) {
                    par0AttributeInstance.b(attributemodifier1);
                }
                par0AttributeInstance.a(attributemodifier);
            }
        }
    }

    public static ot a(by par0NBTTagCompound) {
        UUID uuid = new UUID(par0NBTTagCompound.f("UUIDMost"), par0NBTTagCompound.f("UUIDLeast"));
        return new ot(uuid, par0NBTTagCompound.i("Name"), par0NBTTagCompound.h("Amount"), par0NBTTagCompound.e("Operation"));
    }
}

