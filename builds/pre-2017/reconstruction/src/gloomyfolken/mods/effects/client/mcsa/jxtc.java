/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.mcsa;

import gloomyfolken.mods.effects.client.mcsa.qlgf;
import java.nio.ByteBuffer;
import net.minecraft.util.ResourceLocation;

public class jxtc
extends jhuw<qlgf> {
    private ByteBuffer _a;

    public jxtc(ResourceLocation resourceLocation) {
        super(resourceLocation);
    }

    protected qlgf _a(String string, String string2, int n, short[] sArray, int n2, int n3, float f) {
        return new qlgf(this, string, string2, n, sArray, n2, n3, f);
    }

    @Override
    protected void onModelLoaded(ByteBuffer byteBuffer) {
        this._a = byteBuffer;
        this.glTaskFast(this::_a);
    }

    private void _a() {
        for (int i = 0; i < this.meshes.size(); ++i) {
            ((qlgf)this.meshes.get(i))._a();
        }
        this.ioTask(this::_b);
    }

    private void _b() {
        for (int i = 0; i < this.meshes.size(); ++i) {
            ((qlgf)this.meshes.get(i))._b();
        }
        hspu._a(this._a);
        this._a = null;
        this.glTaskFast(this::_c);
    }

    private void _c() {
        for (int i = 0; i < this.meshes.size(); ++i) {
            ((qlgf)this.meshes.get(i))._c();
        }
        this.mcFenceTask(this::setLoaded);
    }

    @Override
    protected /* synthetic */ iess createMesh(String string, String string2, int n, short[] sArray, int n2, int n3, float f) {
        return this._a(string, string2, n, sArray, n2, n3, f);
    }
}

