/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import mcoptifine.Config;
import mcoptifine.IWrUpdateControl;
import mcoptifine.Reflector;
import net.minecraft.util.eidj;

public class WrUpdateControl
implements IWrUpdateControl {
    private boolean hasForge = Reflector.ForgeHooksClient.exists();
    private int renderPass = 0;

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
        eidj._a()._a();
        pkix pkix2 = Config.getMinecraft()._r;
        if (pkix2 != null) {
            pkix2.func_82732_R()._a();
        }
    }

    public void setRenderPass(int n) {
        this.renderPass = n;
    }
}

