package task_2;
/*2. Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true, если они одинаковые, и false в противном случае.
     Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа по парно по индексам.*/

public class ArrayComparator {
    public static <T> boolean compareArrays(T[] array1, T[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) {
                return false;
            }
        }

        return true; // Все элементы одинаковы
    }

    public static void main(String[] args) {
        Integer[] intArray1 = {1, 2, 3, 4, 5};
        Integer[] intArray2 = {1, 2, 3, 4, 5};
        Integer[] intArray3 = {1, 9, 3, 4, 6};

        String[] strArray1 = {"apple", "orange", "cherry"};
        String[] strArray2 = {"apple", "banana", "cherry"};
        String[] strArray3 = {"apple", "banana", "orange"};
        String[] strArray4 = {"apple", "orange", "cherry"};

        boolean intArraysEqual = compareArrays(intArray1, intArray2);
        boolean strArraysNoEqual = compareArrays(strArray1, strArray2);
        boolean strArraysEqual_2 = compareArrays(strArray1, strArray4);
        boolean intArraysNotEqual = compareArrays(intArray1, intArray3);
        boolean strArraysNotEqual = compareArrays(strArray1, strArray3);

        System.out.println("intArray1 и intArray2 равны: " + intArraysEqual);
        System.out.println("strArray1 и strArray2 равны: " + strArraysNoEqual);
        System.out.println("intArray1 и intArray3 равны: " + intArraysNotEqual);
        System.out.println("strArray1 и strArray3 равны: " + strArraysNotEqual);
        System.out.println("strArray1 и strArray4 равны: " + strArraysEqual_2);
    }
}
