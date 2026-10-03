/*
 * Decompiled with CFR 0.152.
 */
package gr.zdimensions.jsquish;

import gr.zdimensions.jsquish.ColourBlock;
import gr.zdimensions.jsquish.ColourSet;
import gr.zdimensions.jsquish.CompressorColourFit;
import gr.zdimensions.jsquish.SingleColourLookup3;
import gr.zdimensions.jsquish.SingleColourLookup4;
import gr.zdimensions.jsquish.Squish;
import gr.zdimensions.jsquish.Vec;

final class CompressorSingleColour
extends CompressorColourFit {
    private static final int[] indices = new int[16];
    private static final int[][][][] lookups = new int[3][][][];
    private static int[][] sources = new int[3][];
    private static final Vec start = new Vec();
    private static final Vec end = new Vec();
    private static int[] index = new int[1];
    private static int bestError;
    private int[] colour = new int[3];

    CompressorSingleColour(ColourSet colours, Squish.CompressionType type2) {
        super(colours, type2);
        Vec colour = colours.getPoints()[0];
        this.colour[0] = Math.round(255.0f * colour.x());
        this.colour[1] = Math.round(255.0f * colour.y());
        this.colour[2] = Math.round(255.0f * colour.z());
        bestError = Integer.MAX_VALUE;
    }

    void compress3(byte[] block, int offset) {
        CompressorSingleColour.lookups[0] = SingleColourLookup3.LOOKUP_5_3;
        CompressorSingleColour.lookups[1] = SingleColourLookup3.LOOKUP_6_3;
        CompressorSingleColour.lookups[2] = SingleColourLookup3.LOOKUP_5_3;
        int error = this.computeEndPoints(3, lookups);
        if (error < bestError) {
            this.colours.remapIndices(index, indices);
            ColourBlock.writeColourBlock3(start, end, indices, block, offset);
            bestError = error;
        }
    }

    void compress4(byte[] block, int offset) {
        CompressorSingleColour.lookups[0] = SingleColourLookup4.LOOKUP_5_4;
        CompressorSingleColour.lookups[1] = SingleColourLookup4.LOOKUP_6_4;
        CompressorSingleColour.lookups[2] = SingleColourLookup4.LOOKUP_5_4;
        int error = this.computeEndPoints(4, lookups);
        if (error < bestError) {
            this.colours.remapIndices(index, indices);
            ColourBlock.writeColourBlock4(start, end, indices, block, offset);
            bestError = error;
        }
    }

    private int computeEndPoints(int count, int[][][][] lookups) {
        int[][] sources = CompressorSingleColour.sources;
        int bestError = CompressorSingleColour.bestError;
        int index = 0;
        while (index < count) {
            int error = 0;
            int channel = 0;
            while (channel < 3) {
                int[][][] lookup = lookups[channel];
                int target = this.colour[channel];
                sources[channel] = lookup[target][index];
                int diff = sources[channel][2];
                error += diff * diff;
                ++channel;
            }
            if (error < bestError) {
                start.set((float)sources[0][0] * 0.032258064f, (float)sources[1][0] * 0.015873017f, (float)sources[2][0] * 0.032258064f);
                end.set((float)sources[0][1] * 0.032258064f, (float)sources[1][1] * 0.015873017f, (float)sources[2][1] * 0.032258064f);
                CompressorSingleColour.index[0] = index;
                bestError = error;
            }
            ++index;
        }
        return bestError;
    }
}

