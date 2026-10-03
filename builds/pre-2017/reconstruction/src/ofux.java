/*
 * Decompiled with CFR 0.152.
 */
public interface ofux {
    public void onKeyDown();

    default public void onKeyDownRepeat() {
    }

    default public void onKeyUp() {
    }

    default public boolean processOnGui() {
        return false;
    }
}

