# TDD
## 1. 동작하는 골격 만들기
Client, Server, DB가 정상적으로 연결되기.
#### Client
- Server가 연 Socket에 정상적으로 붙기
#### Server
- ServerSocket 정상적으로 생성
- Socket request를 정상적으로 리스닝 (Hello message)
- Cloud firestore에 정상적으로 연결
#### DB
- Cloud firestore 준비(dummy data)

