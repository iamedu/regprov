import org.forgerock.opendj.ldap.*
import org.apache.shiro.authc.credential.Sha256CredentialsMatcher

beans = {
  credentialMatcher(Sha256CredentialsMatcher) {
    storedCredentialsHexEncoded = false
      hashIterations = 1024
      hashSalted = true
  }
  ldapOptions(LDAPOptions) {
  }

  ldapConnectionFactory(LDAPConnectionFactory, application.config.regprov.ldap.host, application.config.regprov.ldap.port, ldapOptions) {
  }

  heartBeatLdapFactory(Connections, ldapConnectionFactory) { bean ->
    bean.factoryMethod = "newHeartBeatConnectionFactory"
  }

  ldapConnectionPool(Connections, heartBeatLdapFactory, 10) { bean ->
    bean.factoryMethod = "newFixedConnectionPool"
  }
}
