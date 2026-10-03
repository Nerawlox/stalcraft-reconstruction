/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import java.lang.reflect.Method;
import java.util.HashSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.sajh;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.smart.moving.ClimbGap;
import net.smart.moving.FeetClimbing;
import net.smart.moving.HandsClimbing;
import net.smart.moving.config.SmartMovingAnticheatConfig;
import net.smart.utilities.Install;
import net.smart.utilities.Name;
import net.smart.utilities.Reflect;

public class Orientation {
    public static final Orientation ZZ = new Orientation(0, 0);
    public static final Orientation PZ = new Orientation(1, 0);
    public static final Orientation ZP = new Orientation(0, 1);
    public static final Orientation NZ = new Orientation(-1, 0);
    public static final Orientation ZN = new Orientation(0, -1);
    public static final Orientation PP = new Orientation(1, 1);
    public static final Orientation NN = new Orientation(-1, -1);
    public static final Orientation PN = new Orientation(1, -1);
    public static final Orientation NP = new Orientation(-1, 1);
    public static final int DefaultMeta = -1;
    public static final int VineFrontMeta = 0;
    public static final int VineSideMeta = 1;
    private static final int top = 2;
    private static final int middle = 1;
    private static final int base = 0;
    private static final int sub = -1;
    private static final int subSub = -2;
    private static final int NoGrab = 0;
    private static final int HalfGrab = 1;
    private static final int AroundGrab = 2;
    public static final HashSet<Orientation> Orthogonals = new HashSet();
    public int _i;
    public int _k;
    private boolean _isDiagonal;
    private float _directionAngle;
    private float _mimimumClimbingAngle;
    private float _maximumClimbingAngle;
    private static HashSet<Orientation> _getClimbingOrientationsHashSet;
    private static final float _handClimbingHoldGap;
    private static ClimbGap _climbGapTemp;
    private static ClimbGap _climbGapOuterTemp;
    private static World world;
    private static double base_jhd;
    private static double jh_offset;
    private static int all_j;
    private static int all_offset;
    private static int base_i;
    private static int base_k;
    private static double base_id;
    private static double base_kd;
    private static int remote_i;
    private static int remote_k;
    private static boolean crawl;
    private static int local_halfOffset;
    private static int local_half;
    private static int local_offset;
    private static boolean grabRemote;
    private static int grabType;
    private static int grabBlockId;
    private static int grabMeta;
    private static final Method _isLadder;
    private static final Method _canConnectFenceTo;
    private static final Block[] _knownFanceGateBlocks;
    private static final Block[] _knownFenceBlocks;
    private static final Block[] _knownWallBlocks;
    private static final Block[] _knownHalfBlocks;
    private static final Block[] _knownCompactStairBlocks;
    private static final Block[] _knownTrapDoorBlocks;
    private static final Block[] _knownThinWallBlocks;
    private static final Class[] _ladderKitLadderTypes;

    private Orientation(int n, int n2) {
        this._i = n;
        this._k = n2;
        this._isDiagonal = this._i != 0 && this._k != 0;
        this.setClimbingAngles();
    }

    public Orientation rotate(int n) {
        switch (n) {
            case -180: 
            case 180: {
                if (this == PZ) {
                    return NZ;
                }
                if (this == PN) {
                    return NP;
                }
                if (this == ZN) {
                    return ZP;
                }
                if (this == NN) {
                    return PP;
                }
                if (this == NZ) {
                    return PZ;
                }
                if (this == NP) {
                    return PN;
                }
                if (this == ZP) {
                    return ZN;
                }
                if (this == PP) {
                    return NN;
                }
            }
            case -135: {
                return this.rotate(-180).rotate(45);
            }
            case -90: {
                return this.rotate(-45).rotate(-45);
            }
            case -45: {
                if (this == PZ) {
                    return PN;
                }
                if (this == PN) {
                    return ZN;
                }
                if (this == ZN) {
                    return NN;
                }
                if (this == NN) {
                    return NZ;
                }
                if (this == NZ) {
                    return NP;
                }
                if (this == NP) {
                    return ZP;
                }
                if (this == ZP) {
                    return PP;
                }
                if (this == PP) {
                    return PZ;
                }
                return null;
            }
            case 45: {
                if (this == PZ) {
                    return PP;
                }
                if (this == PP) {
                    return ZP;
                }
                if (this == ZP) {
                    return NP;
                }
                if (this == NP) {
                    return NZ;
                }
                if (this == NZ) {
                    return NN;
                }
                if (this == NN) {
                    return ZN;
                }
                if (this == ZN) {
                    return PN;
                }
                if (this == PN) {
                    return PZ;
                }
                return null;
            }
            case 90: {
                return this.rotate(45).rotate(45);
            }
            case 135: {
                return this.rotate(180).rotate(-45);
            }
        }
        throw new RuntimeException("angle not supported");
    }

    public static Orientation getOrientation(EntityPlayer entityPlayer, float f, boolean bl, boolean bl2) {
        return Orientation.getOrientation(entityPlayer.rotationYaw, f, bl, bl2);
    }

    public static Orientation getOrientation(jyfy jyfy2, float f, boolean bl, boolean bl2) {
        return Orientation.getOrientation(jyfy2._B, f, bl, bl2);
    }

    public static Orientation getOrientation(float f, float f2, boolean bl, boolean bl2) {
        float f3;
        float f4;
        float f5 = f % 360.0f;
        if (f5 < 0.0f) {
            f5 += 360.0f;
        }
        if ((f4 = f5 - f2) < 0.0f) {
            f4 += 360.0f;
        }
        if ((f3 = f5 + f2) >= 360.0f) {
            f3 -= 360.0f;
        }
        if (bl) {
            if (NZ.isWithinAngle(f4, f3)) {
                return NZ;
            }
            if (PZ.isWithinAngle(f4, f3)) {
                return PZ;
            }
            if (ZN.isWithinAngle(f4, f3)) {
                return ZN;
            }
            if (ZP.isWithinAngle(f4, f3)) {
                return ZP;
            }
        }
        if (bl2) {
            if (NP.isWithinAngle(f4, f3)) {
                return NP;
            }
            if (PN.isWithinAngle(f4, f3)) {
                return PN;
            }
            if (NN.isWithinAngle(f4, f3)) {
                return NN;
            }
            if (PP.isWithinAngle(f4, f3)) {
                return PP;
            }
        }
        return null;
    }

    public double getHorizontalBorderGap(Entity entity) {
        return this.getHorizontalBorderGap(entity.posX, entity.posZ);
    }

    private double getHorizontalBorderGap() {
        return this.getHorizontalBorderGap(base_id, base_kd);
    }

    public double getHorizontalBorderGap(double d, double d2) {
        return this == NZ ? d % 1.0 : (this == PZ ? 1.0 - d % 1.0 : (this == ZN ? d2 % 1.0 : (this == ZP ? 1.0 - d2 % 1.0 : 0.0)));
    }

    public boolean isTunnelAhead(World world, int n, int n2, int n3) {
        Material material;
        int n4 = world.getBlockId(n + this._i, n2 + 1, n3 + this._k);
        return Orientation.isFullEmpty(n4) && (material = world.getBlockMaterial(n + this._i, n2 + 2, n3 + this._k)) != null && Orientation.isSolid(material);
    }

    public static HashSet<Orientation> getClimbingOrientations(EntityPlayer entityPlayer, boolean bl, boolean bl2) {
        return Orientation.getClimbingOrientations(entityPlayer.rotationYaw, bl, bl2);
    }

    public static HashSet<Orientation> getClimbingOrientations(jyfy jyfy2, boolean bl, boolean bl2) {
        return Orientation.getClimbingOrientations(jyfy2._B, bl, bl2);
    }

    public static HashSet<Orientation> getClimbingOrientations(float f, boolean bl, boolean bl2) {
        float f2 = f % 360.0f;
        if (f2 < 0.0f) {
            f2 += 360.0f;
        }
        if (_getClimbingOrientationsHashSet == null) {
            _getClimbingOrientationsHashSet = new HashSet();
        } else {
            _getClimbingOrientationsHashSet.clear();
        }
        if (bl) {
            NZ.addTo(f2);
            PZ.addTo(f2);
            ZN.addTo(f2);
            ZP.addTo(f2);
        }
        if (bl2) {
            NP.addTo(f2);
            PN.addTo(f2);
            NN.addTo(f2);
            PP.addTo(f2);
        }
        return _getClimbingOrientationsHashSet;
    }

    private void addTo(float f) {
        if (this.isRotationForClimbing(f)) {
            _getClimbingOrientationsHashSet.add(this);
        }
    }

    public boolean isFeetLadderSubstitute(World world, int n, int n2, int n3) {
        int n4 = n + this._i;
        int n5 = n3 + this._k;
        return this.isLadderSubstitute(world, n4, n2, n5, 1) > 0 || this.isLadderSubstitute(world, n4, n2, n5, 0) > 0;
    }

    public boolean isHandsLadderSubstitute(World world, int n, int n2, int n3) {
        int n4 = n + this._i;
        int n5 = n3 + this._k;
        return this.isLadderSubstitute(world, n4, n2, n5, 1) > 0 || this.isLadderSubstitute(world, n4, n2, n5, 0) > 0 || this.isLadderSubstitute(world, n4, n2, n5, -1) > 0;
    }

    private int isLadderSubstitute(World world, int n, int n2, int n3, int n4) {
        Orientation.world = world;
        remote_i = n;
        all_j = n2;
        remote_k = n3;
        all_offset = 0;
        return this.isLadderSubstitute(n4, null);
    }

    public void seekClimbGap(float f, World world, int n, double d, double d2, int n2, double d3, boolean bl, boolean bl2, boolean bl3, HandsClimbing[] handsClimbingArray, FeetClimbing[] feetClimbingArray, ClimbGap climbGap, ClimbGap climbGap2) {
        if (this.isRotationForClimbing(f)) {
            this.initialize(world, n, d, d2, n2, d3);
            handsClimbingArray[0] = handsClimbingArray[0].max(this.handsClimbing(bl, bl2, bl3, _climbGapOuterTemp), climbGap, _climbGapOuterTemp);
            feetClimbingArray[0] = feetClimbingArray[0].max(this.feetClimbing(bl, bl2, bl3, _climbGapOuterTemp), climbGap2, _climbGapOuterTemp);
        }
    }

