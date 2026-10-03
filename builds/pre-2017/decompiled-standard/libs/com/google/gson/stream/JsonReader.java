/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.stream.JsonScope;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import com.google.gson.stream.StringPool;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class JsonReader
implements Closeable {
    private static final char[] NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
    private static final String TRUE = "true";
    private static final String FALSE = "false";
    private final StringPool stringPool = new StringPool();
    private final Reader in;
    private boolean lenient = false;
    private final char[] buffer = new char[1024];
    private int pos = 0;
    private int limit = 0;
    private int bufferStartLine = 1;
    private int bufferStartColumn = 1;
    private JsonScope[] stack = new JsonScope[32];
    private int stackSize = 0;
    private JsonToken token;
    private String name;
    private String value;
    private int valuePos;
    private int valueLength;
    private boolean skipping;

    public JsonReader(Reader in) {
        this.push(JsonScope.EMPTY_DOCUMENT);
        this.skipping = false;
        if (in == null) {
            throw new NullPointerException("in == null");
        }
        this.in = in;
    }

    public final void setLenient(boolean lenient) {
        this.lenient = lenient;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    public void beginArray() throws IOException {
        this.expect(JsonToken.BEGIN_ARRAY);
    }

    public void endArray() throws IOException {
        this.expect(JsonToken.END_ARRAY);
    }

    public void beginObject() throws IOException {
        this.expect(JsonToken.BEGIN_OBJECT);
    }

    public void endObject() throws IOException {
        this.expect(JsonToken.END_OBJECT);
    }

    private void expect(JsonToken expected) throws IOException {
        this.peek();
        if (this.token != expected) {
            throw new IllegalStateException("Expected " + (Object)((Object)expected) + " but was " + (Object)((Object)this.peek()) + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
        }
        this.advance();
    }

    public boolean hasNext() throws IOException {
        this.peek();
        return this.token != JsonToken.END_OBJECT && this.token != JsonToken.END_ARRAY;
    }

    public JsonToken peek() throws IOException {
        if (this.token != null) {
            return this.token;
        }
        switch (this.stack[this.stackSize - 1]) {
            case EMPTY_DOCUMENT: {
                if (this.lenient) {
                    this.consumeNonExecutePrefix();
                }
                this.stack[this.stackSize - 1] = JsonScope.NONEMPTY_DOCUMENT;
                JsonToken firstToken = this.nextValue();
                if (!this.lenient && this.token != JsonToken.BEGIN_ARRAY && this.token != JsonToken.BEGIN_OBJECT) {
                    throw new IOException("Expected JSON document to start with '[' or '{' but was " + (Object)((Object)this.token) + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
                }
                return firstToken;
            }
            case EMPTY_ARRAY: {
                return this.nextInArray(true);
            }
            case NONEMPTY_ARRAY: {
                return this.nextInArray(false);
            }
            case EMPTY_OBJECT: {
                return this.nextInObject(true);
            }
            case DANGLING_NAME: {
                return this.objectValue();
            }
            case NONEMPTY_OBJECT: {
                return this.nextInObject(false);
            }
            case NONEMPTY_DOCUMENT: {
                int c = this.nextNonWhitespace(false);
                if (c == -1) {
                    return JsonToken.END_DOCUMENT;
                }
                --this.pos;
                if (!this.lenient) {
                    throw this.syntaxError("Expected EOF");
                }
                return this.nextValue();
            }
            case CLOSED: {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        throw new AssertionError();
    }

    private void consumeNonExecutePrefix() throws IOException {
        this.nextNonWhitespace(true);
        --this.pos;
        if (this.pos + NON_EXECUTE_PREFIX.length > this.limit && !this.fillBuffer(NON_EXECUTE_PREFIX.length)) {
            return;
        }
        for (int i = 0; i < NON_EXECUTE_PREFIX.length; ++i) {
            if (this.buffer[this.pos + i] == NON_EXECUTE_PREFIX[i]) continue;
            return;
        }
        this.pos += NON_EXECUTE_PREFIX.length;
    }

    private JsonToken advance() throws IOException {
        this.peek();
        JsonToken result2 = this.token;
        this.token = null;
        this.value = null;
        this.name = null;
        return result2;
    }

    public String nextName() throws IOException {
        this.peek();
        if (this.token != JsonToken.NAME) {
            throw new IllegalStateException("Expected a name but was " + (Object)((Object)this.peek()) + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
        }
        String result2 = this.name;
        this.advance();
        return result2;
    }

    public String nextString() throws IOException {
        this.peek();
        if (this.token != JsonToken.STRING && this.token != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected a string but was " + (Object)((Object)this.peek()) + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
        }
        String result2 = this.value;
        this.advance();
        return result2;
    }

    public boolean nextBoolean() throws IOException {
        this.peek();
        if (this.token != JsonToken.BOOLEAN) {
            throw new IllegalStateException("Expected a boolean but was " + (Object)((Object)this.token) + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
        }
        boolean result2 = this.value == TRUE;
        this.advance();
        return result2;
    }

    public void nextNull() throws IOException {
        this.peek();
        if (this.token != JsonToken.NULL) {
            throw new IllegalStateException("Expected null but was " + (Object)((Object)this.token) + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
        }
        this.advance();
    }

    public double nextDouble() throws IOException {
        this.peek();
        if (this.token != JsonToken.STRING && this.token != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected a double but was " + (Object)((Object)this.token) + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
        }
        double result2 = Double.parseDouble(this.value);
        if (result2 >= 1.0 && this.value.startsWith("0")) {
            throw new MalformedJsonException("JSON forbids octal prefixes: " + this.value + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
        }
        if (!this.lenient && (Double.isNaN(result2) || Double.isInfinite(result2))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + this.value + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
        }
        this.advance();
        return result2;
    }

    public long nextLong() throws IOException {
        long result2;
        block4: {
            this.peek();
            if (this.token != JsonToken.STRING && this.token != JsonToken.NUMBER) {
                throw new IllegalStateException("Expected a long but was " + (Object)((Object)this.token) + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
            }
            try {
                result2 = Long.parseLong(this.value);
            }
            catch (NumberFormatException ignored) {
                double asDouble = Double.parseDouble(this.value);
                result2 = (long)asDouble;
                if ((double)result2 == asDouble) break block4;
                throw new NumberFormatException("Expected a long but was " + this.value + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
            }
        }
        if (result2 >= 1L && this.value.startsWith("0")) {
            throw new MalformedJsonException("JSON forbids octal prefixes: " + this.value + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
        }
        this.advance();
        return result2;
    }

    public int nextInt() throws IOException {
        int result2;
        block4: {
            this.peek();
            if (this.token != JsonToken.STRING && this.token != JsonToken.NUMBER) {
                throw new IllegalStateException("Expected an int but was " + (Object)((Object)this.token) + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
            }
            try {
                result2 = Integer.parseInt(this.value);
            }
            catch (NumberFormatException ignored) {
                double asDouble = Double.parseDouble(this.value);
                result2 = (int)asDouble;
                if ((double)result2 == asDouble) break block4;
                throw new NumberFormatException("Expected an int but was " + this.value + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
            }
        }
        if ((long)result2 >= 1L && this.value.startsWith("0")) {
            throw new MalformedJsonException("JSON forbids octal prefixes: " + this.value + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
        }
        this.advance();
        return result2;
    }

    public void close() throws IOException {
        this.value = null;
        this.token = null;
        this.stack[0] = JsonScope.CLOSED;
        this.stackSize = 1;
        this.in.close();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void skipValue() throws IOException {
        this.skipping = true;
        try {
            int count = 0;
            do {
                JsonToken token;
                if ((token = this.advance()) == JsonToken.BEGIN_ARRAY || token == JsonToken.BEGIN_OBJECT) {
                    ++count;
                    continue;
                }
                if (token != JsonToken.END_ARRAY && token != JsonToken.END_OBJECT) continue;
                --count;
            } while (count != 0);
        }
        finally {
            this.skipping = false;
        }
    }

    private void push(JsonScope newTop) {
        if (this.stackSize == this.stack.length) {
            JsonScope[] newStack = new JsonScope[this.stackSize * 2];
            System.arraycopy(this.stack, 0, newStack, 0, this.stackSize);
            this.stack = newStack;
        }
        this.stack[this.stackSize++] = newTop;
    }

    private JsonToken nextInArray(boolean firstElement) throws IOException {
        if (firstElement) {
            this.stack[this.stackSize - 1] = JsonScope.NONEMPTY_ARRAY;
        } else {
            switch (this.nextNonWhitespace(true)) {
                case 93: {
                    --this.stackSize;
                    this.token = JsonToken.END_ARRAY;
                    return this.token;
                }
                case 59: {
                    this.checkLenient();
                }
                case 44: {
                    break;
                }
                default: {
                    throw this.syntaxError("Unterminated array");
                }
            }
        }
        switch (this.nextNonWhitespace(true)) {
            case 93: {
                if (firstElement) {
                    --this.stackSize;
                    this.token = JsonToken.END_ARRAY;
                    return this.token;
                }
            }
            case 44: 
            case 59: {
                this.checkLenient();
                --this.pos;
                this.value = "null";
                this.token = JsonToken.NULL;
                return this.token;
            }
        }
        --this.pos;
        return this.nextValue();
    }

    private JsonToken nextInObject(boolean firstElement) throws IOException {
        if (firstElement) {
            switch (this.nextNonWhitespace(true)) {
                case 125: {
                    --this.stackSize;
                    this.token = JsonToken.END_OBJECT;
                    return this.token;
                }
            }
            --this.pos;
        } else {
            switch (this.nextNonWhitespace(true)) {
                case 125: {
                    --this.stackSize;
                    this.token = JsonToken.END_OBJECT;
                    return this.token;
                }
                case 44: 
                case 59: {
                    break;
                }
                default: {
                    throw this.syntaxError("Unterminated object");
                }
            }
        }
        int quote = this.nextNonWhitespace(true);
        switch (quote) {
            case 39: {
                this.checkLenient();
            }
            case 34: {
                this.name = this.nextString((char)quote);
                break;
            }
            default: {
                this.checkLenient();
                --this.pos;
                this.name = this.nextLiteral(false);
                if (this.name.length() != 0) break;
                throw this.syntaxError("Expected name");
            }
        }
        this.stack[this.stackSize - 1] = JsonScope.DANGLING_NAME;
        this.token = JsonToken.NAME;
        return this.token;
    }

    private JsonToken objectValue() throws IOException {
        switch (this.nextNonWhitespace(true)) {
            case 58: {
                break;
            }
            case 61: {
                this.checkLenient();
                if (this.pos >= this.limit && !this.fillBuffer(1) || this.buffer[this.pos] != '>') break;
                ++this.pos;
                break;
            }
            default: {
                throw this.syntaxError("Expected ':'");
            }
        }
        this.stack[this.stackSize - 1] = JsonScope.NONEMPTY_OBJECT;
        return this.nextValue();
    }

    private JsonToken nextValue() throws IOException {
        int c = this.nextNonWhitespace(true);
        switch (c) {
            case 123: {
                this.push(JsonScope.EMPTY_OBJECT);
                this.token = JsonToken.BEGIN_OBJECT;
                return this.token;
            }
            case 91: {
                this.push(JsonScope.EMPTY_ARRAY);
                this.token = JsonToken.BEGIN_ARRAY;
                return this.token;
            }
            case 39: {
                this.checkLenient();
            }
            case 34: {
                this.value = this.nextString((char)c);
                this.token = JsonToken.STRING;
                return this.token;
            }
        }
        --this.pos;
        return this.readLiteral();
    }

    private boolean fillBuffer(int minimum) throws IOException {
        int total;
        char[] buffer = this.buffer;
        int line = this.bufferStartLine;
        int column = this.bufferStartColumn;
        int p = this.pos;
        for (int i = 0; i < p; ++i) {
            if (buffer[i] == '\n') {
                ++line;
                column = 1;
                continue;
            }
            ++column;
        }
        this.bufferStartLine = line;
        this.bufferStartColumn = column;
        if (this.limit != this.pos) {
            this.limit -= this.pos;
            System.arraycopy(buffer, this.pos, buffer, 0, this.limit);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        while ((total = this.in.read(buffer, this.limit, buffer.length - this.limit)) != -1) {
            this.limit += total;
            if (this.bufferStartLine == 1 && this.bufferStartColumn == 1 && this.limit > 0 && buffer[0] == '\ufeff') {
                ++this.pos;
                --this.bufferStartColumn;
            }
            if (this.limit < minimum) continue;
            return true;
        }
        return false;
    }

    private int getLineNumber() {
        int result2 = this.bufferStartLine;
        for (int i = 0; i < this.pos; ++i) {
            if (this.buffer[i] != '\n') continue;
            ++result2;
        }
        return result2;
    }

    private int getColumnNumber() {
        int result2 = this.bufferStartColumn;
        for (int i = 0; i < this.pos; ++i) {
            if (this.buffer[i] == '\n') {
                result2 = 1;
                continue;
            }
            ++result2;
        }
        return result2;
    }

    private int nextNonWhitespace(boolean throwOnEof) throws IOException {
        block15: {
            char c;
            char[] buffer = this.buffer;
            int p = this.pos;
            int l = this.limit;
            block9: while (true) {
                if (p == l) {
                    this.pos = p;
                    if (!this.fillBuffer(1)) break block15;
                    p = this.pos;
                    l = this.limit;
                }
                c = buffer[p++];
                switch (c) {
                    case '\t': 
                    case '\n': 
                    case '\r': 
                    case ' ': {
                        continue block9;
                    }
                    case '/': {
                        this.pos = p;
                        if (p == l) {
                            --this.pos;
                            boolean charsLoaded = this.fillBuffer(2);
                            ++this.pos;
                            if (!charsLoaded) {
                                return c;
                            }
                        }
                        this.checkLenient();
                        char peek = buffer[this.pos];
                        switch (peek) {
                            case '*': {
                                ++this.pos;
                                if (!this.skipTo("*/")) {
                                    throw this.syntaxError("Unterminated comment");
                                }
                                p = this.pos + 2;
                                l = this.limit;
                                continue block9;
                            }
                            case '/': {
                                ++this.pos;
                                this.skipToEndOfLine();
                                p = this.pos;
                                l = this.limit;
                                continue block9;
                            }
                        }
                        return c;
                    }
                    case '#': {
                        this.pos = p;
                        this.checkLenient();
                        this.skipToEndOfLine();
                        p = this.pos;
                        l = this.limit;
                        continue block9;
                    }
                }
                break;
            }
            this.pos = p;
            return c;
        }
        if (throwOnEof) {
            throw new EOFException("End of input at line " + this.getLineNumber() + " column " + this.getColumnNumber());
        }
        return -1;
    }

    private void checkLenient() throws IOException {
        if (!this.lenient) {
            throw this.syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void skipToEndOfLine() throws IOException {
        char c;
        while ((this.pos < this.limit || this.fillBuffer(1)) && (c = this.buffer[this.pos++]) != '\r' && c != '\n') {
        }
    }

    private boolean skipTo(String toFind) throws IOException {
        while (this.pos + toFind.length() <= this.limit || this.fillBuffer(toFind.length())) {
            block3: {
                for (int c = 0; c < toFind.length(); ++c) {
                    if (this.buffer[this.pos + c] == toFind.charAt(c)) {
                        continue;
                    }
                    break block3;
                }
                return true;
            }
            ++this.pos;
        }
        return false;
    }

    private String nextString(char quote) throws IOException {
        char[] buffer = this.buffer;
        StringBuilder builder = null;
        do {
            int p = this.pos;
            int l = this.limit;
            int start = p;
            while (p < l) {
                char c;
                if ((c = buffer[p++]) == quote) {
                    this.pos = p;
                    if (this.skipping) {
                        return "skipped!";
                    }
                    if (builder == null) {
                        return this.stringPool.get(buffer, start, p - start - 1);
                    }
                    builder.append(buffer, start, p - start - 1);
                    return builder.toString();
                }
                if (c != '\\') continue;
                this.pos = p;
                if (builder == null) {
                    builder = new StringBuilder();
                }
                builder.append(buffer, start, p - start - 1);
                builder.append(this.readEscapeCharacter());
                p = this.pos;
                l = this.limit;
                start = p;
            }
            if (builder == null) {
                builder = new StringBuilder();
            }
            builder.append(buffer, start, p - start);
            this.pos = p;
        } while (this.fillBuffer(1));
        throw this.syntaxError("Unterminated string");
    }

    private String nextLiteral(boolean assignOffsetsOnly) throws IOException {
        String result2;
        StringBuilder builder = null;
        this.valuePos = -1;
        this.valueLength = 0;
        int i = 0;
        block4: while (true) {
            if (this.pos + i < this.limit) {
                switch (this.buffer[this.pos + i]) {
                    case '#': 
                    case '/': 
                    case ';': 
                    case '=': 
                    case '\\': {
                        this.checkLenient();
                    }
                    case '\t': 
                    case '\n': 
                    case '\f': 
                    case '\r': 
                    case ' ': 
                    case ',': 
                    case ':': 
                    case '[': 
                    case ']': 
                    case '{': 
                    case '}': {
                        break block4;
                    }
                    default: {
                        ++i;
                        break;
                    }
                }
                continue;
            }
            if (i < this.buffer.length) {
                if (this.fillBuffer(i + 1)) continue;
                this.buffer[this.limit] = '\u0000';
                break;
            }
            if (builder == null) {
                builder = new StringBuilder();
            }
            builder.append(this.buffer, this.pos, i);
            this.valueLength += i;
            this.pos += i;
            i = 0;
            if (!this.fillBuffer(1)) break;
        }
        if (assignOffsetsOnly && builder == null) {
            this.valuePos = this.pos;
            result2 = null;
        } else if (this.skipping) {
            result2 = "skipped!";
        } else if (builder == null) {
            result2 = this.stringPool.get(this.buffer, this.pos, i);
        } else {
            builder.append(this.buffer, this.pos, i);
            result2 = builder.toString();
        }
        this.valueLength += i;
        this.pos += i;
        return result2;
    }

    public String toString() {
        return this.getClass().getSimpleName() + " at line " + this.getLineNumber() + " column " + this.getColumnNumber();
    }

    private char readEscapeCharacter() throws IOException {
        if (this.pos == this.limit && !this.fillBuffer(1)) {
            throw this.syntaxError("Unterminated escape sequence");
        }
        char escaped = this.buffer[this.pos++];
        switch (escaped) {
            case 'u': {
                int i;
                if (this.pos + 4 > this.limit && !this.fillBuffer(4)) {
                    throw this.syntaxError("Unterminated escape sequence");
                }
                char result2 = '\u0000';
                int end = i + 4;
                for (i = this.pos; i < end; ++i) {
                    char c = this.buffer[i];
                    result2 = (char)(result2 << 4);
                    if (c >= '0' && c <= '9') {
                        result2 = (char)(result2 + (c - 48));
                        continue;
                    }
                    if (c >= 'a' && c <= 'f') {
                        result2 = (char)(result2 + (c - 97 + 10));
                        continue;
                    }
                    if (c >= 'A' && c <= 'F') {
                        result2 = (char)(result2 + (c - 65 + 10));
                        continue;
                    }
                    throw new NumberFormatException("\\u" + this.stringPool.get(this.buffer, this.pos, 4));
                }
                this.pos += 4;
                return result2;
            }
            case 't': {
                return '\t';
            }
            case 'b': {
                return '\b';
            }
            case 'n': {
                return '\n';
            }
            case 'r': {
                return '\r';
            }
            case 'f': {
                return '\f';
            }
        }
        return escaped;
    }

    private JsonToken readLiteral() throws IOException {
        this.value = this.nextLiteral(true);
        if (this.valueLength == 0) {
            throw this.syntaxError("Expected literal value");
        }
        this.token = this.decodeLiteral();
        if (this.token == JsonToken.STRING) {
            this.checkLenient();
        }
        return this.token;
    }

    private JsonToken decodeLiteral() throws IOException {
        if (this.valuePos == -1) {
            return JsonToken.STRING;
        }
        if (!(this.valueLength != 4 || 'n' != this.buffer[this.valuePos] && 'N' != this.buffer[this.valuePos] || 'u' != this.buffer[this.valuePos + 1] && 'U' != this.buffer[this.valuePos + 1] || 'l' != this.buffer[this.valuePos + 2] && 'L' != this.buffer[this.valuePos + 2] || 'l' != this.buffer[this.valuePos + 3] && 'L' != this.buffer[this.valuePos + 3])) {
            this.value = "null";
            return JsonToken.NULL;
        }
        if (!(this.valueLength != 4 || 't' != this.buffer[this.valuePos] && 'T' != this.buffer[this.valuePos] || 'r' != this.buffer[this.valuePos + 1] && 'R' != this.buffer[this.valuePos + 1] || 'u' != this.buffer[this.valuePos + 2] && 'U' != this.buffer[this.valuePos + 2] || 'e' != this.buffer[this.valuePos + 3] && 'E' != this.buffer[this.valuePos + 3])) {
            this.value = TRUE;
            return JsonToken.BOOLEAN;
        }
        if (!(this.valueLength != 5 || 'f' != this.buffer[this.valuePos] && 'F' != this.buffer[this.valuePos] || 'a' != this.buffer[this.valuePos + 1] && 'A' != this.buffer[this.valuePos + 1] || 'l' != this.buffer[this.valuePos + 2] && 'L' != this.buffer[this.valuePos + 2] || 's' != this.buffer[this.valuePos + 3] && 'S' != this.buffer[this.valuePos + 3] || 'e' != this.buffer[this.valuePos + 4] && 'E' != this.buffer[this.valuePos + 4])) {
            this.value = FALSE;
            return JsonToken.BOOLEAN;
        }
        this.value = this.stringPool.get(this.buffer, this.valuePos, this.valueLength);
        return this.decodeNumber(this.buffer, this.valuePos, this.valueLength);
    }

    private JsonToken decodeNumber(char[] chars, int offset, int length) {
        int i = offset;
        char c = chars[i];
        if (c == '-') {
            c = chars[++i];
        }
        if (c == '0') {
            c = chars[++i];
        } else if (c >= '1' && c <= '9') {
            c = chars[++i];
            while (c >= '0' && c <= '9') {
                c = chars[++i];
            }
        } else {
            return JsonToken.STRING;
        }
        if (c == '.') {
            c = chars[++i];
            while (c >= '0' && c <= '9') {
                c = chars[++i];
            }
        }
        if (c == 'e' || c == 'E') {
            if ((c = chars[++i]) == '+' || c == '-') {
                c = chars[++i];
            }
            if (c >= '0' && c <= '9') {
                c = chars[++i];
                while (c >= '0' && c <= '9') {
                    c = chars[++i];
                }
            } else {
                return JsonToken.STRING;
            }
        }
        if (i == offset + length) {
            return JsonToken.NUMBER;
        }
        return JsonToken.STRING;
    }

    private IOException syntaxError(String message) throws IOException {
        throw new MalformedJsonException(message + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
    }

    static {
        JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess(){

            public void promoteNameToValue(JsonReader reader) throws IOException {
                if (reader instanceof JsonTreeReader) {
                    ((JsonTreeReader)reader).promoteNameToValue();
                    return;
                }
                reader.peek();
                if (reader.token != JsonToken.NAME) {
                    throw new IllegalStateException("Expected a name but was " + (Object)((Object)reader.peek()) + " " + " at line " + reader.getLineNumber() + " column " + reader.getColumnNumber());
                }
                reader.value = reader.name;
                reader.name = null;
                reader.token = JsonToken.STRING;
            }
        };
    }
}

