package LeetCode.StringManipulation;

/*
    ----------------------------------------------------------------
    | Problem: Remove Digit From Number to Maximize Result
    | Link: https://leetcode.com/contest/weekly-contest-291/problems/remove-digit-from-number-to-maximize-result/
    | Status: Wrong Solution
    ----------------------------------------------------------------
*/

public class Remove_Digit_From_Number_to_Maximize_Result {

    public static void main(String[] args) {
        String number =  "2998589353917872714814599237991174513476623756395992135212546127959342974628712329595771672911914471";
        char digit = '3';
        System.out.println(Long.parseLong(number));
    }

    public static String removeDigit(String number, char digit) {
        long maxIndex = -1;
        int numberLength = number.length();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                maxIndex = i;
            }
        }

        return number.substring(0, (int) (maxIndex + 1));
    }
}
