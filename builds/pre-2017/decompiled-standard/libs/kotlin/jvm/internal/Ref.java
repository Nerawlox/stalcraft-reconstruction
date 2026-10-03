/*
 * Decompiled with CFR 0.152.
 */
package kotlin.jvm.internal;

public class Ref {
    private Ref() {
    }

    public static final class BooleanRef {
        public boolean element;

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class CharRef {
        public char element;

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class DoubleRef {
        public double element;

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class FloatRef {
        public float element;

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class LongRef {
        public long element;

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class IntRef {
        public int element;

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class ShortRef {
        public short element;

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class ByteRef {
        public byte element;

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class ObjectRef<T> {
        public T element;

        public String toString() {
            return String.valueOf(this.element);
        }
    }
}

