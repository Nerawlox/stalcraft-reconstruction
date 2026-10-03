/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.mcsa;

import gloomyfolken.mods.effects.client.mcsa.zwat;
import java.util.function.Predicate;

interface zwaw
extends zwat {
    public zwat getWrappedRenderHelper();

    @Override
    default public void renderOnly(Predicate<String> predicate, cucv cucv2) {
        zwat zwat2 = this.getWrappedRenderHelper();
        if (zwat2 != null) {
            zwat2.renderOnly(predicate, cucv2);
        }
    }

    @Override
    default public void renderAll(cucv cucv2) {
        zwat zwat2 = this.getWrappedRenderHelper();
        if (zwat2 != null) {
            zwat2.renderAll(cucv2);
        }
    }

    @Override
    default public void renderPart(String string, cucv cucv2) {
        zwat zwat2 = this.getWrappedRenderHelper();
        if (zwat2 != null) {
            zwat2.renderPart(string, cucv2);
        }
    }

    @Override
    default public void renderPart(int n, cucv cucv2) {
        zwat zwat2 = this.getWrappedRenderHelper();
        if (zwat2 != null) {
            zwat2.renderPart(n, cucv2);
        }
    }
}

