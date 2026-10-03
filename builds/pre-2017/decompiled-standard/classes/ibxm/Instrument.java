/*
 * Decompiled with CFR 0.152.
 */
package ibxm;

import ibxm.Envelope;
import ibxm.Sample;

public class Instrument {
    public String name = "";
    public int vibrato_type;
    public int vibrato_sweep;
    public int vibrato_depth;
    public int vibrato_rate;
    public boolean volume_envelope_active;
    public boolean panning_envelope_active;
    public int volume_fade_out;
    private Envelope volume_envelope;
    private Envelope panning_envelope;
    private int[] key_to_sample;
    private Sample[] samples;

    public Instrument() {
        this.set_volume_envelope(new Envelope());
        this.set_panning_envelope(new Envelope());
        this.key_to_sample = new int[96];
        this.set_num_samples(1);
    }

    public Envelope get_volume_envelope() {
        return this.volume_envelope;
    }

    public void set_volume_envelope(Envelope envelope) {
        if (envelope != null) {
            this.volume_envelope = envelope;
        }
    }

    public Envelope get_panning_envelope() {
        return this.panning_envelope;
    }

    public void set_panning_envelope(Envelope envelope) {
        if (envelope != null) {
            this.panning_envelope = envelope;
        }
    }

    public Sample get_sample_from_key(int n) {
        int n2 = 0;
        if (n > 0 && n <= this.key_to_sample.length) {
            n2 = this.key_to_sample[n - 1];
        }
        return this.get_sample(n2);
    }

    public void set_key_to_sample(int n, int n2) {
        if (n > 0 && n <= this.key_to_sample.length) {
            this.key_to_sample[n - 1] = n2;
        }
    }

    public int get_num_samples() {
        return this.samples.length;
    }

    public void set_num_samples(int n) {
        if (n < 1) {
            n = 1;
        }
        this.samples = new Sample[n];
        this.set_sample(0, null);
    }

    public Sample get_sample(int n) {
        Sample sample = null;
        if (n >= 0 && n < this.samples.length) {
            sample = this.samples[n];
        }
        if (sample == null) {
            sample = this.samples[0];
        }
        return sample;
    }

    public void set_sample(int n, Sample sample) {
        if (n >= 0 && n < this.samples.length) {
            this.samples[n] = sample;
        }
        if (this.samples[0] == null) {
            this.samples[0] = new Sample();
        }
    }
}

