package com.gestorinc.ws.util.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.validation.XmlValidator;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.xml.xsd.XsdSchemaCollection;

import static com.gestorinc.ws.util.Constants.*;

@EnableWs
@Configuration
public class WSConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, LOCATION_URI);
    }

    @Bean(name = "detailsWsdl")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchemaCollection xsdCollection) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(DETAILS_PORT);
        wsdl11Definition.setLocationUri(DETAILS_LOCATION_URI);
        wsdl11Definition.setTargetNamespace(NAMESPACE_URI);
        wsdl11Definition.setSchemaCollection(xsdCollection);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchemaCollection xsdCollection() {
        return new XsdSchemaCollection() {
            @Override
            public XmlValidator createValidator() {
                return null;
            }
            @Override
            public XsdSchema[] getXsdSchemas() {
                return new XsdSchema[]{studentSchema()};
            }
        };
    }

    @Bean
    public XsdSchema studentSchema() {
        return new SimpleXsdSchema(new ClassPathResource(STUDENT_XSD));
    }
}