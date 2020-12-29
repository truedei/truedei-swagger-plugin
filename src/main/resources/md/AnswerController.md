# URL:/questionTips

---

code:200
## 请求成功返回的数据

*请求成功返回字段描述*
<table>
    <thead>
        <tr><th>返回字段</th><th>类型</th><th style="text-align: left">示例值</th><th>描述</th></tr>
    </thead>
    <tbody>
        <tr><td> highlight </td><td> 字符串</td><td> 后缀为< span class=\"highlight\">GBQ4< /span>/ <br/> GZB4的文件要怎么打开？ </td><td>智能提示的问题，其中匹配的部分被高亮设置 </td></tr>
        <tr><td> question </td><td>字符串 </td><td>后缀为GBQ4/GZB4的文件要怎么打开？ </td><td> 智能提示的问题  </td></tr>
        <tr><td> type </td><td> 整型  </td><td> 2 </td><td> 当前问题的类型 ：<br/> -  0为常规问题 <br/>  -  1为人工问题 <br/> -  2为流程问题   <br/> -  3为表格问题 </td></tr>
        <tr><td> qid </td><td> 整型  </td><td> 133256 </td><td> 当前问题的唯一标识  </td></tr>
    </tbody>
</table>

*请求成功返回的数据基本示例*

```json
{
    "code": 200,
    "message": "success",
    "result": {
        "tips": [
            {
                "highlight": "后缀为<span class=\"highlight\">GBQ4</span>/GZB4/GTB4/GBG9/GPB9的文件要怎么打开？",
                "question": "后缀为GBQ4/GZB4/GTB4/GBG9/GPB9的文件要怎么打开？",                 
                "type": 2,                   
                "qid": 205534
                
            },
            {
                "highlight": "后缀为<span class=\"highlight\">GBQ4</span>/GZB4/GTB4/GBG9/GPB9的文件要怎么打开？",
                "question": "后缀为GBQ4/GZB4/GTB4/GBG9/GPB9的文件要怎么打开？",                 
                "type": 0,                   
                "qid": 205534
            }
        ]
    }
}
```

---


code:400
## 请求失败返回的数据

*请求失败返回的数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)


```json
    {
        "code": 400,
	"message": "Required parameter 'question' is not present"
    }

    {
    	"code": 400,
    	"message": "questionTips.robot: value must be get from server"
    }

    {
    	"code": 400,
    	"message": "questionTips.question: Length exceeds the max value [500]"
    }
```

---

code:500
## 请求失败返回的数据

*请求失败返回的数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)


```json
    {
        "code": 500,
	"message": "java.lang.ClassCastException"
    }
```

---


# URL:/v3/questionTips
用户输入问题时，实时获取智能提示的相关问题，包括：
<br/> - 常规问题
<br/> - 流程问题
<br/> - 表格问题
<br/> - 任务问答
- 相比V1，增加了从用户中心获取的accessToken的验证

---

code:200
## 请求成功返回的数据

*请求成功返回字段描述*
<escape>
<table>
    <thead>
        <tr><th>返回字段</th><th>类型</th><th style="text-align: left">示例值</th><th>描述</th></tr>
    </thead>
    <tbody>
        <tr><td> highlight </td><td> 字符串</td><td> 后缀为< span class=\"highlight\">GBQ4< /span>/ <br/> GZB4的文件要怎么打开？ </td><td>智能提示的问题，其中匹配的部分被高亮设置 </td></tr>
        <tr><td> question </td><td>字符串 </td><td>后缀为GBQ4/GZB4的文件要怎么打开？ </td><td> 智能提示的问题  </td></tr>
        <tr><td> type </td><td> 整型  </td><td> 2 </td><td> 当前问题的类型 ：<br/> -  0为常规问题 <br/>  -  1为人工问题 <br/> -  2为流程问题   <br/> -  3为表格问题 </td></tr>
        <tr><td> qid </td><td> 整型  </td><td> 133256 </td><td> 当前问题的唯一标识  </td></tr>
    </tbody>
</table>
</escape>

*请求成功返回的数据基本示例*

```json
{
    "code": 200,
    "message": "success",
    "result": {
        "tips": [
            {
                "highlight": "后缀为<span class=\"highlight\">GBQ4</span>/GZB4/GTB4/GBG9/GPB9的文件要怎么打开？",
                "question": "后缀为GBQ4/GZB4/GTB4/GBG9/GPB9的文件要怎么打开？",                 
                "type": 2,                   
                "qid": 205534
                
            },
            {
                "highlight": "后缀为<span class=\"highlight\">GBQ4</span>/GZB4/GTB4/GBG9/GPB9的文件要怎么打开？",
                "question": "后缀为GBQ4/GZB4/GTB4/GBG9/GPB9的文件要怎么打开？",                 
                "type": 0,                   
                "qid": 205534
            }
        ]
    }
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
	"message": "Required parameter 'question' is not present"
    }

    {
    	"code": 400,
    	"message": "questionTips.robot: value must be get from server"
    }

    {
    	"code": 400,
    	"message": "questionTips.question: Length exceeds the max value [500]"
    }
```

---

code:500
## 请求失败返回的数据

*请求失败返回的数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)


```json
    {
        "code": 500,
	"message": "java.lang.ClassCastException"
    }
```

---




# URL:/matchedResult

---

code:200
## 请求成功返回的数据

*请求成功返回数据字段描述*

<escape>
<table>
    <thead>
        <tr><th>返回字段</th><th>类型</th><th style="text-align: left">示例值</th><th>描述</th></tr>
    </thead>
    <tbody>
        <tr><td>answer</td><td>字符串</td><td> 因为GBQ4.0软件在分部分项界面点的重用组价，只会自动复制过来分部分项的项 </td><td> 返回的答案 </td></tr>
        <tr><td>hideUpDown</td><td>布尔型</td><td> false </td><td> 用于前端显示或隐藏点踩点赞页签 </td></tr>
        <tr><td>cid</td><td>字符串</td><td> 2e604f02-29c5-4843-affd-533e0e497ee8 </td><td> 单条会话的唯一标识</td></tr>
        <tr><td>initialQuestion</td><td>字符串</td><td> 计价GBQ4如何下载 </td><td>初始问题，用于问题学习 </td></tr>
        <tr><td>isProfessional</td><td>整型</td><td> 0 </td><td> 1为非专业问题，0为专业问题 </td></tr>
        <tr><td>resultType</td><td>整型</td><td> 5 </td><td> 返回的数据结构类型,据此做不同的显示处理, <br/> <span style="color:red">目前用于PC端埋点</span> ：<br/>  -  0为引导问题 <br/>  -  1为直推 <br/>  -  2为引导后点击 <br/>  -  3为未回答上<br/> - 4为智能提示<br/>  -  5为闲聊   <br/> -  6为人工问题   <br/> -  7为直推下挂点击   <br/> -  8为表格问题 </td></tr>
        <tr>
            <td>directQue</td>
            <td>对象</td>
            <td>
                <table>
                    <thead><tr><td>返回字段</td><td>类型</td><td style="text-align: left">示例值</td><td>描述</td></tr></thead>
                    <tbody>
                        <tr><td>question</td><td>字符串</td><td> 缀为GBQ4/GZB4/GTB4/GBG9/GPB9的文件要怎么打开 </td><td> 问题 </td></tr>
                        <tr><td>htmlAnswer</td><td>字符串</td><td> 首先打开软件，然后点击就可以了 </td><td> 答案 </td></tr>
                        <tr><td>qid</td><td>整型</td><td> 133256 </td><td> 当前问题的唯一标识 </td></tr>
                        <tr><td>type</td><td>整型 </td><td> 2 </td><td> 当前问题的类型 ：<br/>  -  0为常规问题 <br/> -  1为人工问题 <br/> -  2为流程问题   <br/>  -  3为表格问题</td></tr>
                    </tbody>
                </table>
            </td>
            <td>直推的数据,包含问题、答案、类型等相关信息</td>
        </tr>
        <tr>
            <td>flowItem</td>
            <td>对象</td>
            <td>
                <table>
                    <thead><tr><td>返回字段</td><td>类型</td><td style="text-align: left">示例值</td><td>描述</td></tr></thead>
                    <tbody>
                        <tr><td>id</td><td>整型</td><td>558</td><td>流程项id, <br/>用于获取下一个流程项</td></tr>
                        <tr><td>isFirstItem</td><td>布尔型</td><td>true</td><td>标识是不是第一个流程项,<br/>用于控制是否显示标问<br/>(只有第一个流程项的话才显示标问)<br/>- true: 是第一个流程项 <br/> - false: 不是第一个流程项</td></tr>
                        <tr><td>flowName</td><td>字符串</td><td>第一步</td><td>流程项名称</td></tr>
                        <tr><td>flowContent</td><td>字符串</td><td><p>安装GBQ4</p></td><td>流程项内容</td></tr>
                        <tr><td>linkContent</td><td>字符串</td><td>下一步</td><td>下一个流程项的链接入口,<br/> 点击能够展示出下一个流程项</td></tr>
                    </tbody>
                </table>
            </td>
            <td> 流程问题的流程项（type=2） <br/> - 如果不是一个流程问题, 不返回该结构</td>
        </tr>
         <tr>
            <td>similarQue <br/> 或 <br/> anotherQue</td>
            <td>对象</td>
            <td>
                <table>
                    <thead><tr><td>返回字段</td><td>类型</td><td style="text-align: left">示例值</td><td>描述</td></tr></thead>
                    <tbody>
				        <tr><td>qid</td><td>整型</td><td> 133256 </td><td> 当前问题的唯一标识 </td></tr>
				        <tr><td>type</td><td>整型 </td><td> 2 </td><td> 当前问题的类型 ：<br/>  -  0为常规问题 <br/> -  1为人工问题 <br/> -  2为流程问题   <br/>  -  3为表格问题</td></tr>
        				<tr><td>question</td><td>字符串</td><td> 缀为GBQ4文件要怎么打开 </td><td> 问题 </td></tr>
                    </tbody>
                </table>
            </td>
            <td> 当前问题的相似问题列表<br/> (其他字段后台使用，无需关注) </td>
        </tr>
    </tbody>
