/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.ServersideAttributeMap;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.ezey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet44UpdateAttributes;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.sajh;

public class EntityTrackerEntry {
    public Entity _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;
    public int _f;
    public int _g;
    public int _h;
    public int _i;
    public double _j;
    public double _k;
    public double _l;
    public int _m;
    public double _n;
    public double _o;
    public double _p;
    public boolean _q;
    public boolean _r;
    public int _s;
    public Entity _t;
    public boolean _u;
    public boolean _v;
    public Set _w = new HashSet();

    public EntityTrackerEntry(Entity entity, int n, int n2, boolean bl) {
        this._a = entity;
        this._b = n;
        this._c = n2;
        this._r = bl;
        this._d = sajh._c(entity.posX * 32.0);
        this._e = sajh._c(entity.posY * 32.0);
        this._f = sajh._c(entity.posZ * 32.0);
        this._g = sajh._d(entity.rotationYaw * 256.0f / 360.0f);
        this._h = sajh._d(entity.rotationPitch * 256.0f / 360.0f);
        this._i = sajh._d(entity.getRotationYawHead() * 256.0f / 360.0f);
    }

    public boolean equals(Object object) {
        return object instanceof EntityTrackerEntry ? ((EntityTrackerEntry)object)._a.entityId == this._a.entityId : false;
    }

    public int hashCode() {
        return this._a.entityId;
    }

    public void _a(List list2) {
        this._v = false;
        if (!this._q || this._a.getDistanceSq(this._n, this._o, this._p) > 16.0) {
            this._n = this._a.posX;
            this._o = this._a.posY;
            this._p = this._a.posZ;
            this._q = true;
            this._v = true;
            this._b(list2);
        }
        if (this._t != this._a.ridingEntity || this._a.ridingEntity != null && this._m % 60 == 0) {
            this._t = this._a.ridingEntity;
            this._a(new nwaj(0, this._a, this._a.ridingEntity));
        }
        if (this._a instanceof EntityItemFrame && this._m % 10 == 0) {
            EntityItemFrame entityItemFrame = (EntityItemFrame)this._a;
            ItemStack itemStack = entityItemFrame.getDisplayedItem();
            if (itemStack != null && itemStack._a() instanceof ItemMap) {
                thdd thdd2 = Item.map._a(itemStack, this._a.worldObj);
                for (EntityPlayer entityPlayer : list2) {
                    Packet packet;
                    EntityPlayerMP entityPlayerMP = (EntityPlayerMP)entityPlayer;
                    thdd2._a(entityPlayerMP, itemStack);
                    if (entityPlayerMP.playerNetServerHandler.func_72568_e() > 5 || (packet = Item.map._a(itemStack, this._a.worldObj, entityPlayerMP)) == null) continue;
                    entityPlayerMP.playerNetServerHandler.func_72567_b(packet);
                }
            }
            this._a();
        } else if (this._m % this._c == 0 || this._a.isAirBorne || this._a.getDataWatcher()._a()) {
            int n;
            if (this._a.ridingEntity == null) {
                double d;
                double d2;
                double d3;
                double d4;
                double d5;
                boolean bl;
                ++this._s;
                n = this._a.myEntitySize._a(this._a.posX);
                int n2 = sajh._c(this._a.posY * 32.0);
                int n3 = this._a.myEntitySize._a(this._a.posZ);
                int n4 = sajh._d(this._a.rotationYaw * 256.0f / 360.0f);
                int n5 = sajh._d(this._a.rotationPitch * 256.0f / 360.0f);
                int n6 = n - this._d;
                int n7 = n2 - this._e;
                int n8 = n3 - this._f;
                Packet packet = null;
                boolean bl2 = Math.abs(n6) >= 4 || Math.abs(n7) >= 4 || Math.abs(n8) >= 4 || this._m % 60 == 0;
                boolean bl3 = bl = Math.abs(n4 - this._g) >= 4 || Math.abs(n5 - this._h) >= 4;
                if (this._m > 0 || this._a instanceof EntityArrow) {
                    if (n6 >= -128 && n6 < 128 && n7 >= -128 && n7 < 128 && n8 >= -128 && n8 < 128 && this._s <= 400 && !this._u) {
                        if (bl2 && bl) {
                            packet = new xsyc(this._a.entityId, (byte)n6, (byte)n7, (byte)n8, (byte)n4, (byte)n5);
                        } else if (bl2) {
                            packet = new sukx(this._a.entityId, (byte)n6, (byte)n7, (byte)n8);
                        } else if (bl) {
                            packet = new ixoh(this._a.entityId, (byte)n4, (byte)n5);
                        }
                    } else {
                        this._s = 0;
                        packet = new txnr(this._a.entityId, n, n2, n3, (byte)n4, (byte)n5);
                    }
                }
                if (this._r && ((d5 = (d4 = this._a.motionX - this._j) * d4 + (d3 = this._a.motionY - this._k) * d3 + (d2 = this._a.motionZ - this._l) * d2) > (d = 0.02) * d || d5 > 0.0 && this._a.motionX == 0.0 && this._a.motionY == 0.0 && this._a.motionZ == 0.0)) {
                    this._j = this._a.motionX;
                    this._k = this._a.motionY;
                    this._l = this._a.motionZ;
                    this._a(new fofa(this._a.entityId, this._j, this._k, this._l));
                }
                if (packet != null) {
                    this._a(packet);
                }
                this._a();
                if (bl2) {
                    this._d = n;
                    this._e = n2;
                    this._f = n3;
                }
                if (bl) {
                    this._g = n4;
                    this._h = n5;
                }
                this._u = false;
            } else {
                boolean bl;
                n = sajh._d(this._a.rotationYaw * 256.0f / 360.0f);
                int n9 = sajh._d(this._a.rotationPitch * 256.0f / 360.0f);
                boolean bl4 = bl = Math.abs(n - this._g) >= 4 || Math.abs(n9 - this._h) >= 4;
                if (bl) {
                    this._a(new ixoh(this._a.entityId, (byte)n, (byte)n9));
                    this._g = n;
                    this._h = n9;
                }
                this._d = this._a.myEntitySize._a(this._a.posX);
                this._e = sajh._c(this._a.posY * 32.0);
                this._f = this._a.myEntitySize._a(this._a.posZ);
                this._a();
                this._u = true;
            }
            n = sajh._d(this._a.getRotationYawHead() * 256.0f / 360.0f);
            if (Math.abs(n - this._i) >= 4) {
                this._a(new ragc(this._a.entityId, (byte)n));
                this._i = n;
            }
            this._a.isAirBorne = false;
        }
        ++this._m;
        if (this._a.velocityChanged) {
            this._b(new fofa(this._a));
            this._a.velocityChanged = false;
        }
    }

