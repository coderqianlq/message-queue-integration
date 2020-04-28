## RabbitMQ

## Download

[RabbitMQ](https://www.rabbitmq.com/download.html)

## Preview

![RabbitMQ Overview](screenshots/RabbitMQ%20Overview.png)

![RabbitMQ Exchanges](screenshots/RabbitMQ%20Exchanges.png)

![RabbitMQ Queues](screenshots/RabbitMQ%20Queues.png)

## FAQ

1. if you use docker-compose to start rabbitmq, but you get connection refused error when you start project, try to change rabbitmq host in application.yml:

```yaml
spring:
  rabbitmq:
    host: 127.0.0.1 -> ${IP}
```

[how to check your local ip address?](../message-queue-kafka/README.md#faq)
