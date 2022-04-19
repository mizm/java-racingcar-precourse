## 기능목록

- Name 구현
    - 글자 길이 valid
- Names 구현
    - Name을 포장하는 1급 객체
    - addNames() 문자열을 ","로 분리해서 Name List에 추가
- Position 구현
    - Car의 위치를 래핑한 Position 객체를 생성한다.
    - move() 메서드를 받으면 position 값이 증가한다.
- Car 구현
    - moveOrStop() 함수 구현 - 불변으로 관리하기 위해 변경 후 Car 반환.
- MoveStrategy 구현
    - RandomMoveStrategy
        - 랜덤 값을 통해 갈 수 있는지 없는지 판별하는 메서드 test 구현
- NumberGenerator 구현
    - RandomNumberGenerator 구현