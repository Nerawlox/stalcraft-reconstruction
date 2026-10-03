/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.MutantSkin;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantConfigHelper;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantConfiguration;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;

public class zgmg
extends oxot {
    public String _c;
    public String _d;

    public zgmg() {
    }

    public zgmg(String string, String string2, float f) {
        this._c = string;
        this._d = string2;
        this._a = f;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeUTF(this._d);
        dataOutput.writeUTF(this._c);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this._d = dataInput.readUTF();
        this._c = dataInput.readUTF();
    }

    @ezey(_a={eidj.CLIENT})
    public EntityMutant _c() {
        EntityMutant entityMutant;
        MutantConfiguration mutantConfiguration = MutantConfigHelper.CLIENT.getMobConfiguration(this._c);
        if (mutantConfiguration != null && (entityMutant = mutantConfiguration.instantiateEntity(Minecraft._E()._r)) != null) {
            entityMutant.setSkin(new MutantSkin(this._d, 1.0f));
            return entityMutant;
        }
        return null;
    }
}

