
happySurvey.controller('surveyIntroController', ['$scope', '$http' , '$location', '$routeParams', function($scope, $http, $location, $routeParams) {

	'use strict';
	
	var maxQuestions = 3;
	var questions = [];
	
	$scope.survey = {};
	$scope.curQuestions = [];
	$scope.participant = {};
	$scope.status = 0;
	$scope.page = -1;
	$scope.action = "";
	$scope.maxPages = 0;

	
	$scope.processInput = function(){
		switch($scope.action) {
			case "start":
			case "FWD":
				if ($scope.page >= $scope.maxPages) { alert('dine') } else { switchPage(1) };
				break;
				
			case "BWD":
				if ($scope.page > 0) { switchPage(-1) };
				break;
		
			case "SEND":
				submitSurvey();
				break;
				
			default:
				alert("Kacke, ein Fehler!");
				break;
		}
	}
	
	function submitSurvey() {
		
		
		console.log( JSON.stringify($scope.participant) );
		
		var ans = {};
		ans.mail = $scope.participant.mail;
		ans.antworten = [];
		
		for ( var prop in $scope.participant ) {
			if ( prop != "mail" ) {
				
				var newObject = {};
				
				if ( $scope.participant[prop] instanceof Object ) {
					newObject = { "multipleChoiceAntworten": [], "frage": { "id": prop } };
					var multiOptions = $scope.participant[prop].multi;
					for ( var multiProp in multiOptions ) {		
						if ( multiOptions[multiProp] == true ) {
							var multiObject = { "frageOption": { "id": Number(multiProp) } };
							newObject.multipleChoiceAntworten.push(multiObject);
						}
					}
				} else {
					newObject = { "wert": $scope.participant[prop], "frage": { "id": prop } };
				}
				ans.antworten.push(newObject);
				
			}
			
			
		}
		
		console.log( JSON.stringify(ans) );
		
		$http.post("http://localhost:8080/HappySurvey/api/v1/setTN", ans)
		.success( function ( res ) { console.log(res);} );
		
		
		
		
	}
	
	function switchPage( direction ){
		$scope.page += direction;
		if ( $scope.page >= $scope.maxPages ) {
			$scope.status = 2;
		} else {
			$scope.curQuestions = $scope.questions.slice( $scope.page * maxQuestions, $scope.page * maxQuestions + maxQuestions );
			$scope.curQuestions[0].newGroup = true;
			$scope.status = 1;
		}
	};

	$http.get("api/v1/getUmfrage/" + $routeParams.link)
	.success( function ( res ) { 
		$scope.survey = res;
		$scope.questions = [];
		for ( var i = 0; i < res.gruppen.length; i++ ) {
			for ( var j = 0; j < res.gruppen[i].fragen.length; j++ ) {
				var entry = res.gruppen[i].fragen[j];
				entry.qi = j + 1;
				entry.gi = i + 1;
				entry.gm = res.gruppen.length;
				entry.qm = res.gruppen[i].fragen.length;
				entry.newGroup = j == 0;
				$scope.questions.push(entry);
			}
		}
		$scope.maxPages = Math.ceil( $scope.questions.length / maxQuestions );
	})
	
}]);

