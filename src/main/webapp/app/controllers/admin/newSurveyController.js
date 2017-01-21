happySurvey.controller('newSurveyController', ['$scope', '$http', '$location', function($scope, $http, $location) {

	'use strict';

	$scope.title = "";
	$scope.description = "";
	$scope.startDate = new Date();
	var endDate = new Date();
	endDate.setDate($scope.startDate.getDate() + 7);
	$scope.endDate = endDate;
	
	$scope.showError = false;

	$scope.createSurvey = function(){

		$http({
    		method: "POST",
    		url: "/HappySurvey/new/umfrage/{id}",
    		params: {
    			name: $scope.title,
    			beschr: $scope.description,
    			stardat: $scope.startDate,
    			enddat: $scope.endDate
    		}
    	}).then(
    			
    		function success(response) {

    			$location.path('/success').replace();
     			
    		},
    		
    		function error(response) {
    			$scope.showError = true;
    		});
	}

}]);

