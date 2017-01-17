happySurvey.controller('overviewAdminController', ['$scope', '$http' , '$location', function($scope, $http, $location) {

	'use strict';

	
	 //es fehlen get parameter 
		
		//ng-click="updateSurveyClicked(id)"
		
		$scope.umf = {};
		$scope.umf.startdat = new Date();
		$scope.umf.enddat = new Date();
		$scope.umf.enddat.setDate($scope.umf.startdat.getDate() + 7);
		
		$scope.updateSurveyClicked = function(id){
			$http.put("http://localhost:8080/HappySurvey/api/v1/update/umfrage/" +id, $scope.umf)
			.finally( function () { 
				$location.path('/admin/home').replace();		
			})

		}
		
		
		 
		//ng-click= "deleteSurveyClicked(id)"
			$scope.deleteSurveyClicked = function(id){
				$http.delete("http://localhost:8080/HappySurvey/api/v1/del/umfrage/" +id)
				.finally( function () { 
					$location.path('/admin/home').replace();		
				})

			}
}]);


/*
happySurvey.controller('overviewAdminController', ['$scope', 'UmfrageRepository', function($scope, UmfrageRepository){
	
	$scope.umfrage = {titel:'', id:null, start:'', ende:'', link:'' };
	$scope.umfragen = [];
	
	$scope.submit = submit;
	$scope.edit = edit;
	$scope.remove = remove;
	
	fetchAllSurveys();
	
	function fetchAllSurveys(){
		UmfrageRepository.fetchAllSurveys()
			.then(
				function(d){
					$scope.umfragen = d;
				},
				function(errResponse){
					console.error('Error while fetching Surveys');
				}
			);
	}
	
	function updateSurvey(umfrage, id){
		UmfrageRepository.createSurvey(umfrage, id)
			.then(
				fetchAllSurveys,
				function(errResponse){
					console.error('Error while updating Survey');
				}
			);
	}
	
	function deleteSurvey(umfrage, id){
		UmfrageRepository.deleteSurvey(umfrage, id)
			.then(
				fetchAllSurveys,
				function(errResponse){
					console.error('Error while deleting Survey');
				}
			);
	}
	
}]);

*/