var jpaApp = angular.module('jpa', ['ngResource']);


jpaApp.config(['$resourceProvider', function ($resourceProvider) {
    $resourceProvider.defaults.stripTrailingSlashes = false;
}]);

jpaApp.factory('JpaService', ['$resource', '$http', function ($resource, $http) {

    return {
        createHeater: function (val) {
            console.log(val);
            return $http({
                url: '/rest/API/heater?name='+val[0]+'&conso='+val[1]+'&home='+val[2],
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
            });

        },
        createPerson: function (val) {
            console.log(val);
            return $http({
                url: '/rest/API/person?fName='+val[0]+'&lName='+val[1]+'&email='+val[2],
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
            });

        },
        getHomeInfos:
            $resource('/rest/API/home/', {}, {
                query: { method: 'GET', params: {}, isArray: true }
            }),
        getPersonInfos: function (uri) {
            return $resource(uri, {}, {
                query: { method: 'GET', params: {}, isArray: true }
            })
        },
        getHeaterInfos: function (uri) {
            return $resource(uri, {}, {
                query: { method: 'GET', params: {}, isArray: true }
            })
        }
    }
}]);


jpaApp.controller('jpaForm', ['$scope', '$log', '$http', '$rootScope', 'JpaService', function ($scope, $log, $http, $rootScope, JpaService) {
    $scope.displayPersonInfos = function () {
        $rootScope.$emit("getPerson", {});
    };
    $scope.displayHeaterInfos = function () {
        $rootScope.$emit("getHeater", {});
    };
    $scope.displayHomeInfos = function () {
        $rootScope.$emit("getHome", {});
    };
    $scope.makeHeater = function () {
        $scope.heaterName = $('#name')[0].value;
        $scope.heaterConso = $('#conso')[0].value;
        $scope.heaterHomeId = $('#homeList')[0].value;
        var val = [$scope.heaterName, $scope.heaterConso, $scope.heaterHomeId];
        JpaService.createHeater(val);
    };
    $scope.makePerson = function () {
        $scope.heaterlName = $('#lName')[0].value;
        $scope.heaterfName = $('#fName')[0].value;
        $scope.heaterEmail = $('#email')[0].value;
        var val = [$scope.heaterlName, $scope.heaterfName, $scope.heaterEmail];
        JpaService.createPerson(val);
    };

    JpaService.getHomeInfos.query().$promise.then(function (data) {
        console.log(data);
        $scope.homes = data;
    });

}]);

jpaApp.controller('jpaInfo', ['$scope', '$resource', '$rootScope', 'JpaService', function ($scope, $resource, $rootScope, JpaService) {
    $rootScope.$on("getPerson", function () {
        JpaService.getPersonInfos('/rest/API/person/').query().$promise.then(function (data) {
            $scope.persons = data;
        }, function (reason) {
            alert('Erreur');
        });
    });
    $rootScope.$on("getHeater", function () {
        JpaService.getHeaterInfos('/rest/API/heater/').query().$promise.then(function (data) {
            $scope.heaters = data;
        }, function (reason) {
            alert('Erreur');
        });
    });
}]);