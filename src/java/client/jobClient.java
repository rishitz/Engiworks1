/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:userResource [generic]<br>
 * USAGE:
 * <pre>
 *        jobClient client = new jobClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author sebatsian
 */
public class jobClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "https://localhost:8181/Engiworks1/webresources";

    public jobClient(String token) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        client.register(new RestFilter(token));
        webTarget = client.target(BASE_URI).path("generic");
    }
    static {
        //for localhost testing only
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
                new javax.net.ssl.HostnameVerifier() {

            public boolean verify(String hostname,
                    javax.net.ssl.SSLSession sslSession) {
                if (hostname.equals("localhost")) {
                    return true;
                }
                return false;
            }
        });
    }

    public <T> T Viemore(Class<T> responseType, String rid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getJob/{0}", new Object[]{rid}));
        return resource.request().get(responseType);
    }

    public <T> T bidcheck(Class<T> responseType, String uid, String rid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getbidcheck/{0}/{1}", new Object[]{uid, rid}));
        return resource.request().get(responseType);
    }

    public <T> T getUser(Class<T> responseType, String userName) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUser/{0}", new Object[]{userName}));
        return resource.request().get(responseType);
    }

    public void updateUser(Object requestEntity) throws ClientErrorException {
        webTarget.path("updateUser").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void addJob(Object requestEntity) throws ClientErrorException {
        webTarget.path("addJob").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void addBid(Object requestEntity) throws ClientErrorException {
        webTarget.path("addBid").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void putJson(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void addAchivement(String uid, String attachment, String title, String description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addAchivement/{0}/{1}/{2}/{3}", new Object[]{uid, attachment, title, description})).request().post(null);
    }

    public <T> T getuserJob(Class<T> responseType, String uid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUserJob/{0}", new Object[]{uid}));
        return resource.request().get(responseType);
    }

    public <T> T alljob(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllJob");
        return resource.request().get(responseType);
    }

    public <T> T getUserdetails(Class<T> responseType, String uid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getuser/{0}", new Object[]{uid}));
        return resource.request().get(responseType);
    }

    public String getJson() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public <T> T homeJob(Class<T> responseType, String uid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("gethomeJob/{0}", new Object[]{uid}));
        return resource.request().get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
