/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import net.minecraft.entity.player.EntityPlayer;

public class rpdf {
    public static rpdf instance = new rpdf();

    public boolean isPlayerRunning(EntityPlayer entityPlayer) {
        return entityPlayer.func_70051_ag();
    }

    public boolean isPlayerCrawling(EntityPlayer entityPlayer) {
        return false;
    }

    @ezey(_a={eidj.CLIENT})
    public int getClientCrawlChangeTicks() {
        return 0;
    }
}

