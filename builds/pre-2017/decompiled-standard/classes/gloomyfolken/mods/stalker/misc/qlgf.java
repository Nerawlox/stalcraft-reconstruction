/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.misc;

import cpw.mods.fml.common.registry.GameRegistry;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.stalker.misc.tupg;
import gloomyfolken.mods.weapon.kjui;
import gloomyfolken.mods.weapon.trace.EntityTracer;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.amww;
import net.minecraft.util.ezfc;
import net.minecraft.util.hank;
import net.minecraft.util.jxtc;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import org.lwjgl.opengl.GL11;

public class qlgf {
    public static boolean _a = false;

    @Hook(returnCondition=ReturnCondition.ALWAYS, booleanReturnConstant=false)
    public static void _a(gqbt gqbt2, ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void _a(EntityLivingBase entityLivingBase, float f) {
        float f2 = entityLivingBase.func_110143_aJ();
        if (entityLivingBase instanceof EntityPlayer) {
            f /= xafi._a(tupg._a((EntityPlayer)((EntityPlayer)entityLivingBase))._d._z);
        }
        if (f2 > 0.0f) {
            entityLivingBase.func_70606_j(f2 + f);
        }
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static cvzo _a(igjl igjl2, bsse bsse2, ozlu ozlu2) {
        for (int i = 0; i < igjl2._b().size(); ++i) {
            lpso lpso2 = (lpso)igjl2._b().get(i);
            if (!lpso2.func_77569_a(bsse2, ozlu2)) continue;
            return lpso2.func_77572_b(bsse2);
        }
        return null;
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS, booleanReturnConstant=false)
    public static void _a(scce scce2, ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
    }

    @Hook(injectOnExit=true)
    @ezey(_a={eidj.CLIENT})
    public static void _a(GameSettings gameSettings) {
        if (!gameSettings.field_74346_m.startsWith("Stalcraft")) {
            gameSettings.field_74346_m = "Stalcraft.zip";
        }
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    @ezey(_a={eidj.CLIENT})
    public static void _a(tfsl tfsl2, float f) {
        xpzm xpzm2 = xpzm._E();
        xpzm2._v = null;
        if (xpzm2._u != null && xpzm2._r != null) {
            double d = xpzm2._j._d();
            double d2 = xpzm2._j._j() ? 6.0 : 3.0;
            EntityLivingBase entityLivingBase = xpzm2._u;
            ofbx ofbx2 = entityLivingBase.func_70666_h(f);
            ofbx ofbx3 = entityLivingBase.func_70676_i(f);
            ofbx ofbx4 = ofbx2._c(ofbx3._c * d, ofbx3._d * d, ofbx3._e * d);
            ofbx ofbx5 = ofbx2._c(ofbx3._c * d2, ofbx3._d * d2, ofbx3._e * d2);
            _a = true;
            hank hank2 = entityLivingBase.field_70170_p.func_72831_a(entityLivingBase.func_70666_h(f), ofbx4, false, true);
            hank hank3 = entityLivingBase.field_70170_p.func_72933_a(entityLivingBase.func_70666_h(f), ofbx4);
            hank hank4 = EntityTracer._a(entityLivingBase.field_70170_p, entityLivingBase.func_70666_h(f), ofbx5, (Entity)entityLivingBase, hank2, true);
            _a = false;
            hank hank5 = xpzm2._L = hank4 == hank2 ? hank3 : hank4;
            if (hank4 != null && hank4._c == amww._b && hank4._i instanceof EntityLivingBase) {
                xpzm2._v = (EntityLivingBase)hank4._i;
            }
        }
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void _a(xsbj xsbj2, qncw qncw2, apbu apbu2, cvzo cvzo2, int n, int n2, boolean bl) {
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 771);
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(injectOnExit=true)
    public static void _a(xbdy xbdy2, EntityPlayer entityPlayer) {
        dgmz dgmz2;
        tewl tewl2;
        cvzo cvzo2 = entityPlayer.func_82169_q(2);
        if (cvzo2 == null || !(cvzo2._a() instanceof dgmz) || (tewl2 = tewl._a(dgmz2 = (dgmz)cvzo2._a())) != null) {
            // empty if block
        }
    }

    @Hook(injectOnExit=true, targetMethod="renderItemIntoGUI")
    @ezey(_a={eidj.CLIENT})
    public static void _b(xsbj xsbj2, qncw qncw2, apbu apbu2, cvzo cvzo2, int n, int n2, boolean bl) {
        GL11.glDisable(3042);
        GL11.glEnable(3008);
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean _a(vlzh vlzh2, EntityPlayer entityPlayer, Entity entity) {
        return entity instanceof EntityItem;
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE, booleanReturnConstant=false)
    public static boolean _a(EntityItem entityItem, jxtc jxtc2, float f) {
        return jxtc2 instanceof kjui;
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(injectOnExit=true)
    public static void _a(EntityItem entityItem) {
        cvzo cvzo2;
        if (!entityItem.field_70128_L && (cvzo2 = entityItem.func_92059_d()) != null && cvzo2._a() instanceof cdit) {
            String string = fmsn._f();
            IExtendedEntityProperties iExtendedEntityProperties = entityItem.getExtendedProperties(string);
            if (iExtendedEntityProperties == null) {
                iExtendedEntityProperties = new fmsn(entityItem);
                entityItem.registerExtendedProperties(string, iExtendedEntityProperties);
            } else {
                ((fmsn)iExtendedEntityProperties)._b();
            }
        }
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void _a(EntityItem entityItem, EntityPlayer entityPlayer) {
    }

    public static void _b(EntityItem entityItem, EntityPlayer entityPlayer) {
        if (entityItem.field_70170_p.field_72995_K) {
            return;
        }
        EntityItemPickupEvent entityItemPickupEvent = new EntityItemPickupEvent(entityPlayer, entityItem);
        if (MinecraftForge.EVENT_BUS.post(entityItemPickupEvent)) {
            return;
        }
        cvzo cvzo2 = entityItem.func_92059_d();
        int n = cvzo2._b;
        if (entityItemPickupEvent.getResult() == Event.Result.ALLOW || n <= 0 || entityPlayer.field_71071_by._c(cvzo2)) {
            cvzo cvzo3 = cvzo2._l();
            cvzo3._b = n - cvzo2._b;
            InvokeSideOnly.frontend(() -> {});
            GameRegistry.onPickupNotification(entityPlayer, entityItem);
            entityItem.func_85030_a("random.pop", 0.2f, ((entityItem.field_70170_p.field_73012_v.nextFloat() - entityItem.field_70170_p.field_73012_v.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            entityPlayer.func_71001_a(entityItem, n);
            if (cvzo2._b <= 0) {
                entityItem.func_70106_y();
            }
        }
    }

    public static void _a(float f, float f2, float f3, float f4) {
    }

    public static void _a(float f, float f2, float f3) {
    }

    public static void _a(Entity entity) {
        if (Math.random() > 0.95 && entity instanceof EntityPlayer) {
            entity.func_70097_a(gloomyfolken.mods.core.misc.ezey._q, GloomyCore.config._a);
        }
    }

    public static void _b(Entity entity) {
        entity.func_70110_aj();
    }

    public static boolean _a() {
        return true;
    }

    @ezey(_a={eidj.CLIENT})
    public static void _b(EntityItem entityItem) {
        GL11.glPushMatrix();
        if (!xsbj.field_82407_g && xpzm._E()._M.field_74347_j) {
            if (entityItem.func_92059_d() != null && entityItem.func_92059_d()._a() instanceof aofo) {
                float f = xpzm._E()._p._d;
                GL11.glTranslatef(0.0f, sajh._a(((float)entityItem.field_70292_b + f) / 10.0f + entityItem.field_70290_d) * 0.1f + 0.1f, 0.0f);
                GL11.glRotatef((((float)entityItem.field_70292_b + f) / 20.0f + entityItem.field_70290_d) * 57.295776f, 0.0f, 1.0f, 0.0f);
            } else {
                GL11.glTranslatef(0.0f, -0.12f, 0.0f);
                GL11.glRotatef(entityItem.field_70177_z, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
            }
        }
    }

    @ezey(_a={eidj.CLIENT})
    public static void _c(EntityItem entityItem) {
        GL11.glPopMatrix();
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE, returnAnotherMethod="canStoreTradepack")
    public static boolean _a(net.minecraft.entity.player.eidj eidj2, cvzo cvzo2) {
        if (cvzo2 != null && cvzo2._b > 0 && cvzo2._a() instanceof pjnz) {
            if (tupg._a(eidj2._e)._h()) {
                pjnz._a(eidj2._e, cvzo2._l());
                cvzo2._b = 0;
            } else {
                eidj2._e.func_71035_c((Object)((Object)ezfc._m) + "\u0422\u043e\u0440\u0433\u043e\u0432\u044b\u0439 \u0440\u044e\u043a\u0437\u0430\u043a \u043d\u0435\u0441\u043e\u0432\u043c\u0435\u0441\u0442\u0438\u043c \u0441 \u0432\u0430\u0448\u0435\u0439 \u0431\u0440\u043e\u043d\u0435\u0439.");
            }
            return true;
        }
        return false;
    }

    public static boolean _b(net.minecraft.entity.player.eidj eidj2, cvzo cvzo2) {
        return tupg._a(eidj2._e)._h();
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static float _a(jxtc jxtc2) {
        return 0.0f;
    }
}

