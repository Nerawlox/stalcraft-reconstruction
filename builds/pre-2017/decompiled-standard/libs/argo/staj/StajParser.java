/*
 * Decompiled with CFR 0.152.
 */
package argo.staj;

import argo.saj.InvalidSyntaxException;
import argo.saj.SajParser;
import argo.staj.BlockingJsonListener;
import argo.staj.Element;
import argo.staj.JsonStreamElementType;
import argo.staj.JsonStreamException;
import argo.staj.JsonStreamReader;
import java.io.IOException;
import java.io.Reader;

public final class StajParser
implements JsonStreamReader {
    private final BlockingJsonListener blockingJsonListener = new BlockingJsonListener();
    private Element next;

    public StajParser(final Reader in) {
        new Thread("Argo StajParser"){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public void run() {
                try {
                    new SajParser().parse(in, StajParser.this.blockingJsonListener);
                }
                catch (InvalidSyntaxException e) {
                    StajParser.this.blockingJsonListener.invalidSyntaxException(e);
                }
                catch (IOException e) {
                    StajParser.this.blockingJsonListener.ioException(e);
                }
                catch (RuntimeException e) {
                    StajParser.this.blockingJsonListener.runtimeException(e);
                }
                finally {
                    StajParser.this.blockingJsonListener.close();
                }
            }
        }.start();
    }

    @Override
    public JsonStreamElementType next() throws JsonStreamException {
        try {
            this.next = this.blockingJsonListener.getNext();
        }
        catch (IOException e) {
            throw new JsonStreamException(e);
        }
        catch (InvalidSyntaxException e) {
            throw new JsonStreamException(e);
        }
        return this.next.getJsonStreamElementType();
    }

    @Override
    public boolean hasNext() throws JsonStreamException {
        try {
            return this.blockingJsonListener.hasNext();
        }
        catch (IOException e) {
            throw new JsonStreamException(e);
        }
        catch (InvalidSyntaxException e) {
            throw new JsonStreamException(e);
        }
    }

    @Override
    public void close() {
        this.blockingJsonListener.close();
    }

    @Override
    public JsonStreamElementType getElementType() {
        if (this.next == null) {
            throw new IllegalStateException("Attempt to get element type of current element before first call to next().");
        }
        return this.next.getJsonStreamElementType();
    }

    @Override
    public String getText() {
        if (this.next == null) {
            throw new IllegalStateException("Attempt to get text of current element before first call to next().");
        }
        return this.next.getText();
    }

    @Override
    public boolean hasText() {
        if (this.next == null) {
            throw new IllegalStateException("Attempt to determine whether current element has text before first call to next().");
        }
        return this.next.hasText();
    }
}

