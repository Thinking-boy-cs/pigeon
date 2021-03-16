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
        homeTown:"重庆市"
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
POST http://localhost:8989/api/pigeon/application/submit      
	请求参数         
	属性 &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;类型 &nbsp; &nbsp;&nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	application &nbsp; &nbsp; Activity&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp;是  &nbsp; &nbsp; 提交活动申请    

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
POST http://localhost:8989/api/pigeon/application/find      
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
POST http://localhost:8989/api/pigeon/application/backout      
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
    data&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp; Upload &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp; 文件
    
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
        data:upload
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
    data&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp; Upload &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp; 文件
    
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
        data:upload
  }
```   
#后端~后台管理系统
## 一、员工信息的增删改查
### 1. 添加员工信息
请求地址      
POST http://localhost:8989/api/pigeon/govern/addUser      
	请求参数         
	属性 &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;类型 &nbsp; &nbsp;&nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	user &nbsp; &nbsp; User&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 是&nbsp; &nbsp; 添加的员工信息    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;Object&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;添加成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;添加失败   

请求数据实例   
```
user{
  	id:"001",
      	username:"小朋友",
      	dept:"幼儿园",
      	password:"123456",
      	sex:"男",
   }
```
返回数据实例
```
  {
	status:0
	msg:"提交成功"
  }
```   
### 2. 修改员工信息
请求地址      
POST http://localhost:8989/api/pigeon/govern/updateUser      
	请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	user &nbsp; &nbsp; User &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; 是  &nbsp; &nbsp; 修改用户    

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
        homeTown:"重庆市"
   }
```
返回数据实例
```
  {
	status:0
	msg:"修改成功"
  }
```   
### 3. 查询员工信息（全部）
请求地址      
POST http://localhost:8989/api/pigeon/govern/findUser      

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   
	data &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;List\<User>&nbsp; &nbsp;所有员工对象

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;查询成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;查询失败   

返回数据实例
```
  {
	status:0
	msg:"查询成功"
        data:[{xxx},{xxx}...]
  }
```   
### 4. 查询员工信息（特定）
请求地址      
POST http://localhost:8989/api/pigeon/govern/queryUser      
	请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	userId &nbsp;String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; 是  &nbsp; &nbsp; 查询用户    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   
	data&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp; User &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;特定用户   

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;查询成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;查询失败   

请求数据实例   
```
userId:"xxxxxxx"
```
返回数据实例
```
  {
	status:0
	msg:"查询成功"
        data:{...}
  }
```   
### 5. 删除员工信息
请求地址      
POST http://localhost:8989/api/pigeon/govern/deleteUser      
	请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	userId &nbsp;String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; 是  &nbsp; &nbsp; 删除用户    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;删除成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;删除失败   

请求数据实例   
```
userId:"xxxxxxx"
```
返回数据实例
```
  {
	status:0
	msg:"删除成功"
  }
```   
### 6. 某日已签到记录
请求地址      
POST http://localhost:8989/api/pigeon/govern/findSigned      
	请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	companyId String &nbsp; &nbsp;  &nbsp; &nbsp;  &nbsp; &nbsp;  是 &nbsp; &nbsp;  &nbsp; &nbsp;  企业号  
	theTime &nbsp;Date &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; 是  &nbsp; &nbsp; 指定日期    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   
	data &nbsp; &nbsp; &nbsp; &nbsp;List\<Record> &nbsp; 签到记录

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;查询成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;查询失败   

请求数据实例   
```
companyId:"123456"
theTime:"xxxxxxx"
```
返回数据实例
```
  {
	status:0
	msg:"查询成功"
        data:[{xxx},{xxx},....]
  }
```   
### 7. 某日未签到记录
请求地址      
POST http://localhost:8989/api/pigeon/govern/findUnSigned      
	请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明  
    companyId String &nbsp; &nbsp;  &nbsp; &nbsp;  &nbsp; &nbsp;  是 &nbsp; &nbsp;  &nbsp; &nbsp;  企业号  
	theTime &nbsp;Date &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; 是  &nbsp; &nbsp; 指定日期    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   
	data &nbsp; &nbsp; &nbsp; &nbsp; List\<User> &nbsp; &nbsp; 签到记录

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;查询成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;查询失败   

