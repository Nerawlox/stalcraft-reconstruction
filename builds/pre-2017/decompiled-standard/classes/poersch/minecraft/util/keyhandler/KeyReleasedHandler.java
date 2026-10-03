/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.keyhandler;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.TickType;
import java.util.EnumSet;
import net.minecraft.client.settings.eidj;
import poersch.minecraft.util.keyhandler.IKeyReleasedCallback;

public class KeyReleasedHandler
extends KeyBindingRegistry.KeyHandler {
    public final int id;
    public final String keyName;
    public final IKeyReleasedCallback callback;
    private EnumSet<TickType> ticks = EnumSet.of(TickType.CLIENT);

    public static void create(int n, String string, int n2, IKeyReleasedCallback iKeyReleasedCallback) {
        KeyBindingRegistry.registerKeyBinding(new KeyReleasedHandler(n, string, n2, iKeyReleasedCallback));
    }

    private KeyReleasedHandler(int n, String string, int n2, IKeyReleasedCallback iKeyReleasedCallback) {
        super(new eidj[]{new eidj(string, n2)}, new boolean[]{false});
        this.id = n;
        this.keyName = string;
        this.callback = iKeyReleasedCallback;
    }

    @Override
    public String getLabel() {
        return this.keyName;
    }

    @Override
    public void keyDown(EnumSet<TickType> enumSet, eidj eidj2, boolean bl, boolean bl2) {
    }

    @Override
    public void keyUp(EnumSet<TickType> enumSet, eidj eidj2, boolean bl) {
        if (bl) {
            this.callback.onKeyReleased(this);
        }
    }

    @Override
    public EnumSet<TickType> ticks() {
        return this.ticks;
    }
}

