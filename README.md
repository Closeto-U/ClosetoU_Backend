# 옷달 (옷장 달력) REST API



## `/member`

#### 1. `/siginin` (POST) 

아이디와 비밀번호를 통해 인증 토큰 발급

##### Request

| Request Component | Value                                                        |
| ----------------- | ------------------------------------------------------------ |
| Name              | /signin                                                      |
| Header            | accept: application/json                                     |
| Body              | {<br />     "email": "email_address",<br />     "password": "password_value"<br />} |
| Method            | POST                                                         |

##### Body Parameter

| Parameter | Description   | Required |
| --------- | ------------- | -------- |
| email     | 유저 이메일   | 필수     |
| password  | 유저 비밀번호 | 필수     |

##### Response

| Status Code      | Description                           |
| ---------------- | ------------------------------------- |
| 200 OK           | 요청이 성공적으로 완료됨.             |
| 401 UnAuthorized | 아이디 또는 비밀번호가 올바르지 않음. |
| 404 Not Found    | 요청된 자원이 존재하지 않음.          |

```
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3b25qdUBuYXZlci5jb20iLCJyb2xlIjoiVVNFUiIsImlhdCI6MTYwOTQxOTU0NSwiZXhwIjoxNjA5NDIzMTQ1fQ.OWidIHqUdGqxOy6hjgowE5BXNcNOQ5JEQUU5yt9zolA (Token_Value)
```