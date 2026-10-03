/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.ResourceLocation;

public class iest
extends uytm {
    public final gpnv _a = new gpnv();

    public iest(String string) {
        this(uyvo._a(string));
    }

    public iest(ResourceLocation resourceLocation) {
        super(resourceLocation);
    }

    @Override
    protected void load() {
        this.ioTask(this::_a);
    }

    private void _a() {
        try {
            new ssps()._a(this);
            this.mcTask(this::setLoaded);
        }
        catch (Exception exception) {
            this.release();
            exception.printStackTrace();
            this.mcTask(this::setBroken);
        }
    }

    @Override
    public void release() {
        this._a._a.clear();
    }

    @Override
    public String toString() {
        return this.location.toString();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        iest iest2 = (iest)object;
        return !(this.location == null ? iest2.location != null : !this.location.equals(iest2.location));
    }

    public int hashCode() {
        return this.location != null ? this.location.hashCode() : 0;
    }
}

