import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;




// This solution has complexity of O(n) and uses HashMap (can be substituted to a bit vector)
public class is_unique
{
    public static boolean isUnique (String string_from_user) 
    {
        if (string_from_user.length() <= 1) {
            return true;
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put(string_from_user.charAt(0), 1);

        for (int i = 1; i < string_from_user.length(); i++) {
            if (map.containsKey(string_from_user.charAt(i))) {
                return false;
            } else {
                map.put(string_from_user.charAt(i), 1);
            }
        }

        return true;
    } 

    public static void main (String args[]) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a string: ");
        String string_from_user = reader.readLine();

        System.out.println();
        if (isUnique(string_from_user)) {
            System.out.println("String has only Unique characters!");
        } else {
            System.out.println("String does NOT have only Unique characters!");
        }
    }
}
