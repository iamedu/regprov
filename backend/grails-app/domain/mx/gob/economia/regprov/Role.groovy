package mx.gob.economia.regprov

class Role implements Serializable {
  String name

  Date dateCreated
  Date lastUpdated

  static hasMany = [ permissions: String ]

  static constraints = {
    name nullable: false, blank: false, unique: true
  }

  static mapping = {

    table "ROL"

    name column: "NOMBRE"

    permissions joinTable: [ name: "ROL_PERMISO", key: "ID_ROL", column: "PERMISO" ]

    id ( generator: "sequence", params: [ sequence: "ROL_SEQº" ] )

  }
}
