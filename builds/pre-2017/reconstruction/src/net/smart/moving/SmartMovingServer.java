/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  gloomyfolken.mods.anticheat.movement.AnticheatHandler
 */
package net.smart.moving;

import gloomyfolken.bundle.common.core.zwaw;
import gloomyfolken.mods.anticheat.movement.AnticheatHandler;
import java.io.File;
import java.util.List;
import java.util.logging.Logger;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.AxisAlignedBB;
import net.smart.moving.IEntityPlayerMP;
import net.smart.moving.config.SmartMovingConfig;
import net.smart.moving.config.SmartMovingServerOptions;
import net.smart.utilities.Assert;

@zwaw
public class SmartMovingServer {
    public static final float SmallSizeItemGrabHeight = 0.25f;
    public final IEntityPlayerMP mp;
    private boolean resetFallDistance = false;
    private boolean resetTicksForFloatKick = false;
    private boolean initialized = false;
    private boolean withinOnLivingUpdate = false;
    public boolean crawlingInitialized;
    public int crawlingCooldown;
    public boolean isCrawling;
    public boolean isSmall;
    private int disableAddExhaustionDepth;
    private boolean disableAddExhaustion;
    public static SmartMovingConfig Options = null;
    private static SmartMovingServerOptions optionsHandler = null;
    private final EntityPlayer player;
    public Packet250CustomPayload lastStatePacket;

    public SmartMovingServer(IEntityPlayerMP iEntityPlayerMP, EntityPlayer entityPlayer, boolean bl) {
        this.mp = iEntityPlayerMP;
        this.player = entityPlayer;
        if (bl) {
            this.initialize(true);
        }
    }

    public void initialize(boolean bl) {
        this.initialized = true;
    }

    public void processStatePacket(Packet250CustomPayload packet250CustomPayload, long l) {
        if (!this.initialized) {
            this.initialize(false);
        }
        boolean bl = (l >>> 13 & 1L) != 0L;
        this.setCrawling(bl);
        boolean bl2 = (l >>> 15 & 1L) != 0L;
        this.setSmall(bl2);
        boolean bl3 = (l >>> 14 & 1L) != 0L;
        boolean bl4 = (l >>> 12 & 1L) != 0L;
        boolean bl5 = (l >>> 18 & 1L) != 0L;
        boolean bl6 = (l >>> 31 & 1L) != 0L;
        this.resetFallDistance = bl3 || bl4 || bl5 || bl6;
        this.resetTicksForFloatKick = bl3 || bl4 || bl5;
        this.lastStatePacket = packet250CustomPayload;
        this.mp.sendPacketToTrackedPlayers(packet250CustomPayload);
    }

    public void afterOnUpdate() {
        if (this.resetFallDistance) {
            this.mp.resetFallDistance();
        }
        if (this.resetTicksForFloatKick) {
            this.mp.resetTicksForFloatKick();
        }
    }

    public static void initialize(File file, Logger logger, int n, boolean bl) {
        if (bl) {
            Assert.server(logger);
        }
        SmartMovingServer.initialize(file, logger, n, new SmartMovingConfig());
    }

    public static void initialize(File file, Logger logger, int n, SmartMovingConfig smartMovingConfig) {
        Options = smartMovingConfig;
        optionsHandler = new SmartMovingServerOptions(Options, file, logger, n);
    }

    public void setCrawling(boolean bl) {
        if (!bl && this.isCrawling) {
            this.crawlingCooldown = 10;
        }
        this.isCrawling = bl;
    }

    public void setSmall(boolean bl) {
        PlayerCapabilities playerCapabilities = this.mp.getMoving().player.capabilities;
        if (playerCapabilities._d || playerCapabilities._c || !AnticheatHandler.ENABLE_MOVEMENT_ANTICHEAT) {
            this.mp.setHeight(bl ? 0.8f : 1.8f);
        }
        this.isSmall = bl;
    }

    public void afterSetPosition(double d, double d2, double d3) {
        if (!this.crawlingInitialized) {
            this.mp.setMaxY(this.mp.getMinY() + (double)this.mp.getHeight() - 1.0);
        }
    }

    public void beforeIsPlayerSleeping() {
        if (!this.crawlingInitialized) {
            this.mp.setMaxY(this.mp.getMinY() + (double)this.mp.getHeight());
            this.crawlingInitialized = true;
        }
    }

    public void onPlayerJoin() {
        if (!this.crawlingInitialized) {
            this.mp.setMaxY(this.mp.getMinY() + (double)this.mp.getHeight());
            this.crawlingInitialized = true;
        }
    }

    public void beforeOnUpdate() {
        if (this.crawlingCooldown > 0) {
            --this.crawlingCooldown;
        }
    }

    public void beforeOnLivingUpdate() {
        this.withinOnLivingUpdate = true;
    }

    public void afterOnLivingUpdate() {
        this.withinOnLivingUpdate = false;
        if (this.isSmall && this.mp.doGetHealth() > 0.0f) {
            double d = 0.25;
            AxisAlignedBB axisAlignedBB = this.mp.expandBox(this.mp.getBox(), 1.0, d, 1.0);
            List list2 = this.mp.getEntitiesExcludingPlayer(axisAlignedBB);
            if (list2 != null && list2.size() > 0) {
                Object[] objectArray = list2.toArray();
                axisAlignedBB = this.mp.expandBox(axisAlignedBB, 0.0, -d, 0.0);
                List list3 = this.mp.getEntitiesExcludingPlayer(axisAlignedBB);
                for (int i = 0; i < objectArray.length; ++i) {
                    Entity entity = (Entity)objectArray[i];
                    if (list3 != null && list3.contains(entity) || this.mp.isDeadEntity(entity)) continue;
                    this.mp.onCollideWithPlayer(entity);
                }
            }
        }
    }

    public boolean isEntityInsideOpaqueBlock() {
        return this.crawlingCooldown > 0 ? false : this.mp.localIsEntityInsideOpaqueBlock();
    }

    public void addMovementStat(double d, double d2, double d3) {
        this.beforeAddMovingHungerBatch();
        this.mp.localAddMovementStat(d, d2, d3);
        this.afterAddMovingHungerBatch();
    }

    public void beforeAddMovingHungerBatch() {
        ++this.disableAddExhaustionDepth;
        this.disableAddExhaustion = true;
    }

    public void addExhaustion(float f) {
        if (!this.disableAddExhaustion) {
            this.mp.localAddExhaustion(f);
        }
    }

    public void afterAddMovingHungerBatch() {
        --this.disableAddExhaustionDepth;
        if (this.disableAddExhaustionDepth == 0) {
            this.disableAddExhaustion = false;
        }
    }
}

