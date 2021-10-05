package baseball;

public class BaseballController {

	private BaseballView baseballView;
	private BaseballModel baseballModel;
	private final String FINAL_MESSAGE = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 끝\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";



	public BaseballController(BaseballView baseballView) {
		this.baseballView = baseballView;
		this.baseballModel = new BaseballModel(this);
	}


	public boolean getWatingforFinal() {
		return baseballModel.isWaitingForFinished();
	}

	public String makeStrikeSentence(int strikes) {
		if (strikes == 0)
			return "";
		if (strikes == 3)
			return FINAL_MESSAGE;
		return strikes + "스트라이크";
	}

	public String makeBallSentence(int balls) {
		if (balls == 0)
			return "";
		return balls + "볼";
	}

	public String makeSentence(String strikeSentene, String ballSentence) {
		if (strikeSentene.equals("") && ballSentence.equals(""))
			return "낫싱";
		if (strikeSentene.equals(""))
			return ballSentence;
		if (ballSentence.equals(""))
			return strikeSentene;
		return strikeSentene + " " + ballSentence;
	}

	public void checkGameFinish(String userInput) {
		if (userInput.equals("1")) {
			baseballModel.setComputerGeneratedNumber();
			baseballModel.checkGameFinished(false);
			return;
		}

		baseballView.finishGame();

	}

	public boolean validateInput(String userInput) {
		if (validateFinalNumber(userInput)) {
			checkGameFinish(userInput);
			return true;
		}
		if (validateNumber(userInput)) {
			baseballModel.getResultFromController(userInput);
			return true;
		}
		return false;
	}

	private boolean validateFinalNumber(String userInput) {
		if (!getWatingforFinal())
			return false;
		return (userInput.equals("1") || userInput.equals("2"));
	}

	private boolean validateNumber(String number) {
		if (number.contains("0"))
			return false;
		if (number.length() != 3)
			return false;

		char first = number.charAt(0);
		char second = number.charAt(1);
		char third = number.charAt(2);

		return (first != second && second != third && third != first);

	}

	public void sendMessage(int strikes, int balls) {
		baseballView.printResult(makeSentence(makeStrikeSentence(strikes), makeBallSentence(balls)));
	}

}
