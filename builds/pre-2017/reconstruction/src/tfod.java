/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.gui.inventory.GuiBeacon;

public class tfod
extends pked {
    public final /* synthetic */ GuiBeacon _e;

    public tfod(GuiBeacon guiBeacon, int n, int n2, int n3) {
        this._e = guiBeacon;
        super(n, n2, n3, GuiBeacon._a(), 90, 220);
    }

    @Override
    public void func_82251_b(int n, int n2) {
        this._e.drawCreativeTabHoveringText(wpcz._a("gui.done"), n, n2);
    }
}

