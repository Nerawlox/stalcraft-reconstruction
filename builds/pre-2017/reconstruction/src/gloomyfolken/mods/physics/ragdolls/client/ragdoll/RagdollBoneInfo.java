/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.client.ragdoll;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.util.vector.Vector3f;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0004H\u00c6\u0003J\t\u0010&\u001a\u00020\u0004H\u00c6\u0003J\t\u0010'\u001a\u00020\bH\u00c6\u0003J\t\u0010(\u001a\u00020\nH\u00c6\u0003J\t\u0010)\u001a\u00020\fH\u00c6\u0003JK\u0010*\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u00c6\u0001J\u0013\u0010+\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010-\u001a\u00020\bH\u00d6\u0001J\t\u0010.\u001a\u00020\fH\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u001a\u0010\u001b\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u001eR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#\u00a8\u0006/"}, d2={"Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/RagdollBoneInfo;", "", "rawVertices", "", "Lorg/lwjgl/util/vector/Vector3f;", "boneOffset", "com", "boneIdx", "", "hasBody", "", "boneName", "", "(Ljava/util/List;Lorg/lwjgl/util/vector/Vector3f;Lorg/lwjgl/util/vector/Vector3f;IZLjava/lang/String;)V", "getBoneIdx", "()I", "getBoneName", "()Ljava/lang/String;", "getBoneOffset", "()Lorg/lwjgl/util/vector/Vector3f;", "getCom", "getHasBody", "()Z", "hasParent", "getHasParent", "hasPhysicalParent", "getHasPhysicalParent", "parentBoneIdx", "getParentBoneIdx", "setParentBoneIdx", "(I)V", "physicalParentBoneIdx", "getPhysicalParentBoneIdx", "setPhysicalParentBoneIdx", "getRawVertices", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "minecraft"})
public final class RagdollBoneInfo {
    private int parentBoneIdx;
    private int physicalParentBoneIdx;
    @NotNull
    private final List<Vector3f> rawVertices;
    @NotNull
    private final Vector3f boneOffset;
    @NotNull
    private final Vector3f com;
    private final int boneIdx;
    private final boolean hasBody;
    @NotNull
    private final String boneName;

    public final int getParentBoneIdx() {
        return this.parentBoneIdx;
    }

    public final void setParentBoneIdx(int n) {
        this.parentBoneIdx = n;
    }

    public final boolean getHasParent() {
        return this.parentBoneIdx >= 0;
    }

    public final int getPhysicalParentBoneIdx() {
        return this.physicalParentBoneIdx;
    }

    public final void setPhysicalParentBoneIdx(int n) {
        this.physicalParentBoneIdx = n;
    }

    public final boolean getHasPhysicalParent() {
        return this.physicalParentBoneIdx >= 0;
    }

    @NotNull
    public final List<Vector3f> getRawVertices() {
        return this.rawVertices;
    }

    @NotNull
    public final Vector3f getBoneOffset() {
        return this.boneOffset;
    }

    @NotNull
    public final Vector3f getCom() {
        return this.com;
    }

    public final int getBoneIdx() {
        return this.boneIdx;
    }

    public final boolean getHasBody() {
        return this.hasBody;
    }

    @NotNull
    public final String getBoneName() {
        return this.boneName;
    }

    public RagdollBoneInfo(@NotNull List<? extends Vector3f> list, @NotNull Vector3f vector3f, @NotNull Vector3f vector3f2, int n, boolean bl, @NotNull String string) {
        Intrinsics.checkParameterIsNotNull(list, "rawVertices");
        Intrinsics.checkParameterIsNotNull(vector3f, "boneOffset");
        Intrinsics.checkParameterIsNotNull(vector3f2, "com");
        Intrinsics.checkParameterIsNotNull(string, "boneName");
        this.rawVertices = list;
        this.boneOffset = vector3f;
        this.com = vector3f2;
        this.boneIdx = n;
        this.hasBody = bl;
        this.boneName = string;
        this.parentBoneIdx = -1;
        this.physicalParentBoneIdx = -1;
    }

