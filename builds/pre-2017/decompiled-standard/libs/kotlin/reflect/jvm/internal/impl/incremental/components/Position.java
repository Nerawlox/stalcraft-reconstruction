/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.incremental.components;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

public final class Position
implements Serializable {
    private final int line;
    private final int column;
    @NotNull
    private static final Position NO_POSITION;
    public static final Companion Companion;

    public final int getLine() {
        return this.line;
    }

    public final int getColumn() {
        return this.column;
    }

    public Position(int line, int column) {
        this.line = line;
        this.column = column;
    }

    static {
        Companion = new Companion(null);
        NO_POSITION = new Position(-1, -1);
    }

    public final int component1() {
        return this.line;
    }

    public final int component2() {
        return this.column;
    }

    @NotNull
    public final Position copy(int line, int column) {
        return new Position(line, column);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ Position copy$default(Position position, int n, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = position.line;
        }
        if ((n3 & 2) != 0) {
            n2 = position.column;
        }
        return position.copy(n, n2);
    }

    public String toString() {
        return "Position(line=" + this.line + ", column=" + this.column + ")";
    }

    public int hashCode() {
        return this.line * 31 + this.column;
    }

    public boolean equals(Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof Position)) break block3;
                Position position = (Position)object;
                if (!(this.line == position.line) || !(this.column == position.column)) break block3;
            }
            return true;
        }
        return false;
    }

    public static final class Companion {
        @NotNull
        public final Position getNO_POSITION() {
            return NO_POSITION;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

