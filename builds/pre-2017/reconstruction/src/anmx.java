/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.annotations.SerializedName;
import gloomyfolken.mods.core.client.gui.engine.component.TreeScrollList;

public abstract class anmx
implements TreeScrollList.TreeElement {
    @SerializedName(value="title")
    protected String _b;

    public anmx(String string) {
        this._b = string;
    }

    public boolean _a() {
        return false;
    }

    @Override
    public int getColor() {
        return 0x939393;
    }

    @Override
    public String getString() {
        return this._b;
    }
}

