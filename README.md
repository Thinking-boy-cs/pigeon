GitHubTest
#后端~App
## 1. 登录/注册
+ 登录:输入用户名和密码登录   
请求地址   
POST http://localhost:8989/api/pigeon/user/login   
请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	user &nbsp; &nbsp; User&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;是  &nbsp;&nbsp; &nbsp; 用户类    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;String&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 状态信息   
	user &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;User &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;登录用户

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;登录成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;登录失败   

请求数据实例   
```
user{
  	telNumber:"xxxxxxxxxxx"
  	password:"123456"
   }
```   

返回数据实例

```
  {
	status:0,
	msg:"登录成功"
        user:{
                id:"001",
                username:"小朋友",
                dept:"幼儿园",
                password:"123456",
                sex:"男",
                telNumber:null,
                email:null,
                icon:"/default"
                companyId:00001,
                originId:001,
                status:"已激活",
                registerTime:2020-11-18 20:30:27
             }
  }
```


+ 注册   
请求地址   
POST http://localhost:8989/api/pigeon/user/register?code   
	请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; &nbsp;说明    
	user &nbsp; &nbsp; User&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 是  &nbsp; &nbsp; &nbsp; &nbsp;用户类    
	code &nbsp;&nbsp; String&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; 是  &nbsp; &nbsp; &nbsp; &nbsp;验证码    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; number&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;String&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;状态信息   

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;注册成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;注册失败   
请求数据实例   
```
user{
	id:"001",
  	username:"小朋友",
  	dept:"幼儿园",
  	password:"123456",
  	sex:"男",
   }

code:"ABCD"
```   

返回数据实例

```
  {
	status:0,
	msg:"注册成功"
  }
```

	 
+ 验证码生成   
	请求地址   
	POST http://localhost:8989/api/pigeon/user/getImage?time   
	请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;说明    
	time &nbsp; &nbsp; number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;是  &nbsp; &nbsp; &nbsp;Math.random()    

	返回值     
	String    
	属性:"data:image/png;base64," + Base64Utils.encodeToString(byteArrayOutputStream.toByteArray());   
	类型:String      
	说明:验证码   

## 2. 签到
请求地址      
POST http://localhost:8989/api/pigeon/user/sign      
	请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	record &nbsp; &nbsp; Record&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;是  &nbsp; &nbsp; 签到记录类    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp; String&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   

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
        record.location:"昌元街道学院路160号西南大学荣昌校区"
        record.longitude:"27.0"
        recourd.latitude:"116.5"
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
POST http://localhost:8989/api/pigeon/user/changeInfo      
	请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	user &nbsp; &nbsp; User&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; 是  &nbsp; &nbsp; 修改用户    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;修改成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;修改失败   

请求数据实例   
```
User{
  	sex:"女"
        telNumber:"xxxxxxxxxxx"
        email:"xxx@xxx.com"
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
POST http://localhost:8989/api/pigeon/activity/submit      
	请求参数         
	属性 &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;类型 &nbsp; &nbsp;&nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	activity &nbsp; &nbsp; Activity&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp;是  &nbsp; &nbsp; 提交活动申请    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;Object&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;提交成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;提交失败   

请求数据实例   
```
Activity{
  	activityName:"请假",
        applicant:"001",
        approver:"002",
        startTime:"2020-11-19 09:07:34",
        endTime:"2020-11-19 09:07:35" 
   }
```
返回数据实例
```
  {
	status:0
	msg:"提交成功"
  }
```   
## 5. 查看用户活动
请求地址      
POST http://localhost:8989/api/pigeon/activity/find      
	请求参数         
	属性 &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;类型 &nbsp; &nbsp;&nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	&nbsp; id &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;String&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;是&nbsp;&nbsp; &nbsp; 当前的用户    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;String&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;查看成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 查看失败   

请求数据实例   
```
    null
```
返回数据实例
```
  {
	status:0
	msg:"提交成功"
        List<Activity>:{
                            xxx
                        }
  }
```   
## 6. 撤回活动
请求地址      
POST http://localhost:8989/api/pigeon/activity/backout      
	请求参数         
	属性 &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;类型 &nbsp; &nbsp;&nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; &nbsp; &nbsp; 说明    
	&nbsp; id &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; int&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 是   &nbsp;&nbsp; &nbsp; &nbsp; 点击的活动    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp; String &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;状态信息   

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;撤回成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;撤回失败   

请求数据实例   
```
    id:1
```
返回数据实例
```
  {
	status:0
	msg:"撤回成功"
  }
```   

## 7. 提交请假请求
请求地址      
POST http://localhost:8989/api/pigeon/leave/submit      
	请求参数         
	属性 &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;类型 &nbsp; &nbsp;&nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	leave &nbsp; &nbsp; Leave&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp;是  &nbsp; &nbsp; 提交请假申请    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp; String&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;提交成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 提交失败   

请求数据实例   
```
leave{
  	Reason:"事假",
        userId:"001",
        approveUser:"002",
        startTime:"2020-11-19 09:07:34",
        endTime:"2020-11-19 09:07:35" 
   }
```
返回数据实例
```
  {
	status:0
	msg:"提交成功"
  }
```   
## 8. 查看用户请假
请求地址      
POST http://localhost:8989/api/pigeon/leave/find      
	请求参数         
	属性 &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;类型 &nbsp; &nbsp;&nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明    
	userId &nbsp;&nbsp; &nbsp;String&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;是&nbsp;&nbsp; &nbsp; 当前的用户工号    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;String&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;查看成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 查看失败   

请求数据实例   
```
    null
```
返回数据实例
```
  {
	status:0
	msg:"提交成功"
        List<Leave>:{
                            xxx
                        }
  }
```   
## 9. 撤回请假
请求地址      
POST http://localhost:8989/api/pigeon/leave/back      
	请求参数         
	属性 &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;类型 &nbsp; &nbsp;&nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; &nbsp; &nbsp; 说明    
	&nbsp; id&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; int&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; 是   &nbsp;&nbsp; &nbsp; &nbsp; 点击的请假    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp; String &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;状态信息   

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;撤回成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;撤回失败   

请求数据实例   
```
    id:1
```
返回数据实例
```
  {
	status:0
	msg:"撤回成功"
  }
```   
## 10. 文件上传
请求地址      
POST http://localhost:8989/api/pigeon/upload/uploadFile      
	请求参数         
	属性 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;类型 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; &nbsp; &nbsp; 说明    
	multipartFile&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; MultipartFile&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; 是   &nbsp;&nbsp; &nbsp; &nbsp; 上传的文件   
	upload &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Upload &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;是&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 上传类

返回值     
	Result    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp; String &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;状态信息   

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	200&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;上传成功   
	404&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;上传失败   

请求数据实例   
```
    multipartFile:file
    upload{
            null
          }
```
返回数据实例
```
  {
	status:200
	msg:"上传成功"
  }
```   
#后端~后台管理系统


