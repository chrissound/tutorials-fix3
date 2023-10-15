package com.baeldung.kafka.message.ordering;

import com.baeldung.kafka.message.ordering.payload.Message;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;

public class SinglePartitionProducer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "com.baeldung.kafka.message.ordering.serialization.JacksonSerializer");

        KafkaProducer<String, Message> producer = new KafkaProducer<>(props);
        for (long insertPosition = 1; insertPosition <= 10 ; insertPosition++) {
            long messageId = Message.getRandomMessageId();
            String key = "Key-" + insertPosition;
            Message message = new Message(insertPosition, messageId);
            producer.send(new ProducerRecord<>("single_partition_topic", key, message));
            System.out.println("Insert Position: " + message.getInsertPosition() + ", Message Id: " + message.getMessageId());
        }
        producer.close();
        System.out.println("SinglePartitionProducer Completed.");
    }

}
