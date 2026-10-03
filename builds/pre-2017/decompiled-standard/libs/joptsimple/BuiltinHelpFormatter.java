/*
 * Decompiled with CFR 0.152.
 */
package joptsimple;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import joptsimple.HelpFormatter;
import joptsimple.OptionDescriptor;
import joptsimple.ParserRules;
import joptsimple.internal.Classes;
import joptsimple.internal.Rows;
import joptsimple.internal.Strings;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class BuiltinHelpFormatter
implements HelpFormatter {
    private final Rows nonOptionRows;
    private final Rows optionRows;

    BuiltinHelpFormatter() {
        this(80, 2);
    }

    public BuiltinHelpFormatter(int desiredOverallWidth, int desiredColumnSeparatorWidth) {
        this.nonOptionRows = new Rows(desiredOverallWidth * 2, 0);
        this.optionRows = new Rows(desiredOverallWidth, desiredColumnSeparatorWidth);
    }

    @Override
    public String format(Map<String, ? extends OptionDescriptor> options) {
        Comparator<OptionDescriptor> comparator = new Comparator<OptionDescriptor>(){

            @Override
            public int compare(OptionDescriptor first, OptionDescriptor second) {
                return first.options().iterator().next().compareTo(second.options().iterator().next());
            }
        };
        TreeSet<OptionDescriptor> sorted2 = new TreeSet<OptionDescriptor>(comparator);
        sorted2.addAll(options.values());
        this.addRows(sorted2);
        return this.formattedHelpOutput();
    }

    private String formattedHelpOutput() {
        StringBuilder formatted = new StringBuilder();
        String nonOptionDisplay = this.nonOptionRows.render();
        if (!Strings.isNullOrEmpty(nonOptionDisplay)) {
            formatted.append(nonOptionDisplay).append(Strings.LINE_SEPARATOR);
        }
        formatted.append(this.optionRows.render());
        return formatted.toString();
    }

    private void addRows(Collection<? extends OptionDescriptor> options) {
        this.addNonOptionsDescription(options);
        if (options.isEmpty()) {
            this.optionRows.add("No options specified", "");
        } else {
            this.addHeaders(options);
            this.addOptions(options);
        }
        this.fitRowsToWidth();
    }

    private void addNonOptionsDescription(Collection<? extends OptionDescriptor> options) {
        OptionDescriptor nonOptions = this.findAndRemoveNonOptionsSpec(options);
        if (this.shouldShowNonOptionArgumentDisplay(nonOptions)) {
            this.nonOptionRows.add("Non-option arguments:", "");
            this.nonOptionRows.add(this.createNonOptionArgumentsDisplay(nonOptions), "");
        }
    }

    private boolean shouldShowNonOptionArgumentDisplay(OptionDescriptor nonOptions) {
        return !Strings.isNullOrEmpty(nonOptions.description()) || !Strings.isNullOrEmpty(nonOptions.argumentTypeIndicator()) || !Strings.isNullOrEmpty(nonOptions.argumentDescription());
    }

    private String createNonOptionArgumentsDisplay(OptionDescriptor nonOptions) {
        StringBuilder buffer = new StringBuilder();
        this.maybeAppendOptionInfo(buffer, nonOptions);
        this.maybeAppendNonOptionsDescription(buffer, nonOptions);
        return buffer.toString();
    }

    private void maybeAppendNonOptionsDescription(StringBuilder buffer, OptionDescriptor nonOptions) {
        buffer.append(buffer.length() > 0 && !Strings.isNullOrEmpty(nonOptions.description()) ? " -- " : "").append(nonOptions.description());
    }

    private OptionDescriptor findAndRemoveNonOptionsSpec(Collection<? extends OptionDescriptor> options) {
        Iterator<? extends OptionDescriptor> it = options.iterator();
        while (it.hasNext()) {
            OptionDescriptor next = it.next();
            if (!next.representsNonOptions()) continue;
            it.remove();
            return next;
        }
        throw new AssertionError((Object)"no non-options argument spec");
    }

    private void addHeaders(Collection<? extends OptionDescriptor> options) {
        if (this.hasRequiredOption(options)) {
            this.optionRows.add("Option (* = required)", "Description");
            this.optionRows.add("---------------------", "-----------");
        } else {
            this.optionRows.add("Option", "Description");
            this.optionRows.add("------", "-----------");
        }
    }

    private boolean hasRequiredOption(Collection<? extends OptionDescriptor> options) {
        for (OptionDescriptor optionDescriptor : options) {
            if (!optionDescriptor.isRequired()) continue;
            return true;
        }
        return false;
    }

    private void addOptions(Collection<? extends OptionDescriptor> options) {
        for (OptionDescriptor optionDescriptor : options) {
            if (optionDescriptor.representsNonOptions()) continue;
            this.optionRows.add(this.createOptionDisplay(optionDescriptor), this.createDescriptionDisplay(optionDescriptor));
        }
    }

    private String createOptionDisplay(OptionDescriptor descriptor2) {
        StringBuilder buffer = new StringBuilder(descriptor2.isRequired() ? "* " : "");
        Iterator<String> i = descriptor2.options().iterator();
        while (i.hasNext()) {
            String option = i.next();
            buffer.append(option.length() > 1 ? "--" : ParserRules.HYPHEN);
            buffer.append(option);
            if (!i.hasNext()) continue;
            buffer.append(", ");
        }
        this.maybeAppendOptionInfo(buffer, descriptor2);
        return buffer.toString();
    }

    private void maybeAppendOptionInfo(StringBuilder buffer, OptionDescriptor descriptor2) {
        String indicator = this.extractTypeIndicator(descriptor2);
        String description = descriptor2.argumentDescription();
        if (indicator != null || !Strings.isNullOrEmpty(description)) {
            this.appendOptionHelp(buffer, indicator, description, descriptor2.requiresArgument());
        }
    }

    private String extractTypeIndicator(OptionDescriptor descriptor2) {
        String indicator = descriptor2.argumentTypeIndicator();
        if (!Strings.isNullOrEmpty(indicator) && !String.class.getName().equals(indicator)) {
            return Classes.shortNameOf(indicator);
        }
        return null;
    }

    private void appendOptionHelp(StringBuilder buffer, String typeIndicator, String description, boolean required) {
        if (required) {
            this.appendTypeIndicator(buffer, typeIndicator, description, '<', '>');
        } else {
            this.appendTypeIndicator(buffer, typeIndicator, description, '[', ']');
        }
    }

    private void appendTypeIndicator(StringBuilder buffer, String typeIndicator, String description, char start, char end) {
        buffer.append(' ').append(start);
        if (typeIndicator != null) {
            buffer.append(typeIndicator);
        }
        if (!Strings.isNullOrEmpty(description)) {
            if (typeIndicator != null) {
                buffer.append(": ");
            }
            buffer.append(description);
        }
        buffer.append(end);
    }

    private String createDescriptionDisplay(OptionDescriptor descriptor2) {
        List<?> defaultValues = descriptor2.defaultValues();
        if (defaultValues.isEmpty()) {
            return descriptor2.description();
        }
        String defaultValuesDisplay = this.createDefaultValuesDisplay(defaultValues);
        return (descriptor2.description() + ' ' + Strings.surround("default: " + defaultValuesDisplay, '(', ')')).trim();
    }

    private String createDefaultValuesDisplay(List<?> defaultValues) {
        return defaultValues.size() == 1 ? defaultValues.get(0).toString() : defaultValues.toString();
    }

    private void fitRowsToWidth() {
        this.nonOptionRows.fitToWidth();
        this.optionRows.fitToWidth();
    }
}

