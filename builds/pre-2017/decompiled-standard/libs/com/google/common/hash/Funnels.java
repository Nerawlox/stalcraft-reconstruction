/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;
import java.io.OutputStream;

@Beta
public final class Funnels {
    private Funnels() {
    }

    public static Funnel<byte[]> byteArrayFunnel() {
        return ByteArrayFunnel.INSTANCE;
    }

    public static Funnel<CharSequence> stringFunnel() {
        return StringFunnel.INSTANCE;
    }

    public static Funnel<Integer> integerFunnel() {
        return IntegerFunnel.INSTANCE;
    }

    public static Funnel<Long> longFunnel() {
        return LongFunnel.INSTANCE;
    }

    public static OutputStream asOutputStream(PrimitiveSink sink) {
        return new SinkAsStream(sink);
    }

    private static class SinkAsStream
    extends OutputStream {
        final PrimitiveSink sink;

        SinkAsStream(PrimitiveSink sink) {
            this.sink = Preconditions.checkNotNull(sink);
        }

        @Override
        public void write(int b) {
            this.sink.putByte((byte)b);
        }

        @Override
        public void write(byte[] bytes) {
            this.sink.putBytes(bytes);
        }

        @Override
        public void write(byte[] bytes, int off, int len) {
            this.sink.putBytes(bytes, off, len);
        }

        public String toString() {
            return "Funnels.asOutputStream(" + this.sink + ")";
        }
    }

    private static enum LongFunnel implements Funnel<Long>
    {
        INSTANCE;


        @Override
        public void funnel(Long from, PrimitiveSink into) {
            into.putLong(from);
        }

        public String toString() {
            return "Funnels.longFunnel()";
        }
    }

    private static enum IntegerFunnel implements Funnel<Integer>
    {
        INSTANCE;


        @Override
        public void funnel(Integer from, PrimitiveSink into) {
            into.putInt(from);
        }

        public String toString() {
            return "Funnels.integerFunnel()";
        }
    }

    private static enum StringFunnel implements Funnel<CharSequence>
    {
        INSTANCE;


        @Override
        public void funnel(CharSequence from, PrimitiveSink into) {
            into.putString(from);
        }

        public String toString() {
            return "Funnels.stringFunnel()";
        }
    }

    private static enum ByteArrayFunnel implements Funnel<byte[]>
    {
        INSTANCE;


        @Override
        public void funnel(byte[] from, PrimitiveSink into) {
            into.putBytes(from);
        }

        public String toString() {
            return "Funnels.byteArrayFunnel()";
        }
    }
}

