package com.currencyfair.service;

import com.currencyfair.model.MessageEntity;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.slf4j.Logger;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * @author Anton Konovchenko
 * @version 1.0.0
 */
public class MessageEncoder implements Encoder.Text<MessageEntity> {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(MessageEndpoint.class);

    @Override
    public void init(EndpointConfig ec) { }

    @Override
    public void destroy() { }

    @Override
    public String encode(MessageEntity message) throws EncodeException {
        StringWriter st = new StringWriter();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(MessageEntity.class);

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
            marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);
            marshaller.marshal(message, st);

        } catch (Exception e) {
            logger.error("", e);
        }
        return st.toString();
    }
}
