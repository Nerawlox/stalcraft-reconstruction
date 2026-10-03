/*
 * Decompiled with CFR 0.152.
 */
import net.minecraftforge.common.Configuration;

public class sbcg
extends anpn {
    private String unlocalizedName;
    private String localizedName;
    public boolean enabled;

    public sbcg(String string, String string2, boolean bl) {
        this.unlocalizedName = string;
        this.localizedName = string2;
        this.enabled = bl;
    }

    @Override
    public void onButtonPressed() {
        this.enabled = !this.enabled;
    }

    @Override
    public String getUnlocalizedName() {
        return this.unlocalizedName;
    }

    @Override
    public String getOptionName() {
        return this.localizedName;
    }

    @Override
    public String getName() {
        return this.localizedName + ": " + (this.enabled ? "\u0412\u043a\u043b." : "\u0412\u044b\u043a\u043b.");
    }

    @Override
    public void save(Configuration configuration) {
        configuration.get("general", this.unlocalizedName, true).set(this.enabled);
    }

    @Override
    public void load(Configuration configuration) {
        this.enabled = configuration.get("general", this.unlocalizedName, this.enabled).getBoolean(this.enabled);
    }
}

