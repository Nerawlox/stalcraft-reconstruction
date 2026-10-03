/*
 * Decompiled with CFR 0.152.
 */
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class sbna {
    @ForgeSubscribe
    public void _a(GuiOpenEvent guiOpenEvent) {
        if (guiOpenEvent.gui instanceof htjl) {
            guiOpenEvent.gui = new teqa();
        }
    }
}

