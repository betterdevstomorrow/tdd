# TDD example

### 코드 구현
#### 1. 프로젝트 목표
- 다음과 같은 두 날짜(YYYYMMDD)의 일 수 차이를 구하는 프로그램을 TDD로 작성해 보자.
```
20070515 sub 20070501 = 14
20070501 sub 20070515 = 14
20070301 sub 20070515 = 31 + 30
```

#### 2. 프로젝트 생성 (gradle)
1. gradle 프로젝트 생성
![Alt text](https://github.com/Hyunhoo-Kwon/tdd/blob/master/tdd-example/src/main/resources/images/init%20project1.png)
![Alt text](https://github.com/Hyunhoo-Kwon/tdd/blob/master/tdd-example/src/main/resources/images/init%20project2.png)
- [build.gradle](https://github.com/Hyunhoo-Kwon/tdd/blob/master/tdd-example/build.gradle)
```
...

dependencies {
    testCompile group: 'junit', name: 'junit', version: '4.12'
}
```

#### 3. 어디서 부터 시작할 것인가?
1. 대략적인 설계
   - 결과 = 절대값(첫 번째 날짜의 총 일수 - 두 번째 날짜의 총 일수)
   - Todo.
      - 두 날짜(YYYYMMDD)의 차이일자를 구한다.
        - 전년도까지의 총 일수를 구한다.
        - 전월까지의 총 일수를 구한다.
        - 해당일자까지의 총 일수를 구한다.
      - 특정일자의 총 일수를 구한다.
      
#### 4. 실패하는 테스트 작성
1. 전년도까지의 총 일 수를 구하는 실패하는 테스트
- SubDateTest.java
```
@Test
public void testGetYearDay() {
    SubDate subDate = new SubDate();
    assertThat(subDate.getYearDay(1), is(0));
    assertThat(subDate.getYearDay(1), is(365));
}
```
- SubDate.java
```
public int getYearDay(int year) {
    return 1;
}
```

#### 5. 테스트를 가장 간단한 성공 케이스로 시작하라
- SubDate.java
```
public int getYearDay(int year) {
    if (year==1 )
        return 0;
    else
        return 365;
}
```

#### 6. TDD의 보폭
- 우리는 getYearDay 메서드가 완전하지 않은 것을 알고있다. 실패하는 테스트 코드를 추가해보자.
```
assertThat(subDate.getYearDay(5), is(365+365+365+366));
```
- 이것을 통과하기 위해서는 1년부터 4년까지 중 윤년이 있는지 조사하는 로직이 필요하다. 당장 "뚝딱" 윤년 체크 로직을 만들 수 없으므로 위의 한 줄을 잠시 주석처리하고 윤년인지 아닌지를 검사하는 테스트 코드를 작성하기로 한다.
- 테스트 코드를 작성할 때 중요한 사항은 작성한 테스트를 쉽게 통과할 수 있을지에 대한 판단이다. 만약 테스트를 통과하기 어렵다고 느낀다면 뒤로 미루어 놓거나, 좀 더 쉬운 테스트 코드로 변환을 해야 한다. TDD초보자들은 대부분 테스트 코드가 너무 큰 범위를 다루게 만든다. 이렇게 되면 테스트를 작성하고 어디서부터 시작해야 할지 갈피를 잡지 못하게 된다.

- 윤년인지 체크하는 테스트 코드 추가
- SubDateTest.java
```
@Test
public void testLeapYear() {
    SubDate subDate = new SubDate();
    assertThat(subDate.isLeapYear(0), is(true));
    assertThat(subDate.isLeapYear(1), is(false));
    assertThat(subDate.isLeapYear(4), is(true));
}
```

- SubDate.java
```
public boolean isLeapYear(int year) {
    if (year == 0) return true;
    if (year == 1) return false;
    if (year == 4) return true;
    return false;
}
```

#### 7. 리팩토링
- 테스트 코드와 실제코드를 잘 살펴보면 "데이터의 중복"을 발견할 수 있다. 이는 다음과 같이 리팩토링을 할 수 있다.
- SubDateTest.java
```
public class SubDateTest {

    private SubDate subDate;

    @Before
    public void init() {
        subDate = new SubDate();
    }


    @Test
    public void testGetYearDay() {
        assertThat(subDate.getYearDay(1), is(0));
        assertThat(subDate.getYearDay(2), is(365));
    }

    @Test
    public void testLeapYear() {
        assertThat(subDate.isLeapYear(0), is(true));
        assertThat(subDate.isLeapYear(1), is(false));
        assertThat(subDate.isLeapYear(4), is(true));
    }

}
```

- SubDate.java
```
public boolean isLeapYear(int year) {
    if (year % 4 == 0)
        return true;
    return false;
}
```

### 참고
- [테스트 주도 개발 - 점프 투 자바](https://wikidocs.net/224)
