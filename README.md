# Message-Queue-Integration

[![Build Status](https://travis-ci.org/coderqianlq/message-queue-integration.svg?branch=master)](https://travis-ci.org/github/coderqianlq/message-queue-integration)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Coverage Status](https://coveralls.io/repos/github/coderqianlq/message-queue-integration/badge.svg)](https://coveralls.io/github/coderqianlq/message-queue-integration)

## Table of Contents

* [Components](#components)
* [Getting Started](#getting-started)
* [Preview](#preview)
* [Dependency Chart](#dependency-chart)
* [Todo List](#todo-list)
* [License](#license)

## Components

- [x] [RabbitMQ](message-queue-rabbitmq)
- [x] [ActiveMQ](message-queue-activemq)
- [x] [RocketMQ](message-queue-rocketmq)
- [x] [Kafka](message-queue-kafka)

## Getting Started

First download and install the message queue service on your computer, and the download link has been written in the readme of each submodule. For example, click the [link](message-queue-kafka/README.md#download) to download kafka.

Then you can start the message queue service according to the online tutorial. For example, you can use rabbitmq-server to start rabbitmq service: 

```yaml
$ rabbitmq-server

  ##  ##      RabbitMQ 3.8.3
  ##  ##
  ##########  Copyright (c) 2007-2020 Pivotal Software, Inc.
  ######  ##
  ##########  Licensed under the MPL 1.1. Website: https://rabbitmq.com

  Doc guides: https://rabbitmq.com/documentation.html
  Support:    https://rabbitmq.com/contact.html
  Tutorials:  https://rabbitmq.com/getstarted.html
  Monitoring: https://rabbitmq.com/monitoring.html

  Logs: /usr/local/var/log/rabbitmq/rabbit@localhost.log
        /usr/local/var/log/rabbitmq/rabbit@localhost_upgrade.log

  Config file(s): (none)

  Starting broker... completed with 6 plugins.
```

Finally, you can start the services or run test case in this project.

Please note that if you find it very troublesome to install each message queue services separately, you can install and start them through docker-compose.

## Preview

* Sting Boot Admin Wallboard
![Admin Wallboard](screenshots/Sprin%20Boot%20Admin%20Wallboard.png)

* Sting Boot Admin Detail
![Admin Detail](screenshots/Spring%20Boot%20Admin%20Detail.png)

* Sting Boot Admin Threads
![Admin Threads](screenshots/Spring%20Boot%20Admin%20Threads.png)

* Sting Boot Admin Logfile
![Admin Logfile](screenshots/Spring%20Boot%20Admin%20Logfile.png)

## Dependency Chart

| Spring Boot | Spring Boot Admin | Swagger | RabbitMQ | ActiveMQ | RocketMQ | Kafka |
| :---------: | :---------------: | :-----: | :------: | :------: | :------: | :---: |
|    2.1.5    |       2.1.6       |  2.7.0  |  2.1.5   |  2.1.5   |   4.7.0  | 2.2.6 |

## Todo List
- [ ] Add readmes to submodule
- [ ] Add usage in complex scenarios

## License

[MIT](LICENSE) © CoderQian