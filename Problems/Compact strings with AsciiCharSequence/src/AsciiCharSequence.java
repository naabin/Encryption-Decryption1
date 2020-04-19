
public class AsciiCharSequence implements CharSequence {
    byte[] chars;

    public AsciiCharSequence(byte[] chars) {
        this.chars = chars.clone();
    }

    @Override
    public int length() {
        return chars.length;
    }

    @Override
    public char charAt(int i) {
        for (int j = 0; j < chars.length; j++) {
            if (j == i) {
                return (char) chars[i];
            }
        }
        return 0;
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return new AsciiCharSequence(java.util.Arrays.copyOfRange(chars, i, i1));
    }

    @Override
    public String toString() {
        return new String(this.chars);
    }

}
interface foo {
    static int bar(){
        return 0;
    }
}