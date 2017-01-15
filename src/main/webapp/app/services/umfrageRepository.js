happySurvey.factory('UmfrageRepository', ['$http', '$q', function($http, $q){
	
	var factory = {
			fetchAllSurveys: fetchAllSurveys,
			fetchSurvey: fetchSurvey,
			createSurvey: createSurvey,
			updateSurvey: updateSurvey,
			deleteSurvey: deleteSurvey
	}
	
	return factory;
	
	//Please implement this function in backend
	function fetchAllSurveys() {
		var deferred = $q.defer();
		$http.get('http://localhost:8080/HappySurvey/get/umfragen')
			.then(
	            function (response) {
	                deferred.resolve(response.data);
	            },
	            function(errResponse){
	                console.error('Error while fetching surveys');
	                deferred.reject(errResponse);
	            }
            );
		return deferred.promise;
	}
	
	//Please implement this function in backend
	function fetchSurvey(id) {
		var deferred = $q.defer();
		$http.get('http://localhost:8080/HappySurvey/get/umfragen/' + id)
			.then(
	            function (response) {
	                deferred.resolve(response.data);
	            },
	            function(errResponse){
	                console.error('Error while fetching survey' + id);
	                deferred.reject(errResponse);
	            }
            );
		return deferred.promise;
	}
	
	function createSurvey(tst, id) {
		var deferred = $q.defer();
		$http.post('http://localhost:8080/HappySurvey/new/umfrage' + id, tst)
			.then(
	            function (response) {
	                deferred.resolve(response.data);
	            },
	            function(errResponse){
	                console.error('Error while creating user');
	                deferred.reject(errResponse);
	            }
            );
		return deferred.promise;
	}
	
	function updateSurvey(umfrage, id) {
		var deferred = $q.defer();
		$http.post('http://localhost:8080/HappySurvey/update/umfrage' + id, umfrage)
			.then(
	            function (response) {
	                deferred.resolve(response.data);
	            },
	            function(errResponse){
	                console.error('Error while updating surveys');
	                deferred.reject(errResponse);
	            }
            );
		return deferred.promise;
	}
	
	function deleteSurvey(umfrage, id) {
		var deferred = $q.defer();
		$http.delete('http://localhost:8080/HappySurvey/del/umfrage' + id, umfrage)
			.then(
	            function (response) {
	                deferred.resolve(response.data);
	            },
	            function(errResponse){
	                console.error('Error while deleting surveys');
	                deferred.reject(errResponse);
	            }
            );
		return deferred.promise;
	}
	
}]);