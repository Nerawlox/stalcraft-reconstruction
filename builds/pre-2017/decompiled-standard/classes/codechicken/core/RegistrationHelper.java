/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core;

import net.minecraft.entity.Entity;
import net.minecraft.entity.jgro;

public class RegistrationHelper {
    public static void registerHandledEntity(Class<? extends Entity> clazz, String string) {
        jgro._b.put(clazz, string);
        jgro._a.put(string, clazz);
    }
}

