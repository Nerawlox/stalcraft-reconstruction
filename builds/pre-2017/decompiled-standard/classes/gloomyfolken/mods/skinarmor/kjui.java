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
import net.minecraft.src.ModLoader;
import net.minecraft.util.jxtc;
import net.minecraftforge.common.ISpecialArmor;

public class kjui
extends lpno
implements ISpecialArmor {
    public static yery _a = yery._e;

    public kjui(int n, int n2) {
        super(n - 256, _a, kjui._a(_a.name().toLowerCase() + kjui._a(n2)), n2);
        this.func_77637_a(GloomyCore.tab);
        this.func_77655_b("armor" + this.field_77779_bT);
        this.func_111206_d("skinarmor:skin");
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
    public boolean func_77623_v() {
        return false;
    }

    @Override
    public boolean func_82816_b_(cvzo cvzo2) {
        return false;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public String getArmorTexture(cvzo cvzo2, Entity entity, int n, int n2) {
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
    public void func_77624_a(cvzo cvzo2, EntityPlayer entityPlayer, List list2, boolean bl) {
        qoac qoac2 = ncwh._c(cvzo2);
        String string = qoac2._j("desc");
        if (string.isEmpty()) {
            list2.add("\u041d\u0435\u0442 \u043e\u043f\u0438\u0441\u0430\u043d\u0438\u044f");
        } else {
            list2.add(qoac2._j("desc"));
        }
        if (entityPlayer.field_71075_bZ._d) {
            String string2 = qoac2._j("skin");
            if (string2.isEmpty()) {
                list2.add("\u0421\u043a\u0438\u043d \u043d\u0435 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d");
            } else {
                list2.add("\u0420\u0430\u0441\u043f\u043e\u043b\u043e\u0436\u0435\u043d\u0438\u0435 \u0441\u043a\u0438\u043d\u0430: " + qoac2._j("skin"));
            }
        }
    }

    @Override
    public ISpecialArmor.ArmorProperties getProperties(EntityLivingBase entityLivingBase, cvzo cvzo2, jxtc jxtc2, double d, int n) {
        return new ISpecialArmor.ArmorProperties(0, 0.0, 0);
    }

    @Override
    public int getArmorDisplay(EntityPlayer entityPlayer, cvzo cvzo2, int n) {
        return 0;
    }

    @Override
    public void damageArmor(EntityLivingBase entityLivingBase, cvzo cvzo2, jxtc jxtc2, int n, int n2) {
    }
}

