/*
 * Decompiled with CFR 0.152.
 */
import java.nio.ByteBuffer;
import net.minecraft.util.ResourceLocation;

public class rpms
extends jhuw<zxep> {
    public rpms(String string) {
        this(uyvo._a(string));
    }

    public rpms(ResourceLocation resourceLocation) {
        super(resourceLocation);
    }

    @Override
    protected zxep createMesh(String string, String string2, int n, short[] sArray, int n2, int n3, float f) {
        return new zxep(this, string, string2, n, sArray, n2, n3, f);
    }

    @Override
    protected void onModelLoaded(ByteBuffer byteBuffer) {
        hspu._a(byteBuffer);
        this.mcTask(this::setLoaded);
    }

    public rpms loadSync() {
        this.load(false);
        return this;
    }
}

