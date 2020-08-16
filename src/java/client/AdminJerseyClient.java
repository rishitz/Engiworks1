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
 * Jersey REST client generated for REST resource:AdminGenericResource
 * [adminmastergeneric]<br>
 * USAGE:
 * <pre>
 *        AdminJerseyClient client = new AdminJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author sebatsian
 */
public class AdminJerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "https://localhost:8181/Engiworks1/webresources";

    public AdminJerseyClient(String token) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        client.register(new RestFilter(token));
        webTarget = client.target(BASE_URI).path("adminmastergeneric");
    }static {
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

    public void updateCity(Object requestEntity) throws ClientErrorException {
        webTarget.path("updateCity").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T UserGotjob(Class<T> responseType, String uid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("UserGotJob/{0}", new Object[]{uid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteJobSub(String jobcid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteJobSub/{0}", new Object[]{jobcid})).request().delete();
    }

    public <T> T getAllState(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllState");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllreview(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllreview");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteJob(String jid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("delete/{0}", new Object[]{jid})).request().delete();
    }

    public <T> T getAllcomment(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllcomment");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getJob(Class<T> responseType, String jid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getJobd/{0}", new Object[]{jid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteCity(String cid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteCity/{0}", new Object[]{cid})).request().delete();
    }

    public <T> T getAlljobSubCategory(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAlljobSubCategory");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getUserReview(Class<T> responseType, String uid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUserReview/{0}", new Object[]{uid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateReqStatus(String r, String s) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateReqStatus/{0}{1}", new Object[]{r, s})).request().post(null);
    }

    public void addState(String stateName) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addState/{0}", new Object[]{stateName})).request().post(null);
    }

    public String getJson() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public void deleteState(String sid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteState/{0}", new Object[]{sid})).request().delete();
    }

    public <T> T getCity(Class<T> responseType, String cid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCity/{0}", new Object[]{cid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllrequirementbid(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllrequirementbid");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateState(Object requestEntity) throws ClientErrorException {
        webTarget.path("updateState").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getUserPostedJob(Class<T> responseType, String uid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUserPostedJob/{0}", new Object[]{uid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAlljobCategory(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAlljobCategory");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateJob(Object requestEntity) throws ClientErrorException {
        webTarget.path("updateJob").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getUserComplaint(Class<T> responseType, String uid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUserComplaint/{0}", new Object[]{uid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getUserAppliedjob(Class<T> responseType, String uid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUserAppliedJob/{0}", new Object[]{uid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addJobSub(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void updateJobSub(Object requestEntity) throws ClientErrorException {
        webTarget.path("updateJobSub").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void addJob(String jobname) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addJob/{0}", new Object[]{jobname})).request().post(null);
    }

    public <T> T getAllUserData(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllusers");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getSpecificUserInfo(Class<T> responseType, String uid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getSpecificUserInfo/{0}", new Object[]{uid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addCity(Object requestEntity) throws ClientErrorException {
        webTarget.path("addCity").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void putJson(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getAllCityData(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllcity");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getState(Class<T> responseType, String sid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getState/{0}", new Object[]{sid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateStatus(String r, String s) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateStatus/{0}{1}", new Object[]{r, s})).request().post(null);
    }

    public <T> T getAllcomplaint(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllcomplaint");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllrequirement(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllrequirement");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getJobSub(Class<T> responseType, String jid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getJobSub/{0}", new Object[]{jid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getUserInfo(Class<T> responseType, String uid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUserInfo/{0}", new Object[]{uid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateCStatus(String r, String s) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateCStatus/{0}{1}", new Object[]{r, s})).request().post(null);
    }

    public void updateUStatus(String r, String s) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateUStatus/{0}{1}", new Object[]{r, s})).request().post(null);
    }

    public void close() {
        client.close();
    }
    
}
