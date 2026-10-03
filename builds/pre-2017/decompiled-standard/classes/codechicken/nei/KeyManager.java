/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.NEIClientConfig;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.lwjgl.input.Keyboard;

public class KeyManager {
    public static HashMap<String, KeyState> keyStates = new HashMap();
    public static LinkedList<IKeyStateTracker> trackers = new LinkedList();

    public static void tickKeyStates() {
        for (Map.Entry<String, KeyState> entry : keyStates.entrySet()) {
            int n = NEIClientConfig.getKeyBinding(entry.getKey());
            boolean bl = n != 0 && Keyboard.isKeyDown(n);
            KeyState keyState = entry.getValue();
            if (bl) {
                keyState.down = !keyState.held;
                keyState.up = false;
            } else {
                keyState.up = keyState.held;
                keyState.down = false;
            }
            keyState.held = bl;
        }
        for (IKeyStateTracker iKeyStateTracker : trackers) {
            iKeyStateTracker.tickKeyStates();
        }
    }

    public static class KeyState {
        public boolean down;
        public boolean held;
        public boolean up;
    }

    public static interface IKeyStateTracker {
        public void tickKeyStates();
    }
}

