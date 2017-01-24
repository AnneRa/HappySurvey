
happySurvey.controller('overviewAdminController', ['$scope', '$http' , '$location', function($scope, $http, $location) {

	'use strict';

	window.$scope = $scope;
	$scope.surveys = [];
	
	$scope.updateTable = function(){
		$http.get("http://localhost:8080/HappySurvey/api/v1/get/umfragen")
		.success( function (data) { 
			$scope.surveys = data;
		})
	};
	
	$scope.updateTable();
	
	$scope.deleteSurvey = function(link){
		$http.delete("http://localhost:8080/HappySurvey/api/v1/del/umfrage/" + link)
		.success( function (data){
			$scope.surveys = data;
			$scope.updateTable();
		})
	};
	
	//das ist nur ein versuch 
	$scope.editSurvey = function(link){
		$http.get("http://localhost:8080/HappySurvey/api/v1/get/umfrage/" + link)
		.success(function(data){
			$location.path('/editSurvey').replace();
			$scope.survey = data;			
		})
	};
	
}]);

