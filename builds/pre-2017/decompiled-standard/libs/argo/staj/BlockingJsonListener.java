/*
 * Decompiled with CFR 0.152.
 */
package argo.staj;

import argo.saj.InvalidSyntaxException;
import argo.saj.JsonListener;
import argo.staj.Element;
import argo.staj.ElementWithText;
import argo.staj.ElementWithoutText;
import argo.staj.JsonStreamElementType;
import java.io.IOException;

final class BlockingJsonListener
implements JsonListener {
    private final Object lock = new Object();
    private Element currentElement;
    private boolean hasNext = false;
    private State state = State.IN_PROGRESS;
    private IOException ioException;
    private RuntimeException runtimeException;
    private InvalidSyntaxException invalidSyntaxException;

    BlockingJsonListener() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    Element getNext() throws IOException, InvalidSyntaxException {
        Element result2;
        Object object = this.lock;
        synchronized (object) {
            while (!this.hasNext && !this.terminated()) {
                try {
                    this.lock.wait();
                }
                catch (InterruptedException e) {
                    throw new RuntimeException("Coding failure in Argo:  Interrupted waiting with request for next element;");
                }
            }
            if (this.terminated()) {
                this.handleTermination();
            }
            result2 = this.currentElement;
            this.hasNext = false;
            this.lock.notifyAll();
        }
        return result2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean hasNext() throws IOException, InvalidSyntaxException {
        boolean result2;
        Object object = this.lock;
        synchronized (object) {
            while (!this.hasNext && !this.terminated()) {
                try {
                    this.lock.wait();
                }
                catch (InterruptedException e) {
                    throw new RuntimeException("Coding failure in Argo:  Interrupted waiting with request for has next element;");
                }
            }
            if (this.state == State.CLOSED) {
                result2 = false;
            } else if (this.hasNext) {
                result2 = true;
            } else {
                this.handleTermination();
                result2 = false;
            }
            this.lock.notifyAll();
        }
        return result2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void gotNext(Element element) {
        Object object = this.lock;
        synchronized (object) {
            while (this.hasNext && !this.terminated()) {
                try {
                    this.lock.wait();
                }
                catch (InterruptedException e) {
                    throw new RuntimeException("Coding failure in Argo:  Interrupted waiting with next element;");
                }
            }
            if (!this.terminated()) {
                this.currentElement = element;
                this.hasNext = true;
                this.lock.notifyAll();
            }
        }
    }

    private boolean terminated() {
        return State.IN_PROGRESS != this.state;
    }

    private void handleTermination() throws IOException, InvalidSyntaxException {
        switch (this.state) {
            case IO_EXCEPTION: {
                throw this.ioException;
            }
            case RUNTIME_EXCEPTION: {
                throw this.runtimeException;
            }
            case INVALID_SYNTAX_EXCEPTION: {
                throw this.invalidSyntaxException;
            }
            case CLOSED: {
                throw new IllegalStateException("Illegal call after already closed.");
            }
        }
        throw new RuntimeException("Coding failure in Argo:  Unhandled state [" + (Object)((Object)this.state) + "].");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void close() {
        Object object = this.lock;
        synchronized (object) {
            if (!this.terminated()) {
                this.state = State.CLOSED;
                this.lock.notifyAll();
            }
        }
    }

    @Override
    public void startDocument() {
        this.gotNext(new ElementWithoutText(JsonStreamElementType.START_DOCUMENT));
    }

    @Override
    public void endDocument() {
        this.gotNext(new ElementWithoutText(JsonStreamElementType.END_DOCUMENT));
    }

    @Override
    public void startArray() {
        this.gotNext(new ElementWithoutText(JsonStreamElementType.START_ARRAY));
    }

    @Override
    public void endArray() {
        this.gotNext(new ElementWithoutText(JsonStreamElementType.END_ARRAY));
    }

    @Override
    public void startObject() {
        this.gotNext(new ElementWithoutText(JsonStreamElementType.START_OBJECT));
    }

    @Override
    public void endObject() {
        this.gotNext(new ElementWithoutText(JsonStreamElementType.END_OBJECT));
    }

    @Override
    public void startField(String name2) {
        this.gotNext(new ElementWithText(JsonStreamElementType.START_FIELD, name2));
    }

    @Override
    public void endField() {
        this.gotNext(new ElementWithoutText(JsonStreamElementType.END_FIELD));
    }

    @Override
    public void stringValue(String value) {
        this.gotNext(new ElementWithText(JsonStreamElementType.STRING, value));
    }

    @Override
    public void numberValue(String value) {
        this.gotNext(new ElementWithText(JsonStreamElementType.NUMBER, value));
    }

    @Override
    public void trueValue() {
        this.gotNext(new ElementWithoutText(JsonStreamElementType.TRUE));
    }

    @Override
    public void falseValue() {
        this.gotNext(new ElementWithoutText(JsonStreamElementType.FALSE));
    }

    @Override
    public void nullValue() {
        this.gotNext(new ElementWithoutText(JsonStreamElementType.NULL));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void ioException(IOException e) {
        Object object = this.lock;
        synchronized (object) {
            if (!this.terminated()) {
                this.state = State.IO_EXCEPTION;
                this.ioException = e;
                this.lock.notifyAll();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void runtimeException(RuntimeException e) {
        Object object = this.lock;
        synchronized (object) {
            if (!this.terminated()) {
                this.state = State.RUNTIME_EXCEPTION;
                this.runtimeException = e;
                this.lock.notifyAll();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void invalidSyntaxException(InvalidSyntaxException e) {
        Object object = this.lock;
        synchronized (object) {
            if (!this.terminated()) {
                this.state = State.INVALID_SYNTAX_EXCEPTION;
                this.invalidSyntaxException = e;
                this.lock.notifyAll();
            }
        }
    }

    private static enum State {
        IN_PROGRESS,
        CLOSED,
        IO_EXCEPTION,
        INVALID_SYNTAX_EXCEPTION,
        RUNTIME_EXCEPTION;

    }
}

