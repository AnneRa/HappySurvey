happySurvey.controller('ChartCtrl', ['$scope', function ($scope){
	
	$scope.options = {
            chart: {
                type: 'pieChart',
                height: 500,
                x: function(d){return d.key;},
                y: function(d){return d.y;},
                showLabels: false,
                duration: 500,
                labelThreshold: 0.01,
                labelSunbeamLayout: true,
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

        $scope.data = [
            {
                key: "Glück",
                y: 5
            },
            {
                key: "Sinn",
                y: 2
            },
            {
                key: "Gesellschaft",
                y: 9
            }
    	];
	  
}]);