    private HandsClimbing handsClimbing(boolean bl, boolean bl2, boolean bl3, ClimbGap climbGap) {
        climbGap.reset();
        _climbGapTemp.reset();
        Orientation.initializeOffset(3.0, bl, bl2, bl3);
        HandsClimbing handsClimbing = HandsClimbing.None;
        if (this.isLadderSubstitute(1, _climbGapTemp) > 0) {
            handsClimbing = jh_offset > 1.0 - (double)_handClimbingHoldGap ? handsClimbing.max(HandsClimbing.Up, climbGap, _climbGapTemp) : handsClimbing.max(HandsClimbing.None, climbGap, _climbGapTemp);
        }
        if (this.isLadderSubstitute(0, _climbGapTemp) > 0) {
            handsClimbing = jh_offset < (double)_handClimbingHoldGap ? handsClimbing.max(HandsClimbing.BottomHold, climbGap, _climbGapTemp) : handsClimbing.max(HandsClimbing.Up, climbGap, _climbGapTemp);
        }
        Orientation._climbGapTemp.SkipGaps = bl || bl2;
        int n = this.isLadderSubstitute(-1, _climbGapTemp);
        if (!(n <= 0 || bl3 && n > 1)) {
            handsClimbing = !bl && n > 2 ? handsClimbing.max(HandsClimbing.FastUp, climbGap, _climbGapTemp) : (bl && n > 1 ? handsClimbing.max(HandsClimbing.FastUp, climbGap, _climbGapTemp) : (jh_offset < (double)_handClimbingHoldGap ? (grabType == 2 ? handsClimbing.max(HandsClimbing.Up, climbGap, _climbGapTemp) : handsClimbing.max(HandsClimbing.TopHold, climbGap, _climbGapTemp)) : (grabType == 2 ? handsClimbing.max(HandsClimbing.TopHold, climbGap, _climbGapTemp) : handsClimbing.max(HandsClimbing.Sink, climbGap, _climbGapTemp))));
        }
        if ((n = this.isLadderSubstitute(-2, _climbGapTemp)) > 0 && !bl3 && (n > 2 && !bl2 || grabType == 2 || n > 1 && bl)) {
            handsClimbing = jh_offset < (double)_handClimbingHoldGap && !bl ? handsClimbing.max(HandsClimbing.TopHold, climbGap, _climbGapTemp) : (bl ? handsClimbing.max(HandsClimbing.FastUp, climbGap, _climbGapTemp) : handsClimbing.max(HandsClimbing.Sink, climbGap, _climbGapTemp));
        }
        return handsClimbing;
    }

    private FeetClimbing feetClimbing(boolean bl, boolean bl2, boolean bl3, ClimbGap climbGap) {
        climbGap.reset();
        _climbGapTemp.reset();
        Orientation.initializeOffset(0.0, bl, bl2, bl3);
        FeetClimbing feetClimbing = FeetClimbing.None;
        if (this.isLadderSubstitute(2, _climbGapTemp) > 0) {
            feetClimbing = feetClimbing.max(FeetClimbing.None, climbGap, _climbGapTemp);
        }
        Orientation._climbGapTemp.SkipGaps = bl || bl2;
        int n = this.isLadderSubstitute(1, _climbGapTemp);
        if (n > 0 && !bl3) {
            feetClimbing = n > 3 && !bl ? (!bl2 ? feetClimbing.max(FeetClimbing.FastUp, climbGap, _climbGapTemp) : feetClimbing.max(FeetClimbing.None, climbGap, _climbGapTemp)) : ((bl || bl2) && n > 1 ? (bl2 ? feetClimbing.max(FeetClimbing.BaseWithHands, climbGap, _climbGapTemp) : feetClimbing.max(FeetClimbing.FastUp, climbGap, _climbGapTemp)) : (n > 2 ? (!bl ? feetClimbing.max(FeetClimbing.SlowUpWithHoldWithoutHands, climbGap, _climbGapTemp) : feetClimbing.max(FeetClimbing.None, climbGap, _climbGapTemp)) : feetClimbing.max(FeetClimbing.TopWithHands, climbGap, _climbGapTemp)));
        }
        if ((n = this.isLadderSubstitute(0, _climbGapTemp)) > 0) {
            feetClimbing = n > 3 && !bl3 && !bl2 ? feetClimbing.max(FeetClimbing.FastUp, climbGap, _climbGapTemp) : (n > 2 && !bl3 ? (!bl ? (jh_offset < (double)_handClimbingHoldGap ? feetClimbing.max(FeetClimbing.SlowUpWithHoldWithoutHands, climbGap, _climbGapTemp) : feetClimbing.max(FeetClimbing.SlowUpWithSinkWithoutHands, climbGap, _climbGapTemp)) : feetClimbing.max(FeetClimbing.None, climbGap, _climbGapTemp)) : (jh_offset < 1.0 - (double)_handClimbingHoldGap ? feetClimbing.max(FeetClimbing.BaseWithHands, climbGap, _climbGapTemp) : feetClimbing.max(FeetClimbing.BaseHold, climbGap, _climbGapTemp)));
        }
        if (this.isLadderSubstitute(-1, _climbGapTemp) > 0) {
            feetClimbing = feetClimbing.max(FeetClimbing.None, climbGap, _climbGapTemp);
        }
        if (bl2 || bl3) {
            feetClimbing = feetClimbing.max(FeetClimbing.BaseWithHands, climbGap, _climbGapTemp);
        }
        return feetClimbing;
    }

    private int isLadderSubstitute(int n, ClimbGap climbGap) {
        int n2;
        Orientation.initializeLocal(n);
        if (local_half == 1) {
            if (this.hasHalfHold()) {
                if (!grabRemote) {
                    boolean bl;
                    boolean bl2 = this.isOnLadderOrVine(0) || this.isOnOpenTrapDoor(0) || this.isRope(0) || this.isOnWallRope(0);
                    boolean bl3 = this.isOnLadderOrVine(1) || this.isOnOpenTrapDoor(1) || this.isRope(1) || this.isOnWallRope(1);
                    boolean bl4 = this.isBaseAccessible(1, false, true);
                    boolean bl5 = this.isBaseAccessible(2, false, true);
                    boolean bl6 = bl4 && this.isFullAccessible(1, grabRemote);
                    boolean bl7 = bl = bl4 && this.isFullExtentAccessible(2, grabRemote);
                    n2 = bl2 ? (bl3 ? 1 : (bl5 ? 1 : 1)) : (bl4 ? (bl6 ? (bl ? 5 : (crawl ? 3 : 5)) : (bl3 ? 5 : 1)) : 1);
                } else {
                    n2 = this.isBaseAccessible(0) ? (this.isUpperHalfFrontEmpty(remote_i, 0, remote_k) ? (this.isFullAccessible(1, grabRemote) ? (this.isFullExtentAccessible(2, grabRemote) ? 5 : (this.isJustLowerHalfExtentAccessible(2) ? 4 : 3)) : 1) : 1) : 0;
                }
            } else {
                n2 = 0;
            }
        } else if (this.hasBottomHold()) {
            if (!grabRemote) {
                boolean bl;
                boolean bl8 = this.isOnLadderOrVine(0) || this.isOnOpenTrapDoor(0) || this.isRope(0) || this.isOnWallRope(0);
                boolean bl9 = this.isOnLadderOrVine(1) || this.isOnOpenTrapDoor(1) || this.isRope(1) || this.isOnWallRope(0);
                boolean bl10 = this.isBaseAccessible(0, false, true);
                boolean bl11 = this.isBaseAccessible(1, false, true);
                boolean bl12 = bl10 && this.isFullAccessible(0, grabRemote);
                boolean bl13 = bl = bl10 && this.isFullExtentAccessible(1, grabRemote);
                n2 = bl8 ? (bl9 ? 1 : (bl11 ? 1 : 1)) : (bl10 ? (bl12 ? (bl11 ? (bl ? 4 : (crawl ? 2 : 4)) : 2) : (bl9 ? 2 : 1)) : 1);
            } else {
                n2 = this.isBaseAccessible(0) ? (this.isFullAccessible(0, grabRemote) ? (this.isFullExtentAccessible(1, grabRemote) ? 4 : 2) : 1) : 0;
            }
        } else {
            n2 = 0;
        }
        if (climbGap != null && n2 > 0) {
            climbGap.BlockId = grabBlockId;
            climbGap.Meta = grabMeta;
            climbGap.CanStand = n2 > 3;
            climbGap.MustCrawl = n2 > 1 && n2 < 4;
            climbGap.Direction = this;
        }
        return n2;
    }

