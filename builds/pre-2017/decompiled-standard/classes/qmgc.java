/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.io.IOException;
import java.nio.IntBuffer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@ezey(_a={eidj.CLIENT})
public class qmgc
extends zhix {
    private final ResourceLocation _a;

    public qmgc(ResourceLocation resourceLocation) {
        this._a = resourceLocation;
    }

    @Override
    public void func_110551_a(xsfs xsfs2) throws IOException {
        int n = this.func_110552_b();
        GL11.glBindTexture(3553, n);
        GL11.glTexImage2D(3553, 0, 6408, 16, 16, 0, 32993, 33639, (IntBuffer)null);
        GL11.glTexParameteri(3553, 10241, 9728);
        GL11.glTexParameteri(3553, 10240, 9728);
        GL11.glTexParameteri(3553, 10242, 10497);
        GL11.glTexParameteri(3553, 10243, 10497);
    }
}

