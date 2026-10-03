/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import cpw.mods.fml.common.registry.EntityRegistry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.jxsn;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.ezey;
import net.minecraft.entity.pidb;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.xpzm;
import net.minecraft.util.amxi;
import net.minecraft.util.turb;

public class ugqx {
    public final yfgy _a;
    public Set _b = new HashSet();
    public amxi _c = new amxi();
    public int _d;

    public ugqx(yfgy yfgy2) {
        this._a = yfgy2;
        this._d = yfgy2.func_73046_m().__ag()._h();
    }

    public void _a(Entity entity) {
        if (EntityRegistry.instance().tryTrackingEntity(this, entity)) {
            return;
        }
        if (entity instanceof EntityPlayerMP) {
            this._a(entity, 512, 2);
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)entity;
            for (xpzm xpzm2 : this._b) {
                if (xpzm2._a == entityPlayerMP) continue;
                xpzm2._b(entityPlayerMP);
            }
        } else if (entity instanceof EntityFishHook) {
            this._a(entity, 64, 5, true);
        } else if (entity instanceof EntityArrow) {
            this._a(entity, 64, 20, false);
        } else if (entity instanceof EntitySmallFireball) {
            this._a(entity, 64, 10, false);
        } else if (entity instanceof EntityFireball) {
            this._a(entity, 64, 10, false);
        } else if (entity instanceof EntitySnowball) {
            this._a(entity, 64, 10, true);
        } else if (entity instanceof EntityEnderPearl) {
            this._a(entity, 64, 10, true);
        } else if (entity instanceof EntityEnderEye) {
            this._a(entity, 64, 4, true);
        } else if (entity instanceof EntityEgg) {
            this._a(entity, 64, 10, true);
        } else if (entity instanceof EntityPotion) {
            this._a(entity, 64, 10, true);
        } else if (entity instanceof EntityExpBottle) {
            this._a(entity, 64, 10, true);
        } else if (entity instanceof EntityFireworkRocket) {
            this._a(entity, 64, 10, true);
        } else if (entity instanceof EntityItem) {
            this._a(entity, 64, 20, true);
        } else if (entity instanceof EntityMinecart) {
            this._a(entity, 80, 3, true);
        } else if (entity instanceof EntityBoat) {
            this._a(entity, 80, 3, true);
        } else if (entity instanceof EntitySquid) {
            this._a(entity, 64, 3, true);
        } else if (entity instanceof EntityWither) {
            this._a(entity, 80, 3, false);
        } else if (entity instanceof EntityBat) {
            this._a(entity, 80, 3, false);
        } else if (entity instanceof ezey) {
            this._a(entity, 80, 3, true);
        } else if (entity instanceof EntityDragon) {
            this._a(entity, 160, 3, true);
        } else if (entity instanceof EntityTNTPrimed) {
            this._a(entity, 160, 10, true);
        } else if (entity instanceof EntityFallingSand) {
            this._a(entity, 160, 20, true);
        } else if (entity instanceof EntityHanging) {
            this._a(entity, 160, Integer.MAX_VALUE, false);
        } else if (entity instanceof EntityXPOrb) {
            this._a(entity, 160, 20, true);
        } else if (entity instanceof EntityEnderCrystal) {
            this._a(entity, 256, Integer.MAX_VALUE, false);
        }
    }

    public void _a(Entity entity, int n, int n2) {
        this._a(entity, n, n2, false);
    }

    public void _a(Entity entity, int n, int n2, boolean bl) {
        if (n > this._d) {
            n = this._d;
        }
        try {
            if (this._c._c(entity.field_70157_k)) {
                throw new IllegalStateException("Entity is already tracked!");
            }
            xpzm xpzm2 = new xpzm(entity, n, n2, bl);
            this._b.add(xpzm2);
            this._c._a(entity.field_70157_k, xpzm2);
            xpzm2._b(this._a.field_73010_i);
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.func_85055_a(throwable, "Adding entity to track");
            jxsn jxsn2 = crashReport.func_85058_a("Entity To Track");
            jxsn2._a("Tracking range", n + " blocks");
            jxsn2._a("Update interval", new pidb(this, n2));
            entity.func_85029_a(jxsn2);
            jxsn jxsn3 = crashReport.func_85058_a("Entity That Is Already Tracked");
            ((xpzm)this._c._b((int)entity.field_70157_k))._a.func_85029_a(jxsn3);
            try {
                throw new turb(crashReport);
            }
            catch (turb turb2) {
                System.err.println("\"Silently\" catching entity tracking error.");
                turb2.printStackTrace();
            }
        }
    }

    public void _b(Entity entity) {
        Object object;
        if (entity instanceof EntityPlayerMP) {
            object = (EntityPlayerMP)entity;
            for (xpzm xpzm2 : this._b) {
                xpzm2._a((EntityPlayerMP)object);
            }
        }
        if ((object = (xpzm)this._c._f(entity.field_70157_k)) != null) {
            this._b.remove(object);
            ((xpzm)object)._b();
        }
    }

    public void _a() {
        ArrayList<EntityPlayerMP> arrayList = new ArrayList<EntityPlayerMP>();
        for (xpzm xpzm2 : this._b) {
            xpzm2._a(this._a.field_73010_i);
            if (!xpzm2._v || !(xpzm2._a instanceof EntityPlayerMP)) continue;
            arrayList.add((EntityPlayerMP)xpzm2._a);
        }
        for (int i = 0; i < arrayList.size(); ++i) {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)arrayList.get(i);
            for (xpzm xpzm3 : this._b) {
                if (xpzm3._a == entityPlayerMP) continue;
                xpzm3._b(entityPlayerMP);
            }
        }
    }

    public void _a(Entity entity, cezg cezg2) {
        xpzm xpzm2 = (xpzm)this._c._b(entity.field_70157_k);
        if (xpzm2 != null) {
            xpzm2._a(cezg2);
        }
    }

    public void _b(Entity entity, cezg cezg2) {
        xpzm xpzm2 = (xpzm)this._c._b(entity.field_70157_k);
        if (xpzm2 != null) {
            xpzm2._b(cezg2);
        }
    }

    public void _a(EntityPlayerMP entityPlayerMP) {
        for (xpzm xpzm2 : this._b) {
            xpzm2._d(entityPlayerMP);
        }
    }

    public void _a(EntityPlayerMP entityPlayerMP, ixzi ixzi2) {
        for (xpzm xpzm2 : this._b) {
            if (xpzm2._a == entityPlayerMP || xpzm2._a.field_70176_ah != ixzi2._i || xpzm2._a.field_70164_aj != ixzi2._j) continue;
            xpzm2._b(entityPlayerMP);
        }
    }
}

