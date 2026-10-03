/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public interface owwh {
    default public void _a() {
        KeyBinding._a(Keyboard.getEventKey(), Keyboard.getEventKeyState());
        if (Keyboard.getEventKeyState()) {
            KeyBinding._a(Keyboard.getEventKey());
        }
    }
}