请求数据实例   
```
companyId:"123456"
theTime:"xxxxxxx"
```
返回数据实例
```
  {
	status:0
	msg:"查询成功"
        data:[{xxx},{xxx},....]
  }
```   
### 7.2. 某日未签到/签到记录综合
请求地址      
POST http://localhost:8989/api/pigeon/govern/queryAll    
	请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明  
    companyId String &nbsp; &nbsp;  &nbsp; &nbsp;  &nbsp; &nbsp;  是 &nbsp; &nbsp;  &nbsp; &nbsp;  企业号  
	theTime &nbsp;Date &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; 是  &nbsp; &nbsp; 指定日期    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   
	data &nbsp; &nbsp; &nbsp; &nbsp; List\<User> &nbsp; &nbsp; 签到记录

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;查询成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;查询失败   

请求数据实例   
```
companyId:"123456"
theTime:"xxxxxxx"
```
返回数据实例
```
  {
	status:0
	msg:"查询成功"
        data:[{xxx},{xxx},....]
  }
```   
### 8. 某日请假记录
请求地址      
POST http://localhost:8989/api/pigeon/govern/findLeaved      
	请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	companyId String &nbsp; &nbsp;  &nbsp; &nbsp;  &nbsp; &nbsp;  是 &nbsp; &nbsp;  &nbsp; &nbsp;  企业号     
	theTime &nbsp;Date &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; 是  &nbsp; &nbsp; 指定日期    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   
	data &nbsp; &nbsp; &nbsp; &nbsp;List\<Leave> &nbsp; 签到记录

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;查询成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;查询失败   

请求数据实例   
```
companyId:"123456"
theTime:"xxxxxxx"
```
返回数据实例
```
  {
	status:0
	msg:"查询成功"
        data:[{xxx},{xxx},....]
  }
```   
### 9. 某日已签到人数
请求地址      
POST http://localhost:8989/api/pigeon/govern/countSigned      
	请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	date &nbsp;Date &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; 是  &nbsp; &nbsp; 指定日期    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   
	data &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; int &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 签到记录

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;查询成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;查询失败   

请求数据实例   
```
date:"xxxxxxx"
```
返回数据实例
```
  {
	status:0
	msg:"查询成功"
        data:20
  }
```   
### 9. 某日未签到人数
请求地址      
POST http://localhost:8989/api/pigeon/govern/countUnsigned      
	请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	date &nbsp;Date &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; 是  &nbsp; &nbsp; 指定日期    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   
	data &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; int &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 签到记录

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;查询成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;查询失败   

请求数据实例   
```
date:"xxxxxxx"
```
返回数据实例
```
  {
	status:0
	msg:"查询成功"
        data:20
  }
```   
### 10. 某日请假人数
请求地址      
POST http://localhost:8989/api/pigeon/govern/countLeaved      
	请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	date &nbsp;Date &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; 是  &nbsp; &nbsp; 指定日期    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   
	data &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; int &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 签到记录

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;查询成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;查询失败   

请求数据实例   
```
date:"xxxxxxx"
```
返回数据实例
```
  {
	status:0
	msg:"查询成功"
        data:20
  }
```   
### 11. 各个部门员工人数统计可视化
请求地址      
POST http://localhost:8989/api/pigeon/view/dept_userNumber      
	请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	companyId &nbsp;String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; 是  &nbsp; &nbsp; 指定公司    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   
	data &nbsp; &nbsp;List\<StatCount>&nbsp; 统计记录

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;查询成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;查询失败   

请求数据实例   
```
companyId:"xxxxxxx"
```
返回数据实例
```
  {
	status:0
	msg:"查询成功"
        data:[{xxx},{xxx},...]
  }
```   
### 12. 公司男女情况人数统计可视化
请求地址      
POST http://localhost:8989/api/pigeon/view/sex_userNumber      
	请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	companyId &nbsp;String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; 是  &nbsp; &nbsp; 指定公司    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   
	data &nbsp; &nbsp;List\<StatCount>&nbsp; 统计记录

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;查询成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;查询失败   

