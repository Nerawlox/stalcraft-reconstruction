/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mods.sound.client.environment.EnvironmentProcessor;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJF\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2={"Lgloomyfolken/mods/core/client/DelayedSoundQueue;", "", "()V", "queue", "Ljava/util/PriorityQueue;", "Lgloomyfolken/mods/core/client/DelayedSoundQueue$Entry;", "tickStartTime", "", "playDelayedSounds", "", "playSoundDelayed", "delay", "", "posX", "", "posY", "posZ", "soundName", "", "volume", "pitch", "relative", "", "tickStart", "Entry", "minecraft"})
public final class dwwh {
    private static final PriorityQueue<kjui> _b;
    private static long _c;
    public static final dwwh _a;

    public final void _a() {
        _c = System.nanoTime();
    }

    public final void _a(float f, double d, double d2, double d3, @NotNull String string, float f2, float f3, boolean bl) {
        Intrinsics.checkParameterIsNotNull(string, "soundName");
        long l = System.nanoTime() + (long)((double)f * (double)50 * (double)1000000);
        double d4 = bl ? d - Minecraft._E()._t.posX : d;
        double d5 = bl ? d2 - Minecraft._E()._t.posY : d2;
        double d6 = bl ? d3 - Minecraft._E()._t.posZ : d3;
        kjui kjui2 = new kjui(l, d4, d5, d6, string, f2, f3, bl);
        if (f > 0.0f) {
            Collection collection = _b;
            collection.add(kjui2);
        } else {
            kjui2._a();
        }
    }

    public final void _b() {
        long l = System.nanoTime();
        Iterator<kjui> iterator2 = _b.iterator();
        while (iterator2.hasNext()) {
            kjui kjui2 = iterator2.next();
            long l2 = l - kjui2._b();
            if (l2 < (long)0) continue;
            kjui2._a();
            iterator2.remove();
        }
    }

    private dwwh() {
        _a = this;
        _b = new PriorityQueue();
    }

    static {
        new dwwh();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0000H\u0096\u0002J\u0006\u0010 \u001a\u00020!R\u0011\u0010\f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011\u00a8\u0006\""}, d2={"Lgloomyfolken/mods/core/client/DelayedSoundQueue$Entry;", "", "targetNanoTime", "", "posX", "", "posY", "posZ", "soundName", "", "volume", "", "pitch", "relative", "", "(JDDDLjava/lang/String;FFZ)V", "getPitch", "()F", "getPosX", "()D", "getPosY", "getPosZ", "getRelative", "()Z", "getSoundName", "()Ljava/lang/String;", "getTargetNanoTime", "()J", "getVolume", "compareTo", "", "other", "play", "", "minecraft"})
    private static final class kjui
    implements Comparable<kjui> {
        private final long _a;
        private final double _b;
        private final double _c;
        private final double _d;
        @NotNull
        private final String _e;
        private final float _f;
        private final float _g;
        private final boolean _h;

        public int _a(@NotNull kjui kjui2) {
            Intrinsics.checkParameterIsNotNull(kjui2, "other");
            return Intrinsics.compare(this._a, kjui2._a);
        }

        @Override
        public /* synthetic */ int compareTo(Object object) {
            return this._a((kjui)object);
        }

        public final void _a() {
            EnvironmentProcessor.instance.playSoundRelatively(this._e, (float)this._b, (float)this._c, (float)this._d, this._f, this._g, this._h, this._h);
        }

        public final long _b() {
            return this._a;
        }

        public final double _c() {
            return this._b;
        }

        public final double _d() {
            return this._c;
        }

        public final double _e() {
            return this._d;
        }

        @NotNull
        public final String _f() {
            return this._e;
        }

        public final float _g() {
            return this._f;
        }

        public final float _h() {
            return this._g;
        }

        public final boolean _i() {
            return this._h;
        }

        public kjui(long l, double d, double d2, double d3, @NotNull String string, float f, float f2, boolean bl) {
            Intrinsics.checkParameterIsNotNull(string, "soundName");
            this._a = l;
            this._b = d;
            this._c = d2;
            this._d = d3;
            this._e = string;
            this._f = f;
            this._g = f2;
            this._h = bl;
        }
    }
}

