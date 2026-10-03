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
import net.minecraft.client.settings.eidj;
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
        ArrayList<eidj> arrayList = Lists.newArrayList();
        for (KeyHandler eidjArray2 : this.keyHandlers) {
            for (eidj eidj2 : eidjArray2.keyBindings) {
                arrayList.add(eidj2);
            }
        }
        eidj[] eidjArray3 = arrayList.toArray(new eidj[arrayList.size()]);
        eidj[] eidjArray = new eidj[gameSettings.field_74324_K.length + eidjArray3.length];
        System.arraycopy(gameSettings.field_74324_K, 0, eidjArray, 0, gameSettings.field_74324_K.length);
        System.arraycopy(eidjArray3, 0, eidjArray, gameSettings.field_74324_K.length, eidjArray3.length);
        gameSettings.field_74324_K = eidjArray;
        gameSettings.func_74300_a();
    }

    public static abstract class KeyHandler
    implements ITickHandler {
        protected eidj[] keyBindings;
        protected boolean[] keyDown;
        protected boolean[] repeatings;
        private boolean isDummy;

        public KeyHandler(eidj[] eidjArray, boolean[] blArray) {
            assert (eidjArray.length == blArray.length) : "You need to pass two arrays of identical length";
            this.keyBindings = eidjArray;
            this.repeatings = blArray;
            this.keyDown = new boolean[eidjArray.length];
        }

        public KeyHandler(eidj[] eidjArray) {
            this.keyBindings = eidjArray;
            this.isDummy = true;
        }

        public eidj[] getKeyBindings() {
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
                eidj eidj2 = this.keyBindings[i];
                int n = eidj2._d;
                boolean bl3 = bl2 = n < 0 ? Mouse.isButtonDown(n + 100) : Keyboard.isKeyDown(n);
                if (bl2 == this.keyDown[i] && (!bl2 || !this.repeatings[i])) continue;
                if (bl2) {
                    this.keyDown(enumSet, eidj2, bl, bl2 != this.keyDown[i]);
                } else {
                    this.keyUp(enumSet, eidj2, bl);
                }
                if (!bl) continue;
                this.keyDown[i] = bl2;
            }
        }

        public abstract void keyDown(EnumSet<TickType> var1, eidj var2, boolean var3, boolean var4);

        public abstract void keyUp(EnumSet<TickType> var1, eidj var2, boolean var3);

        @Override
        public abstract EnumSet<TickType> ticks();
    }
}

