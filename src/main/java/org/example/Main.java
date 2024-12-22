package org.example;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        IceCreamMachine machine = new IceCreamMachine(new String[]{
//                "vanilla", "chocolate"
//        }, new String[]{
//                "chocolate sauce"
//        });
//        List<IceCreamMachine.IceCream> scoops = machine.scoops();
//
//        /*
//         * Should print:
//         * vanilla, chocolate sauce
//         * chocolate, chocolate sauce
//         */
//        for (IceCreamMachine.IceCream iceCream : scoops) {
//            System.out.println(iceCream.ingredient + ", " + iceCream.topping);
//        }
//        System.out.println(iceCreamMachine.getDiscountedPrice(12, 100, IceCreamMachine.DiscountType.Weight));
//        System.out.println(encodeString("AAAABBBCCDA"));
//        System.out.println(decodeString("4A3B2C1D2A"));

        SumNumbers sumNumbers = (x, y) -> x + y;
        System.out.println(sumNumbers.sum(4, 5));
        Predicate<String> isEmptyString = str -> str.isEmpty();

        System.out.println(isEmptyString.test(""));
        System.out.println(isEmptyString.test("a"));

        List<String> list = Arrays.asList("Ime", "prezime", "NadImak");

        list.replaceAll(str -> str.toLowerCase());
        list.forEach(System.out::println);
        System.out.println("---------------------");
        list.replaceAll(str -> str.toUpperCase());
        list.forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::print);
        System.out.println();
        numbers.stream().filter(n -> n % 2 == 1).forEach(System.out::print);
        System.out.println();

        List<String> strings = Arrays.asList("Marko", "Lilia", "Steven", "Joe");
        strings.sort((str1, str2) -> str1.compareToIgnoreCase(str2));
        strings.forEach(System.out::println);

        List<Double> doubles = Arrays.asList(1.3, 2.4, 5.4, 3.2, 6.3, 9.1, 2.2);
        Double average = doubles.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        System.out.println(average);

        List<Integer> numbers2 = Arrays.asList(3, 5, 7, 2, 4, 43, 3, 2, 8, 8, 5);
        numbers2.stream().distinct().forEach(System.out::println);

        LongUnaryOperator factorial = x -> {
          long result = 1;
          for (long i = 1; i <= x; i++) {
              result *= i;
          }
          return result;
        };

        System.out.println(factorial.applyAsLong(5));

        Predicate<Integer> isPrime = x -> {
          if (x <= 1) {
              return false;
          }
          for (int i = 2; i <= Math.sqrt(x); i++) {
              if (x % i == 0) {
                  return false;
              }
          }
          return true;
        };
        System.out.println("Number 5: " + isPrime.test(3));
        System.out.println("Number 6: " + isPrime.test(4));

        BinaryOperator<String> concatStrings = (str1, str2) -> str1.concat(str2);

        System.out.println(concatStrings.apply("Djordje ", "Krstic"));

        List<Integer> integerList = Arrays.asList(2, 3, 4, 33, 6, 7, 8);
        Optional<Integer> max = integerList.stream().max(Integer::compareTo);
        Optional<Integer> min = integerList.stream().min(Integer::compareTo);
        System.out.println(max.orElse(-1));
        System.out.println(min.orElse(-1));

        Integer sum = integerList.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        Integer mult = integerList.stream().reduce(1, Math::multiplyExact);
        System.out.println(mult);

        String sentence = "This is a long sentence for a lambda expression!";

        WordCounter wordCounter = text -> text.split("\\s+").length;
        UnaryOperator<String> numOfWords = str -> str.split(" ").length + "";
        System.out.println(numOfWords.apply(sentence));
        System.out.println(wordCounter.countWords(sentence));

        String checkPalindrome = "Madam";
        Predicate<String> isPalindrome = str -> {
            System.out.println(str);
            String reversed = new StringBuilder(str).reverse().toString();
            System.out.println(reversed);
            System.out.println("-----------------");;
            return str.equals(reversed);
        };
        System.out.println(isPalindrome.test(checkPalindrome.toLowerCase()));

        List<Integer> listOfRandomNumbers = Arrays.asList(4, 7, 2, 7, 1, 4, 2, 9, 6, 8);
        int sumOfEvenRandomNumbers = listOfRandomNumbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(num -> num * num)
                .sum();

        System.out.println(sumOfEvenRandomNumbers);//140

        int sumOfOddRandomNumbers = listOfRandomNumbers.stream()
                .filter(num -> num % 2 == 1)
                .mapToInt(num -> num * num)
                .sum();
        System.out.println(sumOfOddRandomNumbers);//180
        List<String> listOfWords = Arrays.asList("Brown", "Computer", "Age", "Burger");
        Predicate<String> containsWord = str -> str.equalsIgnoreCase("Computer");
        Boolean flag = listOfWords.stream().anyMatch(containsWord);
        System.out.println(flag);
        int longestString = listOfWords.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);

        int shortestString = listOfWords.stream()
                .mapToInt(String::length)
                .min()
                .orElse(0);

        Predicate<Integer> isPerfectSquare = x -> {
            int sqrt = (int) Math.sqrt(x);
            return sqrt * sqrt == x;
        };
        System.out.println(isPerfectSquare.test(3));

        List<Integer> anotherIntList = Arrays.asList(44, 31, 999, 2134, 23, 1);

        Integer smallest = anotherIntList.stream()
                .sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);

        System.out.println(smallest);

        Integer biggest = anotherIntList.stream()
                .sorted().skip(1).findFirst().orElse(null);

        System.out.println(biggest);

        List<Person> personList = Arrays.asList(new Person("Djordje", 23), new Person("Aelksa", 33)
        , new Person("Ana", 19), new Person("Lilija", 32), new Person("Petar", 12));

        List<Person> sortedPersonList = personList.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());
        sortedPersonList.forEach(System.out::println);

        List<Integer> integerList1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sumOfFirst4PrimeNumbers = integerList1.stream()
                .limit(3)
                .filter(isPrime::test)
                .reduce(0, Integer::sum);
        System.out.println(sumOfFirst4PrimeNumbers);

