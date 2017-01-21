happySurvey.controller('updateTableCtrl', ['$scope', '$http', '$location', function($scope, $http, $location) {

	'use strict';
	
	$scope.id

	$scope.updateTable = function(){

		$http({
    		method: "GET",
    		url: "/HappySurvey/get/umfragen",
    		params: {
    			id: $scope.id,
    			name: $scope.title,
    			stardat: $scope.startDate,
    			enddat: $scope.endDate
    		}
    	}).then(
    			
    		function success(response) {

    			$location.path('/admin/home').replace();
     			
    		},
    		
    		function error(response) {
    			$scope.showError = true;
    		});
	}

}]);

