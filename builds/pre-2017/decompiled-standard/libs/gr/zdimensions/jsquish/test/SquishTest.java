/*
 * Decompiled with CFR 0.152.
 */
package gr.zdimensions.jsquish.test;

import gr.zdimensions.jsquish.test.ErrorUtil;
import gr.zdimensions.jsquish.test.ResourceIO;
import gr.zdimensions.jsquish.test.StartupDialog;
import gr.zdimensions.jsquish.test.TextureDXT;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.OpenGLException;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.opengl.Util;

public final class SquishTest {
    private static final String TITLE = "JSquish Test";
    private static long lastLoad;
    private static boolean run;
    private static boolean vSync;
    private static float frameTime;
    private static double fps;
    private static int WIDTH;
    private static int HEIGHT;
    private static float camX;
    private static float camY;
    private static float SCALE;
    private static final Loader loader;
    private static TextureDXT texture;
    private static int activeTexture;

    static {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        run = true;
        vSync = true;
        loader = new Loader();
    }

    private SquishTest() {
    }

    public static void main(String[] args) {
        String libPath;
        switch (LWJGLUtil.getPlatform()) {
            case 3: {
                libPath = "lib/windows";
                break;
            }
            case 1: {
                libPath = "lib/linux";
                break;
            }
            case 2: {
                libPath = "lib/macosx";
                break;
            }
            default: {
                throw new RuntimeException("Unsupported platform: " + LWJGLUtil.getPlatformName());
            }
        }
        System.setProperty("org.lwjgl.librarypath", new File(libPath).getAbsolutePath());
        new StartupDialog().showCentered();
    }

    static void start(final DisplayMode displayMode, final boolean fullscreen) {
        new Thread(){

            public void run() {
                try {
                    SquishTest.initialize(displayMode);
                }
                catch (Exception e) {
                    ErrorUtil.errorKillEngine("Failed to initialize viewer", e);
                }
                try {
                    SquishTest.loadImage(ResourceIO.resourceReadImage("images/intro.png"));
                }
                catch (Exception e) {
                    Sys.alert("Failed to load image.", ErrorUtil.errorGetMessage(e));
                }
                if (fullscreen) {
                    SquishTest.toggleFullscreen();
                }
                SquishTest.mainLoop();
                SquishTest.quit(true);
            }
        }.start();
    }

    private static void mainLoop() {
        long frameStart = 0L;
        long lastFrameTime = 0L;
        long fpsStart = 0L;
        int fpsCounter = 0;
        while (run) {
            if (!Display.isActive()) {
                Thread.yield();
            } else {
                frameStart = Sys.getTime();
                frameTime = (float)((double)(frameStart - lastFrameTime) / (double)Sys.getTimerResolution());
                lastFrameTime = frameStart;
                SquishTest.handleIO();
                SquishTest.renderBG();
                SquishTest.renderShape();
                try {
                    Util.checkGLError();
                }
                catch (Exception e) {
                    ErrorUtil.errorKillEngine("OpenGL error occured during rendering.", e);
                }
            }
            Display.update();
            if (Display.isCloseRequested()) break;
            if (fpsCounter == 0) {
                fpsStart = frameStart;
                ++fpsCounter;
                continue;
            }
            long fpsUpdateTicks = frameStart - fpsStart;
            ++fpsCounter;
            if (fpsUpdateTicks < Sys.getTimerResolution()) continue;
            fps = (double)((long)fpsCounter * Sys.getTimerResolution()) / (double)fpsUpdateTicks;
            SquishTest.updateTitle();
            fpsCounter = 0;
        }
    }

    private static void updateTitle() {
        StringBuilder buffer = new StringBuilder(32);
        buffer.append(TITLE);
        switch (activeTexture) {
            case 0: {
                buffer.append(" [UNCOMPRESSED]");
                break;
            }
            case 1: {
                buffer.append(" [COMPRESSED - DRIVER]");
                break;
            }
            case 2: {
                buffer.append(" [COMPRESSED - RANGE FIT]");
                break;
            }
            case 3: {
                buffer.append(" [COMPRESSED - CLUSTER FIT]");
            }
        }
        buffer.append(" @ ");
        buffer.append(Math.round(fps));
        buffer.append("fps");
        Display.setTitle(buffer.toString());
    }