    public void _a() {
        DataWatcher dataWatcher = this._a.getDataWatcher();
        if (dataWatcher._a()) {
            this._b(new qoia(this._a.entityId, dataWatcher, false));
        }
        if (this._a instanceof EntityLivingBase) {
            ServersideAttributeMap serversideAttributeMap = (ServersideAttributeMap)((EntityLivingBase)this._a).getAttributeMap();
            Set set = serversideAttributeMap._b();
            if (!set.isEmpty()) {
                this._b(new Packet44UpdateAttributes(this._a.entityId, set));
            }
            set.clear();
        }
    }

    public void _a(Packet packet) {
        for (EntityPlayerMP entityPlayerMP : this._w) {
            entityPlayerMP.playerNetServerHandler.func_72567_b(packet);
        }
    }

    public void _b(Packet packet) {
        this._a(packet);
        if (this._a instanceof EntityPlayerMP) {
            ((EntityPlayerMP)this._a).playerNetServerHandler.func_72567_b(packet);
        }
    }

    public void _b() {
        for (EntityPlayerMP entityPlayerMP : this._w) {
            entityPlayerMP.destroyedItemsNetCache.add(this._a.entityId);
        }
    }

    public void _a(EntityPlayerMP entityPlayerMP) {
        if (this._w.contains(entityPlayerMP)) {
            entityPlayerMP.destroyedItemsNetCache.add(this._a.entityId);
            this._w.remove(entityPlayerMP);
        }
    }

