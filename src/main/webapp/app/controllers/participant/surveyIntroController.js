
happySurvey.controller('surveyIntroController', ['$scope', '$http' , '$location', '$routeParams', function($scope, $http, $location, $routeParams) {

	'use strict';
	
	
	//TODO: später wieder löschen
	/*$scope.survey = {
			"id":"tevztrug6",
			"name":"Beispielumfrage",
			"intro":"Ich würde mich freuen, wenn Sie an der Umfrage teilnehmen",
			"description":"Die ist eine Beispielbeschreibung für die Beispielumfrage",
			"categories": [{
				"id":"sfskfssssssssa",
				"name":"Sinn",
				"questions":[{
					"id":"jsfjpsfij",
					"name":"Frage 1",
					"type":"dropDown",
					"options":["a","b","c"]
				}]
			},{},{}]
	};*/
	
	$scope.startSurveyConduct = function(){
		$location.path('conductSurvey/' + $routeParams.link).replace();
	};
	
	$http.get("api/v1/getUmfrage/" + $routeParams.link)
	.success( function ( response ) { 
		$scope.survey = response;
	})
	
}]);

