/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.config;

import gloomyfolken.mods.asm.FileWriteBlocker;
import java.io.File;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import net.minecraft.util.ResourceLocation;
import net.smart.moving.config.SmartMovingProperties;
import net.smart.properties.Properties;
import net.smart.properties.Property;

public class SmartMovingConfig
extends SmartMovingProperties {
    private static final String _smartLadderClimbingSpeedPropertiesFileName = "smart_ladder_climbing_speed_options.txt";
    private static final String _smartClimbingPropertiesFileName = "smart_climbing_options.txt";
    private static final String _smartMovingPropertiesFileName = "smart_moving_options.txt";
    private static final String _smartMovingClientServerPropertiesFileName = "smart_moving_server_options.txt";
    private static final String _slcs = "0.1";
    private static final String _sc = "0.2";
    private static final String _sm_1_0 = "1.0";
    private static final String _sm_1_1 = "1.1";
    private static final String _sm_1_2 = "1.2";
    private static final String _sm_1_3 = "1.3";
    private static final String _sm_1_4 = "1.4";
    private static final String _sm_1_5 = "1.5";
    private static final String _sm_1_6 = "1.6";
    private static final String _sm_1_7 = "1.7";
    private static final String _sm_1_8 = "1.8";
    private static final String _sm_1_9 = "1.9";
    private static final String _sm_1_10 = "1.10";
    private static final String _sm_1_11 = "1.11";
    public static final String _sm_2_0 = "2.0";
    public static final String _sm_2_1 = "2.1";
    public static final String _sm_2_2 = "2.2";
    public static final String _sm_2_3 = "2.3";
    public static final String _sm_2_4 = "2.4";
    public static final String _sm_2_5 = "2.5";
    public static final String _sm_2_6 = "2.6";
    public static final String _sm_3_0 = "3.0";
    public static final String _sm_3_1 = "3.1";
    public static final String _sm_3_2 = "3.2";
    public static final String _sm_current = "3.2";
    private static final String[] _all_sm = new String[]{"3.2", "3.1", "3.0", "2.6", "2.5", "2.4", "2.3", "2.2", "2.1", "2.0", "1.11", "1.10", "1.9", "1.8", "1.7", "1.6", "1.5", "1.4", "1.3", "1.2", "1.1", "1.0"};
    private static final String[] _all_old = new String[]{"0.2", "0.1"};
    protected static final String[] _pre_sm_1_3 = new String[]{"1.2", "1.1", "1.0"};
    protected static final String[] _pre_sm_1_4 = SmartMovingConfig.concat("1.3", _pre_sm_1_3);
    protected static final String[] _pre_sm_1_5 = SmartMovingConfig.concat("1.4", _pre_sm_1_4);
    protected static final String[] _pre_sm_1_6 = SmartMovingConfig.concat("1.5", _pre_sm_1_5);
    protected static final String[] _pre_sm_1_7 = SmartMovingConfig.concat("1.6", _pre_sm_1_6);
    protected static final String[] _pre_sm_1_8 = SmartMovingConfig.concat("1.7", _pre_sm_1_7);
    protected static final String[] _pre_sm_1_9 = SmartMovingConfig.concat("1.8", _pre_sm_1_8);
    protected static final String[] _pre_sm_1_10 = SmartMovingConfig.concat("1.9", _pre_sm_1_9);
    protected static final String[] _pre_sm_1_11 = SmartMovingConfig.concat("1.10", _pre_sm_1_10);
    protected static final String[] _pre_sm_2_0 = SmartMovingConfig.concat("1.11", _pre_sm_1_11);
    protected static final String[] _pre_sm_2_1 = SmartMovingConfig.concat("2.0", _pre_sm_2_0);
    protected static final String[] _pre_sm_2_2 = SmartMovingConfig.concat("2.1", _pre_sm_2_1);
    protected static final String[] _pre_sm_2_3 = SmartMovingConfig.concat("2.2", _pre_sm_2_2);
    protected static final String[] _pre_sm_2_4 = SmartMovingConfig.concat("2.3", _pre_sm_2_3);
    protected static final String[] _pre_sm_2_5 = SmartMovingConfig.concat("2.4", _pre_sm_2_4);
    protected static final String[] _pre_sm_2_6 = SmartMovingConfig.concat("2.5", _pre_sm_2_5);
    protected static final String[] _pre_sm_3_0 = SmartMovingConfig.concat("2.6", _pre_sm_2_6);
    protected static final String[] _pre_sm_3_1 = SmartMovingConfig.concat("3.0", _pre_sm_3_0);
    protected static final String[] _pre_sm_3_2 = SmartMovingConfig.concat("3.1", _pre_sm_3_1);
    private static final String[] _pre_sm_1_7_post_1_4 = new String[]{"1.6", "1.5"};
    private static final String[] _pre_sm_1_7_post_1_0 = new String[]{"1.6", "1.5", "1.4", "1.3", "1.2", "1.1"};
    public static final String[] _all = SmartMovingConfig.concat(_all_sm, _all_old);
    public final Property _speedFactor = SmartMovingConfig.PositiveFactor("move.speed.factor", new String[0]).defaults(java.lang.Float.valueOf(1.0f), new String[0]).comment("Global player speed factor (>= 0)").book("Global Speed", "Below you find the options to manipulate the global speed applied to all speeds.");
    public final Property _speedUser = this.Creative("move.speed.user", new String[0]).defaults(true, _pre_sm_3_2).comment("To switch on/off in-game speed manipulation");
    public final Property _speedUserFactor = SmartMovingConfig.PositiveFactor("move.speed.user.factor", new String[0]).singular().defaults(java.lang.Float.valueOf(0.2f), new String[0]).min(java.lang.Float.valueOf(1.0E-4f)).comment("The factor for in-game speed manipulation (>= 0.0001)");
    public final Property _speedUserExponent = SmartMovingConfig.Integer("move.speed.user.exponent", new String[0]).singular().defaults(0, new String[0]).comment("The exponent for in-game speed manipulation");
    public final Property _baseClimb = SmartMovingConfig.String().defaults("free", new String[0]).key("move.climb.base", new String[0]).key("move.climb.ladder", _pre_sm_1_10).key("climbing.ladder", _all_old).comment("To manipulate the ladder and vine climbing mode (possible values are \"free\", \"smart\", \"simple\" and \"standard\")").book("Climbing", "Below you find all free and ladder climbing options except those for ceiling climbing.");
    public final Property _freeClimb = SmartMovingConfig.Unmodified().key("move.climb.free", new String[0]).key("climbing.free", _all_old).comment("To switch on/off free climbing");
    public final Property _freeBaseLadderClimb = SmartMovingConfig.Modified().key("move.climb.free.base.ladder", new String[0]).comment("To switch on/off remaining base climbing behavior on ladders while free climbing is enabled for ladders (also see \"move.climb.base\")");
    public final Property _freeBaseVineClimb = SmartMovingConfig.Modified().key("move.climb.free.base.vine", new String[0]).defaults(true, _pre_sm_1_11).comment("To switch on/off remaining base climbing behavior on vines while free climbing is enabled for vines (also see \"move.climb.base\")");
    public final Property _isFreeBaseClimb = this._baseClimb.is("free").and(this._freeClimb);
    public final Property _isSmartBaseClimb = this._baseClimb.is("smart").andNot(this._isFreeBaseClimb);
    public final Property _isSimpleBaseClimb = this._baseClimb.is("simple").andNot(this._isFreeBaseClimb).andNot(this._isSmartBaseClimb);
    public final Property _isStandardBaseClimb = this._isFreeBaseClimb.not().andNot(this._isSmartBaseClimb).andNot(this._isSimpleBaseClimb);
    public final Property _freeClimbingUpSpeedFactor = SmartMovingConfig.PositiveFactor("move.climb.free.up.speed.factor", new String[0]).comment("Climbing up speed factor relative to default climbing up speed (>= 0)").chapter(new String[0]);
    public final Property _freeClimbingDownSpeedFactor = SmartMovingConfig.PositiveFactor("move.climb.free.down.speed.factor", new String[0]).comment("Climbing down speed factor relative to default climbing down speed (>= 0)");
    public final Property _freeClimbingHorizontalSpeedFactor = SmartMovingConfig.PositiveFactor("move.climb.free.horizontal.speed.factor", new String[0]).comment("Climbing horizontal speed factor relative to default climbing horizontal speed (>= 0)");
    public final Property _freeClimbingOrthogonalDirectionAngle = SmartMovingConfig.Positive("move.climb.free.direction.orthogonal.angle", new String[0]).values(java.lang.Float.valueOf(90.0f), java.lang.Float.valueOf(90.0f), java.lang.Float.valueOf(180.0f)).comment("Climbing N,S,E,W grabbing angle in degrees");
    public final Property _freeClimbingDiagonalDirectionAngle = SmartMovingConfig.Positive("move.climb.free.direction.diagonal.angle", new String[0]).values(java.lang.Float.valueOf(80.0f), java.lang.Float.valueOf(45.0f), java.lang.Float.valueOf(180.0f)).comment("Climbing NW,SW,SE,NE grabbing angle in degrees");
    public final Property _freeClimbingAutoLaddder = SmartMovingConfig.Unmodified("move.climb.free.ladder.auto", new String[0]).depends(this._isFreeBaseClimb).comment("Whether the \"grab\" button will automatically be triggered while being on ladders and looking in the right direction").section(new String[0]);
    public final Property _freeClimbingAutoVine = SmartMovingConfig.Unmodified("move.climb.free.vine.auto", new String[0]).depends(this._isFreeBaseClimb).comment("Whether the \"grab\" button will automatically be triggered while being on standard climbable vines and looking in the right direction");
    public final Property _freeOneLadderClimbUpSpeedFactor = SmartMovingConfig.PositiveFactor("move.climb.free.ladder.one.up.speed.factor", new String[0]).defaults(java.lang.Float.valueOf(1.0153f), new String[0]).defaults(java.lang.Float.valueOf(0.71f), _pre_sm_2_4).comment("Additional speed factor when climbing straight up on one ladder block (>= 0)");
    public final Property _freeBothLadderClimbUpSpeedFactor = SmartMovingConfig.IncreasingFactor("move.climb.free.ladder.two.up.speed.factor", new String[0]).defaults(java.lang.Float.valueOf(1.43f), new String[0]).comment("Additional speed factor when climbing straight up on two ladder blocks (>= 1)");
    public final Property _freeFenceClimbing = SmartMovingConfig.Unmodified("move.climb.free.fence", new String[0]).comment("Climbing over fences");
    public final Property _freeClimbFallDamageStartDistance = SmartMovingConfig.Positive("move.climb.fall.damage.start.distance", new String[0]).values(java.lang.Float.valueOf(2.0f), java.lang.Float.valueOf(1.0f), java.lang.Float.valueOf(3.0f)).comment("Distance in blocks to fall before suffering fall damage when starting to climb (>= 1, <= 3)").section(new String[0]);
    public final Property _freeClimbFallDamageFactor = SmartMovingConfig.IncreasingFactor("move.climb.fall.damage.factor", new String[0]).defaults(java.lang.Float.valueOf(2.0f), new String[0]).comment("Damage factor applied to the remaining distance (>= 1)");
    public final Property _freeClimbFallMaximumDistance = SmartMovingConfig.Positive("move.climb.fall.maximum.distance", new String[0]).defaults(java.lang.Float.valueOf(3.0f), new String[0]).min(this._freeClimbFallDamageStartDistance).comment("Distance in blocks to fall to block all climbing attempts (>= \"move.climb.fall.damage.start.distance\")");
    public final Property _climbExhaustion = this.Hard("move.climb.exhaustion", new String[0]).comment("To switch on/off exhaustion while climbing").section(new String[0]);
    public final Property _climbExhaustionStart = SmartMovingConfig.Positive("move.climb.exhaustion.start", new String[0]).defaults(java.lang.Float.valueOf(60.0f), new String[0]).defaults(java.lang.Float.valueOf(0.0f), _pre_sm_1_4).comment("Maximum exhaustion to start climbing along ceilings (>= 0)");
    public final Property _climbExhaustionStop = SmartMovingConfig.Positive("move.climb.exhaustion.stop", new String[0]).up(java.lang.Float.valueOf(80.0f), this._climbExhaustionStart).defaults(java.lang.Float.valueOf(100.0f), _pre_sm_1_4).comment("Maximum exhaustion to climb (>= 0)");
    public final Property _climbStrafeExhaustionGain = SmartMovingConfig.Positive("move.climb.strafe.exhaustion.gain", new String[0]).defaults(java.lang.Float.valueOf(1.1f), new String[0]).defaults(java.lang.Float.valueOf(0.75f), _pre_sm_1_4).comment("Exhaustion added every tick while climbing horizontally (>= 0)");
    public final Property _climbUpExhaustionGain = SmartMovingConfig.Positive("move.climb.up.exhaustion.gain", new String[0]).defaults(java.lang.Float.valueOf(1.2f), new String[0]).defaults(java.lang.Float.valueOf(1.0f), _pre_sm_1_4).comment("Exhaustion added every tick while climbing up (>= 0)");
    public final Property _climbDownExhaustionGain = SmartMovingConfig.Positive("move.climb.down.exhaustion.gain", new String[0]).defaults(java.lang.Float.valueOf(1.05f), new String[0]).defaults(java.lang.Float.valueOf(0.5f), _pre_sm_1_4).comment("Exhaustion added every tick while climbing down (>= 0)");
    public final Property _climbStrafeUpExhaustionGain = SmartMovingConfig.Positive("move.climb.strafe.up.exhaustion.gain", new String[0]).defaults(java.lang.Float.valueOf(1.3f), new String[0]).comment("Exhaustion added every tick while climbing diagonally up (>= 0)");
    public final Property _climbStrafeDownExhaustionGain = SmartMovingConfig.Positive("move.climb.strafe.down.exhaustion.gain", new String[0]).defaults(java.lang.Float.valueOf(1.25f), new String[0]).comment("Exhaustion added every tick while climbing diagonally down (>= 0)");
    public final Property _ceilingClimbing = SmartMovingConfig.Unmodified("move.climb.ceiling", new String[0]).comment("To switch on/off climbing along ceilings").book("Ceiling climbing", "Below you find all ceiling climbing options");
    public final Property _ceilingClimbingSpeedFactor = SmartMovingConfig.PositiveFactor("move.climb.ceiling.speed.factor", new String[0]).defaults(java.lang.Float.valueOf(0.2f), new String[0]).comment("Speed factor while climbing along ceilings (>= 0, relative to default movement speed)");
    public final Property _ceilingClimbConfigurationString = SmartMovingConfig.Strings("move.climb.ceiling.configuration", new String[0]).defaults(new String[]{"tile.fenceIron", "tile.trapdoor/0/1/2/3", "tile.trapdoor_iron/0/1/2/3"}, new String[0]).defaults(new String[]{"tile.fenceIron", "tile.trapdoor/0/1/2/3"}, _pre_sm_2_5).comment("To define which blocks are ceiling climbable (syntax: '<blockId/blockName>(/<metadata>)*' seperator: ',')");
    public final Property _ceilingClimbConfigurationObject = this._ceilingClimbConfigurationString.toBlockConfig();
    public final Property _ceilingClimbExhaustion = this.Hard("move.climb.ceiling.exhaustion", new String[0]).comment("To switch on/off exhaustion while climbing along ceilings").section(new String[0]);
    public final Property _ceilingClimbExhaustionStart = SmartMovingConfig.Positive("move.climb.ceiling.exhaustion.start", new String[0]).defaults(java.lang.Float.valueOf(40.0f), new String[0]).defaults(java.lang.Float.valueOf(0.0f), _pre_sm_1_4).comment("Maximum exhaustion to start climbing along ceilings (>= 0)");
    public final Property _ceilingClimbExhaustionStop = SmartMovingConfig.Positive("move.climb.ceiling.exhaustion.stop", new String[0]).up(java.lang.Float.valueOf(60.0f), this._ceilingClimbExhaustionStart).defaults(java.lang.Float.valueOf(100.0f), _pre_sm_1_4).comment("Maximum exhaustion to climbing along ceilings (>= \"move.climb.ceiling.exhaustion.start\")");
    public final Property _ceilingClimbExhaustionGain = SmartMovingConfig.Positive("move.climb.ceiling.exhaustion.gain", new String[0]).defaults(java.lang.Float.valueOf(1.3f), new String[0]).defaults(java.lang.Float.valueOf(2.0f), _pre_sm_1_4).comment("Exhaustion added every tick while climbing along ceilings (>= 0)");
    public final Property _swim = SmartMovingConfig.Unmodified().key("move.swim", new String[0]).key("climbing.swim", _all_old).comment("To switch on/off swimming").book("Swimming", "Below you find all swimming options");
    public final Property _swimSpeedFactor = SmartMovingConfig.PositiveFactor("move.swim.speed.factor", new String[0]).comment("Speed factor while swimming (>= 0, relative to default movement speed)");
    public final Property _swimDownOnSneak = SmartMovingConfig.Unmodified().key("move.swim.down.sneak", new String[0]).defaults(false, _pre_sm_1_6).comment("To switch on/off diving down instead of swimming slow on sneaking while swimming");
    public final Property _swimParticlePeriodFactor = SmartMovingConfig.PositiveFactor("move.swim.particle.period.factor", new String[0]).comment("Swim particle spawning period factor (>= 0)");
    public final Property _dive = SmartMovingConfig.Unmodified().key("move.dive", new String[0]).key("climbing.dive", _all_old).comment("To switch on/off diving").book("Diving", "Below you find all diving options");
    public final Property _diveSpeedFactor = SmartMovingConfig.PositiveFactor("move.dive.speed.factor", new String[0]).comment("Speed factor while diving (>= 0, relative to default movement speed)");
    public final Property _diveDownOnSneak = SmartMovingConfig.Unmodified().key("move.dive.down.sneak", new String[0]).defaults(false, _pre_sm_1_6).comment("To switch on/off diving down instead of diving slow on sneaking while diving");
    public final Property _lavaLikeWater = this.Creative("move.lava.water", new String[0]).comment("To switch on/off swimming and diving in lava").book("Lava", "Below you find all lava movement options");
    public final Property _lavaSwimParticlePeriodFactor = SmartMovingConfig.PositiveFactor("move.lava.swim.particle.period.factor", new String[0]).defaults(java.lang.Float.valueOf(4.0f), new String[0]).comment("Lava swim particle spawning period factor (>= 0)");
    public final Property _run = SmartMovingConfig.Unmodified("move.run", new String[0]).comment("To switch on/off standard sprinting").book("Standard sprinting", "Below you find the options for standard vanilla Minecraft sprinting (sometimes referred as \"running\" here)");
    public final Property _runFactor = SmartMovingConfig.PositiveFactor("move.run.factor", new String[0]).defaults(java.lang.Float.valueOf(1.3f), new String[0]).min(java.lang.Float.valueOf(1.1f)).comment("Standard sprinting factor (>= 1.1)");
    public final Property _runExhaustion = this.Hard("move.run.exhaustion", new String[0]).depends(this._run).comment("To switch on/off standard sprinting exhaustion");
    public final Property _runExhaustionStart = SmartMovingConfig.Positive("move.exhaustion.run.start", new String[0]).defaults(java.lang.Float.valueOf(75.0f), new String[0]).comment("Maximum exhaustion to start a standard sprint (>= 0)").section(new String[0]);
    public final Property _runExhaustionStop = SmartMovingConfig.Positive("move.exhaustion.run.stop", new String[0]).up(java.lang.Float.valueOf(100.0f), this._runExhaustionStart).comment("Maximum exhaustion to continue a standard sprint (>= \"move.exhaustion.run.start\")");
    public final Property _runExhaustionGainFactor = SmartMovingConfig.Positive("move.exhaustion.run.gain.factor", new String[0]).defaults(java.lang.Float.valueOf(1.5f), new String[0]).comment("Exhaustion gain factor while standard sprinting (>= 0)");
    public final Property _sprint = SmartMovingConfig.Unmodified("move.sprint", new String[0]).comment("To switch on/off generic sprinting").book("Generic sprinting", "Below you find the options for Smart Moving's generic sprinting available for many different smart movings plus standard walking");
    public final Property _sprintFactor = SmartMovingConfig.PositiveFactor("move.sprint.factor", new String[0]).defaults(java.lang.Float.valueOf(1.5f), new String[0]).min(this._run.eitherOr(this._runFactor.plus(java.lang.Float.valueOf(0.1f)), java.lang.Float.valueOf(1.1f))).comment("Generic sprinting factor (>= 1.1 AND >= 'move.run.factor' + 0.1 if relevant)");
    public final Property _sprintExhaustion = this.Medium("move.sprint.exhaustion", new String[0]).depends(this._sprint).comment("To switch on/off sprinting exhaustion");
    public final Property _sprintExhaustionStart = SmartMovingConfig.Positive("move.exhaustion.sprint.start", new String[0]).defaults(java.lang.Float.valueOf(50.0f), new String[0]).comment("Maximum exhaustion to start a sprint (>= 0)").section(new String[0]);
    public final Property _sprintExhaustionStop = SmartMovingConfig.Positive("move.exhaustion.sprint.stop", new String[0]).up(java.lang.Float.valueOf(100.0f), this._sprintExhaustionStart).comment("Maximum exhaustion to continue a sprint (>= \"move.exhaustion.sprint.start\")");
    public final Property _sprintExhaustionGainFactor = SmartMovingConfig.IncreasingFactor("move.exhaustion.sprint.gain.factor", new String[0]).defaults(java.lang.Float.valueOf(2.0f), new String[0]).comment("Exhaustion gain factor while sprinting (>= 0)");
    public final Property _sneak = SmartMovingConfig.Unmodified("move.sneak", new String[0]).comment("To switch on/off standard sneaking").book("Generic sneaking", "Below you find the options for Smart Moving's generic sneaking available for many different smart movings. These options also apply to standard sneaking!");
    public final Property _sneakFactor = SmartMovingConfig.DecreasingFactor("move.sneak.factor", new String[0]).defaults(java.lang.Float.valueOf(0.3f), new String[0]).comment("Speed factor while sneaking (>= 0, <= 1, relative to default movement speed)");
    public final Property _sneakNameTag = SmartMovingConfig.Modified("move.sneak.name", new String[0]).comment("Whether to display a name tag above other standard sneaking players");
    public final Property _crawl = SmartMovingConfig.Unmodified("move.crawl", new String[0]).comment("To switch on/off crawling").book("Crawling", "Below you find all crawling options.");
    public final Property _crawlFactor = SmartMovingConfig.DecreasingFactor("move.crawl.factor", new String[0]).defaults(java.lang.Float.valueOf(0.15f), new String[0]).comment("Speed factor while crawling (>= 0, <= 1, relative to default movement speed)");
    public final Property _crawlNameTag = SmartMovingConfig.Modified("move.crawl.name", new String[0]).comment("Whether to display a name tag above other crawling players");
    public final Property _crawlOverEdge = SmartMovingConfig.Unmodified("move.crawl.edge", new String[0]).comment("Whether to allow crawling over edges");
    public final Property _slide = SmartMovingConfig.Unmodified("move.slide", new String[0]).comment("To switch on/off sliding").book("Sliding", "Below you find all sliding options.");
    public final Property _slideControlDegrees = SmartMovingConfig.PositiveFactor("move.slide.control.angle", new String[0]).defaults(java.lang.Float.valueOf(1.0f), new String[0]).comment("Sliding control movement factor (>= 0, in degrees per tick)");
    public final Property _slideSlipperinessFactor = SmartMovingConfig.PositiveFactor("move.slide.glide.factor", new String[0]).comment("Slipperiness factor while sliding (>= 0)");
    public final Property _slidingSpeedStopFactor = SmartMovingConfig.PositiveFactor("move.slide.speed.stop.factor", new String[0]).comment("Sliding to crawling transition speed factor (>= 0)");
    public final Property _slideParticlePeriodFactor = SmartMovingConfig.PositiveFactor("move.slide.particle.period.factor", new String[0]).defaults(java.lang.Float.valueOf(0.5f), new String[0]).defaults(java.lang.Float.valueOf(1.0f), _pre_sm_1_6).comment("Sliding particle spawning period factor (>= 0)");
    public final Property _fly = SmartMovingConfig.Unmodified("move.fly", new String[0]).comment("To switch on/off smart flying").book("Smart flying", "Below you find all options for Smart Moving's own flying mode.");
    public final Property _flyingSpeedFactor = SmartMovingConfig.PositiveFactor("move.fly.speed.factor", new String[0]).comment("To manipulate smart flying speed (>= 0)");
    public final Property _levitateSmall = SmartMovingConfig.Unmodified("move.levitate.small", new String[0]).comment("To switch on/off standard flying small size").book("Standard flying", "Below you find the options for standard vanilla Minecraft flying (sometimes referred as \"levitating\" here)");
    public final Property _levitateAnimation = SmartMovingConfig.Unmodified("move.levitate.animation", new String[0]).key("move.fly.animation", new String[0]).comment("To switch on/off standard flying animation");
    public final Property _fallingDistanceMinimum = SmartMovingConfig.Positive("move.fall.distance.minimum", new String[0]).defaults(java.lang.Float.valueOf(3.0f), new String[0]).comment("Minimum fall distance for stopping ground based moves like crawling or sliding (>= 0)").book("Falling", "Below you find the options for Smart Moving's falling");
    public final Property _fallAnimation = SmartMovingConfig.Unmodified("move.fall.animation", new String[0]).comment("To switch on/off smart falling animation");
    public final Property _fallAnimationDistanceMinimum = SmartMovingConfig.Positive("move.fall.animation.distance.minimum", new String[0]).min(this._fallingDistanceMinimum).defaults(java.lang.Float.valueOf(3.0f), _pre_sm_1_6).comment("Minimum fall distance for the smart falling animation (>= 0, >= \"move.fall.animation.distance.minimum\"");
    public final Property _jump = SmartMovingConfig.Unmodified("move.jump", new String[0]).comment("To switch on/off jumping").book("Jumping", "Below you find the options for all Smart Moving's different jump types. These options also apply to standard jumping!");
    public final Property _jumpControlFactor = SmartMovingConfig.DecreasingFactor("move.jump.control.factor", new String[0]).defaults(java.lang.Float.valueOf(1.0f), new String[0]).comment("Jumping control movement factor (>= 0, <= 1, relative to default air movement speed)");
    public final Property _jumpHorizontalFactor = SmartMovingConfig.IncreasingFactor("move.jump.horizontal.factor", new String[0]).comment("Horizontal jumping factor relative to actual horizontal movement (>= 1)").section(new String[0]);
    public final Property _jumpVerticalFactor = SmartMovingConfig.PositiveFactor("move.jump.vertical.factor", new String[0]).comment("Vertical jumping factor relative to default jump height (>= 0)");
    public final Property _standJump = SmartMovingConfig.Unmodified("move.jump.stand", new String[0]).depends(this._jump).comment("To switch on/off jumping while standing (Relevant only if \"move.jump\" is true)").chapter(new String[0]);
    public final Property _standJumpVerticalFactor = SmartMovingConfig.PositiveFactor("move.jump.stand.vertical.factor", new String[0]).comment("Vertical stand jumping factor relative to default jump height (>= 0)");
    public final Property _sneakJump = SmartMovingConfig.Unmodified("move.jump.sneak", new String[0]).key("move.sneak.jump", _pre_sm_1_7).depends(this._sneak, this._jump).comment("To switch on/off jumping while sneaking (Relevant only if nether \"move.sneak\" nor \"move.jump\" are false)").chapter(new String[0]);
    public final Property _sneakJumpHorizontalFactor = SmartMovingConfig.IncreasingFactor("move.jump.sneak.horizontal.factor", new String[0]).key("move.sneak.jump.horizontal.factor", _pre_sm_1_7).comment("Horizontal sneak jumping factor relative to actual horizontal movement (>= 1)");
    public final Property _sneakJumpVerticalFactor = SmartMovingConfig.PositiveFactor("move.jump.sneak.vertical.factor", new String[0]).key("move.sneak.jump.vertical.factor", _pre_sm_1_7).comment("Vertical sneak jumping factor relative to default jump height (>= 0)");
    public final Property _walkJump = SmartMovingConfig.Unmodified("move.jump.walk", new String[0]).depends(this._jump).comment("To switch on/off jumping while walking (Relevant only if \"move.jump\" is true)").chapter(new String[0]);
    public final Property _walkJumpHorizontalFactor = SmartMovingConfig.IncreasingFactor("move.jump.walk.horizontal.factor", new String[0]).comment("Horizontal walk jumping factor relative to actual horizontal movement (>= 1)");
    public final Property _walkJumpVerticalFactor = SmartMovingConfig.PositiveFactor("move.jump.walk.vertical.factor", new String[0]).comment("Vertical walk jumping factor relative to default jump height (>= 0)");
    public final Property _runJump = SmartMovingConfig.Unmodified("move.jump.run", new String[0]).key("move.run.jump", _pre_sm_1_7).depends(this._run, this._jump).comment("To switch on/off jumping while running (Relevant only if nether \"move.run\" nor \"move.jump\" are false)").chapter(new String[0]);
    public final Property _runJumpHorizontalFactor = SmartMovingConfig.IncreasingFactor("move.jump.run.horizontal.factor", new String[0]).key("move.run.jump.horizontal.factor", _pre_sm_1_7).defaults(java.lang.Float.valueOf(2.0f), new String[0]).comment("Horizontal run jumping factor relative to actual horizontal movement (>= 1)");
    public final Property _runJumpVerticalFactor = SmartMovingConfig.PositiveFactor("move.jump.run.vertical.factor", new String[0]).key("move.run.jump.vertical.factor", _pre_sm_1_7).comment("Vertical run jumping factor relative to default jump height (>= 0)");
    public final Property _sprintJump = SmartMovingConfig.Unmodified("move.jump.sprint", new String[0]).key("move.sprint.jump", _pre_sm_1_7).depends(this._sprint, this._jump).comment("To switch on/off jumping while sprinting (Relevant only if nether \"move.sprint\" nor \"move.jump\" are false)").chapter(new String[0]);
    public final Property _sprintJumpHorizontalFactor = SmartMovingConfig.IncreasingFactor("move.jump.sprint.horizontal.factor", new String[0]).key("move.sprint.jump.horizontal.factor", _pre_sm_1_7).defaults(java.lang.Float.valueOf(2.0f), new String[0]).comment("Horizontal sprint jumping factor relative to actual horizontal movement (>= 1)");
    public final Property _sprintJumpVerticalFactor = SmartMovingConfig.PositiveFactor("move.jump.sprint.vertical.factor", new String[0]).key("move.sprint.jump.vertical.factor", _pre_sm_1_7).comment("Vertical sprint jumping factor relative to default jump height (>= 0)");
    public final Property _jumpCharge = SmartMovingConfig.Unmodified("move.jump.charge", new String[0]).depends(this._jump).comment("Relevant only if \"move.jump\" is not false").chapter("Charged jumping", "Below you find all charged jump specific options except those for exhaustion.");
    public final Property _jumpChargeMaximum = SmartMovingConfig.Positive("move.jump.charge.maximum", new String[0]).defaults(java.lang.Float.valueOf(20.0f), new String[0]).comment("Maximum jump charge (counts up one per tick) (>= 0)");
    public final Property _jumpChargeFactor = SmartMovingConfig.IncreasingFactor("move.jump.charge.factor", new String[0]).defaults(java.lang.Float.valueOf(1.3f), new String[0]).comment("Jump speed factor when completely charged (>= 1)");
    public final Property _jumpChargeCancelOnSneakRelease = SmartMovingConfig.Modified("move.jump.charge.sneak.release.cancel", new String[0]).comment("To switch between charged jump and charge cancel on sneak button release while jump charging");
    public final Property _headJump = SmartMovingConfig.Unmodified("move.jump.head.charge", new String[0]).key("move.forward.jump.charge", _pre_sm_1_8).depends(this._jump).comment("Relevant only if \"move.jump\" is not false").chapter("Head jumping", "Below you find all head jump and fall specific options except those for exhaustion.");
    public final Property _headJumpControlFactor = SmartMovingConfig.DecreasingFactor("move.jump.head.control.factor", new String[0]).key("move.forward.jump.control.factor", _pre_sm_1_8).defaults(java.lang.Float.valueOf(0.2f), new String[0]).comment("Head jump control movement factor (>= 0, <= 1, relative to default air movement speed)");
    public final Property _headJumpChargeMaximum = SmartMovingConfig.Positive("move.jump.head.charge.maximum", new String[0]).key("move.forward.jump.charge.maximum", _pre_sm_1_8).defaults(java.lang.Float.valueOf(10.0f), new String[0]).comment("Maximum head jump charge (counts up one per tick) (>= 0)");
    public final Property _headFallDamageStartDistance = SmartMovingConfig.Positive("move.fall.head.damage.start.distance", new String[0]).key("move.forward.fall.damage.start.distance", _pre_sm_1_8).values(java.lang.Float.valueOf(2.0f), java.lang.Float.valueOf(1.0f), java.lang.Float.valueOf(3.0f)).comment("Distance in blocks to fall head ahead before suffering fall damage (>= 1, <= 3)").section(new String[0]);
    public final Property _headFallDamageFactor = SmartMovingConfig.IncreasingFactor("move.fall.head.damage.factor", new String[0]).key("move.forward.fall.damage.factor", _pre_sm_1_8).defaults(java.lang.Float.valueOf(2.0f), new String[0]).comment("Damage factor applied to the remaining distance when impacting head ahead (>= 1)");
    public final Property _angleJumpSide = SmartMovingConfig.Unmodified("move.jump.angle.side", new String[0]).comment("To switch on/off side jumping").chapter("Side and Back jumping", "Below you find all side and back jump specific options except those for exhaustion.");
    public final Property _angleJumpBack = SmartMovingConfig.Unmodified("move.jump.angle.back", new String[0]).comment("To switch on/off back jumping");
    public final Property _angleJumpHorizontalFactor = SmartMovingConfig.PositiveFactor("move.jump.angle.horizontal.factor", new String[0]).defaults(java.lang.Float.valueOf(0.3f), new String[0]).defaults(java.lang.Float.valueOf(0.4f), "1.3").comment("Horizontal jump speed factor for side and back jumps (>= 0)");
    public final Property _angleJumpVerticalFactor = SmartMovingConfig.PositiveFactor("move.jump.angle.vertical.factor", new String[0]).defaults(java.lang.Float.valueOf(0.2f), new String[0]).comment("Vertical jump speed factor for side and back jumps (>= 0)");
    public final Property _climbUpJump = SmartMovingConfig.Unmodified("move.jump.climb.up", new String[0]).comment("To switch on/off jumping up while climbing").chapter("Climb jumping", "Below you find all climb up jump specific options except those for exhaustion.");
    public final Property _climbUpJumpVerticalFactor = SmartMovingConfig.DecreasingFactor("move.jump.climb.up.vertical.factor", new String[0]).comment("Vertical jump speed factor for jumping while climbing (>= 0, <= 1)");
    public final Property _climbUpJumpHandsOnlyVerticalFactor = SmartMovingConfig.DecreasingFactor("move.jump.climb.up.hands.only.vertical.factor", new String[0]).defaults(java.lang.Float.valueOf(0.8f), new String[0]).comment("Additional vertical jump speed factor for jumping while climbing with hands only (>= 0, <= 1)");
    public final Property _climbBackUpJump = SmartMovingConfig.Unmodified("move.jump.climb.back.up", new String[0]).comment("To switch on/off jumping back while climbing").chapter("Climb back jumping", "Below you find all climb back jump specific options except those for exhaustion.");
    public final Property _climbBackUpJumpVerticalFactor = SmartMovingConfig.DecreasingFactor("move.jump.climb.back.up.vertical.factor", new String[0]).defaults(java.lang.Float.valueOf(0.2f), new String[0]).defaults(java.lang.Float.valueOf(1.0f), _pre_sm_3_1).comment("Vertical jump speed factor for jumping back while climbing (>= 0, <= 1)");
    public final Property _climbBackUpJumpHorizontalFactor = SmartMovingConfig.DecreasingFactor("move.jump.climb.back.up.horizontal.factor", new String[0]).defaults(java.lang.Float.valueOf(0.3f), new String[0]).defaults(java.lang.Float.valueOf(1.0f), _pre_sm_3_1).comment("Horizontal jump speed factor for jumping back while climbing (>= 0, <= 1)");
    public final Property _climbBackUpJumpHandsOnlyVerticalFactor = SmartMovingConfig.DecreasingFactor("move.jump.climb.back.up.hands.only.vertical.factor", new String[0]).defaults(java.lang.Float.valueOf(0.8f), new String[0]).comment("Additional vertical jump speed factor for jumping back while climbing with hands only (>= 0, <= 1)");
    public final Property _climbBackUpJumpHandsOnlyHorizontalFactor = SmartMovingConfig.DecreasingFactor("move.jump.climb.back.up.hands.only.horizontal.factor", new String[0]).comment("Additional horizontal jump speed factor for jumping back while climbing with hands only (>= 0, <= 1)");
    public final Property _climbBackHeadJump = SmartMovingConfig.Unmodified("move.jump.climb.back.head", new String[0]).comment("To switch on/off head jumping back while climbing").chapter("Climb back head jumping", "Below you find all climb back head jump specific options except those for exhaustion.");
    public final Property _climbBackHeadJumpVerticalFactor = SmartMovingConfig.DecreasingFactor("move.jump.climb.back.head.vertical.factor", new String[0]).defaults(java.lang.Float.valueOf(0.2f), new String[0]).defaults(java.lang.Float.valueOf(1.0f), _pre_sm_3_1).comment("Additional vertical jump speed factor for head jumping back while climbing(>= 0, <= 1)");
    public final Property _climbBackHeadJumpHorizontalFactor = SmartMovingConfig.DecreasingFactor("move.jump.climb.back.head.horizontal.factor", new String[0]).defaults(java.lang.Float.valueOf(0.3f), new String[0]).defaults(java.lang.Float.valueOf(1.0f), _pre_sm_3_1).comment("Additional horizontal jump speed factor for head jumping back while climbing(>= 0, <= 1)");
    public final Property _climbBackHeadJumpHandsOnlyVerticalFactor = SmartMovingConfig.DecreasingFactor("move.jump.climb.back.head.hands.only.vertical.factor", new String[0]).defaults(java.lang.Float.valueOf(0.8f), new String[0]).comment("Additional vertical jump speed factor for head jumping while climbing with hands only (>= 0, <= 1)");
    public final Property _climbBackHeadJumpHandsOnlyHorizontalFactor = SmartMovingConfig.DecreasingFactor("move.jump.climb.back.head.hands.only.horizontal.factor", new String[0]).comment("Additional horizontal jump speed factor for head jumping while climbing with hands only (>= 0, <= 1)");
    public final Property _wallUpJump = SmartMovingConfig.Unmodified("move.jump.wall", new String[0]).comment("To switch on/off wall jumping").chapter("Wall jumping", "Below you find all wall jump specific options except those for exhaustion.");
    public final Property _wallUpJumpVerticalFactor = SmartMovingConfig.DecreasingFactor("move.jump.wall.vertical.factor", new String[0]).defaults(java.lang.Float.valueOf(0.4f), new String[0]).comment("Vertical jump speed factor for wall jumping (>= 0, <= 1)");
    public final Property _wallUpJumpHorizontalFactor = SmartMovingConfig.DecreasingFactor("move.jump.wall.horizontal.factor", new String[0]).defaults(java.lang.Float.valueOf(0.15f), new String[0]).comment("Horizontal jump speed factor for wall jumping (>= 0, <= 1)");
    public final Property _wallUpJumpFallMaximumDistance = SmartMovingConfig.Positive("move.jump.wall.fall.maximum.distance", new String[0]).defaults(java.lang.Float.valueOf(2.0f), new String[0]).comment("Distance in blocks to fall to block all wall jumping attempts");
    public final Property _wallUpJumpOrthogonalTolerance = SmartMovingConfig.Positive("move.jump.wall.orthogonal.tolerance", new String[0]).defaults(java.lang.Float.valueOf(5.0f), new String[0]).comment("Tolerance angle in degree for wall jumping orthogonally (>= 0, <= 45)");
    public final Property _wallHeadJump = SmartMovingConfig.Unmodified("move.jump.wall.head", new String[0]).comment("To switch on/off wall head jumping").chapter("Wall head jumping", "Below you find all wall head jump specific options except those for exhaustion.");
    public final Property _wallHeadJumpVerticalFactor = SmartMovingConfig.DecreasingFactor("move.jump.wall.head.vertical.factor", new String[0]).defaults(java.lang.Float.valueOf(0.3f), new String[0]).comment("Vertical jump speed factor for wall head jumping (>= 0, <= 1)");
    public final Property _wallHeadJumpHorizontalFactor = SmartMovingConfig.DecreasingFactor("move.jump.wall.head.horizontal.factor", new String[0]).defaults(java.lang.Float.valueOf(0.15f), new String[0]).comment("Horizontal jump speed factor for wall head jumping (>= 0, <= 1)");
    public final Property _wallHeadJumpFallMaximumDistance = SmartMovingConfig.Positive("move.jump.wall.head.fall.maximum.distance", new String[0]).defaults(java.lang.Float.valueOf(3.0f), new String[0]).min(this._wallUpJumpFallMaximumDistance).comment("Distance in blocks to fall to block all wall head jumping attempts (>= \"move.jump.wall.fall.maximum.distance\")");
    private final Property _old_jumpExhaustion = this.Hard("move.jump.exhaustion", _pre_sm_1_7);
    private final Property _old_jumpExhaustionGain = SmartMovingConfig.Positive("move.jump.exhaustion.gain", _pre_sm_1_7_post_1_0).key("move.exhaustion.jump.gain", "1.0").defaults(java.lang.Float.valueOf(40.0f), new String[0]).defaults(java.lang.Float.valueOf(10.0f), _pre_sm_1_4);
    private final Property _old_jumpExhaustionStop = SmartMovingConfig.Positive("move.jump.exhaustion.stop", _pre_sm_1_7_post_1_0).key("move.exhaustion.jump.stop", "1.0").defaults(java.lang.Float.valueOf(60.0f), new String[0]).defaults(java.lang.Float.valueOf(100.0f), _pre_sm_1_4);
    private final Property _old_sneakJumpExhaustion = this.Hard("move.jump.sneak.exhaustion", _pre_sm_1_7_post_1_4).key("move.sneak.jump.exhaustion", _pre_sm_1_4);
    private final Property _old_sneakJumpExhaustionGain = SmartMovingConfig.Positive("move.sneak.jump.exhaustion.gain", _pre_sm_1_7).down(java.lang.Float.valueOf(45.0f), this._old_jumpExhaustionGain).defaults(java.lang.Float.valueOf(10.0f), _pre_sm_1_4);
    private final Property _old_sneakJumpExhaustionStop = SmartMovingConfig.Positive("move.sneak.jump.exhaustion.stop", _pre_sm_1_7).up(java.lang.Float.valueOf(55.0f), this._old_jumpExhaustionStop).defaults(java.lang.Float.valueOf(100.0f), _pre_sm_1_4);
    private final Property _old_runJumpExhaustion = this.Medium("move.jump.run.exhaustion", _pre_sm_1_7_post_1_4).key("move.run.jump.exhaustion", _pre_sm_1_4);
    private final Property _old_runJumpExhaustionGain = SmartMovingConfig.Positive("move.run.jump.exhaustion.gain", _pre_sm_1_7).defaults(java.lang.Float.valueOf(60.0f), new String[0]).defaults(java.lang.Float.valueOf(20.0f), _pre_sm_1_4);
    private final Property _old_runJumpExhaustionStop = SmartMovingConfig.Positive("move.run.jump.exhaustion.stop", _pre_sm_1_7).defaults(java.lang.Float.valueOf(40.0f), new String[0]).defaults(java.lang.Float.valueOf(100.0f), _pre_sm_1_4);
    private final Property _old_sprintJumpExhaustion = this.Medium("move.jump.sprint.exhaustion", _pre_sm_1_7_post_1_4).key("move.sprint.jump.exhaustion", _pre_sm_1_4);
    private final Property _old_sprintJumpExhaustionGain = SmartMovingConfig.Positive("move.sprint.jump.exhaustion.gain", _pre_sm_1_7_post_1_0).key("move.exhaustion.sprint.jump.gain", "1.0").up(java.lang.Float.valueOf(65.0f), this._old_runJumpExhaustionGain).defaults(java.lang.Float.valueOf(20.0f), _pre_sm_1_4);
    private final Property _old_sprintJumpExhaustionStop = SmartMovingConfig.Positive("move.sprint.jump.exhaustion.stop", _pre_sm_1_7_post_1_0).key("move.exhaustion.sprint.jump.stop", "1.0").down(java.lang.Float.valueOf(35.0f), this._old_runJumpExhaustionStop).defaults(java.lang.Float.valueOf(100.0f), _pre_sm_1_4);
    public final Property _jumpExhaustion = SmartMovingConfig.Unmodified("move.jump.exhaustion", new String[0]).comment("To switch on/off jump exhaustion").chapter("Jump exhaustion", "Below you find the exhaustion options for the different jump types. At runtime all relevant options are combined together to form the specific exhaustion value");
    public final Property _jumpExhaustionGainFactor = SmartMovingConfig.PositiveFactor("move.jump.exhaustion.gain.factor", new String[0]).comment("To manipulate the exhaustion increase by a jump (>= 0)");
    public final Property _jumpExhaustionStopFactor = SmartMovingConfig.PositiveFactor("move.jump.exhaustion.stop.factor", new String[0]).comment("To manipulate maximum exhaustion to jump (>= 0)");
    public final Property _upJumpExhaustion = SmartMovingConfig.Unmodified("move.jump.up.exhaustion", new String[0]).depends(this._jumpExhaustion).comment("To switch on/off up jump exhaustion").chapter(new String[0]);
    public final Property _upJumpExhaustionGainFactor = SmartMovingConfig.PositiveFactor("move.jump.up.exhaustion.gain.factor", new String[0]).comment("To manipulate the exhaustion increase by a jump up (>= 0)");
    public final Property _upJumpExhaustionStopFactor = SmartMovingConfig.PositiveFactor("move.jump.up.exhaustion.stop.factor", new String[0]).comment("To manipulate maximum exhaustion to jump up (>= 0)");
    public final Property _climbJumpExhaustion = this.Hard("move.jump.climb.exhaustion", new String[0]).depends(this._jumpExhaustion).comment("To switch on/off climb jump exhaustion").chapter(new String[0]);
    public final Property _climbJumpExhaustionGainFactor = SmartMovingConfig.PositiveFactor("move.climb.jump.exhaustion.gain.factor", new String[0]).comment("To manipulate the exhaustion increase by jumping while climbing (>= 0)");
    public final Property _climbJumpExhaustionStopFactor = SmartMovingConfig.PositiveFactor("move.climb.jump.exhaustion.stop.factor", new String[0]).comment("To manipulate maximum exhaustion to jumping while climbing (>= 0)");
    public final Property _climbJumpUpExhaustion = SmartMovingConfig.Unmodified("move.jump.climb.up.exhaustion", new String[0]).depends(this._climbJumpExhaustion).comment("To switch on/off climb up jump exhaustion").section(new String[0]);
    public final Property _climbJumpUpExhaustionGainFactor = SmartMovingConfig.PositiveFactor("move.jump.climb.up.exhaustion.gain.factor", new String[0]).defaults(java.lang.Float.valueOf(40.0f), new String[0]).defaults(java.lang.Float.valueOf(1.0f), _pre_sm_3_1).comment("To manipulate the exhaustion increase by a jump up while climbing (>= 0)");
    public final Property _climbJumpUpExhaustionStopFactor = SmartMovingConfig.PositiveFactor("move.jump.climb.up.exhaustion.stop.factor", new String[0]).defaults(java.lang.Float.valueOf(60.0f), new String[0]).defaults(java.lang.Float.valueOf(1.0f), _pre_sm_3_1).comment("To manipulate maximum exhaustion to jump up while climbing (>= 0)");
    public final Property _climbJumpBackUpExhaustion = SmartMovingConfig.Unmodified("move.jump.climb.back.up.exhaustion", new String[0]).depends(this._climbJumpExhaustion).comment("To switch on/off climb back jump exhaustion").section(new String[0]);
    public final Property _climbJumpBackUpExhaustionGainFactor = SmartMovingConfig.PositiveFactor("move.jump.climb.back.up.exhaustion.gain.factor", new String[0]).defaults(java.lang.Float.valueOf(40.0f), new String[0]).defaults(java.lang.Float.valueOf(1.0f), _pre_sm_3_1).comment("To manipulate the exhaustion increase by a jump back while climbing (>= 0)");
    public final Property _climbJumpBackUpExhaustionStopFactor = SmartMovingConfig.PositiveFactor("move.jump.climb.back.up.exhaustion.stop.factor", new String[0]).defaults(java.lang.Float.valueOf(60.0f), new String[0]).defaults(java.lang.Float.valueOf(1.0f), _pre_sm_3_1).comment("To manipulate maximum exhaustion to jump back while climbing (>= 0)");
    public final Property _climbJumpBackHeadExhaustion = SmartMovingConfig.Unmodified("move.jump.climb.back.head.exhaustion", new String[0]).depends(this._climbJumpExhaustion).comment("To switch on/off back climb head jump exhaustion").section(new String[0]);
    public final Property _climbJumpBackHeadExhaustionGainFactor = SmartMovingConfig.PositiveFactor("move.jump.climb.back.head.exhaustion.gain.factor", new String[0]).defaults(java.lang.Float.valueOf(20.0f), new String[0]).defaults(java.lang.Float.valueOf(1.0f), _pre_sm_3_1).comment("To manipulate the exhaustion increase by a head jump back while climbing (>= 0)");
    public final Property _climbJumpBackHeadExhaustionStopFactor = SmartMovingConfig.PositiveFactor("move.jump.climb.back.head.exhaustion.stop.factor", new String[0]).defaults(java.lang.Float.valueOf(80.0f), new String[0]).defaults(java.lang.Float.valueOf(1.0f), _pre_sm_3_1).comment("To manipulate maximum exhaustion to head jump back while climbing (>= 0)");
    public final Property _angleJumpExhaustion = SmartMovingConfig.Unmodified("move.jump.angle.exhaustion", new String[0]).depends(this._jumpExhaustion).comment("To switch on/off angle jump exhaustion").chapter(new String[0]);
    public final Property _angleJumpExhaustionGainFactor = SmartMovingConfig.PositiveFactor("move.jump.angle.exhaustion.gain.factor", new String[0]).comment("To manipulate the exhaustion increase by a jump to the side or back (>= 0)");
    public final Property _angleJumpExhaustionStopFactor = SmartMovingConfig.PositiveFactor("move.jump.angle.exhaustion.stop.factor", new String[0]).comment("To manipulate maximum exhaustion to jump to the side or back (>= 0)");
    public final Property _wallJumpExhaustion = this.Medium("move.jump.wall.exhaustion", new String[0]).depends(this._jumpExhaustion).comment("To switch on/off wall jump exhaustion").chapter(new String[0]);
    public final Property _wallJumpExhaustionGainFactor = SmartMovingConfig.PositiveFactor("move.jump.wall.exhaustion.gain.factor", new String[0]).comment("To manipulate the exhaustion increase by a wall jump (>= 0)");
    public final Property _wallJumpExhaustionStopFactor = SmartMovingConfig.PositiveFactor("move.jump.wall.exhaustion.stop.factor", new String[0]).comment("To manipulate maximum exhaustion to wall jump (>= 0)");
    public final Property _wallUpJumpExhaustion = SmartMovingConfig.Unmodified("move.jump.wall.up.exhaustion", new String[0]).depends(this._wallJumpExhaustion).comment("To switch on/off wall up jump exhaustion").section(new String[0]);
    public final Property _wallUpJumpExhaustionGainFactor = SmartMovingConfig.PositiveFactor("move.jump.wall.up.exhaustion.gain.factor", new String[0]).defaults(java.lang.Float.valueOf(40.0f), new String[0]).comment("To manipulate the exhaustion increase by a wall up jump (>= 0)");
    public final Property _wallUpJumpExhaustionStopFactor = SmartMovingConfig.PositiveFactor("move.jump.wall.up.exhaustion.stop.factor", new String[0]).defaults(java.lang.Float.valueOf(60.0f), new String[0]).comment("To manipulate maximum exhaustion to wall up jump (>= 0)");
    public final Property _wallHeadJumpExhaustion = SmartMovingConfig.Unmodified("move.jump.wall.head.exhaustion", new String[0]).depends(this._wallJumpExhaustion).comment("To switch on/off wall head jump exhaustion").section(new String[0]);
    public final Property _wallHeadJumpExhaustionGainFactor = SmartMovingConfig.PositiveFactor("move.jump.wall.head.exhaustion.gain.factor", new String[0]).defaults(java.lang.Float.valueOf(20.0f), new String[0]).comment("To manipulate the exhaustion increase by a wall head jump (>= 0)");
    public final Property _wallHeadJumpExhaustionStopFactor = SmartMovingConfig.PositiveFactor("move.jump.wall.head.exhaustion.stop.factor", new String[0]).defaults(java.lang.Float.valueOf(80.0f), new String[0]).comment("To manipulate maximum exhaustion to wall head jump (>= 0)");
    public final Property _standJumpExhaustion = this.Hard("move.jump.stand.exhaustion", new String[0]).depends(this._jumpExhaustion).source(this._old_jumpExhaustion, _pre_sm_1_7).comment("To switch on/off stand jump exhaustion").chapter(new String[0]);
    public final Property _standJumpExhaustionGainFactor = SmartMovingConfig.PositiveFactor("move.jump.stand.exhaustion.gain.factor", new String[0]).defaults(java.lang.Float.valueOf(40.0f), new String[0]).source(this._old_jumpExhaustionGain, _pre_sm_1_7).comment("To manipulate the exhaustion increase by a jump while standing (>= 0)");
    public final Property _standJumpExhaustionStopFactor = SmartMovingConfig.PositiveFactor("move.jump.stand.exhaustion.stop.factor", new String[0]).defaults(java.lang.Float.valueOf(60.0f), new String[0]).source(this._old_jumpExhaustionStop, _pre_sm_1_7).comment("To manipulate maximum exhaustion to jump while standing (>= 0)");
    public final Property _sneakJumpExhaustion = this.Hard("move.jump.sneak.exhaustion", new String[0]).depends(this._jumpExhaustion).source(this._old_sneakJumpExhaustion, _pre_sm_1_7).comment("To switch on/off sneak jump exhaustion").section(new String[0]);
    public final Property _sneakJumpExhaustionGainFactor = SmartMovingConfig.PositiveFactor("move.jump.sneak.exhaustion.gain.factor", new String[0]).up(java.lang.Float.valueOf(40.0f), this._standJumpExhaustionGainFactor).source(this._old_sneakJumpExhaustionGain, _pre_sm_1_7).comment("To manipulate the exhaustion increase by a jump while sneaking (>= \"move.jump.stand.exhaustion.gain.factor\")");
    public final Property _sneakJumpExhaustionStopFactor = SmartMovingConfig.PositiveFactor("move.jump.sneak.exhaustion.stop.factor", new String[0]).down(java.lang.Float.valueOf(60.0f), this._standJumpExhaustionStopFactor).source(this._old_sneakJumpExhaustionStop, _pre_sm_1_7).comment("To manipulate maximum exhaustion to jump while sneaking (>= 0, <= \"move.jump.stand.exhaustion.stop.factor\")");
    public final Property _walkJumpExhaustion = this.Hard("move.jump.walkexhaustion", new String[0]).depends(this._jumpExhaustion).source(this._old_jumpExhaustion, _pre_sm_1_7).comment("To switch on/off walk jump exhaustion").section(new String[0]);
    public final Property _walkJumpExhaustionGainFactor = SmartMovingConfig.PositiveFactor("move.jump.walk.exhaustion.gain.factor", new String[0]).up(java.lang.Float.valueOf(45.0f), this._sneakJumpExhaustionGainFactor).source(this._old_jumpExhaustionGain, _pre_sm_1_7).comment("To manipulate the exhaustion increase by a jump while walking (>= \"move.jump.sneak.exhaustion.gain.factor\")");
    public final Property _walkJumpExhaustionStopFactor = SmartMovingConfig.PositiveFactor("move.jump.walk.exhaustion.stop.factor", new String[0]).down(java.lang.Float.valueOf(55.0f), this._sneakJumpExhaustionStopFactor).source(this._old_jumpExhaustionStop, _pre_sm_1_7).comment("To manipulate maximum exhaustion to jump while walking (>= 0, <= \"move.jump.sneak.exhaustion.stop.factor\")");
    public final Property _runJumpExhaustion = this.Medium("move.jump.run.exhaustion", new String[0]).depends(this._jumpExhaustion).source(this._old_runJumpExhaustion, _pre_sm_1_7).comment("To switch on/off run jump exhaustion").section(new String[0]);
    public final Property _runJumpExhaustionGainFactor = SmartMovingConfig.PositiveFactor("move.jump.run.exhaustion.gain.factor", new String[0]).up(java.lang.Float.valueOf(60.0f), this._walkJumpExhaustionGainFactor).source(this._old_runJumpExhaustionGain, _pre_sm_1_7).comment("To manipulate the exhaustion increase by a jump while running (>= \"move.jump.walk.exhaustion.gain.factor\")");
    public final Property _runJumpExhaustionStopFactor = SmartMovingConfig.PositiveFactor("move.jump.run.exhaustion.stop.factor", new String[0]).down(java.lang.Float.valueOf(40.0f), this._walkJumpExhaustionStopFactor).source(this._old_runJumpExhaustionStop, _pre_sm_1_7).comment("To manipulate maximum exhaustion to jump while running (>= 0, <= \"move.jump.walk.exhaustion.stop.factor\")");
    public final Property _sprintJumpExhaustion = this.Medium("move.jump.sprint.exhaustion", new String[0]).depends(this._jumpExhaustion).source(this._old_sprintJumpExhaustion, _pre_sm_1_7).comment("To switch on/off sprint jump exhaustion").section(new String[0]);
    public final Property _sprintJumpExhaustionGainFactor = SmartMovingConfig.PositiveFactor("move.jump.sprint.exhaustion.gain.factor", new String[0]).up(java.lang.Float.valueOf(65.0f), this._runJumpExhaustionGainFactor).source(this._old_sprintJumpExhaustionGain, _pre_sm_1_7).comment("To manipulate the exhaustion increase by a jump while sprinting (>= \"move.jump.run.exhaustion.gain.factor\")");
    public final Property _sprintJumpExhaustionStopFactor = SmartMovingConfig.PositiveFactor("move.jump.sprint.exhaustion.stop.factor", new String[0]).down(java.lang.Float.valueOf(35.0f), this._runJumpExhaustionStopFactor).source(this._old_sprintJumpExhaustionStop, _pre_sm_1_7).comment("To manipulate maximum exhaustion to jump while sprinting (>= 0, <= \"move.jump.run.exhaustion.stop.factor\")");
    public final Property _jumpChargeExhaustion = this.Medium("move.jump.charge.exhaustion", new String[0]).depends(this._jumpExhaustion).defaults(true, _pre_sm_1_11).comment("To switch on/off up additional jump charge exhaustion").section(new String[0]);
    public final Property _jumpChargeExhaustionGainFactor = SmartMovingConfig.PositiveFactor("move.jump.charge.exhaustion.gain.factor", new String[0]).defaults(this.Value(java.lang.Float.valueOf(30.0f)), new String[0]).comment("To manipulate the additional exhaustion for the higher jump (>= 0, is multiplied with the actual charge factor)");
    public final Property _jumpChargeExhaustionStopFactor = SmartMovingConfig.PositiveFactor("move.jump.charge.exhaustion.stop.factor", new String[0]).defaults(this.Value(java.lang.Float.valueOf(30.0f)), new String[0]).comment("To manipulate the subtractional maximum exhaustion to jump higher (>= 0, is multiplied with the actual charge factor)");
    public final Property _jumpSlideExhaustion = this.Medium("move.jump.slide.exhaustion", new String[0]).depends(this._jumpExhaustion).defaults(true, _pre_sm_1_11).comment("To switch on/off slide jump exhaustion").section(new String[0]);
    public final Property _jumpSlideExhaustionGainFactor = SmartMovingConfig.PositiveFactor("move.jump.slide.exhaustion.gain.factor", new String[0]).defaults(this.Value(java.lang.Float.valueOf(10.0f)), new String[0]).comment("To manipulate the exhaustion increase by a slide jump (>= 0)");
    public final Property _jumpSlideExhaustionStopFactor = SmartMovingConfig.PositiveFactor("move.jump.slide.exhaustion.stop.factor", new String[0]).defaults(this.Value(java.lang.Float.valueOf(90.0f)), new String[0]).comment("To manipulate maximum exhaustion to slide jump (>= 0)");
    public final Property _baseExhautionGainFactor = SmartMovingConfig.PositiveFactor("move.exhaustion.gain.factor", new String[0]).comment("Exhaustion gain base factor, set to '0' to disable exhaustion (>= 0)").book("Exhaustion", "Below you find the options for the continuous exhaustion gain/loss factors.");
    public final Property _baseExhautionLossFactor = SmartMovingConfig.PositiveFactor("move.exhaustion.loss.factor", new String[0]).defaults(this.Value(java.lang.Float.valueOf(1.0f)).e(java.lang.Float.valueOf(1.2f)).h(java.lang.Float.valueOf(0.8f)), new String[0]).defaults(java.lang.Float.valueOf(1.0f), _pre_sm_1_5).comment("Exhaustion loss base factor (>= 0)");
    public final Property _sprintingExhautionLossFactor = SmartMovingConfig.PositiveFactor("move.exhaustion.sprint.loss.factor", new String[0]).defaults(java.lang.Float.valueOf(0.0f), new String[0]).comment("Smart sprinting exhaustion loss factor (>= 0)").section(new String[0]);
    public final Property _runningExhautionLossFactor = SmartMovingConfig.PositiveFactor("move.exhaustion.run.loss.factor", new String[0]).up(java.lang.Float.valueOf(0.5f), this._sprintingExhautionLossFactor).comment("Standard sprinting exhaustion loss factor while  (>= 0, >= \"move.exhaustion.sprint.loss.factor\")");
    public final Property _walkingExhautionLossFactor = SmartMovingConfig.PositiveFactor("move.exhaustion.walk.loss.factor", new String[0]).up(java.lang.Float.valueOf(1.0f), this._runningExhautionLossFactor).comment("Walking exhaustion loss factor (>= 0, >= \"move.exhaustion.run.loss.factor\")");
    public final Property _sneakingExhautionLossFactor = SmartMovingConfig.PositiveFactor("move.exhaustion.sneak.loss.factor", new String[0]).up(java.lang.Float.valueOf(1.5f), this._walkingExhautionLossFactor).defaults(java.lang.Float.valueOf(1.0f), "1.1").comment("Sneaking exhaustion loss factor (>= 0, >= \"move.exhaustion.walk.loss.factor\")");
    public final Property _standingExhautionLossFactor = SmartMovingConfig.PositiveFactor("move.exhaustion.stand.loss.factor", new String[0]).up(java.lang.Float.valueOf(2.0f), this._sneakingExhautionLossFactor.maximum(java.lang.Float.valueOf(1.0f))).comment("Standing exhaustion loss factor (>= 1, >= \"move.exhaustion.sneak.loss.factor\")");
    public final Property _fallExhautionLossFactor = SmartMovingConfig.PositiveFactor("move.exhaustion.fall.loss.factor", new String[0]).up(java.lang.Float.valueOf(2.5f), this._standingExhautionLossFactor).comment("Falling exhaustion loss factor (>= \"move.exhaustion.stand.loss.factor\")");
    public final Property _ceilClimbingExhaustionLossFactor = SmartMovingConfig.PositiveFactor("move.exhaustion.climb.ceiling.loss.factor", new String[0]).comment("Ceiling climbing exhaustion loss factor (>= 0)").section(new String[0]);
    public final Property _climbingExhaustionLossFactor = SmartMovingConfig.PositiveFactor("move.exhaustion.climb.loss.factor", new String[0]).comment("Climbing exhaustion loss factor (>= 0)");
    public final Property _crawlingExhaustionLossFactor = SmartMovingConfig.PositiveFactor("move.exhaustion.crawl.loss.factor", new String[0]).comment("Crawling exhaustion loss factor (>= 0)");
    public final Property _dippingExhaustionLossFactor = SmartMovingConfig.PositiveFactor("move.exhaustion.dip.loss.factor", new String[0]).comment("Water walking exhaustion loss factor (>= 0)");
    public final Property _swimmingExhaustionLossFactor = SmartMovingConfig.PositiveFactor("move.exhaustion.swim.loss.factor", new String[0]).comment("Swimming exhaustion loss factor (>= 0)");
    public final Property _divingExhaustionLossFactor = SmartMovingConfig.PositiveFactor("move.exhaustion.dive.loss.factor", new String[0]).comment("Diving exhaustion loss factor (>= 0)");
    public final Property _normalExhaustionLossFactor = SmartMovingConfig.PositiveFactor("move.exhaustion.normal.loss.factor", new String[0]).comment("Normal movement exhaustion loss factor (>= 0)");
    public final Property _exhaustionLossHunger = SmartMovingConfig.Unmodified("move.exhaustion.hunger", new String[0]).comment("Whether exhaustion loss increases hunger").section(new String[0]);
    public final Property _exhaustionLossHungerFactor = SmartMovingConfig.PositiveFactor("move.exhaustion.hunger.factor", new String[0]).defaults(this.Value(java.lang.Float.valueOf(0.05f)).e(java.lang.Float.valueOf(0.02f)).h(java.lang.Float.valueOf(0.08f)), new String[0]).defaults(java.lang.Float.valueOf(0.05f), _pre_sm_1_5).comment("How much hunger is generated for exhaustion loss (>= 0)");
    public final Property _exhaustionLossFoodLevelMinimum = SmartMovingConfig.Positive("move.exhaustion.food.minimum", new String[0]).defaults(java.lang.Float.valueOf(4.0f), new String[0]).comment("Until which food level exhaustion is continuously reduced");
    public final Property _hungerGain = this.Medium("move.hunger.gain", new String[0]).comment("To switch on/off hunger generation").book("Hunger", "Below you find all hunger gain options.");
    public final Property _baseHungerGainFactor = SmartMovingConfig.PositiveFactor("move.hunger.gain.factor", new String[0]).defaults(this.Value(java.lang.Float.valueOf(1.0f)).e(java.lang.Float.valueOf(0.8f)).h(java.lang.Float.valueOf(1.2f)), new String[0]).defaults(java.lang.Float.valueOf(1.0f), _pre_sm_1_5).comment("Hunger generation base factor (>= 0)");
    public final Property _sprintingHungerGainFactor = SmartMovingConfig.PositiveFactor("move.hunger.sprint.gain.factor", new String[0]).key("move.hunger.gain.sprint.factor", _pre_sm_1_3).comment("Smart sprinting hunger generation factor (>= 0)").section(new String[0]);
    public final Property _runningHungerGainFactor = SmartMovingConfig.PositiveFactor("move.hunger.run.gain.factor", new String[0]).key("move.hunger.gain.run.factor", _pre_sm_1_3).defaults(java.lang.Float.valueOf(10.0f), new String[0]).comment("Standard sprinting hunger generation factor (>= 0)");
    public final Property _walkingHungerGainFactor = SmartMovingConfig.PositiveFactor("move.hunger.walk.gain.factor", new String[0]).key("move.hunger.gain.walk.factor", _pre_sm_1_3).comment("Standard speed movement hunger generation factor (>= 0)");
    public final Property _sneakingHungerGainFactor = SmartMovingConfig.PositiveFactor("move.hunger.sneak.gain.factor", new String[0]).key("move.hunger.gain.sneak.factor", _pre_sm_1_3).comment("Sneaking hunger generation factor (>= 0)");
    public final Property _standingHungerGainFactor = SmartMovingConfig.PositiveFactor("move.hunger.stand.gain.factor", new String[0]).defaults(java.lang.Float.valueOf(0.0f), new String[0]).comment("Sneaking hunger generation factor (>= 0)");
    public final Property _climbingHungerGainFactor = SmartMovingConfig.PositiveFactor("move.hunger.climb.gain.factor", new String[0]).key("move.hunger.gain.climb.factor", _pre_sm_1_3).comment("Climbing hunger generation factor (>= 0)").section(new String[0]);
    public final Property _crawlingHungerGainFactor = SmartMovingConfig.PositiveFactor("move.hunger.crawl.gain.factor", new String[0]).key("move.hunger.gain.crawl.factor", _pre_sm_1_3).comment("Crawling hunger generation factor (>= 0)");
    public final Property _ceilClimbingHungerGainFactor = SmartMovingConfig.PositiveFactor("move.hunger.climb.gain.ceiling.factor", new String[0]).key("move.hunger.gain.climb.ceiling.factor", _pre_sm_1_3).comment("Ceiling climbing hunger generation factor (>= 0)");
    public final Property _swimmingHungerGainFactor = SmartMovingConfig.PositiveFactor("move.hunger.swim.gain.factor", new String[0]).key("move.hunger.gain.swim.factor", _pre_sm_1_3).defaults(java.lang.Float.valueOf(1.5f), new String[0]).comment("Swimming hunger generation factor (>= 0)");
    public final Property _divingHungerGainFactor = SmartMovingConfig.PositiveFactor("move.hunger.dive.gain.factor", new String[0]).key("move.hunger.gain.dive.factor", _pre_sm_1_3).defaults(java.lang.Float.valueOf(1.5f), new String[0]).comment("Diving hunger generation factor (>= 0)");
    public final Property _dippingHungerGainFactor = SmartMovingConfig.PositiveFactor("move.hunger.dip.gain.factor", new String[0]).key("move.hunger.gain.dip.factor", _pre_sm_1_3).defaults(java.lang.Float.valueOf(1.5f), new String[0]).comment("Water walking hunger generation factor (>= 0)");
    public final Property _normalHungerGainFactor = SmartMovingConfig.PositiveFactor("move.hunger.normal.gain.factor", new String[0]).key("move.hunger.gain.ground.factor", _pre_sm_1_3).comment("Normal movement hunger generation factor (>= 0)");
    public final Property _alwaysHungerGain = SmartMovingConfig.Positive("move.hunger.always.gain", new String[0]).defaults(this.Value(java.lang.Float.valueOf(0.0f)).h(java.lang.Float.valueOf(0.005f)), new String[0]).defaults(java.lang.Float.valueOf(0.0f), _pre_sm_1_5).comment("Basic hunger per tick (>= 0)").section(new String[0]);
    public final Property _usageSpeedFactor = SmartMovingConfig.DecreasingFactor("move.usage.speed.factor", new String[0]).defaults(java.lang.Float.valueOf(0.2f), new String[0]).comment("Speed factor while using an item, if not defined otherwise (>= 0 AND <= 1)").book("Item Usage", "Below you find the options to manipulate the speed factors additionally applied while using an item.");
    public final Property _usageSwordSpeedFactor = SmartMovingConfig.DecreasingFactor("move.usage.sword.speed.factor", new String[0]).defaults(this._usageSpeedFactor, new String[0]).comment("Speed factor while blocking with a sword (>= 0 AND <= 1, defaults to \"move.usage.speed.factor\" when not present)");
    public final Property _usageBowSpeedFactor = SmartMovingConfig.DecreasingFactor("move.usage.bow.speed.factor", new String[0]).defaults(this._usageSpeedFactor, new String[0]).comment("Speed factor while pulling back a bow (>= 0 AND <= 1, defaults to \"move.usage.speed.factor\" when not present)");
    public final Property _usageFoodSpeedFactor = SmartMovingConfig.DecreasingFactor("move.usage.food.speed.factor", new String[0]).defaults(this._usageSpeedFactor, new String[0]).comment("Speed factor while eating food (>= 0 AND <= 1, defaults to \"move.usage.speed.factor\" when not present)");
    public final Property _sprintDuringItemUsage = SmartMovingConfig.Modified("move.usage.sprint", new String[0]).comment("To switch on/off generic sprinting while using an item").section(new String[0]);
    public final Property _replaceRopeClimbing = SmartMovingConfig.Unmodified("move.mod.rope.replace.climb.rope", new String[0]).comment("Whether to replace the rope climbing of mod pack 'Ropes+'").book("Mod compatibility", "Below you find the options to manipulate how Smart Moving should interact with other mods");
    public final Property _survivalConfigKeys = SmartMovingConfig.Strings("move.config.survival.keys", new String[0]).singular().defaults(new String[]{"e", "m", "h"}, new String[0]).comment("A list of survival option configuration keys, entries seperated by ','").book("Configuration Management", "Below you find the options to define multiple configuration option sets");
    public final Property _survivalDefaultConfigKey = SmartMovingConfig.String("move.config.survival.keys.default", new String[0]).singular().defaults("m", new String[0]).comment("The option configuration to start the next minecraft survival game with (can also be modified via in-game option configuration toggling)");
    public final Property _creativeConfigKeys = SmartMovingConfig.Strings("move.config.creative.keys", new String[0]).singular().defaults(new String[]{"c"}, new String[0]).defaults(new String[0], _pre_sm_2_3).comment("A list of creative option configuration keys, entries seperated by ','").section(new String[0]);
    public final Property _creativeDefaultConfigKey = SmartMovingConfig.String("move.config.creative.keys.default", new String[0]).singular().defaults("c", new String[0]).defaults("", _pre_sm_2_3).comment("The option configuration to start the next minecraft creative game with (can also be modified via in-game option configuration toggling)");
    public final Property _adventureConfigKeys = SmartMovingConfig.Strings("move.config.adventure.keys", new String[0]).singular().defaults(new String[]{"e", "m", "h"}, new String[0]).comment("A list of adventure option configuration keys, entries seperated by ','").section(new String[0]);
    public final Property _adventureDefaultConfigKey = SmartMovingConfig.String("move.config.adventure.keys.default", new String[0]).singular().defaults("m", new String[0]).comment("The option configuration to start the next minecraft adventure game with (can also be modified via in-game option configuration toggling)");
    public final Property _configKeyName = SmartMovingConfig.String("move.config.key.name", new String[0]).defaults(this.Value((String)null).e("Easy").m("Medium").h("Hard"), new String[0]).comment("The display names of the option configuration keys").section(new String[0]);
    public final Property _serverConfig = SmartMovingConfig.Modified("move.server.config", new String[0]).singular().comment("Whether the players on this server should be forced to use the configurations on this server").book("Server Management", "Below you find the options to manage your server");
    public final Property _survivalDefaultConfigUserKeys = SmartMovingConfig.StringMap("move.server.config.survival.user.keys", new String[0]).singular().comment("The option configuration to start the player's next minecraft survival game with (can also be modified via in-game option configuration toggling)").section(new String[0]);
    public final Property _creativeDefaultConfigUserKeys = SmartMovingConfig.StringMap("move.server.config.creative.user.keys", new String[0]).singular().comment("The option configuration to start the player's next minecraft creative game with (can also be modified via in-game option configuration toggling)");
    public final Property _adventureDefaultConfigUserKeys = SmartMovingConfig.StringMap("move.server.config.adventure.user.keys", new String[0]).singular().comment("The option configuration to start the player's next minecraft adventure game with (can also be modified via in-game option configuration toggling)");
    public final Property _speedUsersExponents = SmartMovingConfig.IntegerMap("move.server.speed.user.exponents", new String[0]).singular().comment("The user specific exponents for in-game speed manipulation");
    public final Property _globalConfig = SmartMovingConfig.Modified("move.global.config", new String[0]).key("move.config.overwrite", _pre_sm_3_0).key("move.config.send", _pre_sm_2_2).singular().depends(this._serverConfig).comment("Whether all players on this server should be forced to use the same global configuration (Relevant only if \"move.server.config\" is true)").section(new String[0]);
    public final Property _usersWithChangeConfigRights = SmartMovingConfig.Strings("move.global.config.right.user.names", new String[0]).singular().comment("The names of the users that have the right to change the global configuraton in-game, entries seperated by ','").section(new String[0]);
    public final Property _usersWithChangeSpeedRights = SmartMovingConfig.Strings("move.global.speed.right.user.names", new String[0]).singular().comment("The names of the users that have the right to change the global speed in-game, entries seperated by ','");
    protected static final int Unknown = -1;
    protected static final int Survival = 0;
    protected static final int Creative = 1;
    protected static final int Adventure = 2;
    private static final DecimalFormat formatter = new DecimalFormat("0.############################################################");
    private static final BigDecimal ten = new BigDecimal(10);
    public static final Object defaultSpeedPercent = "100";

    public void changeSpeed(int n) {
        this._speedUserExponent.setValue((Integer)this._speedUserExponent.value + n);
    }

    public boolean isUserSpeedEnabled() {
        return this.enabled && (Boolean)this._speedUser.value != false;
    }

    public boolean isUserSpeedAlwaysDefault() {
        return (Boolean)this._speedUser.value == false || ((Float)this._speedUserFactor.value).floatValue() == 1.0f;
    }

    public float getUserSpeedFactor() {
        return !this.isUserSpeedAlwaysDefault() && (Integer)this._speedUserExponent.value != 0 ? (float)Math.pow(1.0f + ((Float)this._speedUserFactor.value).floatValue(), ((Integer)this._speedUserExponent.value).intValue()) : 1.0f;
    }

    protected void loadFromProperties(Properties properties) {
        try {
            this.load(properties);
        }
        catch (Exception exception) {
            throw new RuntimeException("Could not load Smart Moving properties from properties", exception);
        }
    }

    protected void writeToProperties(Properties properties, List list2) {
        try {
            this.write(properties);
            if (list2 != null) {
                for (int i = 0; i < list2.size(); ++i) {
                    String string = ((Property)list2.get(i)).getCurrentKey();
                    if (string == null) continue;
                    properties.remove(string);
                }
            }
        }
        catch (Exception exception) {
            throw new RuntimeException("Could not write Smart Moving properties to properties", exception);
        }
    }

    protected void loadOptionsFromAssets() {
        ResourceLocation resourceLocation = new ResourceLocation("smartmoving", "options.txt");
        Properties properties = new Properties(resourceLocation);
        try {
            this.load(properties);
        }
        catch (Exception exception) {
            throw new RuntimeException("Could not load Smart Moving properties from file", exception);
        }
    }

    protected void saveToOptionsFile(File file) {
        boolean bl = FileWriteBlocker.getBlockFileWrite();
        if (bl) {
            return;
        }
        try {
            this.save(new File(file, _smartMovingPropertiesFileName), "3.2", true, true);
        }
        catch (Exception exception) {
            throw new RuntimeException("Could not save Smart Moving properties to file", exception);
        }
    }

    @Override
    protected void printHeader(PrintWriter printWriter) {
        printWriter.println("#######################################################################");
        printWriter.println("#");
        printWriter.println("# Smart Moving mod configuration file");
        printWriter.println("# -----------------------------------");
        printWriter.println("#");
        printWriter.println("# Modify the values behind the keys in this file to configure the");
        printWriter.println("# Smart Moving behavior as you like it.");
        printWriter.println("#");
        printWriter.println("# * All options you leave at their default value will be automatically");
        printWriter.println("#   updated when the default value is updated with a new version of");
        printWriter.println("#   Smart Moving options.");
        printWriter.println("#");
        printWriter.println("# * All options you modify will stay the same over the upgrade cycles");
        printWriter.println("#   as long as they still fall in the allowed range.");
        printWriter.println("#");
        printWriter.println("# * The character '!' will be used after the value's text's end to");
        printWriter.println("#   mark a value that has originally been modified but became the");
        printWriter.println("#   default value at some point in the update process to avoid it being");
        printWriter.println("#   updated too with the next default value change.");
        printWriter.println("#");
        printWriter.println("# * The '!' mark can also be used to create a 'modified' and so not");
        printWriter.println("#   automatically updated value identical to the current default value");
        printWriter.println("#");
        printWriter.println("# Additionally you can create multiple option configurations and define");
        printWriter.println("# separate option values for each configuration.");
        printWriter.println("#");
        printWriter.println("# * key-value separator is ':'");
        printWriter.println("# * key-value-pair separator is ';'");
        printWriter.println("# * a value without key will become the default value");
        printWriter.println("#");
        printWriter.println("#######################################################################");
        printWriter.println();
    }

    @Override
    protected void printVersion(PrintWriter printWriter, String string, boolean bl) {
        if (bl) {
            printWriter.println("# The current version of this Smart Moving options file");
        }
        printWriter.print("move.options.version");
        printWriter.print(":");
        printWriter.print(string);
        printWriter.println();
    }

    private Property Creative(String string, String ... stringArray) {
        return SmartMovingConfig.Modified(string, stringArray).defaults(this.Value(false).c(true), new String[0]);
    }

    private Property Hard(String string, String ... stringArray) {
        return SmartMovingConfig.Modified(string, stringArray).defaults(this.Value(false).h(true), new String[0]).defaults(false, _pre_sm_1_5);
    }

    private Property Medium(String string, String ... stringArray) {
        return SmartMovingConfig.Unmodified(string, stringArray).defaults(this.Value(true).e(false), new String[0]).defaults(true, _pre_sm_1_5);
    }

    public Object getSpeedPercent() {
        float f;
        int n = 0;
        for (f = this.getUserSpeedFactor() * 100.0f; f < 100.0f; f *= 10.0f) {
            ++n;
        }
        int n2 = Math.round(f);
        BigDecimal bigDecimal = new BigDecimal(n2);
        while (n-- > 0) {
            bigDecimal = bigDecimal.divide(ten);
        }
        return formatter.format(bigDecimal);
    }
}

