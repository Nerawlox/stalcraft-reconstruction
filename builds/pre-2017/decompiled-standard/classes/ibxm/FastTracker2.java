/*
 * Decompiled with CFR 0.152.
 */
package ibxm;

import ibxm.Envelope;
import ibxm.Instrument;
import ibxm.Module;
import ibxm.Pattern;
import ibxm.Sample;
import java.io.DataInput;
import java.io.EOFException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class FastTracker2 {
    public static boolean is_xm(byte[] byArray) {
        String string = FastTracker2.ascii_text(byArray, 0, 17);
        return string.equals("Extended Module: ");
    }

    public static Module load_xm(byte[] byArray, DataInput dataInput) throws IOException {
        int n;
        if (!FastTracker2.is_xm(byArray)) {
            throw new IllegalArgumentException("Not an XM file!");
        }
        int n2 = FastTracker2.unsigned_short_le(byArray, 58);
        if (n2 != 260) {
            throw new IllegalArgumentException("Sorry, XM version " + n2 + " is not supported!");
        }
        Module module = new Module();
        module.song_title = FastTracker2.ascii_text(byArray, 17, 20);
        String string = FastTracker2.ascii_text(byArray, 38, 20);
        boolean bl = string.startsWith("DigiBooster Pro");
        byte[] byArray2 = new byte[4];
        dataInput.readFully(byArray2);
        int n3 = FastTracker2.int_le(byArray2, 0);
        byte[] byArray3 = new byte[n3];
        dataInput.readFully(byArray3, 4, n3 - 4);
        int n4 = FastTracker2.unsigned_short_le(byArray3, 4);
        module.restart_sequence_index = FastTracker2.unsigned_short_le(byArray3, 6);
        int n5 = FastTracker2.unsigned_short_le(byArray3, 8);
        int n6 = FastTracker2.unsigned_short_le(byArray3, 10);
        int n7 = FastTracker2.unsigned_short_le(byArray3, 12);
        int n8 = FastTracker2.unsigned_short_le(byArray3, 14);
        module.linear_periods = (n8 & 1) == 1;
        module.global_volume = 64;
        module.channel_gain = 12288;
        module.default_speed = FastTracker2.unsigned_short_le(byArray3, 16);
        module.default_tempo = FastTracker2.unsigned_short_le(byArray3, 18);
        module.set_num_channels(n5);
        for (n = 0; n < n5; ++n) {
            module.set_initial_panning(n, 128);
        }
        module.set_sequence_length(n4);
        for (n = 0; n < n4; ++n) {
            module.set_sequence(n, byArray3[20 + n] & 0xFF);
        }
        module.set_num_patterns(n6);
        for (n = 0; n < n6; ++n) {
            module.set_pattern(n, FastTracker2.read_xm_pattern(dataInput, n5));
        }
        module.set_num_instruments(n7);
        for (n = 1; n <= n7; ++n) {
            try {
                Instrument instrument = FastTracker2.read_xm_instrument(dataInput, bl);
                module.set_instrument(n, instrument);
                continue;
            }
            catch (EOFException eOFException) {
                System.out.println("Instrument " + n + " is missing!");
            }
        }
        return module;
    }

    private static Pattern read_xm_pattern(DataInput dataInput, int n) throws IOException {
        byte[] byArray = new byte[4];
        dataInput.readFully(byArray);
        int n2 = FastTracker2.int_le(byArray, 0);
        byte[] byArray2 = new byte[n2];
        dataInput.readFully(byArray2, 4, n2 - 4);
        byte by = byArray2[4];
        if (by != 0) {
            throw new IllegalArgumentException("Pattern packing type " + by + " is not supported!");
        }
        Pattern pattern = new Pattern();
        pattern.num_rows = FastTracker2.unsigned_short_le(byArray2, 5);
        int n3 = FastTracker2.unsigned_short_le(byArray2, 7);
        byte[] byArray3 = new byte[n3];
        dataInput.readFully(byArray3);
        pattern.set_pattern_data(byArray3);
        return pattern;
    }

    private static Instrument read_xm_instrument(DataInput dataInput, boolean bl) throws IOException {
        byte[] byArray = new byte[4];
        dataInput.readFully(byArray);
        int n = FastTracker2.int_le(byArray, 0);
        byte[] byArray2 = new byte[n];
        dataInput.readFully(byArray2, 4, n - 4);
        Instrument instrument = new Instrument();
        instrument.name = FastTracker2.ascii_text(byArray2, 4, 22);
        int n2 = FastTracker2.unsigned_short_le(byArray2, 27);
        if (n2 > 0) {
            int n3;
            int n4;
            int n5;
            instrument.set_num_samples(n2);
            for (n5 = 0; n5 < 96; ++n5) {
                instrument.set_key_to_sample(n5 + 1, byArray2[33 + n5] & 0xFF);
            }
            Envelope envelope = new Envelope();
            int n6 = byArray2[225] & 0xFF;
            envelope.set_num_points(n6);
            for (n5 = 0; n5 < n6; ++n5) {
                n4 = FastTracker2.unsigned_short_le(byArray2, 129 + n5 * 4);
                n3 = FastTracker2.unsigned_short_le(byArray2, 131 + n5 * 4);
                envelope.set_point(n5, n4, n3, bl);
            }
            envelope.set_sustain_point(byArray2[227] & 0xFF);
            envelope.set_loop_points(byArray2[228] & 0xFF, byArray2[229] & 0xFF);
            int n7 = byArray2[233] & 0xFF;
            instrument.volume_envelope_active = (n7 & 1) == 1;
            envelope.sustain = (n7 & 2) == 2;
            envelope.looped = (n7 & 4) == 4;
            instrument.set_volume_envelope(envelope);
            envelope = new Envelope();
            n6 = byArray2[226] & 0xFF;
            envelope.set_num_points(n6);
            for (n5 = 0; n5 < n6; ++n5) {
                n4 = FastTracker2.unsigned_short_le(byArray2, 177 + n5 * 4);
                n3 = FastTracker2.unsigned_short_le(byArray2, 179 + n5 * 4);
                envelope.set_point(n5, n4, n3, bl);
            }
            envelope.set_sustain_point(byArray2[230] & 0xFF);
            envelope.set_loop_points(byArray2[231] & 0xFF, byArray2[232] & 0xFF);
            n7 = byArray2[234] & 0xFF;
            instrument.panning_envelope_active = (n7 & 1) == 1;
            envelope.sustain = (n7 & 2) == 2;
            envelope.looped = (n7 & 4) == 4;
            instrument.set_panning_envelope(envelope);
            instrument.vibrato_type = byArray2[235] & 0xFF;
            instrument.vibrato_sweep = byArray2[236] & 0xFF;
            instrument.vibrato_depth = byArray2[237] & 0xFF;
            instrument.vibrato_rate = byArray2[238] & 0xFF;
            instrument.volume_fade_out = FastTracker2.unsigned_short_le(byArray2, 239);
            byte[] byArray3 = new byte[n2 * 40];
            dataInput.readFully(byArray3);
            for (n5 = 0; n5 < n2; ++n5) {
                instrument.set_sample(n5, FastTracker2.read_xm_sample(byArray3, n5, dataInput));
            }
        }
        return instrument;
    }

    private static Sample read_xm_sample(byte[] byArray, int n, DataInput dataInput) throws IOException {
        int n2 = n * 40;
        Sample sample = new Sample();
        int n3 = FastTracker2.int_le(byArray, n2);
        int n4 = FastTracker2.int_le(byArray, n2 + 4);
        int n5 = FastTracker2.int_le(byArray, n2 + 8);
        sample.volume = byArray[n2 + 12] & 0xFF;
        int n6 = byArray[n2 + 13];
        n6 = (n6 << 15) / 1536;
        sample.set_panning = true;
        int n7 = byArray[n2 + 14] & 0xFF;
        if ((n7 & 3) == 0) {
            n5 = 0;
        }
        boolean bl = (n7 & 2) == 2;
        boolean bl2 = (n7 & 0x10) == 16;
        sample.panning = byArray[n2 + 15] & 0xFF;
        int n8 = byArray[n2 + 16];
        n8 = (n8 << 15) / 12;
        sample.transpose = n8 + n6;
        sample.name = FastTracker2.ascii_text(byArray, n2 + 18, 22);
        byte[] byArray2 = new byte[n3];
        try {
            dataInput.readFully(byArray2);
        }
        catch (EOFException eOFException) {
            System.out.println("Sample has been truncated!");
        }
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        int n12 = 0;
        if (bl2) {
            short[] sArray = new short[n3 >> 1];
            while (n9 < byArray2.length) {
                n11 = byArray2[n9] & 0xFF;
                sArray[n10] = (short)(n12 += (n11 |= (byArray2[n9 + 1] & 0xFF) << 8));
                n9 += 2;
                ++n10;
            }
            sample.set_sample_data(sArray, n4 >> 1, n5 >> 1, bl);
        } else {
            short[] sArray = new short[n3];
            while (n9 < byArray2.length) {
                n11 = byArray2[n9] & 0xFF;
                sArray[n10] = (short)((n12 += n11) << 8);
                ++n9;
                ++n10;
            }
            sample.set_sample_data(sArray, n4, n5, bl);
        }
        return sample;
    }

    private static int unsigned_short_le(byte[] byArray, int n) {
        int n2 = byArray[n] & 0xFF;
        return n2 |= (byArray[n + 1] & 0xFF) << 8;
    }

    private static int int_le(byte[] byArray, int n) {
        int n2 = byArray[n] & 0xFF;
        n2 |= (byArray[n + 1] & 0xFF) << 8;
        n2 |= (byArray[n + 2] & 0xFF) << 16;
        return n2 |= (byArray[n + 3] & 0x7F) << 24;
    }

    private static String ascii_text(byte[] byArray, int n, int n2) {
        String string;
        byte[] byArray2 = new byte[n2];
        for (int i = 0; i < n2; ++i) {
            int n3 = byArray[n + i];
            if (n3 < 32) {
                n3 = 32;
            }
            byArray2[i] = (byte)n3;
        }
        try {
            string = new String(byArray2, 0, n2, "ISO-8859-1");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            string = "";
        }
        return string;
    }
}

