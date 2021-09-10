class Solution {
    public static String rangeExtraction(int[] arr) {
        StringBuffer output = new StringBuffer();
        int len = 1;
        int start = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == 1) {
                if (len == 1) {
                    start = arr[i];
                } 
                len++;
            } else {                
                appendNumsByLen(output, start, arr[i], len);
                output.append(',');
                len = 1;
            }
        }
        appendNumsByLen(output, start, arr[arr.length - 1], len);

        return output.toString();
    }

    private static void appendNumsByLen(StringBuffer buf, int start, int end, int len) {
        if (len < 2) {
            buf.append(end);
        } else if (len == 2) {
            buf.append(start);
            buf.append(',');
            buf.append(end);
        } else {
            buf.append(start + "-" + end);
        }
    }
}