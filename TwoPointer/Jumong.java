import java.util.Arrays;
import java.util.Scanner;

public class Jumong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] materials = new int[N];

        for (int i = 0; i < N; i++) {
            materials[i] = sc.nextInt();
        }

        Jumong sample = new Jumong();

        System.out.println(sample.solution(M, materials));
    }

    int solution(int M, int[] materials) {
        Arrays.sort(materials);

        return getCountOfArmor(M, materials);
    }

    int getCountOfArmor(int M, int[] materials) {
        int start_idx = 0;
        int end_idx = materials.length - 1;
        int count = 0;

        while (start_idx < end_idx) {
            int sum = materials[start_idx] + materials[end_idx];
            if (sum == M) {
                count++;
            }
            if (sum > M) {
                end_idx--;
            } else {
                start_idx++;
            }
        }

        return count;
    }
}
