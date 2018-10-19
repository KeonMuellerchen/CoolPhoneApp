package Models;

public class RegexExperiment {
    public static void main(String[] args)
    {
        String areaCode = "416";
        String badAreaCode1 = "123";
        String badAreaCode2 = "Hello";

        String acRegex = "[2-9][0-9][0-9]";

        System.out.printf("%s is a valid area code: %b%n", areaCode, areaCode.matches(acRegex));
        System.out.printf("%s is a valid area code: %b%n", badAreaCode1, badAreaCode1.matches(acRegex));
        System.out.printf("%s is a valid area code: %b%n", badAreaCode2, badAreaCode2.matches(acRegex));

        String phoneNum = "7055551234";
        String phoneWithSpaces = "705 555 1234";
        String phoneWithDashes = "705-555-1234";
        String phoneSpaceDash = "705 555-1234";
        String phoneBrackets = "(705) 555-1234";
        String phoneWithDots = "705.555.1234";

        String phoneRegex = "\\(?[2-9]\\d{2}\\)?[-\\s.]?[2-9]\\d{2}[-\\s].?\\d{4}";
        System.out.printf("%s is a valid phone #: %b%n", phoneNum, phoneNum.matches(phoneRegex));
        System.out.printf("%s is a valid phone #: %b%n", phoneWithSpaces, phoneWithSpaces.matches(phoneRegex));
        System.out.printf("%s is a valid phone #: %b%n", phoneWithDashes, phoneWithDashes.matches(phoneRegex));
        System.out.printf("%s is a valid phone #: %b%n", phoneSpaceDash, phoneSpaceDash.matches(phoneRegex));
        System.out.printf("%s is a valid phone #: %b%n", phoneBrackets, phoneBrackets.matches(phoneRegex));
        System.out.printf("%s is a valid phone #: %b%n", phoneWithDots, phoneWithDots.matches(phoneRegex));


    }
}
