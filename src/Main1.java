import java.util.Scanner;

/**
 * Клас представляє число Фібоначчі з його індексом і значенням.
 */
class SequenceNumber {
    private final int index;
    private final long value;

    /**
     * Конструктор класу.
     * @param index номер елемента
     */
    public SequenceNumber(int index) {
        this.index = index;
        this.value = computeFibonacci(index);
    }

    public int getIndex() { return index; }
    public long getValue() { return value; }

    /**
     * Обчислення n-го числа Фібоначчі.
     * @param n номер елемента
     * @return значення числа Фібоначчі
     */
    public static long computeFibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return 1;
        long a = 1, b = 1;
        for (int i = 3; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}

/**
 * Головний клас програми для обчислення чисел Фібоначчі.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;
        int digit;

        if (args.length >= 2) {
            N = Integer.parseInt(args[0]);
            digit = Integer.parseInt(args[1]);
        } else {
            System.out.print("Введіть N (кількість чисел Фібоначчі): ");
            N = scanner.nextInt();
            System.out.print("Введіть цифру (0-9): ");
            digit = scanner.nextInt();
        }

        SequenceNumber[] numbers = new SequenceNumber[N];

        System.out.printf("Перші %d чисел Фібоначчі, що закінчуються на %d:%n", N, digit);
        boolean found = false;
        for (int i = 1; i <= N; i++) {
            numbers[i - 1] = new SequenceNumber(i);
            long value = numbers[i - 1].getValue();
            if (value % 10 == digit) {
                System.out.printf("F(%d) = %d%n", i, value);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Немає таких чисел серед перших " + N);
        }
    }
}
