/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.mc.convenience;

import eu.ha3.mc.convenience.Ha3KeyActions;
import eu.ha3.mc.convenience.Ha3KeyBinding;
import java.util.HashMap;
import java.util.Iterator;
import net.minecraft.client.settings.eidj;

public class Ha3KeyManager {
    HashMap<eidj, Ha3KeyBinding> keys = new HashMap();

    public void addKeyBinding(eidj eidj2, Ha3KeyActions ha3KeyActions) {
        this.keys.put(eidj2, new Ha3KeyBinding(eidj2, ha3KeyActions));
    }

    public void handleKeyDown(eidj eidj2) {
        if (this.keys.containsKey(eidj2)) {
            this.keys.get(eidj2).handleBefore();
        }
    }

    public void handleRuntime() {
        Iterator<Ha3KeyBinding> iterator2 = this.keys.values().iterator();
        while (iterator2.hasNext()) {
            iterator2.next().handle();
        }
    }
}

