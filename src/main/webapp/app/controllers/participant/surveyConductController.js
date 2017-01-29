
happySurvey.controller('surveyConductController', ['$scope', '$http' , '$location', '$routeParams', function($scope, $http, $location, $routeParams) {

	'use strict';
	
	
	//TODO: später wieder löschen
	$scope.survey = {
			"name":"Beispielumfrage",
			"intro":"Ich würde mich freuen, wenn Sie an der Umfrage teilnehmen",
			"description":"Die ist eine Beispielbeschreibung für die Beispielumfrage"
	};
	
	
	$http.get("api/v1/getUmfrage/" + $routeParams.link)
	.success( function ( response ) { 
		$scope.survey = response;
	})
	
}]);

