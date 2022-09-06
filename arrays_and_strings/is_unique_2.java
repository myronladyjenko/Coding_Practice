import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;

// This solution has complexity of O(nlog(n)) and uses no Data Structures
public class is_unique_2
{
    public static void merge(char[] array_from_user, int left, int middle, int right) 
    {
        // find the sizes of the arrays to be merged
        int size1 = middle - left + 1;
        int size2 = right - middle;
        char tempL[] = new char[size1]; 
        char tempR[] = new char[size2];

        for (int i = 0; i < size1; i++) {
            tempL[i] = array_from_user[left + i];
        }

        for (int i = 0; i < size2; i++) {
            tempR[i] = array_from_user[middle + 1 + i];
        }

        int first = 0;
        int second = 0;

        int merged_index = left;
        while (first < size1 && second < size2) {
            if (tempL[first] <= tempR[second]) {
                array_from_user[merged_index] = tempL[first];
                first++;
            } else {
                array_from_user[merged_index] = tempR[second];
                second++;
            }
            merged_index++;
        }

        while (first < size1) {
            array_from_user[merged_index] = tempL[first];
            first++;
            merged_index++;
        }

        while (second < size2) {
            array_from_user[merged_index] = tempR[second];
            second++;
            merged_index++;
        }  
    } 

    public static void mergeSort(char[] array_from_user, int left, int right) 
    {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(array_from_user, left, middle);
            mergeSort(array_from_user, middle + 1, right);

            merge(array_from_user, left, middle, right);
        }
    }

    public static boolean isUnique (String string_from_user) 
    {
        if (string_from_user.length() <= 1) {
            return true;
        }

        char array_from_user[] = string_from_user.toCharArray();

        int left = 0;
        int right = array_from_user.length - 1;
        // sort a string using merge sort
        mergeSort(array_from_user, left, right);

        for (int i = 0; i < array_from_user.length - 1; i++) {
            if (array_from_user[i] == array_from_user[i + 1]) {
                return false;
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