# URL:/getSignature

---

code:200

**请求成功返回数据字段描述:**

| 返回字段 | 类型 | 示例值 | 描述 |
| --- | --- | :--- | :--- |
| jsapi_ticket | 字符串 | sM4AOVdWfPE4DxkXGEs8VCRoJVk67rr-iW2UdUZ0FlGeu8g_e--aERHgGizxWsqGpiGR2in53Y-ZzpnFRsiNrQ | 根据access_token从微信获取的ticket |
| noncestr | 字符串 | y8lv4oj9xq | 随机数 |
| signature | 字符串 | dd2e8f46dca97e0c60effa1ed3beba7fc5851b65 | 根据ticket等参数从微信获取的签名 |
| timestamp | 字符串 | 1582025626 | 时间戳 |
| url | 字符串 | http://mp.weixin.qq.com?params=value | 客户端传递的参数，返回给客户端 |


**请求成功返回的数据基本示例:**

```json
{
    "result": {
        "jsapi_ticket": "sM4AOVdWfPE4DxkXGEs8VCRoJVk67rr-iW2UdUZ0FlGeu8g_e--aERHgGizxWsqGpiGR2in53Y-ZzpnFRsiNrQ",
        "noncestr": "y8lv4oj9xq",
        "signature": "dd2e8f46dca97e0c60effa1ed3beba7fc5851b65",
        "timestamp": "1582025626",
        "url": "http://mp.weixin.qq.com?params=value"
    },
    "code": 200,
    "message": "success"
}
```

---

code:400

**请求失败返回的数据基本示例 :**

```json
    {
        "code": 400,
		"message": "Required parameter 'appId' is not present"
    }
	
	{
        "code": 400,
		"message": "Required parameter 'urlParam' is not present"
    }
	
	{
        "code": 400,
		"message": "getSignature.appId: Length exceeds the max limit 50"
    }
	
	{
        "code": 400,
		"message": "getSignature.urlParam: Length exceeds the max limit 200"
    }
```

---


code:500

**请求失败返回的数据基本示例 :**

```json
	
	{
        "code": 500,
		"message": "get appSecret error"
    }
	
	{
        "code": 500,
		"message": "get access_token from wechat error"
    }
	
	{
        "code": 500,
		"message": "get ticket from wechat error"
    }

    {
        "code": 500,
		"message": "compute signature error"
    }
	
	{
        "code": 500,
		"message": "system error"
    }
```

---




# URL:/v3/getSignature

---

code:200

**请求成功返回的数据**

*请求成功返回数据字段描述:*

| 返回字段 | 类型 | 示例值 | 描述 |
| --- | --- | :--- | :--- |
| jsapi_ticket | 字符串 | sM4AOVdWfPE4DxkXGEs8VCRoJVk67rr-iW2UdUZ0FlGeu8g_e--aERHgGizxWsqGpiGR2in53Y-ZzpnFRsiNrQ | 根据access_token从微信获取的ticket |
| noncestr | 字符串 | y8lv4oj9xq | 随机数 |
| signature | 字符串 | dd2e8f46dca97e0c60effa1ed3beba7fc5851b65 | 根据ticket等参数从微信获取的签名 |
| timestamp | 字符串 | 1582025626 | 时间戳 |
| url | 字符串 | http://mp.weixin.qq.com?params=value | 客户端传递的参数，返回给客户端 |

*请求成功返回的数据基本示例:*

```json
    {
    "result": {
        "jsapi_ticket": "sM4AOVdWfPE4DxkXGEs8VCRoJVk67rr-iW2UdUZ0FlGeu8g_e--aERHgGizxWsqGpiGR2in53Y-ZzpnFRsiNrQ",
        "noncestr": "y8lv4oj9xq",
        "signature": "dd2e8f46dca97e0c60effa1ed3beba7fc5851b65",
        "timestamp": "1582025626",
        "url": "http://mp.weixin.qq.com?params=value"
    },
    "code": 200,
    "message": "success"
}
```
---

code:400

**请求失败返回的数据:**

*请求失败返回的数据基本示例*

