# Comparable & Comparator

## Primitive & Reference Type
* 기본적인 Java Object는 `Comparable interface`가 구현되어 있음
* Array Type Object : `Arrays.sort()`
* Reference Type Object : `Collections.sort()`
* `sort()` 메소드는 내부적으로 해당 클래스의 `compareTo()` 메소드 호출

## Comparable
* Class에 `Comparable interface` 구현 후 `compareTo()` 메소드 구현하여 사용

##### `compareTo()`
* 현재 object가 먼저면 `음수` 리턴
* 비교 object가 먼저면 `양수` 리턴
* 같은 순서면 `0` 리턴

```java
public class MyClass implements Comparable<MyClass> {

  public int num;
  public String str;
  
  public int compareTo(MyClass o){
    int result = this.num.compareTo(o.num);
    // int result = this.num - o.num;
    if (result == 0){
      result = this.str.compareTo(o.str);
    }
    return result;
  }
}
```

## Comparator
* 기존 `Comparable` 정의와 다른 정렬 결과를 얻고 싶을 때 사용
* `Arrays.sort()`, `Collections.sort()`의 두번째 parameter로 `Comparator` 구현체를 전달


```java
Arrays.sort(arr, new Comparator<MyClass>() {
  @Override
  public int compare(MyClass o1, MyClass o2) {
    return o1.str.compareTo(o2.str);
  }
});
```
