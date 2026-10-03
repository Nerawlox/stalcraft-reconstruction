/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.util.ResourceLocation;

public class fnsz
implements cvkw {
    public static final ResourceLocation _a = new ResourceLocation("textures/colormap/foliage.png");

    @Override
    public void onResourceManagerReload(ResourceManager resourceManager) {
        try {
            igvq._a(bsfn._a(resourceManager, _a));
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }
}

