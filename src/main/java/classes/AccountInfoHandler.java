package classes;

import classes.model.AccountInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
public class AccountInfoHandler implements MessageBodyReader<AccountInfo> {

    @Inject
    ObjectMapper objectMapper;

    public boolean isReadable(Class<?> type, Type genericType,
                              Annotation[] annotations, MediaType mediaType) {
        return AccountInfo.class.isAssignableFrom(type);
    }

    public AccountInfo readFrom(Class<AccountInfo> type, Type genericType,
                                Annotation[] annotations, MediaType mediaType,
                                MultivaluedMap<String, String> httpHeaders,
                                InputStream entityStream)
            throws IOException, WebApplicationException {
        AccountInfo accountInfo = objectMapper.readValue(entityStream, type);
        accountInfo.accountId = httpHeaders.getFirst("x-id");
        return accountInfo;
    }

}
