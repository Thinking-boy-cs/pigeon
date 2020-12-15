###webViewUtil接口说明
##概述
@JavascriptInterface是提供给JS的接口, 只需了解带此注释的接口功能即可
下面给出了给所有接口的所需参数以及功能, 以及创建和配置webViewUtil
* ###webVIew getWebView()
返回一个WebView
* ###WevSetting getSetting(WebView webView)
输入WebView, 返回WebSetting, 并对WebSetting做出相应的配置, 例如启用JS接口的操作
在此函数中提供给JS的接口为webViewUtil
```
webView.addJavascriptInterface(new webViewUtil(activity),"webViewUtil");
```
* ###void popInfo(String channelId, String channelName, int importance, String url, String title, String content)
弹出通知弹窗, 所需参数分别提供弹窗所需的 channelId, channelName, 弹窗优先级, 弹窗跳转Url, 弹窗title, 弹窗所含简要信息
* ###String getLocationInfo()
返回JSON格式数据 其中包含"Longitude" : Longitude "Latitude" : Latitude
* ###void TakePhoto()
开启相机, 不返回结果
* ###String getPhotoData()
返回base64格式的照片数据