happySurvey.controller('loginController', ['$scope', '$http' , function($scope, $http) {
	
	'use strict';
	
	$scope.email = "";
    $scope.password = "";
    $scope.login = login;
    
    $scope.loginClicked = function(){
    	
    	$http({
    		method: "GET",
    		url: "/signin",
    		params: {
    			email: $scope.email,
    			passwordinput: $scope.password 
    		}
    	}).then(
    			
    		function success(response) {
    			// TODO implement 
    		},
    		
    		function error(response) {
    			// TODO implement
    			console.log(response);
    		});
    }
    
}]);

//(function() {
//  'use strict';
//  angular.module('HSLogin',[])
//        .controller('HSLoginController', HSLoginController);
//
//        function HSLoginController($scope, $filter) {
//          $scope.email = "";
//          $scope.password = "";
//          $scope.login = login;
//        }
//
//        function login() {
//
//        }
//}());
