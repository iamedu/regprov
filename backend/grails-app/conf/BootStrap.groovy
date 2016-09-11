class BootStrap {

  def grailsApplication

  def init = { servletContext ->
    def serverIdentifier = UUID.randomUUID().toString()
    println "**** Server Identifier #${serverIdentifier}"
    grailsApplication.metadata.'serverIdentifier' = serverIdentifier
    grailsApplication.metadata.persist()
  }
  def destroy = {
  }
}
