package leetcode;

public class PossibleStringOfLengthK {

    static void printAllStringOfKLength(int n, int k) {
        if (k == 0)
            return;
        print_rec("", n, k);
    }

    static void print_rec(String prefix, int n, int k) {
        if (k == 0) {
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < n; i++) {
            String new_prefix = prefix + i;
            print_rec(new_prefix, n, k-1);
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 2; // values 0 - 1
        printAllStringOfKLength(n, k);
    }
}
