happySurvey.controller('surveyConductController', ['$scope', '$http', '$cookies', '$location' ,'UmfrageRepository', function($scope, $http, $cookies, $location, UmfrageRepository) {
	
	'use strict';
	
	$scope.surveyTitle = "loading data...";
	$scope.surveyDescription = "loading data...";
	
	//Beispiel-Id für eine Beispiel-Umfrage
	fetchSurvey("jujzfkzizikzk");
	
	
	function fetchSurvey(id){
		UmfrageRepository.fetchSurvey(id)
			.then(
				function(d){
					$scope.umfragen = d;
				},
				function(errResponse){
					console.error('Error while fetching Survey' + id);
				}
			);
	}
	
	
    
}]);