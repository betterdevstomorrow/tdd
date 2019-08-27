# TDD
## 1. 동작하는 골격 만들기
Client, Server, DB가 정상적으로 연결되어 방 리스트 불러오기
#### Client
- Server가 연 Socket에 정상적으로 붙기
- 방리스트 수신하여 뿌리기
#### Server
- SocketIOServer 정상적으로 생성
- Socket request를 정상적으로 리스닝
- Cloud firestore에 정상적으로 연결
#### DB
- Cloud firestore 준비(dummy data)

