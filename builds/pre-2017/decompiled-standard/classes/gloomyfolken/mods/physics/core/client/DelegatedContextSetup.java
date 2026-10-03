/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.core.client;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0011\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0000H\u0096\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0007H&J\b\u0010\u0010\u001a\u00020\u0007H&\u00a8\u0006\u0011"}, d2={"Lgloomyfolken/mods/physics/core/client/DelegatedContextSetup;", "", "compareTo", "", "other", "priority", "readyForSetup", "", "release", "", "setWasReleased", "flag", "setWasSetup", "setup", "skipLagCheck", "wasReleased", "wasSetup", "minecraft"})
public interface DelegatedContextSetup
extends Comparable<DelegatedContextSetup> {
    public boolean wasSetup();

    public void setWasSetup(boolean var1);

    public boolean setup();

    public void release();

    public void setWasReleased(boolean var1);

    public boolean wasReleased();

    public boolean readyForSetup();

    public boolean skipLagCheck();

    @Override
    public int compareTo(@NotNull DelegatedContextSetup var1);

    public int priority();

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=3)
    public static final class DefaultImpls {
        public static void setWasSetup(DelegatedContextSetup delegatedContextSetup, boolean bl) {
        }

        public static boolean setup(DelegatedContextSetup delegatedContextSetup) {
            return true;
        }

        public static void release(DelegatedContextSetup delegatedContextSetup) {
            delegatedContextSetup.setWasReleased(true);
        }

        public static boolean readyForSetup(DelegatedContextSetup delegatedContextSetup) {
            return true;
        }

        public static boolean skipLagCheck(DelegatedContextSetup delegatedContextSetup) {
            return false;
        }

        public static int compareTo(@NotNull DelegatedContextSetup delegatedContextSetup, DelegatedContextSetup delegatedContextSetup2) {
            Intrinsics.checkParameterIsNotNull(delegatedContextSetup2, "other");
            return delegatedContextSetup.priority() - delegatedContextSetup2.priority();
        }

        public static int priority(DelegatedContextSetup delegatedContextSetup) {
            return 0;
        }
    }
}