</table>
</escape>

*请求成功返回的数据基本示例----直推下挂*	算法推出一条答案, 并返回三条相似的问题

```json
{
	"code": 200,
	"message": "success",
	"result": {
		"similarQue": [{
			"question": "计价GBQ4.0重用组价，查询历史工程，全选自动复制组价为什么措施项目组价没有一起匹配过来？",
			"levelId": "5",
			"type": 0,
			"qid": "262189"
		}, {
			"question": "计价GBQ4.0如何返回项目管理界面？",
			"levelId": "5",
			"type": 0,
			"qid": "260847"
		}],
		"directQue": {
			"htmlAnswer": "<p>计价软件载入XML组价后，部分单位工程组价没有匹配进去是因为工程招标清单里面的部分单位工程清单编码和招标方给的招标控制价里面的清单编码不匹配。</p>",
			"question": "计价GBQ4.0项目管理界面载入XML组价后，部分单位工程组价并没有匹配进去",
			"type": 2,
			"qid": "262100",
			"flowItem": {//只有type=2才有
				"flowContent": "<p>测试1  </p>",
				"id": 483,
				"flowName": "测试1",
				"linkContent": "测试1",
				"isFirstItem": true
			}
		},			
		"answer": "<p>计价软件载入组价</p>",
		"isProfessional": 0,
		"hideUpDown": false,
		"resultType": 1,
		"initialQuestion": "计价GBQ4.0项目管理界面载入XML组价后，部分单位工程组价并没有匹配进去",
		"cid": "aec5c6a6-f269-4f61-b19f-81759c49692a"
	}
}

```

*请求成功返回的数据基本示例---换一批提示/分页* 算法没有找到正确答案, 返回五条提示的问题

```json
{
	"code": 200,
	"message": "success",
	"result": {
		"anotherQue": [{
			"question": "计价GBQ4.0如何找回历史工程？",
			"levelId": "5",
			"type": 0,
			"qid": "260690"
		}, {
			"question": "计价GBQ4.0软件安装之后不显示图标/显示白色/没有生成Bin文件夹怎么处理？",
			"levelId": "5",
			"type": 0,
			"qid": "262034"
		}, {
			"question": "计价GBQ4.0软件没有锁如何查看工程的数据？",
			"levelId": "5",
			"type": 0,
			"qid": "262043"
		}, {
			"question": "计价GBQ4.0如何生成招标书/投标书？",
			"levelId": "5",
			"type": 0,
			"qid": "260762"
		}, {
			"question": "计价GBQ4.0如何将投标文件或者招标文件转换为预算文件？",
			"levelId": "5",
			"type": 0,
			"qid": "260641"
		}],
		"isProfessional": 0,
		"hideUpDown": false,
		"resultType": 0,
		"initialQuestion": "GBQ",
		"cid": "eba7d442-5813-48fa-b13e-d13c2aa89a4f"
	},
	"pageCount": 3,
	"pageNumber": 1,
	"recordCount": 15,
	"pageSize": 5
}
```


*请求成功返回的数据基本示例---人工监管* 当前会话被人工监管了, pc端使用, h5/公众号/小程序暂时不用关注

```json
    {
      "code": 200,
	  "message": "success",
	  "result": {
            "peerChatid": "weizp-a_1554342532589",
	    "isDeal": 1
        } 
    }
```
---

code:400


## 请求失败返回的数据

*请求失败返回数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)



```json
    {
        "code": 400,
	"message": "Required parameter 'chatid' is not present"
    }
	
    {
    	"code": 400,
    	"message": "matchedResult.question: Length exceeds the max value [500]"
    }
```
---

code:500

## 请求失败返回的数据

*请求失败返回数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)

```json
    {
        "code": 500,
	"message": "java.lang.ClassCastException"
    }
```
---






# URL:/v2/matchedResult

<br/> - 输入问题后点击发送或者直接回车进行提问，经过算法引擎，获得问题的答案。
<br/> - 相比V1，新增表格知识问答（简单多轮对话）

---

code:200
## 请求成功返回的数据

*请求成功返回数据字段描述*

<escape>
<table>
    <thead>
        <tr><th>返回字段</th><th>类型</th><th style="text-align: left">示例值</th><th>描述</th></tr>
    </thead>
    <tbody>
        <tr><td>answer</td><td>字符串</td><td> 因为GBQ4.0软件在分部分项界面点的重用组价，只会自动复制过来分部分项的项 </td><td> 返回的答案 </td></tr>
        <tr><td>hideUpDown</td><td>布尔型</td><td> false </td><td> 用于前端显示或隐藏点踩点赞页签 </td></tr>
        <tr><td>cid</td><td>字符串</td><td> 2e604f02-29c5-4843-affd-533e0e497ee8 </td><td> 单条会话的唯一标识</td></tr>
        <tr><td>initialQuestion</td><td>字符串</td><td> 计价GBQ4如何下载 </td><td>初始问题，用于问题学习 </td></tr>
        <tr><td>isProfessional</td><td>整型</td><td> 0 </td><td> 1为非专业问题，0为专业问题 </td></tr>
        <tr><td>routing</td><td>字符串</td><td> nlu </td><td> nlu/faq，用于后台区分调用的算法引擎 </td></tr>
        <tr><td>slotVecsState</td><td>字符串</td><td> None </td><td> 算法引擎使用  </td></tr>
        <tr><td>slotsContent</td><td>字符串</td><td> None </td><td> 算法引擎使用  </td></tr>
        <tr><td>slotsQueryTimes</td><td>字符串</td><td> None </td><td> 算法引擎使用  </td></tr>
        <tr><td>resultType</td><td>整型</td><td> 5 </td><td> 返回的数据结构类型,据此做不同的显示处理, <br/> <span style="color:red">目前用于PC端埋点</span> ：<br/>  -  0为引导问题 <br/>  -  1为直推 <br/>  -  2为引导后点击 <br/>  -  3为未回答上<br/> - 4为智能提示<br/>  -  5为闲聊   <br/> -  6为人工问题   <br/> -  7为直推下挂点击   <br/> -  8为表格问题 </td></tr>
        <tr>
            <td>directQue</td>
            <td>对象</td>
            <td>
                <table>
                    <thead><tr><td>返回字段</td><td>类型</td><td style="text-align: left">示例值</td><td>描述</td></tr></thead>
                    <tbody>
                        <tr><td>question</td><td>字符串</td><td> 缀为GBQ4/GZB4/GTB4/GBG9/GPB9的文件要怎么打开 </td><td> 问题 </td></tr>
                        <tr><td>htmlAnswer</td><td>字符串</td><td> 首先打开软件，然后点击就可以了 </td><td> 答案 </td></tr>
                        <tr><td>qid</td><td>整型</td><td> 133256 </td><td> 当前问题的唯一标识 </td></tr>
                        <tr><td>type</td><td>整型 </td><td> 2 </td><td> 当前问题的类型 ：<br/>  -  0为常规问题 <br/> -  1为人工问题 <br/> -  2为流程问题   <br/>  -  3为表格问题</td></tr>
                    </tbody>
                </table>
            </td>
            <td>直推的数据(包括常规问题和表格问题),包含问题、答案、类型等相关信息</td>
        </tr>
        <tr>
            <td>flowItem</td>
            <td>对象</td>
            <td>
                <table>
                    <thead><tr><td>返回字段</td><td>类型</td><td style="text-align: left">示例值</td><td>描述</td></tr></thead>
                    <tbody>
                        <tr><td>id</td><td>整型</td><td>558</td><td>流程项id, <br/>用于获取下一个流程项</td></tr>
                        <tr><td>isFirstItem</td><td>布尔型</td><td>true</td><td>标识是不是第一个流程项,<br/>用于控制是否显示标问<br/>(只有第一个流程项的话才显示标问)<br/>- true: 是第一个流程项 <br/> - false: 不是第一个流程项</td></tr>
                        <tr><td>flowName</td><td>字符串</td><td>第一步</td><td>流程项名称</td></tr>
                        <tr><td>flowContent</td><td>字符串</td><td><p>安装GBQ4</p></td><td>流程项内容</td></tr>
                        <tr><td>linkContent</td><td>字符串</td><td>下一步</td><td>下一个流程项的链接入口,<br/> 点击能够展示出下一个流程项</td></tr>
                    </tbody>
                </table>
            </td>
            <td> 流程问题的流程项（type=2） <br/> - 如果不是一个流程问题, 不返回该结构</td>
        </tr>
         <tr>
            <td>similarQue <br/> 或 <br/> anotherQue</td>
            <td>对象</td>
            <td>
                <table>
                    <thead><tr><td>返回字段</td><td>类型</td><td style="text-align: left">示例值</td><td>描述</td></tr></thead>
                    <tbody>
				        <tr><td>qid</td><td>整型</td><td> 133256 </td><td> 当前问题的唯一标识 </td></tr>
				        <tr><td>type</td><td>整型 </td><td> 2 </td><td> 当前问题的类型 ：<br/>  -  0为常规问题 <br/> -  1为人工问题 <br/> -  2为流程问题   <br/>  -  3为表格问题</td></tr>
        				<tr><td>question</td><td>字符串</td><td> 缀为GBQ4文件要怎么打开 </td><td> 问题 </td></tr>
                    </tbody>
                </table>
            </td>
            <td> 当前问题的相似问题列表<br/> (其他字段后台使用，无需关注) </td>
        </tr>
    </tbody>