    @NotNull
    public final List<Vector3f> component1() {
        return this.rawVertices;
    }

    @NotNull
    public final Vector3f component2() {
        return this.boneOffset;
    }

    @NotNull
    public final Vector3f component3() {
        return this.com;
    }

    public final int component4() {
        return this.boneIdx;
    }

    public final boolean component5() {
        return this.hasBody;
    }

    @NotNull
    public final String component6() {
        return this.boneName;
    }

    @NotNull
    public final RagdollBoneInfo copy(@NotNull List<? extends Vector3f> list, @NotNull Vector3f vector3f, @NotNull Vector3f vector3f2, int n, boolean bl, @NotNull String string) {
        Intrinsics.checkParameterIsNotNull(list, "rawVertices");
        Intrinsics.checkParameterIsNotNull(vector3f, "boneOffset");
        Intrinsics.checkParameterIsNotNull(vector3f2, "com");
        Intrinsics.checkParameterIsNotNull(string, "boneName");
        return new RagdollBoneInfo(list, vector3f, vector3f2, n, bl, string);
    }

    @NotNull
    public static /* synthetic */ RagdollBoneInfo copy$default(RagdollBoneInfo ragdollBoneInfo, List list, Vector3f vector3f, Vector3f vector3f2, int n, boolean bl, String string, int n2, Object object) {
        if ((n2 & 1) != 0) {
            list = ragdollBoneInfo.rawVertices;
        }
        if ((n2 & 2) != 0) {
            vector3f = ragdollBoneInfo.boneOffset;
        }
        if ((n2 & 4) != 0) {
            vector3f2 = ragdollBoneInfo.com;
        }
        if ((n2 & 8) != 0) {
            n = ragdollBoneInfo.boneIdx;
        }
        if ((n2 & 0x10) != 0) {
            bl = ragdollBoneInfo.hasBody;
        }
        if ((n2 & 0x20) != 0) {
            string = ragdollBoneInfo.boneName;
        }
        return ragdollBoneInfo.copy(list, vector3f, vector3f2, n, bl, string);
    }

    public String toString() {
        return "RagdollBoneInfo(rawVertices=" + this.rawVertices + ", boneOffset=" + this.boneOffset + ", com=" + this.com + ", boneIdx=" + this.boneIdx + ", hasBody=" + this.hasBody + ", boneName=" + this.boneName + ")";
    }

    public int hashCode() {
        List<Vector3f> list = this.rawVertices;
        Vector3f vector3f = this.boneOffset;
        Vector3f vector3f2 = this.com;
        int n = ((((list != null ? ((Object)list).hashCode() : 0) * 31 + (vector3f != null ? vector3f.hashCode() : 0)) * 31 + (vector3f2 != null ? vector3f2.hashCode() : 0)) * 31 + Integer.hashCode(this.boneIdx)) * 31;
        int n2 = this.hasBody ? 1 : 0;
        if (n2 != 0) {
            n2 = 1;
        }
        String string = this.boneName;
        return (n + n2) * 31 + (string != null ? string.hashCode() : 0);
    }

    public boolean equals(Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof RagdollBoneInfo)) break block3;
                RagdollBoneInfo ragdollBoneInfo = (RagdollBoneInfo)object;
                if (!Intrinsics.areEqual(this.rawVertices, ragdollBoneInfo.rawVertices) || !Intrinsics.areEqual(this.boneOffset, ragdollBoneInfo.boneOffset) || !Intrinsics.areEqual(this.com, ragdollBoneInfo.com) || !(this.boneIdx == ragdollBoneInfo.boneIdx) || !(this.hasBody == ragdollBoneInfo.hasBody) || !Intrinsics.areEqual(this.boneName, ragdollBoneInfo.boneName)) break block3;
            }
            return true;
        }
        return false;
    }
}

