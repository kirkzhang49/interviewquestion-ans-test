  /* The function assumes that there are at least two
       elements in array.
       The function returns a negative value if the array is
       sorted in decreasing order. 
       Returns 0 if elements are equal */
    int maxDiff(int arr[], int arr_size) 
    {
        int max_diff = arr[1] - arr[0];
        int i, j;
        for (i = 0; i < arr_size; i++) 
        {
            for (j = i + 1; j < arr_size; j++) 
            {
                if (arr[j] - arr[i] > max_diff)
                    max_diff = arr[j] - arr[i];
            }
        }
        return max_diff;
    }

    parseInt("-20") returns -20

    http://www.geeksforgeeks.org/string-to-integer-in-java-parseint/