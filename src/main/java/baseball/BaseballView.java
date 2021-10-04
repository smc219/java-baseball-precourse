package baseball;

import nextstep.utils.Console;

public class BaseballView {
	private BaseballController baseballController;
	private boolean open = true;

	public BaseballView() {
		this.baseballController = new BaseballController(this);
	}

	boolean isOpen() {
		return open;
	}

	void finishGame() {
		open = false;
	}

	void inputFromUser() {
		System.out.print("숫자를 입력해주세요 : ");
		String input = Console.readLine();
		if (baseballController.validateInput(input)) {
			return;
		}
		printError(baseballController.getWatingforFinal());
	}

	void printResult(String sentence) {
		System.out.println(sentence);
	}

	void printError(boolean finalResult) {
		if (!finalResult) {
			System.out.println("[Error] 숫자를 잘못 입력하셨습니다. 1부터 9까지의 숫자 중 서로 다른 세가지 숫자를 골라 입력해주세요.");
			return;
		}
		System.out.println("[Error] 숫자를 잘못 입력하셨습니다. 1 또는 2를 입력해주세요.");
	}

}
