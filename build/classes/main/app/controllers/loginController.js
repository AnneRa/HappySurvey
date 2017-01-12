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

