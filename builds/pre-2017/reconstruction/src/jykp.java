/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import net.minecraftforge.common.Configuration;

public class jykp
extends anpn {
    public final String unlocalizedName;
    protected String localizedName;
    protected String[] valueNames;
    public int value;

    public jykp(String string, String string2, int n, String[] stringArray) {
        this.unlocalizedName = string;
        this.localizedName = string2;
        this.value = n;
        this.valueNames = stringArray;
    }

    public <T extends Enum> jykp(String string, String string2, T t, Function<? super T, String> function) {
        this(string, string2, t.ordinal(), Arrays.stream(t.getClass().getEnumConstants()).map(enum_ -> (String)function.apply(enum_)).collect(Collectors.toList()).toArray(new String[0]));
    }

    @Override
    public String getUnlocalizedName() {
        return this.unlocalizedName;
    }

    @Override
    public void onButtonPressed() {
        this.value = (this.value + 1) % this.valueNames.length;
    }

    @Override
    public String getOptionName() {
        return this.localizedName;
    }

    @Override
    public String getName() {
        return this.localizedName + ": " + this.valueNames[this.value];
    }

    @Override
    public void save(Configuration configuration) {
        configuration.get("general", this.unlocalizedName, 0).set(this.value);
    }

    @Override
    public void load(Configuration configuration) {
        this.value = configuration.get("general", this.unlocalizedName, this.value).getInt(this.value) % this.valueNames.length;
    }

    public String[] getValueNames() {
        return this.valueNames;
    }
}

