/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author sebatsian
 */

@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "engi1_jndi",
        callerQuery = "select password from tbluser where userName = ?",
        groupsQuery = "select groupName from tbluser u,tblgroup g,tblusergroup ug where ug.userId = u.userId and ug.userGroupId = g.groupId and u.userName = ?",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        priority = 30
)

@ApplicationScoped
@Named
public class projectConfig {
    
}
