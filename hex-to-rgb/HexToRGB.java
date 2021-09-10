    public class HexToRGB {
    
        public static int[] hexStringToRGB(String hex) {
            // hex -> {r, g, b}
            int[] rgb = new int[3];

            int l = 1, r = 3;
            for (int i = 0; i < 3; i++) {
                rgb[i] = hexToInt(hex.substring(l, r));
                l += 2;
                r += 2;
            }

            return rgb;
        }
        
        private static int hexToInt(String hex) {
            return Integer.parseInt(hex, 16);
        }

    }