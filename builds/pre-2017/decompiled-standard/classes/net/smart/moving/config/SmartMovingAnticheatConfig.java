/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.config;

import net.smart.moving.SmartMovingContext;
import net.smart.moving.config.SmartMovingClientConfig;
import net.smart.moving.config.SmartMovingConfig;
import net.smart.properties.Property;

public class SmartMovingAnticheatConfig
extends SmartMovingClientConfig {
    public static SmartMovingAnticheatConfig instance = new SmartMovingAnticheatConfig();
    public final Property _localUserHasChangeConfigRight = SmartMovingAnticheatConfig.Unmodified("move.global.config.right.local.user", new String[0]).comment("Whether the current local user has the right to change the global configuration in-game (despite of the names listed in \"move.global.config.right.user.names\"").section(new String[0]);
    public final Property _localUserHasChangeSpeedRight = SmartMovingAnticheatConfig.Unmodified("move.global.speed.right.local.user", new String[0]).comment("Whether the current local user has the right to change the global speed in-game (despite of the names listed in \"move.global.config.right.user.names\"");
    public final Property _perspectiveFadeFactor = SmartMovingAnticheatConfig.PositiveFactor("move.perspective.fade.factor", new String[0]).values(java.lang.Float.valueOf(0.5f), java.lang.Float.valueOf(0.1f), java.lang.Float.valueOf(1.0f)).comment("Fading speed factor between the different perspectives (>= 0.1, <= 1, set to '1' to switch off)").book("Viewpoint perspective", "Below you find the options to manipulate the viewpoint perspective");
    public final Property _perspectiveRunFactor = SmartMovingAnticheatConfig.Float("move.perspective.run.factor", new String[0]).key("move.run.perspective.factor", SmartMovingConfig._pre_sm_2_1).defaults(java.lang.Float.valueOf(1.0f), new String[0]).comment("Standard sprinting perspective (set to '0' to switch off)");
    public final Property _perspectiveSprintFactor = SmartMovingAnticheatConfig.Float("move.perspective.sprint.factor", new String[0]).key("move.sprint.perspective.factor", SmartMovingConfig._pre_sm_2_1).defaults(java.lang.Float.valueOf(1.5f), new String[0]).comment("Smart on ground sprinting perspective (set to '0' to switch off)");
    public final Property _angleJumpDoubleClickTicks = SmartMovingAnticheatConfig.Positive("move.jump.angle.double.click.ticks", new String[0]).singular().up(java.lang.Float.valueOf(3.0f), java.lang.Float.valueOf(2.0f)).comment("The maximum number of ticks between two clicks to trigger a side or back jump (>= 2)").book("User interface", "Below you find the options to manipulate Smart Moving's user interface");
    public final Property _wallJumpDoubleClick = SmartMovingAnticheatConfig.Unmodified("move.jump.wall.double.click", new String[0]).singular().comment("Whether wall jumping should be triggered by single or double clicking (and then press and holding) the jump button").section(new String[0]);
    public final Property _wallJumpDoubleClickTicks = SmartMovingAnticheatConfig.Positive("move.jump.wall.double.click.ticks", new String[0]).singular().up(java.lang.Float.valueOf(3.0f), java.lang.Float.valueOf(2.0f)).comment("The maximum number of ticks between two clicks to trigger a wall jump (>= 2, depends on \"move.jump.wall.double.click\")");
    public final Property _climbJumpBackHeadOnGrab = SmartMovingAnticheatConfig.Unmodified("move.jump.climb.back.head.on.grab", new String[0]).singular().comment("Whether pressing or not pressing the grab button while climb jumping back results in a head jump").section(new String[0]);
    public final Property _displayExhaustionBar = SmartMovingAnticheatConfig.Unmodified("move.gui.exhaustion.bar", new String[0]).singular().comment("Whether to display the exhaustion bar in the game overlay").section(new String[0]);
    public final Property _displayJumpChargeBar = SmartMovingAnticheatConfig.Unmodified("move.gui.jump.charge.bar", new String[0]).singular().comment("Whether to display the jump charge bar in the game overlay");
    public final Property _sneakToggle = SmartMovingAnticheatConfig.Modified("move.sneak.toggle", new String[0]).comment("To switch on/off sneak toggling").section(new String[0]);
    public final Property _crawlToggle = SmartMovingAnticheatConfig.Modified("move.crawl.toggle", new String[0]).comment("To switch on/off crawl toggling");
    public final Property _flyCloseToGround = SmartMovingAnticheatConfig.Modified("move.fly.ground.close", new String[0]).comment("To switch on/off flying close to the ground").section(new String[0]);
    public final Property _flyWhileOnGround = SmartMovingAnticheatConfig.Modified("move.fly.ground.collide", new String[0]).depends(this._flyCloseToGround).comment("To switch on/off flying while colliding with the grond (Relevant only if \"move.fly.ground.close\" is true)");
    public final Property _flyControlVertical = SmartMovingAnticheatConfig.Unmodified("move.fly.control.vertical", new String[0]).comment("Whether flying control also depends on where the player looks vertically.").section(new String[0]);
    public final Property _diveControlVertical = SmartMovingAnticheatConfig.Unmodified("move.dive.control.vertical", new String[0]).comment("Whether diving control also depends on where the player looks vertically.");
    public final Property _configChat = SmartMovingAnticheatConfig.Unmodified("move.config.chat", new String[0]).singular().comment("To switch on/off option status messages via chat system").book("Message Management", "Below you find the options to define in which case Smart Moving should write messages about its current behavior to the ingame chat");
    public final Property _configChatInit = SmartMovingAnticheatConfig.Unmodified("move.config.chat.init", new String[0]).depends(this._configChat).singular().comment("To switch on/off the initial option status message when starting a game (Relevant only if \"move.config.chat\" is not false)");
    public final Property _configChatInitHelp = SmartMovingAnticheatConfig.Unmodified("move.config.chat.init.help", new String[0]).depends(this._configChatInit).singular().comment("To switch on/off the initial option help message (Relevant only if \"move.config.chat.init\" is not false and no improved keybinding GUI (Minecraft Forge or the Macros/Keybind mod) is installed)");
    public final Property _configChatServer = SmartMovingAnticheatConfig.Unmodified("move.config.chat.server", new String[0]).depends(this._configChat).singular().comment("To switch on/off the server config overridden status message when joining a multiplayer game (Relevant only if \"move.config.chat\" is not false)");
    public final Property _speedChat = SmartMovingAnticheatConfig.Unmodified("move.speed.chat", new String[0]).singular().comment("To switch on/off speed messages via chat system").section(new String[0]);
    public final Property _speedChatInit = SmartMovingAnticheatConfig.Unmodified("move.speed.chat.init", new String[0]).depends(this._speedChat).singular().comment("To switch on/off the intial speed message when starting a game (Relevant only if \"move.speed.chat\" is not false)");
    public final Property _speedChatInitHelp = SmartMovingAnticheatConfig.Unmodified("move.speed.chat.init.help", new String[0]).depends(this._speedChatInit).singular().comment("To switch on/off the initial speed help message (Relevant only if \"move.speed.chat.init\" is not false and no improved keybinding GUI (Minecraft Forge or the Macros/Keybind mod) is installed))");
    public final Property _speedChatServer = SmartMovingAnticheatConfig.Unmodified("move.config.chat.server", new String[0]).depends(this._speedChat).singular().comment("To switch on/off the server speed change message when joining a multiplayer game (Relevant only if \"move.speed.chat\" is not false)");
    public final Property concentrationExhaustion = SmartMovingAnticheatConfig.Float("aim.concentration.exhaustion", new String[0]);
    public final Property crawlingEndMaxExhaustion = SmartMovingAnticheatConfig.Float("crawl.end.exhaustion.max", new String[0]);
    public final Property crawlingEndExhaustion = SmartMovingAnticheatConfig.Float("crawl.end.exhaustion.cost", new String[0]);
    public static boolean hasRedPowerWire = false;
    public static boolean hasBuildCraftTransportation = false;
    public static boolean hasFiniteLiquid = false;
    public static boolean hasBetterThanWolves = false;
    public static boolean hasSinglePlayerCommands = false;
    public static boolean hasRopesPlus = false;
    public static boolean hasASGrapplingHook = false;
    public static boolean hasBetterMisc = false;
    public static boolean hasMoreKeyBindingGui = false;

    public SmartMovingAnticheatConfig() {
        this.loadOptionsFromAssets();
    }

    public boolean isSneakToggleEnabled() {
        return (Boolean)this._sneakToggle.value != false && this.enabled;
    }

    public boolean isCrawlToggleEnabled() {
        return true;
    }

    public int angleJumpDoubleClickTicks() {
        return (int)Math.ceil(((Float)this._angleJumpDoubleClickTicks.value).floatValue());
    }

    public int wallJumpDoubleClickTicks() {
        return (int)Math.ceil(((Float)this._wallJumpDoubleClickTicks.value).floatValue());
    }

    public float getMaximumUpJumpCharge() {
        return ((Float)SmartMovingContext.Config._jumpChargeMaximum.value).floatValue();
    }

    public float getMaximumHeadJumpCharge() {
        return ((Float)SmartMovingContext.Config._headJumpChargeMaximum.value).floatValue();
    }

    public float getMaximumExhaustion() {
        return SmartMovingContext.Config.getMaxExhaustion();
    }

    public float getConcentrationExhaustion() {
        return this.concentrationExhaustion.value != null ? 1.0f : ((Float)this.concentrationExhaustion.value).floatValue();
    }
}

