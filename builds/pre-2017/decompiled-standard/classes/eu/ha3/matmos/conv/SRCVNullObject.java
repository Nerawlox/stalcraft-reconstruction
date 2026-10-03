/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.conv;

import eu.ha3.matmos.conv.CustomVolume;
import eu.ha3.matmos.conv.ReplicableSoundRelay;
import eu.ha3.matmos.engine.interfaces.SoundRelay;

public class SRCVNullObject
implements CustomVolume,
ReplicableSoundRelay {
    @Override
    public void routine() {
    }

    @Override
    public void cacheSound(String string) {
    }

    @Override
    public void playSound(String string, float f, float f2, int n) {
    }

    @Override
    public int getNewStreamingToken() {
        return 0;
    }

    @Override
    public boolean setupStreamingToken(int n, String string, float f, float f2) {
        return false;
    }

    @Override
    public void startStreaming(int n, float f, int n2) {
    }

    @Override
    public void stopStreaming(int n, float f) {
    }

    @Override
    public void pauseStreaming(int n, float f) {
    }

    @Override
    public void eraseStreamingToken(int n) {
    }

    @Override
    public void setVolume(float f) {
    }

    @Override
    public float getVolume() {
        return 0.0f;
    }

    @Override
    public SoundRelay createChild() {
        return null;
    }
}