</table>
</escape>

*请求成功返回的数据基本示例----直推下挂*	算法推出一条答案, 并返回三条相似的问题

```json
{
	"code": 200,
	"message": "success",
	"result": {
		"similarQue": [{
			"question": "计价GBQ4.0重用组价，查询历史工程，全选自动复制组价为什么措施项目组价没有一起匹配过来？",
			"levelId": "5",
			"type": 0,
			"qid": "262189"
		}, {
			"question": "计价GBQ4.0如何返回项目管理界面？",
			"levelId": "5",
			"type": 0,
			"qid": "260847"
		}],
		"directQue": {
			"htmlAnswer": "<p>计价软件载入XML组价后，部分单位工程组价没有匹配进去是因为工程招标清单里面的部分单位工程清单编码和招标方给的招标控制价里面的清单编码不匹配。</p>",
			"question": "计价GBQ4.0项目管理界面载入XML组价后，部分单位工程组价并没有匹配进去",
			"type": 2,
			"qid": "262100",
			"flowItem": {//只有type=2才有
				"flowContent": "<p>测试1  </p>",
				"id": 483,
				"flowName": "测试1",
				"linkContent": "测试1",
				"isFirstItem": true
			}
		},
		"routing": "faq",
		"slotVecsState": "None",
		"slotsContent": "None",
		"slotsQueryTimes": "None",			
		"answer": "<p>计价软件载入组价</p>",
		"isProfessional": 0,
		"hideUpDown": false,
		"resultType": 1,
		"initialQuestion": "计价GBQ4.0项目管理界面载入XML组价后，部分单位工程组价并没有匹配进去",
		"cid": "aec5c6a6-f269-4f61-b19f-81759c49692a"
	}
}


```

*请求成功返回的数据基本示例---换一批提示/分页* 算法没有找到正确答案, 返回五条提示的问题

```json
{
	"code": 200,
	"message": "success",
	"result": {
		"anotherQue": [{
			"question": "计价GBQ4.0如何找回历史工程？",
			"levelId": "5",
			"type": 0,
			"qid": "260690"
		}, {
			"question": "计价GBQ4.0软件安装之后不显示图标/显示白色/没有生成Bin文件夹怎么处理？",
			"levelId": "5",
			"type": 0,
			"qid": "262034"
		}, {
			"question": "计价GBQ4.0软件没有锁如何查看工程的数据？",
			"levelId": "5",
			"type": 0,
			"qid": "262043"
		}, {
			"question": "计价GBQ4.0如何生成招标书/投标书？",
			"levelId": "5",
			"type": 0,
			"qid": "260762"
		}, {
			"question": "计价GBQ4.0如何将投标文件或者招标文件转换为预算文件？",
			"levelId": "5",
			"type": 0,
			"qid": "260641"
		}],
		"routing": "faq",
		"slotVecsState": "None",
		"slotsContent": "None",
		"slotsQueryTimes": "None",
		"isProfessional": 0,
		"hideUpDown": false,
		"resultType": 0,
		"initialQuestion": "GBQ",
		"cid": "eba7d442-5813-48fa-b13e-d13c2aa89a4f"
	},
	"pageCount": 3,
	"pageNumber": 1,
	"recordCount": 15,
	"pageSize": 5
}
```


*请求成功返回的数据基本示例----表格问题*	算法推出一条表格问题答案

```json

{
	"code": 200,
	"message": "success",
	"result": {
		"directQue": {
			"htmlAnswer": "<p>计价软件载入XML组价后，部分单位工程组价没有匹配进去是因为工程招标清单里面的部分单位工程清单编码和招标方给的招标控制价里面的清单编码不匹配。</p>",
			"question": "计价GBQ4.0项目管理界面载入XML组价后，部分单位工程组价并没有匹配进去",
			"type": 3,
			"qid": "262100"
		},
		"routing": "nlu",
		"slotVecsState": "None",
		"slotsContent": "None",
		"slotsQueryTimes": "None",			
		"answer": "<p>计价软件载入组价</p>",
		"isProfessional": 0,
		"hideUpDown": false,
		"resultType": 1,
		"initialQuestion": "计价GBQ4.0项目管理界面载入XML组价后，部分单位工程组价并没有匹配进去",
		"cid": "aec5c6a6-f269-4f61-b19f-81759c49692a"
	}
}

```

*请求成功返回的数据基本示例---人工监管* 当前会话被人工监管了, pc端使用, h5/公众号/小程序暂时不用关注

```json
    {
      "code": 200,
	  "message": "success",
	  "result": {
            "peerChatid": "weizp-a_1554342532589",
	    "isDeal": 1
        } 
    }
```

---

code:400


## 请求失败返回的数据

*请求失败返回数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)



```json
    {
        "code": 400,
	"message": "Required parameter 'chatid' is not present"
    }
    
    {
    	"code": 400,
    	"message": "v2matchedResult.routing: 'xx' is invalid routing.valid routing must be in ('faq','nlu')"
    }
	
    {
    	"code": 400,
    	"message": "v2matchedResult.question: Length exceeds the max value [500]"
    }
```
---

code:500

## 请求失败返回的数据

*请求失败返回数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)

```json
    {
        "code": 500,
	"message": "java.lang.ClassCastException"
    }
```
---





# URL:/v3/matchedResult

<br/> - 相比V2，增加了从用户中心获取的accessToken的验证

---

code:200
## 请求成功返回的数据

*请求成功返回数据字段描述*

<escape>
<table>
    <thead>
        <tr><th>返回字段</th><th>类型</th><th style="text-align: left">示例值</th><th>描述</th></tr>
    </thead>
    <tbody>
        <tr><td>answer</td><td>字符串</td><td> 因为GBQ4.0软件在分部分项界面点的重用组价，只会自动复制过来分部分项的项 </td><td> 返回的答案 </td></tr>
        <tr><td>hideUpDown</td><td>布尔型</td><td> false </td><td> 用于前端显示或隐藏点踩点赞页签 </td></tr>
        <tr><td>cid</td><td>字符串</td><td> 2e604f02-29c5-4843-affd-533e0e497ee8 </td><td> 单条会话的唯一标识</td></tr>
        <tr><td>initialQuestion</td><td>字符串</td><td> 计价GBQ4如何下载 </td><td>初始问题，用于问题学习 </td></tr>
        <tr><td>isProfessional</td><td>整型</td><td> 0 </td><td> 1为非专业问题，0为专业问题 </td></tr>
        <tr><td>routing</td><td>字符串</td><td> nlu </td><td> nlu/faq，用于后台区分调用的算法引擎 </td></tr>
        <tr><td>slotVecsState</td><td>字符串</td><td> None </td><td> 算法引擎使用  </td></tr>
        <tr><td>slotsContent</td><td>字符串</td><td> None </td><td> 算法引擎使用  </td></tr>
        <tr><td>slotsQueryTimes</td><td>字符串</td><td> None </td><td> 算法引擎使用  </td></tr>
        <tr><td>resultType</td><td>整型</td><td> 5 </td><td> 返回的数据结构类型,据此做不同的显示处理, <br/> <span style="color:red">目前用于PC端埋点</span> ：<br/>  -  0为引导问题 <br/>  -  1为直推 <br/>  -  2为引导后点击 <br/>  -  3为未回答上<br/> - 4为智能提示<br/>  -  5为闲聊   <br/> -  6为人工问题   <br/> -  7为直推下挂点击   <br/> -  8为表格问题 </td></tr>
        <tr>
            <td>directQue</td>
            <td>对象</td>
            <td>
                <table>
                    <thead><tr><td>返回字段</td><td>类型</td><td style="text-align: left">示例值</td><td>描述</td></tr></thead>
                    <tbody>
                        <tr><td>question</td><td>字符串</td><td> 缀为GBQ4/GZB4/GTB4/GBG9/GPB9的文件要怎么打开 </td><td> 问题 </td></tr>
                        <tr><td>htmlAnswer</td><td>字符串</td><td> 首先打开软件，然后点击就可以了 </td><td> 答案 </td></tr>
                        <tr><td>qid</td><td>整型</td><td> 133256 </td><td> 当前问题的唯一标识 </td></tr>
                        <tr><td>type</td><td>整型 </td><td> 2 </td><td> 当前问题的类型 ：<br/>  -  0为常规问题 <br/> -  1为人工问题 <br/> -  2为流程问题   <br/>  -  3为表格问题</td></tr>
                    </tbody>
                </table>
            </td>
            <td>直推的数据(包括常规问题和表格问题),包含问题、答案、类型等相关信息</td>
        </tr>
        <tr>
            <td>flowItem</td>
            <td>对象</td>
            <td>
                <table>
                    <thead><tr><td>返回字段</td><td>类型</td><td style="text-align: left">示例值</td><td>描述</td></tr></thead>
                    <tbody>
                        <tr><td>id</td><td>整型</td><td>558</td><td>流程项id, <br/>用于获取下一个流程项</td></tr>
                        <tr><td>isFirstItem</td><td>布尔型</td><td>true</td><td>标识是不是第一个流程项,<br/>用于控制是否显示标问<br/>(只有第一个流程项的话才显示标问)<br/>- true: 是第一个流程项 <br/> - false: 不是第一个流程项</td></tr>
                        <tr><td>flowName</td><td>字符串</td><td>第一步</td><td>流程项名称</td></tr>
                        <tr><td>flowContent</td><td>字符串</td><td><p>安装GBQ4</p></td><td>流程项内容</td></tr>
                        <tr><td>linkContent</td><td>字符串</td><td>下一步</td><td>下一个流程项的链接入口,<br/> 点击能够展示出下一个流程项</td></tr>
                    </tbody>
                </table>
            </td>
            <td> 流程问题的流程项（type=2） <br/> - 如果不是一个流程问题, 不返回该结构</td>
        </tr>
         <tr>
            <td>similarQue <br/> 或 <br/> anotherQue</td>
            <td>对象</td>
            <td>
                <table>
                    <thead><tr><td>返回字段</td><td>类型</td><td style="text-align: left">示例值</td><td>描述</td></tr></thead>
                    <tbody>
				        <tr><td>qid</td><td>整型</td><td> 133256 </td><td> 当前问题的唯一标识 </td></tr>
				        <tr><td>type</td><td>整型 </td><td> 2 </td><td> 当前问题的类型 ：<br/>  -  0为常规问题 <br/> -  1为人工问题 <br/> -  2为流程问题   <br/>  -  3为表格问题</td></tr>
        				<tr><td>question</td><td>字符串</td><td> 缀为GBQ4文件要怎么打开 </td><td> 问题 </td></tr>
                    </tbody>
                </table>
            </td>
            <td> 当前问题的相似问题列表<br/> (其他字段后台使用，无需关注) </td>
        </tr>
    </tbody>
