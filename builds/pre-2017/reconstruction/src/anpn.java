/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import net.minecraft.client.gui.GuiButton;
import net.minecraftforge.common.Configuration;

public abstract class anpn
implements eizz {
    public abstract void onButtonPressed();

    public abstract String getOptionName();

    public abstract String getName();

    public abstract String getUnlocalizedName();

    public abstract void save(Configuration var1);

    public abstract void load(Configuration var1);

    @ezey(_a={eidj.CLIENT})
    public GuiButton createButton(int n, int n2, int n3) {
        return new GuiButton(n, n2, n3, 150, 20, this.getName());
    }

    public void onChanged(boolean bl) {
    }

    @Override
    public void applyLoadedState() {
        this.onChanged(false);
    }

    public boolean isEnabled() {
        return true;
    }
}

