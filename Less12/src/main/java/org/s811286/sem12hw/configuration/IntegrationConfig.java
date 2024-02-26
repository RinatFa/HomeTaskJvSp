package org.s811286.sem12hw.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import java.io.File;

@EnableIntegration
@Configuration
public class IntegrationConfig {

    @Bean
    public MessageChannel textInputChanel() {
        return new DirectChannel();
    }

    @Bean
    @Transformer(inputChannel = "textInputChanel", outputChannel = "fileWriterChanel")
    public GenericTransformer<String, String> mainTransformer() {
        return text -> {
            //какая-то логика
            return text;
        };
    }

    @Bean
    public MessageChannel fileWriterChanel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "fileWriterChanel")
    public FileWritingMessageHandler messageHandler() {
        FileWritingMessageHandler handler =
                new FileWritingMessageHandler(new File(
                        //  "../files")); // на уровне наименования проекта
                        "files")); // на уровне папки /src/
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);
        return handler;
    }

    /**
     * Добавлен паттерн "Message Bus", использует @Bean textInputChanel
     * Вывод в файл производится на каждую первую команду "Send" в Postman,
     * вывод в консоль производится на каждую вторую команду
     * "Send" в Postman: POST localhost:8080/notes
     * {
     * "header": "note1",
     * "content": "text1"
     * }
     * Вывод в консоль:
     * Received massage: GenericMessage [payload=Note(id=null, header=note1,
     * content=text1, dateCreation=2024-02-26T22:23:04.130),
     * headers={replyChannel=nullChannel, errorChannel=,
     * id=52f0527d-e7f1-7cf3-fa16-67e6e48f28d1, file_name=note1.txt, timestamp=1708975384130}]
     */
    @ServiceActivator(inputChannel = "textInputChanel")
    @Bean
    public MessageHandler messageBusHandler() {
        return message -> System.out.println("Received massage: " + message);
    }
}
