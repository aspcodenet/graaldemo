package se.systementor.graaldemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

// Started GraaldemoApplication in 0.618 seconds (process running for 1.111), 6275
//                                 0.013 seconds (process running for 0.017)

@Component
public class TestRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        int n = 0;
        var start = System.nanoTime();
        for(int i = 0; i < 1000; i++){
            var  values = IntStream.generate(() -> new Random().nextInt(100)).limit(100000).toArray();
            var res = Arrays.stream(values)
                    .map(x -> x + 1)
                    .map(x -> x * 2)
                    .map(x -> x + 2)
                    .reduce(0, Integer::sum);
            if(res % 10 == 2){
                n++;
            }
        }
        var end = System.nanoTime();
        System.out.println((end - start) / 1000000);
        System.out.println(n);


    }
}
