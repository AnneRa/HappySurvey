
happySurvey.controller('surveyConductController', ['$scope', '$http' , '$location', '$routeParams', function($scope, $http, $location, $routeParams) {

	'use strict';
	
	$scope.survey = {};
	
	$http.get("api/v1/getUmfrage/" + $routeParams.link)
	.success( function ( response ) { 
		$scope.survey = response;
	})
	
}]);

