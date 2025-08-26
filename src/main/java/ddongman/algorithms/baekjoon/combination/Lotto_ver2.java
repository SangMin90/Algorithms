package ddongman.algorithms.baekjoon.combination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class Lotto_ver2 {
    static boolean nextPermutation(int[] a) {
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }
        if (i <= 0) {
            return false;
        }
        int j = a.length-1;
        while (a[j] <= a[i-1]) {
            j -= 1;
        }
        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;
        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int k = sc.nextInt();
            if (k == 0) {
                break;
            }
            int[] a = new int[k];
            int[] c = new int[k];
            for (int i=0;i<k;i++) {
                a[i] = sc.nextInt();
                if (i >= k-6) {
                    c[i] = 1;
                }
            }
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            do {
                ArrayList<Integer> cur = new ArrayList<>();
                for (int i=0;i<k;i++) {
                    if (c[i] == 1) {
                        cur.add(a[i]);
                    }
                }
                ans.add(cur);
            } while (nextPermutation(c));
            Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    int n = o1.size();
                    int m = o2.size();
                    int i = 0;
                    while (i < n && i < m) {
                        int x1 = o1.get(i);
                        int x2 = o2.get(i);
                        if (x1 < x2) {
                            return -1;
                        } else if (x1 > x2) {
                            return 1;
                        }
                        i += 1;
                    }
                    if (i == n && i != m) {
                        return -1;
                    } else if (i != n && i == m) {
                        return 1;
                    }
                    return 0;
                }
            });
            for (ArrayList<Integer> v : ans) {
                for (int x : v) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}