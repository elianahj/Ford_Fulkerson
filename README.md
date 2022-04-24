# 컴퓨터알고리즘_FordFulkerson 201902954한현진

## Ford Fulkerson 알고리즘
> 그래프의 시작점에서 도착점으로 동시에 보낼 수 있는 **최대 용량**을 구하는 알고리즘
#### 알고리즘을 위한 요소들
- 시작점 : Source
- 도착점 : Sink
- a에서 b로 실제로 보내는 용량 : F(a,b)
- a에서 b로 보낼 수 있는 잔여 용량 : R(a,b)
--------
### 구현 방법
#### 1. 시작점에서 도착점까지 가는 경로를 DFS를 이용하여 찾는다
- **DFS**(깊이우선탐색) : 현재 정점에서 더 이상 내려갈 수 없을 때까지 내려간 뒤 옆으로 이동
- 잔여 용량 R이 보내는 용량 F보다 큰 경우만 찾는다
  =>  **R > F**
#### 2. 찾은 경로 중에서 가장 작은 잔여 용량을 찾는다
- 찾은 경로에 가장 작은 잔여 용량만큼을 보냅니다
#### 3. 정간선에는 잔여 용량에서 보낸 용량을 빼고, 역간선에는 잔여 용량에서 보낸 용량을 더합니다
- 역간선을 이용하여 새로운 경로를 찾을 수 있습니다
  
  
  
-------
### java 구현



-------
### 예제 풀이
![image](https://user-images.githubusercontent.com/80517119/164936764-b9f630f0-e327-4f1f-860b-5c75ef2b4279.png)
#### 실행 결과
![Capture](https://user-images.githubusercontent.com/80517119/164936894-7ae9dfcb-6ae5-4419-9810-050a9faddd06.JPG)

--------
### 성능 분석
#### 시간 복잡도
- DFS


