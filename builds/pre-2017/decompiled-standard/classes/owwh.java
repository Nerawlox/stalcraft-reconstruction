/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.settings.eidj;
import org.lwjgl.input.Keyboard;

public interface owwh {
    default public void _a() {
        eidj._a(Keyboard.getEventKey(), Keyboard.getEventKeyState());
        if (Keyboard.getEventKeyState()) {
            eidj._a(Keyboard.getEventKey());
        }
    }
}

