package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nextstep.utils.Randoms;

public class BaseballControllerTest {
	BaseballController baseballController;
	BaseballModel baseballModel;
	BaseballView baseballView;
	@BeforeEach
	void setup() {
		baseballView = new BaseballView();
		baseballController = new BaseballController(baseballView);


	}

	@Test
	void testValidateInput() {
		Assertions.assertFalse(baseballController.validateInput("test"));
		Assertions.assertTrue(baseballController.validateInput("456"));
		Assertions.assertFalse(baseballController.validateInput("445"));
		Assertions.assertFalse(baseballController.validateInput("555"));
	}

	@Test
	void testMakeSentence() {
		int randBall = Randoms.pickNumberInRange(1, 2);
		int randStrike = Randoms.pickNumberInRange(0, 3 - randBall);
		String resultSentence = randStrike + "스트라이크 " + randBall + "볼";
		Assertions.assertEquals(baseballController.makeBallSentence(randBall), randBall + "볼");
		Assertions.assertEquals(baseballController.makeStrikeSentence(randStrike), randStrike + "스트라이크");

		Assertions.assertEquals(baseballController.makeSentence(baseballController.makeStrikeSentence(randStrike), baseballController.makeBallSentence(randBall)), resultSentence);
	}

}
