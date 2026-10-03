/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.packet;

import gloomyfolken.bundle.common.core.qlgf;
import gloomyfolken.mods.stalker.mobs.client.tuning.gui.MutantConfigEdit;
import gloomyfolken.mods.stalker.mobs.entity.config.ConfigJsonHelper;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantConfigHelper;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantConfiguration;
import gloomyfolken.mods.stalker.mobs.packet.PacketConfig;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Map;

public class PacketConfigList
extends PacketConfig {
    public qoac tag = new qoac();
    public boolean requestFromUi = false;
    public boolean specialConfigEdit = false;

    public PacketConfigList() {
    }

    public PacketConfigList(MutantConfiguration mutantConfiguration, boolean bl) {
        this.tag._a(mutantConfiguration.getCommon().getName(), ConfigJsonHelper.write(mutantConfiguration));
        this.requestFromUi = bl;
        this.specialConfigEdit = true;
    }

    public PacketConfigList(Map<String, MutantConfiguration> map, boolean bl) {
        this(map, bl, false);
    }

    public PacketConfigList(Map<String, MutantConfiguration> map, boolean bl, boolean bl2) {
        map.forEach((string, mutantConfiguration) -> this.tag._a((String)string, ConfigJsonHelper.write(mutantConfiguration)));
        this.specialConfigEdit = bl2;
        this.requestFromUi = bl;
    }

    @Override
    public void processClient(boolean bl) {
        if (!this.specialConfigEdit) {
            MutantConfigHelper.CLIENT.clearMobConfigs();
        }
        this.tag._c.forEach((object, object2) -> {
            String string = ((xsxy)object2)._c;
            MutantConfigHelper.CLIENT.addMobConfig((String)object, ConfigJsonHelper.read(string, MutantConfiguration.class));
        });
        if (this.requestFromUi) {
            if (this.specialConfigEdit) {
                String string = this.tag._c.keySet().stream().findFirst().orElse(null);
                if (string != null) {
                    MutantConfigEdit.setup(MutantConfigHelper.CLIENT.getMobConfiguration(string));
                }
            } else {
                MutantConfigEdit.setup(MutantConfigHelper.CLIENT.getEditableMobConfigs().values());
            }
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this.tag = qlgf.readNBTTagCompound(dataInput);
        this.requestFromUi = dataInput.readBoolean();
        this.specialConfigEdit = dataInput.readBoolean();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        qlgf.writeNBTTagCompound(this.tag, dataOutput);
        dataOutput.writeBoolean(this.requestFromUi);
        dataOutput.writeBoolean(this.specialConfigEdit);
    }
}

