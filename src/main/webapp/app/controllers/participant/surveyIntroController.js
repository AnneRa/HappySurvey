
happySurvey.controller('surveyIntroController', ['$scope', '$http' , '$location', '$routeParams', function($scope, $http, $location, $routeParams) {

	'use strict';
	
	$scope.umfrage = [];
	
	$scope.startSurveyConduct = function(){
		$location.path('conductSurvey/' + $routeParams.link).replace();
	};
	
	$scope.showSurvey = function(link){
		$http.get("http://localhost:8080/HappySurvey/api/v1/getUmfrage/" + link)
		.success( function ( response ) { 
			$scope.umfrage = response;
		})
	};
	
	
}]);

