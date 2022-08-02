#### 开发说明
```xml
<!--springboot的文档注解处理器，在pom.xml中填写配置，通过ConfigurationProperties注解读取到类中 见WxConfig-->
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
</dependency>
```
按照springboot开发模式正常开发，开发完成后，pom打包修改为maven打包，启动类可以删掉。

如果有注入容器的bean，则要在resources下新建 META-INF/spring.factories，
在此文件中按以下格式写入要注入的类，如果此项目中有依赖第三方插件，则在引用的项目中也要依赖
```yaml
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
com.wsj.wxnotice.interfaces.WxServiceApi,\
com.wsj.wxnotice.config.WxConfig,\
com.wsj.wxnotice.config.ApplicationUtil,\
com.wsj.wxnotice.config.RedisConfig
```
打包时去掉测试，把打包好的jar上传到阿里云仓库，使用阿里云仓库下载下来的settings.xml就可以正常使用jar 
https://packages.aliyun.com/

#### 使用说明
> wx.corpid=企业id
> 
> wx.corpsecret=应用密钥
> 
> spring.redis.host=
> 
> spring.redis.port=
> 
> spring.redis.database=
> 
> spring.redis.password=