    private boolean hasHalfHold() {
        int n;
        int n2;
        int n3;
        if (SmartMovingAnticheatConfig.instance.isFreeBaseClimb()) {
            if (this.isOnLadder(0) && this.isOnLadderFront(0)) {
                return this.setHalfGrabType(2, Orientation.getBaseBlockId(0), false);
            }
            if (this.remoteLadderClimbing(0)) {
                return this.setHalfGrabType(2, Orientation.getRemoteBlockId(0), true);
            }
        }
        if (SmartMovingAnticheatConfig.hasBetterThanWolves || SmartMovingAnticheatConfig.hasRopesPlus) {
            n3 = this.getRopeId(0);
            if (n3 >= 0 && this.isHeadedToRope()) {
                return this.setHalfGrabType(2, n3, false);
            }
            n3 = this.getAnchorId(0);
            if (n3 >= 0 && this.isOnAnchorFront(0)) {
                return this.setHalfGrabType(1, n3, false);
            }
        }
        n3 = Orientation.getRemoteBlockId(0);
        if (this.isEmpty(base_i, 0, base_k) && n3 == Block.fenceIron.blockID && this.headedToFrontWall(remote_i, 0, remote_k, n3)) {
            return this.setHalfGrabType(1, n3);
        }
        int n4 = Orientation.getWallBlockId(base_i, 0, base_k);
        if (n4 == Block.fenceIron.blockID && this.headedToBaseWall(0, n4)) {
            return this.setHalfGrabType(1, n4, false);
        }
        if (((Boolean)SmartMovingAnticheatConfig.instance._freeFenceClimbing.value).booleanValue()) {
            if (Orientation.isFence(n3, remote_i, 0, remote_k) && this.headedToFrontWall(remote_i, 0, remote_k, n3)) {
                if (!Orientation.isFence(Orientation.getBaseBlockId(0), base_i, 0, base_k)) {
                    return this.setHalfGrabType(1, n3);
                }
                if (this.headedToFrontSideWall(remote_i, 0, remote_k, n3)) {
                    return this.setHalfGrabType(1, n3);
                }
            }
            if (Orientation.isFence(n2 = Orientation.getRemoteBlockId(-1), remote_i, -1, remote_k) && this.headedToFrontWall(remote_i, -1, remote_k, n2)) {
                if (!Orientation.isFence(Orientation.getBaseBlockId(-1), remote_i, -1, remote_k)) {
                    return this.setHalfGrabType(1, n3);
                }
                if (this.headedToFrontSideWall(remote_i, -1, remote_k, n2)) {
                    return this.setHalfGrabType(1, n3);
                }
            }
            if (Orientation.isFence(n4, base_i, 0, base_k) && this.headedToBaseWall(0, n4)) {
                return this.setHalfGrabType(1, n4, false);
            }
            n = Orientation.getWallBlockId(base_i, -1, base_k);
            if (Orientation.isFence(n, base_i, -1, base_k) && this.headedToBaseWall(-1, n)) {
                return this.setHalfGrabType(1, n, false);
            }
            if (n3 == Block.cobblestoneWall.blockID && !this.headedToRemoteFlatWall(n3, 0)) {
                return this.setHalfGrabType(1, n3);
            }
            if (n2 == Block.cobblestoneWall.blockID && !this.headedToRemoteFlatWall(n2, -1)) {
                return this.setHalfGrabType(1, n2);
            }
        }
        if (!Orientation.isBottomHalfBlock(n3, n2 = Orientation.getRemoteBlockMetadata(0)) && (!Orientation.isStairCompact(n3) || !this.isBottomStairCompactNotBack(n2) || Orientation.isStairCompact(Orientation.getBaseBlockId(-1)) && this.isBottomStairCompactFront(Orientation.getBaseBlockMetadata(-1)))) {
            if (Orientation.isTrapDoor(n3) && Orientation.isClosedTrapDoor(Orientation.getRemoteBlockMetadata(0))) {
                return this.setHalfGrabType(1, n3);
            }
            n = Orientation.getBaseBlockId(0);
            if (Orientation.isTrapDoor(n) && !Orientation.isClosedTrapDoor(Orientation.getBaseBlockMetadata(0))) {
                return this.setHalfGrabType(1, n, false);
            }
            if (SmartMovingAnticheatConfig.hasASGrapplingHook && ((Boolean)SmartMovingAnticheatConfig.instance._replaceRopeClimbing.value).booleanValue() || SmartMovingAnticheatConfig.hasRopesPlus) {
                if (Orientation.isASRope(n) && this.isASGrapplingHookFront(Orientation.getBaseBlockMetadata(0))) {
                    return this.setHalfGrabType(1, n, false);
                }
                if (Orientation.isASRope(n3) && this.rotate(180).isASGrapplingHookFront(n2)) {
                    return this.setHalfGrabType(1, n3, true);
                }
            }
            if (SmartMovingAnticheatConfig.instance.isFreeBaseClimb()) {
                int n5 = this.baseVineClimbing(0);
                if (n5 > -1) {
                    return this.setHalfGrabType(1, Block.vine.blockID, false, n5);
                }
                n5 = this.remoteVineClimbing(0);
                if (n5 > -1) {
                    return this.setHalfGrabType(1, Block.vine.blockID, false, n5);
                }
            }
            return this.setHalfGrabType(0, 0);
        }
        return this.setHalfGrabType(1, n3);
    }

    private boolean hasBottomHold() {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        if (SmartMovingAnticheatConfig.instance.isFreeBaseClimb()) {
            if (this.isOnLadder(-1) && this.isOnLadderFront(-1)) {
                return this.setBottomGrabType(2, Orientation.getBaseBlockId(-1), false);
            }
            if (this.isOnLadder(0) && this.isOnLadderFront(0)) {
                return this.setBottomGrabType(2, Orientation.getBaseBlockId(0), false);
            }
            if (this.remoteLadderClimbing(-1)) {
                return this.setBottomGrabType(2, Orientation.getRemoteBlockId(-1), true);
            }
            if (this.remoteLadderClimbing(0)) {
                return this.setBottomGrabType(2, Orientation.getRemoteBlockId(0), true);
            }
        }
        if (SmartMovingAnticheatConfig.hasBetterThanWolves || SmartMovingAnticheatConfig.hasRopesPlus) {
            n5 = this.getRopeId(-1);
            if (!(n5 >= 0 && this.isHeadedToRope() || (n5 = this.getRopeId(0)) >= 0 && this.isHeadedToRope())) {
                n5 = this.getAnchorId(-1);
                if (n5 >= 0 && this.isOnAnchorFront(-1) || (n5 = this.getAnchorId(0)) >= 0 && this.isOnAnchorFront(0)) {
                    return this.setBottomGrabType(1, n5, false);
                }
            } else {
                return this.setBottomGrabType(2, n5, false);
            }
        }
        n5 = Orientation.getRemoteBlockId(0);
        int n6 = Orientation.getRemoteBlockId(-1);
        boolean bl = this.isLowerHalfFrontFullEmpty(remote_i, 0, remote_k);
        if (SmartMovingAnticheatConfig.hasRedPowerWire) {
            if (Orientation.isRedPowerWire(n6) && (this.isRedPowerWireFullFront(n4 = Orientation.getRpCoverSides(remote_i, -1, remote_k)) || Orientation.isRedPowerWireTop(n4)) && bl) {
                return this.setBottomGrabType(1, n6);
            }
            if (Orientation.isRedPowerWire(n5) && Orientation.isRedPowerWireBottom(n4 = Orientation.getRpCoverSides(remote_i, 0, remote_k)) && bl) {
                return this.setBottomGrabType(1, n6);
            }
            n4 = Orientation.getBaseBlockId(-1);
            if (Orientation.isRedPowerWire(n4) && this.isRedPowerWireFullBack(n3 = Orientation.getRpCoverSides(base_i, -1, base_k)) && bl) {
                return this.setBottomGrabType(1, n6);
            }
            if (Orientation.isRedPowerWire(n6)) {
                return false;
            }
        }
        if (this.isEmpty(base_i, -1, base_k) && n6 == Block.fenceIron.blockID && this.headedToFrontWall(remote_i, -1, remote_k, n6)) {
            return this.setBottomGrabType(1, n6);
        }
        if (((Boolean)SmartMovingAnticheatConfig.instance._freeFenceClimbing.value).booleanValue()) {
            n4 = Orientation.getBaseBlockId(-1);
            if (Orientation.isFence(n6, remote_i, -1, remote_k) && this.headedToFrontWall(remote_i, -1, remote_k, n6)) {
                if (!Orientation.isFence(n4, base_i, -1, base_k)) {
                    return this.setBottomGrabType(1, n6);
                }
                if (this.headedToFrontSideWall(remote_i, -1, remote_k, n6)) {
                    return this.setBottomGrabType(1, n6);
                }
            }
            if (n6 == Block.cobblestoneWall.blockID && !this.headedToRemoteFlatWall(n6, -1)) {
                return this.setHalfGrabType(1, n6);
            }
            if (n5 == Block.cobblestoneWall.blockID && !this.headedToRemoteFlatWall(n5, 0)) {
                return this.setHalfGrabType(1, n5);
            }
        }
        if ((n4 = Orientation.getWallBlockId(base_i, -1, base_k)) != -1) {
            if (this.isEmpty(base_i - this._i, 0, base_k - this._k) && this.isEmpty(base_i - this._i, -1, base_k - this._k)) {
                if (n4 == Block.fenceIron.blockID && this.headedToBaseWall(-1, n4)) {
                    return this.setBottomGrabType(1, n4, false);
                }
                if (this.headedToBaseGrabWall(-1, n4)) {
                    return this.setBottomGrabType(1, n4, false);
                }
            }
            return (Boolean)SmartMovingAnticheatConfig.instance._freeFenceClimbing.value != false && Orientation.isFence(n4, base_i, -1, base_k) && this.headedToBaseWall(-1, n4) ? this.setBottomGrabType(1, n4, false) : false;
        }
        n3 = Orientation.getRemoteBlockMetadata(-1);
        if (!(!bl || !this.isBaseAccessible(-1, true, false) || !this.isUpperHalfFrontAnySolid(remote_i, -1, remote_k) || Orientation.isBottomHalfBlock(n6, n3) || Orientation.isStairCompact(n6) && this.isBottomStairCompactFront(n3) || Orientation.isDoor(n6) && !Orientation.isDoorTop(n3) || Orientation.isDoor(Orientation.getBaseBlockId(0)) && this.isDoorFrontBlocked(base_i, 0, base_k) || !((Boolean)SmartMovingAnticheatConfig.instance._freeFenceClimbing.value).booleanValue() && this.isFence(remote_i, -1, remote_k))) {
            return this.setBottomGrabType(1, n6);
        }
        if (Orientation.isStairCompact(n5) && Orientation.isTopStairCompact(n2 = Orientation.getRemoteBlockMetadata(0)) && !this.isTopStairCompactBack(n2) && this.isUpperHalfFrontFullSolid(remote_i, -1, remote_k)) {
            return this.setBottomGrabType(1, n6);
        }
        n2 = Orientation.getBaseBlockId(-1);
        int n7 = Orientation.getBaseBlockMetadata(-1);
        if (Orientation.isTrapDoor(n2) && !Orientation.isClosedTrapDoor(Orientation.getBaseBlockMetadata(-1))) {
            return this.setBottomGrabType(1, n2, false);
        }
        if (Orientation.isDoor(n2) && Orientation.isDoorTop(n7) && this.isDoorFrontBlocked(base_i, -1, base_k) && this.isBaseAccessible(0)) {
            return this.setBottomGrabType(1, n2, false);
        }
        if (SmartMovingAnticheatConfig.hasASGrapplingHook && ((Boolean)SmartMovingAnticheatConfig.instance._replaceRopeClimbing.value).booleanValue() || SmartMovingAnticheatConfig.hasRopesPlus) {
            if (Orientation.isASRope(n2) && this.isASGrapplingHookFront(Orientation.getBaseBlockMetadata(0))) {
                return this.setBottomGrabType(1, n2, false);
            }
            n = Orientation.getBaseBlockId(0);
            if (Orientation.isASRope(n) && this.isASGrapplingHookFront(Orientation.getBaseBlockMetadata(0))) {
                return this.setBottomGrabType(1, n, false);
            }
            if (Orientation.isASRope(n6) && this.rotate(180).isASGrapplingHookFront(n3)) {
                return this.setHalfGrabType(1, n6, true);
            }
            if (Orientation.isASRope(n5) && this.rotate(180).isASGrapplingHookFront(Orientation.getRemoteBlockMetadata(0))) {
                return this.setHalfGrabType(1, n5, true);
            }
        }
        if (SmartMovingAnticheatConfig.instance.isFreeBaseClimb()) {
            n = this.baseVineClimbing(-1);
            if (n != -1) {
                return this.setHalfGrabType(1, Block.vine.blockID, false, n);
            }
            n = this.baseVineClimbing(0);
            if (n != -1) {
                return this.setHalfGrabType(1, Block.vine.blockID, false, n);
            }
            n = this.remoteVineClimbing(-1);
            if (n != -1) {
                return this.setHalfGrabType(1, Block.vine.blockID, false, n);
            }
            n = this.remoteVineClimbing(0);
            if (n != -1) {
                return this.setHalfGrabType(1, Block.vine.blockID, false, n);
            }
        }
        return this.setBottomGrabType(0, 0);
    }

