/*
 * Decompiled with CFR 0.152.
 */
package joptsimple;

import java.util.Collection;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.ArgumentList;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
class OptionalArgumentOptionSpec<V>
extends ArgumentAcceptingOptionSpec<V> {
    OptionalArgumentOptionSpec(String option) {
        super(option, false);
    }

    OptionalArgumentOptionSpec(Collection<String> options, String description) {
        super(options, false, description);
    }

    @Override
    protected void detectOptionArgument(OptionParser parser, ArgumentList arguments2, OptionSet detectedOptions) {
        if (arguments2.hasMore()) {
            String nextArgument = arguments2.peek();
            if (!parser.looksLikeAnOption(nextArgument)) {
                this.handleOptionArgument(parser, detectedOptions, arguments2);
            } else if (this.isArgumentOfNumberType() && this.canConvertArgument(nextArgument)) {
                this.addArguments(detectedOptions, arguments2.next());
            } else {
                detectedOptions.add(this);
            }
        } else {
            detectedOptions.add(this);
        }
    }

    private void handleOptionArgument(OptionParser parser, OptionSet detectedOptions, ArgumentList arguments2) {
        if (parser.posixlyCorrect()) {
            detectedOptions.add(this);
            parser.noMoreOptions();
        } else {
            this.addArguments(detectedOptions, arguments2.next());
        }
    }
}

