/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.util.ResourceLocation;

public class xbes
implements cvkw {
    public static final ResourceLocation _a = new ResourceLocation("textures/colormap/grass.png");

    @Override
    public void onResourceManagerReload(ResourceManager resourceManager) {
        try {
            gapq._a(bsfn._a(resourceManager, _a));
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }
}

