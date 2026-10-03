/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.mcsa;

import java.util.function.Predicate;
import net.minecraftforge.client.model.IModelCustom;
import org.apache.commons.lang3.ArrayUtils;

public interface zwat
extends IModelCustom {
    @Override
    default public String getType() {
        return "mcsa";
    }

    @Override
    default public void renderAll() {
        this.renderAll(null);
    }

    @Override
    @Deprecated
    default public void renderOnly(String ... stringArray) {
        this._a(string -> ArrayUtils.contains(stringArray, string));
    }

    @Override
    default public void renderPart(String string) {
        this.renderPart(string, null);
    }

    @Override
    @Deprecated
    default public void renderAllExcept(String ... stringArray) {
        this._a(string -> !ArrayUtils.contains(stringArray, string));
    }

    default public void _a(Predicate<String> predicate) {
        this.renderOnly(predicate, null);
    }

    default public void _a(int n) {
        this.renderPart(n, null);
    }

    public void renderOnly(Predicate<String> var1, cucv var2);

    public void renderAll(cucv var1);

    public void renderPart(String var1, cucv var2);

    public void renderPart(int var1, cucv var2);
}

