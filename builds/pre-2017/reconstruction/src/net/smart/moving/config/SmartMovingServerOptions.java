/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.config;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;
import net.smart.moving.IEntityPlayerMP;
import net.smart.moving.config.SmartMovingConfig;
import net.smart.properties.Properties;
import net.smart.properties.Property;

public class SmartMovingServerOptions {
    public final SmartMovingConfig config;
    public final File optionsPath;
    public final Logger logger;
    private final Property _userConfigKeys;

    public SmartMovingServerOptions(SmartMovingConfig smartMovingConfig, File file, Logger logger, int n) {
        this.config = smartMovingConfig;
        this.logger = logger;
        this.optionsPath = file;
        smartMovingConfig.loadOptionsFromAssets();
        Property property = null;
        Property property2 = null;
        switch (n) {
            default: {
                property = smartMovingConfig._survivalDefaultConfigKey;
                property2 = smartMovingConfig._survivalConfigKeys;
                this._userConfigKeys = smartMovingConfig._survivalDefaultConfigUserKeys;
                break;
            }
            case 1: {
                property = smartMovingConfig._creativeDefaultConfigKey;
                property2 = smartMovingConfig._creativeConfigKeys;
                this._userConfigKeys = smartMovingConfig._creativeDefaultConfigUserKeys;
                break;
            }
            case 2: {
                property = smartMovingConfig._adventureDefaultConfigKey;
                property2 = smartMovingConfig._adventureConfigKeys;
                this._userConfigKeys = smartMovingConfig._adventureDefaultConfigUserKeys;
            }
        }
        smartMovingConfig.setKeys((String[])property2.value);
        smartMovingConfig.setCurrentKey(property != null && !((String)property.value).isEmpty() ? (String)property.value : null);
    }

    public String[] writeToProperties() {
        return this.writeToProperties(null, null);
    }

    public String[] writeToProperties(IEntityPlayerMP iEntityPlayerMP, String string) {
        if (string == null ? !this.config.enabled : string == "disabled") {
            return new String[]{this.config._globalConfig.getCurrentKey(), this.config._globalConfig.getValueString()};
        }
        Properties properties = new Properties();
        this.config.write(properties, string);
        String[] stringArray = new String[properties.size() * 2];
        Iterator<Map.Entry<Object, Object>> iterator2 = properties.entrySet().iterator();
        String string2 = iEntityPlayerMP != null ? this.config._speedUserExponent.getCurrentKey() : null;
        int n = 0;
        while (iterator2.hasNext()) {
            Integer n2;
            Map.Entry<Object, Object> entry = iterator2.next();
            int n3 = n++;
            String string3 = entry.getKey().toString();
            stringArray[n3] = string3;
            String string4 = string3;
            if (iEntityPlayerMP != null && string4.equals(string2) && (n2 = (Integer)((Map)this.config._speedUsersExponents.value).get(iEntityPlayerMP.getUsername())) != null) {
                entry.setValue(this.config._speedUserExponent.getValueString(n2));
            }
            stringArray[n++] = entry.getValue().toString();
        }
        return stringArray;
    }
}

