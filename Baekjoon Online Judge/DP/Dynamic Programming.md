# Dynamic Programming

* 주어진 문제를 하위로 나뉘어서 해결
* 하위 문제가 상호 종속성을 가질 때
* 하위 문제 결과를 저장하고 다음 단계 문제에 활용
* 점화식

1. 효과적인 자료구조 고민해보기
2. `dp[n]`, `dp[n-1]`, `dp[n-2]`, ... 간의 관계를 통해 점화식 도출
3. 점화식이 적용되지 않는 초기값 설정
4. 자료구조 및 점화식 구현