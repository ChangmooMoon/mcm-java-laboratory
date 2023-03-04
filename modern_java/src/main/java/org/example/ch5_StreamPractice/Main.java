package org.example.ch5_StreamPractice;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );

        // 2011년에 일어난 모든 트랜잭션을 찾아서 오름차순으로 정리
        List<Transaction> sorted2011Transactions = transactions.stream()
            .filter(t -> t.getYear() == 2011)
            .sorted(comparing(Transaction::getValue))
            .collect(toList());
        System.out.println(sorted2011Transactions);

        // 거래자가 근무하는 모든 도시를 중복없이 나열
        List<String> uniqueTraderCities = transactions.stream()
            .map(t -> t.getTrader().getCity())
            .distinct()
            .collect(toList());
        System.out.println(uniqueTraderCities);

        // 캠브릿지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬
        List<Trader> cambridgeTrader = transactions.stream()
            .map(Transaction::getTrader)
            .filter(t -> t.getCity().equals("Cambridge"))
            .distinct()
            .sorted(comparing(Trader::getName))
            .collect(toList());
        System.out.println(cambridgeTrader);

        // 모든 거래자의 이름을 알파벳순으로 정렬해서 반환
        String traderList = transactions.stream()
            .map(Transaction::getTrader)
            .map(Trader::getName)
            .distinct()
            .sorted()
            .collect(joining(" "));
        System.out.println(traderList);

        // 캠브릿지에 거주하는 거래자의 모든 트랜잭션 값을 출력
        transactions.stream()
            .filter(t -> t.getTrader().getCity().equals("Cambridge"))
            .map(Transaction::getValue)
            .forEach(System.out::println);

        // 전체 트랜잭션 중 최대값
        Optional<Integer> highestValue = transactions.stream()
            .map(Transaction::getValue)
            .reduce(Integer::max);

        System.out.println(highestValue.orElse(0));

        // 전체 트랜잭션 중 최소값
        Optional<Transaction> minValue = transactions.stream()
            .min(comparing(Transaction::getValue));
        System.out.println(minValue.get());
    }
}

