/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.mc.quick.keys;

import eu.ha3.mc.haddon.SupportsKeyEvents;
import eu.ha3.mc.haddon.SupportsTickEvents;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.settings.KeyBinding;

public class KeyWatcher
implements SupportsTickEvents {
    private final SupportsKeyEvents watcher;
    private final List<KeyBinding> keys;

    public KeyWatcher(SupportsKeyEvents supportsKeyEvents) {
        this.watcher = supportsKeyEvents;
        this.keys = new ArrayList<KeyBinding>();
    }

    public void add(KeyBinding keyBinding) {
        this.keys.add(keyBinding);
    }

    @Override
    public void onTick() {
        for (KeyBinding keyBinding : this.keys) {
            if (!keyBinding._e) continue;
            this.watcher.onKey(keyBinding);
        }
    }
}

