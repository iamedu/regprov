package mx.gob.economia.regprov.exception

enum ErrorSeverity {
		UNKNOWN,
		FATAL,
		ERROR,
		WARNING,
		INFO,
		DEBUG
}

enum ErrorOrigin {
		UNKNOWN,
		WEBAPP,
		DOCUMENT,
		BPM,
		DATABASE,
    LDAP,
    TASK
}

class ErrorInfo {

	static final List<ErrorInfo> errorInfoList = new ArrayList<ErrorInfo>();

  public static final ErrorInfo XSRF_ERROR =
			new ErrorInfo("XSRF_ERROR", """\
  Ocurrió un error al validar el token de xsrf""",
				ErrorSeverity.DEBUG,
        ErrorOrigin.WEBAPP)
    public static final ErrorInfo XAUTH_ERROR =
      new ErrorInfo("XAUTH_ERROR", """\
  Ocurrió un error al validar el token de X-Auth""",
        ErrorSeverity.DEBUG,
        ErrorOrigin.WEBAPP)
		public static final ErrorInfo SESSION_ERROR =
			new ErrorInfo("SESSION_ERROR", """\
El usuario no tiene sesion en el sistema""",
				ErrorSeverity.DEBUG,
        ErrorOrigin.WEBAPP)
		public static final ErrorInfo UNKNOWN_USER =
			new ErrorInfo("UNKNOWN_USER", """\
El usuario especificado no existe en el sistema""",
				ErrorSeverity.DEBUG,
        ErrorOrigin.WEBAPP)
		public static final ErrorInfo UNKNOWN_TOKEN =
			new ErrorInfo("UNKNOWN_TOKEN", """\
El token especificado no existe en el sistema""",
				ErrorSeverity.WARNING,
        ErrorOrigin.WEBAPP)
		public static final ErrorInfo XSRF_ATTACK_ERROR =
			new ErrorInfo("XSRF_ATTACK_ERROR", """\
Hay posibilidades de un ataque de XSRF ocurriendo al servidor""",
				ErrorSeverity.WARNING,
        ErrorOrigin.WEBAPP)
		public static final ErrorInfo AUTHORIZATION_ERROR =
			new ErrorInfo("AUTHORIZATION_ERROR", """\
El usuario no tiene permiso de ejecutar la acción requerida""",
				ErrorSeverity.INFO,
        ErrorOrigin.WEBAPP)
		public static final ErrorInfo DATABASE_ERROR =
			new ErrorInfo("DATABASE_ERROR", """\
Ha ocurrido un error de acceso a datos, es posible que el servicio en general se vea afectado.""",
				ErrorSeverity.FATAL,
        ErrorOrigin.DATABASE)
		public static final ErrorInfo MALFORMED_REQUEST_ERROR =
			new ErrorInfo("MALFORMED_REQUEST_ERROR", """\
La petición enviada por el usuario es diferente a lo que requiere la aplicación""",
				ErrorSeverity.DEBUG,
        ErrorOrigin.WEBAPP)
		public static final ErrorInfo TOKEN_ERROR =
			new ErrorInfo("TOKEN_ERROR", """\
No fue posible generar un token para el usuario""",
				ErrorSeverity.INFO,
        ErrorOrigin.DATABASE)
		public static final ErrorInfo PARAM_ERROR =
			new ErrorInfo("PARAM_ERROR", """\
Alguno de los parametros de la URL es incorrecto""",
				ErrorSeverity.INFO,
        ErrorOrigin.WEBAPP)
		public static final ErrorInfo UNKNOWN_ERROR =
			new ErrorInfo("UNKNOWN_ERROR", """\
Ha ocurrido un error que no fue detectado en tiempo de desarrollo, y por lo tanto no está manejado""",
				ErrorSeverity.FATAL,
        ErrorOrigin.UNKNOWN)
		public static final ErrorInfo REGISTRATION_ERROR =
			new ErrorInfo("REGISTRATION_ERROR", """\
Ha ocurrido un error con el usuario.""",
				ErrorSeverity.WARNING,
		ErrorOrigin.WEBAPP)

		public static final ErrorInfo LDAP_ERROR =
			new ErrorInfo("LDAP_ERROR", """\
Ha ocurrido un error grave alconectarse con LDAP""",
				ErrorSeverity.FATAL,
        ErrorOrigin.LDAP)
		public static final ErrorInfo LDAP_NOT_FOUND =
			new ErrorInfo("LDAP_NOT_FOUND", """\
El usuario especificado no existe en LDAP""",
				ErrorSeverity.WARNING,
        ErrorOrigin.LDAP)

		String errorId
		String description
		ErrorSeverity severity
		ErrorOrigin origin

		public ErrorInfo(String errorId, String description, ErrorSeverity severity, ErrorOrigin origin) {
			this.errorId = errorId
			this.description = description
			this.severity = severity
			this.origin = origin

      errorInfoList.add(this)
		}
}
