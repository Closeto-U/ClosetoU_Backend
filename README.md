# 옷달 (옷장 달력) REST API



## `/member`

<details open> <summary> Member 접기 / 펼치기 </summary>

#### 1. `/siginin` (POST) 

아이디와 비밀번호를 통해 인증 토큰 발급

<details open> <summary> /sigin 접기 / 펼치기 </summary>

##### Request

<table>
<tr><th>Request Component</th><th>Value</th></tr>
<tr><td> Name</td><td><pre><code>/signin</code></pre></td></tr>
<tr><td>Header </td><td><pre><code>accept: application/json</code></pre> </td></tr>
<tr><td>Body</td><td><pre><code>
{
    "email": "swj@gmail.com",
    "password": "1234321swj"
}
</code></pre> </td></tr>
<tr><td>Method</td><td>POST</td></tr>

##### Body Parameter

| Parameter | Description   | Required |
| --------- | ------------- | -------- |
| email     | 이메일          | 필수      |
| password  | 비밀번호        | 필수      |

##### Response

| Status Code      | Description                           |
| ---------------- | ------------------------------------- |
| 200 OK           | 요청이 성공적으로 완료됨.                   |
| 401 UnAuthorized | 아이디 또는 비밀번호가 올바르지 않음.          |
| 404 Not Found    | 요청된 자원이 존재하지 않음.                 |

```
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3b25qdUBuYXZlci5jb20iLCJyb2xlIjoiVVNFUiIsImlhdCI6MTYwOTQxOTU0NSwiZXhwIjoxNjA5NDIzMTQ1fQ.OWidIHqUdGqxOy6hjgowE5BXNcNOQ5JEQUU5yt9zolA (Token_Value)
```

</details>

<br />

#### 2. `/join` (POST)

회원정보를 입력하여 회원가입

<details open> <summary> /join 접기 / 펼치기 </summary>

##### Request

<table>
<tr><th>Request Component</th><th>Value</th></tr>
<tr><td> Name</td><td><pre><code>/join</code></pre></td></tr>
<tr><td>Header </td><td><pre><code>accept: application/json</code></pre> </td></tr>
<tr><td>Body</td><td><pre><code>
{
    "email": "swj@gmail.com",
    "password": "1234321swj",
    "name": "Son",
    "age": "10",
    "gender": "MALE",
    "birthday": "2021-01-01",
    "nickname": "수박바"
}
</code></pre> </td></tr>
<tr><td>Method</td><td>POST</td></tr>

##### Body Parameter

| Parameter | Description        | Required |
| --------- | ------------------ | -------- |
| email     | 이메일               | true     |
| password  | 비밀번호             | true     |
| name      | 이름                | false    |
| age       | 나이                | false    |
| gender    | 성별 (MALE, FEMALE) | false    |
| birthday  | 생년월일             | false    |
| nickname  | 닉네임               | false   |
| role      | 권한                | true     |

##### Response

| Status Code      | Description                           |
| ---------------- | ------------------------------------- |
| 201 Created      | 회원정보가 성공적으로 생성됨.                |
| 404 Not Found    | 요청된 자원이 존재하지 않음.                 |

</details>

<br />

#### 3. `/list` (GET)

모든 회원의 정보를 조회

<details open> <summary> /list 접기 / 펼치기 </summary>

##### Request

| Request Component | Value                      |
| ----------------- | -------------------------- |
| Name              | `/list`                    |
| Header            | `accept: application/json`<br /> `X-AUTH-TOKEN: TOKEN_VALUE` |
| Body              | N/A                        |
| Method            | GET                        |

##### Response

| Status Code      | Description                              |
| ---------------- | ---------------------------------------- |
| 200 OK           | 회원 정보를 성공적으로 조회함.                   |
| 401 UnAuthorized | 해당 리소스에 접근하기 위한 권한이 없음. (토큰 필요) |
| 404 Not Found    | 요청된 자원이 존재하지 않음.                    |

