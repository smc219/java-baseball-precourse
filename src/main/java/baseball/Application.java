package baseball;

public class Application {
	public static void main(String[] args) {
		// TODO 숫자 야구 게임 구현
		BaseballView baseballView = new BaseballView();

		while (baseballView.isOpen()) {
			baseballView.inputFromUser();
		}

	}
}
