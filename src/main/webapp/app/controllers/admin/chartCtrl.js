
happySurvey.controller('chartCtrl', ['$scope', '$http', function ($scope, $http){
	
	var results;
	
	$http.get("http://localhost:8080/HappySurvey/api/v1/getResults/2")
	.success( function (data) { 
		
		results = data;
		
		$scope.options = {
	            chart: {
	                type: 'pieChart',
	                height: 400,
	                x: function(d){return d.key;},
	                y: function(d){return d.y;},
	                showLabels: false,
	                duration: 500,
	                legend: {
	                    margin: {
	                        top: 5,
	                        right: 35,
	                        bottom: 5,
	                        left: 0
	                    }
	                }
	            }
	        };
		
		$scope.data = [];
		for ( var i = 0; i < results.gruppen[0].fragen[0].predefinedAnswers.length; i++ ) {
			
			$scope.data.push( { key: results.gruppen[0].fragen[0].predefinedAnswers[i].text, y: results.gruppen[0].fragen[0].predefinedAnswers[i].count } );
			
		}
		
	})
	


        
	  
}]);