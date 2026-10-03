/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.config;

import java.io.File;
import java.lang.reflect.Field;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.world.EnumGameType;
import net.smart.moving.config.SmartMovingClientConfig;
import net.smart.moving.config.SmartMovingConfig;
import net.smart.properties.Property;
import net.smart.utilities.Install;
import net.smart.utilities.Reflect;

public class SmartMovingOptions
extends SmartMovingClientConfig {
    public final Property _localUserHasChangeConfigRight = SmartMovingOptions.Unmodified("move.global.config.right.local.user", new String[0]).comment("Whether the current local user has the right to change the global configuration in-game (despite of the names listed in \"move.global.config.right.user.names\"").section(new String[0]);
    public final Property _localUserHasChangeSpeedRight = SmartMovingOptions.Unmodified("move.global.speed.right.local.user", new String[0]).comment("Whether the current local user has the right to change the global speed in-game (despite of the names listed in \"move.global.config.right.user.names\"");
    public final Property _perspectiveFadeFactor = SmartMovingOptions.PositiveFactor("move.perspective.fade.factor", new String[0]).values(java.lang.Float.valueOf(0.5f), java.lang.Float.valueOf(0.1f), java.lang.Float.valueOf(1.0f)).comment("Fading speed factor between the different perspectives (>= 0.1, <= 1, set to '1' to switch off)").book("Viewpoint perspective", "Below you find the options to manipulate the viewpoint perspective");
    public final Property _perspectiveRunFactor = SmartMovingOptions.Float("move.perspective.run.factor", new String[0]).key("move.run.perspective.factor", SmartMovingConfig._pre_sm_2_1).defaults(java.lang.Float.valueOf(1.0f), new String[0]).comment("Standard sprinting perspective (set to '0' to switch off)");
    public final Property _perspectiveSprintFactor = SmartMovingOptions.Float("move.perspective.sprint.factor", new String[0]).key("move.sprint.perspective.factor", SmartMovingConfig._pre_sm_2_1).defaults(java.lang.Float.valueOf(1.5f), new String[0]).comment("Smart on ground sprinting perspective (set to '0' to switch off)");
    public final Property _angleJumpDoubleClickTicks = SmartMovingOptions.Positive("move.jump.angle.double.click.ticks", new String[0]).singular().up(java.lang.Float.valueOf(3.0f), java.lang.Float.valueOf(2.0f)).comment("The maximum number of ticks between two clicks to trigger a side or back jump (>= 2)").book("User interface", "Below you find the options to manipulate Smart Moving's user interface");
    public final Property _wallJumpDoubleClick = SmartMovingOptions.Unmodified("move.jump.wall.double.click", new String[0]).singular().comment("Whether wall jumping should be triggered by single or double clicking (and then press and holding) the jump button").section(new String[0]);
    public final Property _wallJumpDoubleClickTicks = SmartMovingOptions.Positive("move.jump.wall.double.click.ticks", new String[0]).singular().up(java.lang.Float.valueOf(3.0f), java.lang.Float.valueOf(2.0f)).comment("The maximum number of ticks between two clicks to trigger a wall jump (>= 2, depends on \"move.jump.wall.double.click\")");
    public final Property _climbJumpBackHeadOnGrab = SmartMovingOptions.Unmodified("move.jump.climb.back.head.on.grab", new String[0]).singular().comment("Whether pressing or not pressing the grab button while climb jumping back results in a head jump").section(new String[0]);
    public final Property _displayExhaustionBar = SmartMovingOptions.Unmodified("move.gui.exhaustion.bar", new String[0]).singular().comment("Whether to display the exhaustion bar in the game overlay").section(new String[0]);
    public final Property _displayJumpChargeBar = SmartMovingOptions.Unmodified("move.gui.jump.charge.bar", new String[0]).singular().comment("Whether to display the jump charge bar in the game overlay");
    public final Property _sneakToggle = SmartMovingOptions.Modified("move.sneak.toggle", new String[0]).comment("To switch on/off sneak toggling").section(new String[0]);
    public final Property _crawlToggle = SmartMovingOptions.Modified("move.crawl.toggle", new String[0]).comment("To switch on/off crawl toggling");
    public final Property _flyCloseToGround = SmartMovingOptions.Modified("move.fly.ground.close", new String[0]).comment("To switch on/off flying close to the ground").section(new String[0]);
    public final Property _flyWhileOnGround = SmartMovingOptions.Modified("move.fly.ground.collide", new String[0]).depends(this._flyCloseToGround).comment("To switch on/off flying while colliding with the grond (Relevant only if \"move.fly.ground.close\" is true)");
    public final Property _flyControlVertical = SmartMovingOptions.Unmodified("move.fly.control.vertical", new String[0]).comment("Whether flying control also depends on where the player looks vertically.").section(new String[0]);
    public final Property _diveControlVertical = SmartMovingOptions.Unmodified("move.dive.control.vertical", new String[0]).comment("Whether diving control also depends on where the player looks vertically.");
    private final Property _old_toggleKeyCode = SmartMovingOptions.Integer("move.toggle.key", SmartMovingConfig._pre_sm_1_7).singular().defaults(67, new String[0]);
    private final Property _defaultConfigToggleKeyName = SmartMovingOptions.String("move.config.toggle.default.key.name", new String[0]).key("move.toggle.key.name", SmartMovingConfig._pre_sm_3_2).singular().defaults("F9", new String[0]).source(this._old_toggleKeyCode.toKeyName(), SmartMovingConfig._pre_sm_1_7).singular().comment("Key name to toggle Smart Moving features in-game (default: \"F9\")").section(new String[0]);
    private final Property _defaultGrabKeyName = SmartMovingOptions.String("move.grab.default.key.name", new String[0]).singular().defaults("LCONTROL", new String[0]).singular().comment("Default key name to \"grab\" (default: \"LCONTROL\")");
    private final Property _defaultSprintKeyName = SmartMovingOptions.String("move.sprint.default.key.name", new String[0]).singular().defaults("TAB", new String[0]).singular().comment("Default key name to \"sprint\" (default: \"TAB\")");
    private final Property _speedIncreaseKeyName = SmartMovingOptions.String("move.speed.increase.default.key.name", new String[0]).key("move.speed.increase.key.name", SmartMovingConfig._pre_sm_3_2).singular().defaults("O", new String[0]).singular().comment("Key name to increase the moving speed ingame (default: \"O\")");
    private final Property _speedDecreaseKeyName = SmartMovingOptions.String("move.speed.decrease.default.key.name", new String[0]).key("move.speed.decrease.key.name", SmartMovingConfig._pre_sm_3_2).singular().defaults("I", new String[0]).singular().comment("Key name to decrease the moving speed ingame (default: \"I\")");
    public final Property _defaultConfigToggleKeyCode = this._defaultConfigToggleKeyName.toKeyCode(67);
    public final Property _defaultGrabKeyCode = this._defaultGrabKeyName.toKeyCode(29);
    public final Property _defaultSprintKeyCode = this._defaultSprintKeyName.toKeyCode(15);
    public final Property _defaultSpeedIncreaseKeyCode = this._speedIncreaseKeyName.toKeyCode(24);
    public final Property _defaultSpeedDecreaseKeyCode = this._speedDecreaseKeyName.toKeyCode(23);
    public final Property _configChat = SmartMovingOptions.Unmodified("move.config.chat", new String[0]).singular().comment("To switch on/off option status messages via chat system").book("Message Management", "Below you find the options to define in which case Smart Moving should write messages about its current behavior to the ingame chat");
    public final Property _configChatInit = SmartMovingOptions.Unmodified("move.config.chat.init", new String[0]).depends(this._configChat).singular().comment("To switch on/off the initial option status message when starting a game (Relevant only if \"move.config.chat\" is not false)");
    public final Property _configChatInitHelp = SmartMovingOptions.Unmodified("move.config.chat.init.help", new String[0]).depends(this._configChatInit).singular().comment("To switch on/off the initial option help message (Relevant only if \"move.config.chat.init\" is not false and no improved keybinding GUI (Minecraft Forge or the Macros/Keybind mod) is installed)");
    public final Property _configChatServer = SmartMovingOptions.Unmodified("move.config.chat.server", new String[0]).depends(this._configChat).singular().comment("To switch on/off the server config overridden status message when joining a multiplayer game (Relevant only if \"move.config.chat\" is not false)");
    public final Property _speedChat = SmartMovingOptions.Unmodified("move.speed.chat", new String[0]).singular().comment("To switch on/off speed messages via chat system").section(new String[0]);
    public final Property _speedChatInit = SmartMovingOptions.Unmodified("move.speed.chat.init", new String[0]).depends(this._speedChat).singular().comment("To switch on/off the intial speed message when starting a game (Relevant only if \"move.speed.chat\" is not false)");
    public final Property _speedChatInitHelp = SmartMovingOptions.Unmodified("move.speed.chat.init.help", new String[0]).depends(this._speedChatInit).singular().comment("To switch on/off the initial speed help message (Relevant only if \"move.speed.chat.init\" is not false and no improved keybinding GUI (Minecraft Forge or the Macros/Keybind mod) is installed))");
    public final Property _speedChatServer = SmartMovingOptions.Unmodified("move.config.chat.server", new String[0]).depends(this._speedChat).singular().comment("To switch on/off the server speed change message when joining a multiplayer game (Relevant only if \"move.speed.chat\" is not false)");
    public KeyBinding keyBindGrab;
    public KeyBinding keyBindSprint;
    public KeyBinding keyBindConfigToggle;
    public KeyBinding keyBindSpeedIncrease;
    public KeyBinding keyBindSpeedDecrease;
    public KeyBinding keyBindCrawl;
    public static File optionsPath;
    public static boolean hasRedPowerWire;
    public static boolean hasBuildCraftTransportation;
    public static boolean hasFiniteLiquid;
    public static boolean hasBetterThanWolves;
    public static boolean hasSinglePlayerCommands;
    public static boolean hasRopesPlus;
    public static boolean hasASGrapplingHook;
    public static boolean hasBetterMisc;
    public static boolean hasMoreKeyBindingGui;
    public int gameType;
    private static Field _currentGameType;
    private static final boolean DUMP_OPTIONS;

    public SmartMovingOptions() {
        this.loadOptionsFromAssets();
        if (DUMP_OPTIONS) {
            this.saveToOptionsFile(new File("."));
        }
        this.keyBindGrab = new KeyBinding("key.climb", (Integer)this._defaultGrabKeyCode.value);
        this.keyBindSprint = new KeyBinding("key.sprint", (Integer)this._defaultSprintKeyCode.value);
        this.keyBindConfigToggle = new KeyBinding("key.config.toggle", (Integer)this._defaultConfigToggleKeyCode.value);
        this.keyBindSpeedIncrease = new KeyBinding("key.speed.increase", (Integer)this._defaultSpeedIncreaseKeyCode.value);
        this.keyBindSpeedDecrease = new KeyBinding("key.speed.decrease", (Integer)this._defaultSpeedDecreaseKeyCode.value);
        this.keyBindCrawl = new KeyBinding("\u041b\u0435\u0447\u044c/\u0412\u0441\u0442\u0430\u0442\u044c", 44);
    }

    public boolean isSneakToggleEnabled() {
        return (Boolean)this._sneakToggle.value != false && this.enabled;
    }

    public boolean isCrawlToggleEnabled() {
        return (Boolean)this._crawlToggle.value != false && this.enabled;
    }

    public int angleJumpDoubleClickTicks() {
        return (int)Math.ceil(((Float)this._angleJumpDoubleClickTicks.value).floatValue());
    }

    public int wallJumpDoubleClickTicks() {
        return (int)Math.ceil(((Float)this._wallJumpDoubleClickTicks.value).floatValue());
    }

    public static void initialize(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        hasRedPowerWire = bl;
        hasBuildCraftTransportation = bl2;
        hasFiniteLiquid = bl3;
        hasBetterThanWolves = bl4;
        hasSinglePlayerCommands = bl5;
        hasRopesPlus = bl6;
        hasASGrapplingHook = bl7;
        hasBetterMisc = bl8;
        boolean bl9 = Reflect.LoadClass(Minecraft.class, Install.MacroModCore, false) != null;
        boolean bl10 = Reflect.LoadClass(Minecraft.class, Install.ForgeHooksClient, false) != null;
        hasMoreKeyBindingGui = bl9 || bl10;
    }

    public void resetForNewGame() {
        this.gameType = -1;
    }

    public void initializeForGameIfNeccessary() {
        int n = ((EnumGameType)((Object)Reflect.GetField(_currentGameType, Minecraft._E()._j)))._a();
        if (n != this.gameType) {
            this.gameType = n;
            String[] stringArray = null;
            String string = null;
            switch (this.gameType) {
                case 0: {
                    stringArray = (String[])this._survivalConfigKeys.value;
                    string = (String)this._survivalDefaultConfigKey.value;
                    break;
                }
                case 1: {
                    stringArray = (String[])this._creativeConfigKeys.value;
                    string = (String)this._creativeDefaultConfigKey.value;
                    break;
                }
                case 2: {
                    stringArray = (String[])this._adventureConfigKeys.value;
                    string = (String)this._adventureDefaultConfigKey.value;
                    break;
                }
                default: {
                    string = "";
                }
            }
            this.setKeys(stringArray);
            if (!string.isEmpty()) {
                this.setCurrentKey(string);
            }
        }
    }

    static {
        hasRedPowerWire = false;
        hasBuildCraftTransportation = false;
        hasFiniteLiquid = false;
        hasBetterThanWolves = false;
        hasSinglePlayerCommands = false;
        hasRopesPlus = false;
        hasASGrapplingHook = false;
        hasBetterMisc = false;
        hasMoreKeyBindingGui = false;
        _currentGameType = Reflect.GetField(vlzh.class, Install.PlayerControllerMP_currentGameType);
        DUMP_OPTIONS = System.getProperty("smartmoving.dump_options", "true").equals("true");
    }
}