```json
    {
        "code": 400,
		"message": "Required parameter 'appId' is not present"
    }
	
	{
        "code": 400,
		"message": "Required parameter 'urlParam' is not present"
    }
	
	{
        "code": 400,
		"message": "getSignature.appId: Length exceeds the max limit 50"
    }
	
	{
        "code": 400,
		"message": "getSignature.urlParam: Length exceeds the max limit 200"
    }
	
```
---

code:500
**请求失败返回的数据:**

*请求失败返回的数据基本示例:*
```json
	{
        "code": 500,
		"message": "get appSecret error"
    }
	
	{
        "code": 500,
		"message": "get access_token from wechat error"
    }
	
	{
        "code": 500,
		"message": "get ticket from wechat error"
    }

    {
        "code": 500,
		"message": "compute signature error"
    }
	
	{
        "code": 500,
		"message": "system error"
    }
```
---


# URL:/speechToText

---

code:200
**请求成功返回的数据**

*请求成功返回的数据基本示例:*
```json
    {
		"code": 200,
		"message": "success",
        "result": {
            "text": "计价GBQ4怎么使用"
        }
    }
```
---

code:400
**请求失败返回的数据:**

*请求失败返回的数据基本示例:*

```json
  {
        "code": 400,
		"message": "Required parameter 'channel' is not present"
    }

	{
    	"code": 400,
    	"message": "file type not support, just support pcm,wav,amr,silk"
	}

	{
    	"code": 400,
    	"message": "speechToText.channel: value must be between 1 and 4"
	}
```

---


code:500
**请求失败返回的数据:**

*请求失败返回的数据基本示例:*

```json
    {
        "code": 500,
		"message": "java.lang.IndexOutOfBoundsException"
    }
```

---


# URL:/v3/speechToText

---

code:200
**请求成功返回的数据**

*请求成功返回的数据基本示例:*


```json
    {
		"code": 200,
		"message": "success",
        "result": {
            "text": "计价GBQ4怎么使用"
        }
    }
```
---

code:400
**请求失败返回的数据:**

*请求失败返回的数据基本示例:*


```json
    {
        "code": 400,
		"message": "Required parameter 'channel' is not present"
    }

	{
    	"code": 400,
    	"message": "file type not support, just support pcm,wav,amr,silk"
	}

	{
    	"code": 400,
    	"message": "speechToText.channel: value must be between 1 and 4"
	}
```
---

code:500
**请求失败返回的数据:**

*请求失败返回的数据基本示例:*
```json
    {
        "code": 500,
		"message": "java.lang.IndexOutOfBoundsException"
    }
```
---



# URL:/speechBlobToText


---

code:200

**请求成功返回的数据**

*请求成功返回的数据基本示例:*

```json
    {
		"code": 200,
		"message": "success",
        "result": {
            "text": "计价GBQ4怎么使用"
        }
    }
```
---

code:400
**请求失败返回的数据:**

*请求失败返回的数据基本示例:*
```json
    {
        "code": 400,
		"message": "Required parameter 'channel' is not present"
    }

	{
    	"code": 400,
    	"message": "file type not support, just support pcm,wav,amr,silk"
	}

	{
    	"code": 400,
    	"message": "speechToText.channel: value must be between 1 and 4"
	}

```
---

code:500
**请求失败返回的数据:**

*请求失败返回的数据基本示例:*
```json
    {
        "code": 500,
		"message": "java.lang.IndexOutOfBoundsException"
    }
```
---


# URL:/v3/speechBlobToText


---

code:200
**请求成功返回的数据**

*请求成功返回的数据基本示例:*
```json
    {
		"code": 200,
		"message": "success",
        "result": {
            "text": "计价GBQ4怎么使用"
        }
    }
```
---


code:400
**请求失败返回的数据:**

*请求失败返回的数据基本示例:*
```json
    {
        "code": 400,
		"message": "Required parameter 'channel' is not present"
    }

	{
    	"code": 400,
    	"message": "file type not support, just support pcm,wav,amr,silk"
	}

	{
    	"code": 400,
    	"message": "speechToText.channel: value must be between 1 and 4"
	}

```
---


code:500
**请求失败返回的数据:**

*请求失败返回的数据基本示例:*
```json
    {
        "code": 500,
		"message": "java.lang.IndexOutOfBoundsException"
    }
```
---


