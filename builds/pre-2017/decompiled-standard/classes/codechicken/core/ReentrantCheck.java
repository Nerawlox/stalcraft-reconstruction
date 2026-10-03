/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core;

public class ReentrantCheck {
    private boolean entered = false;

    public boolean entered() {
        return this.entered;
    }

    public void enter() {
        this.entered = true;
    }

    public void exit() {
        this.entered = false;
    }

    public static ThreadLocal<ReentrantCheck> threadLocal() {
        return new ThreadLocal<ReentrantCheck>(){

            @Override
            protected ReentrantCheck initialValue() {
                return new ReentrantCheck();
            }
        };
    }
}

