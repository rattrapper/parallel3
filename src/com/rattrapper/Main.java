package com.rattrapper;

import java.util.stream.IntStream;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] data = IntStream.rangeClosed(1, 10000).toArray();
        System.out.println("sum = " +
                Arrays.stream(data).parallel().sum());
        System.out.println("even count = " +
                Arrays.stream(data).parallel().filter(n -> n % 2 == 0).count());
        int minIndex = IntStream.range(0, data.length).parallel()
                .reduce((a, b) -> data[a] < data[b] ? a : b).getAsInt();
        System.out.println("min data[" + minIndex+ "] = " + data[minIndex]);
        System.out.println("checksum = " + Arrays.stream(data).reduce((a, b) -> a ^ b).getAsInt());
    }
}
