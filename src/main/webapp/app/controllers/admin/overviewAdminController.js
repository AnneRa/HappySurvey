
happySurvey.controller('overviewAdminController', ['$scope', '$http' , '$location', function($scope, $http, $location) {

	'use strict';
		
	$scope.surveys = [];
	
	$scope.updateTable = function(){
		$http.get("http://localhost:8080/HappySurvey/api/v1/get/umfragen")
		.success( function (data) { 
			$scope.surveys = data;
		})
	};
	
	$scope.updateTable();
	
	$scope.deleteSurvey = function(id){
		$http.delete("http://localhost:8080/HappySurvey/api/v1/del/umfrage/" + id)
		.success( function (data){
			$scope.surveys = data;
			$scope.updateTable();
		})
	};
	
	//das ist nur ein versuch 
	$scope.editSurvey = function(id){
		$http.get("http://localhost:8080/HappySurvey/api/v1/get/umfrage/" + id)
		.success(function(data){
			$location.path('/editSurvey').replace();
			$scope.survey = data;			
		})
	};
	
}]);

