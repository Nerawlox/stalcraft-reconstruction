/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.core.client.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0001&B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u000fR(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006'"}, d2={"Lgloomyfolken/mods/physics/core/client/utils/DynamicByteBuffer;", "", "direct", "", "size", "", "(ZI)V", "<set-?>", "Ljava/nio/ByteBuffer;", "buf", "getBuf", "()Ljava/nio/ByteBuffer;", "setBuf", "(Ljava/nio/ByteBuffer;)V", "createBuffer", "", "ensureCapacity", "required", "position", "pos", "put", "b", "", "putDouble", "d", "", "putFloat", "f", "", "putInt", "i", "putLong", "l", "", "putShort", "s", "", "reset", "Companion", "minecraft"})
public final class DynamicByteBuffer {
    @Nullable
    private ByteBuffer buf;
    private final boolean direct;
    private static final float EXPAND_FACTOR = 1.5f;
    public static final Companion Companion = new Companion(null);

    @Nullable
    public final ByteBuffer getBuf() {
        return this.buf;
    }

    private final void setBuf(ByteBuffer byteBuffer) {
        this.buf = byteBuffer;
    }

    public final void put(byte by) {
        this.ensureCapacity(1);
        ByteBuffer byteBuffer = this.buf;
        if (byteBuffer == null) {
            Intrinsics.throwNpe();
        }
        byteBuffer.put(by);
    }

    public final void putFloat(float f) {
        this.ensureCapacity(4);
        ByteBuffer byteBuffer = this.buf;
        if (byteBuffer == null) {
            Intrinsics.throwNpe();
        }
        byteBuffer.putFloat(f);
    }

    public final void putInt(int n) {
        this.ensureCapacity(4);
        ByteBuffer byteBuffer = this.buf;
        if (byteBuffer == null) {
            Intrinsics.throwNpe();
        }
        byteBuffer.putInt(n);
    }

    public final void putShort(short s) {
        this.ensureCapacity(2);
        ByteBuffer byteBuffer = this.buf;
        if (byteBuffer == null) {
            Intrinsics.throwNpe();
        }
        byteBuffer.putShort(s);
    }

    public final void putLong(long l) {
        this.ensureCapacity(8);
        ByteBuffer byteBuffer = this.buf;
        if (byteBuffer == null) {
            Intrinsics.throwNpe();
        }
        byteBuffer.putLong(l);
    }

    public final void putDouble(double d) {
        this.ensureCapacity(8);
        ByteBuffer byteBuffer = this.buf;
        if (byteBuffer == null) {
            Intrinsics.throwNpe();
        }
        byteBuffer.putDouble(d);
    }

    public final int position() {
        ByteBuffer byteBuffer = this.buf;
        if (byteBuffer == null) {
            Intrinsics.throwNpe();
        }
        return byteBuffer.position();
    }

    public final void position(int n) {
        ByteBuffer byteBuffer = this.buf;
        if (byteBuffer == null) {
            Intrinsics.throwNpe();
        }
        byteBuffer.position(n);
    }

    public final void reset() {
        ByteBuffer byteBuffer = this.buf;
        if (byteBuffer == null) {
            Intrinsics.throwNpe();
        }
        byteBuffer.reset();
    }

    private final void ensureCapacity(int n) {
        ByteBuffer byteBuffer = this.buf;
        if (byteBuffer == null) {
            Intrinsics.throwNpe();
        }
        if (byteBuffer.remaining() < n) {
            ByteBuffer byteBuffer2 = this.buf;
            if (byteBuffer2 == null) {
                Intrinsics.throwNpe();
            }
            this.createBuffer((int)((float)(byteBuffer2.capacity() + n) * DynamicByteBuffer.Companion.getEXPAND_FACTOR()));
        }
    }

    private final void createBuffer(int n) {
        ByteBuffer byteBuffer;
        if (this.direct) {
            ByteBuffer byteBuffer2 = ByteBuffer.allocateDirect(n).order(ByteOrder.nativeOrder());
            Intrinsics.checkExpressionValueIsNotNull(byteBuffer2, "ByteBuffer.allocateDirec\u2026(ByteOrder.nativeOrder())");
            byteBuffer = byteBuffer2;
        } else {
            ByteBuffer byteBuffer3 = ByteBuffer.allocate(n);
            Intrinsics.checkExpressionValueIsNotNull(byteBuffer3, "ByteBuffer.allocate(size)");
            byteBuffer = byteBuffer3;
        }
        if (this.buf != null) {
            ByteBuffer byteBuffer4 = this.buf;
            if (byteBuffer4 == null) {
                Intrinsics.throwNpe();
            }
            int n2 = byteBuffer4.position();
            ByteBuffer byteBuffer5 = this.buf;
            if (byteBuffer5 == null) {
                Intrinsics.throwNpe();
            }
            byteBuffer5.position(0);
            byteBuffer.put(this.buf);
            byteBuffer.position(n2);
        }
        this.buf = byteBuffer;
    }

    public DynamicByteBuffer(boolean bl, int n) {
        this.direct = bl;
        this.createBuffer(n);
    }

    static {
        EXPAND_FACTOR = 1.5f;
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lgloomyfolken/mods/physics/core/client/utils/DynamicByteBuffer$Companion;", "", "()V", "EXPAND_FACTOR", "", "getEXPAND_FACTOR", "()F", "minecraft"})
    public static final class Companion {
        private final float getEXPAND_FACTOR() {
            return EXPAND_FACTOR;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

