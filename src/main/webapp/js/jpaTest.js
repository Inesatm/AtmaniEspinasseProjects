var jpaApp = angular.module('jpa', ['ngResource']);


jpaApp.config(['$resourceProvider', function ($resourceProvider) {
    $resourceProvider.defaults.stripTrailingSlashes = false;
}]);

jpaApp.factory('JpaService', ['$resource', '$http', function ($resource, $http) {

    return {
      
        createPerson: function (val) {
            console.log(val);
            return $http({
                url: '/rest/person?firstName='+val[0]+'&lastName='+val[1]+'&email='+val[2],
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
            });

        },
        getHomeInfos:
            $resource('/rest/home/', {}, {
                query: { method: 'GET', params: {}, isArray: true }
            }),
        getPersonInfos: function (uri) {
            return $resource(uri, {}, {
                query: { method: 'GET', params: {}, isArray: true }
            })
        },

    }
}]);


jpaApp.controller('jpaForm', ['$scope', '$log', '$http', '$rootScope', 'JpaService', function ($scope, $log, $http, $rootScope, JpaService) {
    $scope.displayPersonInfos = function () {
        $rootScope.$emit("getPerson", {});
    };


    $scope.createPerson = function () {
        $scope.personlastName = $('#lastName')[0].value;
        $scope.personfirstName = $('#firstName')[0].value;
        $scope.personEmail = $('#email')[0].value;
        var val = [$scope.personlastName, $scope.personfirstName, $scope.personEmail];
        JpaService.createPerson(val);
    };

    JpaService.getHomeInfos.query().$promise.then(function (data) {
        console.log(data);
        $scope.homes = data;
    });

}]);

jpaApp.controller('jpaInfo', ['$scope', '$resource', '$rootScope', 'JpaService', function ($scope, $resource, $rootScope, JpaService) {
    $rootScope.$on("getPerson", function () {
        JpaService.getPersonInfos('/rest/person/').query().$promise.then(function (data) {
            $scope.persons = data;
        }, function (reason) {
            alert('Erreur');
        });
    });
    
}]);