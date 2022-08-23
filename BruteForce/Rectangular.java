public class Rectangular {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
//        int[][] sizes = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
//        int[][] sizes = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
        int maxWidth = 0;
        int maxHeight = 0;
        for (int i=0;i<sizes.length;i++) {
            int width;
            int height;
            if (sizes[i][0] > sizes[i][1]) {
                width = sizes[i][0];
                height = sizes[i][1];
            } else {
                width = sizes[i][1];
                height = sizes[i][0];
            }
            if (maxWidth < width) {
                maxWidth = width;
            }
            if (maxHeight < height) {
                maxHeight = height;
            }
        }
        System.out.println(maxHeight * maxWidth);
    }
}
