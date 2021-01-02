# Backtracking

```
Backtracking(Node v)
{
  if (Promising(v)){
    if (Solution exists at v) Write Solution;
    else
      for (each child u of v) Backtracking(u);
  }
}
```

* 가능한 모든 경우의 수를 테스트
* 상태공간트리 상에서 DFS 방식으로 탐색
* 불필요한 가지와 그 하위 노드는 탐색하지 않음으로써 효율 증대
