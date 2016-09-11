'use strict';

angular.module('frontendApp')
  .factory('authService', function ($q, $http, urlService) {
    return {
      testing: function() {
        var defer = $q.defer();
        $http.post(urlService.getBasePath() + '/api/auth/testing',{

        }).success(function (data){
          defer.resolve(data);
        }).error(function (data){
          defer.reject(data);
        });
        return defer.promise;
      }
    };
  });
