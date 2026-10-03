/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.user;

import eu.ha3.easy.TimeStatistic;
import eu.ha3.matmos.conv.MAtmosConvLogger;
import eu.ha3.matmos.game.gui.MAtGuiMenu;
import eu.ha3.matmos.game.system.MAtMod;
import eu.ha3.matmos.game.system.MAtModPhase;
import eu.ha3.matmos.game.user.MAtScroller;
import eu.ha3.mc.convenience.Ha3HoldActions;
import eu.ha3.mc.convenience.Ha3KeyHolding;
import eu.ha3.mc.convenience.Ha3KeyManager;
import eu.ha3.mc.haddon.SupportsFrameEvents;
import eu.ha3.mc.haddon.SupportsKeyEvents;
import eu.ha3.mc.haddon.SupportsTickEvents;
import eu.ha3.mc.quick.keys.KeyWatcher;
import net.minecraft.client.settings.eidj;
import net.minecraft.client.xpzm;
import org.apache.commons.lang3.ArrayUtils;
import org.lwjgl.input.Keyboard;

public class MAtUserControl
implements Ha3HoldActions,
SupportsFrameEvents,
SupportsKeyEvents,
SupportsTickEvents {
    private MAtMod mod;
    private eidj keyBindingMain;
    private final KeyWatcher watcher = new KeyWatcher(this);
    private final Ha3KeyManager keyManager = new Ha3KeyManager();
    private MAtScroller scroller;
    private int loadingCount;
    private int tickRound;

    public MAtUserControl(MAtMod mAtMod) {
        this.mod = mAtMod;
    }

    public void load() {
        this.keyBindingMain = new eidj("key.matmos", 65);
        xpzm._E()._M.field_74324_K = ArrayUtils.addAll(xpzm._E()._M.field_74324_K, this.keyBindingMain);
        this.watcher.add(this.keyBindingMain);
        this.keyBindingMain._d = this.mod.getConfig().getInteger("key.code");
        eidj._b();
        this.scroller = new MAtScroller(this.mod);
        this.keyManager.addKeyBinding(this.keyBindingMain, new Ha3KeyHolding(this, 7));
    }

    public String getKeyBindingMainFriendlyName() {
        if (this.keyBindingMain == null) {
            return "undefined";
        }
        return Keyboard.getKeyName(this.keyBindingMain._d);
    }

    @Override
    public void onKey(eidj eidj2) {
        this.keyManager.handleKeyDown(eidj2);
    }

    @Override
    public void onTick() {
        int n;
        if (this.tickRound == 0 && (n = this.keyBindingMain._d) != this.mod.getConfig().getInteger("key.code")) {
            MAtmosConvLogger.info("Key binding changed. Saving...");
            this.mod.getConfig().setProperty("key.code", n);
            this.mod.saveConfig();
        }
        this.watcher.onTick();
        this.keyManager.handleRuntime();
        this.scroller.routine();
        if (this.scroller.isRunning()) {
            this.mod.getGlobalVolumeControl().setVolume(this.scroller.getValue());
        }
        this.tickRound = (this.tickRound + 1) % 100;
    }

    @Override
    public void onFrame(float f) {
        this.scroller.draw(f);
    }

    public void communicateKeyBindingEvent(eidj eidj2) {
        this.keyManager.handleKeyDown(eidj2);
    }

    public void printUnusualMessages() {
        if (!this.mod.isReady()) {
            MAtModPhase mAtModPhase = this.mod.getPhase();
            if (!this.mod.isFatalError()) {
                this.mod.getChatter().printChat("\u00a76", "MAtmos is not loaded.");
            } else if (mAtModPhase == MAtModPhase.NOT_INITIALIZED) {
                this.mod.getChatter().printChat("\u00a76", "MAtmos will not load due to a fatal error. ", "\u00a77", "(Some MAtmos modules are not initialized)");
            }
        } else if (xpzm._E()._M.field_74340_b <= 0.0f) {
            this.mod.getChatter().printChat("\u00a7c", "Warning: ", "\u00a7f", "Sounds are turned off in your game settings!");
        }
    }

    @Override
    public void beginHold() {
        if (this.mod.getConfig().getBoolean("reversed.controls")) {
            this.displayMenu();
        } else if (this.mod.isRunning()) {
            this.scroller.start();
        }
    }

    @Override
    public void shortPress() {
        if (this.mod.getConfig().getBoolean("reversed.controls")) {
            this.whenWantsToggle();
        } else if (!this.mod.isRunning()) {
            this.whenWantsToggle();
        } else {
            this.displayMenu();
        }
        this.printUnusualMessages();
    }

    @Override
    public void endHold() {
        if (this.scroller.isRunning()) {
            this.scroller.stop();
            this.mod.getConfig().setProperty("globalvolume.scale", Float.valueOf(this.mod.getGlobalVolumeControl().getVolume()));
            this.mod.saveConfig();
        }
        this.whenWantsForcing();
        this.printUnusualMessages();
    }

    private void whenWantsToggle() {
        if (this.mod.isRunning()) {
            this.mod.stopRunning();
            this.mod.getChatter().printChat("\u00a7e", "Stopped. Press ", "\u00a7f", this.getKeyBindingMainFriendlyName(), "\u00a7e", " to re-enable.");
        } else if (this.mod.isReady()) {
            if (this.loadingCount != 0) {
                this.mod.getChatter().printChat("\u00a7a", "Loading...");
            } else {
                this.mod.getChatter().printChat("\u00a7a", "Loading...", "\u00a7e", " (Hold ", "\u00a7f", this.getKeyBindingMainFriendlyName() + " down", "\u00a7e", " to tweak the volume)");
            }
            ++this.loadingCount;
            this.mod.startRunning();
        } else if (this.mod.getPhase() == MAtModPhase.NOT_YET_ENABLED) {
            this.whenUninitializedAction();
        }
    }

    private void whenUninitializedAction() {
        if (this.mod.getPhase() != MAtModPhase.NOT_YET_ENABLED) {
            return;
        }
        TimeStatistic timeStatistic = new TimeStatistic();
        this.mod.initializeAndEnable();
        this.mod.getChatter().printChat("\u00a7a", "Loading for the first time (" + timeStatistic.getSecondsAsString(2) + "s)");
    }

    private void whenWantsForcing() {
        if (!this.mod.isRunning() && this.mod.isReady()) {
            TimeStatistic timeStatistic = new TimeStatistic();
            this.mod.reloadAndStart();
            this.mod.getChatter().printChat("\u00a7a", "Reloading expansions (" + timeStatistic.getSecondsAsString(2) + "s)");
        } else if (this.mod.getPhase() == MAtModPhase.NOT_YET_ENABLED) {
            this.whenUninitializedAction();
        }
    }

    private void displayMenu() {
        if (this.mod.isRunning() && this.mod.util().isCurrentScreen(null)) {
            xpzm._E()._a(new MAtGuiMenu((gqjz)this.mod.util().getCurrentScreen(), this.mod));
        }
    }

    @Override
    public void beginPress() {
    }

    @Override
    public void endPress() {
    }
}

