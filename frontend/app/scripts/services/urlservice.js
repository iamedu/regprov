'use strict';

angular.module('frontendApp')
  .factory('urlService', function () {
    var unloggedUrls = [ '/', '/register' ];
    return {
      getUnloggedUrls: function () {
        return unloggedUrls;
      },
      getBasePath: function () {
        return '';
      }
    };
  });
