package mx.gob.economia.regprov.api

import grails.converters.JSON

class ApiAuthController {

  def testing = {
    def test = [ prove: "Daniel" ]
    render test as JSON
  }

}
