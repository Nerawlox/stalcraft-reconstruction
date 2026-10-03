/*
 * Decompiled with CFR 0.152.
 */
package argo.saj;

import argo.saj.InvalidSyntaxException;
import argo.saj.JsonListener;
import argo.saj.PositionTrackingPushbackReader;
import argo.saj.ThingWithPosition;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public final class SajParser {
    private static final char DOUBLE_QUOTE = '\"';
    private static final char BACK_SLASH = '\\';
    private static final char BACKSPACE = '\b';
    private static final char TAB = '\t';
    private static final char NEWLINE = '\n';
    private static final char CARRIAGE_RETURN = '\r';
    private static final char FORM_FEED = '\f';

    public void parse(Reader in, JsonListener jsonListener) throws IOException, InvalidSyntaxException {
        PositionTrackingPushbackReader pushbackReader = new PositionTrackingPushbackReader(in);
        char nextChar = (char)pushbackReader.read();
        switch (nextChar) {
            case '{': {
                pushbackReader.unread(nextChar);
                jsonListener.startDocument();
                this.objectString(pushbackReader, jsonListener);
                break;
            }
            case '[': {
                pushbackReader.unread(nextChar);
                jsonListener.startDocument();
                this.arrayString(pushbackReader, jsonListener);
                break;
            }
            default: {
                throw new InvalidSyntaxException("Expected either [ or { but got [" + nextChar + "].", pushbackReader);
            }
        }
        int trailingCharacter = this.readNextNonWhitespaceChar(pushbackReader);
        if (trailingCharacter != -1) {
            throw new InvalidSyntaxException("Got unexpected trailing character [" + (char)trailingCharacter + "].", pushbackReader);
        }
        jsonListener.endDocument();
    }

    private void arrayString(PositionTrackingPushbackReader pushbackReader, JsonListener jsonListener) throws IOException, InvalidSyntaxException {
        char firstChar = (char)this.readNextNonWhitespaceChar(pushbackReader);
        if (firstChar != '[') {
            throw new InvalidSyntaxException("Expected object to start with [ but got [" + firstChar + "].", pushbackReader);
        }
        jsonListener.startArray();
        char secondChar = (char)this.readNextNonWhitespaceChar(pushbackReader);
        pushbackReader.unread(secondChar);
        if (secondChar != ']') {
            this.aJsonValue(pushbackReader, jsonListener);
        }
        boolean gotEndOfArray = false;
        block4: while (!gotEndOfArray) {
            char nextChar = (char)this.readNextNonWhitespaceChar(pushbackReader);
            switch (nextChar) {
                case ',': {
                    this.aJsonValue(pushbackReader, jsonListener);
                    continue block4;
                }
                case ']': {
                    gotEndOfArray = true;
                    continue block4;
                }
            }
            throw new InvalidSyntaxException("Expected either , or ] but got [" + nextChar + "].", pushbackReader);
        }
        jsonListener.endArray();
    }

    private void objectString(PositionTrackingPushbackReader pushbackReader, JsonListener jsonListener) throws IOException, InvalidSyntaxException {
        char firstChar = (char)this.readNextNonWhitespaceChar(pushbackReader);
        if (firstChar != '{') {
            throw new InvalidSyntaxException("Expected object to start with { but got [" + firstChar + "].", pushbackReader);
        }
        jsonListener.startObject();
        char secondChar = (char)this.readNextNonWhitespaceChar(pushbackReader);
        pushbackReader.unread(secondChar);
        if (secondChar != '}') {
            this.aFieldToken(pushbackReader, jsonListener);
        }
        boolean gotEndOfObject = false;
        block4: while (!gotEndOfObject) {
            char nextChar = (char)this.readNextNonWhitespaceChar(pushbackReader);
            switch (nextChar) {
                case ',': {
                    this.aFieldToken(pushbackReader, jsonListener);
                    continue block4;
                }
                case '}': {
                    gotEndOfObject = true;
                    continue block4;
                }
            }
            throw new InvalidSyntaxException("Expected either , or } but got [" + nextChar + "].", pushbackReader);
        }
        jsonListener.endObject();
    }

    private void aFieldToken(PositionTrackingPushbackReader pushbackReader, JsonListener jsonListener) throws IOException, InvalidSyntaxException {
        char nextChar = (char)this.readNextNonWhitespaceChar(pushbackReader);
        if ('\"' != nextChar) {
            throw new InvalidSyntaxException("Expected object identifier to begin with [\"] but got [" + nextChar + "].", pushbackReader);
        }
        pushbackReader.unread(nextChar);
        jsonListener.startField(this.stringToken(pushbackReader));
        char separatorChar = (char)this.readNextNonWhitespaceChar(pushbackReader);
        if (separatorChar != ':') {
            throw new InvalidSyntaxException("Expected object identifier to be followed by : but got [" + separatorChar + "].", pushbackReader);
        }
        this.aJsonValue(pushbackReader, jsonListener);
        jsonListener.endField();
    }

    private void aJsonValue(PositionTrackingPushbackReader pushbackReader, JsonListener jsonListener) throws IOException, InvalidSyntaxException {
        char nextChar = (char)this.readNextNonWhitespaceChar(pushbackReader);
        switch (nextChar) {
            case '\"': {
                pushbackReader.unread(nextChar);
                jsonListener.stringValue(this.stringToken(pushbackReader));
                break;
            }
            case 't': {
                char[] remainingTrueTokenCharacters = new char[3];
                int trueTokenCharactersRead = pushbackReader.read(remainingTrueTokenCharacters);
                if (trueTokenCharactersRead != 3 || remainingTrueTokenCharacters[0] != 'r' || remainingTrueTokenCharacters[1] != 'u' || remainingTrueTokenCharacters[2] != 'e') {
                    pushbackReader.uncount(remainingTrueTokenCharacters);
                    throw new InvalidSyntaxException("Expected 't' to be followed by [[r, u, e]], but got [" + Arrays.toString(remainingTrueTokenCharacters) + "].", pushbackReader);
                }
                jsonListener.trueValue();
                break;
            }
            case 'f': {
                char[] remainingFalseTokenCharacters = new char[4];
                int falseTokenCharactersRead = pushbackReader.read(remainingFalseTokenCharacters);
                if (falseTokenCharactersRead != 4 || remainingFalseTokenCharacters[0] != 'a' || remainingFalseTokenCharacters[1] != 'l' || remainingFalseTokenCharacters[2] != 's' || remainingFalseTokenCharacters[3] != 'e') {
                    pushbackReader.uncount(remainingFalseTokenCharacters);
                    throw new InvalidSyntaxException("Expected 'f' to be followed by [[a, l, s, e]], but got [" + Arrays.toString(remainingFalseTokenCharacters) + "].", pushbackReader);
                }
                jsonListener.falseValue();
                break;
            }
            case 'n': {
                char[] remainingNullTokenCharacters = new char[3];
                int nullTokenCharactersRead = pushbackReader.read(remainingNullTokenCharacters);
                if (nullTokenCharactersRead != 3 || remainingNullTokenCharacters[0] != 'u' || remainingNullTokenCharacters[1] != 'l' || remainingNullTokenCharacters[2] != 'l') {
                    pushbackReader.uncount(remainingNullTokenCharacters);
                    throw new InvalidSyntaxException("Expected 'n' to be followed by [[u, l, l]], but got [" + Arrays.toString(remainingNullTokenCharacters) + "].", pushbackReader);
                }
                jsonListener.nullValue();
                break;
            }
            case '-': 
            case '0': 
            case '1': 
            case '2': 
            case '3': 
            case '4': 
            case '5': 
            case '6': 
            case '7': 
            case '8': 
            case '9': {
                pushbackReader.unread(nextChar);
                jsonListener.numberValue(this.numberToken(pushbackReader));
                break;
            }
            case '{': {
                pushbackReader.unread(nextChar);
                this.objectString(pushbackReader, jsonListener);
                break;
            }
            case '[': {
                pushbackReader.unread(nextChar);
                this.arrayString(pushbackReader, jsonListener);
                break;
            }
            default: {
                throw new InvalidSyntaxException("Invalid character at start of value [" + nextChar + "].", pushbackReader);
            }
        }
    }

    private String numberToken(PositionTrackingPushbackReader in) throws IOException, InvalidSyntaxException {
        StringBuilder result2 = new StringBuilder();
        char firstChar = (char)in.read();
        if ('-' == firstChar) {
            result2.append('-');
        } else {
            in.unread(firstChar);
        }
        result2.append(this.nonNegativeNumberToken(in));
        return result2.toString();
    }

    private String nonNegativeNumberToken(PositionTrackingPushbackReader in) throws IOException, InvalidSyntaxException {
        StringBuilder result2 = new StringBuilder();
        char firstChar = (char)in.read();
        if ('0' == firstChar) {
            result2.append('0');
            result2.append(this.possibleFractionalComponent(in));
            result2.append(this.possibleExponent(in));
        } else {
            in.unread(firstChar);
            result2.append(this.nonZeroDigitToken(in));
            result2.append(this.digitString(in));
            result2.append(this.possibleFractionalComponent(in));
            result2.append(this.possibleExponent(in));
        }
        return result2.toString();
    }

    private char nonZeroDigitToken(PositionTrackingPushbackReader in) throws IOException, InvalidSyntaxException {
        char result2;
        char nextChar = (char)in.read();
        switch (nextChar) {
            case '1': 
            case '2': 
            case '3': 
            case '4': 
            case '5': 
            case '6': 
            case '7': 
            case '8': 
            case '9': {
                result2 = nextChar;
                break;
            }
            default: {
                throw new InvalidSyntaxException("Expected a digit 1 - 9 but got [" + nextChar + "].", in);
            }
        }
        return result2;
    }

    private char digitToken(PositionTrackingPushbackReader in) throws IOException, InvalidSyntaxException {
        char result2;
        char nextChar = (char)in.read();
        switch (nextChar) {
            case '0': 
            case '1': 
            case '2': 
            case '3': 
            case '4': 
            case '5': 
            case '6': 
            case '7': 
            case '8': 
            case '9': {
                result2 = nextChar;
                break;
            }
            default: {
                throw new InvalidSyntaxException("Expected a digit 1 - 9 but got [" + nextChar + "].", in);
            }
        }
        return result2;
    }

    private String digitString(PositionTrackingPushbackReader in) throws IOException {
        StringBuilder result2 = new StringBuilder();
        boolean gotANonDigit = false;
        block3: while (!gotANonDigit) {
            char nextChar = (char)in.read();
            switch (nextChar) {
                case '0': 
                case '1': 
                case '2': 
                case '3': 
                case '4': 
                case '5': 
                case '6': 
                case '7': 
                case '8': 
                case '9': {
                    result2.append(nextChar);
                    continue block3;
                }
            }
            gotANonDigit = true;
            in.unread(nextChar);
        }
        return result2.toString();
    }

    private String possibleFractionalComponent(PositionTrackingPushbackReader pushbackReader) throws IOException, InvalidSyntaxException {
        StringBuilder result2 = new StringBuilder();
        char firstChar = (char)pushbackReader.read();
        if (firstChar == '.') {
            result2.append('.');
            result2.append(this.digitToken(pushbackReader));
            result2.append(this.digitString(pushbackReader));
        } else {
            pushbackReader.unread(firstChar);
        }
        return result2.toString();
    }

    private String possibleExponent(PositionTrackingPushbackReader pushbackReader) throws IOException, InvalidSyntaxException {
        StringBuilder result2 = new StringBuilder();
        char firstChar = (char)pushbackReader.read();
        switch (firstChar) {
            case '.': 
            case 'E': {
                result2.append('E');
                result2.append(this.possibleSign(pushbackReader));
                result2.append(this.digitToken(pushbackReader));
                result2.append(this.digitString(pushbackReader));
                break;
            }
            case 'e': {
                result2.append('e');
                result2.append(this.possibleSign(pushbackReader));
                result2.append(this.digitToken(pushbackReader));
                result2.append(this.digitString(pushbackReader));
                break;
            }
            default: {
                pushbackReader.unread(firstChar);
            }
        }
        return result2.toString();
    }

    private String possibleSign(PositionTrackingPushbackReader pushbackReader) throws IOException {
        StringBuilder result2 = new StringBuilder();
        char firstChar = (char)pushbackReader.read();
        if (firstChar == '+' || firstChar == '-') {
            result2.append(firstChar);
        } else {
            pushbackReader.unread(firstChar);
        }
        return result2.toString();
    }

    private String stringToken(PositionTrackingPushbackReader in) throws IOException, InvalidSyntaxException {
        StringBuilder result2 = new StringBuilder();
        char firstChar = (char)in.read();
        if ('\"' != firstChar) {
            throw new InvalidSyntaxException("Expected [\"] but got [" + firstChar + "].", in);
        }
        ThingWithPosition openDoubleQuotesPosition = in.snapshotOfPosition();
        boolean stringClosed = false;
        block5: while (!stringClosed) {
            char nextChar = (char)in.read();
            switch (nextChar) {
                case '\uffff': {
                    throw new InvalidSyntaxException("Got opening [\"] without matching closing [\"]", openDoubleQuotesPosition);
                }
                case '\"': {
                    stringClosed = true;
                    continue block5;
                }
                case '\\': {
                    char escapedChar = this.escapedStringChar(in);
                    result2.append(escapedChar);
                    continue block5;
                }
            }
            result2.append(nextChar);
        }
        return result2.toString();
    }

    private char escapedStringChar(PositionTrackingPushbackReader in) throws IOException, InvalidSyntaxException {
        char result2;
        char firstChar = (char)in.read();
        switch (firstChar) {
            case '\"': {
                result2 = '\"';
                break;
            }
            case '\\': {
                result2 = '\\';
                break;
            }
            case '/': {
                result2 = '/';
                break;
            }
            case 'b': {
                result2 = '\b';
                break;
            }
            case 'f': {
                result2 = '\f';
                break;
            }
            case 'n': {
                result2 = '\n';
                break;
            }
            case 'r': {
                result2 = '\r';
                break;
            }
            case 't': {
                result2 = '\t';
                break;
            }
            case 'u': {
                result2 = (char)this.hexadecimalNumber(in);
                break;
            }
            default: {
                throw new InvalidSyntaxException("Unrecognised escape character [" + firstChar + "].", in);
            }
        }
        return result2;
    }

    private int hexadecimalNumber(PositionTrackingPushbackReader in) throws IOException, InvalidSyntaxException {
        int result2;
        char[] resultCharArray = new char[4];
        int readSize = in.read(resultCharArray);
        if (readSize != 4) {
            throw new InvalidSyntaxException("Expected a 4 digit hexadecimal number but got only [" + readSize + "], namely [" + String.valueOf(resultCharArray, 0, readSize) + "].", in);
        }
        try {
            result2 = Integer.parseInt(String.valueOf(resultCharArray), 16);
        }
        catch (NumberFormatException e) {
            in.uncount(resultCharArray);
            throw new InvalidSyntaxException("Unable to parse [" + String.valueOf(resultCharArray) + "] as a hexadecimal number.", e, in);
        }
        return result2;
    }

    private int readNextNonWhitespaceChar(PositionTrackingPushbackReader in) throws IOException {
        int nextChar;
        boolean gotNonWhitespace = false;
        do {
            nextChar = in.read();
            switch (nextChar) {
                case 9: 
                case 10: 
                case 13: 
                case 32: {
                    break;
                }
                default: {
                    gotNonWhitespace = true;
                }
            }
        } while (!gotNonWhitespace);
        return nextChar;
    }
}

