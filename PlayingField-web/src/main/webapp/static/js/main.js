var storeApp = angular.module('storeApp',[
    'ngRoute',
    'ngResource']);

var SERVER_URL = "http://localhost:8080/PlayingField-web";

//http://localhost:8383/LaptopStoreClient/index.html#/login

storeApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider
                .when('/index', {
                    templateUrl: 'partials/login.html',
                    controller: 'LoginController'
                })
                .otherwise({redirectTo: '/index'});
    }]);
storeApp.factory('RestService',function($http){
    return{
        getMessage: function(){
            return $http.get(SERVER_URL+"/message.htm");
        }
    };
});
storeApp.controller('LoginController',function($scope,$route,RestService){
    
    $scope.testMessage="";
    
    RestService.getMessage().success(function(data,status){
        if(status == 200){
            console.log("Message:"+ data);
            $scope.testMessage = data;
        }
    }).error(function(data,status){
            console.log("Error Fetching data"+status);
    });
    
});
    
