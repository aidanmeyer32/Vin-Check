import java.util.*;
class Algorithm {
    private boolean isValid;
    private static final Map<Character, Integer> charValues = new HashMap<>();
    private static final int[] weights = {8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2};

    static {
        // Initialize character values
        charValues.put('A', 1); charValues.put('B', 2); charValues.put('C', 3); charValues.put('D', 4);
        charValues.put('E', 5); charValues.put('F', 6); charValues.put('G', 7); charValues.put('H', 8);
        charValues.put('J', 1); charValues.put('K', 2); charValues.put('L', 3); charValues.put('M', 4);
        charValues.put('N', 5); charValues.put('P', 7); charValues.put('R', 9); charValues.put('S', 2);
        charValues.put('T', 3); charValues.put('U', 4); charValues.put('V', 5); charValues.put('W', 6);
        charValues.put('X', 7); charValues.put('Y', 8); charValues.put('Z', 9);
        for (int i = 0; i <= 9; i++) {
            charValues.put(Character.forDigit(i, 10), i);
        }
    }

    public Algorithm() {
        this.isValid = false;
    }

    public String checkLine(String line){
        line = cleanLine(line);

        if (line.length() != 17) {
            isValid = false;
            return "";
        }

        for (char ch : line.toCharArray()) {
            if (!charValues.containsKey(ch)) {
                isValid = false;
                return "";
            }
        }

        int sum = 0;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            sum += charValues.get(ch) * weights[i];
        }

        int remainder = sum % 11;
        char checkDigit = (remainder == 10) ? 'X' : Character.forDigit(remainder, 10);

        isValid = (line.charAt(8) == checkDigit);

        return isValid ? "Valid VIN" : "Invalid VIN";
    }

    private String cleanLine(String line){
        line = line.toUpperCase().replaceAll("-", "");
        return line;
    }

    public boolean isValid(){
        return isValid;
    }
}