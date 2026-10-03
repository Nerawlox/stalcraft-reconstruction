/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.incremental.components;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.incremental.components.Position;
import kotlin.reflect.jvm.internal.impl.incremental.components.ScopeKind;
import org.jetbrains.annotations.NotNull;

public final class LookupInfo
implements Serializable {
    @NotNull
    private final String filePath;
    @NotNull
    private final Position position;
    @NotNull
    private final String scopeFqName;
    @NotNull
    private final ScopeKind scopeKind;
    @NotNull
    private final String name;

    @NotNull
    public final String getFilePath() {
        return this.filePath;
    }

    @NotNull
    public final Position getPosition() {
        return this.position;
    }

    @NotNull
    public final String getScopeFqName() {
        return this.scopeFqName;
    }

    @NotNull
    public final ScopeKind getScopeKind() {
        return this.scopeKind;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public LookupInfo(@NotNull String filePath, @NotNull Position position, @NotNull String scopeFqName, @NotNull ScopeKind scopeKind, @NotNull String name2) {
        Intrinsics.checkParameterIsNotNull(filePath, "filePath");
        Intrinsics.checkParameterIsNotNull(position, "position");
        Intrinsics.checkParameterIsNotNull(scopeFqName, "scopeFqName");
        Intrinsics.checkParameterIsNotNull((Object)scopeKind, "scopeKind");
        Intrinsics.checkParameterIsNotNull(name2, "name");
        this.filePath = filePath;
        this.position = position;
        this.scopeFqName = scopeFqName;
        this.scopeKind = scopeKind;
        this.name = name2;
    }

    @NotNull
    public final String component1() {
        return this.filePath;
    }

    @NotNull
    public final Position component2() {
        return this.position;
    }

    @NotNull
    public final String component3() {
        return this.scopeFqName;
    }

    @NotNull
    public final ScopeKind component4() {
        return this.scopeKind;
    }

    @NotNull
    public final String component5() {
        return this.name;
    }

    @NotNull
    public final LookupInfo copy(@NotNull String filePath, @NotNull Position position, @NotNull String scopeFqName, @NotNull ScopeKind scopeKind, @NotNull String name2) {
        Intrinsics.checkParameterIsNotNull(filePath, "filePath");
        Intrinsics.checkParameterIsNotNull(position, "position");
        Intrinsics.checkParameterIsNotNull(scopeFqName, "scopeFqName");
        Intrinsics.checkParameterIsNotNull((Object)scopeKind, "scopeKind");
        Intrinsics.checkParameterIsNotNull(name2, "name");
        return new LookupInfo(filePath, position, scopeFqName, scopeKind, name2);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ LookupInfo copy$default(LookupInfo lookupInfo, String string, Position position, String string2, ScopeKind scopeKind, String string3, int n, Object object) {
        if ((n & 1) != 0) {
            string = lookupInfo.filePath;
        }
        if ((n & 2) != 0) {
            position = lookupInfo.position;
        }
        if ((n & 4) != 0) {
            string2 = lookupInfo.scopeFqName;
        }
        if ((n & 8) != 0) {
            scopeKind = lookupInfo.scopeKind;
        }
        if ((n & 0x10) != 0) {
            string3 = lookupInfo.name;
        }
        return lookupInfo.copy(string, position, string2, scopeKind, string3);
    }

    public String toString() {
        return "LookupInfo(filePath=" + this.filePath + ", position=" + this.position + ", scopeFqName=" + this.scopeFqName + ", scopeKind=" + (Object)((Object)this.scopeKind) + ", name=" + this.name + ")";
    }

    public int hashCode() {
        String string = this.filePath;
        Position position = this.position;
        String string2 = this.scopeFqName;
        ScopeKind scopeKind = this.scopeKind;
        String string3 = this.name;
        return ((((string != null ? string.hashCode() : 0) * 31 + (position != null ? ((Object)position).hashCode() : 0)) * 31 + (string2 != null ? string2.hashCode() : 0)) * 31 + (scopeKind != null ? ((Object)((Object)scopeKind)).hashCode() : 0)) * 31 + (string3 != null ? string3.hashCode() : 0);
    }

    public boolean equals(Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof LookupInfo)) break block3;
                LookupInfo lookupInfo = (LookupInfo)object;
                if (!Intrinsics.areEqual(this.filePath, lookupInfo.filePath) || !Intrinsics.areEqual(this.position, lookupInfo.position) || !Intrinsics.areEqual(this.scopeFqName, lookupInfo.scopeFqName) || !Intrinsics.areEqual((Object)this.scopeKind, (Object)lookupInfo.scopeKind) || !Intrinsics.areEqual(this.name, lookupInfo.name)) break block3;
            }
            return true;
        }
        return false;
    }
}

