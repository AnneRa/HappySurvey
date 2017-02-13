
happySurvey.controller('surveyController', ['$scope', '$http', '$location', '$routeParams', '$mdToast', function($scope, $http, $location, $routeParams, $mdToast) {

	'use strict';
	
	$scope.umf = {};
	$scope.editMode = false;
	

	// Ist id nicht verfügbar, wird eine neue Umfrage erstellt
	if ( $routeParams.id != undefined ) {
		
		$scope.editMode = true;
		$http.get("http://localhost:8080/HappySurvey/api/v1/umfrage/" + $routeParams.id)
		.success( function (response){
			$scope.umf = response;
			$scope.umf.startdat = new Date($scope.umf.startdat);
			$scope.umf.enddat = new Date($scope.umf.enddat);
		})
		
	} else {
		
		$scope.umf.startdat = new Date();
		$scope.umf.enddat = new Date();
		$scope.umf.enddat.setDate($scope.umf.startdat.getDate() + 7);
		
	}
	
	function openSurveyOverview(response){
		
		$scope.umf = response;
		$scope.umf.startdat = new Date($scope.umf.startdat);
		$scope.umf.enddat = new Date($scope.umf.enddat);
		$location.path('/admin/' + $scope.umf.id + '/groups')
		
	}
	
	$scope.saveSurvey = function(){

		if ( $scope.editMode ) {

			
			
			if($scope.umf.name && $scope.umf.beschr)
			{
				$http.put("http://localhost:8080/HappySurvey/api/v1/umfrage", $scope.umf).success(openSurveyOverview);
				$mdToast.show( $mdToast.simple()
					    .textContent('Umfrage wurde geändert!')
					    .hideDelay(4000)
				);
			}
			else
			{
				$mdToast.show( $mdToast.simple()
					    .textContent('Bitte füllen Sie alle Pflichtfelder aus!'));
			}

		} else {
			
			if($scope.umf.name && $scope.umf.beschr)
			{
				$http.post("http://localhost:8080/HappySurvey/api/v1/umfrage", $scope.umf).success(openSurveyOverview);
				$mdToast.show( $mdToast.simple()
					    .textContent('Umfrage wurde erstellt!')
					    .hideDelay(4000));
			}
			else
			{
				$mdToast.show( $mdToast.simple()
					    .textContent('Bitte füllen Sie alle Pflichtfelder aus!'));
			}
		}		
	};

}]);

