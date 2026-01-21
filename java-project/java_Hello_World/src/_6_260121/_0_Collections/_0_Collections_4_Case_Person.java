package _6_260121._0_Collections;

import java.util.Objects;

public class _0_Collections_4_Case_Person {
    private String name;
    private int age;

    public _0_Collections_4_Case_Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //컬렉션 사용시 해시 코드(객체에 지정된 번호)를 비교 하고, equals로 논리적으로 맞는지 비교를 한다.(컬렉션을 get할때 실행이 자동적으로 됨)
    //equals와 hashCode는 무조건 재정의 해줘야 한다.
    //this == o로 주소값이 같은지(객체가 완전 동일한지)보긴 하지만 막상 객체의 값만 같아도 true가 되기때문에 없어도 됨
    //==는 객체형에서는 주소까지 비교하고, 기본형인 int, double이런거에서는 값만 비교
    //하지만 같은 객체일때 굳이 값을 비교할 필요는 없어서(최적화 및 성능) 넣음
    //즉, 객체의 값이 같은지만 판단
    @Override
    public boolean equals(Object o) {
        if(this == o)   return true;    //같은 객체인지 확인(같은 객체라면 타입과 값을 확인할 필요 없음)
        if(!(o instanceof _0_Collections_4_Case_Person))  return false;   //타입이 맞는지 확인(타입이 아니라면 실패)
        _0_Collections_4_Case_Person p = (_0_Collections_4_Case_Person) o;
        return (p.getName().equals(name) && p.getAge() == age); //객체는 다르지만 객체의 값이 같을때
    }

    //컬렉션에서 get을 사용할때 버킷 번호를 이용해서 찾는데 객체의 값이 같은걸 찾기 위해 사용해서 버킷 번호를 받아옴
    //이것도 객체의 값이 같은지 판단(값이 같으면 리턴되는 버킷번호도 같음)
    //즉, 순서는 hashCode()로 버킷 번호를 찾고 -> 같은 버킷 번호의 컬렉션의 키 값(객체의 값)이 같은지 equals()로 확인
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    //println을 할대 toString을 자동적으로 실행해준다.
    @Override
    public String toString() {
        return name + "(" + age + ")";
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
