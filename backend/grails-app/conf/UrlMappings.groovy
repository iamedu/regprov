class UrlMappings {

  static mappings = {
    "/api/auth/${action}" (controller: "apiAuth")

    "/$controller/$action?/$id?(.$format)?"{
      constraints {
        // apply constraints here
      }
    }

    "/"(view:"/index")
    "500"(view:'/error')
  }
}
