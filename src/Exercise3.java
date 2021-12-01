public class Exercise3 {
    public static final int ARRAY_SIZE = 11;
    public static void main (String[] args) {
        System.out.println(checkAndChangePhoneNumber("053-7177659"));

    }


    public static String checkAndChangePhoneNumber(String phoneNumber) {
        String result = "";
        if (phoneNumber.length() >= 10 && phoneNumber.length() <= 12) {
            if (isCorrect(phoneNumber)) {
                if (phoneNumber.length() == 11){
                    result = phoneNumber;
                }else{
                    result = changeFormat(phoneNumber);
                }
            }
        }

        return result;
    }



    public static String changeFormat(String phoneNumber) {
        char[] arrayNewNumbers = new char[ARRAY_SIZE];
        String areaCode = "05";
        String newNumbers = "";
        int longNumber = phoneNumber.length();
        int numberBeforeHyphen;
        if (phoneNumber.length() == 10) {
            numberBeforeHyphen = 2;
        }else{
            numberBeforeHyphen = 4;
        }


        for (int j = 0; j < areaCode.length() ; j++) {
            arrayNewNumbers[j] = areaCode.charAt(j);
            arrayNewNumbers[2] = phoneNumber.charAt(numberBeforeHyphen);
            arrayNewNumbers[3] = '-';
        }

        for (int i = (longNumber - 1); i >= (longNumber - 7); i--) {
            if (phoneNumber.length() == 10) {
                arrayNewNumbers[(i + 1)] = phoneNumber.charAt(i);
            }else {
                arrayNewNumbers [i - 1] = phoneNumber.charAt(i);
            }
        }

        for (int i = 0; i < arrayNewNumbers.length; i++) {
            newNumbers = newNumbers + arrayNewNumbers[i];
        }

        return newNumbers;
    }



    public static boolean isCorrect(String phoneNumber) {
        Boolean isCorrect = false;
        boolean correctAreaCode = false;
        boolean correctChars = false;
        int afterTheAreaCode = 4;

        String areaCode = "";
        if (phoneNumber.length() == 10 && phoneNumber.charAt(3) != '-') {
            areaCode = "05";
            afterTheAreaCode = 2;
        }else if (phoneNumber.length() == 11) {
            if (phoneNumber.charAt(3) == '-' && isNumber(phoneNumber, 2))
            areaCode = "05";
        }else {
            areaCode = "9725";
        }

        for (int i = 0; i < areaCode.length(); i++) {
            if (phoneNumber.charAt(i) == areaCode.charAt(i)) {
                correctAreaCode = true;
            } else {
                correctAreaCode = false;
                break;
            }
        }


            for (int i = phoneNumber.length() - 1; i > afterTheAreaCode; i--) {
                if (isNumber(phoneNumber, i)) {
                    correctChars = true;
                } else {
                    correctChars = false;
                    break;
                }
            }

            if (correctAreaCode && correctChars) {
                isCorrect = true;
            }
        return isCorrect;
    }



    public static boolean isNumber (String phoneNumber ,int index) {
        boolean isNumber = false;
        String numbers = "0123456789";

        for (int i = 0; i < numbers.length(); i++) {
            if (phoneNumber.charAt(index) == numbers.charAt(i)) {
                isNumber = true;
                break;
            }

        }

        return isNumber;
    }


}