</table>
</escape>

*请求成功返回的数据基本示例----直推下挂*	算法推出一条答案, 并返回三条相似的问题

```json
{
	"code": 200,
	"message": "success",
	"result": {
		"similarQue": [{
			"question": "计价GBQ4.0重用组价，查询历史工程，全选自动复制组价为什么措施项目组价没有一起匹配过来？",
			"levelId": "5",
			"type": 0,
			"qid": "262189"
		}, {
			"question": "计价GBQ4.0如何返回项目管理界面？",
			"levelId": "5",
			"type": 0,
			"qid": "260847"
		}],
		"directQue": {
			"htmlAnswer": "<p>计价软件载入XML组价后，部分单位工程组价没有匹配进去是因为工程招标清单里面的部分单位工程清单编码和招标方给的招标控制价里面的清单编码不匹配。</p>",
			"question": "计价GBQ4.0项目管理界面载入XML组价后，部分单位工程组价并没有匹配进去",
			"type": 2,
			"qid": "262100",
			"flowItem": {//只有type=2才有
				"flowContent": "<p>测试1  </p>",
				"id": 483,
				"flowName": "测试1",
				"linkContent": "测试1",
				"isFirstItem": true
			}
		},
		"routing": "faq",
		"slotVecsState": "None",
		"slotsContent": "None",
		"slotsQueryTimes": "None",			
		"answer": "<p>计价软件载入组价</p>",
		"isProfessional": 0,
		"hideUpDown": false,
		"resultType": 1,
		"initialQuestion": "计价GBQ4.0项目管理界面载入XML组价后，部分单位工程组价并没有匹配进去",
		"cid": "aec5c6a6-f269-4f61-b19f-81759c49692a"
	}
}

```

*请求成功返回的数据基本示例---换一批提示/分页* 算法没有找到正确答案, 返回五条提示的问题

```json
{
	"code": 200,
	"message": "success",
	"result": {
		"anotherQue": [{
			"question": "计价GBQ4.0如何找回历史工程？",
			"levelId": "5",
			"type": 0,
			"qid": "260690"
		}, {
			"question": "计价GBQ4.0软件安装之后不显示图标/显示白色/没有生成Bin文件夹怎么处理？",
			"levelId": "5",
			"type": 0,
			"qid": "262034"
		}, {
			"question": "计价GBQ4.0软件没有锁如何查看工程的数据？",
			"levelId": "5",
			"type": 0,
			"qid": "262043"
		}, {
			"question": "计价GBQ4.0如何生成招标书/投标书？",
			"levelId": "5",
			"type": 0,
			"qid": "260762"
		}, {
			"question": "计价GBQ4.0如何将投标文件或者招标文件转换为预算文件？",
			"levelId": "5",
			"type": 0,
			"qid": "260641"
		}],
		"routing": "faq",
		"slotVecsState": "None",
		"slotsContent": "None",
		"slotsQueryTimes": "None",
		"isProfessional": 0,
		"hideUpDown": false,
		"resultType": 0,
		"initialQuestion": "GBQ",
		"cid": "eba7d442-5813-48fa-b13e-d13c2aa89a4f"
	},
	"pageCount": 3,
	"pageNumber": 1,
	"recordCount": 15,
	"pageSize": 5
}
```


*请求成功返回的数据基本示例----表格问题*	算法推出一条表格问题答案

```json

{
	"code": 200,
	"message": "success",
	"result": {
		"directQue": {
			"htmlAnswer": "<p>计价软件载入XML组价后，部分单位工程组价没有匹配进去是因为工程招标清单里面的部分单位工程清单编码和招标方给的招标控制价里面的清单编码不匹配。</p>",
			"question": "计价GBQ4.0项目管理界面载入XML组价后，部分单位工程组价并没有匹配进去",
			"type": 3,
			"qid": "262100"
		},
		"routing": "nlu",
		"slotVecsState": "None",
		"slotsContent": "None",
		"slotsQueryTimes": "None",			
		"answer": "<p>计价软件载入组价</p>",
		"isProfessional": 0,
		"hideUpDown": false,
		"resultType": 1,
		"initialQuestion": "计价GBQ4.0项目管理界面载入XML组价后，部分单位工程组价并没有匹配进去",
		"cid": "aec5c6a6-f269-4f61-b19f-81759c49692a"
	}
}


```

*请求成功返回的数据基本示例---人工监管* 当前会话被人工监管了, pc端使用, h5/公众号/小程序暂时不用关注

```json
    {
      "code": 200,
	  "message": "success",
	  "result": {
            "peerChatid": "weizp-a_1554342532589",
	    "isDeal": 1
        } 
    }
```

---

code:400


## 请求失败返回的数据

*请求失败返回数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)



```json
    {
        "code": 400,
	"message": "Header parameter 'authorization' is invalid"
    }
	
	{
        "code": 400,
	"message": "Header parameter 'openid' is invalid"
    }
	
    {
        "code": 400,
	"message": "Required parameter 'chatid' is not present"
    }
    
    {
    	"code": 400,
    	"message": "v2matchedResult.routing: 'xx' is invalid routing.valid routing must be in ('faq','nlu')"
    }
	
    {
    	"code": 400,
    	"message": "v2matchedResult.question: Length exceeds the max value [500]"
    }
```
---

code:500

## 请求失败返回的数据

*请求失败返回数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)

```json
    {
        "code": 500,
	"message": "java.lang.ClassCastException"
    }
```
---


# URL:/answer

*初始问题（用于知识学习）, 仅在以下两种情况传该参数，获取方式见下图*

| 场景1-1:点击直推下引导的问题|  | 场景1-2:点击换一批引导的问题 |
| :--- | :--- |:--- |
| <img src="https://openai-pre.glodon.com/docs/api/robotAppOpenApi/img/initQue2.png" width = "500" height = "400" alt="图片名称" align=center />  |  | <img src="https://openai-pre.glodon.com/docs/api/robotAppOpenApi/img/initQue4.png" width = "500" height = "400" alt="图片名称" align=center />  |

<a name="getAns"></a>

---

code:200

## 请求成功返回的数据

*请求成功返回字段描述*

<escape>
<table>
    <thead>
        <tr><th>返回字段</th><th>类型</th><th style="text-align: left">示例值</th><th>描述</th></tr>
    </thead>
    <tbody>
    	<tr><td>cid</td><td>字符串</td><td> 2e604f02-29c5-4843-affd-533e0e497ee8 </td><td> 单条会话的唯一标识</td></tr>
        <tr><td>htmlAnswer</td><td>字符串</td><td> 首先打开软件，然后点击就可以了 </td><td> 问题的答案(如果是流程问题, 不返回该字段，返回flowItem) </td></tr>  
        <tr><td>initialQuestion</td><td>字符串</td><td> 计价GBQ4如何下载 </td><td>初始问题，用于问题学习 </td></tr>
        <tr><td>routing</td><td>字符串</td><td> nlu </td><td> nlu/faq，用于后台区分调用的算法引擎 </td></tr>
        <tr><td>qid</td><td>整型</td><td> 133256 </td><td> 当前问题的唯一标识 </td></tr>
        <tr><td>slotVecsState</td><td>字符串</td><td> None </td><td> 算法引擎使用  </td></tr>
        <tr><td>slotsContent</td><td>字符串</td><td> None </td><td> 算法引擎使用  </td></tr>
        <tr><td>slotsQueryTimes</td><td>字符串</td><td> None </td><td> 算法引擎使用  </td></tr>
        <tr>
            <td>flowItem</td>
            <td>对象</td>
            <td>
                <table>
                    <thead><tr><td>返回字段</td><td>类型</td><td style="text-align: left">示例值</td><td>描述</td></tr></thead>
                    <tbody>
                        <tr><td>id</td><td>整型</td><td>558</td><td>流程项id, <br/>用于获取下一个流程项</td></tr>
                        <tr><td>isFirstItem</td><td>布尔型</td><td>true</td><td>标识是不是第一个流程项,用于控制是否显示标问(只有第一个流程项的话才显示标问)<br/>- true: 是第一个流程项 <br/> - false: 不是第一个流程项</td></tr>
                        <tr><td>flowName</td><td>字符串</td><td>第一步</td><td>流程项名称</td></tr>
                        <tr><td>flowContent</td><td>字符串</td><td><p>安装GBQ4</p></td><td>流程项内容</td></tr>
                        <tr><td>linkContent</td><td>字符串</td><td>下一步</td><td>下一个流程项的链接入口,<br/> 点击能够展示出下一个流程项</td></tr>
                    </tbody>
                </table>
            </td>
            <td> 流程问题的流程项（type=2） <br/> - 如果不是流程问题, 不返回该结构 </td>
        </tr>
    </tbody>
