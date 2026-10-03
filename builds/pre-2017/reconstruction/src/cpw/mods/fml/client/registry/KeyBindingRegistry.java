/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client.registry;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Set;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class KeyBindingRegistry {
    private static final KeyBindingRegistry INSTANCE = new KeyBindingRegistry();
    private Set<KeyHandler> keyHandlers = Sets.newLinkedHashSet();

    public static void registerKeyBinding(KeyHandler keyHandler) {
        KeyBindingRegistry.instance().keyHandlers.add(keyHandler);
        if (!keyHandler.isDummy) {
            TickRegistry.registerTickHandler(keyHandler, Side.CLIENT);
        }
    }

    @Deprecated
    public static KeyBindingRegistry instance() {
        return INSTANCE;
    }

    public void uploadKeyBindingsToGame(GameSettings gameSettings) {
        ArrayList<KeyBinding> arrayList = Lists.newArrayList();
        for (KeyHandler keyBindingArray2 : this.keyHandlers) {
            for (KeyBinding keyBinding : keyBindingArray2.keyBindings) {
                arrayList.add(keyBinding);
            }
        }
        KeyBinding[] keyBindingArray3 = arrayList.toArray(new KeyBinding[arrayList.size()]);
        KeyBinding[] keyBindingArray = new KeyBinding[gameSettings.keyBindings.length + keyBindingArray3.length];
        System.arraycopy(gameSettings.keyBindings, 0, keyBindingArray, 0, gameSettings.keyBindings.length);
        System.arraycopy(keyBindingArray3, 0, keyBindingArray, gameSettings.keyBindings.length, keyBindingArray3.length);
        gameSettings.keyBindings = keyBindingArray;
        gameSettings.loadOptions();
    }

    public static abstract class KeyHandler
    implements ITickHandler {
        protected KeyBinding[] keyBindings;
        protected boolean[] keyDown;
        protected boolean[] repeatings;
        private boolean isDummy;

        public KeyHandler(KeyBinding[] keyBindingArray, boolean[] blArray) {
            assert (keyBindingArray.length == blArray.length) : "You need to pass two arrays of identical length";
            this.keyBindings = keyBindingArray;
            this.repeatings = blArray;
            this.keyDown = new boolean[keyBindingArray.length];
        }

        public KeyHandler(KeyBinding[] keyBindingArray) {
            this.keyBindings = keyBindingArray;
            this.isDummy = true;
        }

        public KeyBinding[] getKeyBindings() {
            return this.keyBindings;
        }

        @Override
        public final void tickStart(EnumSet<TickType> enumSet, Object ... objectArray) {
            this.keyTick(enumSet, false);
        }

        @Override
        public final void tickEnd(EnumSet<TickType> enumSet, Object ... objectArray) {
            this.keyTick(enumSet, true);
        }

        private void keyTick(EnumSet<TickType> enumSet, boolean bl) {
            for (int i = 0; i < this.keyBindings.length; ++i) {
                boolean bl2;
                KeyBinding keyBinding = this.keyBindings[i];
                int n = keyBinding._d;
                boolean bl3 = bl2 = n < 0 ? Mouse.isButtonDown(n + 100) : Keyboard.isKeyDown(n);
                if (bl2 == this.keyDown[i] && (!bl2 || !this.repeatings[i])) continue;
                if (bl2) {
                    this.keyDown(enumSet, keyBinding, bl, bl2 != this.keyDown[i]);
                } else {
                    this.keyUp(enumSet, keyBinding, bl);
                }
                if (!bl) continue;
                this.keyDown[i] = bl2;
            }
        }

        public abstract void keyDown(EnumSet<TickType> var1, KeyBinding var2, boolean var3, boolean var4);

        public abstract void keyUp(EnumSet<TickType> var1, KeyBinding var2, boolean var3);

        @Override
        public abstract EnumSet<TickType> ticks();
    }
}

