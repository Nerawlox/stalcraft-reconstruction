/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.engine.interfaces;

public interface SoundRelay {
    public void routine();

    public void cacheSound(String var1);

    public void playSound(String var1, float var2, float var3, int var4);

    public int getNewStreamingToken();

    public boolean setupStreamingToken(int var1, String var2, float var3, float var4);

    public void startStreaming(int var1, float var2, int var3);

    public void stopStreaming(int var1, float var2);

    public void pauseStreaming(int var1, float var2);

    public void eraseStreamingToken(int var1);
}

