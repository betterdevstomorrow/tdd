# Netty

## 채널 인바운드 이벤트
- 연결 상대가 어떤 동작을 취했을 때 발생하는 이벤트
- 채널 활성화, 데이터 수신 등
- bottom-up 식으로 동작하기 때문에 가장 먼저 등록한 Handler에서부터 마지막에 등록한 Handler 순서로 동작

### 이벤트 순서
1. channelRegistered
- 채널이 이벤트 루프에 등록되었을 때
- 서버는 최초 서버 소켓 채널 등록, 매 연결마다 클라이언트 소켓 채널 등록 이렇게 두번 발생.
- 클라이언트는 connect() 호출 때마다 발생

2. channelActive
- 채널 입출력 준비 완료
- 연결 직후 한번 수행하는 작업에 유용

3. channelRead
- 데이터가 수신되었음
- ByteBuf객체로 전달됨

4. channelReadComplete
- 데이터 수신이 완료되었음
- 소켓 채널에 더 이상 읽을 데이터가 없을 때 발생

5. channelInactive
- 채널이 비활성화 되었음
- 입출력 작업 불가

6. channelUnregistered
- 채널이 이벤트 루프에서 제거되었음
- 채널 이벤트 처리 불가

(출처)[https://juyoung-1008.tistory.com/23]

# lombok 세팅
## install lombok.jar
- https://projectlombok.org/download
```
❯ java -jar lombok.jar
```

## vscode plugin download
- https://marketplace.visualstudio.com/items?itemName=GabrielBB.vscode-lombok


# netty TEST
- user `EmbeddedChannel`