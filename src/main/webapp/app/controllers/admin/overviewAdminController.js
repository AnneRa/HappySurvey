happySurvey.controller('overviewAdminController', ['$scope', '$http' , '$location', function($scope, $http, $location) {

	'use strict';

	window.$scope = $scope;
	$scope.surveys = [];
	
	$scope.updateTable = function(){
		$http.get("http://localhost:8080/HappySurvey/api/v1/umfragen")
		.success( function (data) { 
			$scope.surveys = data;
		})
	};
	
	$scope.updateTable();
	
	$scope.deleteSurvey = function(id){
		$http.delete("http://localhost:8080/HappySurvey/api/v1/umfrage/" + id)
		.success( function (data){
			$scope.surveys = data;
			$scope.updateTable();
		})
	};
	 
	$scope.editSurvey = function(id){

		$location.path('/admin/editSurvey/' + id).replace();
	
	};
	
}]);