    public void _b(EntityPlayerMP entityPlayerMP) {
        if (entityPlayerMP != this._a) {
            double d = entityPlayerMP.posX - (double)(this._d / 32);
            double d2 = entityPlayerMP.posZ - (double)(this._f / 32);
            if (d >= (double)(-this._b) && d <= (double)this._b && d2 >= (double)(-this._b) && d2 <= (double)this._b) {
                if (!this._w.contains(entityPlayerMP) && (this._c(entityPlayerMP) || this._a.forceSpawn)) {
                    EntityPlayer entityPlayer;
                    ServersideAttributeMap serversideAttributeMap;
                    Collection collection;
                    this._w.add(entityPlayerMP);
                    Packet packet = this._c();
                    entityPlayerMP.playerNetServerHandler.func_72567_b(packet);
                    if (!this._a.getDataWatcher()._d()) {
                        entityPlayerMP.playerNetServerHandler.func_72567_b(new qoia(this._a.entityId, this._a.getDataWatcher(), true));
                    }
                    if (this._a instanceof EntityLivingBase && !(collection = (serversideAttributeMap = (ServersideAttributeMap)((EntityLivingBase)this._a).getAttributeMap())._c()).isEmpty()) {
                        entityPlayerMP.playerNetServerHandler.func_72567_b(new Packet44UpdateAttributes(this._a.entityId, collection));
                    }
                    this._j = this._a.motionX;
                    this._k = this._a.motionY;
                    this._l = this._a.motionZ;
                    int n = sajh._c(this._a.posX * 32.0);
                    int n2 = sajh._c(this._a.posY * 32.0);
                    int n3 = sajh._c(this._a.posZ * 32.0);
                    if (n != this._d || n2 != this._e || n3 != this._f) {
                        FMLNetworkHandler.makeEntitySpawnAdjustment(this._a.entityId, entityPlayerMP, this._d, this._e, this._f);
                    }
                    if (this._r && !(packet instanceof tgmo)) {
                        entityPlayerMP.playerNetServerHandler.func_72567_b(new fofa(this._a.entityId, this._a.motionX, this._a.motionY, this._a.motionZ));
                    }
                    if (this._a.ridingEntity != null) {
                        entityPlayerMP.playerNetServerHandler.func_72567_b(new nwaj(0, this._a, this._a.ridingEntity));
                    }
                    if (this._a instanceof EntityLiving && ((EntityLiving)this._a).getLeashedToEntity() != null) {
                        entityPlayerMP.playerNetServerHandler.func_72567_b(new nwaj(1, this._a, ((EntityLiving)this._a).getLeashedToEntity()));
                    }
                    if (this._a instanceof EntityLivingBase) {
                        for (int i = 0; i < 5; ++i) {
                            ItemStack itemStack = ((EntityLivingBase)this._a).func_71124_b(i);
                            if (itemStack == null) continue;
                            entityPlayerMP.playerNetServerHandler.func_72567_b(new hdms(this._a.entityId, i, itemStack));
                        }
                    }
                    if (this._a instanceof EntityPlayer && (entityPlayer = (EntityPlayer)this._a).isPlayerSleeping()) {
                        entityPlayerMP.playerNetServerHandler.func_72567_b(new kmuh(this._a, 0, sajh._c(this._a.posX), sajh._c(this._a.posY), sajh._c(this._a.posZ)));
                    }
                    if (this._a instanceof EntityLivingBase) {
                        EntityLivingBase entityLivingBase = (EntityLivingBase)this._a;
                        for (PotionEffect potionEffect : entityLivingBase.getActivePotionEffects()) {
                            entityPlayerMP.playerNetServerHandler.func_72567_b(new cwaw(this._a.entityId, potionEffect));
                        }
                    }
                }
            } else if (this._w.contains(entityPlayerMP)) {
                this._w.remove(entityPlayerMP);
                entityPlayerMP.destroyedItemsNetCache.add(this._a.entityId);
            }
        }
    }

    public boolean _c(EntityPlayerMP entityPlayerMP) {
        return entityPlayerMP.getServerForPlayer().getPlayerManager()._a(entityPlayerMP, this._a.chunkCoordX, this._a.chunkCoordZ);
    }

    public void _b(List list2) {
        for (int i = 0; i < list2.size(); ++i) {
            this._b((EntityPlayerMP)list2.get(i));
        }
    }

