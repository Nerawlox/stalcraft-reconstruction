/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.mc.quick.keys;

import eu.ha3.mc.haddon.SupportsKeyEvents;
import eu.ha3.mc.haddon.SupportsTickEvents;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.settings.eidj;

public class KeyWatcher
implements SupportsTickEvents {
    private final SupportsKeyEvents watcher;
    private final List<eidj> keys;

    public KeyWatcher(SupportsKeyEvents supportsKeyEvents) {
        this.watcher = supportsKeyEvents;
        this.keys = new ArrayList<eidj>();
    }

    public void add(eidj eidj2) {
        this.keys.add(eidj2);
    }

    @Override
    public void onTick() {
        for (eidj eidj2 : this.keys) {
            if (!eidj2._e) continue;
            this.watcher.onKey(eidj2);
        }
    }
}

