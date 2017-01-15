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