    private boolean setHalfGrabType(int n, int n2) {
        return this.setHalfGrabType(n, n2, true);
    }

    private boolean setHalfGrabType(int n, int n2, boolean bl) {
        return this.setHalfGrabType(n, n2, bl, -1);
    }

    private boolean setHalfGrabType(int n, int n2, boolean bl, int n3) {
        boolean bl2;
        boolean bl3 = bl2 = n != 0;
        if (bl2 && bl && this._isDiagonal) {
            boolean bl4 = this.rotate(90).isUpperHalfFrontEmpty(base_i, 0, remote_k);
            boolean bl5 = this.rotate(-90).isUpperHalfFrontEmpty(remote_i, 0, base_k);
            bl2 &= bl4 && bl5;
        }
        return Orientation.setGrabType(n, n2, bl, bl2, n3);
    }

    private boolean setBottomGrabType(int n, int n2) {
        return this.setBottomGrabType(n, n2, true);
    }

    private boolean setBottomGrabType(int n, int n2, boolean bl) {
        return this.setBottomGrabType(n, n2, bl, -1);
    }

    private boolean setBottomGrabType(int n, int n2, boolean bl, int n3) {
        boolean bl2;
        boolean bl3 = bl2 = n != 0;
        if (bl2 && bl && this._isDiagonal) {
            boolean bl4 = this.rotate(90).isLowerHalfFrontFullEmpty(base_i, 0, remote_k);
            boolean bl5 = this.rotate(-90).isLowerHalfFrontFullEmpty(remote_i, 0, base_k);
            bl2 &= bl4 && bl5;
        }
        return Orientation.setGrabType(n, n2, bl, bl2, n3);
    }

    private static boolean setGrabType(int n, int n2, boolean bl, boolean bl2, int n3) {
        grabRemote = bl;
        grabType = bl2 ? n : 0;
        grabBlockId = n2;
        grabMeta = n3;
        return bl2;
    }

    private boolean setClimbingAngles() {
        switch (this._i) {
            case -1: {
                switch (this._k) {
                    case -1: {
                        return this.setClimbingAngles(135.0f);
                    }
                    case 0: {
                        return this.setClimbingAngles(90.0f);
                    }
                    case 1: {
                        return this.setClimbingAngles(45.0f);
                    }
                }
                return false;
            }
            case 0: {
                switch (this._k) {
                    case -1: {
                        return this.setClimbingAngles(180.0f);
                    }
                    case 0: {
                        return this.setClimbingAngles(0.0f, 360.0f);
                    }
                    case 1: {
                        return this.setClimbingAngles(0.0f);
                    }
                }
                return false;
            }
            case 1: {
                switch (this._k) {
                    case -1: {
                        return this.setClimbingAngles(225.0f);
                    }
                    case 0: {
                        return this.setClimbingAngles(270.0f);
                    }
                    case 1: {
                        return this.setClimbingAngles(315.0f);
                    }
                }
            }
        }
        return false;
    }

    private boolean setClimbingAngles(float f) {
        this._directionAngle = f;
        float f2 = (this._isDiagonal ? (Float)SmartMovingAnticheatConfig.instance._freeClimbingDiagonalDirectionAngle.value : (Float)SmartMovingAnticheatConfig.instance._freeClimbingOrthogonalDirectionAngle.value).floatValue() / 2.0f;
        return this.setClimbingAngles(f - f2, f + f2);
    }

    private boolean setClimbingAngles(float f, float f2) {
        if (f < 0.0f) {
            f += 360.0f;
        }
        if (f2 > 360.0f) {
            f2 -= 360.0f;
        }
        this._mimimumClimbingAngle = f;
        this._maximumClimbingAngle = f2;
        return f != f2;
    }

    private boolean isWithinAngle(float f, float f2) {
        return this.isWithinAngle(this._directionAngle, f, f2);
    }

    private boolean isRotationForClimbing(float f) {
        return this.isWithinAngle(f, this._mimimumClimbingAngle, this._maximumClimbingAngle);
    }

    private boolean isWithinAngle(float f, float f2, float f3) {
        return f2 > f3 ? f >= f2 || f <= f3 : f >= f2 && f <= f3;
    }

    private int baseVineClimbing(int n) {
        boolean bl = this.isOnVine(n);
        if (bl) {
            bl = this.isOnVineFront(n);
            if (bl) {
                return 0;
            }
            if (this.baseVineClimbing(n, PZ) || this.baseVineClimbing(n, NZ) || this.baseVineClimbing(n, ZP) || this.baseVineClimbing(n, ZN)) {
                return 1;
            }
        }
        return -1;
    }

    private boolean baseVineClimbing(int n, Orientation orientation) {
        return orientation == this ? false : orientation.rotate(180).hasVineOrientation(world, base_i, local_offset + n, base_k) && orientation.getHorizontalBorderGap() >= 0.65;
    }

    private boolean remoteLadderClimbing(int n) {
        return this.isBehindLadder(n) && this.isOnLadderBack(n);
    }

    private int remoteVineClimbing(int n) {
        return this.isBehindVine(n) && this.isOnVineBack(n) ? 0 : (!this.remoteVineClimbing(n, PZ) && !this.remoteVineClimbing(n, NZ) && !this.remoteVineClimbing(n, ZP) && !this.remoteVineClimbing(n, ZN) ? -1 : 1);
    }

    private boolean remoteVineClimbing(int n, Orientation orientation) {
        if (orientation == this) {
            return false;
        }
        int n2 = base_i - orientation._i;
        int n3 = base_k - orientation._k;
        return Orientation.isVine(Orientation.getBlockId(n2, n, n3)) && orientation.hasVineOrientation(world, n2, local_offset + n, n3) && orientation.getHorizontalBorderGap() >= (double)0.65f;
    }

    private boolean isOnLadder(int n) {
        int n2 = Orientation.getBaseBlockId(n);
        return Orientation.isLadder(n2) ? true : (Orientation.isVine(n2) ? false : Orientation.isClimbable(world, base_i, local_offset + n, base_k));
    }

    private boolean isBehindLadder(int n) {
        int n2 = Orientation.getRemoteBlockId(n);
        return Orientation.isLadder(n2) ? true : (Orientation.isVine(n2) ? false : Orientation.isClimbable(world, remote_i, local_offset + n, remote_k));
    }

    private boolean isOnVine(int n) {
        return Orientation.isVine(Orientation.getBaseBlockId(n));
    }

    private boolean isBehindVine(int n) {
        return Orientation.isVine(Orientation.getRemoteBlockId(n));
    }

    private boolean isOnLadderOrVine(int n) {
        return Orientation.isLadderOrVine(Orientation.getBaseBlockId(n)) || Orientation.isVine(grabBlockId);
    }

    public static boolean isLadder(int n) {
        return n == Block.ladder.blockID;
    }

    public static boolean isVine(int n) {
        return n == Block.vine.blockID;
    }

    public static boolean isLadderOrVine(int n) {
        return Orientation.isLadder(n) || Orientation.isVine(n) || Orientation.isBlockIdOfType(n, _ladderKitLadderTypes);
    }

    public static boolean isKnownLadder(int n) {
        return Orientation.isLadder(n) || Orientation.isBlockIdOfType(n, _ladderKitLadderTypes);
    }

    public static boolean isClimbable(World world, int n, int n2, int n3) {
        int n4 = world.getBlockId(n, n2, n3);
        return _isLadder == null ? Orientation.isLadderOrVine(n4) : n4 > 0 && (Boolean)Reflect.Invoke(_isLadder, Block.blocksList[n4], world, n, n2, n3, null) != false;
    }

    private boolean isOnLadderFront(int n) {
        return this.hasLadderOrientation(world, base_i, local_offset + n, base_k);
    }

    private boolean isOnLadderBack(int n) {
        return this.rotate(180).hasLadderOrientation(world, remote_i, local_offset + n, remote_k);
    }

    private boolean isOnVineFront(int n) {
        return this.hasVineOrientation(world, base_i, local_offset + n, base_k);
    }

    private boolean isOnVineBack(int n) {
        return this.rotate(180).hasVineOrientation(world, remote_i, local_offset + n, remote_k);
    }

    public static Orientation getKnownLadderOrientation(World world, int n, int n2, int n3) {
        int n4 = world.getBlockId(n, n2, n3);
        int n5 = world.getBlockMetadata(n, n2, n3);
        if (Orientation.isBlockIdOfType(n4, _ladderKitLadderTypes)) {
            switch (n5 & 3) {
                case 0: {
                    return ZP;
                }
                case 1: {
                    return NZ;
                }
                case 2: {
                    return ZN;
                }
                case 3: {
                    return PZ;
                }
            }
            return null;
        }
        switch (n5 & 7) {
            case 2: {
                return ZP;
            }
            case 3: {
                return ZN;
            }
            case 4: {
                return PZ;
            }
            case 5: {
                return NZ;
            }
        }
        return null;
    }

    public boolean hasVineOrientation(World world, int n, int n2, int n3) {
        int n4 = world.getBlockMetadata(n, n2, n3);
        return this == NZ ? (n4 & 2) != 0 : (this == PZ ? (n4 & 8) != 0 : (this == ZP ? (n4 & 1) != 0 : (this == ZN ? (n4 & 4) != 0 : false)));
    }

    private boolean hasLadderOrientation(World world, int n, int n2, int n3) {
        int n4 = world.getBlockId(n, n2, n3);
        int n5 = world.getBlockMetadata(n, n2, n3);
        if (Orientation.isBlockIdOfType(n4, _ladderKitLadderTypes)) {
            return this == NZ ? n5 == 1 : (this == PZ ? n5 == 3 : (this == ZP ? n5 == 0 : (this == ZN ? (n5 &= 3) == 2 : false)));
        }
        return this == NZ ? n5 == 5 : (this == PZ ? n5 == 4 : (this == ZP ? n5 == 2 : (this == ZN ? (n5 &= 7) == 3 : false)));
    }

    public boolean isRemoteSolid(World world, int n, int n2, int n3) {
        return Orientation.isSolid(world.getBlockMaterial(n + this._i, n2, n3 + this._k));
    }

    public static Orientation getOpenTrapDoorOrientation(World world, int n, int n2, int n3) {
        int n4 = world.getBlockMetadata(n, n2, n3);
        if (!Orientation.isClosedTrapDoor(n4)) {
            switch (n4 & 3) {
                case 0: {
                    return ZP;
                }
                case 1: {
                    return ZN;
                }
                case 2: {
                    return PZ;
                }
                case 3: {
                    return NZ;
                }
            }
        }
        return null;
    }

