happySurvey.controller('overviewAdminController', ['$scope', 'UmfrageRepository', function($scope, UmfrageRepository){
	
	this.umfrage = {titel:'', id:null, start:'', ende:'', link:'' };
	this.umfragen = [];
	
	this.submit = submit;
	this.edit = edit;
	this.remove = remove;
	
	fetchAllSurveys();
	
	function fetchAllSurveys(){
		UmfrageRepository.fetchAllSurveys()
			.then(
				function(d){
					this.umfragen = d;
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