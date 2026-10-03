/*
 * Decompiled with CFR 0.152.
 */
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.SharedDrawable;

public class ncyz
extends ssni {
    private SharedDrawable _c;
    public final boolean _a;

    public ncyz(qmdg qmdg2, boolean bl) {
        super(qmdg2);
        this._a = bl;
        this.setDaemon(true);
        this.setPriority(2);
        this.setName("Background loader");
        if (bl) {
            try {
                this._c = new SharedDrawable(Display.getDrawable());
            }
            catch (LWJGLException lWJGLException) {
                throw new RuntimeException(lWJGLException);
            }
        }
    }

    @Override
    public void run() {
        if (this._a) {
            gpmu._d("Creating background gl context...", new Object[0]);
            try {
                this._c.makeCurrent();
            }
            catch (LWJGLException lWJGLException) {
                throw new RuntimeException(lWJGLException);
            }
        }
        super.run();
    }
}