    private static void initialize(DisplayMode displayMode) {
        try {
            Display.setDisplayMode(displayMode);
            SquishTest.updateTitle();
            Display.setVSyncEnabled(vSync);
            try {
                Display.setIcon(new ByteBuffer[]{ResourceIO.resourceReadImageBuffer("images/icon.png")});
            }
            catch (IOException iOException) {
                // empty catch block
            }
            Display.create(new PixelFormat(24, 8, 24, 0, 0));
        }
        catch (LWJGLException e) {
            ErrorUtil.errorKillEngine(e);
        }
        WIDTH = displayMode.getWidth();
        HEIGHT = displayMode.getHeight();
        ContextCapabilities caps = GLContext.getCapabilities();
        if (!caps.OpenGL13) {
            ErrorUtil.errorKillEngine("Unsupported feature", "OpenGL 1.3 is not supported.");
        }
        if (!caps.GL_EXT_texture_compression_s3tc) {
            ErrorUtil.errorKillEngine("Unsupported feature", "EXT_texture_compression_s3tc is not supported.");
        }
        GL11.glViewport(0, 0, WIDTH, HEIGHT);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0, WIDTH, 0.0, -HEIGHT, -1.0, 1.0);
        GL11.glPushMatrix();
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, -HEIGHT, -1.0f);
        GL11.glPushMatrix();
        GL11.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
        GL11.glClearDepth(1.0);
        GL11.glDepthFunc(515);
        GL11.glHint(3152, 4354);
        GL11.glFrontFace(2305);
        GL11.glPolygonMode(1028, 6914);
        GL11.glPixelStorei(3317, 1);
        GL11.glPixelStorei(3333, 1);
        GL11.glCullFace(1029);
        GL11.glEnable(2884);
        GL11.glShadeModel(7425);
        GL11.glTexEnvi(8960, 8704, 7681);
        try {
            Util.checkGLError();
        }
        catch (OpenGLException e) {
            ErrorUtil.errorKillEngine("OpenGL initialization failed.", e);
        }
    }

    private static void loadImage(BufferedImage image) {
        TextureDXT newTexture = new TextureDXT(image);
        if (texture != null) {
            texture.release();
        }
        texture = newTexture;
        SquishTest.resetView();
    }

    private static void toggleFullscreen() {
        try {
            Display.setFullscreen(!Display.isFullscreen());
        }
        catch (LWJGLException lWJGLException) {
            // empty catch block
        }
    }

    private static void handleIO() {
        if (Keyboard.getNumKeyboardEvents() != 0) {
            block10: while (Keyboard.next()) {
                if (Keyboard.getEventKeyState()) continue;
                switch (Keyboard.getEventKey()) {
                    case 199: {
                        SquishTest.resetView();
                        break;
                    }
                    case 24: {
                        loader.load();
                        break;
                    }
                    case 46: {
                        if (++activeTexture > 3) {
                            activeTexture = 0;
                        }
                        SquishTest.updateTitle();
                        break;
                    }
                    case 47: {
                        vSync = !vSync;
                        Display.setVSyncEnabled(vSync);
                        break;
                    }
                    case 1: {
                        if (Sys.getTime() - lastLoad < Sys.getTimerResolution()) continue block10;
                        run = false;
                    }
                }
            }
        }
        int speed = Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54) ? 4 : 1;
        float speedScale = (float)Math.sqrt(SCALE) * frameTime * 128.0f;
        if (Keyboard.isKeyDown(203)) {
            camX += (float)speed * speedScale;
        } else if (Keyboard.isKeyDown(205)) {
            camX -= (float)speed * speedScale;
        }
        if (Keyboard.isKeyDown(200)) {
            camY += (float)speed * speedScale;
        } else if (Keyboard.isKeyDown(208)) {
            camY -= (float)speed * speedScale;
        }
        if (Keyboard.isKeyDown(74) || Keyboard.isKeyDown(12)) {
            SquishTest.zoomView((float)speed * speedScale * -1.0f);
        } else if (Keyboard.isKeyDown(78) || Keyboard.isKeyDown(13)) {
            SquishTest.zoomView((float)speed * speedScale * 1.0f);
        }
        while (Mouse.next()) {
            switch (Mouse.getEventButton()) {
                case -1: {
                    if (Mouse.getEventDWheel() == 0) break;
                    SquishTest.zoomView(speed * (Mouse.getEventDWheel() > 0 ? 1 : -1));
                }
            }
        }
    }

    private static void resetView() {
        float zoomX = (float)(WIDTH - 32) / (float)texture.getWidth();
        float zoomY = (float)(HEIGHT - 32) / (float)texture.getHeight();
        SCALE = Math.min(zoomX, zoomY);
        camX = WIDTH >> 1;
        camY = HEIGHT >> 1;
    }

    private static void zoomView(float units) {
        float zoomLevels = units * 0.01f;
        if (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54)) {
            zoomLevels *= 4.0f;
        }
        float scale = SCALE;
        if ((scale += zoomLevels) < 0.1f) {
            scale = 0.1f;
        }
        SquishTest.setViewZoom(scale);
    }

    private static void setViewZoom(float scale) {
        float ratio = scale / SCALE - 1.0f;
        camX += ratio * (camX - (float)(WIDTH >> 1));
        camY += ratio * (camY - (float)(HEIGHT >> 1));
        SCALE = (float)Math.round(scale * 100.0f) * 0.01f;
    }

    private static void renderBG() {
        GL11.glClear(16640);
        GL11.glBegin(7);
        GL11.glColor3f(1.0f, 1.0f, 0.0f);
        GL11.glVertex2i(0, 0);
        GL11.glColor3f(1.0f, 0.0f, 1.0f);
        GL11.glVertex2i(0, HEIGHT);
        GL11.glColor3f(0.0f, 1.0f, 0.0f);
        GL11.glVertex2i(WIDTH, HEIGHT);
        GL11.glColor3f(1.0f, 0.0f, 0.0f);
        GL11.glVertex2i(WIDTH, 0);
        GL11.glEnd();
    }

    private static void renderShape() {
        int texID;
        if (texture == null) {
            return;
        }
        GL11.glTranslatef(camX, camY, 0.0f);
        GL11.glScalef(SCALE, SCALE, 1.0f);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(3553);
        int w = texture.getWidth();
        int h = texture.getHeight();
        GL11.glPushMatrix();
        GL11.glTranslatef((float)(-w) * 0.5f, (float)(-h) * 0.5f, 0.0f);
        switch (activeTexture) {
            case 0: {
                texID = texture.getUncompressed();
                break;
            }
            case 1: {
                texID = texture.getCompressedDriver();
                break;
            }
            case 2: {
                texID = texture.getCompressedRangeFit();
                break;
            }
            default: {
                texID = texture.getCompressedClusterFit();
            }
        }
        GL11.glBindTexture(3553, texID);
        SquishTest.renderQuad(texture);
        GL11.glPopMatrix();
        GL11.glDisable(3553);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
    }

    private static void renderQuad(TextureDXT texture) {
        GL11.glBegin(7);
        GL11.glTexCoord2f(0.0f, 0.0f);
        GL11.glVertex2i(0, 0);
        GL11.glTexCoord2f(0.0f, 1.0f);
        GL11.glVertex2i(0, texture.getHeight());
        GL11.glTexCoord2f(1.0f, 1.0f);
        GL11.glVertex2i(texture.getWidth(), texture.getHeight());
        GL11.glTexCoord2f(1.0f, 0.0f);
        GL11.glVertex2i(texture.getWidth(), 0);
        GL11.glEnd();
    }

    static void quit(boolean normal) {
        if (Display.isCreated()) {
            if (texture != null) {
                texture.release();
            }
            Display.destroy();
        }
        System.exit(normal ? 0 : -1);
    }

    private static class ImageFileFilter
    extends FileFilter {
        private final String description;
        private final String[] types;

        ImageFileFilter(String description, String ... types) {
            this.description = description;
            this.types = types;
        }

        public boolean accept(File file) {
            if (file.isDirectory()) {
                return true;
            }
            String name2 = file.getName();
            int dotIndex = name2.lastIndexOf(46);
            if (dotIndex == -1) {
                return false;
            }
            String ext = name2.substring(dotIndex + 1);
            String[] stringArray = this.types;
            int n = this.types.length;
            int n2 = 0;
            while (n2 < n) {
                String type2 = stringArray[n2];
                if (type2.equalsIgnoreCase(ext)) {
                    return true;
                }
                ++n2;
            }
            return false;
        }

        public String getDescription() {
            return this.description;
        }
    }

    private static class Loader {
        private final JFileChooser chooser = new JFileChooser("images");

        Loader() {
            this.chooser.setDialogTitle("Create a texture");
            this.chooser.setDialogType(0);
            this.chooser.setFileHidingEnabled(true);
            this.chooser.setFileSelectionMode(0);
            this.chooser.setMultiSelectionEnabled(false);
            this.chooser.setAcceptAllFileFilterUsed(false);
            this.chooser.addChoosableFileFilter(new ImageFileFilter("PNG Images (.png)", "PNG"));
            this.chooser.addChoosableFileFilter(new ImageFileFilter("JPEG Images (.jpg, .jpeg)", "JPG", "JPEG"));
            this.chooser.addChoosableFileFilter(new ImageFileFilter("GIF Images (.gif)", "GIF"));
            this.chooser.addChoosableFileFilter(new ImageFileFilter("Bitmap Images (.bmp)", "BMP"));
            this.chooser.addChoosableFileFilter(new ImageFileFilter("TIFF Images (.tiff, .tif)", "TIFF", "TIF"));
            FileFilter[] filters = this.chooser.getChoosableFileFilters();
            LinkedList<String> allTypes = new LinkedList<String>();
            int i = 0;
            while (i < filters.length) {
                ImageFileFilter filter = (ImageFileFilter)filters[i];
                String[] stringArray = filter.types;
                int n = stringArray.length;
                int n2 = 0;
                while (n2 < n) {
                    String type2 = stringArray[n2];
                    allTypes.add(type2);
                    ++n2;
                }
                ++i;
            }
            this.chooser.addChoosableFileFilter(new ImageFileFilter("All Image Files", allTypes.toArray(new String[allTypes.size()])));
        }

        final boolean load() {
            boolean fullscreen = Display.isFullscreen();
            if (fullscreen) {
                SquishTest.toggleFullscreen();
            }
            try {
                int state = this.chooser.showOpenDialog(null);
                lastLoad = Sys.getTime();
                if (state != 0) {
                    return false;
                }
                try {
                    SquishTest.loadImage(ImageIO.read(this.chooser.getSelectedFile()));
                }
                catch (Exception e) {
                    Sys.alert("Failed to load image file", ErrorUtil.errorGetMessage(e));
                }
                return true;
            }
            finally {
                if (fullscreen) {
                    SquishTest.toggleFullscreen();
                }
            }
        }
    }
}

