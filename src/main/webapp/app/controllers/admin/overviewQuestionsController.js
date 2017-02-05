
happySurvey.controller('overviewQuestionsController', ['$scope', '$http' , '$location', '$routeParams', function($scope, $http, $location, $routeParams) {

	'use strict';

	$scope.questions = {};
	$scope.umfId = 0;
	
	$scope.delQuestion = function(questionId) {
		
		$http.delete("http://localhost:8080/HappySurvey/api/v1/del/umfrage/" + $scope.umfId + "/frage/" + questionId)
		.success( function (response) {
			$scope.questions = response;
		})
		
	}

	$scope.modQuestion = function(questionId) {
		
		$location.path('/admin/' + $scope.umfId + '/editQuestion/' + questionId);
		
	}
	
	$scope.decodeType = function(index) {
		
		switch(index) {
		
		case 1:
			return "Lineare Skala";
		
		case 2:
			return "Multiple-Choice";
			
		case 3:
			return "Drop-Down";
			
		case 4:
			return "Textfeld";
		
		}
		
	}
	
	function loadQuestions(surveyId) {
		
		$scope.umfId = surveyId;
		$http.get("http://localhost:8080/HappySurvey/api/v1/get/fragen/" + surveyId)
		.success( function (response) {
			$scope.questions = response;
		})
		
	}
	
	if ($routeParams.id != undefined) { loadQuestions($routeParams.id) };
		
}]);

