package baseball;

import nextstep.utils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class BaseballModel {
    private BaseballController baseballController;
    private String computerGeneratedNumber;
    private String userGeneratedNumber;

    public BaseballModel() {
        this.computerGeneratedNumber = genNum();
    }

    public BaseballModel(BaseballController baseballController) {
        this.baseballController = baseballController;
        this.computerGeneratedNumber = genNum();
        System.out.println("hint : " + this.computerGeneratedNumber);
    }

    public boolean checkAllDifferent(int first, int second, int third) {
        return (first != second && second != third && third != first);
    }

    private String genNum() {
        int first = Randoms.pickNumberInRange(1, 9);
        int second = Randoms.pickNumberInRange(1, 9);
        int third = Randoms.pickNumberInRange(1, 9);
        while(!checkAllDifferent(first, second, third)) {
            first = Randoms.pickNumberInRange(1, 9);
            second = Randoms.pickNumberInRange(1, 9);
            third = Randoms.pickNumberInRange(1, 9);
        };
        return (Integer.toString(first) + Integer.toString(second) + Integer.toString(third));
    }

    public void setBaseballController(BaseballController baseballController) {
        this.baseballController = baseballController;
    }



    public String getComputerGeneratedNumber() {
        return computerGeneratedNumber;
    }

    public String getUserGeneratedNumber() {
        return userGeneratedNumber;
    }

    public void setComputerGeneratedNumber() {
        computerGeneratedNumber = genNum();
    }

    public void setUserGeneratedNumber(String userGeneratedNumber) {
        this.userGeneratedNumber = userGeneratedNumber;
    }

    public int checkStrike(char num, int ix) {
        if (num == this.getComputerGeneratedNumber().charAt(ix)) return 1;
        return 0;
    }

    public int countStrike(String number) {
        int cnt = 0;
        for (int i = 0; i < 3; ++i) {
            cnt += checkStrike(number.charAt(i), i);
        }
        return cnt;
    }

    public int countContains(char num) {
        String numString = String.valueOf(num);
        if (getComputerGeneratedNumber().contains(numString)) return 1;
        return 0;
    }



    public int countBalls(String number) {
        int cnt = 0;
        for (int i = 0; i < 3; ++i) {
            cnt += countContains(number.charAt(i));
        }
        return cnt - countStrike(number);
    }

    public void getResultFromController(String num) {

    }

}