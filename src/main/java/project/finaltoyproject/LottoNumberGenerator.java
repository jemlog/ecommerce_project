package project.finaltoyproject;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LottoNumberGenerator {

    public List<Integer> generate(final int money)
    {
        if(!isValidMoney(money))
        {
            throw new RuntimeException("올바른 금액이 아니다!");
        }
        return generate();
    }

    public boolean isValidMoney(final int money)
    {
        return money == 1000;
    }

    private List<Integer> generate()
    {
        return new Random()
                .ints(1,45+1)
                .distinct()
                .limit(6)
                .boxed()
                .collect(Collectors.toList());
    }

}
