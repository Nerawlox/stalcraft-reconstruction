/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.functions;

import com.google.common.base.Function;
import cpw.mods.fml.common.ModContainer;

public final class ModIdFunction
implements Function<ModContainer, String> {
    @Override
    public String apply(ModContainer modContainer) {
        return modContainer.getModId();
    }
}