    private boolean isHeadedToRope() {
        int n = Orientation.getTriple(base_id, base_kd);
        int n2 = Orientation.getTriple(base_kd, base_id);
        return n > 0 ? (n2 > 0 ? this == NN : (n2 < 0 ? this == NP : this == NZ)) : (n < 0 ? (n2 > 0 ? this == PN : (n2 < 0 ? this == PP : this == PZ)) : (n2 > 0 ? this == ZN : (n2 < 0 ? this == ZP : this == ZZ)));
    }

    private boolean isOnAnchorFront(int n) {
        switch (Orientation.getBaseBlockMetadata(n)) {
            case 0: {
                return false;
            }
            case 1: {
                return false;
            }
            case 2: {
                return this._k == 1;
            }
            case 3: {
                return this._k == -1;
            }
            case 4: {
                return this._i == 1;
            }
            case 5: {
                return this._i == -1;
            }
        }
        return false;
    }

    private int getRopeId(int n) {
        int n2 = Orientation.getBaseBlockId(n);
        return Orientation.isRopeId(n2) ? n2 : -1;
    }

    private boolean isRope(int n) {
        return this.getRopeId(n) >= 0;
    }

    private static boolean isRopeId(int n) {
        return SmartMovingAnticheatConfig.hasBetterThanWolves && Orientation.hasBlockName(n, "tile.fcRopeBlock") || SmartMovingAnticheatConfig.hasRopesPlus && Orientation.hasBlockName(n, "tile.blockRopeCentral");
    }

    private int getAnchorId(int n) {
        int n2 = Orientation.getBaseBlockId(n);
        return Orientation.isAnchorId(n2) ? n2 : -1;
    }

    private static boolean isAnchorId(int n) {
        return Orientation.hasBlockName(n, "tile.fcAnchor");
    }

    private boolean isOnWallRope(int n) {
        return (SmartMovingAnticheatConfig.hasASGrapplingHook || SmartMovingAnticheatConfig.hasRopesPlus) && Orientation.isASRope(Orientation.getBaseBlockId(n));
    }

    private static boolean isASRope(int n) {
        return Orientation.hasBlockName(n, "tile.blockRope");
    }

    private static boolean isASGrapplingHook(int n) {
        return Orientation.hasBlockName(n, "tile.blockGrHk");
    }

    private boolean isASGrapplingHookFront(int n) {
        boolean bl;
        boolean bl2 = n % 2 != 0;
        boolean bl3 = n / 2 % 2 != 0;
        boolean bl4 = n / 4 % 2 != 0;
        boolean bl5 = bl = n / 8 % 2 != 0;
        return !(this._i > 0 && bl || this._i < 0 && bl3) ? (!(this._k > 0 && bl2 || this._k < 0 && bl4) ? false : (this._i > 0 ? bl : (this._i < 0 ? bl3 : true))) : (this._k > 0 ? bl2 : (this._k < 0 ? bl4 : true));
    }

    private boolean isOnOpenTrapDoor(int n) {
        return Orientation.isTrapDoor(Orientation.getBaseBlockId(n)) && !Orientation.isClosedTrapDoor(Orientation.getBaseBlockMetadata(n));
    }

    private boolean isTrapDoorFront(int n) {
        return this == NZ ? (n & 3) == 3 : (this == PZ ? (n & 3) == 2 : (this == ZP ? (n & 3) == 0 : (this == ZN ? (n & 3) == 1 : (this == PN ? (n & 3) == 2 || (n & 3) == 1 : (this == PP ? (n & 3) == 2 || (n & 3) == 0 : (this == NN ? (n & 3) == 3 || (n & 3) == 1 : (this != NP ? false : (n & 3) == 3 || (n & 3) == 0)))))));
    }

    private boolean isBottomStairCompactNotBack(int n) {
        return !Orientation.isTopStairCompact(n) && !this.isStairCompactBack(n);
    }

    private boolean isBottomStairCompactFront(int n) {
        return !Orientation.isTopStairCompact(n) && this.isStairCompactFront(n);
    }

    private boolean isTopStairCompactFront(int n) {
        return Orientation.isTopStairCompact(n) && this.isStairCompactFront(n);
    }

    private boolean isTopStairCompactBack(int n) {
        return Orientation.isTopStairCompact(n) && this.isStairCompactBack(n);
    }

    private boolean isStairCompactFront(int n) {
        return this == NZ ? n == 1 : (this == PZ ? n == 0 : (this == ZP ? n == 2 : (this == ZN ? n == 3 : (this == PN ? n == 0 || n == 3 : (this == PP ? n == 0 || n == 2 : (this == NN ? n == 1 || n == 3 : (this != NP ? false : (n &= 3) == 1 || n == 2)))))));
    }

    private boolean isStairCompactBack(int n) {
        return this == NZ ? n == 0 : (this == PZ ? n == 1 : (this == ZP ? n == 3 : (this == ZN ? n == 2 : (this == PN ? n == 1 || n == 2 : (this == PP ? n == 1 || n == 3 : (this == NN ? n == 0 || n == 2 : (this != NP ? false : (n &= 3) == 0 || n == 3)))))));
    }

    private static boolean isTopStairCompact(int n) {
        return (n & 4) != 0;
    }

    private static boolean isRedPowerWireTop(int n) {
        return (n >> 1) % 2 == 1;
    }

    private static boolean isRedPowerWireBottom(int n) {
        return (n >> 0) % 2 == 1;
    }

    private boolean isRedPowerWireFullFront(int n) {
        return this == NZ ? (n >> 5) % 2 == 1 : (this == PZ ? (n >> 4) % 2 == 1 : (this == ZP ? (n >> 2) % 2 == 1 : (this == ZN ? (n >> 3) % 2 == 1 : (this == PN ? PZ.isRedPowerWireFullFront(n) && ZN.isRedPowerWireFullFront(n) : (this == PP ? PZ.isRedPowerWireFullFront(n) && ZP.isRedPowerWireFullFront(n) : (this == NN ? NZ.isRedPowerWireFullFront(n) && ZN.isRedPowerWireFullFront(n) : (this != NP ? false : NZ.isRedPowerWireFullFront(n) && ZP.isRedPowerWireFullFront(n))))))));
    }

    private boolean isRedPowerWireAnyFront(int n) {
        return this == NZ ? (n >> 5) % 2 == 1 : (this == PZ ? (n >> 4) % 2 == 1 : (this == ZP ? (n >> 2) % 2 == 1 : (this == ZN ? (n >> 3) % 2 == 1 : (this == PN ? PZ.isRedPowerWireFullFront(n) || ZN.isRedPowerWireFullFront(n) : (this == PP ? PZ.isRedPowerWireFullFront(n) || ZP.isRedPowerWireFullFront(n) : (this == NN ? NZ.isRedPowerWireFullFront(n) || ZN.isRedPowerWireFullFront(n) : (this != NP ? false : NZ.isRedPowerWireFullFront(n) || ZP.isRedPowerWireFullFront(n))))))));
    }

    private boolean isRedPowerWireFullBack(int n) {
        return this == NZ ? (n >> 4) % 2 == 1 : (this == PZ ? (n >> 5) % 2 == 1 : (this == ZP ? (n >> 3) % 2 == 1 : (this == ZN ? (n >> 2) % 2 == 1 : (this == PN ? PZ.isRedPowerWireFullBack(n) && ZN.isRedPowerWireFullBack(n) : (this == PP ? PZ.isRedPowerWireFullBack(n) && ZP.isRedPowerWireFullBack(n) : (this == NN ? NZ.isRedPowerWireFullBack(n) && ZN.isRedPowerWireFullBack(n) : (this != NP ? false : NZ.isRedPowerWireFullBack(n) && ZP.isRedPowerWireFullBack(n))))))));
    }

    private boolean isRedPowerWireAnyBack(int n) {
        return this == NZ ? (n >> 4) % 2 == 1 : (this == PZ ? (n >> 5) % 2 == 1 : (this == ZP ? (n >> 3) % 2 == 1 : (this == ZN ? (n >> 2) % 2 == 1 : (this == PN ? PZ.isRedPowerWireFullBack(n) || ZN.isRedPowerWireFullBack(n) : (this == PP ? PZ.isRedPowerWireFullBack(n) || ZP.isRedPowerWireFullBack(n) : (this == NN ? NZ.isRedPowerWireFullBack(n) || ZN.isRedPowerWireFullBack(n) : (this != NP ? false : NZ.isRedPowerWireFullBack(n) || ZP.isRedPowerWireFullBack(n))))))));
    }

    private boolean isFenceGateFront(int n) {
        int n2 = n % 4;
        return this == NZ ? n2 == 0 || n2 == 2 : (this == PZ ? n2 == 0 || n2 == 2 : (this == ZP ? n2 == 1 || n2 == 3 : (this != ZN ? false : n2 == 1 || n2 == 3)));
    }

    private boolean headedToFrontWall(int n, int n2, int n3, int n4) {
        Block block = Block.blocksList[n4];
        boolean bl = this.getWallFlag(ZN, n, n2, n3, block);
        boolean bl2 = this.getWallFlag(ZP, n, n2, n3, block);
        boolean bl3 = this.getWallFlag(NZ, n, n2, n3, block);
        boolean bl4 = this.getWallFlag(PZ, n, n2, n3, block);
        boolean bl5 = this.getAllWallsOnNoWall(block);
        if (!(!bl5 || bl || bl2 || bl3 || bl4)) {
            bl4 = true;
            bl3 = true;
            bl2 = true;
            bl = true;
        }
        return this.headedToWall(NZ, bl4) || this.headedToWall(PZ, bl3) || this.headedToWall(ZN, bl2) || this.headedToWall(ZP, bl);
    }

    private boolean headedToFrontSideWall(int n, int n2, int n3, int n4) {
        Block block = Block.blocksList[n4];
        boolean bl = this.getWallFlag(ZN, n, n2, n3, block);
        boolean bl2 = this.getWallFlag(ZP, n, n2, n3, block);
        boolean bl3 = this.getWallFlag(NZ, n, n2, n3, block);
        boolean bl4 = this.getWallFlag(PZ, n, n2, n3, block);
        boolean bl5 = this.getAllWallsOnNoWall(block);
        if (!(!bl5 || bl || bl2 || bl3 || bl4)) {
            bl4 = true;
            bl3 = true;
            bl2 = true;
            bl = true;
        }
        boolean bl6 = Orientation.isTopHalf(base_id);
        boolean bl7 = Orientation.isTopHalf(base_kd);
        return bl6 ? (bl7 ? this.headedToWall(NZ, bl2) || this.headedToWall(PZ, bl2) || this.headedToWall(ZN, bl4) || this.headedToWall(ZP, bl4) : this.headedToWall(NZ, bl) || this.headedToWall(PZ, bl) || this.headedToWall(ZN, bl4) || this.headedToWall(ZP, bl4)) : (bl7 ? this.headedToWall(NZ, bl2) || this.headedToWall(PZ, bl2) || this.headedToWall(ZN, bl3) || this.headedToWall(ZP, bl3) : this.headedToWall(NZ, bl) || this.headedToWall(PZ, bl) || this.headedToWall(ZN, bl3) || this.headedToWall(ZP, bl3));
    }

