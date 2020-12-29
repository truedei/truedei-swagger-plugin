# URL:/knowledgeFeedback

---

code:200

## 请求成功返回的数据

*请求成功正确返回的数据基本示例*

```json
    {
		"code": 200,
		"message": "success"
    }
```
---


code:400
## 请求失败返回的数据

*请求失败返回的数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)

```json
    {
        "code": 400,
		"message": "Required parameter 'chatid' is not present"
    }
```
---

code:500
## 请求失败返回的数据

*请求失败返回的数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)

```json
    {
        "code": 500,
		"message": "java.lang.IndexOutOfBoundsException"
    }
```
---


# URL:/v3/knowledgeFeedback

- 用户对答案点踩后进行原因反馈
- 相比V1，增加了从用户中心获取的accessToken的验证

---

code:200

## 请求成功返回的数据

*请求成功正确返回的数据基本示例*

```json
    {
		"code": 200,
		"message": "success"
    }
```
---


code:400
## 请求失败返回的数据

*请求失败返回的数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)

```json
    {
        "code": 400,
	"message": "Header parameter 'authorization' is invalid"
    }
	
	{
        "code": 400,
		"message": "Required parameter 'chatid' is not present"
    }
```
---

code:500
## 请求失败返回的数据

*请求失败返回的数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)

```json
    {
        "code": 500,
		"message": "java.lang.IndexOutOfBoundsException"
    }
```
---