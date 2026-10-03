/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import cpw.mods.fml.common.registry.EntityRegistry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.CallableEntityTracker;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.EntityTrackerEntry;
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
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.IntHashMap;
import net.minecraft.util.turb;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;

public class EntityTracker {
    public final WorldServer _a;
    public Set _b = new HashSet();
    public IntHashMap _c = new IntHashMap();
    public int _d;

    public EntityTracker(WorldServer worldServer) {
        this._a = worldServer;
        this._d = worldServer.getMinecraftServer().__ag()._h();
    }

    public void _a(Entity entity) {
        if (EntityRegistry.instance().tryTrackingEntity(this, entity)) {
            return;
        }
        if (entity instanceof EntityPlayerMP) {
            this._a(entity, 512, 2);
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)entity;
            for (EntityTrackerEntry entityTrackerEntry : this._b) {
                if (entityTrackerEntry._a == entityPlayerMP) continue;
                entityTrackerEntry._b(entityPlayerMP);
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
            if (this._c._c(entity.entityId)) {
                throw new IllegalStateException("Entity is already tracked!");
            }
            EntityTrackerEntry entityTrackerEntry = new EntityTrackerEntry(entity, n, n2, bl);
            this._b.add(entityTrackerEntry);
            this._c._a(entity.entityId, entityTrackerEntry);
            entityTrackerEntry._b(this._a.playerEntities);
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Adding entity to track");
            CrashReportCategory crashReportCategory = crashReport.makeCategory("Entity To Track");
            crashReportCategory._a("Tracking range", n + " blocks");
            crashReportCategory._a("Update interval", new CallableEntityTracker(this, n2));
            entity.addEntityCrashInfo(crashReportCategory);
            CrashReportCategory crashReportCategory2 = crashReport.makeCategory("Entity That Is Already Tracked");
            ((EntityTrackerEntry)this._c._b((int)entity.entityId))._a.addEntityCrashInfo(crashReportCategory2);
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
            for (EntityTrackerEntry entityTrackerEntry : this._b) {
                entityTrackerEntry._a((EntityPlayerMP)object);
            }
        }
        if ((object = (EntityTrackerEntry)this._c._f(entity.entityId)) != null) {
            this._b.remove(object);
            ((EntityTrackerEntry)object)._b();
        }
    }

    public void _a() {
        ArrayList<EntityPlayerMP> arrayList = new ArrayList<EntityPlayerMP>();
        for (EntityTrackerEntry entityTrackerEntry : this._b) {
            entityTrackerEntry._a(this._a.playerEntities);
            if (!entityTrackerEntry._v || !(entityTrackerEntry._a instanceof EntityPlayerMP)) continue;
            arrayList.add((EntityPlayerMP)entityTrackerEntry._a);
        }
        for (int i = 0; i < arrayList.size(); ++i) {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)arrayList.get(i);
            for (EntityTrackerEntry entityTrackerEntry : this._b) {
                if (entityTrackerEntry._a == entityPlayerMP) continue;
                entityTrackerEntry._b(entityPlayerMP);
            }
        }
    }

    public void _a(Entity entity, Packet packet) {
        EntityTrackerEntry entityTrackerEntry = (EntityTrackerEntry)this._c._b(entity.entityId);
        if (entityTrackerEntry != null) {
            entityTrackerEntry._a(packet);
        }
    }

    public void _b(Entity entity, Packet packet) {
        EntityTrackerEntry entityTrackerEntry = (EntityTrackerEntry)this._c._b(entity.entityId);
        if (entityTrackerEntry != null) {
            entityTrackerEntry._b(packet);
        }
    }

    public void _a(EntityPlayerMP entityPlayerMP) {
        for (EntityTrackerEntry entityTrackerEntry : this._b) {
            entityTrackerEntry._d(entityPlayerMP);
        }
    }

    public void _a(EntityPlayerMP entityPlayerMP, Chunk chunk) {
        for (EntityTrackerEntry entityTrackerEntry : this._b) {
            if (entityTrackerEntry._a == entityPlayerMP || entityTrackerEntry._a.chunkCoordX != chunk._i || entityTrackerEntry._a.chunkCoordZ != chunk._j) continue;
            entityTrackerEntry._b(entityPlayerMP);
        }
    }
}

