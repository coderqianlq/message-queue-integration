## ActiveMQ

## Download

[ActiveMQ](http://activemq.apache.org/download-archives.html)

## Preview

![ActiveMQ Client](./screenshots/ActiveMQ%20Client.png)

## FAQ

1. Failed to build body from content. Serializable class not available to broker. Reason: java.lang.ClassNotFoundException: Forbidden class com.qianlq.core.model.dto.MessageDTO! This class is not trusted to be serialized as ObjectMessage payload. Please take a look at http://activemq.apache.org/objectmessage.html for more information on how to configure trusted classes.

refer to the link, here we use the method of using ActiveMQConnectionFactory:

```java
@Bean
public ActiveMQConnectionFactory connectionFactory() {
    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, brokerUrl);
    connectionFactory.setTrustedPackages(new ArrayList(Arrays.asList("com.qianlq.core.model.dto")));
    return connectionFactory;
}
```