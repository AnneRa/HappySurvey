 happySurvey.controller('lineChartCtrl', ['$scope', function($scope){
       
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
	                x: function(d){return d.label;},
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
	                        "label" : "Glück" ,
	                        "value" : 50
	                    } ,
	                    {
	                        "label" : "Sinn" ,
	                        "value" : 90
	                    } ,
	                    {
	                        "label" : "Gemeinschaft" ,
	                        "value" : 68
	                    } 
	                ]
	            }
	        ]
}])