</table>
</escape>


*请求成功返回的数据基本示例:标准问题*

```json
    {
	"code": 200,
	"message": "success",
        "result": {
        	"routing": "faq",
			"qid": 12345,
			"slotVecsState": "None",
			"slotsContent": "None",
			"slotsQueryTimes": "None",
            "cid ": "2e604f02-29c5-4843-affd-533e0e497ee8",
            "initialQuestion": "云计量只旋转图纸，不旋转构件",
            "htmlAnswer": "<p><span class='zc - highlight '>软件暂时不能处理。</span></p><p>，可以用柱代替布置。</p>"
        }   
    }
```
---

code:400
## 请求失败返回的数据

*请求失败返回的数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)

```json
	{
	    "code": 400,
	    "message": "Required parameter 'qid' is not present"
	}
	
	{
	    "code": 400,
	    "message": "answer.qid: value must be a number"
	}
	
	{
    	    "code": 400,
    	    "message": "answer.clickType: value must be between 0 and 3"
	}
```
---

code:500
## 请求失败返回的数据

*请求失败返回的数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)

```json
    {
        "code": 500,
    "message": "java.lang.NullPointerException"
    }
```
---

# URL:/v2/answer


点击以下问题, 通过该接口返回答案
<br/> - 点击智能提示的问题
<br/> - 点击引导的问题
<br/> - 点击热门问题
- 相比V1，增加了推荐问题的返回

*初始问题（用于知识学习）, 仅在以下两种情况传该参数，获取方式见下图*

| 场景1-1:点击直推下引导的问题 | 场景1-2:点击换一批引导的问题 |
| :--- | :--- |
| <img src="https://openai-pre.glodon.com/docs/api/robotAppOpenApi/img/initQue2.png" width = "500" height = "400" alt="图片名称" align=center />  | <img src="https://openai-pre.glodon.com/docs/api/robotAppOpenApi/img/initQue4.png" width = "500" height = "400" alt="图片名称" align=center />  |

<a name="getAns"></a>

---

code:200

## 请求成功返回的数据

*请求成功返回字段描述*

<escape>
<table>
    <thead>
        <tr><th>返回字段</th><th>类型</th><th style="text-align: left">示例值</th><th>描述</th></tr>
    </thead>
    <tbody>
    	<tr><td>cid</td><td>字符串</td><td> 2e604f02-29c5-4843-affd-533e0e497ee8 </td><td> 单条会话的唯一标识</td></tr>
        <tr><td>htmlAnswer</td><td>字符串</td><td> 首先打开软件，然后点击就可以了 </td><td> 问题的答案(如果是流程问题, 不返回该字段，返回flowItem) </td></tr>  
        <tr><td>initialQuestion</td><td>字符串</td><td> 计价GBQ4如何下载 </td><td>初始问题，用于问题学习 </td></tr>
        <tr><td>routing</td><td>字符串</td><td> nlu </td><td> nlu/faq，用于后台区分调用的算法引擎 </td></tr>
        <tr><td>qid</td><td>整型</td><td> 133256 </td><td> 当前问题的唯一标识 </td></tr>
        <tr><td>slotVecsState</td><td>字符串</td><td> None </td><td> 算法引擎使用  </td></tr>
        <tr><td>slotsContent</td><td>字符串</td><td> None </td><td> 算法引擎使用  </td></tr>
        <tr><td>slotsQueryTimes</td><td>字符串</td><td> None </td><td> 算法引擎使用  </td></tr>
        <tr>
            <td>flowItem</td>
            <td>对象</td>
            <td>
                <table>
                    <thead><tr><td>返回字段</td><td>类型</td><td style="text-align: left">示例值</td><td>描述</td></tr></thead>
                    <tbody>
                        <tr><td>id</td><td>整型</td><td>558</td><td>流程项id, <br/>用于获取下一个流程项</td></tr>
                        <tr><td>isFirstItem</td><td>布尔型</td><td>true</td><td>标识是不是第一个流程项,用于控制是否显示标问(只有第一个流程项的话才显示标问)<br/>- true: 是第一个流程项 <br/> - false: 不是第一个流程项</td></tr>
                        <tr><td>flowName</td><td>字符串</td><td>第一步</td><td>流程项名称</td></tr>
                        <tr><td>flowContent</td><td>字符串</td><td><p>安装GBQ4</p></td><td>流程项内容</td></tr>
                        <tr><td>linkContent</td><td>字符串</td><td>下一步</td><td>下一个流程项的链接入口,<br/> 点击能够展示出下一个流程项</td></tr>
                    </tbody>
                </table>
            </td>
            <td> 流程问题的流程项（type=2） <br/> - 如果不是流程问题, 不返回该结构 </td>
        </tr>
		<tr>
            <td>similarQue</td>
            <td>对象</td>
            <td>
                <table>
                    <thead><tr><td>返回字段</td><td>类型</td><td style="text-align: left">示例值</td><td>描述</td></tr></thead>
                    <tbody>
				        <tr><td>qid</td><td>整型</td><td> 133256 </td><td> 当前问题的唯一标识 </td></tr>
				        <tr><td>type</td><td>整型 </td><td> 2 </td><td> 当前问题的类型 ：<br/>  -  0为常规问题 <br/> -  1为人工问题 <br/> -  2为流程问题   <br/>  -  3为表格问题</td></tr>
        				<tr><td>question</td><td>字符串</td><td> 缀为GBQ4文件要怎么打开 </td><td> 问题 </td></tr>
                    </tbody>
                </table>
            </td>
            <td> 当前问题的推荐问题列表<br/> (其他字段后台使用，无需关注) </td>
        </tr>
    </tbody>
</table>
</escape>


*请求成功返回的数据基本示例:标准问题*

```json
    {
        "code": 200,
        "message": "success",
        "result": {
			"similarQue": [{
				"question": "计价GBQ4.0重用组价，查询历史工程，全选自动复制组价为什么措施项目组价没有一起匹配过来？",
				"levelId": "5",
				"type": 0,
				"qid": "262189"
			}, {
				"question": "计价GBQ4.0如何返回项目管理界面？",
				"levelId": "5",
				"type": 0,
				"qid": "260847"
			}],
        	        "routing": "faq",
			"qid": 12345,
			"slotVecsState": "None",
			"slotsContent": "None",
			"slotsQueryTimes": "None",
                        "cid ": "2e604f02-29c5-4843-affd-533e0e497ee8",
                        "initialQuestion": "云计量只旋转图纸，不旋转构件",
                        "htmlAnswer": "<p><span class='zc - highlight '>软件暂时不能处理。</span></p><p>，可以用柱代替布置。</p>"
        }   
    }
```

*请求成功返回的数据基本示例:流程问题*

```json
    {
        "code": 200,
        "message": "success",
        "result": {
			"similarQue": [{
				"question": "计价GBQ4.0重用组价，查询历史工程，全选自动复制组价为什么措施项目组价没有一起匹配过来？",
				"levelId": "5",
				"type": 0,
				"qid": "262189"
			}, {
				"question": "计价GBQ4.0如何返回项目管理界面？",
				"levelId": "5",
				"type": 0,
				"qid": "260847"
			}],
                        "cid ": "2e604f02-29c5-4843-affd-533e0e497ee8",
                        "initialQuestion": "云计量只旋转图纸，不旋转构件",
                        "flowItem": {
           		    "id": 558,
           		    "isFirstItem": true,
           		    "flowName": "第一步",
           		    "flowContent": "<p>安装GBQ4</p>",
           		    "linkContent": "下一步",
           	        }			
        }   
    }
```


---

code:400
## 请求失败返回的数据

*请求失败返回的数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)

```json
   	{
	    "code": 400,
	    "message": "Required parameter 'qid' is not present"
	}
	
	{
	    "code": 400,
	    "message": "v2Answer.qid: value must be a number"
	}
	
	{
    	    "code": 400,
    	    "message": "v2Answer.clickType: value must be between 0 and 3"
	}
```
---

code:500
## 请求失败返回的数据

*请求失败返回的数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)

```json
    {
        "code": 500,
    "message": "java.lang.NullPointerException"
    }
```
---



# URL:/v3/answer


点击以下问题, 通过该接口返回答案
<br/> - 点击智能提示的问题
<br/> - 点击引导的问题
<br/> - 点击热门问题
- 相比V2，增加了从用户中心获取的accessToken的验证

*初始问题（用于知识学习）, 仅在以下两种情况传该参数，获取方式见下图*

| 场景1-1:点击直推下引导的问题 | 场景1-2:点击换一批引导的问题 |
| :--- | :--- |
| <img src="https://openai-pre.glodon.com/docs/api/robotAppOpenApi/img/initQue2.png" width = "500" height = "400" alt="图片名称" align=center />  | <img src="https://openai-pre.glodon.com/docs/api/robotAppOpenApi/img/initQue4.png" width = "500" height = "400" alt="图片名称" align=center />  |

<a name="getAns"></a>

---

code:200

## 请求成功返回的数据

*请求成功返回字段描述*

