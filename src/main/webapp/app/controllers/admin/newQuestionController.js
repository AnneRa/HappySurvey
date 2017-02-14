
happySurvey.controller('newQuestionController', ['$scope', '$http', '$location', '$routeParams', function($scope, $http, $location, $routeParams) {

	'use strict';
	
	$scope.frage = {};
	$scope.gruppen = {};
	$scope.groupIndex = 0;
	$scope.umfId = 0;
	$scope.editMode = false;
	
	function loadGroups(surveyId) {
		$scope.umfId = surveyId;
		$http.get("http://localhost:8080/HappySurvey/api/v1/umfrage/" + surveyId)
		.success( function (data) { 
			$scope.gruppen = data.gruppen;
			if ($routeParams.questionId != undefined) { loadQuestion($routeParams.questionId) };
		})
	}
	
	function loadQuestion(questionId) {
		
		$scope.editMode = true;
		$http.get("http://localhost:8080/HappySurvey/api/v1/frage/" + questionId)
		.success( function (data) {
			console.log(data);
			var optionen = angular.copy(data.optionen);
			data.optionen = [];
			for (var i = 0; i < optionen.length; i++) {
				data.optionen.push(optionen[i].text);	
			}
			
			data.type = data.type.toString();
			$scope.onQuestionTypeChanged(data.type);
			$scope.groupIndex = data.groupId.toString();
			
			$scope.frage = data;
			console.log($scope.frage);
		})
		
	}

	if ($routeParams.id != undefined) { loadGroups($routeParams.id) };
	
	$scope.saveQuestion = function() {
		
		if ($scope.frage.optional == undefined) $scope.frage.optional = false;
	
		if ( $scope.editMode ) {
		
			$http.put("http://localhost:8080/HappySurvey/api/v1/fragen/" + $scope.groupIndex , $scope.frage)
			.success(
			function(res){ $location.path('/admin/' + $scope.umfId + '/questions').replace(); }	)
			
		} else {
		
			$http.post("http://localhost:8080/HappySurvey/api/v1/fragen/" + $scope.groupIndex , $scope.frage)
			.success(
			function(res){ $location.path('/admin/' + $scope.umfId + '/questions').replace(); }	)

		}

	}
	
	$scope.componentHandler = function() {
		
	}
	
	$scope.addOptionClicked = function() {
		
		$scope.frage.optionen.push("Auswahl " + ($scope.frage.optionen.length +1));
		 
	}
	
	$scope.removeOptionClicked = function(item) {

		  var index = $scope.frage.optionen.indexOf(item);
		   $scope.frage.optionen.splice(index, 1);
	}
	
	$scope.onQuestionTypeChanged = function(selectedType) {
		
		var noReset = selectedType != undefined;
		var typeSpecificAttributesContainer = document.getElementById('typeSpecificAttributes');
		var linearScaleSpecificAttributesContainer = document.getElementById('linearScaleSpecificAttributesContainer');
		var choiceAttributesContainer = document.getElementById('choiceAttributesContainer');
		var textFieldAttributesContainer = document.getElementById('textFieldAttributesContainer');
		
		typeSpecificAttributesContainer.style.display = 'none';
		linearScaleSpecificAttributesContainer.style.display = 'none';
		choiceAttributesContainer.style.display = 'none';
		textFieldAttributesContainer.style.display = 'none';
		
		var list = document.getElementById('questionType');
		if (selectedType == undefined) { selectedType = list[list.selectedIndex].value };
		
		switch(selectedType){
		
		case "1":
			if (!noReset) { $scope.frage.optionen = ["Linke Seite", "Rechte Seite"] };
			linearScaleSpecificAttributesContainer.style.display = 'block';
			typeSpecificAttributesContainer.style.display = 'block';
			break;
		
		case "2":
		case "3":
			if (!noReset) { $scope.frage.optionen = ["Auswahl 1", "Auswahl 2"] };
			choiceAttributesContainer.style.display = 'block';
			typeSpecificAttributesContainer.style.display = 'block';
			break;
			
		case "4":
			if (!noReset) { $scope.frage.optionen = [] };
			textFieldAttributesContainer.style.display = 'block';
			break;
		
		default:
			break;
		}
	
	}
	
	$scope.goBackToQuestion = function(umfId){
		$location.path('/admin/' + umfId + '/questions').replace();
	}
	
}]);