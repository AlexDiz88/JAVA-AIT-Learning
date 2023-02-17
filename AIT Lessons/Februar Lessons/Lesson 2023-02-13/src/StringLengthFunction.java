public class StringLengthFunction implements StringToIntFunction{
    @Override
    public int processing(String s) {
        return s.length();
    }
}
