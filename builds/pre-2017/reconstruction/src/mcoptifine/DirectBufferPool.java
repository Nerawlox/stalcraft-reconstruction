/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.BufferUtils;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lmcoptifine/DirectBufferPool;", "", "()V", "MAX_BUFFERS", "", "byteBuffers", "Ljava/util/ArrayList;", "Ljava/nio/ByteBuffer;", "Lkotlin/collections/ArrayList;", "lock", "usedBuffers", "buffersRemaining", "popCapableOf", "size", "release", "", "byteBuffer", "minecraft"})
public final class DirectBufferPool {
    private static final Object lock;
    private static final int MAX_BUFFERS = 10;
    private static int usedBuffers;
    private static final ArrayList<ByteBuffer> byteBuffers;
    public static final DirectBufferPool INSTANCE;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @JvmStatic
    public static final int buffersRemaining() {
        Object object = lock;
        synchronized (object) {
            int n = MAX_BUFFERS - usedBuffers;
            return n;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @JvmStatic
    @Nullable
    public static final ByteBuffer popCapableOf(int n) {
        Object object = lock;
        synchronized (object) {
            Object object2;
            Object object3;
            Object object4;
            int n2;
            block10: {
                int n3;
                block9: {
                    if (usedBuffers < MAX_BUFFERS) break block9;
                    ByteBuffer byteBuffer = null;
                    return byteBuffer;
                }
                n2 = usedBuffers;
                usedBuffers = n2 + 1;
                object4 = byteBuffers;
                int n4 = 0;
                object3 = object4.iterator();
                while (object3.hasNext()) {
                    object2 = object3.next();
                    ByteBuffer byteBuffer = (ByteBuffer)object2;
                    if (byteBuffer.capacity() >= n) {
                        n3 = n4;
                        break block10;
                    }
                    ++n4;
                }
                n3 = n2 = -1;
            }
            if (n2 < 0) {
                ByteBuffer byteBuffer = byteBuffers.remove(0);
                hspu._a(byteBuffer);
                ByteBuffer byteBuffer2 = BufferUtils.createByteBuffer(n);
                Intrinsics.checkExpressionValueIsNotNull(byteBuffer2, "BufferUtils.createByteBuffer(size)");
                object4 = byteBuffer2;
            } else {
                ByteBuffer byteBuffer = byteBuffers.remove(n2);
                Intrinsics.checkExpressionValueIsNotNull(byteBuffer, "byteBuffers.removeAt(bufferIndex)");
                object4 = byteBuffer;
            }
            ((ByteBuffer)object4).clear();
            ((ByteBuffer)object4).limit(n);
            List list = byteBuffers;
            if (list.size() > 1) {
                object3 = list;
                object2 = new Comparator<T>(){

                    public final int compare(T t, T t2) {
                        ByteBuffer byteBuffer = (ByteBuffer)t;
                        Comparable comparable = Integer.valueOf(byteBuffer.capacity());
                        byteBuffer = (ByteBuffer)t2;
                        Comparable comparable2 = comparable;
                        Integer n = byteBuffer.capacity();
                        return ComparisonsKt.compareValues(comparable2, (Comparable)n);
                    }
                };
                CollectionsKt.sortWith(object3, object2);
            }
            Object object5 = object4;
            return object5;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @JvmStatic
    public static final void release(@NotNull ByteBuffer byteBuffer) {
        Intrinsics.checkParameterIsNotNull(byteBuffer, "byteBuffer");
        Object object = lock;
        synchronized (object) {
            int n = usedBuffers;
            usedBuffers = n + -1;
            boolean bl = byteBuffers.add(byteBuffer);
        }
    }

    private DirectBufferPool() {
        INSTANCE = this;
        lock = new Object();
        MAX_BUFFERS = 10;
        byteBuffers = new ArrayList();
        int n = 0;
        int n2 = MAX_BUFFERS - 1;
        if (n <= n2) {
            while (true) {
                byteBuffers.add(BufferUtils.createByteBuffer(65536));
                if (n == n2) break;
                ++n;
            }
        }
    }

    static {
        new DirectBufferPool();
    }
}