<escape>
<table>
    <thead>
        <tr><th>返回字段</th><th>类型</th><th style="text-align: left">示例值</th><th>描述</th></tr>
    </thead>
    <tbody>
    	<tr><td>cid</td><td>字符串</td><td> 2e604f02-29c5-4843-affd-533e0e497ee8 </td><td> 单条会话的唯一标识</td></tr>
        <tr><td>htmlAnswer</td><td>字符串</td><td> 首先打开软件，然后点击就可以了 </td><td> 问题的答案(如果是流程问题, 不返回该字段，返回flowItem) </td></tr>  
        <tr><td>initialQuestion</td><td>字符串</td><td> 计价GBQ4如何下载 </td><td>初始问题，用于问题学习 </td></tr>
        <tr><td>routing</td><td>字符串</td><td> nlu </td><td> nlu/faq，用于后台区分调用的算法引擎 </td></tr>
        <tr><td>qid</td><td>整型</td><td> 133256 </td><td> 当前问题的唯一标识 </td></tr>
        <tr><td>slotVecsState</td><td>字符串</td><td> None </td><td> 算法引擎使用  </td></tr>
        <tr><td>slotsContent</td><td>字符串</td><td> None </td><td> 算法引擎使用  </td></tr>
        <tr><td>slotsQueryTimes</td><td>字符串</td><td> None </td><td> 算法引擎使用  </td></tr>
        <tr>
            <td>flowItem</td>
            <td>对象</td>
            <td>
                <table>
                    <thead><tr><td>返回字段</td><td>类型</td><td style="text-align: left">示例值</td><td>描述</td></tr></thead>
                    <tbody>
                        <tr><td>id</td><td>整型</td><td>558</td><td>流程项id, <br/>用于获取下一个流程项</td></tr>
                        <tr><td>isFirstItem</td><td>布尔型</td><td>true</td><td>标识是不是第一个流程项,用于控制是否显示标问(只有第一个流程项的话才显示标问)<br/>- true: 是第一个流程项 <br/> - false: 不是第一个流程项</td></tr>
                        <tr><td>flowName</td><td>字符串</td><td>第一步</td><td>流程项名称</td></tr>
                        <tr><td>flowContent</td><td>字符串</td><td><p>安装GBQ4</p></td><td>流程项内容</td></tr>
                        <tr><td>linkContent</td><td>字符串</td><td>下一步</td><td>下一个流程项的链接入口,<br/> 点击能够展示出下一个流程项</td></tr>
                    </tbody>
                </table>
            </td>
            <td> 流程问题的流程项（type=2） <br/> - 如果不是流程问题, 不返回该结构 </td>
        </tr>
    </tbody>
</table>
</escape>


*请求成功返回的数据基本示例:标准问题*

```json
 {
"code": 200,
"message": "success",
     "result": {
        "routing": "faq",
        "qid": 12345,
        "slotVecsState": "None",
        "slotsContent": "None",
        "slotsQueryTimes": "None",
         "cid ": "2e604f02-29c5-4843-affd-533e0e497ee8",
         "initialQuestion": "云计量只旋转图纸，不旋转构件",
         "htmlAnswer": "<p><span class='zc - highlight '>软件暂时不能处理。</span></p><p>，可以用柱代替布置。</p>"
     }   
 }
```

*请求成功返回的数据基本示例:流程问题*

```json
    {
  	"code": 200,
  	"message": "success",
          "result": {
              "cid ": "2e604f02-29c5-4843-affd-533e0e497ee8",
              "initialQuestion": "云计量只旋转图纸，不旋转构件",
              "flowItem": {
             		"id": 558,
             		"isFirstItem": true,
             		"flowName": "第一步",
             		"flowContent": "<p>安装GBQ4</p>",
             		"linkContent": "下一步",
             	}			
          }   
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
	"message": "Header parameter 'openid' is invalid"
    }
	
	{
	    "code": 400,
	    "message": "Required parameter 'qid' is not present"
	}
	
	{
	    "code": 400,
	    "message": "answer.qid: value must be a number"
	}
	
	{
    	    "code": 400,
    	    "message": "answer.clickType: value must be between 0 and 3"
	}
```
---

code:500
## 请求失败返回的数据

*请求失败返回的数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)

```json
    {
        "code": 500,
    "message": "java.lang.NullPointerException"
    }
```
---








# URL:/flowItem

---

code:200
## 请求成功返回的数据

*请求成功返回数据字段描述*

<escape>
<table>
    <thead>
        <tr><th>返回字段</th><th>类型</th><th style="text-align: left">示例值</th><th>描述</th></tr>
    </thead>
    <tbody>
        <tr><td>question</td><td>字符串</td><td> 缀为GBQ4/GZB4/GTB4/GBG9/GPB9的文件要怎么打开 </td><td> 问题 </td></tr>
        <tr><td>initialQuestion</td><td>字符串</td><td> 计价GBQ4如何下载 </td><td>初始问题，用于问题学习 </td></tr>
        <tr>
            <td>flowItem</td>
            <td>对象</td>
            <td>
                <table>
                    <thead><tr><td>返回字段</td><td>类型</td><td style="text-align: left">示例值</td><td>描述</td></tr></thead>
                    <tbody>
                        <tr><td>id</td><td>整型</td><td>558</td><td>流程项id, <br/>用于获取下一个流程项</td></tr>
                        <tr><td>flowName</td><td>字符串</td><td>第一步</td><td>流程项名称</td></tr>
                        <tr><td>flowContent</td><td>字符串</td><td><p>安装GBQ4</p></td><td>流程项内容</td></tr>
                        <tr><td>linkContent</td><td>字符串</td><td>下一步</td><td>下一个流程项的链接入口,<br/> 点击能够展示出下一个流程项</td></tr>
                    </tbody>
                </table>
            </td>
            <td> 流程问题的流程项（type=2） </td>
        </tr>
    </tbody>
</table>
</escape>

*请求成功返回的数据基本示例*

```json
{
	"code": 200,
	"message": "success",
	"result": {
		"flowItem": {
			"id": 480,
			"flowName": "2",
			"flowContent": "<p>2</p>",
			"linkContent": "2"
		},
		"question": "我要进行流程问题测试2",
		"initialQuestion": "我要进行流程问题测试2"
	}
}
```


---



code:400
## 请求失败返回的数据

*请求失败返回数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)

```json
{
    "code": 400,
"message": "Required parameter 'id' is not present"
}

{
    "code": 400,
    "message": "flowItem.id: value must be a number"
}
```
---



code:500
## 请求失败返回的数据

*请求失败返回数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)

```json
    {
        "code": 500,
	"message": "java.lang.NullPointerException"
    }
```
---






# URL:/v3/flowItem

- 点击流程问题下的流程链接, 根据流程id,获取下一个流程项
- 相比V1，增加了从用户中心获取的accessToken的验证

---

code:200
## 请求成功返回的数据

*请求成功返回数据字段描述*

<escape>
<table>
    <thead>
        <tr><th>返回字段</th><th>类型</th><th style="text-align: left">示例值</th><th>描述</th></tr>
    </thead>
    <tbody>
        <tr><td>question</td><td>字符串</td><td> 缀为GBQ4/GZB4/GTB4/GBG9/GPB9的文件要怎么打开 </td><td> 问题 </td></tr>
        <tr><td>initialQuestion</td><td>字符串</td><td> 计价GBQ4如何下载 </td><td>初始问题，用于问题学习 </td></tr>
        <tr>
            <td>flowItem</td>
            <td>对象</td>
            <td>
                <table>
                    <thead><tr><td>返回字段</td><td>类型</td><td style="text-align: left">示例值</td><td>描述</td></tr></thead>
                    <tbody>
                        <tr><td>id</td><td>整型</td><td>558</td><td>流程项id, <br/>用于获取下一个流程项</td></tr>
                        <tr><td>flowName</td><td>字符串</td><td>第一步</td><td>流程项名称</td></tr>
                        <tr><td>flowContent</td><td>字符串</td><td><p>安装GBQ4</p></td><td>流程项内容</td></tr>
                        <tr><td>linkContent</td><td>字符串</td><td>下一步</td><td>下一个流程项的链接入口,<br/> 点击能够展示出下一个流程项</td></tr>
                    </tbody>
                </table>
            </td>
            <td> 流程问题的流程项（type=2） </td>
        </tr>
    </tbody>
</table>
</escape>

*请求成功返回的数据基本示例*

```json
{
	"code": 200,
	"message": "success",
	"result": {
		"flowItem": {
			"id": 480,
			"flowName": "2",
			"flowContent": "<p>2</p>",
			"linkContent": "2"
		},
		"question": "我要进行流程问题测试2",
		"initialQuestion": "我要进行流程问题测试2"
	}
}
```


---



code:400
## 请求失败返回的数据

*请求失败返回数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)

```json
 {
        "code": 400,
	"message": "Header parameter 'authorization' is invalid"
    }
	
	{
        "code": 400,
	"message": "Header parameter 'openid' is invalid"
    }
   
   {
        "code": 400,
	"message": "Required parameter 'id' is not present"
    }

    {
    	"code": 400,
    	"message": "flowItem.id: value must be a number"
    }

```
---



code:500
## 请求失败返回的数据

*请求失败返回数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)

```json
    {
        "code": 500,
	"message": "java.lang.NullPointerException"
    }
```
---

# URL:/linkQuestion
<br/> - 点击关联问题，通过关联问题的id, 获取关联问题的答案


| linkId 和 question 获取方式见下图: |
| :--- |
| <img src="https://openai-pre.glodon.com/docs/api/robotAppOpenApi/img/linkIdImg.png" width = "500" height = "400" alt="图片名称" align=center /> |


---

code:200
## 请求成功返回的数据

*请求成功返回数据字段描述*

