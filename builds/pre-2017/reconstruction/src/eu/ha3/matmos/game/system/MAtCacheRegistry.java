/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.system;

import eu.ha3.matmos.conv.CacheRegistry;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.client.Minecraft;

public class MAtCacheRegistry
implements CacheRegistry {
    private Set<String> set = new HashSet<String>();

    @Override
    public void clear() {
        this.set.clear();
    }

    @Override
    public void cacheSound(String string) {
        if (this.set.contains(string)) {
            return;
        }
        Minecraft._E()._N._a(string);
        this.set.add(string);
    }
}

