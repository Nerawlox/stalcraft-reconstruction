/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.ResourceLocation;

public abstract class uytm
implements oxca {
    public final ResourceLocation location;
    private Runnable loadedCallback;
    private Runnable brokenCallback;
    private oxca.kjui state = oxca.kjui._a;
    private boolean useAsyncIO = true;
    private long loadStartTime;

    public uytm(ResourceLocation resourceLocation) {
        this.location = resourceLocation;
    }

    public void onLoaded(Runnable runnable) {
        this.loadedCallback = runnable;
    }

    public void onBroken(Runnable runnable) {
        this.brokenCallback = runnable;
    }

    public void onProceeded(Runnable runnable) {
        this.loadedCallback = this.brokenCallback = runnable;
    }

    protected void ioTask(Runnable runnable) {
        runnable = new kjui(runnable);
        if (this.useAsyncIO) {
            ogai._t()._d(runnable);
        } else {
            runnable.run();
        }
    }

    protected void glTaskFast(Runnable runnable) {
        runnable = new kjui(runnable);
        if (this.useAsyncIO) {
            ogai._t()._a(runnable);
        } else {
            this.ensureMcThreadAndRun(runnable);
        }
    }

    protected void glTaskDelayed(Runnable runnable) {
        runnable = new kjui(runnable);
        if (this.useAsyncIO) {
            ogai._t()._b(runnable);
        } else {
            this.ensureMcThreadAndRun(runnable);
        }
    }

    protected void mcTask(Runnable runnable) {
        runnable = new kjui(runnable);
        if (this.useAsyncIO) {
            ogai._t()._e(runnable);
        } else {
            this.ensureMcThreadAndRun(runnable);
        }
    }

    protected void mcFenceTask(Runnable runnable) {
        runnable = new kjui(runnable);
        if (this.useAsyncIO) {
            ogai._t()._c(runnable);
        } else {
            this.ensureMcThreadAndRun(runnable);
        }
    }

    private void ensureMcThreadAndRun(Runnable runnable) {
        ogai._y();
        runnable.run();
    }

    public final void load(boolean bl) {
        ogai._y();
        this.useAsyncIO = bl;
        gpmu._f("Loading resource \"" + this + "\" (async=" + this.useAsyncIO + ")", new Object[0]);
        this.loadStartTime = System.currentTimeMillis();
        this.state = oxca.kjui._b;
        this.load();
    }

    protected final void setLoaded() {
        this.setState(oxca.kjui._c);
    }

    protected final void setBroken() {
        this.setState(oxca.kjui._d);
    }

    protected final void setState(oxca.kjui kjui2) {
        ogai._y();
        if (kjui2 == oxca.kjui._c) {
            long l = System.currentTimeMillis() - this.loadStartTime;
            gpmu._f("Resource \"" + this + "\" was loaded (async=" + this.useAsyncIO + ") in " + l + " ms", new Object[0]);
            if (this.loadedCallback != null) {
                try {
                    this.loadedCallback.run();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            this.loadedCallback = null;
            this.brokenCallback = null;
        } else if (kjui2 == oxca.kjui._d) {
            if (this.brokenCallback != null) {
                try {
                    this.brokenCallback.run();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            this.loadedCallback = null;
            this.brokenCallback = null;
        }
        this.state = kjui2;
    }

    @Override
    public oxca.kjui getState() {
        return this.state;
    }

    protected boolean shouldUseAsyncIO() {
        return this.useAsyncIO;
    }

    protected abstract void load();

    public abstract void release();

    public String toString() {
        return this.location.toString();
    }

    private class kjui
    implements Runnable {
        private final Runnable _b;

        public kjui(Runnable runnable) {
            this._b = runnable;
        }

        @Override
        public void run() {
            if (uytm.this.state == oxca.kjui._d) {
                gpmu._b("Dropping async task for broken resource " + uytm.this, new Object[0]);
                return;
            }
            try {
                this._b.run();
            }
            catch (Exception exception) {
                gpmu._b("Can not process async task for " + uytm.this, new Object[0]);
                exception.printStackTrace();
                uytm.this.mcTask(uytm.this::setBroken);
            }
        }
    }
}

