/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.component.TreeScrollList;
import java.util.Collection;
import java.util.Collections;

public abstract class eixm
extends anmx {
    public eixm(String string) {
        super(string);
    }

    public abstract String _b();

    public abstract String _c();

    @Override
    public Collection<? extends TreeScrollList.TreeElement> elements() {
        return Collections.emptyList();
    }
}

