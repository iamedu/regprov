package mx.gob.economia.regprov.service

import org.forgerock.opendj.ldap.*
import mx.gob.economia.regprov.exception.*


class LdapService {

  def ldapConnectionPool
  def grailsApplication

  def checkUser(def userDn, def password) {
    def connection
    try {
      connection = ldapConnectionPool.connection
      def result = connection.bind(userDn, password)
      if(result.resultCode.isExceptional()) {
        throw new AppException(ErrorInfo.LDAP_ERROR, result.diagnosticMessage, result.cause)
      }
      result.isSuccess()
    } catch(Exception ex) {
      ex.printStackTrace()
    } finally {
      if(connection != null) {
        connection.close()
      }
    }
  }
}