```
{
    "data": [
        {
            "email": "swj@gmail.com",
            "password": "1234321swj",
            "name": "Son",
            "age": "10",
            "gender": "MALE",
            "birthday": "2021-01-01",
            "nickname": "수박바"
        },
        {
            "email": "tttt@naver.com",
            "password": "4543342@ddd"
            "name": "Kim",
            "age": 44,
            "gender": "FEMALE",
            "birthday": "1985-01-20",
            "nickname": "바밤바"
        }
    ],
    "entityClassName": "Member",
    "msg": "모든 회원 조회에 성공하였습니다.",
    "success": true
}
```

</details>

<br />

#### 4. `/{id}` (GET)

id에 해당하는 회원 정보 한 건을 조회

<details open> <summary> /{id} (GET) 접기 / 펼치기 </summary>

##### Request

| Request Component | Value                      |
| ----------------- | -------------------------- |
| Name              | `/{id}`                    |
| Header            | `accept: application/json`<br /> `X-AUTH-TOKEN: TOKEN_VALUE` |
| Body              | N/A                        |
| Method            | GET                        |

##### Response

| Status Code      | Description                              |
| ---------------- | ---------------------------------------- |
| 200 OK           | 회원 정보를 성공적으로 조회함.                   |
| 401 UnAuthorized | 해당 리소스에 접근하기 위한 권한이 없음. (토큰 필요) |
| 404 Not Found    | 요청된 자원이 존재하지 않음.                    |

```
{
    "data": {
        "email": "swj@gmail.com",
        "password": "1234321swj",
        "name": "Son",
        "age": "10",
        "gender": "MALE",
        "birthday": "2021-01-01",
        "nickname": "수박바"
    },
    "entityClassName": "Member",
    "msg": "ID [1] 회원 정보 조회에 성공하였습니다.",
    "success": true
}
```

</details>

<br />

#### 5. `/{id}` (PUT)

id에 해당하는 회원 정보를 갱신 (이메일은 변경 불가)

<details open> <summary> /{id} (PUT) 접기 / 펼치기 </summary>

##### Request

<table>
<tr><th>Request Component</th><th>Value</th></tr>
<tr><td> Name</td><td><pre><code>/join</code></pre></td></tr>
<tr><td>Header </td><td><pre><code>accept: application/json</code><br /><code>X-AUTH-TOKEN: TOKEN_VALUE</code></pre> </td></tr>
<tr><td>Body</td><td><pre><code>
{
    "password": "dwnnsjdxdf",
    "name": "Son",
    "age": "22",
    "gender": "MALE",
    "birthday": "1990-10-01",
    "nickname": "스크류바"
}
</code></pre> </td></tr>
<tr><td>Method</td><td>PUT</td></tr>

##### Response

| Status Code      | Description                              |
| ---------------- | ---------------------------------------- |
| 200 OK           | 회원 정보를 성공적으로 갱신함.                   |
| 401 UnAuthorized | 해당 리소스에 접근하기 위한 권한이 없음. (토큰 필요) |
| 404 Not Found    | 요청된 자원이 존재하지 않음.                    |

</details>

<br />

#### 5. `/{id}` (DELETE)

id에 해당하는 회원 정보를 삭제

<details open> <summary> /{id} (DELETE) 접기 / 펼치기 </summary>

##### Request

| Request Component | Value                      |
| ----------------- | -------------------------- |
| Name              | `/list`                    |
| Header            | `accept: application/json`<br /> `X-AUTH-TOKEN: TOKEN_VALUE` |
| Body              | N/A                        |
| Method            | DELETE                     |

##### Response

| Status Code      | Description                              |
| ---------------- | ---------------------------------------- |
| 200 OK           | 회원 정보를 성공적으로 삭제함.                   |
| 401 UnAuthorized | 해당 리소스에 접근하기 위한 권한이 없음. (토큰 필요) |
| 404 Not Found    | 요청된 자원이 존재하지 않음.                    |

</details>

<br />

</details>








