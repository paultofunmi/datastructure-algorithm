package interviewprep.javastream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    private static void intStream() {

        IntStream.range(1, 10)
                .forEach(System.out::print);
        System.out.println();

        IntStream.range(1, 10)
                .skip(5)
                .forEach(System.out::println);

        System.out.println("---SUM---");
        System.out.println(
                IntStream.range(1, 3)
                        .sum()
        );
    }

    private static void sorted() {

        Stream.of("Ava", "Aneri", "Alberto")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);


        System.out.println("---Filtering by A---");
        String[] names = {"AI", "Ankit", "Kushal", "Abhishek", "Amanda"};
        Arrays.stream(names)
                .filter(x -> x.startsWith("A"))
                .sorted()
                .forEach(System.out::println);
    }

    private static void map() {

        Stream.of(2, 4, 6, 8, 10)
                .map(x -> x * x)
                .forEach(System.out::println);

        Arrays.stream(new int[] {2, 4, 6, 8, 10})
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);
//                .forEach(System.out::println);
    }

    private static void readFromFileAndPrint() {

        try {

            System.out.println("--Read file and prints only with names starting with letter b");
            Stream<String> batch = Files.lines(Paths.get("MOCK_DATA.csv"));
            batch
                    .sorted()
                    .map(x -> x.toLowerCase())
                    .filter(x -> x.startsWith("b"))
                    .forEach(System.out::println);
            batch.close();

            System.out.println("--Process files and filter results--");
            Stream<String> batch2 = Files.lines(Paths.get("MOCK_DATA-2.csv"));
            long result = batch2
                            .map(x -> x.split(","))
                            .filter(x -> x.length == 4)
                            .count();
            batch2.close();
            System.out.println("Found " + result + " valid records");

            System.out.println("--Read file, process valid records and out record of users with gmail address--");
            Stream<String> batch3 = Files.lines(Paths.get("MOCK_DATA-2.csv"));
            batch3
                    .map(x -> x.split(","))
                    .filter(x -> x.length == 4)
                    .filter(x -> x[3].contains("gmail"))
                    .map(x -> x[0] + " " + x[1] + " " + x[2] + " " + x[3])
                    .forEach(System.out::println);
            batch3.close();

            System.out.println("--Read file, process valid records and out record of users with valid email address--");
            Stream<String> batch4 = Files.lines(Paths.get("MOCK_DATA-2.csv"));
            Map<Integer, String> users = new HashMap<>();

            users = batch4
                    .map(x -> x.split(","))
                    .filter(x -> x.length == 4)
                    .filter(x -> x[3].contains("@"))
                    .collect(Collectors.toMap(
                            x -> Integer.valueOf(x[0]),
                            x -> x[1] + " " + x[2] + " " + x[3]
                    ));

            for(Map.Entry<Integer, String> entry: users.entrySet()) {

                System.out.println("key: " + entry.getKey() +" value: " + entry.getValue());
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static void reduce() {

        Double total = Stream.of(1.5, 2.5, 2.1)
                                .reduce(0.0, (a, b) -> a + b);
        System.out.println(total);
    }

    private static void summaryStats() {

        IntSummaryStatistics summaryStatistics = IntStream.range(1, 10).summaryStatistics();
        System.out.println(summaryStatistics);
    }
    public static void main(String[] args) {

//        StreamTest.intStream();
//        StreamTest.sorted();
//        StreamTest.map();
//        StreamTest.readFromFileAndPrint();
//        StreamTest.reduce();
        StreamTest.summaryStats();
    }
}
