<script id="body_muban" type="text/html">
	<!-- 头部 -->
	<div class="layui-tab layui-tab-brief " lay-filter="docDemoTabBrief">
		
	 <!-- 选项卡 ：文档 & 调试 -->
	  <ul class="layui-tab-title head_css">
		<li class="layui-this"> 
			<i class="layui-icon">&#xe60e;</i>
			<span>文档</span>
		</li>
	 <!--   <li> 
			<i class="layui-icon">&#xe64c;</i>
			<span>调试</span>
		</li> -->
	  </ul>
	  
	  <!-- 内容区域 -->
	  <div class="layui-tab-content " >
		  
	   <!-- 文档区域 -->
		<div class="layui-tab-item layui-show gundong_body">
			
			<!-- 模板 -->
			<div class="layui-fluid">
			  <div class="layui-row">
				<div class="layui-col-xs12">
				  <div class="layui-card">
					<div class="layui-card-header">
						<div style="float: left;">
							<h2>{{summary}}</h2>
						</div>
						<div style="float: right;">
							<h4 style="margin-left: 50px;"><a >复制接口</a></h4>
						</div>
						
						<div style="float: right;margin-left: 50px;">
							<h4><a>复制文档</a></h4>
						</div>
					</div>
					<div class="layui-card-body" style="background: rgba(73,204,144,.1);">
					  <span style="background-color: #49cc90;margin-right: 50px;">
						  {{method}}
					  </span>	 
					  <span>
						  {{path}}
					  </span>
					</div>
				</div>
				  
				  <!-- 接口描述 -->
				  <div class="layui-card">
					<div class="layui-card-header layui-elem-quote">接口描述</div>
					
					<div class="layui-card-body" id="jiekoumiaoshu">
						{{description}}
					</div>
					
				  </div>
				  
				  <!-- 请求示例 -->
				  <div class="layui-card">
					<div class="layui-card-header layui-elem-quote">请求示例</div>
					
					<div class="layui-card-body">
						<pre class="layui-code">
							code
						</pre>
					</div>
					
				  </div>
				  
				  <!-- 请求参数 -->
				  <div class="layui-card">
					<div class="layui-card-header layui-elem-quote">请求参数</div>
						
					<div class="layui-card-body">
						<table class="layui-table" lay-skin="line">
						  <colgroup>
							<col width="20%">
							<col width="20%">
							<col width="10%">
							<col width="10%">
							<col width="30%">
							<col>
						  </colgroup>
						  <thead>
							<tr>
							  <th>参数名称</th>
							  <th>参数说明</th>
							  <th>请求类型</th>
							  <th>是否必填</th>
							  <th>数据类型</th>
							</tr> 
						  </thead>
						
						  <tbody>
							{{each parameters paramer_value paramer_index}}
							   <tr>
								   <td>{{paramer_value.name}}</td>
								   <td>{{paramer_value.description}}</td>
								   <td>{{paramer_value.in}}</td>
								   <td>{{paramer_value.required}}</td>
								   <td>{{paramer_value.type}}</td>
							   </tr>
							{{/each}}
						  </tbody>
						</table>   
						
					</div>
						
				  </div>
				  
				  <!-- 响应状态 -->
				  <div class="layui-card">
					<div class="layui-card-header layui-elem-quote">响应状态</div>
						
					<div class="layui-card-body">
						
						<table class="layui-table" lay-skin="line">
						  <colgroup>
							<col width="150">
							<col width="150">
							<col width="200">
							<col>
						  </colgroup>
						  <thead>
							<tr>
							  <th>状态码</th>
							  <th>说明</th>
							</tr> 
						  </thead>
						  <tbody>
							{{each responses responses_value responses_index}}
								<tr>
								  <td>{{responses_index}}</td>
								  <td>{{responses_value.description}}</td>
								</tr>
							{{/each}}
						  </tbody>
						</table>   
						
					</div>
						
				  </div>	
				  
				  <!-- 响应参数 -->
				  <div class="layui-card">
					<div class="layui-card-header layui-elem-quote">响应参数</div>
						
					<div class="layui-card-body">
						
						<table class="layui-table" lay-skin="line">
						  <colgroup>
							<col width="150">
							<col width="150">
							<col width="200">
							<col>
						  </colgroup>
						  <thead>
							<tr>
							  <th>参数名称</th>
							  <th>参数说明</th>
							  <th>参数类型</th>
							</tr> 
						  </thead>
						  <tbody>
							<tr>
							  <td>200</td>
							  <td>OK</td>
							  <td>OK</td>
							</tr>
							  <tr>
								<td>400</td>
								<td>页面错误</td>
								<td>页面错误</td>
							  </tr>
						  </tbody>
						</table>  
						
					</div>
						
				  </div>	
						  
				  <!-- 响应示例 -->
				  <div class="layui-card">
					<div class="layui-card-header layui-elem-quote">响应示例</div>
						
					<div class="layui-card-body">
						<pre class="layui-code">
								code
						</pre>
					</div>
						
				  </div>		
					
	  
				</div>
			  </div>
			</div>
			
		</div>
		
		<!-- debugn区域 -->
		<div class="layui-tab-item">
			<div class="layui-card">
				<div class="layui-card-body">
				  <form class="layui-form">
					  
					<div>
					  <div class="layui-row layui-col-space10">
						  
						<div class="layui-col-sm11">
							<div class="layui-form-item">
								<label class="layui-form-label">
									<span id="requestType" style="background-color: #49cc90;margin-right: 50px;">
									  GET
									</span>	 
								</label>
								<div class="layui-input-block">
								  <input id="requestUrl" value="/api/getuserinfo" type="text" name="title" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
								</div>
							</div>
						</div>
						
						<div class="layui-col-sm1">
						  <a href="javascript:;" class="layui-btn" id="sendRequest">发起请求</a>
						</div>
						
					  </div>
					</div>
				  </form>
				  
				  <div class="layui-card">
					<div class="layui-tab layui-tab-brief" >
					  <div class="layui-tab-content" >
						  
					  <ul class="layui-tab-title">
						<li class="layui-this">请求参数</li>
						<li>请求头部</li>
					  </ul>
					   <!-- 请求参数 -->
						<div class="layui-tab-item layui-show">
							<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
								
									<ul class="layui-tab-title">
										<li class="layui-this">x-www-form-urlencoded</li>
										<li>form-data</li>
										<li>Raw</li>
									</ul>
								
									<div class="layui-tab-content" >
										<div class="layui-tab-item layui-show" id="xiangyingneirong" style="text-align: left;">
											<div class="layui-card-body">
												111
												
											</div>							
										</div>
										<div class="layui-tab-item" id="raw1">内容5</div>
										<div class="layui-tab-item" id="headers1"> lalala </div> 
									</div>
							</div>
						</div>
						
						<!-- 请求头部 -->
						<div class="layui-tab-item" id="headers">
							请求头部
						</div>
						
					  </div>
					</div> 
				  </div>
				</div>
			  </div>
			  
		   
			  <div class="layui-card">
				
				<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
				  <ul class="layui-tab-title">
					<li class="layui-this">响应内容</li>
					<li>Raw</li>
					<li>Headers</li>
					<li>Curl</li>
				  </ul>
				  <div class="layui-tab-content" >
					<div class="layui-tab-item layui-show" id="xiangyingneirong" style="text-align: left;">内容不一样是要有</div>
					<div class="layui-tab-item" id="raw">内容5</div>
					<div class="layui-tab-item" id="headers">
					<div class="layui-card-body">
						<table class="layui-table" lay-skin="line">
						  <colgroup>
							<col width="150">
							<col width="150">
							<col width="200">
							<col>
						  </colgroup>
						  <thead>
							<tr>
							  <th>响应头</th>
							  <th>值</th>
							</tr> 
						  </thead>
						  
						 
						  
						  <tbody>
							<tr>
								<td>connection</td>
								<td>keep-alive</td>
							</tr>
							<tr>
								<td>content-length</td>
								<td>4</td>
							</tr>
	
							<tr>
								<td>content-type</td>
								<td>text/plain;charset=UTF-8</td>
							</tr>
							<tr>
								<td>date</td>
								<td>Sat, 10 Oct 2020 02:45:47 GMT</td>
							</tr>
							<tr>
								<td>keep-alive</td>
								<td>timeout=60</td>
							</tr>
							<tr>
								<td>vary</td>
								<td>Origin, Access-Control-Request-Method, Access-Control-Request-Headers</td>
							</tr>
								
								
								
								
						  </tbody>
						</table>   
					</div>
						
					<div class="layui-tab-item" >
						<h5 id="curl" >
							
						</h5>
					</div>
				  </div>
				</div> 
			
			  </div>
		   
			</div>
		
		
	  </div>
	
	</div> 
	
</script>