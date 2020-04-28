## Kafka

* Broker 节点
* Topic 主题
* Partition 分区
* Partition offset 偏移量
* Consumer Group 消费者组
* Message 消息

## Download

* Kafka server

by `homebrew` 
```shell script
$ brew install kafka
```

or by [kafka website](http://kafka.apache.org/downloads) 

* The visual client for kafka

[Kafka Tool](http://www.kafkatool.com/download.html)

## Preview

![RocketMQ Console](./screenshots/Kafka%20Tool.png)

## Attention

if you use docker-compose to start kafka server, first add you local ip address to [docker-compose.yml](docker-compose.yml):

```yaml
version: '2'
services:
  kafka:
    environment:
      KAFKA_ADVERTISED_HOST_NAME: ${IP} # Use ifconfig command to view ip
``` 

## FAQ

1. how to check your local ip address:

```
$ ifconfg
...
en0: flags=8863<UP,BROADCAST,SMART,RUNNING,SIMPLEX,MULTICAST> mtu 1500
	options=400<CHANNEL_IO>
	ether 8c:85:90:b0:17:c3
	inet6 fe80::1870:9add:88ab:5a06%en0 prefixlen 64 secured scopeid 0x7
	inet 192.168.1.3 netmask 0xffffff00 broadcast 192.168.1.255
	inet6 240e:390:e5e:92c0:143e:c773:8842:95cb prefixlen 64 autoconf secured
	inet6 240e:390:e5e:92c0:e473:817:c1eb:b660 prefixlen 64 autoconf temporary
	nd6 options=201<PERFORMNUD,DAD>
	media: autoselect
	status: active
...
```

add `192.168.1.3` to [docker-compose.yml](docker-compose.yml):

```yaml
version: '2'
services:
  kafka:
    environment:
      KAFKA_ADVERTISED_HOST_NAME: 192.168.1.3
```
