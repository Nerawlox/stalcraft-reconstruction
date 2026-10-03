/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.hooklib.asm;

import java.util.logging.Level;
import java.util.logging.Logger;

public interface HookLogger {
    public void debug(String var1);

    public void warning(String var1);

    public void severe(String var1);

    public void severe(String var1, Throwable var2);

    public static class VanillaLogger
    implements HookLogger {
        private Logger logger;

        public VanillaLogger(Logger logger) {
            this.logger = logger;
        }

        @Override
        public void debug(String string) {
            this.logger.fine(string);
        }

        @Override
        public void warning(String string) {
            this.logger.warning(string);
        }

        @Override
        public void severe(String string) {
            this.logger.severe(string);
        }

        @Override
        public void severe(String string, Throwable throwable) {
            this.logger.log(Level.SEVERE, string, throwable);
        }
    }

    public static class SystemOutLogger
    implements HookLogger {
        @Override
        public void debug(String string) {
            System.out.println("[DEBUG] " + string);
        }

        @Override
        public void warning(String string) {
            System.out.println("[WARNING] " + string);
        }

        @Override
        public void severe(String string) {
            System.out.println("[SEVERE] " + string);
        }

        @Override
        public void severe(String string, Throwable throwable) {
            this.severe(string);
            throwable.printStackTrace();
        }
    }
}

