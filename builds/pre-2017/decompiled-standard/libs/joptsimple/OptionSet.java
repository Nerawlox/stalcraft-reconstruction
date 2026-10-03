/*
 * Decompiled with CFR 0.152.
 */
package joptsimple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import joptsimple.AbstractOptionSpec;
import joptsimple.MultipleArgumentsForOptionException;
import joptsimple.OptionSpec;
import joptsimple.internal.Objects;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class OptionSet {
    private final List<OptionSpec<?>> detectedSpecs = new ArrayList();
    private final Map<String, AbstractOptionSpec<?>> detectedOptions = new HashMap();
    private final Map<AbstractOptionSpec<?>, List<String>> optionsToArguments = new IdentityHashMap();
    private final Map<String, List<?>> defaultValues;

    OptionSet(Map<String, List<?>> defaults) {
        this.defaultValues = new HashMap(defaults);
    }

    public boolean hasOptions() {
        return !this.detectedOptions.isEmpty();
    }

    public boolean has(String option) {
        return this.detectedOptions.containsKey(option);
    }

    public boolean has(OptionSpec<?> option) {
        return this.optionsToArguments.containsKey(option);
    }

    public boolean hasArgument(String option) {
        AbstractOptionSpec<?> spec = this.detectedOptions.get(option);
        return spec != null && this.hasArgument(spec);
    }

    public boolean hasArgument(OptionSpec<?> option) {
        Objects.ensureNotNull(option);
        List<String> values2 = this.optionsToArguments.get(option);
        return values2 != null && !values2.isEmpty();
    }

    public Object valueOf(String option) {
        Objects.ensureNotNull(option);
        AbstractOptionSpec<?> spec = this.detectedOptions.get(option);
        if (spec == null) {
            List defaults = this.defaultValuesFor(option);
            return defaults.isEmpty() ? null : defaults.get(0);
        }
        return this.valueOf(spec);
    }

    public <V> V valueOf(OptionSpec<V> option) {
        Objects.ensureNotNull(option);
        List<V> values2 = this.valuesOf(option);
        switch (values2.size()) {
            case 0: {
                return null;
            }
            case 1: {
                return values2.get(0);
            }
        }
        throw new MultipleArgumentsForOptionException(option.options());
    }

    public List<?> valuesOf(String option) {
        Objects.ensureNotNull(option);
        AbstractOptionSpec<?> spec = this.detectedOptions.get(option);
        return spec == null ? this.defaultValuesFor(option) : this.valuesOf(spec);
    }

    public <V> List<V> valuesOf(OptionSpec<V> option) {
        Objects.ensureNotNull(option);
        List<String> values2 = this.optionsToArguments.get(option);
        if (values2 == null || values2.isEmpty()) {
            return this.defaultValueFor(option);
        }
        AbstractOptionSpec spec = (AbstractOptionSpec)option;
        ArrayList convertedValues = new ArrayList();
        for (String each : values2) {
            convertedValues.add(spec.convert(each));
        }
        return Collections.unmodifiableList(convertedValues);
    }

    public List<OptionSpec<?>> specs() {
        List<OptionSpec<?>> specs = this.detectedSpecs;
        specs.remove(this.detectedOptions.get("[arguments]"));
        return Collections.unmodifiableList(specs);
    }

    public List<?> nonOptionArguments() {
        return Collections.unmodifiableList(this.valuesOf(this.detectedOptions.get("[arguments]")));
    }

    void add(AbstractOptionSpec<?> spec) {
        this.addWithArgument(spec, null);
    }

    void addWithArgument(AbstractOptionSpec<?> spec, String argument) {
        this.detectedSpecs.add(spec);
        for (String each : spec.options()) {
            this.detectedOptions.put(each, spec);
        }
        List<String> optionArguments = this.optionsToArguments.get(spec);
        if (optionArguments == null) {
            optionArguments = new ArrayList<String>();
            this.optionsToArguments.put(spec, optionArguments);
        }
        if (argument != null) {
            optionArguments.add(argument);
        }
    }

    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null || !this.getClass().equals(that.getClass())) {
            return false;
        }
        OptionSet other = (OptionSet)that;
        HashMap thisOptionsToArguments = new HashMap(this.optionsToArguments);
        HashMap otherOptionsToArguments = new HashMap(other.optionsToArguments);
        return ((Object)this.detectedOptions).equals(other.detectedOptions) && ((Object)thisOptionsToArguments).equals(otherOptionsToArguments);
    }

    public int hashCode() {
        HashMap thisOptionsToArguments = new HashMap(this.optionsToArguments);
        return ((Object)this.detectedOptions).hashCode() ^ ((Object)thisOptionsToArguments).hashCode();
    }

    private <V> List<V> defaultValuesFor(String option) {
        if (this.defaultValues.containsKey(option)) {
            return this.defaultValues.get(option);
        }
        return Collections.emptyList();
    }

    private <V> List<V> defaultValueFor(OptionSpec<V> option) {
        return this.defaultValuesFor(option.options().iterator().next());
    }
}