    private boolean headedToWall(Orientation orientation, boolean bl) {
        return this != orientation && this != orientation.rotate(45) && this != orientation.rotate(-45) ? false : bl;
    }

    private boolean headedToBaseWall(int n, int n2) {
        Block block = Block.blocksList[n2];
        boolean bl = this.getWallFlag(ZN, base_i, n, base_k, block);
        boolean bl2 = this.getWallFlag(ZP, base_i, n, base_k, block);
        boolean bl3 = this.getWallFlag(NZ, base_i, n, base_k, block);
        boolean bl4 = this.getWallFlag(PZ, base_i, n, base_k, block);
        boolean bl5 = this.getAllWallsOnNoWall(block);
        if (!(!bl5 || bl || bl2 || bl3 || bl4)) {
            bl4 = true;
            bl3 = true;
            bl2 = true;
            bl = true;
        }
        boolean bl6 = bl || bl2 || bl3 || bl4;
        boolean bl7 = !bl5 && !bl6;
        boolean bl8 = Orientation.isTopHalf(base_id);
        boolean bl9 = Orientation.isTopHalf(base_kd);
        return bl8 ? (bl9 ? this.headedToBaseWall(NN, NZ, ZN, bl2, bl3, bl4, bl, bl7, bl6) : this.headedToBaseWall(NP, NZ, ZP, bl, bl3, bl4, bl2, bl7, bl6)) : (bl9 ? this.headedToBaseWall(PN, PZ, ZN, bl2, bl4, bl3, bl, bl7, bl6) : this.headedToBaseWall(PP, PZ, ZP, bl, bl4, bl3, bl2, bl7, bl6));
    }

    private boolean headedToBaseWall(Orientation orientation, Orientation orientation2, Orientation orientation3, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        return this != orientation ? (this == orientation2 ? this.headedToBaseWall(bl, bl2, bl3, bl4, bl5) : (this == orientation3 ? this.headedToBaseWall(bl3, bl4, bl, bl2, bl5) : false)) : bl6 || bl5;
    }

    private boolean headedToBaseWall(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        return bl || bl2 && !bl3 || bl4 && !bl && !bl3 || bl5;
    }

    private boolean headedToBaseGrabWall(int n, int n2) {
        boolean bl;
        boolean bl2;
        boolean bl3;
        boolean bl4;
        boolean bl5;
        int n3;
        Block block = Block.blocksList[n2];
        boolean bl6 = this.getWallFlag(ZN, base_i, n, base_k, block);
        boolean bl7 = this.getWallFlag(ZP, base_i, n, base_k, block);
        boolean bl8 = this.getWallFlag(NZ, base_i, n, base_k, block);
        boolean bl9 = this.getWallFlag(PZ, base_i, n, base_k, block);
        boolean bl10 = this.getAllWallsOnNoWall(block);
        if (!(!bl10 || bl6 || bl7 || bl8 || bl9)) {
            bl9 = true;
            bl8 = true;
            bl7 = true;
            bl6 = true;
        }
        if (Orientation.isFullEmpty(n3 = Orientation.getBlockId(base_i, n + 1, base_k))) {
            bl5 = false;
            bl4 = false;
            bl3 = false;
            bl2 = false;
        } else if (Orientation.isWallBlock(n3, base_i, n + 1, base_k)) {
            Block block2 = Block.blocksList[n3];
            bl2 = this.getWallFlag(ZN, base_i, n + 1, base_k, block2);
            bl3 = this.getWallFlag(ZP, base_i, n + 1, base_k, block2);
            bl4 = this.getWallFlag(NZ, base_i, n + 1, base_k, block2);
            bl5 = this.getWallFlag(PZ, base_i, n + 1, base_k, block2);
            bl = this.getAllWallsOnNoWall(block2);
            if (!(!bl || bl2 || bl3 || bl4 || bl5)) {
                bl5 = true;
                bl4 = true;
                bl3 = true;
                bl2 = true;
            }
        } else {
            bl5 = true;
            bl4 = true;
            bl3 = true;
            bl2 = true;
        }
        boolean bl11 = Orientation.isTopHalf(base_id);
        bl = Orientation.isTopHalf(base_kd);
        return bl11 ? (bl ? this.headedToBaseGrabWall(-this._i, -this._k, bl7, bl9, bl8, bl6, bl3, bl5, bl4, bl2) : this.headedToBaseGrabWall(-this._i, this._k, bl9, bl6, bl7, bl8, bl5, bl2, bl3, bl4)) : (bl ? this.headedToBaseGrabWall(this._i, -this._k, bl8, bl7, bl6, bl9, bl4, bl3, bl2, bl5) : this.headedToBaseGrabWall(this._i, this._k, bl6, bl8, bl9, bl7, bl2, bl4, bl5, bl3));
    }

    private boolean headedToBaseGrabWall(int n, int n2, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        return bl4 && !bl8 && !bl && !bl5 && n == 1 ? true : (bl3 && !bl7 && !bl2 && !bl6 && n2 == 1 ? true : (bl2 && !bl6 && n2 >= 0 ? true : (bl && !bl5 && n2 >= 0 ? true : (bl3 && !bl7 && !bl5 && n == 1 && n2 >= 0 ? true : bl4 && !bl8 && !bl6 && n2 == 1 && n >= 0))));
    }

    private boolean headedToRemoteFlatWall(int n, int n2) {
        Block block = Block.blocksList[n];
        return !this.getWallFlag(this, remote_i, n2, remote_k, block) && this.getWallFlag(this.rotate(90), remote_i, n2, remote_k, block) && !this.getWallFlag(this.rotate(180), remote_i, n2, remote_k, block) && this.getWallFlag(this.rotate(-90), remote_i, n2, remote_k, block);
    }

    private boolean getWallFlag(Orientation orientation, int n, int n2, int n3, Block block) {
        if (block instanceof zxyg) {
            return ((zxyg)block)._a(Orientation.getBlockId(n + orientation._i, n2, n3 + orientation._k));
        }
        if (Orientation.isFenceBase(block.blockID)) {
            if (block instanceof BlockFence) {
                return ((BlockFence)block)._a(world, n + orientation._i, local_offset + n2, n3 + orientation._k);
            }
            if (block instanceof BlockWall) {
                return ((BlockWall)block)._a(world, n + orientation._i, local_offset + n2, n3 + orientation._k);
            }
            if (SmartMovingAnticheatConfig.hasBetterMisc && _canConnectFenceTo != null) {
                return (Boolean)Reflect.Invoke(_canConnectFenceTo, block, world, n + orientation._i, local_offset + n2, n3 + orientation._k);
            }
        } else if (Orientation.isFenceGate(block.blockID)) {
            int n4 = Orientation.getBlockMetadata(n, n2, n3);
            return Orientation.isClosedFenceGate(n4) && this.isFenceGateFront(n4);
        }
        return false;
    }

    private boolean getAllWallsOnNoWall(Block block) {
        return block instanceof zxyg;
    }

    private static boolean isTopHalf(double d) {
        return (int)Math.abs(Math.floor(d * 2.0)) % 2 == 1;
    }

    private static int getTriple(double d, double d2) {
        d = d - Math.floor(d) - 0.5;
        d2 = d2 - Math.floor(d2) - 0.5;
        return Math.abs(d) * 2.0 < Math.abs(d2) ? 0 : (d > 0.0 ? 1 : (d < 0.0 ? -1 : 0));
    }

    private static boolean isBottomHalfBlock(int n, int n2) {
        return Orientation.isHalfBlock(n) && Orientation.isHalfBlockBottomMetaData(n2) ? true : (n == Block.bed.blockID ? true : SmartMovingAnticheatConfig.hasBetterThanWolves && Orientation.isAnchorId(n) && n2 == 1);
    }

    private static boolean isTopHalfBlock(int n, int n2) {
        return Orientation.isHalfBlock(n) && Orientation.isHalfBlockTopMetaData(n2);
    }

    private static boolean isHalfBlockBottomMetaData(int n) {
        return (n & 8) == 0;
    }

    private static boolean isHalfBlockTopMetaData(int n) {
        return (n & 8) != 0;
    }

    private static boolean isHalfBlock(int n) {
        return Orientation.isBlock(n, BlockHalfSlab.class, _knownHalfBlocks) && !((BlockHalfSlab)Block.blocksList[n]).isOpaqueCube();
    }

    private static boolean isStairCompact(int n) {
        return Orientation.isBlock(n, yuxu.class, _knownCompactStairBlocks);
    }

    private boolean isLowerHalfFrontFullEmpty(int n, int n2, int n3) {
        int n4;
        int n5 = Orientation.getBlockId(n, n2, n3);
        boolean bl = Orientation.isFullEmpty(n5);
        if (!bl && SmartMovingAnticheatConfig.hasRedPowerWire && Orientation.isRedPowerWire(n5) && !this.isRedPowerWireAnyFront(n4 = Orientation.getRpCoverSides(n, n2, n3))) {
            bl = true;
        }
        if (!bl && SmartMovingAnticheatConfig.hasBetterThanWolves && Orientation.isAnchorId(n5)) {
            boolean bl2 = bl = Orientation.getBlockMetadata(n, n2, n3) == 0;
        }
        if (!bl && Orientation.isStairCompact(n5) && this.isTopStairCompactFront(Orientation.getBlockMetadata(n, n2, n3))) {
            bl = true;
        }
        if (!bl && Orientation.isHalfBlock(n5) && Orientation.isHalfBlockTopMetaData(Orientation.getBlockMetadata(n, n2, n3))) {
            bl = true;
        }
        if (!bl && Orientation.isWallBlock(n5, n, n2, n3) && !this.headedToFrontWall(n, n2, n3, n5)) {
            bl = true;
        }
        if (!bl && Orientation.isDoor(n5) && !this.rotate(180).isDoorFrontBlocked(n, n2, n3)) {
            bl = true;
        }
        if (!bl && (SmartMovingAnticheatConfig.hasASGrapplingHook || SmartMovingAnticheatConfig.hasRopesPlus) && Orientation.isASRope(n5) && !this.rotate(180).isASGrapplingHookFront(Orientation.getRemoteBlockMetadata(n2))) {
            bl = true;
        }
        if (bl && Orientation.isBlockIdOfType(n5, _ladderKitLadderTypes) && this.rotate(180).hasLadderOrientation(world, n, local_offset + n2, n3)) {
            bl = false;
        }
        return bl;
    }

