# Cloud Function
Event-driven serverless compute platform으로 클라우드에서 코드를 실행해주는 간편한 서비스.

다음의 사양까지 **무료**로 제공됨 ([자세한 가격 정책](https://cloud.google.com/functions/pricing-summary/))
- 메모리 256MB(CPU 400MHz)
- 월별 호출 100만 개
- 호출당 런타임 300밀리초
- 네트워킹/이그레스 무료(Google API만 사용)

## Getting Started
[Cloud Function Getting Started](https://firebase.google.com/docs/functions/get-started) 참고.

## Test in Local
[Cloud Function Test in Local](https://firebase.google.com/docs/functions/local-emulator?hl=ko) 참고.
### Cloud Firestore
Function에서 Firestore 관련 작업을 하는 경우, local에서 돌고 있는 Firestore emulator에 전달 됨. 만약 Firestore emulator가 돌고 있지 않으면 production에 접근하여, Permission Error가 발생함.

##### Firestore Emulator 설치
```sh
$ firebase setup:emulators:firestore
```
##### Firebase.json 수정
```json
{
  "firestore": {}
}
```
##### Firestore 및 Functions emulator 실행
```sh
$ firebase emulators:start --only functions,firestore
```

# Function List
- [방 목록](#list)
- [방 생성](#create)
- [방 삭제](#delete)
### 방목록 <a id="list">
##### Request Example
```sh
curl -X GET "https://us-central1-tdd-chatting.cloudfunctions.net/getRooms"
```
##### Response
```json
[{
  "id": "YNPxHSShQa7UAR9qntt9",
  "data": {
    "name": "전승훈"
  }
},
{
  "id": "lesJrL6xS5e5aRk77u0s",
  "data": {
    "name":"no.1"
  }
}]
```

### 방생성 <a id="create">
Response로 생성된 room id 응답.
##### Request Example
```sh
curl -X GET "https://us-central1-tdd-chatting.cloudfunctions.net/createRoom?name=test"
```
##### Response
```
ile65Oc9F9Kdv9M5ixpg
```

### 방삭제 <a id="delete">
id는 room id.
##### Request Example
```sh
curl -X GET "https://us-central1-tdd-chatting.cloudfunctions.net/deleteRoom?id=ile65Oc9F9Kdv9M5ixpg"
```
##### Response
```
Document id: ile65Oc9F9Kdv9M5ixpg successfully deleted
```