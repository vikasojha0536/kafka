# kafka

## Installing kafka
Follow https://www.geeksforgeeks.org/how-to-install-and-run-apache-kafka-on-windows/
or 
Zip folder is attached just unzip in the c:/ drive

## Running zookeeper
1) go to <installed dir>\kafka (If you are running on windows keep the installed folder in c drive)
2) Run command .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

## Run brokers
1) change the log.dirs in <installed dir>\kafka\config\server.properties with <installed dir>/kafka/kafka-logs
2) Run the command .\bin\windows\kafka-server-start.bat .\config\server.properties

## Run multiple brokers
1) Create multiple server.properties and changing broker.id,listeners=PLAINTEXT://:<Different port>,log.dirs.
2) Run the command .\bin\windows\kafka-server-start.bat .\config\<server properties file>

## Create a topic
1) .\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --create --topic my-topic --partitions 3 --replication-factor 3

## List the topics on broker server
.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list

## describe the partition
C:\Users\vojha\kafka>.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --describe topic my-topic
Topic: my-topic TopicId: Fgfbyq1gSYyHr3QE19MrKA PartitionCount: 3       ReplicationFactor: 3    Configs:
Topic: my-topic Partition: 0    Leader: 1       Replicas: 1,0,2 Isr: 1,0,2
Topic: my-topic Partition: 1    Leader: 0       Replicas: 0,2,1 Isr: 0,2,1
Topic: my-topic Partition: 2    Leader: 2       Replicas: 2,1,0 Isr: 2,1,0

## Delete the topic on broker server
.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --delete --topic my-topic

## Consume the events from the topic
.\bin\windows\kafka-console-consumer.bat --bootstrap-server <host_ip_of_producer>:9092 --topic my-topic --from-beginning

## Produce the events on the topic
.\bin\windows\kafka-console-producer.bat --bootstrap-server localhost:9092 --topic my-topic


## Kafka perf producer
.\bin\windows\kafka-producer-perf-test.bat --topic my-topic-1 --num-records 50 --record-size 1 --throughput 10 --producer-props bootstrap.servers=localhost:9092 key.serializer=org.apache.kafka.common.serialization.StringSerializer value.serializer=org.apache.kafka.common.serialization.StringSerializer

## Alter the partition
.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --alter --topic my-topic-3 --partition 4

## Notes
If we have 4 consumers in one consumer group with 3 partitions and listening to one topic one consumer will be idle
If we have 2 consumers in one consumer group with 4 partitions and listening to one topic both the consumers will listen to two partitions each