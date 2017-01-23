
happySurvey.controller('surveyConductController', ['$scope', '$http' , '$location', function($scope, $http, $location) {

	'use strict';

//	window.$scope = $scope;


	$scope.survey = [];
	var str = document.location.href;
	var link = str.split('/').pop();
	
	$scope.getSurvey = function(){
		$http.get("http://localhost:8080/HappySurvey/api/v1/get/umfrage/" +link)
		.success( function (data) { 
			$scope.survey = data;
		})
	};
	
	$scope.getSurvey();
	
}]);

