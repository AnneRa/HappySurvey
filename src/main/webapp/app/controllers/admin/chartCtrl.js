happySurvey.controller('chartCtrl', ['$scope', '$http', function ($scope, $http){

	var results;
	
	var pieChart = {
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
					}}}};
	
	var lineChart = {
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
				}}};
	
	

	$http.get("http://localhost:8080/HappySurvey/api/v1/getResults/2")
	.success( function (data) { 

		var tempArray = [];
		
		results = data;
		$scope.data = [];		
		
		// Bei Tortdendiagramm
		$scope.options = pieChart;
		
		// Bei Balkendiagramm
		$scope.options = lineChart;

		for ( var i = 0; i < results.gruppen[0].fragen[0].predefinedAnswers.length; i++ ) {

			// Bei Tortendiagramm
			// $scope.data.push( { key: results.gruppen[0].fragen[0].predefinedAnswers[i].text, y: results.gruppen[0].fragen[0].predefinedAnswers[i].count } );
			
			// Bei Balkendiagramm
			tempArray.push( { label: results.gruppen[0].fragen[0].predefinedAnswers[i].text, value: results.gruppen[0].fragen[0].predefinedAnswers[i].count } );

		}
		
		// Nur bei Balkendiagramm
		$scope.data[0] = { key: "undefinded", values: tempArray };

	});










}]);