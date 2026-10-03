/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.pathfind;

import kotlin.Metadata;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/pathfind/PathTaskResult;", "", "pathChanged", "", "(Ljava/lang/String;IZ)V", "getPathChanged", "()Z", "DIRECT_PATH", "NEW_PATH", "OLD_PATH", "NO_PATH", "minecraft"})
public final class PathTaskResult
extends Enum<PathTaskResult> {
    public static final /* enum */ PathTaskResult DIRECT_PATH;
    public static final /* enum */ PathTaskResult NEW_PATH;
    public static final /* enum */ PathTaskResult OLD_PATH;
    public static final /* enum */ PathTaskResult NO_PATH;
    private static final /* synthetic */ PathTaskResult[] $VALUES;
    private final boolean pathChanged;

    static {
        PathTaskResult[] pathTaskResultArray = new PathTaskResult[4];
        PathTaskResult[] pathTaskResultArray2 = pathTaskResultArray;
        pathTaskResultArray[0] = DIRECT_PATH = new PathTaskResult(true);
        pathTaskResultArray[1] = NEW_PATH = new PathTaskResult(true);
        pathTaskResultArray[2] = OLD_PATH = new PathTaskResult(false);
        pathTaskResultArray[3] = NO_PATH = new PathTaskResult(false);
        $VALUES = pathTaskResultArray;
    }

    public final boolean getPathChanged() {
        return this.pathChanged;
    }

    protected PathTaskResult(boolean bl) {
        this.pathChanged = bl;
    }

    public static PathTaskResult[] values() {
        return (PathTaskResult[])$VALUES.clone();
    }

    public static PathTaskResult valueOf(String string) {
        return Enum.valueOf(PathTaskResult.class, string);
    }
}

