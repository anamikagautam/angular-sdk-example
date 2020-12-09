package org.ehrbase.angularsdkexample.config;

import org.ehrbase.client.openehrclient.OpenEhrClientConfig;
import org.ehrbase.client.openehrclient.defaultrestclient.DefaultRestClient;
import org.ehrbase.angularsdkexample.ExampleTemplateProvider;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.URI;

@Configuration
@ConfigurationProperties(prefix = "ehrbase")
public class ClientConfig implements InitializingBean {

    // config attributes from application.properties
    private int port;
    private InetAddress address;
    private String path;

    public ClientConfig() {

    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public InetAddress getAddress() {
        return address;
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    // client bean and its initialization
    private DefaultRestClient client;

    @Bean
    public DefaultRestClient getClient() {
        return client;
    }

    @Override   // runs automatically on Spring setup and sets up the SDK client class
    public void afterPropertiesSet() throws Exception {
        ExampleTemplateProvider templateProvider = new ExampleTemplateProvider();
        URI uri = new URI("http", null, address.getCanonicalHostName(), port, path, null, null);
        client = new DefaultRestClient(new OpenEhrClientConfig(uri), templateProvider);
        templateProvider.listTemplateIds().forEach(
                t -> client.templateEndpoint().ensureExistence(t)
        );
    }
}