请求数据实例   
```
companyId:"xxxxxxx"
```
返回数据实例
```
  {
	status:0
	msg:"查询成功"
        data:[{xxx},{xxx},...]
  }
```   
### 13. 公司员工家乡情况人数统计可视化
请求地址      
POST http://localhost:8989/api/pigeon/view/hometown_userNumber      
	请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	companyId &nbsp;String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; 是  &nbsp; &nbsp; 指定公司    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   
	data &nbsp; &nbsp;List\<StatCount>&nbsp; 统计记录

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;查询成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;查询失败   

请求数据实例   
```
companyId:"xxxxxxx"
```
返回数据实例
```
  {
	status:0
	msg:"查询成功"
        data:[{xxx},{xxx},...]
  }
```   
### 14. 员工薪资情况人数统计可视化
请求地址      
POST http://localhost:8989/api/pigeon/view/salary_userNumber      
	请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	companyId &nbsp;String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; 是  &nbsp; &nbsp; 指定公司    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   
	data &nbsp; &nbsp;List\<StatCount>&nbsp; 统计记录

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;查询成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;查询失败   

请求数据实例   
```
companyId:"xxxxxxx"
```
返回数据实例
```
  {
	status:0
	msg:"查询成功"
        data:[{xxx},{xxx},...]
  }
```   
### 15. 员工在离职情况人数统计可视化
请求地址      
POST http://localhost:8989/api/pigeon/view/status_userNumber      
	请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	companyId &nbsp;String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;是  &nbsp; &nbsp; 指定公司    
	time1 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Date &nbsp; &nbsp; &nbsp; &nbsp; 是 &nbsp; &nbsp; &nbsp; 指定日期1   
    time2 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Date &nbsp; &nbsp; &nbsp; &nbsp; 是 &nbsp; &nbsp; &nbsp; 指定日期2

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   
	data &nbsp; &nbsp;List\<StatCount>&nbsp; 统计记录

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;查询成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;查询失败   

请求数据实例   
```
companyId:"xxxxxxx"
time1:"xx:xx:xx"
time2:"xx:xx:xx"
```
返回数据实例
```
  {
	status:0
	msg:"查询成功"
        data:[{xxx},{xxx},...]
  }
```   
### 16. 审核员工在职
请求地址      
POST http://localhost:8989/api/pigeon/govern/letStatusOn      
	请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	id &nbsp; &nbsp; &nbsp; &nbsp; String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;是  &nbsp; &nbsp; 指定用户    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;审核成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;审核失败   

请求数据实例   
```
id:"xxxxxxx"
```
返回数据实例
```
  {
	status:0
	msg:"审核成功"
  }
```   
### 17. 审核员工离职
请求地址      
POST http://localhost:8989/api/pigeon/govern/letStatusOff      
	请求参数         
	属性 &nbsp; &nbsp; 类型 &nbsp; &nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; 说明    
	id &nbsp; &nbsp; &nbsp; &nbsp; String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;是  &nbsp; &nbsp; 指定用户    

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;审核成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;审核失败   

请求数据实例   
```
id:"xxxxxxx"
```
返回数据实例
```
  {
	status:0
	msg:"审核成功"
  }
```   
#后端~其他
## 1. 插入company表（管理员操作）
请求地址      
POST http://localhost:8989/api/pigeon/company/addCompany      
	请求参数         
	属性 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;类型 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; &nbsp; &nbsp; 说明    
	company&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Company&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; 是   &nbsp;&nbsp; &nbsp; &nbsp; 公司对象   

返回值     
	Map<String,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp; String &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;状态信息   
    
status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;插入成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;插入失败   

请求数据实例   
```
    company:{
            id:"xxx"
            name:"xxx"
            userId:"xxx"
            }
```
返回数据实例
```
  {
	status:0
	msg:"插入成功"
  }
```   
## 2. 插入group表（管理员操作）
请求地址      
POST http://localhost:8989/api/pigeon/group/addGroup      
	请求参数         
	属性 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;类型 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; &nbsp; &nbsp; 说明    
	group&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Group&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 是   &nbsp;&nbsp; &nbsp; &nbsp; group对象   

