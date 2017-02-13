happySurvey.controller('overviewAdminController', ['$scope', '$http' , '$location', '$mdToast', function($scope, $http, $location, $mdToast) {

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
		});
		
		$mdToast.show( $mdToast.simple()
			    .textContent('Umfrage wurde gelöscht!')
			    .hideDelay(4000)
		);
	};
	 
	$scope.editSurvey = function(id){

		$location.path('/admin/editSurvey/' + id).replace();
	
	};
	
	$scope.addQuestionToSurvey = function(surveyId) {
		
		$location.path('/admin/' + surveyId + '/questions').replace();
	}
	
	$scope.addGroupToSurvey = function(surveyId) {
		
		$location.path('/admin/' + surveyId + '/groups').replace();
	}
	
}]);

