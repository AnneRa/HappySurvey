
happySurvey.controller('overviewGroupsController', ['$scope', '$http' , '$location', '$routeParams', function($scope, $http, $location, $routeParams) {

	'use strict';

	$scope.umf = {};
	
	function loadSurvey(surveyId) {
		
		$http.get("http://localhost:8080/HappySurvey/api/v1/umfrage/" + surveyId)
		.success( function (response) {
			$scope.umf = response;
			console.log(response);
			$scope.umf.startdat = new Date($scope.umf.startdat);
			$scope.umf.enddat = new Date($scope.umf.enddat);
		})
		
	}
	
	function openQuestionOverview(response){
		
		$scope.umf = response;
		$scope.umf.startdat = new Date($scope.umf.startdat);
		$scope.umf.enddat = new Date($scope.umf.enddat);
		$location.path('/admin/' + $scope.umf.id + '/questions')
		
	}
	
	$scope.addGroup = function() {
		
		var newGroup = angular.copy($scope.umf.gruppen[0]);
		newGroup.id = 0;
		newGroup.name = "Neue Gruppe";
		$scope.umf.gruppen.push(newGroup);
		
	}
	
	$scope.saveGroups = function() {
	
		$http.put("http://localhost:8080/HappySurvey/api/v1/umfrage", $scope.umf).success(openQuestionOverview)
		
	}
	
	if ($routeParams.id != undefined) { loadSurvey($routeParams.id) };
	

	$scope.goBackToSurvey = function(id){
		$location.path('/admin/editSurvey/' + $scope.umf.id).replace();
	}
	
}]);