<escape>
<table>
    <thead>
        <tr><th>返回字段</th><th>类型</th><th style="text-align: left">示例值</th><th>描述</th></tr>
    </thead>
    <tbody>
    	<tr><td>htmlAnswer</td><td>字符串</td><td> 首先打开软件，然后点击就可以了 </td><td> 答案 (如果是流程问题, 不返回该字段，返回flowItem)</td></tr>
        <tr><td>hideUpDown</td><td>布尔型</td><td> false </td><td> 用于前端显示或隐藏点踩点赞页签 </td></tr>
        <tr><td>question</td><td>字符串</td><td>计价GBQ4.0项目管理界面载入XML组价后，部分单位工程组价并没有匹配进去 </td><td> 问题 </td></tr>
        <tr><td>type</td><td>整型 </td><td> 2 </td><td> 当前问题的类型 ：<br/>  -  0为常规问题 <br/> -  1为人工问题 <br/> -  2为流程问题   <br/>  -  3为表格问题</td></tr>
        <tr><td>cid</td><td>字符串</td><td> 2e604f02-29c5-4843-affd-533e0e497ee8 </td><td> 单条会话的唯一标识</td></tr>
        <tr><td>initialQuestion</td><td>字符串</td><td> 计价GBQ4如何下载 </td><td>初始问题，用于问题学习 </td></tr>
        <tr><td>routing</td><td>字符串</td><td> nlu </td><td> nlu/faq，用于后台区分调用的算法引擎 </td></tr>
        <tr><td>qid</td><td>整型</td><td> 133256 </td><td> 当前问题的唯一标识 </td></tr>
        <tr><td>slotVecsState</td><td>字符串</td><td> None </td><td> 算法引擎使用  </td></tr>
        <tr><td>slotsContent</td><td>字符串</td><td> None </td><td> 算法引擎使用  </td></tr>
        <tr><td>slotsQueryTimes</td><td>字符串</td><td> None </td><td> 算法引擎使用  </td></tr>
        <tr>
            <td>flowItem</td>
            <td>对象</td>
            <td>
                <table>
                    <thead><tr><td>返回字段</td><td>类型</td><td style="text-align: left">示例值</td><td>描述</td></tr></thead>
                    <tbody>
                        <tr><td>id</td><td>整型</td><td>558</td><td>流程项id, <br/>用于获取下一个流程项</td></tr>
                        <tr><td>isFirstItem</td><td>布尔型</td><td>true</td><td>标识是不是第一个流程项,<br/>用于控制是否显示标问<br/>(只有第一个流程项的话才显示标问)<br/>- true: 是第一个流程项 <br/> - false: 不是第一个流程项</td></tr>
                        <tr><td>flowName</td><td>字符串</td><td>第一步</td><td>流程项名称</td></tr>
                        <tr><td>flowContent</td><td>字符串</td><td><p>安装GBQ4</p></td><td>流程项内容</td></tr>
                        <tr><td>linkContent</td><td>字符串</td><td>下一步</td><td>下一个流程项的链接入口,<br/> 点击能够展示出下一个流程项</td></tr>
                    </tbody>
                </table>
            </td>
            <td> 流程问题的流程项（type=2） <br/> - 如果不是流程问题, 不返回该结构 </td>
        </tr>
    </tbody>
</table>
</escape>

*请求成功返回的数据基本示例:常规问题*

```json
{
	"code": 200,
	"message": "success",
	"result": {
		"routing": "faq",
		"qid": 12345,
		"slotVecsState": "None",
		"slotsContent": "None",
		"slotsQueryTimes": "None",
		"htmlAnswer": "<p>计价软件载入XML组价后，部分单位工程组价没有匹配进去是因为工程招标清单里面的部分单位工程清单编码和招标方给的招标控制价里面的清单编码不匹配。</p>",
		"hideUpDown": false,
		"question": "计价GBQ4.0项目管理界面载入XML组价后，部分单位工程组价并没有匹配进去",
		"type": 0,
		"initialQuestion": "计价GBQ4.0项目管理界面载入XML组价后，部分单位工程组价并没有匹配进去",
		"cid": "0e7bf813-b138-4364-a16b-64eccbf63a3e"
	}
}
```


*请求成功返回的数据基本示例:流程问题*


```json
{
	"code": 200,
	"message": "success",
	"result": {
		"flowItem": {
			"id": 479,
			"flowContent": "<p>content1</p>",
			"flowName": "name1",
			"linkContent": "like1",
			"isFirstItem": true
		},
		"hideUpDown": false,
		"question": "我要进行流程问题测试2",
		"type": 2,
		"initialQuestion": "我要进行流程问题测试2",
		"cid": "58153881-ea83-42df-b4a2-09378a3aa660"
	}
}
```


---


code:400
## 请求失败返回的数据

*请求失败返回数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)

```json
    {
        "code": 400,
	"message": "Required parameter 'linkId' is not present"
    }
    
    {
    	"code": 400,
    	"message": "linkQuestion.linkId: value must be a number"
    }

    {
    	"code": 400,
    	"message": "linkQuestion.question: Length exceeds the max value [500]"
    }
```
---

code:500
## 请求失败返回的数据

*请求失败返回数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)

```json
{
    "code": 500,
"message": "java.lang.IndexOutOfBoundsException"
}
```
---



# URL:/v2/linkQuestion

<br/> - 点击关联问题，通过关联问题的id, 获取关联问题的答案
- 相比V1，增加了推荐问题的返回

| linkId 和 question 获取方式见下图: |
| :--- |
| <img src="https://openai-pre.glodon.com/docs/api/robotAppOpenApi/img/linkIdImg.png" width = "500" height = "400" alt="图片名称" align=center /> |


---

code:200
## 请求成功返回的数据

*请求成功返回数据字段描述*

<escape>
<table>
    <thead>
        <tr><th>返回字段</th><th>类型</th><th style="text-align: left">示例值</th><th>描述</th></tr>
    </thead>
    <tbody>
    	<tr><td>htmlAnswer</td><td>字符串</td><td> 首先打开软件，然后点击就可以了 </td><td> 答案 (如果是流程问题, 不返回该字段，返回flowItem)</td></tr>
        <tr><td>hideUpDown</td><td>布尔型</td><td> false </td><td> 用于前端显示或隐藏点踩点赞页签 </td></tr>
        <tr><td>question</td><td>字符串</td><td>计价GBQ4.0项目管理界面载入XML组价后，部分单位工程组价并没有匹配进去 </td><td> 问题 </td></tr>
        <tr><td>type</td><td>整型 </td><td> 2 </td><td> 当前问题的类型 ：<br/>  -  0为常规问题 <br/> -  1为人工问题 <br/> -  2为流程问题   <br/>  -  3为表格问题</td></tr>
        <tr><td>cid</td><td>字符串</td><td> 2e604f02-29c5-4843-affd-533e0e497ee8 </td><td> 单条会话的唯一标识</td></tr>
        <tr><td>initialQuestion</td><td>字符串</td><td> 计价GBQ4如何下载 </td><td>初始问题，用于问题学习 </td></tr>
        <tr><td>routing</td><td>字符串</td><td> nlu </td><td> nlu/faq，用于后台区分调用的算法引擎 </td></tr>
        <tr><td>qid</td><td>整型</td><td> 133256 </td><td> 当前问题的唯一标识 </td></tr>
        <tr><td>slotVecsState</td><td>字符串</td><td> None </td><td> 算法引擎使用  </td></tr>
        <tr><td>slotsContent</td><td>字符串</td><td> None </td><td> 算法引擎使用  </td></tr>
        <tr><td>slotsQueryTimes</td><td>字符串</td><td> None </td><td> 算法引擎使用  </td></tr>
        <tr>
            <td>flowItem</td>
            <td>对象</td>
            <td>
                <table>
                    <thead><tr><td>返回字段</td><td>类型</td><td style="text-align: left">示例值</td><td>描述</td></tr></thead>
                    <tbody>
                        <tr><td>id</td><td>整型</td><td>558</td><td>流程项id, <br/>用于获取下一个流程项</td></tr>
                        <tr><td>isFirstItem</td><td>布尔型</td><td>true</td><td>标识是不是第一个流程项,<br/>用于控制是否显示标问<br/>(只有第一个流程项的话才显示标问)<br/>- true: 是第一个流程项 <br/> - false: 不是第一个流程项</td></tr>
                        <tr><td>flowName</td><td>字符串</td><td>第一步</td><td>流程项名称</td></tr>
                        <tr><td>flowContent</td><td>字符串</td><td><p>安装GBQ4</p></td><td>流程项内容</td></tr>
                        <tr><td>linkContent</td><td>字符串</td><td>下一步</td><td>下一个流程项的链接入口,<br/> 点击能够展示出下一个流程项</td></tr>
                    </tbody>
                </table>
            </td>
            <td> 流程问题的流程项（type=2） <br/> - 如果不是流程问题, 不返回该结构 </td>
        </tr>
		<tr>
            <td>similarQue</td>
            <td>对象</td>
            <td>
                <table>
                    <thead><tr><td>返回字段</td><td>类型</td><td style="text-align: left">示例值</td><td>描述</td></tr></thead>
                    <tbody>
				        <tr><td>qid</td><td>整型</td><td> 133256 </td><td> 当前问题的唯一标识 </td></tr>
				        <tr><td>type</td><td>整型 </td><td> 2 </td><td> 当前问题的类型 ：<br/>  -  0为常规问题 <br/> -  1为人工问题 <br/> -  2为流程问题   <br/>  -  3为表格问题</td></tr>
        				<tr><td>question</td><td>字符串</td><td> 缀为GBQ4文件要怎么打开 </td><td> 问题 </td></tr>
                    </tbody>
                </table>
            </td>
            <td> 当前问题的推荐问题列表<br/> (其他字段后台使用，无需关注) </td>
        </tr>
    </tbody>
</table>
</escape>

*请求成功返回的数据基本示例:常规问题*

