GitHubTest
#后端
## 1. 登录/注册
+ 登录:输入用户名和密码登录   
请求地址   
POST http://localhost:8989/pigeon/user/login   
请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	user &nbsp; &nbsp; User&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;是  &nbsp; &nbsp; 用户类    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;Object&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;登录成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;登录失败   

请求数据实例   
```
user{
  	user.username:"小朋友"
  	user.password:"123456"
   }
```   

返回数据实例

```
  {
	status:0
	msg:"登录成功"
  }
```


+ 注册   
请求地址   
POST http://localhost:8989/pigeon/user/register?code   
	请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	user &nbsp; &nbsp; User&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;是  &nbsp; &nbsp; &nbsp;用户类    
	code &nbsp; &nbsp; String&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 是  &nbsp; &nbsp; &nbsp;验证码    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;Object&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;注册成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;注册失败   
请求数据实例   
```
user{
	user.id:"001"
  	user.username:"小朋友"
  	user.dept:"幼儿园"
  	user.password:"123456"
  	uesr.sex:"男"
   }
```   

返回数据实例

```
  {
	status:0
	msg:"注册成功"
  }
```

	 
+ 验证码生成   
	请求地址   
	POST http://localhost:8989/pigeon/user/getImage?time   
	请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;说明    
	time &nbsp; &nbsp; number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;是  &nbsp; &nbsp; &nbsp;Math.random()    

	返回值     
	String    
	属性:"data:image/png;base64," + Base64Utils.encodeToString(byteArrayOutputStream.toByteArray());   
	类型:String      
	说明:验证码   

## 2. 签到
请求地址      
POST http://localhost:8989/pigeon/user/sign      
	请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	record &nbsp; &nbsp; Record&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;是  &nbsp; &nbsp; 签到记录类    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;Object&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;签到成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;签到失败   

请求数据实例   
```
record{
  	record.temperature:36.6
  	record.nation:"中国"
  	record.province:"重庆市"
  	record.city:"荣昌区"
   }
```
返回数据实例
```
  {
	status:0
	msg:"签到成功"
  }
```

## 3. 修改个人信息
请求地址      
POST http://localhost:8989/pigeon/user/changeInfo      
	请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	user &nbsp; &nbsp; User&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; 是  &nbsp; &nbsp; 修改用户    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;Object&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;签到成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;签到失败   

请求数据实例   
```
User{
  	User.icon:"text.png"
   }
```
返回数据实例
```
  {
	status:0
	msg:"修改成功"
  }
```   
## 4. 提交活动请求
请求地址      
POST http://localhost:8989/pigeon/activity/submit?      
	请求参数         
	属性 &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;类型 &nbsp; &nbsp;&nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	activity &nbsp; &nbsp; Activity&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp;是  &nbsp; &nbsp; 提交活动申请    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;Object&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;提交成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;提交失败   

请求数据实例   
```
Activity{
  	activityName:"请假",
        applicant:"小朋友",
        approver:"大家长",
        startTime:"2020-11-19 09:07:34",
        endTime:"2020-11-19 09:07:35",
        status:"已通过",
        submitTime:"2020-11-19 09:07:20" 
   }
```
返回数据实例
```
  {
	status:0
	msg:"提交成功"
  }
```

