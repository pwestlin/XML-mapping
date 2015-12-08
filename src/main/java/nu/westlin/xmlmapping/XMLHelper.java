package nu.westlin.xmlmapping;

import org.springframework.stereotype.Component;

import java.io.IOException;

import javax.inject.Inject;
import javax.xml.transform.Result;
import javax.xml.transform.Source;

import org.springframework.oxm.XmlMappingException;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Component
public class XMLHelper {

    @Inject
    private Jaxb2Marshaller marshaller;

    /**
     * Unmarshal a given source
     */
    public Object load(Source source) throws XmlMappingException, IOException {
        return marshaller.unmarshal(source);
    }

    /**
     * Marshal a given Object to a Result
     */
    public void save(Object obj, Result result) throws XmlMappingException, IOException {
        marshaller.marshal(obj, result);
    }

}
