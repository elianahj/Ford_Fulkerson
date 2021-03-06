# 컴퓨터알고리즘 201902954한현진

## Ford Fulkerson 알고리즘
> 그래프의 시작점에서 도착점으로 동시에 보낼 수 있는 **최대 용량**을 구하는 알고리즘
#### 알고리즘을 위한 요소들
- 시작점 : Source
- 도착점 : Sink
- a에서 b로 실제로 보내는 용량 : F(a,b)
- a에서 b로 보낼 수 있는 잔여 용량 : residual(a,b)
--------
### 구현 방법
#### 1. 시작점에서 도착점까지 가는 경로를 DFS/BFS를 이용하여 찾는다
- **DFS**(깊이우선탐색) : 현재 정점에서 더 이상 내려갈 수 없을 때까지 내려간 뒤 옆으로 이동
- **BFS**(너비우선탐색) : 현재 정점에서 가까운 점들부터 탐색 
- BFS로 구현하였다
- 잔여 용량이 0보다 큰 경우만 찾는다
  =>  **residual > 0**
#### 2. 찾은 경로 내 간선 중 가장 작은 잔여 용량을 찾는다
- 찾은 경로에 가장 작은 잔여 용량만큼을 보낸다
#### 3. 정간선에는 잔여 용량에서 보낸 용량을 빼고, 역간선에는 잔여 용량에서 보낸 용량을 더한다
- 새로운 간선인 역간선을 만들고, 유량을 되돌려 새로운 경로를 탐색할 수 있게 한다
- => 하단 예제 풀이 3번 과정에서 역간선으로 유량을 되돌려 새로운 경로를 탐색하는 과정을 볼 수 있다 
#### > 위 과정들을 통해 빠짐 없이 경로를 찾아 출발점에서 도착점까지 최대 용량을 보낸다
-------
### 예제 풀이
![image](https://user-images.githubusercontent.com/80517119/164936764-b9f630f0-e327-4f1f-860b-5c75ef2b4279.png)
#### 실행 결과
![Capture](https://user-images.githubusercontent.com/80517119/164936894-7ae9dfcb-6ae5-4419-9810-050a9faddd06.JPG)

--------
### 성능 분석
#### 시간 복잡도
- BFS를 이용하여 최대 간선의 수만큼 반복 = O(E) 소요
- 역간선 최대 O(VE) 소요
> O(VE^2) 
- DFS를 이용할 경우 경로에 대해 최대로 보낼 수 있는 용량을 찾기 위해 용량 F만큼 루프를 돌게 되므로 O((E)F)가 소요된다
#### > 따라서 DFS를 이용한 경우 용량 F가 클수록 영향을 많이 받지만, DFS를 이용한 경우에는 용량 F보다 간선에 대해 영향을 더 많이 받는다
- 용량을 크게 한 경우
 ![231354135](https://user-images.githubusercontent.com/80517119/165514159-3a40fda8-d41c-4f65-afea-05e06813d91b.JPG)
- 위의 예제 문제의 경우
 ![efsfswfe](https://user-images.githubusercontent.com/80517119/165514231-88877219-c73b-4988-8124-89bf07d75df2.JPG)
> 큰 차이가 없는 것을 볼 수 있다

