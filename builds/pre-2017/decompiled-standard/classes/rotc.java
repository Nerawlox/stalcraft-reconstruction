/*
 * Decompiled with CFR 0.152.
 */
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\u0011\u001a\n \f*\u0004\u0018\u00010\u00120\u0012J\u000e\u0010\u0013\u001a\n \f*\u0004\u0018\u00010\u00140\u0014J\u000e\u0010\u0015\u001a\n \f*\u0004\u0018\u00010\u00160\u0016J\u0006\u0010\u0017\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0019"}, d2={"Lgloomyfolken/bundle/common/utils/ServerTimeOffset;", "", "()V", "timeOffsetMillis", "", "zoneOffsetSeconds", "", "(JI)V", "getTimeOffsetMillis", "()J", "zoneOffset", "Ljava/time/ZoneOffset;", "kotlin.jvm.PlatformType", "getZoneOffset", "()Ljava/time/ZoneOffset;", "getZoneOffsetSeconds", "()I", "getInstant", "Ljava/time/Instant;", "getLocalTime", "Ljava/time/LocalDateTime;", "getOffsetTime", "Ljava/time/OffsetDateTime;", "getTimeMillis", "Companion", "minecraft"})
public final class rotc {
    private final ZoneOffset _b;
    private final long _c;
    private final int _d;
    @NotNull
    private static final rotc _e;
    public static final kjui _a;

    public final ZoneOffset _a() {
        return this._b;
    }

    public final Instant _b() {
        return Instant.now().plusMillis(this._c);
    }

    public final OffsetDateTime _c() {
        return this._b().atOffset(ZoneOffset.ofTotalSeconds(this._d));
    }

    public final LocalDateTime _d() {
        return this._c().toLocalDateTime();
    }

    public final long _e() {
        return System.currentTimeMillis() + this._c;
    }

    public final long _f() {
        return this._c;
    }

    public final int _g() {
        return this._d;
    }

    public rotc(long l, int n) {
        this._c = l;
        this._d = n;
        this._b = ZoneOffset.ofTotalSeconds(this._d);
    }

    public rotc() {
        this(0L, _a._b());
    }

    static {
        _a = new kjui(null);
        _e = new rotc();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2={"Lgloomyfolken/bundle/common/utils/ServerTimeOffset$Companion;", "", "()V", "zeroOffset", "Lgloomyfolken/bundle/common/utils/ServerTimeOffset;", "getZeroOffset", "()Lgloomyfolken/bundle/common/utils/ServerTimeOffset;", "getSystemDefaultOffset", "", "minecraft"})
    public static final class kjui {
        @NotNull
        public final rotc _a() {
            return _e;
        }

        public final int _b() {
            return ZoneId.systemDefault().getRules().getOffset(Instant.now()).getTotalSeconds();
        }

        private kjui() {
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

