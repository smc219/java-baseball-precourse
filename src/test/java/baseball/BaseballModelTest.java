package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class BaseballModelTest {

    BaseballModel baseballModel;
    BaseballModel spy;
    @BeforeEach
    void beforeEach() {
        baseballModel = new BaseballModel();
        spy = spy(BaseballModel.class);
        when(spy.getComputerGeneratedNumber()).thenReturn("123");
    }



    @Test
    void testCheckStrike() {
        String compared1 = "123";
        String compared2 = "456";
        for (int i = 0; i < 3; ++i) {
            Assertions.assertEquals(1, spy.checkStrike(compared1.charAt(i), i));
            Assertions.assertEquals(0, spy.checkStrike(compared2.charAt(i), i));
        }
    }

    @Test
    void testCountStrikes(){
        // 1 strike
        Assertions.assertEquals(spy.countStrike("145"), 1);
        Assertions.assertEquals(spy.countStrike("425"), 1);
        Assertions.assertEquals(spy.countStrike("453"), 1);
        // 2 strike
        Assertions.assertEquals(spy.countStrike("125"), 2);
        Assertions.assertEquals(spy.countStrike("523"), 2);
        Assertions.assertEquals(spy.countStrike("153"), 2);
        // 3 strike
        Assertions.assertEquals(spy.countStrike("123"), 3);
    }

    @Test
    void testCountContains() {
        String oneSameNum = "451";
        String twoSameNum = "254";
        String threeSameNum = "435";

        Assertions.assertEquals(1, spy.countContains(oneSameNum.charAt(2)));
        Assertions.assertEquals(1, spy.countContains(twoSameNum.charAt(0)));
        Assertions.assertEquals(1, spy.countContains(threeSameNum.charAt(1)));

        Assertions.assertEquals(0, spy.countContains(oneSameNum.charAt(1)));
        Assertions.assertEquals(0, spy.countContains(twoSameNum.charAt(2)));
        Assertions.assertEquals(0, spy.countContains(threeSameNum.charAt(0)));

    }

    @Test
    void testCountBalls() {
        // no strike
        String oneSameNum = "451";
        String twoSameNum = "431";
        String threeSameNum = "312";
        // strike
        String oneStrikeOneBall = "134";
        String oneStrikeTwoBall = "132";


        Assertions.assertEquals(1, spy.countBalls(oneSameNum));
        Assertions.assertEquals(2, spy.countBalls(twoSameNum));
        Assertions.assertEquals(3, spy.countBalls(threeSameNum));
        Assertions.assertEquals(1, spy.countBalls(oneStrikeOneBall));
        Assertions.assertEquals(2, spy.countBalls(oneStrikeTwoBall));

    }

}
