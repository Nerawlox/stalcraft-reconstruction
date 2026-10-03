/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.functions;

import com.google.common.base.Function;
import cpw.mods.fml.common.ModContainer;

public class ModNameFunction
implements Function<ModContainer, String> {
    @Override
    public String apply(ModContainer modContainer) {
        return modContainer.getName();
    }
}

