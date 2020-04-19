/**
 * It returns a double value or 0 if an exception occurred
 */

    public static double convertStringToDouble(String input) {
        double num = 0.0;
        try{
            num = Double.parseDouble(input);
        }catch(NumberFormatException | NullPointerException ex ){
            return num;
        }
        return num;
    }

