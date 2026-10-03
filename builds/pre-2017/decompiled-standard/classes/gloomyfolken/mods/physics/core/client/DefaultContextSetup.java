/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.core.client;

import gloomyfolken.mods.physics.core.client.DelegatedContextSetup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0096\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lgloomyfolken/mods/physics/core/client/DefaultContextSetup;", "Lgloomyfolken/mods/physics/core/client/DelegatedContextSetup;", "()V", "init", "", "released", "compareTo", "", "other", "setWasReleased", "", "flag", "setWasSetup", "wasReleased", "wasSetup", "minecraft"})
public final class DefaultContextSetup
implements DelegatedContextSetup {
    private boolean init;
    private boolean released;

    @Override
    public boolean wasReleased() {
        return this.released;
    }

    @Override
    public void setWasReleased(boolean bl) {
        this.released = bl;
    }

    @Override
    public boolean wasSetup() {
        return this.init;
    }

    @Override
    public void setWasSetup(boolean bl) {
        this.init = bl;
    }

    @Override
    public int compareTo(@NotNull DelegatedContextSetup delegatedContextSetup) {
        Intrinsics.checkParameterIsNotNull(delegatedContextSetup, "other");
        return 0;
    }

    @Override
    public boolean setup() {
        return DelegatedContextSetup.DefaultImpls.setup(this);
    }

    @Override
    public void release() {
        DelegatedContextSetup.DefaultImpls.release(this);
    }

    @Override
    public boolean readyForSetup() {
        return DelegatedContextSetup.DefaultImpls.readyForSetup(this);
    }

    @Override
    public boolean skipLagCheck() {
        return DelegatedContextSetup.DefaultImpls.skipLagCheck(this);
    }

    @Override
    public int priority() {
        return DelegatedContextSetup.DefaultImpls.priority(this);
    }
}

