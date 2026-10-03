/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.mc.convenience;

import eu.ha3.mc.convenience.Ha3KeyActions;
import eu.ha3.mc.convenience.Ha3KeyBinding;
import java.util.HashMap;
import java.util.Iterator;
import net.minecraft.client.settings.KeyBinding;

public class Ha3KeyManager {
    HashMap<KeyBinding, Ha3KeyBinding> keys = new HashMap();

    public void addKeyBinding(KeyBinding keyBinding, Ha3KeyActions ha3KeyActions) {
        this.keys.put(keyBinding, new Ha3KeyBinding(keyBinding, ha3KeyActions));
    }

    public void handleKeyDown(KeyBinding keyBinding) {
        if (this.keys.containsKey(keyBinding)) {
            this.keys.get(keyBinding).handleBefore();
        }
    }

    public void handleRuntime() {
        Iterator<Ha3KeyBinding> iterator2 = this.keys.values().iterator();
        while (iterator2.hasNext()) {
            iterator2.next().handle();
        }
    }
}

