happySurvey.controller('loginController', ['$scope', '$http', '$cookies' , function($scope, $http, $cookies) {
	
	// Aktiven Nutzer eintragen
	// Sollte aber in app.js noch verifiziert werden
	$cookies.put('currentUser4916', 'Anne')
	
	// Nutzer wieder löschen
	$cookies.remove('currentUser4916')
	
	
	// Alt
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

