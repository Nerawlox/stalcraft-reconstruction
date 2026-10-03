/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.Teleporter;

public class zifw
extends ChunkCoordinates {
    public long _d;
    public final /* synthetic */ Teleporter _e;

    public zifw(Teleporter teleporter, int n, int n2, int n3, long l) {
        this._e = teleporter;
        super(n, n2, n3);
        this._d = l;
    }
}

