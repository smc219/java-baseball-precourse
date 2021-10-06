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
		int randBall = Randoms.pickNumberInRange(1, 3);
		int randStrike = Randoms.pickNumberInRange(1,3);

		Assertions.assertEquals(baseballController.makeBallSentence(randBall), randBall + "볼");
		Assertions.assertEquals(baseballController.makeStrikeSentence(randStrike), randStrike + "스트라이크");


	}

}
