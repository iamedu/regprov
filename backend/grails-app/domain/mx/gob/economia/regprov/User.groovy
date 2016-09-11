package mx.gob.economia.regprov

class User implements Serializable {
  String username
  String ldapDn

  static hasMany = [ roles: Role, permissions: String ]

  static constraints = {
    username nullable: false, blank: false, unique: true
  }

  static mapping = {

    table "USUARIO"

    username column: "USUARIO"
    ldapDn column: "LDAP_DN"

    roles joinTable: [ name: "USUARIO_ROL", key: "ID_USUARIO", column: "ID_ROL" ]
    permissions joinTable: [ name: "USUARIO_PERMISO", key: "ID_USUARIO", column: "PERMISO" ]

    id ( generator: "sequence", params: [ sequence: "USUARIO_SEQº" ] )

  }

}
