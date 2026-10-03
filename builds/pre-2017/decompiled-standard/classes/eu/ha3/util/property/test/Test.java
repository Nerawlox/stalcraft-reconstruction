/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.util.property.test;

import eu.ha3.util.property.contract.PropertyHolder;
import eu.ha3.util.property.simple.ConfigProperty;
import java.util.Map;

public class Test
implements Runnable {
    public static void main(String[] stringArray) {
        new Test().run();
    }

    @Override
    public void run() {
        ConfigProperty configProperty = new ConfigProperty();
        configProperty.setProperty("derp", "Yes");
        configProperty.setProperty("boo", true);
        configProperty.commit();
        configProperty.setSource("user.cfg");
        configProperty.load();
        configProperty.save();
        this.printHolder(configProperty);
    }

    private void printHolder(PropertyHolder propertyHolder) {
        System.out.println("- " + propertyHolder.toString());
        for (Map.Entry<String, String> entry : propertyHolder.getAllProperties().entrySet()) {
            System.out.println("  - " + entry.getKey().toString() + "\t: " + entry.getValue().toString());
        }
    }
}

