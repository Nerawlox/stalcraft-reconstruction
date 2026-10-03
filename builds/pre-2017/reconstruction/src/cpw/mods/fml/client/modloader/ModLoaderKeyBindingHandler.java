/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client.modloader;

import com.google.common.collect.ObjectArrays;
import com.google.common.primitives.Booleans;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.modloader.ModLoaderModContainer;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.src.BaseMod;

public class ModLoaderKeyBindingHandler
extends KeyBindingRegistry.KeyHandler {
    private ModLoaderModContainer modContainer;
    private List<KeyBinding> helper;
    private boolean[] active = new boolean[0];
    private boolean[] mlRepeats = new boolean[0];
    private boolean[] armed = new boolean[0];

    public ModLoaderKeyBindingHandler() {
        super(new KeyBinding[0], new boolean[0]);
    }

    void setModContainer(ModLoaderModContainer modLoaderModContainer) {
        this.modContainer = modLoaderModContainer;
    }

    public void fireKeyEvent(KeyBinding keyBinding) {
        ((BaseMod)this.modContainer.getMod()).keyboardEvent(keyBinding);
    }

    @Override
    public void keyDown(EnumSet<TickType> enumSet, KeyBinding keyBinding, boolean bl, boolean bl2) {
        if (!bl) {
            return;
        }
        int n = this.helper.indexOf(keyBinding);
        if (enumSet.contains((Object)TickType.CLIENT)) {
            this.armed[n] = true;
        }
        if (this.armed[n] && enumSet.contains((Object)TickType.RENDER) && (!this.active[n] || this.mlRepeats[n])) {
            this.fireKeyEvent(keyBinding);
            this.active[n] = true;
            this.armed[n] = false;
        }
    }

    @Override
    public void keyUp(EnumSet<TickType> enumSet, KeyBinding keyBinding, boolean bl) {
        if (!bl) {
            return;
        }
        int n = this.helper.indexOf(keyBinding);
        this.active[n] = false;
    }

    @Override
    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.CLIENT, TickType.RENDER);
    }

    @Override
    public String getLabel() {
        return this.modContainer.getModId() + " KB " + this.keyBindings[0]._d;
    }

    void addKeyBinding(KeyBinding keyBinding, boolean bl) {
        this.keyBindings = ObjectArrays.concat(this.keyBindings, keyBinding);
        this.repeatings = new boolean[this.keyBindings.length];
        Arrays.fill(this.repeatings, true);
        this.active = new boolean[this.keyBindings.length];
        this.armed = new boolean[this.keyBindings.length];
        this.mlRepeats = Booleans.concat(this.mlRepeats, {bl});
        this.keyDown = new boolean[this.keyBindings.length];
        this.helper = Arrays.asList(this.keyBindings);
    }
}

