
happySurvey.controller('lineChartCtrl', ['$scope', function($scope){
	 
	 $scope.umf = {};
	 $scope.questions = {};
	 
		
	 
	 $scope.options = {
	            chart: {
	                type: 'discreteBarChart',
	                height: 400,
	                margin : {
	                    top: 100,
	                    right: 100,
	                    bottom: 50,
	                    left: 100
	                },
	                x: function loadResult(surveyId) {
	        			
	        			$http.get("http://localhost:8080/HappySurvey/api/v1/getResults/{umfId}/" + surveyId)
	        			.success( function (response) {
	        				$scope.umf = response;
	        				console.log(response);
	        				$scope.umf.resfra = new Frage($scope.umf.resfra);
	        				$scope.umf.gruppe = new Gruppe($scope.umf.gruppe);
	        			})
	        			
	        		},
	                y: function(d){return d.value;},
	                showValues: false,
	                xAxis: {
	                    axisLabel: 'Alle Befragten'
	                },
	                yAxis: {
	                    axisLabelDistance: -10
	                }
	            }
	        };

	        $scope.data = [
	            {
	                key: "Cumulative Return",
	                values: [
	                    {
	                        "label" : "gruppen" ,
	                        "value" : fragen
	                    } ,
	                    {
	                        "label" : "Sinn" ,
	                        "value" : fragen
	                    } ,
	                    {
	                        "label" : "Gemeinschaft" ,
	                        "value" : fragen
	                    } 
	                ]
	            }
	        ]
	        
}])