```json
{
	"code": 200,
	"message": "success",
	"result": {
		"similarQue": [{
			"question": "计价GBQ4.0重用组价，查询历史工程，全选自动复制组价为什么措施项目组价没有一起匹配过来？",
			"levelId": "5",
			"type": 0,
			"qid": "262189"
		}, {
			"question": "计价GBQ4.0如何返回项目管理界面？",
			"levelId": "5",
			"type": 0,
			"qid": "260847"
		}],
		"routing": "faq",
		"qid": 12345,
		"slotVecsState": "None",
		"slotsContent": "None",
		"slotsQueryTimes": "None",
		"htmlAnswer": "<p>计价软件载入XML组价后，部分单位工程组价没有匹配进去是因为工程招标清单里面的部分单位工程清单编码和招标方给的招标控制价里面的清单编码不匹配。</p>",
		"hideUpDown": false,
		"question": "计价GBQ4.0项目管理界面载入XML组价后，部分单位工程组价并没有匹配进去",
		"type": 0,
		"initialQuestion": "计价GBQ4.0项目管理界面载入XML组价后，部分单位工程组价并没有匹配进去",
		"cid": "0e7bf813-b138-4364-a16b-64eccbf63a3e"
	}
}
```


*请求成功返回的数据基本示例:流程问题*


```json
{
	"code": 200,
	"message": "success",
	"result": {
		"flowItem": {
			"id": 479,
			"flowContent": "<p>content1</p>",
			"flowName": "name1",
			"linkContent": "like1",
			"isFirstItem": true
		},
		"similarQue": [{
			"question": "计价GBQ4.0重用组价，查询历史工程，全选自动复制组价为什么措施项目组价没有一起匹配过来？",
			"levelId": "5",
			"type": 0,
			"qid": "262189"
		}, {
			"question": "计价GBQ4.0如何返回项目管理界面？",
			"levelId": "5",
			"type": 0,
			"qid": "260847"
		}],
		"hideUpDown": false,
		"question": "我要进行流程问题测试2",
		"type": 2,
		"initialQuestion": "我要进行流程问题测试2",
		"cid": "58153881-ea83-42df-b4a2-09378a3aa660"
	}
}
```


---


code:400
## 请求失败返回的数据

*请求失败返回数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)

```json
    {
        "code": 400,
	"message": "Required parameter 'linkId' is not present"
    }
    
    {
    	"code": 400,
    	"message": "v2LinkQuestion.linkId: value must be a number"
    }

    {
    	"code": 400,
    	"message": "v2LinkQuestion.question: Length exceeds the max value [500]"
    }
```
---

code:500
## 请求失败返回的数据

*请求失败返回数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)

```json
    {
        "code": 500,
	"message": "java.lang.IndexOutOfBoundsException"
    }
```
---



# URL:/v3/linkQuestion

<br/> - 点击关联问题，通过关联问题的id, 获取关联问题的答案
- 相比V2，增加了从用户中心获取的accessToken的验证

| linkId 和 question 获取方式见下图: |
| :--- |
| <img src="https://openai-pre.glodon.com/docs/api/robotAppOpenApi/img/linkIdImg.png" width = "500" height = "400" alt="图片名称" align=center /> |


---

code:200
## 请求成功返回的数据

*请求成功返回数据字段描述*



<escape>
<table>
    <thead>
        <tr><th>返回字段</th><th>类型</th><th style="text-align: left">示例值</th><th>描述</th></tr>
    </thead>
    <tbody>
    	<tr><td>htmlAnswer</td><td>字符串</td><td> 首先打开软件，然后点击就可以了 </td><td> 答案 (如果是流程问题, 不返回该字段，返回flowItem)</td></tr>
        <tr><td>hideUpDown</td><td>布尔型</td><td> false </td><td> 用于前端显示或隐藏点踩点赞页签 </td></tr>
        <tr><td>question</td><td>字符串</td><td>计价GBQ4.0项目管理界面载入XML组价后，部分单位工程组价并没有匹配进去 </td><td> 问题 </td></tr>
        <tr><td>type</td><td>整型 </td><td> 2 </td><td> 当前问题的类型 ：<br/>  -  0为常规问题 <br/> -  1为人工问题 <br/> -  2为流程问题   <br/>  -  3为表格问题</td></tr>
        <tr><td>cid</td><td>字符串</td><td> 2e604f02-29c5-4843-affd-533e0e497ee8 </td><td> 单条会话的唯一标识</td></tr>
        <tr><td>initialQuestion</td><td>字符串</td><td> 计价GBQ4如何下载 </td><td>初始问题，用于问题学习 </td></tr>
        <tr><td>routing</td><td>字符串</td><td> nlu </td><td> nlu/faq，用于后台区分调用的算法引擎 </td></tr>
        <tr><td>qid</td><td>整型</td><td> 133256 </td><td> 当前问题的唯一标识 </td></tr>
        <tr><td>slotVecsState</td><td>字符串</td><td> None </td><td> 算法引擎使用  </td></tr>
        <tr><td>slotsContent</td><td>字符串</td><td> None </td><td> 算法引擎使用  </td></tr>
        <tr><td>slotsQueryTimes</td><td>字符串</td><td> None </td><td> 算法引擎使用  </td></tr>
        <tr>
            <td>flowItem</td>
            <td>对象</td>
            <td>
                <table>
                    <thead><tr><td>返回字段</td><td>类型</td><td style="text-align: left">示例值</td><td>描述</td></tr></thead>
                    <tbody>
                        <tr><td>id</td><td>整型</td><td>558</td><td>流程项id, <br/>用于获取下一个流程项</td></tr>
                        <tr><td>isFirstItem</td><td>布尔型</td><td>true</td><td>标识是不是第一个流程项,<br/>用于控制是否显示标问<br/>(只有第一个流程项的话才显示标问)<br/>- true: 是第一个流程项 <br/> - false: 不是第一个流程项</td></tr>
                        <tr><td>flowName</td><td>字符串</td><td>第一步</td><td>流程项名称</td></tr>
                        <tr><td>flowContent</td><td>字符串</td><td><p>安装GBQ4</p></td><td>流程项内容</td></tr>
                        <tr><td>linkContent</td><td>字符串</td><td>下一步</td><td>下一个流程项的链接入口,<br/> 点击能够展示出下一个流程项</td></tr>
                    </tbody>
                </table>
            </td>
            <td> 流程问题的流程项（type=2） <br/> - 如果不是流程问题, 不返回该结构 </td>
        </tr>
    </tbody>
</table>
</escape>



*请求成功返回的数据基本示例:常规问题*

```json
{
	"code": 200,
	"message": "success",
	"result": {
		"routing": "faq",
		"qid": 12345,
		"slotVecsState": "None",
		"slotsContent": "None",
		"slotsQueryTimes": "None",
		"htmlAnswer": "<p>计价软件载入XML组价后，部分单位工程组价没有匹配进去是因为工程招标清单里面的部分单位工程清单编码和招标方给的招标控制价里面的清单编码不匹配。</p>",
		"hideUpDown": false,
		"question": "计价GBQ4.0项目管理界面载入XML组价后，部分单位工程组价并没有匹配进去",
		"type": 0,
		"initialQuestion": "计价GBQ4.0项目管理界面载入XML组价后，部分单位工程组价并没有匹配进去",
		"cid": "0e7bf813-b138-4364-a16b-64eccbf63a3e"
	}
}
```


*请求成功返回的数据基本示例:流程问题*


```json
{
	"code": 200,
	"message": "success",
	"result": {
		"flowItem": {
			"id": 479,
			"flowContent": "<p>content1</p>",
			"flowName": "name1",
			"linkContent": "like1",
			"isFirstItem": true
		},
		"hideUpDown": false,
		"question": "我要进行流程问题测试2",
		"type": 2,
		"initialQuestion": "我要进行流程问题测试2",
		"cid": "58153881-ea83-42df-b4a2-09378a3aa660"
	}
}
```


---


code:400
## 请求失败返回的数据

*请求失败返回数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)

```json
    {
        "code": 400,
	"message": "Header parameter 'authorization' is invalid"
    }
	
	{
        "code": 400,
	"message": "Header parameter 'openid' is invalid"
    }
	
	{
        "code": 400,
	"message": "Required parameter 'linkId' is not present"
    }
    
    {
    	"code": 400,
    	"message": "linkQuestion.linkId: value must be a number"
    }

    {
    	"code": 400,
    	"message": "linkQuestion.question: Length exceeds the max value [500]"
    }
```
---

code:500
## 请求失败返回的数据

*请求失败返回数据基本示例*  [**查看其它状态码**](#sort=api&doc=robotAppOpenApi/summary/02-explain.md)

```json
    {
    "code": 500,
	"message": "java.lang.IndexOutOfBoundsException"
    }
```
---


# URL:/userAction
- 用户的点踩、点赞、点击、点下一页、分享等行为

|场景: 点击换一批的引导问题的时候传递 |
| :--- |
| <img src="https://openai-pre.glodon.com/docs/api/robotAppOpenApi/img/actionClick.png" width = "500" height = "400" alt="图片名称" align=center /> |


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

	{
    	"code": 400,
    	"message": "userAction.action: 'xx' is invalid action. valid action must be in ('up','down','click','another','share')"
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



# URL:/v3/userAction

- 用户的点踩、点赞、点击、点下一页、分享等行为
- 相比V1，增加了从用户中心获取的accessToken的验证


|场景: 点击换一批的引导问题的时候传递 |
| :--- |
| <img src="https://openai-pre.glodon.com/docs/api/robotAppOpenApi/img/actionClick.png" width = "500" height = "400" alt="图片名称" align=center /> |


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

	{
    	"code": 400,
    	"message": "userAction.action: 'xx' is invalid action. valid action must be in ('up','down','click','another','share')"
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


# URL:/robotFeedback
- 退出程序时，可对本次服务的解决情况进行评价及意见反馈

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

	{
    	"code": 400,
    	"message": "robotFeedback.feedbackType: 'xx' is invalid feedbackType. valid feedbackType must be in ('0','1','2')"
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




# URL:/v3/robotFeedback
- 退出程序时，可对本次服务的解决情况进行评价及意见反馈
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

	{
    	"code": 400,
    	"message": "robotFeedback.feedbackType: 'xx' is invalid feedbackType. valid feedbackType must be in ('0','1','2')"
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
