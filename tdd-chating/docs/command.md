## command and api

### 서버접속

### 채팅방 목록 받아오기
command
```
/room
```
api
```
GET /rooms
```
### 채팅방 개설
command 
```
/create room -n name -u user_name
```
api
```
POST /rooms
```

### 채팅방 입장
command
```
/join room -n name -u user_name
```

### 채팅방 입장 실패
### 채팅 메시지 송신 
api
```
POST /messages
```
### 채팅 메시지 수신
api 
```
GET /messages
```

### 채팅방 나가기
command
```
/exit
```

### 파일 전송
### 파일 수신
### 이미지 보기