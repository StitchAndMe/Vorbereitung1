import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Methods {
    public static void main(String[] args){
        int res = 0;
        res = 1 < 2 ? 1 : 2>1? 1 : 0;
        System.out.println(-5%4);
        System.out.println(1.0/2.0);
        String string = new String("abcd");
        for(char c : string.toCharArray()) System.out.println(c);
    }
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        int i = 5;
        while (i * i <= number) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }
        return true;
    }

    public int binarySearch(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    } //aus: https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0704.%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE.md

    public int binarySearch2(int[] nums, int target) { //right open
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid;
        }
        return -1;
    } //aus https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0704.%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE.md

    /*public static int removeElement(ArrayList<Integer> nums, int val) {
        int size = nums.size();
        for (int i = 0; i < size; i++) {
            if (nums.get(i) == val) {
                for (int j = i + 1; j < size; j++) {
                    nums.set(j - 1, nums.get(j));
                }
                i--;
                size--;
            }
        }
        return size;
    }*/
    public static int findGCD(int a, int b) {
        // Ensure positive numbers for the algorithm
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static int power(int base, int exponent){
        int res = 1;
        while(exponent > 0){
            res *= base;
            exponent--;
        }
        return res;
    }

    public static int sumOfOddsTo(int n){
        int sum = 0;
        while(n>0){
            if(n%2==1){sum += n;}
            n--;
        }
        return sum;
    }
    public static String readString() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int readInt() {
        while (true) {
            String input = readString();
            try {
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("This was not a valid number, please try again.");
            }
        }
    }
    public static void rotate(int[] array, int amount) {
        int length = array.length;

        if(length == 0) {
            return;
        }

        // Get rotation amount into range [0, array.length - 1]
        amount = amount % length;
        if(amount < 0) { //1 nach links ist gleich length - 1 nach rechts
            amount += length;
        }

        // Rotate into new array
        int[] rotated = new int[length];
        for(int i = 0; i < length; i++) {
            rotated[(i + amount) % length] = array[i];
        }

        // Copy from this new array back into old one
        for(int i = 0; i < length; i++) {
            array[i] = rotated[i];
        }
    }
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
    public static String reverseString(String str) {
        // Konvertiere die Eingabezeichenkette in einen Zeichenarray
        char[] charArray = str.toCharArray();

        // Initialisiere zwei Zeiger, einen am Anfang und einen am Ende der Zeichenkette
        int start = 0;
        int end = str.length() - 1;

        // Umdrehen der Zeichenkette
        while (start < end) {
            // Tausche die Zeichen am Anfang und Ende des Arrays
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;

            // Bewege die Zeiger nach innen
            start++;
            end--;
        }

        // Erstelle eine neue Zeichenkette aus dem umgedrehten Zeichenarray
        return new String(charArray);
    }
    public static void printPascalTriangle(int numRows) {
        for (int i = 0; i < numRows; i++) {
            int number = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(number + " ");
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
    public static boolean isPrimeSolution(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    
}
