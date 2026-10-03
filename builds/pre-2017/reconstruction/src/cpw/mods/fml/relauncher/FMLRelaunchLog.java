/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.relauncher;

import com.google.common.base.Throwables;
import cpw.mods.fml.relauncher.FMLLogFormatter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import net.minecraft.launchwrapper.LogWrapper;

public class FMLRelaunchLog {
    public static FMLRelaunchLog log = new FMLRelaunchLog();
    static File minecraftHome;
    private static boolean configured;
    private static Thread consoleLogThread;
    private static PrintStream errCache;
    private Logger myLog;
    private static FileHandler fileHandler;
    private static FMLLogFormatter formatter;
    static String logFileNamePattern;

    private FMLRelaunchLog() {
    }

    private static void configureLogging() {
        LogManager.getLogManager().reset();
        Logger logger = Logger.getLogger("global");
        logger.setLevel(Level.OFF);
        FMLRelaunchLog.log.myLog = Logger.getLogger("ForgeModLoader");
        LogWrapper.retarget(FMLRelaunchLog.log.myLog);
        Logger logger2 = Logger.getLogger("STDOUT");
        logger2.setParent(FMLRelaunchLog.log.myLog);
        Logger logger3 = Logger.getLogger("STDERR");
        logger3.setParent(FMLRelaunchLog.log.myLog);
        FMLRelaunchLog.log.myLog.setLevel(Level.ALL);
        FMLRelaunchLog.log.myLog.setUseParentHandlers(false);
        consoleLogThread = new Thread(new ConsoleLogThread());
        consoleLogThread.setDaemon(true);
        consoleLogThread.start();
        formatter = new FMLLogFormatter();
        try {
            File file = new File(minecraftHome, logFileNamePattern);
            fileHandler = new FileHandler(file.getPath(), 0, 3){

                @Override
                public synchronized void close() throws SecurityException {
                }
            };
        }
        catch (Throwable throwable) {
            throw Throwables.propagate(throwable);
        }
        FMLRelaunchLog.resetLoggingHandlers();
        errCache = System.err;
        System.setOut(new PrintStream(new LoggingOutStream(logger2), true));
        System.setErr(new PrintStream(new LoggingOutStream(logger3), true));
        configured = true;
    }

    private static void resetLoggingHandlers() {
        ConsoleLogThread.wrappedHandler.setLevel(Level.parse(System.getProperty("fml.log.level", "INFO")));
        FMLRelaunchLog.log.myLog.addHandler(new ConsoleLogWrapper());
        ConsoleLogThread.wrappedHandler.setFormatter(formatter);
        fileHandler.setLevel(Level.ALL);
        fileHandler.setFormatter(formatter);
        FMLRelaunchLog.log.myLog.addHandler(fileHandler);
    }

    public static void loadLogConfiguration(File file) {
        if (file != null && file.exists() && file.canRead()) {
            try {
                LogManager.getLogManager().readConfiguration(new FileInputStream(file));
                FMLRelaunchLog.resetLoggingHandlers();
            }
            catch (Exception exception) {
                FMLRelaunchLog.log(Level.SEVERE, exception, "Error reading logging configuration file %s", file.getName());
            }
        }
    }

    public static void log(String string, Level level, String string2, Object ... objectArray) {
        FMLRelaunchLog.makeLog(string);
        Logger.getLogger(string).log(level, String.format(string2, objectArray));
    }

    public static void log(Level level, String string, Object ... objectArray) {
        if (!configured) {
            FMLRelaunchLog.configureLogging();
        }
        FMLRelaunchLog.log.myLog.log(level, String.format(string, objectArray));
    }

    public static void log(String string, Level level, Throwable throwable, String string2, Object ... objectArray) {
        FMLRelaunchLog.makeLog(string);
        Logger.getLogger(string).log(level, String.format(string2, objectArray), throwable);
    }

    public static void log(Level level, Throwable throwable, String string, Object ... objectArray) {
        if (!configured) {
            FMLRelaunchLog.configureLogging();
        }
        FMLRelaunchLog.log.myLog.log(level, String.format(string, objectArray), throwable);
    }

    public static void severe(String string, Object ... objectArray) {
        FMLRelaunchLog.log(Level.SEVERE, string, objectArray);
    }

    public static void warning(String string, Object ... objectArray) {
        FMLRelaunchLog.log(Level.WARNING, string, objectArray);
    }

    public static void info(String string, Object ... objectArray) {
        FMLRelaunchLog.log(Level.INFO, string, objectArray);
    }

    public static void fine(String string, Object ... objectArray) {
        FMLRelaunchLog.log(Level.FINE, string, objectArray);
    }

    public static void finer(String string, Object ... objectArray) {
        FMLRelaunchLog.log(Level.FINER, string, objectArray);
    }

    public static void finest(String string, Object ... objectArray) {
        FMLRelaunchLog.log(Level.FINEST, string, objectArray);
    }

    public Logger getLogger() {
        return this.myLog;
    }

    public static void makeLog(String string) {
        Logger logger = Logger.getLogger(string);
        logger.setParent(FMLRelaunchLog.log.myLog);
    }

    private static class LoggingOutStream
    extends ByteArrayOutputStream {
        private Logger log;
        private StringBuilder currentMessage;

        public LoggingOutStream(Logger logger) {
            this.log = logger;
            this.currentMessage = new StringBuilder();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void flush() throws IOException {
            Class<FMLRelaunchLog> clazz = FMLRelaunchLog.class;
            synchronized (FMLRelaunchLog.class) {
                super.flush();
                String string = this.toString();
                super.reset();
                this.currentMessage.append(string.replace(FMLLogFormatter.LINE_SEPARATOR, "\n"));
                int n = -1;
                int n2 = this.currentMessage.indexOf("\n", n + 1);
                while (n2 >= 0) {
                    this.log.log(Level.INFO, this.currentMessage.substring(n + 1, n2));
                    n = n2;
                    n2 = this.currentMessage.indexOf("\n", n + 1);
                }
                if (n >= 0) {
                    String string2 = this.currentMessage.substring(n + 1);
                    this.currentMessage.setLength(0);
                    this.currentMessage.append(string2);
                }
                // ** MonitorExit[var2_1] (shouldn't be in output)
                return;
            }
        }
    }

    private static class ConsoleLogThread
    implements Runnable {
        static ConsoleHandler wrappedHandler = new ConsoleHandler();
        static LinkedBlockingQueue<LogRecord> recordQueue = new LinkedBlockingQueue();

        private ConsoleLogThread() {
        }

        @Override
        public void run() {
            while (true) {
                try {
                    LogRecord logRecord = recordQueue.take();
                    wrappedHandler.publish(logRecord);
                    continue;
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace(errCache);
                    Thread.interrupted();
                    continue;
                }
                break;
            }
        }
    }

    private static class ConsoleLogWrapper
    extends Handler {
        private ConsoleLogWrapper() {
        }

        @Override
        public void publish(LogRecord logRecord) {
            boolean bl = Thread.interrupted();
            try {
                ConsoleLogThread.recordQueue.put(logRecord);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace(errCache);
            }
            if (bl) {
                Thread.currentThread().interrupt();
            }
        }

        @Override
        public void flush() {
        }

        @Override
        public void close() throws SecurityException {
        }
    }
}

