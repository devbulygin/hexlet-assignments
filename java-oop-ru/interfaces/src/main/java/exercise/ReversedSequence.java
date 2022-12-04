package exercise;

import java.util.stream.IntStream;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String text;

    public ReversedSequence(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        char[] array = text.toCharArray();
        String result = new String();
        for (int i = array.length-1; i >= 0; i--) {
            try {
                result = result + array[i];
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }



    @Override
    public int length() {
        return getText().length();
    }

    @Override
    public char charAt(int index) throws RuntimeException {
        char[] array;
        try {
            array = toString().toCharArray();
        } catch (Exception e){
            throw new RuntimeException("index " + index + "out of line size."
                    + " Input range from 0 to" + (getText().length() -1 ));
        }
        return array[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        char[] array = text.toCharArray();
        String result = new String();
        if (start >= 0 || end <= array.length)
        for (int i = end; i > start; i--) {
            try {
                result = result + array[i];
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return result;

    }

    @Override
    public boolean isEmpty() {
        return CharSequence.super.isEmpty();
    }

    @Override
    public IntStream chars() {
        return CharSequence.super.chars();
    }

    @Override
    public IntStream codePoints() {
        return CharSequence.super.codePoints();
    }
}
// END
