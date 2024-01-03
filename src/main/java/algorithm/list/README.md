# 리스트

## ArrayList

- 배열 기반의 리스트
- 메모리 상 연속적 데이터 저장
- Random access : 배열은 메모리 상 연속적으로 데이터를 저장하므로 첫 주소값을 알고 있으면 어떤 Index에도 즉시 접근이 가능

|           | 시간 복잡도 |
|-----------|--------|
| Access    | O(1)   |
| Search    | O(n)   |
| Insertion | O(n)   |
| Deletion  | O(n)   |

## LinkedList

- 노드(데이터 + 다음 노드 주소)라는 구조체 기반의 리스트
- 메모리 상 비 연속적 데이터 저장

|           | 시간 복잡도 |
|-----------|--------|
| Access    | O(n)   |
| Search    | O(n)   |
| Insertion | O(1)   |
| Deletion  | O(1)   |
