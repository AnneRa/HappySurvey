
happySurvey.controller('newSurveyController', ['$scope', '$http', '$location', function($scope, $http, $location) {

	'use strict';

	$scope.umf = {};
	$scope.umf.startdat = new Date();
	$scope.umf.enddat = new Date();
	$scope.umf.enddat.setDate($scope.umf.startdat.getDate() + 7);
	
	$scope.createSurveyClicked = function(){
		$http.post("http://localhost:8080/HappySurvey/api/v1/new/umfrage", $scope.umf)
		.finally( function () { 
			$location.path('/admin/home').replace();		
		})
	};

}]);