    public Packet _c() {
        Packet packet;
        if (this._a.isDead) {
            this._a.worldObj.getWorldLogAgent()._b("Fetching addPacket for removed entity");
        }
        if ((packet = FMLNetworkHandler.getEntitySpawningPacket(this._a)) != null) {
            return packet;
        }
        if (this._a instanceof EntityItem) {
            return new ixor(this._a, 2, 1);
        }
        if (this._a instanceof EntityPlayerMP) {
            return new xsze((EntityPlayer)this._a);
        }
        if (this._a instanceof EntityMinecart) {
            EntityMinecart entityMinecart = (EntityMinecart)this._a;
            return new ixor(this._a, 10, entityMinecart.getMinecartType());
        }
        if (this._a instanceof EntityBoat) {
            return new ixor(this._a, 1);
        }
        if (!(this._a instanceof ezey) && !(this._a instanceof EntityDragon)) {
            if (this._a instanceof EntityFishHook) {
                EntityPlayer entityPlayer = ((EntityFishHook)this._a).angler;
                return new ixor(this._a, 90, entityPlayer != null ? entityPlayer.entityId : this._a.entityId);
            }
            if (this._a instanceof EntityArrow) {
                Entity entity = ((EntityArrow)this._a).shootingEntity;
                return new ixor(this._a, 60, entity != null ? entity.entityId : this._a.entityId);
            }
            if (this._a instanceof EntitySnowball) {
                return new ixor(this._a, 61);
            }
            if (this._a instanceof EntityPotion) {
                return new ixor(this._a, 73, ((EntityPotion)this._a).getPotionDamage());
            }
            if (this._a instanceof EntityExpBottle) {
                return new ixor(this._a, 75);
            }
            if (this._a instanceof EntityEnderPearl) {
                return new ixor(this._a, 65);
            }
            if (this._a instanceof EntityEnderEye) {
                return new ixor(this._a, 72);
            }
            if (this._a instanceof EntityFireworkRocket) {
                return new ixor(this._a, 76);
            }
            if (this._a instanceof EntityFireball) {
                EntityFireball entityFireball = (EntityFireball)this._a;
                ixor ixor2 = null;
                int n = 63;
                if (this._a instanceof EntitySmallFireball) {
                    n = 64;
                } else if (this._a instanceof EntityWitherSkull) {
                    n = 66;
                }
                ixor2 = entityFireball.shootingEntity != null ? new ixor(this._a, n, ((EntityFireball)this._a).shootingEntity.entityId) : new ixor(this._a, n, 0);
                ixor2._e = (int)(entityFireball.accelerationX * 8000.0);
                ixor2._f = (int)(entityFireball.accelerationY * 8000.0);
                ixor2._g = (int)(entityFireball.accelerationZ * 8000.0);
                return ixor2;
            }
            if (this._a instanceof EntityEgg) {
                return new ixor(this._a, 62);
            }
            if (this._a instanceof EntityTNTPrimed) {
                return new ixor(this._a, 50);
            }
            if (this._a instanceof EntityEnderCrystal) {
                return new ixor(this._a, 51);
            }
            if (this._a instanceof EntityFallingSand) {
                EntityFallingSand entityFallingSand = (EntityFallingSand)this._a;
                return new ixor(this._a, 70, entityFallingSand.blockID | entityFallingSand.metadata << 16);
            }
            if (this._a instanceof EntityPainting) {
                return new ixoa((EntityPainting)this._a);
            }
            if (this._a instanceof EntityItemFrame) {
                EntityItemFrame entityItemFrame = (EntityItemFrame)this._a;
                ixor ixor3 = new ixor(this._a, 71, entityItemFrame.hangingDirection);
                ixor3._b = sajh._d(entityItemFrame.xPosition * 32);
                ixor3._c = sajh._d(entityItemFrame.yPosition * 32);
                ixor3._d = sajh._d(entityItemFrame.zPosition * 32);
                return ixor3;
            }
            if (this._a instanceof EntityLeashKnot) {
                EntityLeashKnot entityLeashKnot = (EntityLeashKnot)this._a;
                ixor ixor4 = new ixor(this._a, 77);
                ixor4._b = sajh._d(entityLeashKnot.xPosition * 32);
                ixor4._c = sajh._d(entityLeashKnot.yPosition * 32);
                ixor4._d = sajh._d(entityLeashKnot.zPosition * 32);
                return ixor4;
            }
            if (this._a instanceof EntityXPOrb) {
                return new kmst((EntityXPOrb)this._a);
            }
            throw new IllegalArgumentException("Don't know how to add " + this._a.getClass() + "!");
        }
        this._i = sajh._d(this._a.getRotationYawHead() * 256.0f / 360.0f);
        return new tgmo((EntityLivingBase)this._a);
    }

    public void _d(EntityPlayerMP entityPlayerMP) {
        if (this._w.contains(entityPlayerMP)) {
            this._w.remove(entityPlayerMP);
            entityPlayerMP.destroyedItemsNetCache.add(this._a.entityId);
        }
    }
}