    private boolean isUpperHalfFrontAnySolid(int n, int n2, int n3) {
        int n4 = Orientation.getBlockId(n, n2, n3);
        boolean bl = this.isUpperHalfFrontFullSolid(n, n2, n3);
        if (bl && Orientation.isWallBlock(n4, n, n2, n3) && !this.headedToFrontWall(n, n2, n3, n4)) {
            bl = false;
        }
        return bl;
    }

    private boolean isUpperHalfFrontFullSolid(int n, int n2, int n3) {
        int n4 = Orientation.getBlockId(n, n2, n3);
        if (n4 <= 0) {
            return false;
        }
        Block block = Block.blocksList[n4];
        boolean bl = Orientation.isSolid(block.blockMaterial);
        if (bl && n4 == Block.signPost.blockID) {
            bl = false;
        }
        if (bl && n4 == Block.signWall.blockID) {
            bl = false;
        }
        if (bl && block instanceof jiju) {
            bl = false;
        }
        if (bl && Orientation.isTrapDoor(n4)) {
            bl = false;
        }
        if (bl && SmartMovingAnticheatConfig.hasASGrapplingHook && Orientation.isASGrapplingHook(n4)) {
            bl = false;
        }
        if (bl && this.isOpenFenceGate(n4, Orientation.getBlockMetadata(n, n2, n3))) {
            bl = false;
        }
        return bl;
    }

    private static boolean isFullEmpty(int n) {
        boolean bl;
        if (n <= 0) {
            return true;
        }
        Block block = Block.blocksList[n];
        boolean bl2 = bl = !Orientation.isSolid(block.blockMaterial);
        if (!bl && n == Block.signPost.blockID) {
            bl = true;
        }
        if (!bl && n == Block.signWall.blockID) {
            bl = true;
        }
        if (!bl && block instanceof jiju) {
            bl = true;
        }
        if (!bl && (SmartMovingAnticheatConfig.hasASGrapplingHook || SmartMovingAnticheatConfig.hasRopesPlus) && Orientation.isASGrapplingHook(n)) {
            bl = true;
        }
        if (bl && (SmartMovingAnticheatConfig.hasASGrapplingHook || SmartMovingAnticheatConfig.hasRopesPlus) && Orientation.isASRope(n)) {
            bl = false;
        }
        return bl;
    }

    private static boolean isFenceBase(int n) {
        return Orientation.isBlock(n, BlockFence.class, _knownFenceBlocks) || Orientation.isBlock(n, BlockWall.class, _knownWallBlocks);
    }

    private static boolean isFence(int n, int n2, int n3, int n4) {
        return Orientation.isFenceBase(n) || Orientation.isClosedFenceGate(n, Orientation.getBlockMetadata(n2, n3, n4));
    }

    private boolean isFence(int n, int n2, int n3) {
        return this.getFenceId(n, n2, n3) != -1;
    }

    private int getFenceId(int n, int n2, int n3) {
        int n4 = Orientation.getBlockId(n, n2, n3);
        return !Orientation.isFenceBase(n4) && !Orientation.isClosedFenceGate(n4, Orientation.getBlockMetadata(n, n2, n3)) ? -1 : n4;
    }

    private static boolean isClosedFenceGate(int n, int n2) {
        return Orientation.isFenceGate(n) && Orientation.isClosedFenceGate(n2);
    }

    private static boolean isFenceGate(int n) {
        return Orientation.isBlock(n, BlockFenceGate.class, _knownFanceGateBlocks);
    }

    private boolean isOpenFenceGate(int n, int n2) {
        return Orientation.isFenceGate(n) && !Orientation.isClosedFenceGate(n2);
    }

    private static boolean isClosedFenceGate(int n) {
        return (n & 4) == 0;
    }

    private boolean isOpenTrapDoor(int n, int n2, int n3) {
        return Orientation.isTrapDoor(n, n2, n3) && !Orientation.isClosedTrapDoor(Orientation.getBlockMetadata(n, n2, n3));
    }

    private static boolean isClosedTrapDoor(int n, int n2, int n3) {
        return Orientation.isTrapDoor(n, n2, n3) && Orientation.isClosedTrapDoor(Orientation.getBlockMetadata(n, n2, n3));
    }

    private static boolean isTrapDoor(int n, int n2, int n3) {
        return Orientation.isTrapDoor(Orientation.getBlockId(n, n2, n3));
    }

    public static boolean isTrapDoor(int n) {
        return Orientation.isBlock(n, matg.class, _knownTrapDoorBlocks);
    }

    private static boolean isBlock(int n, Class clazz, Block[] blockArray) {
        if (n < 1) {
            return false;
        }
        if (clazz != null && blockArray.length > 1 && Orientation.isBlockType(n, clazz)) {
            return true;
        }
        for (int i = 0; i < blockArray.length; ++i) {
            if (blockArray[i] == null || n != blockArray[i].blockID) continue;
            return true;
        }
        if (clazz != null && Orientation.isBlockType(n, clazz)) {
            return true;
        }
        Block block = Block.blocksList[n];
        if (block == null) {
            return false;
        }
        Class<?> clazz2 = block.getClass();
        for (int i = 0; i < blockArray.length; ++i) {
            if (blockArray[i] == null || !blockArray[i].getClass().isAssignableFrom(clazz2)) continue;
            return true;
        }
        return false;
    }

    private static boolean isBlockType(int n, Class clazz) {
        Block block = Block.blocksList[n];
        return block != null && clazz.isAssignableFrom(block.getClass());
    }

    public static boolean isClosedTrapDoor(int n) {
        return (n & 4) == 0;
    }

    private static boolean isDoor(int n) {
        return n == Block.doorWood.blockID || n == Block.doorIron.blockID;
    }

    private static boolean isDoorTop(int n) {
        return n == 8;
    }

    private boolean isDoorFrontBlocked(int n, int n2, int n3) {
        int n4 = Orientation.getBlockMetadata(n, n2, n3);
        switch (n4) {
            case 0: 
            case 7: {
                return this._i < 0;
            }
            case 1: 
            case 4: {
                return this._k < 0;
            }
            case 2: 
            case 5: {
                return this._i > 0;
            }
            case 3: 
            case 6: {
                return this._k > 0;
            }
            case 8: {
                return this.isDoorFrontBlocked(n, n2 - 1, n3);
            }
        }
        return true;
    }

    private static int getWallBlockId(int n, int n2, int n3) {
        int n4 = Orientation.getBlockId(n, n2, n3);
        return Orientation.isWallBlock(n4, n, n2, n3) ? n4 : -1;
    }

    private static boolean isWallBlock(int n, int n2, int n3, int n4) {
        return Orientation.isBlock(n, zxyg.class, _knownThinWallBlocks) || Orientation.isFence(n, n2, n3, n4);
    }

    private boolean isBaseAccessible(int n) {
        return this.isBaseAccessible(n, false, false);
    }

    private boolean isBaseAccessible(int n, boolean bl, boolean bl2) {
        int n2 = Orientation.getBaseBlockId(n);
        boolean bl3 = this.isEmpty(base_i, n, base_k);
        if (SmartMovingAnticheatConfig.hasRedPowerWire && !bl3 && Orientation.isRedPowerWire(n2)) {
            int n3 = Orientation.getRpCoverSides(base_i, n, base_k);
            bl3 = !Orientation.isRedPowerWireBottom(n3);
            int n4 = Orientation.getBaseBlockId(n - 1);
            if (Orientation.isRedPowerWire(n4)) {
                int n5 = Orientation.getRpCoverSides(base_i, n - 1, base_k);
                bl3 &= !Orientation.isRedPowerWireTop(n5);
            }
        }
        if (!bl3 && Orientation.isFullEmpty(n2)) {
            bl3 = true;
        }
        if (!bl3 && this.isOpenTrapDoor(base_i, n, base_k)) {
            bl3 = true;
        }
        if (!bl3 && bl && Orientation.isClosedTrapDoor(base_i, n, base_k)) {
            bl3 = true;
        }
        if (!bl3 && !bl2 && Orientation.isWallBlock(n2, base_i, n, base_k)) {
            bl3 = true;
        }
        if (!bl3 && !bl2 && (SmartMovingAnticheatConfig.hasASGrapplingHook || SmartMovingAnticheatConfig.hasRopesPlus) && Orientation.isASRope(n2)) {
            bl3 = true;
        }
        if (!bl3 && Orientation.isDoor(n2)) {
            bl3 = true;
        }
        return bl3;
    }

    private boolean isRemoteAccessible(int n) {
        int n2;
        int n3;
        boolean bl = this.isEmpty(remote_i, n, remote_k);
        if (SmartMovingAnticheatConfig.hasRedPowerWire && !bl && Orientation.isRedPowerWire(n3 = Orientation.getRemoteBlockId(n))) {
            n2 = Orientation.getRpCoverSides(remote_i, n, remote_k);
            bl = !this.isRedPowerWireAnyFront(n2);
            int n4 = Orientation.getBaseBlockId(n);
            if (Orientation.isRedPowerWire(n4)) {
                int n5 = Orientation.getRpCoverSides(base_i, n, base_k);
                bl &= !this.isRedPowerWireAnyBack(n5);
            }
        }
        if (bl) {
            n3 = Orientation.getBaseBlockId(n);
            if (Orientation.isTrapDoor(n3)) {
                boolean bl2 = bl = !this.isTrapDoorFront(Orientation.getBlockMetadata(base_i, n, base_k));
            }
            if (bl && Orientation.isDoor(n3)) {
                boolean bl3 = bl = !this.isDoorFrontBlocked(base_i, n, base_k);
            }
            if (this.remoteLadderClimbing(n)) {
                bl = false;
            }
        }
        if (!bl && Orientation.isTrapDoor(remote_i, n, remote_k)) {
            bl = Orientation.isClosedTrapDoor(Orientation.getRemoteBlockMetadata(n));
        }
        if (!bl) {
            n3 = Orientation.getRemoteBlockId(n);
            if (Orientation.isWallBlock(n3, remote_i, n, remote_k) && !this.headedToFrontWall(remote_i, n, remote_k, n3) && !this.isFence(remote_i, n - 1, remote_k)) {
                bl = true;
            }
            n2 = Orientation.getRemoteBlockId(n - 1);
            if (!(bl || !Orientation.isFence(n2, remote_i, n - 1, remote_k) || this.headedToFrontWall(remote_i, n - 1, remote_k, n2) && !Orientation.isWallBlock(Orientation.getBaseBlockId(n - 1), base_i, n - 1, base_k) || n2 == Block.cobblestoneWall.blockID && !this.headedToRemoteFlatWall(n2, -1))) {
                bl = true;
            }
            if (!bl && Orientation.isDoor(n3) && !this.rotate(180).isDoorFrontBlocked(remote_i, n, remote_k)) {
                bl = true;
            }
            if ((SmartMovingAnticheatConfig.hasASGrapplingHook || SmartMovingAnticheatConfig.hasRopesPlus) && Orientation.isASRope(n3) && !this.rotate(180).isASGrapplingHookFront(Orientation.getRemoteBlockMetadata(n))) {
                bl = true;
            }
        }
        return bl;
    }

