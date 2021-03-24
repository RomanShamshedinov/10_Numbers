import java.util.Arrays;
import java.util.Scanner;

public class Main {
    @SuppressWarnings("checkstyle:RegexpSingleline")
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        int input = scanner.nextInt();
        final int size = 10;

//        Число массива = сумма индекса и модификатора
        int[] array = getFilledArray(size, input,
                (a, b) -> {
                    return a + b;
                }
        );
        System.out.println(Arrays.toString(array));
//        Число = произведение индекса и модификатора;
        array = getFilledArray(size, input,
                (a, b) -> {
                    return a * b;
                });
        System.out.println(Arrays.toString(array));

//        Число = для чётного индекса <(разделить на 2) плюс модификатор>,
//                для нечётного <(квадрат индекса) минус модификатор>
        array = getFilledArray(size, input,
                (a, b) -> {
                    if (a % 2 == 0) {
                        return a / 2 + b;
                    }
                    return a * a - b;
                });
        System.out.println(Arrays.toString(array));

//        Число = тройной индекс + модификатор
        array = getFilledArray(size, input,
                (a, b) -> {
                    final int c = 3;
                    return c * a + b;
                });
        System.out.println(Arrays.toString(array));

//        Число = (индекс + модификатор) * индекс
        array = getFilledArray(size, input,
                (a, b) -> {
                    return (a + b) * a;
                });
        System.out.println(Arrays.toString(array));

//        Число = всегда -1. :)
        array = getFilledArray(size, input,
                (a, b) -> {
                    return -1;
                });
        System.out.println(Arrays.toString(array));
        scanner.close();
    }


    public static int[] getFilledArray(final int size, final int mod, final ModArray ar) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = ar.process(i, mod);
        }
        return array;
    }
}