//        int start_prime = 100;
//        int end_prime = 200;
//
//        // Calculate the sum of prime numbers using lambda expression
//        int sumOfPrimes = IntStream.rangeClosed(start_prime, end_prime)
//                .filter(Main::isPrime)
//                .sum();
//        System.out.println("Sum of prime numbers between " + start_prime + " and " + end_prime + ": " + sumOfPrimes);

        List<String> list2 = Arrays.asList("IME", "PREZIME", "NADIMAK");

        boolean areAllUpper = list2.stream()
                .allMatch(str -> str.toUpperCase().equals(str));
        System.out.println(areAllUpper);
        boolean areAllLower = list2.stream()
                .allMatch(str -> str.toLowerCase().equals(str));
        System.out.println(areAllLower);
        boolean areMixed = !areAllLower && !areAllUpper;
        System.out.println(areMixed);

        double averageLength = list2.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0);

        System.out.println(averageLength);

        Function<Integer, String> convertToBinary = x -> Integer.toBinaryString(x);
        integerList1.stream()
                .map(convertToBinary::apply)
                .forEach(System.out::println);

    }

//    public static boolean isPrime(int number) {
//        if (number <= 1) {
//            return false;
//        }
//        for (int i = 2; i <= Math.sqrt(number); i++) {
//            if (number % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }

    interface SumNumbers {
        int sum(int a, int b);
    }

    @FunctionalInterface
    interface WordCounter {
        int countWords(String text);
    }

    @FunctionalInterface
    interface IsPalindrome {
        boolean isPalindrome(String str);
    }

    public static String encodeString(String str) {
        String encoded = "";
        int counter = 1;
        char c = str.charAt(0);
        if (str.length() > 1) {
            for (int i = 1; i < str.length(); i++) {
                if (c == str.charAt(i)) {
                    counter++;
                } else {
                    encoded += "" + counter + c;
                    c = str.charAt(i);
                    counter = 1;
                }
            }
        }
        encoded += "" + counter + c;

        return encoded;
    }

    public static String decodeString(String str) {
        String decoded = "";
        for (int i = 0; i < str.length(); i += 2) {
            int counter = Integer.parseInt(str.charAt(i) + "");
            char c = str.charAt(i + 1);
            for (int j = 0; j < counter; j++) {
                decoded += c;
            }
        }
        return decoded;
    }
}