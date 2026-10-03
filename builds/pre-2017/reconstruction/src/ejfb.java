/*
 * Decompiled with CFR 0.152.
 */
import org.lwjgl.opengl.GL11;

public interface ejfb
extends sctg {
    public int _e();

    default public void _g() {
        GL11.glBindTexture(this._e(), this.getGlTextureId());
    }
}

