# 학습 관리 시스템(Learning Management System)
## 진행 방법
* 학습 관리 시스템의 수강신청 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


## LMS 기능 목록
* `Question`
    * [x] : 로그인 사용자, 질문자와 모든 답변자들이 같으면 답변을 삭제 상태로 바꿀 수 있다.
    * [x] : 삭제할 수 없다면 예외를 던진다.
      * [x] : 사용자와 질문자가 달라 삭제할 수 없다면 예외를 던진다.
      * [x] : 질문자와 답변자들이 달라 삭제할 수 없다면 예외를 던진다.

* `Answer`
    * [x] : 질문자와 답변자가 같은지 다른지 확인한다.
    * [x] : 질문이 삭제되면, 댓글도 삭제한다.

* `DeleteHistory`
    * [] : 질문이 삭제되면, 해당 질문과 답글에 대한 삭제 기록을 남긴다.