    private boolean isAccessAccessible(int n) {
        return !this._isDiagonal ? true : this.isEmpty(remote_i, n, base_k) && this.isEmpty(base_i, n, remote_k);
    }

    private boolean isFullExtentAccessible(int n, boolean bl) {
        boolean bl2 = this.isFullAccessible(n, bl);
        if (SmartMovingAnticheatConfig.hasRedPowerWire && bl2) {
            int n2;
            int n3;
            int n4 = Orientation.getRemoteBlockId(n);
            if (Orientation.isRedPowerWire(n4) && Orientation.isRedPowerWireBottom(n3 = Orientation.getRpCoverSides(remote_i, n, remote_k))) {
                bl2 = false;
            }
            if (Orientation.isRedPowerWire(n3 = Orientation.getRemoteBlockId(n - 1)) && Orientation.isRedPowerWireTop(n2 = Orientation.getRpCoverSides(remote_i, n - 1, remote_k))) {
                bl2 = false;
            }
        }
        return bl2;
    }

    private boolean isJustLowerHalfExtentAccessible(int n) {
        int n2 = Orientation.getRemoteBlockId(n);
        int n3 = Orientation.getRemoteBlockMetadata(n);
        boolean bl = false;
        if (!bl) {
            bl = Orientation.isTopHalfBlock(n2, n3);
        }
        if (!bl) {
            bl = Orientation.isStairCompact(n2) && this.isTopStairCompactFront(n3);
        }
        return bl;
    }

    private boolean isFullAccessible(int n, boolean bl) {
        return !bl ? this.isEmpty(base_i, n, base_k) : this.isBaseAccessible(n) && this.isRemoteAccessible(n) && this.isAccessAccessible(n);
    }

    private boolean isEmpty(int n, int n2, int n3) {
        return Orientation.isFullEmpty(Orientation.getBlockId(n, n2, n3)) && !this.isFence(n, n2 - 1, n3);
    }

    private boolean isUpperHalfFrontEmpty(int n, int n2, int n3) {
        int n4;
        int n5 = Orientation.getBlockId(n, n2, n3);
        boolean bl = Orientation.isFullEmpty(n5);
        if (!bl) {
            n4 = Orientation.getBlockMetadata(n, n2, n3);
            if (Orientation.isBottomHalfBlock(n5, n4)) {
                bl = true;
            }
            if (!bl && Orientation.isStairCompact(n5) && this.isBottomStairCompactFront(n4)) {
                bl = true;
            }
        }
        if (SmartMovingAnticheatConfig.hasRedPowerWire && !bl && Orientation.isRedPowerWire(n5) && !this.isRedPowerWireAnyFront(n4 = Orientation.getRpCoverSides(n, n2, n3))) {
            bl = true;
        }
        if (!bl && Orientation.isTrapDoor(n5)) {
            bl = true;
        }
        if (!(bl || (n4 = Orientation.getWallBlockId(n, n2, n3)) <= 0 || this.headedToFrontWall(n, n2, n3, n4) && !Orientation.isWallBlock(Orientation.getBlockId(n - this._i, n2, n3 - this._k), n - this._i, n2, n3 - this._k))) {
            bl = true;
        }
        if (bl && Orientation.isBlockIdOfType(n5, _ladderKitLadderTypes) && this.rotate(180).hasLadderOrientation(world, n, local_offset + n2, n3)) {
            bl = false;
        }
        return bl;
    }

    private static int getRpCoverSides(int n, int n2, int n3) {
        TileEntity tileEntity = Orientation.getBlockTileEntity(n, n2, n3);
        Class<?> clazz = tileEntity.getClass();
        while (!clazz.getSimpleName().equals("TileCovered")) {
            clazz = clazz.getSuperclass();
        }
        return (Integer)Reflect.GetField(clazz, tileEntity, new Name("CoverSides"));
    }

    private static boolean isRedPowerWire(int n) {
        return Orientation.hasBlockName(n, "tile.rpwire");
    }

    public static int getFiniteLiquidWater(int n) {
        String string = Orientation.getBlockName(n);
        return string == null ? 0 : (string.equals("tile.nocean") ? 2 : (string.equals("tile.nwater_still") ? 1 : 0));
    }

    private static boolean isSolid(Material material) {
        return material._a() && material._c();
    }

    private static int getBlockId(int n, int n2, int n3) {
        return world.getBlockId(n, local_offset + n2, n3);
    }

    private static int getBlockMetadata(int n, int n2, int n3) {
        return world.getBlockMetadata(n, local_offset + n2, n3);
    }

    private static TileEntity getBlockTileEntity(int n, int n2, int n3) {
        return world.getBlockTileEntity(n, local_offset + n2, n3);
    }

    private static int getBaseBlockId(int n) {
        return world.getBlockId(base_i, local_offset + n, base_k);
    }

    private static int getBaseBlockMetadata(int n) {
        return world.getBlockMetadata(base_i, local_offset + n, base_k);
    }

    private static boolean isBaseBlockOfType(int n, Class ... classArray) {
        return Orientation.isBlockIdOfType(Orientation.getBaseBlockId(n), classArray);
    }

    private static boolean isRemoteBlockOfType(int n, Class ... classArray) {
        return Orientation.isBlockIdOfType(Orientation.getRemoteBlockId(n), classArray);
    }

    private static boolean isBlockIdOfType(int n, Class ... classArray) {
        if (classArray == null) {
            return false;
        }
        if (n <= 0) {
            return false;
        }
        Block block = Block.blocksList[n];
        if (block == null) {
            return false;
        }
        Class<?> clazz = block.getClass();
        Class[] classArray2 = classArray;
        int n2 = classArray.length;
        for (int i = 0; i < n2; ++i) {
            Class clazz2 = classArray2[i];
            if (!clazz2.isAssignableFrom(clazz)) continue;
            return true;
        }
        return false;
    }

    private static int getRemoteBlockId(int n) {
        return world.getBlockId(remote_i, local_offset + n, remote_k);
    }

    private static int getRemoteBlockMetadata(int n) {
        return world.getBlockMetadata(remote_i, local_offset + n, remote_k);
    }

    private static boolean hasBlockName(int n, String string) {
        String string2 = Orientation.getBlockName(n);
        return string2 != null && string2.equals(string);
    }

    private static String getBlockName(int n) {
        return n <= 0 ? null : Block.blocksList[n].getUnlocalizedName();
    }

    private void initialize(World world, int n, double d, double d2, int n2, double d3) {
        Orientation.world = world;
        base_i = n;
        base_id = d;
        base_jhd = d2;
        base_k = n2;
        base_kd = d3;
        remote_i = n + this._i;
        remote_k = n2 + this._k;
    }

    private static void initializeOffset(double d, boolean bl, boolean bl2, boolean bl3) {
        crawl = bl || bl2 || bl3;
        double d2 = base_jhd + d;
        int n = sajh._c(d2);
        jh_offset = d2 - (double)n;
        all_j = n / 2;
        all_offset = n % 2;
    }

    private static void initializeLocal(int n) {
        local_halfOffset = n + all_offset;
        local_half = Math.abs(local_halfOffset) % 2;
        local_offset = all_j + (local_halfOffset - local_half) / 2;
    }

    public String toString() {
        return this == ZZ ? "ZZ" : (this == NZ ? "NZ" : (this == PZ ? "PZ" : (this == ZP ? "ZP" : (this == ZN ? "ZN" : (this == PN ? "PN" : (this == PP ? "PP" : (this == NN ? "NN" : (this == NP ? "NP" : "UNKNOWN"))))))));
    }

    static {
        Orthogonals.add(PZ);
        Orthogonals.add(ZP);
        Orthogonals.add(NZ);
        Orthogonals.add(ZN);
        _getClimbingOrientationsHashSet = null;
        _handClimbingHoldGap = Math.min(0.25f, 0.06f * Math.max(((Float)SmartMovingAnticheatConfig.instance._freeClimbingUpSpeedFactor.value).floatValue(), ((Float)SmartMovingAnticheatConfig.instance._freeClimbingDownSpeedFactor.value).floatValue()));
        _climbGapTemp = new ClimbGap();
        _climbGapOuterTemp = new ClimbGap();
        _isLadder = Reflect.GetMethod(Block.class, new Name("isLadder"), false, World.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, EntityLivingBase.class);
        Class clazz = Reflect.LoadClass(Block.class, Install.ModBlockFence, false);
        _canConnectFenceTo = clazz != null ? Reflect.GetMethod(clazz, new Name("canConnectFenceTo"), false, IBlockAccess.class, Integer.TYPE, Integer.TYPE, Integer.TYPE) : null;
        _knownFanceGateBlocks = new Block[]{Block.fenceGate};
        _knownFenceBlocks = new Block[]{Block.fence, Block.netherFence};
        _knownWallBlocks = new Block[]{Block.cobblestoneWall};
        _knownHalfBlocks = new Block[]{Block.stoneSingleSlab, Block.stoneDoubleSlab, Block.woodSingleSlab, Block.woodDoubleSlab};
        _knownCompactStairBlocks = new Block[]{Block.stairsCobblestone, Block.stairsWoodOak, Block.stairsBrick, Block.stairsNetherBrick, Block.stairsSandStone, Block.stairsStoneBrick, Block.stairsWoodBirch, Block.stairsWoodJungle, Block.stairsWoodSpruce, Block.stairsNetherQuartz};
        _knownTrapDoorBlocks = new Block[]{Block.trapdoor};
        _knownThinWallBlocks = new Block[]{Block.fenceIron, Block.thinGlass};
        Class clazz2 = Reflect.LoadClass(Block.class, Install.BlockRopeLadder, false);
        Class clazz3 = Reflect.LoadClass(Block.class, Install.BlockSturdyLadder, false);
        _ladderKitLadderTypes = clazz2 != null ? (clazz3 != null ? new Class[]{clazz2, clazz3} : new Class[]{clazz2}) : (clazz3 != null ? new Class[]{clazz3} : null);
    }
}

