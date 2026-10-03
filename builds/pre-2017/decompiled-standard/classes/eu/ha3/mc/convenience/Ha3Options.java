/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.mc.convenience;

import eu.ha3.mc.convenience.Ha3Personalizable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;

public class Ha3Options
implements Ha3Personalizable {
    private Collection<Ha3Personalizable> personalizables = new HashSet<Ha3Personalizable>();

    public void registerPersonalizable(Ha3Personalizable ha3Personalizable) {
        this.personalizables.add(ha3Personalizable);
    }

    @Override
    public void inputOptions(Properties properties) {
        for (Ha3Personalizable ha3Personalizable : this.personalizables) {
            ha3Personalizable.inputOptions(properties);
        }
    }

    @Override
    public Properties outputOptions() {
        Properties properties = new Properties();
        for (Ha3Personalizable ha3Personalizable : this.personalizables) {
            properties.putAll((Map<?, ?>)ha3Personalizable.outputOptions());
        }
        return properties;
    }

    @Override
    public void defaultOptions() {
        for (Ha3Personalizable ha3Personalizable : this.personalizables) {
            ha3Personalizable.defaultOptions();
        }
    }
}

