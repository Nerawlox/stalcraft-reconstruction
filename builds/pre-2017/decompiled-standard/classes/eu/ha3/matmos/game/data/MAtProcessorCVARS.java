/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.data;

import eu.ha3.matmos.engine.implem.IntegerData;
import eu.ha3.matmos.game.data.MAtProcessorModel;
import eu.ha3.matmos.game.system.MAtMod;
import eu.ha3.util.property.simple.ConfigProperty;
import eu.ha3.util.property.simple.PropertyMissingException;
import eu.ha3.util.property.simple.PropertyTypeException;
import java.io.File;
import java.io.IOException;

public class MAtProcessorCVARS
extends MAtProcessorModel {
    private File defaultsConfig = new File(this.mod().util().getModsFolder(), "matmos/dataconfigvars_defaults.cfg");
    private File userConfig = new File(this.mod().util().getModsFolder(), "matmos/dataconfigvars.cfg");
    private ConfigProperty config = new ConfigProperty();

    public MAtProcessorCVARS(MAtMod mAtMod, IntegerData integerData, String string, String string2) {
        super(mAtMod, integerData, string, string2);
        this.config.setSource(this.defaultsConfig.getAbsolutePath());
        this.config.load();
        this.config.setSource(this.userConfig.getAbsolutePath());
        if (!this.userConfig.exists()) {
            try {
                this.userConfig.createNewFile();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    @Override
    protected void doProcess() {
        this.config.load();
        for (String string : this.config.getAllProperties().keySet()) {
            try {
                int n = Integer.parseInt(string);
                this.setValue(n, this.config.getInteger(string));
            }
            catch (NumberFormatException numberFormatException) {
            }
            catch (PropertyTypeException propertyTypeException) {
            }
            catch (PropertyMissingException propertyMissingException) {
                propertyMissingException.printStackTrace();
            }
        }
    }
}

