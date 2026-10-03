/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.config;

import net.smart.moving.config.SmartMovingClientConfig;
import net.smart.properties.Properties;

public class SmartMovingServerConfig
extends SmartMovingClientConfig {
    private Properties properties = new Properties();
    private Properties topProperties = new Properties();

    public void loadFromProperties(String[] stringArray, boolean bl) {
        for (int i = 0; i < stringArray.length - 1; i += 2) {
            String string = stringArray[i];
            String string2 = stringArray[i + 1];
            this.properties.put(string, string2);
            if (!bl) continue;
            this.topProperties.put(string, string2);
        }
        this.load(bl);
    }

    public void load(boolean bl) {
        if (!bl && !this.topProperties.isEmpty()) {
            for (Object object : this.topProperties.keySet()) {
                this.properties.put(object, this.topProperties.get(object));
            }
        }
        super.loadFromProperties(this.properties);
    }

    public void reset() {
        this.properties.clear();
        this.topProperties.clear();
    }
}

