## RocketMQ

* Topic
* Tag
* GroupName

## Download

[Apache RocketMQ](http://rocketmq.apache.org/release_notes/)

[RocketMQ Console](https://github.com/apache/rocketmq-externals/tree/master/rocketmq-console)

## Preview

![RocketMQ Console](../screenshots/RocketMQ%20Console.png)

## FAQ

1. org.apache.rocketmq.remoting.exception.RemotingConnectException:connect to failed.

add brokerIP1 to conf/broker.conf:

```
brokerClusterName = DefaultCluster
brokerName = broker-a
brokerId = 0
deleteWhen = 04
fileReservedTime = 48
brokerRole = ASYNC_MASTER
flushDiskType = ASYNC_FLUSH
brokerIP1 = `IP address of public network`
```

if not work, try to modify application.properties of rocketmq-console:

```
# rocketmq.config.namesrvAddr=localhost:9876
rocketmq.config.namesrvAddr=192.168.0.102:9876
```

2. org.apache.rocketmq.client.exception.MQClientException:no route info of this topic: xxx.

restart broker and use command:

```
$ nohup sh bin/mqbroker -n localhost:9876 autoCreateTopicEnable=true &
```