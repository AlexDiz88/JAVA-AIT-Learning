package task;

public class Main {
    public static void main(String[] args) {
        StringLengthCompare stringLengthCompare = (s1, s2) ->{
            String res = s1.length()>s2.length()?s1:s2;
            return res.replaceAll(",","").toUpperCase();
        };

        String str1 = "adaa , ada,a";
        String str2 = "nfthjft d,r kfk, ,fes";
        String str3 = "usehfsfhs ,sff,s,";
        System.out.println(stringLengthCompare.lengthCompare(str1, str2));
        System.out.println(stringLengthCompare.lengthCompare(str1, str3));
    }
}
