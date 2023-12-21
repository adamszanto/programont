Bitcoin Real-time Data App
Introduction
This Spring Boot application fetches real-time Bitcoin (BTC) exchange rate data from the Coinbase API. It utilizes MongoDB for data storage, Kafka for real-time event streaming, and Spring Boot for the backend. Postman can be used to interact with the exposed APIs.

Prerequisites
Make sure you have the following installed:

MongoDB
Kafka
Java Development Kit (JDK)
Maven
Postman
Kafka Setup
Start ZooKeeper service:

bash
Copy code
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
Start Kafka Broker Service:

bash
Copy code
.\bin\windows\kafka-server-start.bat .\config\server.properties
List Topics:

bash
Copy code
.\bin\windows\kafka-console-consumer.bat --topic BTCcoinDataConsumerTopic --from-beginning --bootstrap-server 127.0.0.1:9092
.\bin\windows\kafka-console-consumer.bat --topic BTCcoinDataProducerTopic --from-beginning --bootstrap-server 127.0.0.1:9092
Create Topics:

bash
Copy code
.\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --topic BTCcoinDataConsumerTopic 
.\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --topic ETHcoinDataConsumerTopic

.\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --topic BTCcoinDataConsumerTopic
.\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --topic BTCcoinDataProducerTopic
Console Producer:

bash
Copy code
.\bin\kafka-console-producer.sh --topic BTCcoinDataConsumerTopic --bootstrap-server localhost:9092
BTC Real-time API Calls
The application performs API calls to Coinbase to fetch Bitcoin exchange rate data. It fetches 10 real-life moments of BTC data per second.

Contributing
Feel free to contribute by opening issues or submitting pull requests.
