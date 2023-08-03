import java.util.Arrays;
import java.util.HashMap;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static boolean isItAanagram4(String w1, String w2) {
        if (w1.length() != w2.length()) return false;

        char[] letters1 = w1.toCharArray();
        char[] letters2 = w2.toCharArray();

        Arrays.sort(letters1);
        Arrays.sort(letters2);

        System.out.println(letters1);
        System.out.println(letters2);
        return Arrays.equals(letters1, letters2);
    }

    public static boolean isItAanagram3(String w1, String w2) {
        if (w1.length() != w2.length()) return false;

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        char[] letters1 = alphabet.toCharArray();
        char[] letters2 = alphabet.toCharArray();

        String s1 = w1.toLowerCase();
        String s2 = w2.toLowerCase();

        for (int i = 0; i < s1.length(); i++) {
            letters1[s1.charAt(i) - 'a'] = '_';
            letters2[s2.charAt(i) - 'a'] = '_';
        }

        System.out.println(letters1);
        System.out.println(letters2);
        return Arrays.equals(letters1, letters2);
    }

    public static boolean isItAanagram2(String w1, String w2) {
        if (w1.length() != w2.length()) return false;

        int[] data = new int[26];
        int[] data2 = new int[26];

        for (int i = 0; i < data.length; i++) {
            data[i] = 0;
            data2[i] = 0;
        }

        String s1 = w1.toLowerCase();
        String s2 = w2.toLowerCase();

        int j = 0, k = 0;
        for (int i = 0; i < s1.length(); i++) {
            j = s1.charAt(i) - 'a';
            data[j]++;
            k = s2.charAt(i) - 'a';
            data2[k]++;
        }

        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            char c = (char) ('a' + i);
            // System.out.println(c  + ": " + data[i] + " : "+data2[i]) ;
            if (data[i] != data2[i]) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean isItAanagram(String w1, String w2) {
        HashMap<String, Integer> data = new HashMap<>();
        HashMap<String, Integer> data2 = new HashMap<>();

        if (w1.length() == w2.length()) {
            for (int i = 0; w1.length() > i; i++) {
                if (data.containsKey(String.valueOf(w1.charAt(i)))) {
                    System.out.println("i got in");
                    int new_value = data.get(String.valueOf(w1.charAt(i))) + 1;
                    data.put(String.valueOf(w1.charAt(i)), new_value);
                } else {
                    data.put(String.valueOf(w1.charAt(i)), 1);
                }

                if (data2.containsKey(String.valueOf(w2.charAt(i)))) {
                    System.out.println("i got in");
                    int new_value2 = data2.get(String.valueOf(w2.charAt(i))) + 1;
                    data2.put(String.valueOf(w2.charAt(i)), new_value2);
                } else {
                    data2.put(String.valueOf(w2.charAt(i)), 1);
                }
            }
            System.out.println(data);
            System.out.println(data2);

            for (String o : data.keySet()) {
                System.out.println(o + " " + data.get(o) + " " + data2.get(o));
                if (data.get(o) != data2.get(o)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String word = "staTeAaBa";
        String word2 = "BAbataesT";


        System.out.println(isItAanagram(word, word2));
        System.out.println(isItAanagram2(word, word2));
        System.out.println(isItAanagram3(word, word2));
        System.out.println(isItAanagram4(word, word2));


    }


}