happySurvey.controller('newSurveyController', ['$scope', '$http' , function($scope, $http) {

	'use strict';

	$scope.title = "";
	$scope.description = "";
	$scope.startDate = new Date();
	var endDate = new Date();
	endDate.setDate($scope.startDate.getDate() + 7);
	$scope.endDate = endDate;

	$scope.createSurveyClicked = function(){

		// TODO implement
	}

}]);
