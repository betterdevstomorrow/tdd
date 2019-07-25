# Database Schema
Firebase에서 제공하는 NoSQL Document DB인 [Cloud Firestore](https://firebase.google.com/docs/firestore/?hl=ko) 사용.
#### 왜??
대화 내용이라는 방대한 비정형 데이터를 저장하기에는 NoSQL이 적합함.
## 1. NoSQL Document DB란?
Key와 value의 형태로 저장됨. Document는 한 개 이상의 key-value pair로 이루어져 있으며, value로 collection을 가질 수 있음. Document는 일반적으로 JSON이나 xml 형태로 인코딩되어 출력 됨. Collection이란 단순히 document들의 container 임.
##### Document encoded in JSON
```json
{
    "FirstName": "Bob",
    "Address": "5 Oak St.",
    "Hobby": "sailing"
}
```
Document 모델에서는 document 내의 key-value를 이용한 질의가 가능함. 다만 이를 위해서는 서비스 별로 정의해놓은 질의 언어를 사용해야 함.
##### MongoDB query
```sql
db.mycol.find({
  $or:[
    {"by":"tutorials point"},{"title": "MongoDB Overview"}
  ]
}).pretty()
```
##### MongoDB query result
```json
{
   "_id": ObjectId(7df78ad8902c),
   "title": "MongoDB Overview",
   "description": "MongoDB is no sql database",
   "by": "tutorials point",
   "url": "http://www.tutorialspoint.com",
   "tags": ["mongodb", "database", "NoSQL"],
   "likes": "100"
}
```
## 2. Data Models
### 2.1. User Data Model
```json
{
  "_id": "1",
  "name": "tdd"
}
```
### 2.2. Room Data Model
```json
{
  "_id": "1",
  "name": "tdd-chat",
}
```
### 2.3. Message Data Model
```json
{
  "_id": "1",
  "roomId": "1",
  "userId": "1",
  "text": "hello",
  "timestamp": 1563680863
}
```

## References
- https://namu.wiki/w/NoSQL
- https://en.wikipedia.org/wiki/Document-oriented_database
- https://www.tutorialspoint.com/mongodb/mongodb_query_document


