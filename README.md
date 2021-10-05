# 숫자 야구 게임

## 진행 방법

* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정

* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 구현

### BaseballModel(Model)

* 컴퓨터가 만든 값(computerGeneratedNum)과 사용자가 만든 값(userInputNum) 두 개를 변수로 가진다. [완료]
    * 컴퓨터로 값을 만드는 함수 (genNum) [완료]
    * 컴퓨터로 값을 만드는 함수가 겹치는 수가 없는지 확인하는 함수(checkAllDifferent) [완료]
* Controller로부터 값을 받으면 Controller가 전해준 값으로 사용자가 만든 값을 세팅한다(setUserGeneratedNum).[완료]
* 스트라이크의 개수를 세는 함수(countStrike) [완료]
    * 숫자와 인덱스를 주면 userGeneratedNum의 같은 인덱스에 같은 값이 있는지 확인하고 있으면 1, 없으면 0을 리턴하는 함수(checkStrike) [완료]
* 볼의 개수를 세는 함수 (countBall) [완료]
    * 숫자를 주면 전체를 돌면서 자신과 같지 않은 인덱스에 숫자가 있는지 확인하고 있으면 1, 없으면 0을 리턴하는 함수(checkBall) [완료]
* 종료 상태를 확인하는 함수 (checkGameFinished) [완료]

### BaseballView(View)

* 사용자가 3 strike를 할 때까지 사용자로부터 입력을 받는 메서드 (inputFromUser) [완료]
* 오류를 출력해주는 함수(printError) [완료]
    * Final 여부에 따라서 다른 결과를 출력하도록 해준다. [완료]
* 사용자가 입력한 결과에 대해서 출력을 해주는 메서드 (printResult) [완료]
* UI창이 열려있는지 확인해주는 함수(isOpen) [완료]
* UI창에게 종료 여부를 알려주는 함수(finishGame)

### BaseballController(Controller)

* View로부터 입력받은 내용이 정상인지 확인하는 함수(validateNumber) [완료]
* View로부터 입력받은 내용을 Model에 전달하고, 그 결과를 반환받는 함수(validateInput) [완료]
* Model로부터 전달받은 내용을 확인하고, 그에 따라 View에서 어떤 내용을 반환할지 전달해주는 함수(sendMessage) [완료]
    * 결과를 기반으로 문장을 만들어주는 함수(makeStrikeSentence, makeBallSentence) [완료]
* 3스트라이크가 나온 경우, 해당 경우를 확인하고 View로부터 마지막 메시지를 출력할 수 있도록 문장을 전달하는 함수(sentFinalMessage) [완료]
* 잘못된 Final Message가 나온 경우 오류를 확인하는 함수(validateFinalNumber) [완료]
* 제대로된 Final Message가 나온 경우 계속하기를 원하는지, 멈추기를 원하는지 확인하는 함수(checkGameFinished) [완료]