返回值     
	Map<String,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp; String &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;状态信息   
    
status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;插入成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;插入失败   

请求数据实例   
```
     group:{
            id:"xxx"
            name:"xxx"
            parentId:"xxx"
            companyId:"xxx"
            }
```
返回数据实例
```
  {
	status:0
	msg:"插入成功"
  }
```   
## 3. 插入user_group表（管理员操作）（有问题，还没写先占个位）
请求地址      
POST http://localhost:8989/api/pigeon/group/addUser_group      
	请求参数         
	属性 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;类型 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; &nbsp; &nbsp; 说明    
	group&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Group&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 是   &nbsp;&nbsp; &nbsp; &nbsp; group对象   

返回值     
	Map<String,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp; String &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;状态信息   
    
status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;插入成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;插入失败   

请求数据实例   
```
     group:{
            id:"xxx"
            name:"xxx"
            parentId:"xxx"
            companyId:"xxx"
            }
```
返回数据实例
```
  {
	status:0
	msg:"插入成功"
  }
```   
## 4. 给定group的id返回包含“组内所有人的列表“的响应对象
请求地址      
POST http://localhost:8989/api/pigeon/group/findUserByGroupId     
	请求参数         
	属性 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;类型 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; &nbsp; &nbsp; 说明    
	groupId&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; String&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 是   &nbsp;&nbsp; &nbsp; &nbsp; groupId   

返回值     
	Map<String,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp; String &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;状态信息   
    
status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;查看成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;查看失败   

请求数据实例   
```
     groupId:"xxx"
```
返回数据实例
```
  {
        status:0
        msg:"查看成功"
            data:{
                 user:{
                       xxx
                       }
                 }
  }
```   
## 5. 给定一个人的id返回包含“他所属的所有组的id的列表”的响应对象
请求地址      
POST http://localhost:8989/api/pigeon/group/findGroupId   
	请求参数         
	属性 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;类型 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; &nbsp; &nbsp; 说明    
	userId&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; String&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 是   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; userId   

返回值     
	Map<String,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp; String &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;状态信息   
    
status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;查看成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;查看失败   

请求数据实例   
```
     userId:"xxx"
```
返回数据实例
```
  {
	status:0
    	msg:"查看成功"
            data:{
                 List<String> groupId
                 }
  }
```   
## 6. 给定一个人的id返回包含“他所属的所有组的对象的列表”的响应对象
请求地址      
POST http://localhost:8989/api/pigeon/group/findGroupObject   
	请求参数         
	属性 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;类型 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; &nbsp; &nbsp; 说明    
	userId&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; String&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 是   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;

返回值     
	Map<String,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp; String &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;状态信息   
    
status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;查看成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;查看失败   

请求数据实例   
```
     userId:"xxx"
```
返回数据实例
```
  {
	status:0
	msg:"查看成功"
        data:{
             group:{
                   id:"xxx"
                   name:"xxx"
                   parentId:"xxx"
                   companyId:"xxx"
                   }
             }
  }
```   
### 7. 请求加速短信验证码
请求地址      
POST http://localhost:8989/api/pigeon/user/sendSMS      

返回值     
	Map<int,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;String &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;状态信息   

status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;查询成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;查询失败   

返回数据实例
```
  {
	status:0
	msg:"发送成功"
        smsCode:"660804"
  }
```   
### 8. 支付宝沙箱接口
请求地址
POST http://localhost:8989/api/pigeon/Alipay/PayPage

请求参数         
	属性 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;类型 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 默认值 &nbsp; &nbsp; 必填 &nbsp; &nbsp; &nbsp; &nbsp; 说明    
	userId&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; String&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 是   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; userId   

返回值     
	Map<String,Object>    
	属性	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;类型&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	status&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;状态码   
	msg&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp; String &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;状态信息   
    
status的合法值   
	值&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;说明   
	0&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;支付成功   
	1&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;支付失败   

请求数据实例   
```
     
```
返回数据实例
```
  {
	
  }
```   